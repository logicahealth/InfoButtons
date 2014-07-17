/**
 * -----------------------------------------------------------------------------------
 * (c) 2010-2014 OpenInfobutton Project, Biomedical Informatics, University of Utah
 * Contact: {@code <andrew.iskander@utah.edu>}
 * Biomedical Informatics
 * 421 Wakara Way, Ste 140
 * Salt Lake City, UT 84108-3514
 * Day Phone: 1-801-581-4080
 * -----------------------------------------------------------------------------------
 *
 * @author Andrew Iskander {@code <andrew.iskander@utah.edu>}
 * @version Jun 13, 2014
 */

package org.openinfobutton.service.response;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.hl7.v3.AggregateKnowledgeResponse;
import org.hl7.v3.CategoryType;
import org.hl7.v3.DateTimeType;
import org.hl7.v3.EntryType;
import org.hl7.v3.FeedType;
import org.hl7.v3.IdType;
import org.hl7.v3.LinkType;
import org.hl7.v3.TextType;
import org.openinfobutton.schema.CodeConstants;
import org.openinfobutton.schema.CodeUtility;
import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.schemas.kb.Code;
import org.openinfobutton.schemas.kb.CodedContextElement;
import org.openinfobutton.schemas.kb.Context;
import org.openinfobutton.schemas.kb.KnowledgeResourceProfile;
import org.openinfobutton.schemas.kb.SubTopic;
import org.openinfobutton.schemas.kb.SyntaxOnResource;
import org.openinfobutton.schemas.kb.Context.ContextDefinition;
import org.openinfobutton.schemas.kb.SubTopic.SearchParameter;
import org.openinfobutton.service.matching.RequestResult;
import org.openinfobutton.service.transform.TransformCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResponseGenerator
{

    private KnowledgeRequest request;

    Logger log = Logger.getLogger( ResponseGenerator.class.getName() );

    @Autowired
    TransformCode tc;

    /**
     * Does searching and accordingly creates the feed for each resource profile
     * 
     * @param r the infobutton knowledgeRequest
     * @param results List of results after matching
     * @return AggregateKnowledgeResponse
     * @throws DatatypeConfigurationException
     */
    public final AggregateKnowledgeResponse returnResponse( KnowledgeRequest r, List<RequestResult> results )
        throws DatatypeConfigurationException
    {

        final AggregateKnowledgeResponse knowledgeResponse = new AggregateKnowledgeResponse();
        if ( r.getPerformer().getLanguage().getCode().equals( "" ) )
        {
            knowledgeResponse.setLang( "en" );
        }
        else
        {
            knowledgeResponse.setLang( r.getPerformer().getLanguage().getCode() );
        }
        final int count = results.size();
        FeedType feed;
        request = r;
        for ( int x = 0; x < count; x++ )
        {
            feed = createFeed( results.get( x ) );
            if ( !feed.getEntry().isEmpty() )
            {
                final IdType feedID = new IdType();
                feedID.setValue( "urn:uuid:" + UUID.randomUUID() );
                feed.setId( feedID );
                knowledgeResponse.getFeed().add( feed );
            }
        }
        return knowledgeResponse;
    }

    private FeedType createFeed( RequestResult result )
    {

        final FeedType feed = new FeedType();
        final KnowledgeResourceProfile.Header header = result.getHeader();
        final List<Context> contexts = result.getContexts();
        final TextType title = new TextType();
        final TextType subTitle = new TextType();
        title.setType( "text" );
        subTitle.setType( "text" );
        title.getValue().add( header.getTitle() );
        subTitle.getValue().add( request.getMainSearchCriteria().getCode().getDisplayName() );
        feed.setTitle( title );
        feed.setSubtitle( subTitle );
        feed.setUpdated( getUpdateTime() );
        final int count = contexts.size();
        if ( result.isHl7URLCompliant() && result.isHl7KnowledgeResponseCompliant() )
        {
            FeedType feedFromResource = null;
            for ( int x = 0; x < count; x++ )
            {
                feedFromResource = parseAndCreateEntries( contexts.get( x ), result.getSupportedCodeSystems() );
                feed.getEntry().addAll( feedFromResource.getEntry() );
            }
            /**
             * Only one context in a profile is being checked for adding content into the category tag at the feed
             * level.
             */
            if ( count > 0 )
            {
                feed.getCategory().addAll( feedFromResource.getCategory() );
            }
            return feed;
        }
        else
        {
            String lang = "en";
            if ( count > 0 )
            {
                final ContextDefinition cd = contexts.get( 0 ).getContextDefinition();
                feed.getCategory().addAll( getFeedLevelCategory( cd ) );
                if ( cd.getInformationRecipientLanguage() != null
                    && ( cd.getInformationRecipientLanguage().isMatch() || cd.getInformationRecipientLanguage().isSearch() )
                    && request.getCategoryHashMap().containsKey( CodeConstants.INFORMATION_RECIPIENT_LANGUAGE_KEY ) )
                {
                    lang = request.getInformationRecipient().getLanguage().getCode();
                    feed.setLang( lang );
                }
                else
                {
                    feed.setLang( lang );
                }
            }
            if ( result.isHl7URLCompliant() )
            {
                for ( int x = 0; x < count; x++ )
                {
                    feed.getEntry().addAll( createEntries( contexts.get( x ), result.getSupportedCodeSystems(), lang ) );
                }
            }
            else
            {
                for ( int x = 0; x < count; x++ )
                {
                    feed.getEntry().addAll( createNonHL7CompliantEntries( contexts.get( x ),
                                                                          result.getSupportedCodeSystems(),
                                                                          result.getUrlStyle(), lang ) );
                }
            }
        }
        return feed;
    }

    private boolean checkFieldCategory(CodedContextElement element, String key) {
        
        boolean addCategory = false;
        if (element != null && (element.isMatch() || element.isSearch()) && request.getCategoryHashMap().containsKey(key))
            addCategory = true;
        return addCategory;
    }
    
    private List<CategoryType> getFeedLevelCategory( ContextDefinition cd )
    {

        final List<CategoryType> category = new ArrayList<CategoryType>();
        if ( checkFieldCategory(cd.getPatientGender(), CodeConstants.PATIENT_GENDER_KEY ))
        {
            category.addAll( request.getCategoryHashMap().get( CodeConstants.PATIENT_GENDER_KEY ));
        }
        if ( checkFieldCategory(cd.getPatientAgeGroup(), CodeConstants.PATIENT_AGEGROUP_KEY ))
        {
            category.addAll( request.getCategoryHashMap().get( CodeConstants.PATIENT_AGEGROUP_KEY ));
        }
        if ( checkFieldCategory(cd.getTask(), CodeConstants.TASK_KEY ))
        {
            category.addAll( request.getCategoryHashMap().get( CodeConstants.TASK_KEY ));
        }
        if ( checkFieldCategory(cd.getEncounterType(),CodeConstants.ENCOUNTER_KEY ))
        {
            category.addAll( request.getCategoryHashMap().get( CodeConstants.ENCOUNTER_KEY ) );
        }
        if ( checkFieldCategory(cd.getPerformerLanguage(),CodeConstants.PERFORMER_LANGUAGE_KEY ) )
        {
            category.addAll( request.getCategoryHashMap().get( CodeConstants.PERFORMER_LANGUAGE_KEY ) );
        }
        if ( checkFieldCategory(cd.getPerformerDiscipline(),CodeConstants.PERFORMER_DISCIPLINE_KEY ) )
        {
            category.addAll( request.getCategoryHashMap().get( CodeConstants.PERFORMER_DISCIPLINE_KEY ) );
        }
        if ( checkFieldCategory(cd.getPerformerKnowledgeUserType(),CodeConstants.PERFORMER_KNOWLEDGE_USERTYPE_KEY ) )
        {
            category.addAll( request.getCategoryHashMap().get( CodeConstants.PERFORMER_KNOWLEDGE_USERTYPE_KEY ) );
        }
        if ( checkFieldCategory(cd.getInformationRecipientLanguage(),CodeConstants.INFORMATION_RECIPIENT_LANGUAGE_KEY ) )
        {
            category.addAll( request.getCategoryHashMap().get( CodeConstants.INFORMATION_RECIPIENT_LANGUAGE_KEY ) );
        }
        if ( checkFieldCategory(cd.getInformationRecipientDiscipline(),CodeConstants.INFORMATION_RECIPIENT_DISCIPLINE_KEY ) )
        {
            category.addAll( request.getCategoryHashMap().get( CodeConstants.INFORMATION_RECIPIENT_DISCIPLINE_KEY ) );
        }
        if ( checkFieldCategory(cd.getInformationRecipientUserType(),CodeConstants.INFORMATION_RECIPIENT_USERTYPE_KEY ) )
        {
            category.addAll( request.getCategoryHashMap().get( CodeConstants.INFORMATION_RECIPIENT_USERTYPE_KEY ) );
        }
        if ( checkFieldCategory(cd.getConceptOfInterest(),CodeConstants.CONCEPT_OF_INTEREST_KEY ) )
        {
            category.addAll( request.getCategoryHashMap().get( CodeConstants.CONCEPT_OF_INTEREST_KEY ) );
        }

        return category;
    }

    /**
     * Returns the feed after calling the webservice of the resource
     * 
     * @param context of the profile whose response in HL7 compliant
     * @param supportedCodeSystems to generate the base link
     * @return the entire feed in the form of xml
     */
    private FeedType parseAndCreateEntries( Context context, List<String> supportedCodeSystems )
    {
        FeedType feedType = new FeedType();
        try
        {
            final String urlBase = context.getKnowledgeRequestService().getKnowledgeRequestServiceLocation().getUrl();
            final StringBuilder baseLink =
                generateBaseLink( urlBase, context.getContextDefinition(), supportedCodeSystems, null );
            final DefaultHttpClient httpClient = new DefaultHttpClient();
            final URL url = new URL( baseLink.toString() );
            final URI uri = new URI( url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null );
            final HttpGet getRequest = new HttpGet( uri.toString() );
            getRequest.addHeader( "accept", "application/xml" );
            HttpResponse response;
            response = httpClient.execute( getRequest );
            final HttpEntity entity = response.getEntity();
            final String xmlString = EntityUtils.toString( entity );
            final StringReader xmlReader = new StringReader( xmlString );
            StreamSource xmlSource = new StreamSource( xmlReader );
            StringWriter stringWriter = new StringWriter();
            Result result = new StreamResult( stringWriter );
            final TransformerFactory tfactory = TransformerFactory.newInstance();
            final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream mapInput = classLoader.getResourceAsStream( "removeNamespaces.xsl" );
            Transformer transformer = tfactory.newTransformer( new StreamSource( mapInput ) );
            transformer.transform( xmlSource, result );
            xmlSource = new StreamSource( new StringReader( stringWriter.getBuffer().toString() ) );
            mapInput = classLoader.getResourceAsStream( "convertingCategory.xsl" );
            transformer = tfactory.newTransformer( new StreamSource( mapInput ) );
            stringWriter = new StringWriter();
            result = new StreamResult( stringWriter );
            transformer.transform( xmlSource, result );
            xmlSource = new StreamSource( new StringReader( stringWriter.getBuffer().toString() ) );
            final JAXBContext ctx = JAXBContext.newInstance( FeedType.class );
            final Unmarshaller u = ctx.createUnmarshaller();
            @SuppressWarnings( "rawtypes" )
            final JAXBElement ele = (JAXBElement) u.unmarshal( xmlSource );
            feedType = (FeedType) ele.getValue();
        }
        catch ( final ClientProtocolException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch ( final IOException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch ( final TransformerConfigurationException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch ( final TransformerException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch ( final JAXBException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch ( final URISyntaxException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return feedType;
    }

    private List<EntryType> createEntries( Context context, List<String> supportedCodeSystems, String lang )
    {

        final List<EntryType> entries = new ArrayList<EntryType>();
        final String urlBase = context.getKnowledgeRequestService().getKnowledgeRequestServiceLocation().getUrl();
        final List<CategoryType> entryLevelCategoryList = new ArrayList<CategoryType>();
        final StringBuilder baseLink =
            generateBaseLink( urlBase, context.getContextDefinition(), supportedCodeSystems, entryLevelCategoryList );

        StringBuilder subTopics = new StringBuilder();
        LinkType link;
        EntryType entry;
        final List<Code> codes = new ArrayList<Code>();
        final List<SubTopic> subtopicList = context.getContextDefinition().getSubTopics().getSubTopic();
        for ( int i = 0; i < subtopicList.size(); i++ )
        {
            try
            {
                final Code temp = subtopicList.get( i ).getSearchParameter().getValueSource().getSearchCode().getCode();
                if ( temp != null )
                {
                    link = new LinkType();
                    link.setRel( "alternate" );
                    link.setType( "html" );
                    link.setHreflang( lang );
                    link.setTitle( subtopicList.get( i ).getLinkName() );
                    subTopics = new StringBuilder( baseLink );
                    subTopics.append( CodeConstants.SUBTOPIC_CODE );
                    subTopics.append( "=" );
                    subTopics.append( temp.getCode() );
                    subTopics.append( "&" );
                    subTopics.append( CodeConstants.SUBTOPIC_CODESYSTEM );
                    subTopics.append( "=" );
                    subTopics.append( temp.getCodeSystem() );
                    subTopics.append( "&" );
                    subTopics.append( CodeConstants.SUBTOPIC_DISPLAYNAME );
                    subTopics.append( "=" );
                    subTopics.append( temp.getDisplayName() );
                    link.setHref( subTopics.toString() );
                    entry = new EntryType();
                    entry.setUpdated( getUpdateTime() );
                    entry.setLang( lang );
                    final IdType entryID = new IdType();
                    entryID.setValue( "urn:uuid:" + UUID.randomUUID() );
                    entry.setId( entryID );
                    final TextType title = new TextType();
                    title.setType( "text" );
                    title.getValue().add( subtopicList.get( i ).getLinkName() );
                    entry.getCategory().addAll( entryLevelCategoryList );
                    entry.getCategory().addAll( convertCodeIntoCategory( temp, CodeConstants.SUBTOPIC_CODE,
                                                                         CodeConstants.SUBTOPIC_CODESYSTEM,
                                                                         CodeConstants.SUBTOPIC_DISPLAYNAME ) );
                    entry.getLink().add( link );
                    entry.setTitle( title );
                    entries.add( entry );
                }
            }
            catch ( final NullPointerException e )
            {
                link = new LinkType();
                link.setRel( "alternate" );
                link.setType( "html" );
                link.setHreflang( lang );
                link.setTitle( subtopicList.get( i ).getLinkName() );
                subTopics = new StringBuilder( baseLink );
                link.setHref( subTopics.toString() );
                entry = new EntryType();
                entry.setUpdated( getUpdateTime() );
                entry.setLang( lang );
                final IdType entryID = new IdType();
                entryID.setValue( "urn:uuid:" + UUID.randomUUID() );
                entry.setId( entryID );
                final TextType title = new TextType();
                title.setType( "text" );
                title.getValue().add( subtopicList.get( i ).getLinkName() );
                entry.getLink().add( link );
                entry.setTitle( title );
                entries.add( entry );
            }
        }
        return entries;
    }

    private List<CategoryType> convertCodeIntoCategory( Code code, String codeKey, String codeSystemKey,
                                                        String displayNameKey )
    {
        final List<CategoryType> categoryList = new ArrayList<CategoryType>();
        if ( !code.getCode().equals( "" ) )
        {
            categoryList.add( CodeUtility.convertIntoCategoryType( code.getCode(), codeKey ) );
        }
        if ( !code.getCodeSystem().equals( "" ) )
        {
            categoryList.add( CodeUtility.convertIntoCategoryType( code.getCodeSystem(), codeSystemKey ) );
        }
        if ( !code.getDisplayName().equals( "" ) )
        {
            categoryList.add( CodeUtility.convertIntoCategoryType( code.getDisplayName(), displayNameKey ) );
        }
        return categoryList;
    }

    private List<EntryType> createNonHL7CompliantEntries( Context context, List<String> supportedCodeSystems,
                                                          String urlStyle, String lang )
    {

        final List<EntryType> entries = new ArrayList<EntryType>();
        final String urlBase = context.getKnowledgeRequestService().getKnowledgeRequestServiceLocation().getUrl();
        final StringBuilder str = new StringBuilder( urlBase );
        if ( context.getKnowledgeRequestService().getAttributes() != null )
        {
            final List<Context.KnowledgeRequestService.Attributes.Attribute> parameters =
                context.getKnowledgeRequestService().getAttributes().getAttribute();
            for ( final Context.KnowledgeRequestService.Attributes.Attribute attribute : parameters )
            {
                str.append( attribute.getName() );
                str.append( ( urlStyle.equals( "CLEAN" ) ) ? "/" : "=" );
                str.append( attribute.getValue() );
                str.append( ( urlStyle.equals( "CLEAN" ) ) ? "/" : "&" );
            }
        }
        final StringBuilder baseLink =
            generateNonHL7CompliantBaseLink( str.toString(), context.getContextDefinition(), urlStyle,
                                             supportedCodeSystems );
        StringBuilder subTopics = new StringBuilder();
        LinkType link;
        EntryType entry;
        final List<SubTopic> subtopicList = context.getContextDefinition().getSubTopics().getSubTopic();
        for ( int i = 0; i < subtopicList.size(); i++ )
        {
            link = new LinkType();
            link.setRel( "alternate" );
            link.setType( "html" );
            link.setHreflang( lang );
            link.setTitle( subtopicList.get( i ).getLinkName() );
            final SearchParameter sp = subtopicList.get( i ).getSearchParameter();
            subTopics = new StringBuilder( baseLink );
            String searchTerm = null;
            if ( sp != null )
            {
                if ( sp.getSyntaxOnResource() != null )
                {
                    subTopics.append( sp.getSyntaxOnResource().getNonHl7CompliantName() );
                }
                if ( sp.getValueSource() != null )
                {
                    searchTerm = sp.getValueSource().getSearchTerm();
                }
            }
            if ( searchTerm != null )
            {
                subTopics.append( ( urlStyle.equals( "CLEAN" ) ) ? "/" : "=" );
                subTopics.append( searchTerm );
            }
            link.setHref( subTopics.toString() );
            entry = new EntryType();
            entry.setUpdated( getUpdateTime() );
            entry.setLang( lang );
            final IdType entryID = new IdType();
            entryID.setValue( "urn:uuid:" + UUID.randomUUID() );
            entry.setId( entryID );
            final TextType title = new TextType();
            title.setType( "text" );
            title.getValue().add( subtopicList.get( i ).getLinkName() );
            entry.getLink().add( link );
            entry.setTitle( title );
            entries.add( entry );
        }
        return entries;

    }

    private StringBuilder generateNonHL7CompliantBaseLink( String url, Context.ContextDefinition contextDef,
                                                           String urlStyle, List<String> supportedCodeSystems )
    {

        final StringBuilder str = new StringBuilder( url );
        Code code = CodeUtility.getCode();
        if ( checkContextAndSearchType(contextDef.getTask()))
        {
            code = request.getTaskContext().getCode();
            str.append( returnNonHL7CompliantParameters( code, contextDef.getTask(), urlStyle ) );
        }
        if ( checkContextAndSearchType(contextDef.getPatientAgeGroup()))
        {
            code = request.getPatientContext().getPatient().getAgeGroup();
            str.append( returnNonHL7CompliantParameters( code, contextDef.getPatientAgeGroup(), urlStyle ) );
        }
        if ( checkContextAndSearchType(contextDef.getPatientGender()))
        {
            code = request.getPatientContext().getPatient().getGender();
            str.append( returnNonHL7CompliantParameters( code, contextDef.getPatientGender(), urlStyle ) );
        }
        if ( checkContextAndSearchType(contextDef.getEncounterType()))
        {
            code = request.getEncounter().getCode();
            str.append( returnNonHL7CompliantParameters( code, contextDef.getEncounterType(), urlStyle ) );
        }
        if ( checkContextAndSearchType(contextDef.getPerformerLanguage()))
        {
            code = request.getPerformer().getLanguage();
            str.append( returnNonHL7CompliantParameters( code, contextDef.getPerformerLanguage(), urlStyle ) );
        }
        if ( checkContextAndSearchType(contextDef.getPerformerDiscipline()))
        {
            code = request.getPerformer().getHealthCareProvider();
            str.append( returnNonHL7CompliantParameters( code, contextDef.getPerformerDiscipline(), urlStyle ) );
        }
        if ( checkContextAndSearchType(contextDef.getPerformerKnowledgeUserType()))
        {
            code = request.getPerformer().getProviderOrPatient();
            str.append( returnNonHL7CompliantParameters( code, contextDef.getPerformerKnowledgeUserType(), urlStyle ) );
        }
        if ( checkContextAndSearchType(contextDef.getInformationRecipientLanguage()))
        {
            code = request.getInformationRecipient().getLanguage();
            str.append( returnNonHL7CompliantParameters( code, contextDef.getInformationRecipientLanguage(), urlStyle ) );
        }
        if ( checkContextAndSearchType(contextDef.getInformationRecipientDiscipline()))
        {
            code = request.getInformationRecipient().getHealthCareProvider();
            str.append( returnNonHL7CompliantParameters( code, contextDef.getInformationRecipientDiscipline(), urlStyle ) );
        }
        if ( checkContextAndSearchType(contextDef.getInformationRecipientUserType()))
        {
            code = request.getInformationRecipient().getProviderOrPatient();
            str.append( returnNonHL7CompliantParameters( code, contextDef.getInformationRecipientUserType(), urlStyle ) );
        }
        if ( checkContextAndSearchType(contextDef.getConceptOfInterest()))
        {
            code =
                tc.transformOutput( contextDef.getConceptOfInterest(), request.getMainSearchCriteria().getCode(),
                                    supportedCodeSystems, request );
            str.append( returnNonHL7CompliantParameters( code, contextDef.getConceptOfInterest(), urlStyle ) );
        }
        return str;

    }

    private static String returnNonHL7CompliantParameters( Code code, CodedContextElement context, String urlStyle )
    {

        final StringBuilder str = new StringBuilder();

        final SyntaxOnResource syn = context.getSearchParameter().getSyntaxOnResource();
        String searchParameter;
        if ( context.getSearchParameter().getSource() != null
            && context.getSearchParameter().getSource().equals( "displayName" ) )
        {
            searchParameter = code.getDisplayName();
        }
        else
        {
            searchParameter = code.getCode();
        }
        if ( !searchParameter.isEmpty() )
        {

            if ( syn != null )
            {
                str.append( syn.getNonHl7CompliantName() );
                str.append( ( urlStyle.equals( "CLEAN" ) ) ? "/" : "=" );
                str.append( ( syn.getValuePrefix() != null ) ? syn.getValuePrefix() : "" );
            }
            str.append( searchParameter );
            if ( syn != null )
            {
                str.append( ( syn.getValueSuffix() != null ) ? syn.getValueSuffix() : "" );
            }
            str.append( ( urlStyle.equals( "CLEAN" ) ) ? "/" : "&" );
        }

        return str.toString();

    }
    
    private boolean checkContextAndSearchType (CodedContextElement element) {
        
        boolean addCode = false;
        if (element != null && element.isSearch())
            addCode = true;
        return addCode;
    }

    private StringBuilder generateBaseLink( String url, Context.ContextDefinition contextDef,
                                            List<String> supportedCodeSystems, List<CategoryType> entryLevelCategoryList )
    {

        final StringBuilder str = new StringBuilder( url );
        Code code = CodeUtility.getCode();
        if ( checkContextAndSearchType(contextDef.getTask()))
        {
            code = request.getTaskContext().getCode();
            str.append( returnParameters( code, CodeConstants.TASKCONTEXT_CODE, CodeConstants.TASKCONTEXT_CODESYSTEM,
                                          CodeConstants.TASKCONTEXT_DISPLAYNAME ) );
        }
        if ( checkContextAndSearchType(contextDef.getPatientAgeGroup()))
        {
            code = request.getPatientContext().getPatient().getAgeGroup();
            str.append( returnParameters( code, CodeConstants.AGEGROUP_CODE, CodeConstants.AGEGROUP_CODESYSTEM,
                                          CodeConstants.AGEGROUP_DISPLAYNAME ) );
        }
        if ( checkContextAndSearchType(contextDef.getPatientGender()))
        {
            code = request.getPatientContext().getPatient().getGender();
            str.append( returnParameters( code, CodeConstants.GENDER_CODE, CodeConstants.GENDER_CODESYSTEM,
                                          CodeConstants.GENDER_DISPLAYNAME ) );
        }
        if ( checkContextAndSearchType(contextDef.getEncounterType()))
        {
            code = request.getEncounter().getCode();
            str.append( returnParameters( code, CodeConstants.ENCOUNTER_CODE, CodeConstants.ENCOUNTER_CODESYSTEM,
                                          CodeConstants.ENCOUNTER_DISPLAYNAME ) );
        }
        if ( checkContextAndSearchType(contextDef.getPerformerLanguage()))
        {
            code = request.getPerformer().getLanguage();
            str.append( returnParameters( code, CodeConstants.PERFORMER_LANGUAGECODE,
                                          CodeConstants.PERFORMER_LANGUAGECODESYSTEM,
                                          CodeConstants.PERFORMER_LANGUAGEDISPLAYNAME ) );
        }
        if ( checkContextAndSearchType(contextDef.getPerformerDiscipline()))
        {
            code = request.getPerformer().getHealthCareProvider();
            str.append( returnParameters( code, CodeConstants.PERFORMER_CODE, CodeConstants.PERFORMER_CODESYSTEM,
                                          CodeConstants.PERFORMER_DISPLAYNAME ) );
        }
        if ( checkContextAndSearchType(contextDef.getPerformerKnowledgeUserType()))
        {
            code = CodeUtility.getCode( request.getPerformer().getProviderOrPatient().getCode(), "", "", "" );
            str.append( returnParameters( code, CodeConstants.PERFORMER, "", "" ) );
        }
        if ( checkContextAndSearchType(contextDef.getInformationRecipientLanguage()))
        {
            code = request.getInformationRecipient().getLanguage();
            str.append( returnParameters( code, CodeConstants.INFORMATIONRECIPIENT_LANGUAGECODE,
                                          CodeConstants.INFORMATIONRECIPIENT_LANGUAGECODESYSTEM,
                                          CodeConstants.INFORMATIONRECIPIENT_LANGUAGEDISPLAYNAME ) );
        }
        if ( checkContextAndSearchType(contextDef.getInformationRecipientDiscipline()))
        {
            code = request.getInformationRecipient().getHealthCareProvider();
            str.append( returnParameters( code, CodeConstants.INFORMATIONRECIPIENT_CODE,
                                          CodeConstants.INFORMATIONRECIPIENT_CODESYSTEM,
                                          CodeConstants.INFORMATIONRECIPIENT_DISPLAYNAME ) );
        }
        if ( checkContextAndSearchType(contextDef.getInformationRecipientUserType()))
        {
            code = CodeUtility.getCode( request.getInformationRecipient().getProviderOrPatient().getCode(), "", "", "" );
            str.append( returnParameters( code, CodeConstants.INFORMATIONRECIPIENT, "", "" ) );
        }
        if ( checkContextAndSearchType(contextDef.getConceptOfInterest()))
        {
            code =
                tc.transformOutput( contextDef.getConceptOfInterest(), request.getMainSearchCriteria().getCode(),
                                    supportedCodeSystems, request );
            str.append( returnParameters( code, CodeConstants.MAINSEARCH_CODE, CodeConstants.MAINSEARCH_CODESYSTEM,
                                          CodeConstants.MAINSEARCH_DISPLAYNAME ) );
            if ( ( entryLevelCategoryList != null )
                && ( request.getMainSearchCriteria().getCode().getCode().equals( "" ) ) )
            {
                entryLevelCategoryList.addAll( convertCodeIntoCategory( code, CodeConstants.MAINSEARCH_CODE,
                                                                        CodeConstants.MAINSEARCH_CODESYSTEM,
                                                                        CodeConstants.MAINSEARCH_DISPLAYNAME ) );
            }
        }
        return str;
    }

    private static String returnParameters( Code code, String codeKey, String codeSystemKey, String displayNameKey )
    {

        final StringBuilder str = new StringBuilder();
        if ( !code.getCode().isEmpty() )
        {
            str.append( codeKey );
            str.append( "=" );
            str.append( code.getCode() );
            str.append( "&" );
            if ( !code.getCodeSystem().isEmpty() )
            {
                str.append( codeSystemKey );
                str.append( "=" );
                str.append( code.getCodeSystem() );
                str.append( "&" );
            }
        }
        if ( !code.getDisplayName().isEmpty() )
        {

            str.append( displayNameKey );
            str.append( "=" );
            str.append( code.getDisplayName() );
            str.append( "&" );
        }

        return str.toString();
    }

    private DateTimeType getUpdateTime()
    {
        try
        {
            final GregorianCalendar gcal = new GregorianCalendar();
            gcal.setTime( Calendar.getInstance().getTime() );
            XMLGregorianCalendar xmlTime;
            xmlTime = DatatypeFactory.newInstance().newXMLGregorianCalendar( gcal );
            final DateTimeType updated = new DateTimeType();
            updated.setValue( xmlTime );
            return updated;
        }
        catch ( final DatatypeConfigurationException e )
        {
            e.printStackTrace();
        }
        return null;
    }
}

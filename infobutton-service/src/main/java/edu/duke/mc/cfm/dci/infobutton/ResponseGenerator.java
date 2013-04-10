
package edu.duke.mc.cfm.dci.infobutton;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.duke.mc.cfm.dci.infobutton.schemas.kb.Code;
import edu.duke.mc.cfm.dci.infobutton.schemas.kb.CodedContextElement;
import edu.duke.mc.cfm.dci.infobutton.schemas.kb.Context;
import edu.duke.mc.cfm.dci.infobutton.schemas.kb.Context.ContextDefinition;
import edu.duke.mc.cfm.dci.infobutton.schemas.kb.KnowledgeResourceProfile;
import edu.duke.mc.cfm.dci.infobutton.schemas.kb.SubTopic;
import edu.duke.mc.cfm.dci.infobutton.schemas.kb.SubTopic.SearchParameter;
import edu.duke.mc.cfm.dci.infobutton.schemas.kb.SyntaxOnResource;


@Component
public class ResponseGenerator {
	
	private KnowledgeRequest request;
	Logger log = Logger.getLogger(ResponseGenerator.class.getName());
	@Autowired
	TransformCode tc;
	/**
	 * Does searching and accordingly creates the feed for each resource profile 
	 * @param r the infobutton knowledgeRequest
	 * @param results List of results after matching
	 * @return AggregateKnowledgeResponse
	 * @throws DatatypeConfigurationException
	 */
	public  AggregateKnowledgeResponse returnResponse(KnowledgeRequest r, List<RequestResult> results) throws DatatypeConfigurationException {

		AggregateKnowledgeResponse knowledgeResponse = new AggregateKnowledgeResponse();
		if(r.getPerformer().getLanguage().getCode().equals(""))
			knowledgeResponse.setLang("en");
		else
			knowledgeResponse.setLang(r.getPerformer().getLanguage().getCode());
		int count = results.size();
		FeedType feed;
		request = r;
		for (int x = 0; x < count; x++) {
			feed = createFeed(results.get(x));
			if (!feed.getEntry().isEmpty()) 
			{
				IdType feedID = new IdType();
				feedID.setValue("urn:uuid:"+UUID.randomUUID());
				feed.setId(feedID);
				knowledgeResponse.getFeed().add(feed);
			}
		}
		return knowledgeResponse;
	}
	
	private  FeedType createFeed(RequestResult result){
		
		FeedType feed = new FeedType();
		KnowledgeResourceProfile.Header header = result.getHeader();
		List<Context> contexts = result.getContexts();
		TextType title = new TextType();
		TextType subTitle = new TextType();
		title.setType("text");
		subTitle.setType("text");
		title.getValue().add(header.getTitle());
		subTitle.getValue().add(request.getMainSearchCriteria().getCode().getDisplayName());
		feed.setTitle(title);
		feed.setSubtitle(subTitle);
	 	feed.setUpdated(getUpdateTime());
		int count = contexts.size();
		if(result.isHl7URLCompliant()&&result.isHl7KnowledgeResponseCompliant()){
				FeedType feedFromResource = null;
				for (int x = 0; x < count; x++){
					feedFromResource = parseAndCreateEntries(contexts.get(x),result.getSupportedCodeSystems());
					feed.getEntry().addAll(feedFromResource.getEntry());
				}
				/**
				 * Only one context in a profile is being checked for adding content into the category tag at the feed level.
				 */
				if(count>0)
					feed.getCategory().addAll(feedFromResource.getCategory());
				return feed;
		}
		else{
			String lang="en";
			if(count>0)
			{
				ContextDefinition cd = contexts.get(0).getContextDefinition();
				feed.getCategory().addAll(getFeedLevelCategory(cd));
				if(cd.getInformationRecipientLanguage()!=null&&(cd.getInformationRecipientLanguage().isMatch()||cd.getInformationRecipientLanguage().isSearch())&&
						request.getCategoryHashMap().containsKey(CodeConstants.INFORMATION_RECIPIENT_LANGUAGE_KEY))
				{
					lang=request.getInformationRecipient().getLanguage().getCode();
					feed.setLang(lang);
				}
				else
					feed.setLang(lang);
			}
			if(result.isHl7URLCompliant())
			{
				for (int x = 0; x < count; x++)
					feed.getEntry().addAll(createEntries(contexts.get(x),result.getSupportedCodeSystems(),lang));
			}
			else
			{
				for (int x = 0; x < count; x++)
				feed.getEntry().addAll(createNonHL7CompliantEntries(contexts.get(x),result.getSupportedCodeSystems(),result.getUrlStyle(),lang));
			}
		}
		return feed;
	}
	
	private List<CategoryType> getFeedLevelCategory(ContextDefinition cd) {
		
		List<CategoryType> category = new ArrayList<CategoryType>();
		if(cd.getPatientGender()!=null&&(cd.getPatientGender().isMatch()||cd.getPatientGender().isSearch()) &&
				request.getCategoryHashMap().containsKey(CodeConstants.PATIENT_GENDER_KEY))
			category.addAll(request.getCategoryHashMap().get(CodeConstants.PATIENT_GENDER_KEY));
		if(cd.getPatientAgeGroup()!=null&&(cd.getPatientAgeGroup().isMatch()||cd.getPatientAgeGroup().isSearch()) &&
				request.getCategoryHashMap().containsKey(CodeConstants.PATIENT_AGEGROUP_KEY))
			category.addAll(request.getCategoryHashMap().get(CodeConstants.PATIENT_AGEGROUP_KEY));
		if(cd.getTask()!=null&&(cd.getTask().isMatch()||cd.getTask().isSearch()) &&
				request.getCategoryHashMap().containsKey(CodeConstants.TASK_KEY))
			category.addAll(request.getCategoryHashMap().get(CodeConstants.TASK_KEY));
		if(cd.getEncounterType()!=null&&(cd.getEncounterType().isMatch()||cd.getEncounterType().isSearch()) &&
				request.getCategoryHashMap().containsKey(CodeConstants.ENCOUNTER_KEY))
			category.addAll(request.getCategoryHashMap().get(CodeConstants.ENCOUNTER_KEY));
		if(cd.getPerformerLanguage()!=null&&(cd.getPerformerLanguage().isMatch()||cd.getPerformerLanguage().isSearch()) &&
				request.getCategoryHashMap().containsKey(CodeConstants.PERFORMER_LANGUAGE_KEY))
			category.addAll(request.getCategoryHashMap().get(CodeConstants.PERFORMER_LANGUAGE_KEY));
		if(cd.getPerformerDiscipline()!=null&&(cd.getPerformerDiscipline().isMatch()||cd.getPerformerDiscipline().isSearch()) &&
				request.getCategoryHashMap().containsKey(CodeConstants.PERFORMER_DISCIPLINE_KEY))
			category.addAll(request.getCategoryHashMap().get(CodeConstants.PERFORMER_DISCIPLINE_KEY));
		if(cd.getPerformerKnowledgeUserType()!=null&&(cd.getPerformerKnowledgeUserType().isMatch()||cd.getPerformerKnowledgeUserType().isSearch()) &&
				request.getCategoryHashMap().containsKey(CodeConstants.PERFORMER_KNOWLEDGE_USERTYPE_KEY))
			category.addAll(request.getCategoryHashMap().get(CodeConstants.PERFORMER_KNOWLEDGE_USERTYPE_KEY));
		if(cd.getInformationRecipientLanguage()!=null&&(cd.getInformationRecipientLanguage().isMatch()||cd.getInformationRecipientLanguage().isSearch()) &&
				request.getCategoryHashMap().containsKey(CodeConstants.INFORMATION_RECIPIENT_LANGUAGE_KEY))
			category.addAll(request.getCategoryHashMap().get(CodeConstants.INFORMATION_RECIPIENT_LANGUAGE_KEY));
		if(cd.getInformationRecipientDiscipline()!=null&&(cd.getInformationRecipientDiscipline().isMatch()||cd.getInformationRecipientDiscipline().isSearch()) &&
				request.getCategoryHashMap().containsKey(CodeConstants.INFORMATION_RECIPIENT_DISCIPLINE_KEY))
			category.addAll(request.getCategoryHashMap().get(CodeConstants.INFORMATION_RECIPIENT_DISCIPLINE_KEY));
		if(cd.getInformationRecipientUserType()!=null&&(cd.getInformationRecipientUserType().isMatch()||cd.getInformationRecipientUserType().isSearch()) &&
				request.getCategoryHashMap().containsKey(CodeConstants.INFORMATION_RECIPIENT_USERTYPE_KEY))
			category.addAll(request.getCategoryHashMap().get(CodeConstants.INFORMATION_RECIPIENT_USERTYPE_KEY));
		if(cd.getConceptOfInterest()!=null&&(cd.getConceptOfInterest().isMatch()||cd.getConceptOfInterest().isSearch()) &&
				request.getCategoryHashMap().containsKey(CodeConstants.CONCEPT_OF_INTEREST_KEY))
			category.addAll(request.getCategoryHashMap().get(CodeConstants.CONCEPT_OF_INTEREST_KEY));
		
		return category;
	}

	/**
 	 * Returns the feed after calling the webservice of the resource
	 * @param context of the profile whose response in HL7 compliant
	 * @param supportedCodeSystems to generate the base link
	 * @return the entire feed in the form of xml
	 */
	private FeedType parseAndCreateEntries(Context context, List<String> supportedCodeSystems) {
		FeedType feedType = new FeedType();
		try {
			String urlBase = context.getKnowledgeRequestService().getKnowledgeRequestServiceLocation().getUrl();
			StringBuilder baseLink = generateBaseLink(urlBase, context.getContextDefinition(),supportedCodeSystems, null);
			DefaultHttpClient httpClient = new DefaultHttpClient();
			URL url = new URL(baseLink.toString());
			URI uri = new URI(url.getProtocol(),url.getHost(), url.getPath(), url.getQuery(), null);
			HttpGet getRequest = new HttpGet(uri.toString());
			getRequest.addHeader("accept", "application/xml");
			HttpResponse response;
			response = httpClient.execute(getRequest);
			HttpEntity entity = response.getEntity();
			String xmlString = EntityUtils.toString(entity);
			StringReader xmlReader = new StringReader(xmlString);
			StreamSource xmlSource = new StreamSource(xmlReader);
			StringWriter stringWriter = new StringWriter();
			Result result = new StreamResult(stringWriter);
			TransformerFactory tfactory = TransformerFactory.newInstance();
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream mapInput = classLoader.getResourceAsStream("/removeNamespaces.xsl");
			Transformer transformer = tfactory.newTransformer(new StreamSource(mapInput));
			transformer.transform(xmlSource, result);
			xmlSource = new StreamSource(new StringReader(stringWriter.getBuffer().toString()));
			mapInput = classLoader.getResourceAsStream("/convertingCategory.xsl");
			transformer = tfactory.newTransformer(new StreamSource(mapInput));
			stringWriter=new StringWriter();
			result = new StreamResult(stringWriter);
			transformer.transform(xmlSource, result);
			xmlSource = new StreamSource(new StringReader(stringWriter.getBuffer().toString()));
			JAXBContext ctx = JAXBContext.newInstance(FeedType.class);
			Unmarshaller u = ctx.createUnmarshaller();
			@SuppressWarnings("rawtypes")
			JAXBElement ele = (JAXBElement) u.unmarshal(xmlSource);
			feedType = (FeedType) ele.getValue();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return feedType;
	}
	
	private  List<EntryType> createEntries (Context context,List<String> supportedCodeSystems, String lang) {
		
		List<EntryType> entries = new ArrayList<EntryType>();
		String urlBase = context.getKnowledgeRequestService().getKnowledgeRequestServiceLocation().getUrl();
		List<CategoryType> entryLevelCategoryList = new ArrayList<CategoryType>();
		StringBuilder baseLink = generateBaseLink(urlBase, context.getContextDefinition(),supportedCodeSystems,entryLevelCategoryList);
		
		StringBuilder subTopics = new StringBuilder();
		LinkType link;
		EntryType entry;
		List<Code> codes = new ArrayList<Code>();
		List<SubTopic> subtopicList = context.getContextDefinition().getSubTopics().getSubTopic();
		for(int i=0;i<subtopicList.size();i++)
		{ 
			try{
			Code temp = subtopicList.get(i).getSearchParameter().getValueSource().getSearchCode().getCode();
			if(temp!=null)
				codes.add(temp);
			}catch(NullPointerException e)
			{
				link = new LinkType();
				link.setRel("alternate");
				link.setType("html");
				link.setHreflang(lang);
				link.setTitle(subtopicList.get(i).getLinkName());
				subTopics = new StringBuilder(baseLink);
				link.setHref(subTopics.toString());
				entry = new EntryType();
				entry.setUpdated(getUpdateTime());
				entry.setLang(lang);
				IdType entryID = new IdType();
				entryID.setValue("urn:uuid:"+UUID.randomUUID());
				entry.setId(entryID);
				TextType title = new TextType();
				title.setType("text");
				title.getValue().add(subtopicList.get(i).getLinkName());
				entry.getLink().add(link);
				entry.setTitle(title);
				entries.add(entry);
			}
		}
		
		for (Code contextCode : codes) {
			link = new LinkType();
			link.setRel("alternate");
			link.setType("html");
			link.setHreflang(lang);
			link.setTitle(contextCode.getDisplayName());
			subTopics = new StringBuilder(baseLink);
			subTopics.append(CodeConstants.SUBTOPIC_CODE);
			subTopics.append("=");
			subTopics.append(contextCode.getCode());
			subTopics.append("&");
			subTopics.append(CodeConstants.SUBTOPIC_CODESYSTEM);
			subTopics.append("=");
			subTopics.append(contextCode.getCodeSystem());
			subTopics.append("&");
			subTopics.append(CodeConstants.SUBTOPIC_DISPLAYNAME);
			subTopics.append("=");
			subTopics.append(contextCode.getDisplayName());
			link.setHref(subTopics.toString());
			entry = new EntryType();
			entry.setUpdated(getUpdateTime());
			entry.setLang(lang);
			IdType entryID = new IdType();
			entryID.setValue("urn:uuid:"+UUID.randomUUID());
			entry.setId(entryID);
			TextType title = new TextType();
			title.setType("text");
			title.getValue().add(contextCode.getDisplayName());
			entry.getCategory().addAll(entryLevelCategoryList);
			entry.getCategory().addAll(convertCodeIntoCategory(contextCode,CodeConstants.SUBTOPIC_CODE,
					CodeConstants.SUBTOPIC_CODESYSTEM,CodeConstants.SUBTOPIC_DISPLAYNAME));
			entry.getLink().add(link);
			entry.setTitle(title);
			entries.add(entry);
		}
		return entries;
	}
	
	private List<CategoryType> convertCodeIntoCategory(Code code,String codeKey, String codeSystemKey, String displayNameKey) {
		List<CategoryType> categoryList = new ArrayList<CategoryType>();
		if(!code.getCode().equals(""))
			categoryList.add(CodeUtility.convertIntoCategoryType(code.getCode(),codeKey));
		if(!code.getCodeSystem().equals(""))
			categoryList.add(CodeUtility.convertIntoCategoryType(code.getCodeSystem(),codeSystemKey));
		if(!code.getDisplayName().equals(""))
			categoryList.add(CodeUtility.convertIntoCategoryType(code.getDisplayName(),displayNameKey));
		return categoryList;
	}

	private  List <EntryType> createNonHL7CompliantEntries (Context context, List<String> supportedCodeSystems, String urlStyle, String lang) {
		
		List<EntryType> entries = new ArrayList<EntryType>();
		String urlBase = context.getKnowledgeRequestService().getKnowledgeRequestServiceLocation().getUrl();
		StringBuilder str = new StringBuilder(urlBase);
		if (context.getKnowledgeRequestService().getAttributes() != null) {
			List<Context.KnowledgeRequestService.Attributes.Attribute> parameters = context.getKnowledgeRequestService().getAttributes().getAttribute();
			for (Context.KnowledgeRequestService.Attributes.Attribute attribute : parameters) {
				str.append(attribute.getName());
				str.append((urlStyle.equals("CLEAN")) ? "/" : "=");
				str.append(attribute.getValue());
				str.append((urlStyle.equals("CLEAN")) ? "/" : "&");
			}
		}
		StringBuilder baseLink = generateNonHL7CompliantBaseLink(str.toString(), context.getContextDefinition(), urlStyle, supportedCodeSystems);
		StringBuilder subTopics = new StringBuilder();
		LinkType link;
		EntryType entry;
		List<SubTopic> subtopicList = context.getContextDefinition().getSubTopics().getSubTopic();
		for(int i=0;i<subtopicList.size();i++)
		{
			link = new LinkType();
			link.setRel("alternate");
			link.setType("html");
			link.setHreflang(lang);
			link.setTitle(subtopicList.get(i).getLinkName());
			SearchParameter sp = subtopicList.get(i).getSearchParameter();
			subTopics = new StringBuilder(baseLink);
			String searchTerm =null;
			if (sp!=null) {
				if(sp.getSyntaxOnResource() != null)
					subTopics.append(sp.getSyntaxOnResource().getNonHl7CompliantName());
				if(sp.getValueSource()!=null)
					searchTerm=sp.getValueSource().getSearchTerm();
			}
			if(searchTerm!=null)
			{
				subTopics.append((urlStyle.equals("CLEAN")) ? "/" : "=");
				subTopics.append(searchTerm);
			}
			link.setHref(subTopics.toString());
			entry = new EntryType();
			entry.setUpdated(getUpdateTime());
			entry.setLang(lang);
			IdType entryID = new IdType();
			entryID.setValue("urn:uuid:"+UUID.randomUUID());
			entry.setId(entryID);
			TextType title = new TextType();
			title.setType("text");
			title.getValue().add(subtopicList.get(i).getLinkName());
			entry.getLink().add(link);
			entry.setTitle(title);
			entries.add(entry);
		}
		return entries;
		
	}
	
	private  StringBuilder generateNonHL7CompliantBaseLink (String url, Context.ContextDefinition contextDef, String urlStyle,List<String> supportedCodeSystems) {
		
		StringBuilder str = new StringBuilder(url);
		Code code = CodeUtility.getCode();;
		
		if (contextDef.getTask() != null && contextDef.getTask().isSearch()) {
			code =request.getTaskContext().getCode();
			str.append(returnNonHL7CompliantParameters(code, contextDef.getTask(), urlStyle));
		}
		if (contextDef.getPatientAgeGroup() != null && contextDef.getPatientAgeGroup().isSearch()) {
			code = request.getPatientContext().getPatient().getAgeGroup();
			str.append(returnNonHL7CompliantParameters(code, contextDef.getPatientAgeGroup(), urlStyle));
		}
		if (contextDef.getPatientGender() != null && contextDef.getPatientGender().isSearch()) {
			code = request.getPatientContext().getPatient().getGender();
			str.append(returnNonHL7CompliantParameters(code, contextDef.getPatientGender(), urlStyle));
		}
		if (contextDef.getEncounterType() != null && contextDef.getEncounterType().isSearch()) {
			code = request.getEncounter().getCode();
			str.append(returnNonHL7CompliantParameters(code, contextDef.getEncounterType(), urlStyle));
		}
		if (contextDef.getPerformerLanguage() != null && contextDef.getPerformerLanguage().isSearch()) {
			code = request.getPerformer().getLanguage();
			str.append(returnNonHL7CompliantParameters(code, contextDef.getPerformerLanguage(), urlStyle));
		}
		if (contextDef.getPerformerDiscipline() != null && contextDef.getPerformerDiscipline().isSearch()) {
			code =request.getPerformer().getHealthCareProvider();
			str.append(returnNonHL7CompliantParameters(code, contextDef.getPerformerDiscipline(), urlStyle));
		}
		if (contextDef.getPerformerKnowledgeUserType() != null && contextDef.getPerformerKnowledgeUserType().isSearch()) {
			code = request.getPerformer().getProviderOrPatient();
			str.append(returnNonHL7CompliantParameters(code, contextDef.getPerformerKnowledgeUserType(), urlStyle));
		}
		if (contextDef.getInformationRecipientLanguage() != null && contextDef.getInformationRecipientLanguage().isSearch()) {
			code = request.getInformationRecipient().getLanguage();
			str.append(returnNonHL7CompliantParameters(code, contextDef.getInformationRecipientLanguage(), urlStyle));
		}
		if (contextDef.getInformationRecipientDiscipline() != null && contextDef.getInformationRecipientDiscipline().isSearch()) {
			code = request.getInformationRecipient().getHealthCareProvider();
			str.append(returnNonHL7CompliantParameters(code, contextDef.getInformationRecipientDiscipline(), urlStyle));
		}
		if (contextDef.getInformationRecipientUserType() != null && contextDef.getInformationRecipientUserType().isSearch()) {
			code = request.getInformationRecipient().getProviderOrPatient();
			str.append(returnNonHL7CompliantParameters(code, contextDef.getInformationRecipientUserType(), urlStyle));
		}
		if (contextDef.getConceptOfInterest() != null && contextDef.getConceptOfInterest().isSearch()) {
			code = tc.transformOutput(contextDef.getConceptOfInterest(), request.getMainSearchCriteria().getCode(), supportedCodeSystems, request);
			str.append(returnNonHL7CompliantParameters(code,contextDef.getConceptOfInterest(),urlStyle));
		}
		return str;
		
	}
	
	private static String returnNonHL7CompliantParameters (Code code, CodedContextElement context, String urlStyle) {
		
		StringBuilder str = new StringBuilder();
		
		SyntaxOnResource syn = context.getSearchParameter().getSyntaxOnResource();
		String searchParameter;
		if (context.getSearchParameter().getSource() != null && context.getSearchParameter().getSource().equals("displayName")) {
			searchParameter = code.getDisplayName();
		} else {
			searchParameter = code.getCode();
		}
		if (!searchParameter.isEmpty()) {
			
			if (syn != null) {
				str.append(syn.getNonHl7CompliantName());
				str.append((urlStyle.equals("CLEAN")) ? "/" : "=");
				str.append((syn.getValuePrefix() != null) ? syn.getValuePrefix() : "");
			}
			str.append(searchParameter);
			if (syn != null) {
				str.append((syn.getValueSuffix() != null) ? syn.getValueSuffix() : "");
			}
			str.append((urlStyle.equals("CLEAN")) ? "/" : "&");
		}
		
		return str.toString();
		
	}
	
	private  StringBuilder generateBaseLink(String url, Context.ContextDefinition contextDef,List<String> supportedCodeSystems, List<CategoryType> entryLevelCategoryList) {

		StringBuilder str = new StringBuilder(url);
		Code code = CodeUtility.getCode();;
	
		if (contextDef.getTask() != null && contextDef.getTask().isSearch()) {
			code = request.getTaskContext().getCode();
			str.append(returnParameters(code, CodeConstants.TASKCONTEXT_CODE, 
					CodeConstants.TASKCONTEXT_CODESYSTEM, CodeConstants.TASKCONTEXT_DISPLAYNAME));
		}
		if (contextDef.getPatientAgeGroup() != null && contextDef.getPatientAgeGroup().isSearch()) {
			code = request.getPatientContext().getPatient().getAgeGroup();
			str.append(returnParameters(code, CodeConstants.AGEGROUP_CODE, 
					CodeConstants.AGEGROUP_CODESYSTEM, CodeConstants.AGEGROUP_DISPLAYNAME));
		}
		if (contextDef.getPatientGender() != null && contextDef.getPatientGender().isSearch()) {
			code = request.getPatientContext().getPatient().getGender();
			str.append(returnParameters(code, CodeConstants.GENDER_CODE, 
					CodeConstants.GENDER_CODESYSTEM, CodeConstants.GENDER_DISPLAYNAME));
		}
		if (contextDef.getEncounterType() != null && contextDef.getEncounterType().isSearch()) {
			code = request.getEncounter().getCode();
			str.append(returnParameters(code, CodeConstants.ENCOUNTER_CODE, 
					CodeConstants.ENCOUNTER_CODESYSTEM, CodeConstants.ENCOUNTER_DISPLAYNAME));
		}
		if (contextDef.getPerformerLanguage() != null && contextDef.getPerformerLanguage().isSearch()) {
			code = request.getPerformer().getLanguage();
			str.append(returnParameters(code, CodeConstants.PERFORMER_LANGUAGECODE, 
					CodeConstants.PERFORMER_LANGUAGECODESYSTEM, CodeConstants.PERFORMER_LANGUAGEDISPLAYNAME));
		}
		if (contextDef.getPerformerDiscipline() != null && contextDef.getPerformerDiscipline().isSearch()) {
			code = request.getPerformer().getHealthCareProvider();
			str.append(returnParameters(code, CodeConstants.PERFORMER_CODE, 
					CodeConstants.PERFORMER_CODESYSTEM, CodeConstants.PERFORMER_DISPLAYNAME));
		}
		if (contextDef.getPerformerKnowledgeUserType() != null && contextDef.getPerformerKnowledgeUserType().isSearch()) {
			code = CodeUtility.getCode(request.getPerformer().getProviderOrPatient().getCode(), "", "", "");
			str.append(returnParameters(code, CodeConstants.PERFORMER, "", ""));
		}
		if (contextDef.getInformationRecipientLanguage() != null && contextDef.getInformationRecipientLanguage().isSearch()) {
			code = request.getInformationRecipient().getLanguage();
			str.append(returnParameters(code, CodeConstants.INFORMATIONRECIPIENT_LANGUAGECODE, 
					CodeConstants.INFORMATIONRECIPIENT_LANGUAGECODESYSTEM, CodeConstants.INFORMATIONRECIPIENT_LANGUAGEDISPLAYNAME));
		}
		if (contextDef.getInformationRecipientDiscipline() != null && contextDef.getInformationRecipientDiscipline().isSearch()) {
			code = request.getInformationRecipient().getHealthCareProvider();
			str.append(returnParameters(code, CodeConstants.INFORMATIONRECIPIENT_CODE, 
					CodeConstants.INFORMATIONRECIPIENT_CODESYSTEM, CodeConstants.INFORMATIONRECIPIENT_DISPLAYNAME));
		}
		if (contextDef.getInformationRecipientUserType() != null && contextDef.getInformationRecipientUserType().isSearch()) {
			code = CodeUtility.getCode(request.getInformationRecipient().getProviderOrPatient().getCode(), "", "", "");
			str.append(returnParameters(code, CodeConstants.INFORMATIONRECIPIENT, "", ""));
		}
		if (contextDef.getConceptOfInterest() != null && contextDef.getConceptOfInterest().isSearch()) {
			code = tc.transformOutput(contextDef.getConceptOfInterest(),request.getMainSearchCriteria().getCode(),supportedCodeSystems,request);
			str.append(returnParameters(code, CodeConstants.MAINSEARCH_CODE, 
					CodeConstants.MAINSEARCH_CODESYSTEM, CodeConstants.MAINSEARCH_DISPLAYNAME));
			if((entryLevelCategoryList!=null)&&(request.getMainSearchCriteria().getCode().getCode().equals("")))
			{
				entryLevelCategoryList.addAll(convertCodeIntoCategory(code, CodeConstants.MAINSEARCH_CODE, 
					CodeConstants.MAINSEARCH_CODESYSTEM, CodeConstants.MAINSEARCH_DISPLAYNAME));
			}
		}
		return str;
	}
	
	private static String returnParameters(Code code, String codeKey, String codeSystemKey, String displayNameKey) {

		StringBuilder str = new StringBuilder();
		if (!code.getCode().isEmpty()) {
			str.append(codeKey);
			str.append("=");
			str.append(code.getCode());
			str.append("&");
			if (!code.getCodeSystem().isEmpty()) {
				str.append(codeSystemKey);
				str.append("=");
				str.append(code.getCodeSystem());
				str.append("&");				
			}
		}
		if (!code.getDisplayName().isEmpty()) {
			
			str.append(displayNameKey);
			str.append("=");
			str.append(code.getDisplayName());
			str.append("&");
		}
		
		return str.toString();
	}
	
	private DateTimeType getUpdateTime() {
		try {
		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(Calendar.getInstance().getTime());
		XMLGregorianCalendar xmlTime;
		xmlTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
		DateTimeType updated = new DateTimeType();
		updated.setValue(xmlTime);
		return updated;
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}
}

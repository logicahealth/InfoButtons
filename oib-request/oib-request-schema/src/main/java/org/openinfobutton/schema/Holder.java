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
 * @version Jul 15, 2014
 */
package org.openinfobutton.schema;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.hl7.v3.CategoryType;
import org.hl7.v3.EDLite;
import org.hl7.v3.REDSMT010001UVAssignedEntity;
import org.hl7.v3.REDSMT010001UVAuthorizedPerson;
import org.hl7.v3.REDSMT010001UVHolder;
import org.hl7.v3.REDSMT010001UVOrganization;
import org.hl7.v3.STLite;

// TODO: Auto-generated Javadoc
/*
 $Rev:: 1097          $:  Revision of last commit
 $Author:: ai28       $:  Author of last commit
 $Date:: 2010-10-01 1#$:  Date of last commit
 */

/**
 * The Class Holder.
 */
public class Holder
{

    /** The name. */
    private String name;

    /** The certificate text. */
    private String certificateText;

    /** The assigned authorized person. */
    private IDLite assignedAuthorizedPerson;

    /** The represented organization. */
    private IDLite representedOrganization;

    /** The category. */
    List<CategoryType> category;

    /**
     * Instantiates a new holder.
     *
     * @param name the name
     * @param certificateText the certificate text
     * @param assignedAuthorizedPerson the assigned authorized person
     * @param representedOrganization the represented organization
     */
    public Holder( String name, String certificateText, IDLite assignedAuthorizedPerson, IDLite representedOrganization )
    {

        this.name = name;
        this.certificateText = certificateText;
        this.assignedAuthorizedPerson = assignedAuthorizedPerson;
        this.representedOrganization = representedOrganization;
        category = new ArrayList<CategoryType>();
    }
    
    /**
     * Instantiates a new holder.
     *
     * @param requestParameters the request parameters
     * @param categoryHashMap the category hash map
     */
    public Holder (Map<String, String[]> requestParameters, final Map<String, List<CategoryType>> categoryHashMap) {
        
        this.setCategory(new ArrayList<CategoryType>());
        // Set Holder
        String name = new String();
        if ( requestParameters.containsKey( CodeConstants.HOLDER_NAME ) )
        {
            name = requestParameters.get( CodeConstants.HOLDER_NAME )[0] ;
        }
        this.setName( name );
        String certificateText = new String();
        if ( requestParameters.containsKey( CodeConstants.HOLDER_CERTIFICATETEXT ) )
        {
            certificateText = requestParameters.get( CodeConstants.HOLDER_CERTIFICATETEXT )[0] ;
        }
        this.setCertificateText( certificateText );
        final IDLite authorizedperson = new IDLite();
        if ( requestParameters.containsKey( CodeConstants.HOLDER_AUTHORIZEDPERSON ) )
        {
            authorizedperson.setRoot( requestParameters.get( CodeConstants.HOLDER_AUTHORIZEDPERSON )[0] );
        }
        this.setAssignedAuthorizedPerson( authorizedperson );
        final IDLite representedorganization = new IDLite();
        if ( requestParameters.containsKey( CodeConstants.HOLDER_ORGANIZATION ) )
        {
            representedorganization.setRoot( requestParameters.get( CodeConstants.HOLDER_ORGANIZATION )[0] );
        }
        this.setRepresentedOrganization( representedorganization );

    }

    /**
     * Instantiates a new holder.
     */
    public Holder()
    {

        this( new String(), new String(), new IDLite(), new IDLite() );
    }

    /**
     * Instantiates a new holder.
     *
     * @param holder the holder
     */
    public Holder( REDSMT010001UVHolder holder )
    {

        final REDSMT010001UVAssignedEntity assignedEntity = holder.getAssignedEntity();
        this.name = assignedEntity.getName().getContent();
        this.certificateText = assignedEntity.getCertificateText().getContent();
        this.assignedAuthorizedPerson =
            new IDLite( assignedEntity.getAssignedAuthorizedPerson().getValue().getId().get( 0 ) );
        this.representedOrganization =
            new IDLite( assignedEntity.getRepresentedOrganization().getValue().getId().get( 0 ) );
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName()
    {

        return this.name;
    }

    /**
     * Gets the certificate text.
     *
     * @return the certificate text
     */
    public String getCertificateText()
    {

        return this.certificateText;
    }

    /**
     * Gets the assigned authorized person.
     *
     * @return the assigned authorized person
     */
    public IDLite getAssignedAuthorizedPerson()
    {

        return this.assignedAuthorizedPerson;
    }

    /**
     * Gets the represented organization.
     *
     * @return the represented organization
     */
    public IDLite getRepresentedOrganization()
    {

        return this.representedOrganization;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName( String name )
    {

        this.name = name;
    }

    /**
     * Sets the certificate text.
     *
     * @param certificateText the new certificate text
     */
    public void setCertificateText( String certificateText )
    {

        this.certificateText = certificateText;
        final CategoryType c = new CategoryType();
        c.setTerm( certificateText );
        c.setScheme( CodeConstants.HOLDER_CERTIFICATETEXT );
        category.add( c );
    }

    /**
     * Sets the assigned authorized person.
     *
     * @param assignedAuthorizedPerson the new assigned authorized person
     */
    public void setAssignedAuthorizedPerson( IDLite assignedAuthorizedPerson )
    {

        this.assignedAuthorizedPerson = assignedAuthorizedPerson;
    }

    /**
     * Sets the represented organization.
     *
     * @param representedOrganization the new represented organization
     */
    public void setRepresentedOrganization( IDLite representedOrganization )
    {

        this.representedOrganization = representedOrganization;
    }

    /**
     * Gets the category.
     *
     * @return the category
     */
    public List<CategoryType> getCategory()
    {
        return category;
    }

    /**
     * Sets the category.
     *
     * @param category the new category
     */
    public void setCategory( List<CategoryType> category )
    {
        this.category = category;
    }

    /**
     * Gets the JAXB element.
     *
     * @param holder the holder
     * @return the JAXB element
     */
    public static JAXBElement<REDSMT010001UVHolder> getJAXBElement( Holder holder )
    {

        final REDSMT010001UVHolder element = new REDSMT010001UVHolder();
        final REDSMT010001UVAssignedEntity assignedEntity = new REDSMT010001UVAssignedEntity();
        final REDSMT010001UVAuthorizedPerson authorizedPerson = new REDSMT010001UVAuthorizedPerson();
        final REDSMT010001UVOrganization authorizedOrganization = new REDSMT010001UVOrganization();
        final STLite name = new STLite();
        name.setContent( holder.getName() );
        assignedEntity.setName( name );
        final EDLite certificateText = new EDLite();
        certificateText.setContent( holder.getCertificateText() );
        assignedEntity.setCertificateText( certificateText );
        authorizedPerson.getId().add( IDLite.getJAXBElement( holder.getAssignedAuthorizedPerson() ) );
        assignedEntity.setAssignedAuthorizedPerson( new JAXBElement<REDSMT010001UVAuthorizedPerson>(
                                                     new QName("urn:hl7-org:v3","assignedAuthorizedPerson" ),
                                                     REDSMT010001UVAuthorizedPerson.class,
                                                     authorizedPerson ) );
        authorizedOrganization.getId().add( IDLite.getJAXBElement( holder.getRepresentedOrganization() ) );
        assignedEntity.setRepresentedOrganization( new JAXBElement<REDSMT010001UVOrganization>(
                                                        new QName("urn:hl7-org:v3","representedOrganization" ),
                                                        REDSMT010001UVOrganization.class,
                                                        authorizedOrganization ) );
        element.setAssignedEntity( assignedEntity );
        final JAXBElement<REDSMT010001UVHolder> jaxBElement =
            new JAXBElement<REDSMT010001UVHolder>( new QName( "urn:hl7-org:v3", "holder" ), REDSMT010001UVHolder.class,
                                                   element );
        return jaxBElement;
    }
}

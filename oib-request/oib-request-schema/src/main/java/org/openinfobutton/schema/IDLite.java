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

import org.hl7.v3.IILite;

// TODO: Auto-generated Javadoc
/*
 $Rev:: 1097          $:  Revision of last commit
 $Author:: ai28       $:  Author of last commit
 $Date:: 2010-10-01 1#$:  Date of last commit
 */

/**
 * The Class IDLite.
 */
public class IDLite
{

    /** The root. */
    private String root;

    /** The extension. */
    private String extension;

    /** The assigning authority name. */
    private String assigningAuthorityName;

    /**
     * Instantiates a new ID lite.
     *
     * @param root the root
     * @param extension the extension
     * @param assigningAuthorityName the assigning authority name
     */
    public IDLite( String root, String extension, String assigningAuthorityName )
    {
        this.root = root;
        this.extension = extension;
        this.assigningAuthorityName = assigningAuthorityName;
    }

    /**
     * Instantiates a new ID lite.
     *
     * @param id the id
     */
    public IDLite( IILite id )
    {

        this( id.getRoot(), id.getExtension(), id.getAssigningAuthorityName() );
    }

    /**
     * Instantiates a new ID lite.
     */
    public IDLite()
    {
        this( new String(), new String(), new String() );
    }

    /**
     * Gets the root.
     *
     * @return the root
     */
    public String getRoot()
    {
        return this.root;
    }

    /**
     * Gets the extension.
     *
     * @return the extension
     */
    public String getExtension()
    {
        return this.extension;
    }

    /**
     * Gets the assigning authority name.
     *
     * @return the assigning authority name
     */
    public String getAssigningAuthorityName()
    {
        return this.assigningAuthorityName;
    }

    /**
     * Sets the root.
     *
     * @param root the new root
     */
    public void setRoot( String root )
    {
        this.root = root;
    }

    /**
     * Sets the extension.
     *
     * @param extension the new extension
     */
    public void setExtension( String extension )
    {
        this.extension = extension;
    }

    /**
     * Sets the assigning authority name.
     *
     * @param assigningAuthorityName the new assigning authority name
     */
    public void setAssigningAuthorityName( String assigningAuthorityName )
    {
        this.assigningAuthorityName = assigningAuthorityName;
    }

    /**
     * Gets the JAXB element.
     *
     * @param id the id
     * @return the JAXB element
     */
    public static IILite getJAXBElement( IDLite id )
    {
        final IILite jaxBElement = new IILite();
        jaxBElement.setRoot( id.getRoot() );
        jaxBElement.setExtension( id.getExtension() );
        jaxBElement.setAssigningAuthorityName( id.getAssigningAuthorityName() );
        return jaxBElement;
    }
}

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
package edu.utah.further.profiledb.service;

import org.w3c.dom.Document;

/**
 * The Class FileandMarker.
 */
public class FileandMarker
{

    /** The blob file. */
    Document blobFile;

    /** The marker. */
    int marker;

    /**
     * Gets the blob file.
     *
     * @return the blob file
     */
    public Document getBlobFile()
    {
        return blobFile;
    }

    /**
     * Sets the blob file.
     *
     * @param blobFile the new blob file
     */
    public void setBlobFile( Document blobFile )
    {
        this.blobFile = blobFile;
    }

    /**
     * Gets the marker.
     *
     * @return the marker
     */
    public int getMarker()
    {
        return marker;
    }

    /**
     * Sets the marker.
     *
     * @param marker the new marker
     */
    public void setMarker( int marker )
    {
        this.marker = marker;
    }

}

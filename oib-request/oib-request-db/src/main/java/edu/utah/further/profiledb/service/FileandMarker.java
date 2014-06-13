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
package edu.utah.further.profiledb.service;

import java.io.File;

import org.w3c.dom.Document;

public class FileandMarker {

	Document blobFile;
	int marker;
	public Document getBlobFile() {
		return blobFile;
	}
	public void setBlobFile(Document blobFile) {
		this.blobFile = blobFile;
	}
	public int getMarker() {
		return marker;
	}
	public void setMarker(int marker) {
		this.marker = marker;
	}
	
}

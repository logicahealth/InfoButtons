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

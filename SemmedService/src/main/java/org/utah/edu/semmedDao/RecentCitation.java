package org.utah.edu.semmedDao;

/**
 * Created by JoeNarus on 5/31/16.
 */
public class RecentCitation {
    private String PMID;
    private String CitationJSON;

    public String getPMID() {
        return this.PMID;
    }

    public void setPMID(String pmid) {
        this.PMID = pmid;
    }

    public String getCitationJSON() {
        return this.CitationJSON;
    }

    public void setCitationJSON(String citationJSON) {
        this.CitationJSON = citationJSON;
    }
}

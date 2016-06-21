package org.utah.edu.semmedDao;

/**
 * Created by JoeNarus on 6/21/16.
 */
public class Filter {

    private String CUI;

    public String getCUI() {
        return CUI;
    }

    public void setCUI(String CUI) {
        this.CUI = CUI;
    }

    public String getSemanticGroup() {
        return semanticGroup;
    }

    public void setSemanticGroup(String semanticGroup) {
        this.semanticGroup = semanticGroup;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public long getFrequencyInCollection() {
        return frequencyInCollection;
    }

    public void setFrequencyInCollection(int frequencyInCollection) {
        this.frequencyInCollection = frequencyInCollection;
    }

    public int getFrequencyInResults() {
        return frequencyInResults;
    }

    public void setFrequencyInResults(int frequencyInResults) {
        this.frequencyInResults = frequencyInResults;
    }

    private String semanticGroup;

    private String term;

    private long frequencyInCollection;

    private int frequencyInResults;

    public Filter(String CUI, String semanticGroup, String term, long frequencyInCollection, int frequencyInResults) {
        this.CUI = CUI;
        this.semanticGroup = semanticGroup;
        this.term = term;
        this.frequencyInCollection = frequencyInCollection;
        this.frequencyInResults = frequencyInResults;
    }

}

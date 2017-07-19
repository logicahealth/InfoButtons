package org.openinfobutton.externalresource.json;

import java.util.List;

/**
 * Created by JoeNarus on 7/19/16.
 */
public class CodeTransformerResult {
    private String classType;
    private List<CodeTransformerResultList> results;

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public List<CodeTransformerResultList> getResults() {
        return results;
    }

    public void setResults(List<CodeTransformerResultList> results) {
        this.results = results;
    }
}

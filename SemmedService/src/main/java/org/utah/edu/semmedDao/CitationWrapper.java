package org.utah.edu.semmedDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JoeNarus on 6/13/16.
 */
public class CitationWrapper {

    public List<String> getCitations() {
        return citations;
    }

    public void setCitations(List<String> citations) {
        this.citations = citations;
    }

    public List<String> getFilters() {
        return filters;
    }

    public void setFilters(List<String> filters) {
        this.filters = filters;
    }

    private List<String> citations;
    private List<String> filters;

    public CitationWrapper() {

    }

    public CitationWrapper(List<RecentCitationsEntity> rce, List<ConceptFrequencySemmedEntity> cfse) {


    citations = new ArrayList<String>();
        for (RecentCitationsEntity s: rce) {
            if(s.getCitationjson() != null) {
                citations.add(s.getCitationjson());
            }
        }

        filters = new ArrayList<String>();
        for (ConceptFrequencySemmedEntity a: cfse) {
            if(a.getSemGroup() != null) {
                filters.add(a.getSemGroup());
            }
        }
    }

}

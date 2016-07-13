package org.utah.edu.semmed.web.wrappers;

import com.fasterxml.jackson.annotation.JsonRawValue;
import org.utah.edu.semmed.db.domain.RecentCitationsEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JoeNarus on 6/13/16.
 */
public class CitationWrapper {

    @JsonRawValue
    public List getFeed() {
        return feed;
    }

    public void setFeed(List feed) {
        this.feed = feed;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    private List<String> feed;
    private List<Filter> filters;

    public CitationWrapper() {

    }

    public CitationWrapper(List rce, List<Filter> cfse) {


        feed = new ArrayList(rce);

        filters = new ArrayList<Filter>(cfse);

        }
    }



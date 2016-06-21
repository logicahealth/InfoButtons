package org.utah.edu.semmedDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JoeNarus on 6/13/16.
 */
public class CitationWrapper {

    public List<String> getFeed() {
        return feed;
    }

    public void setFeed(List<String> citations) {
        this.feed = citations;
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

    public CitationWrapper(List<RecentCitationsEntity> rce, List<Filter> cfse) {


    feed = new ArrayList<String>();
        for (RecentCitationsEntity s: rce) {
            if(s.getCitationjson() != null) {
                feed.add(s.getCitationjson());
            }
        }

        filters = new ArrayList<Filter>(cfse);

        }
    }



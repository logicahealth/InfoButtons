package org.utah.edu.semmed.db.dao;

import org.utah.edu.semmed.web.wrappers.Filter;
import org.utah.edu.semmed.db.domain.RecentCitationsEntity;

import java.util.List;

/**
 * Created by JoeNarus on 5/23/16.
 */
public interface SemmedServiceDao {

List getCitations(List<String> PMIDs);
   List<Filter> getFilters(List<String> PMIDs);

}

package org.utah.edu.semmedDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by JoeNarus on 5/23/16.
 */
public interface SemmedServiceDao {

List<RecentCitationsEntity> getCitations(List<String> PMIDs);
   List<Filter> getFilters(List<String> PMIDs);

}

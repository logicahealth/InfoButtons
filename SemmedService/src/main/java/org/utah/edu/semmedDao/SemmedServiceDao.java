package org.utah.edu.semmedDao;

import java.util.List;

/**
 * Created by JoeNarus on 5/23/16.
 */
public interface SemmedServiceDao {

List<String> getCitations(List<String> PMIDs);

}

/**
 * -----------------------------------------------------------------------------------
 * (c) 2010-2014 OpenInfobutton Project, Biomedical Informatics, University of Utah
 * Contact: {@code <andrew.iskander@utah.edu>}
 * Biomedical Informatics
 * 421 Wakara Way, Ste 140
 * Salt Lake City, UT 84108-3514
 * Day Phone: 1-801-581-4080
 * -----------------------------------------------------------------------------------
 *
 * @author Andrew Iskander {@code <andrew.iskander@utah.edu>}
 * @version Jul 15, 2014
 */
package org.openinfobutton.subsetdb.service;

import org.openinfobutton.valuset.matcher.api.ValueSetMatcher;
import org.openinfobutton.valuset.matcher.model.ValueSets;

// TODO: Auto-generated Javadoc
/**
 * The Interface SubsetDbDao.
 */
public interface SubsetDbDao extends ValueSetMatcher
{
    /**
     * Gets the subset by name.
     *
     * @param subsetName the subset name
     * @return the subset by name
     */
     ValueSets getSubsetByName( String subsetName );

}

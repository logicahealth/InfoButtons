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
package edu.utah.further.subsetdb.service;

import edu.utah.further.core.api.context.Api;
import edu.utah.further.subsetdb.domain.Concept;
import edu.utah.further.subsetdb.domain.Subset;
import edu.utah.openinfobutton.valuset.matcher.api.ValueSetMatcher;

// TODO: Auto-generated Javadoc
/**
 * The Interface SubsetDbDao.
 */
@Api
public interface SubsetDbDao extends ValueSetMatcher
{

    /**
     * Gets the concept by code and code system.
     *
     * @param code the code
     * @param codesystem the codesystem
     * @return the concept by code and code system
     */
    public Concept getConceptByCodeAndCodeSystem( String code, String codesystem );

    /**
     * Gets the subset by name.
     *
     * @param subsetName the subset name
     * @return the subset by name
     */
    public Subset getSubsetByName( String subsetName );

}

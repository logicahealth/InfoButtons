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
package org.openinfobutton.app.dao;

import java.math.BigDecimal;
import java.util.List;
import org.openinfobutton.app.model.ValueSet;
import org.openinfobutton.app.model.ValueSetCode;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValueSetDaoI.
 *
 * @author rick
 */
public interface ValueSetDaoI
    extends DaoBaseI<ValueSet>
{

    /**
     * Gets the value set codes.
     *
     * @param valueSetId the value set id
     * @return the value set codes
     */
    List<ValueSetCode> getValueSetCodes( BigDecimal valueSetId );

}

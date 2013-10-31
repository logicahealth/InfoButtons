package org.openinfobutton.app.dao;

import java.math.BigDecimal;
import java.util.List;
import org.openinfobutton.app.model.ValueSet;
import org.openinfobutton.app.model.ValueSetCode;

/**
 *
 * @author rick
 */
public interface IValueSetDao extends IDaoBase<ValueSet> {
    
    List<ValueSetCode> getValueSetCodes( BigDecimal valueSetId );

}

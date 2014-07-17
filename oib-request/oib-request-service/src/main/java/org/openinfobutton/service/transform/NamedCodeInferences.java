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
package org.openinfobutton.service.transform;

import java.io.IOException;

import org.openinfobutton.schemas.kb.Code;

import edu.utah.openinfobutton.inference.rxnorm.service.RxNormService;

// TODO: Auto-generated Javadoc
/**
 * The Enum NamedCodeInferences.
 */
public enum NamedCodeInferences
{
    
    /** The get rx norm code. */
    getRxNormCode
    {
        @Override
        public Code getCodeFromDisplayName( final Code code )
        {
            try
            {
                return RxNormService.getCode( code );
            }
            catch ( final IOException e )
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return code;
            }
        }

    };

    /**
     * Gets the code from display name.
     *
     * @param code the code
     * @return the code from display name
     */
    public abstract Code getCodeFromDisplayName( final Code code );
}

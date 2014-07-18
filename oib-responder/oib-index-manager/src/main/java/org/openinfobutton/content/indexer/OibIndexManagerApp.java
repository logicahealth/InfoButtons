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
package org.openinfobutton.content.indexer;

import org.openinfobutton.service.IndexService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// TODO: Auto-generated Javadoc
/**
 * The Class OibIndexManagerApp.
 */
public final class OibIndexManagerApp
{

    /**
     * Instantiates a new oib index manager app.
     */
    private OibIndexManagerApp(){}
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main( String[] args )
    {

        System.out.println( "OpenInfobutton Content Index Manager" );

        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "application-context.xml" );
        final IndexService indexService = applicationContext.getBean( IndexService.class );

        indexService.refreshAllAssetIndexes( IndexService.ICD9_CODE_SYSTEM_OID );

    }
}

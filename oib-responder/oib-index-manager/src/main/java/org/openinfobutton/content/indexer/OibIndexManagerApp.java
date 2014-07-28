package org.openinfobutton.content.indexer;

import org.openinfobutton.service.IndexService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The Class OibIndexManagerApp.
 */
public final class OibIndexManagerApp {

    /**
     * Instantiates a new oib index manager app.
     */
    private OibIndexManagerApp() {
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {

        System.out.println("OpenInfobutton Content Index Manager");

        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        final IndexService indexService = applicationContext.getBean(IndexService.class);

        indexService.refreshAllAssetIndexes(IndexService.ICD9_CODE_SYSTEM_OID);

    }
}

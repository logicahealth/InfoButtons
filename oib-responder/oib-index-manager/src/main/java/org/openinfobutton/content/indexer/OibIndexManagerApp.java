package org.openinfobutton.content.indexer;

import org.openinfobutton.service.IndexService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class OibIndexManagerApp {

    public static void main(String[] args) {

        System.out.println("OpenInfobutton Content Index Manager");

        final ApplicationContext applicationContext = new FileSystemXmlApplicationContext("/application-context.xml");
        IndexService indexService = (IndexService) applicationContext.getBean(IndexService.class);
        
        indexService.refreshAllAssetIndexes( IndexService.ICD9_CODE_SYSTEM_OID );

    }
}

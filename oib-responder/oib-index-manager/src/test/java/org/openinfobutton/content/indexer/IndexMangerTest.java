package org.openinfobutton.content.indexer;

import java.util.List;
import java.util.Properties;
import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.openinfobutton.app.model.ValueSetCode;
import org.openinfobutton.service.IndexService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; //FileSystemXmlApplicationContext;

public class IndexMangerTest extends TestCase {

    final private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testApplicationContextExists() {
        
        for (String beanName:applicationContext.getBeanDefinitionNames()) {
            System.out.println("Spring bean " + beanName + " found.");
        }
        
        assertTrue( applicationContext.getBeanDefinitionCount() > 0 );
    }

    public void testUtsPropertiesExist() {

        Properties utsProperties = (Properties)applicationContext.getBean("utsProperties");
        
        for ( Object prop:utsProperties.keySet() ) {
            String propertyName = (String)prop;
            System.out.println( "Found UTS Property: " + propertyName); // + "=" + utsProperties.getProperty(propertyName));
        }
        
        assertTrue("Can't find the uts.properties file in the classpath.", utsProperties.size() > 0 );

    }
    
    /*
     * - not a good for compile-time unit tests
     * - is good to test settings and for functioanl testing during development
    */
    
//    public void testUtsAccountSettingsAreValid() {
//        
//        System.out.println("Test UMLS Terminology (UTS) account settings");
//        String codeSystem = IndexService.SNOMED_CODE_SYSTEM_OID;
//        String code = "47505003";
//        CodeExpanderUtsHelper codeExpander = new CodeExpanderUtsHelper();
//        Properties utsProperties = (Properties)applicationContext.getBean("utsProperties");
//        codeExpander.setUtsProperties( utsProperties );
//        
//        Set<Code> codes;
//        try {
//            
//            codes = codeExpander.getExpansionCodes(codeSystem, code);
//            assertTrue( "Call to the UMLS Terminology Web Services (UTS) failed.  " +
//                    "Either the UTS account does not exist (http://utslogin.nlm.nih.gov) " +
//                    "or the settings in uts.properties file are incorrect.", codes.size() > 0 );
//        
//        } catch( Exception e ) {
//            fail("Something is jacked up with UTS. ");
//        }
//    }
    
    
//    public void testDatabase() {
//        
//        IndexService indexService = (IndexService) applicationContext.getBean(IndexService.class);
//        List<ValueSetCode> supportedSystems = indexService.getSupportedCodeExpansionCodeSystems();
//        
//        assertTrue( supportedSystems.size() > 0 );
//        
//    }
    
    
    
    
    
    
}

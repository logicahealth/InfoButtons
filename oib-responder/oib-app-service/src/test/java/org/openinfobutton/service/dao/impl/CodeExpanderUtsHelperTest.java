package org.openinfobutton.service.dao.impl;

import java.util.Set;
import junit.framework.TestCase;
import org.openinfobutton.app.model.Code;
import org.openinfobutton.service.IndexService;

/**
 *
 * @author rick
 */
public class CodeExpanderUtsHelperTest extends TestCase {
    
    public CodeExpanderUtsHelperTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testExpansionCodeStub() {
        assertTrue( true );
    }
    
    /**
     * Test of getExpansionCodes method, of class CodeExpanderUtsHelper. 
     * Requires full integration and setup to run
     *  - not good for compile time regression and or unit testing
     *  - good for sanity testing during development to validate settings and external functionality
     */
//    public void testGetExpansionCodes() {
//        System.out.println("getExpansionCodes");
//        String codeSystem = IndexService.SNOMED_CODE_SYSTEM_OID;
//        String code = "47505003";
//        CodeExpanderUtsHelper instance = new CodeExpanderUtsHelper();
//        
//        Set<Code> codes;
//        try {
//            
//            codes = instance.getExpansionCodes(codeSystem, code);
//            assertTrue( codes.size() > 0 );
//        
//        } catch( Exception e) {
//            fail("Call to the UMLS Terminology Web Services (UTS) failed.  Check the UTS settings in  ");
//        }
//        
//        for ( Code eCode:codes ) {
//            System.out.println(code + " hasExpCode=" + eCode.getCode());
//        }
        
//    }
}

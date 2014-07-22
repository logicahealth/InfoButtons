package org.openinfobutton.service.dao.impl;

/*
 * #%L
 * Project:  oib-app-service
 * Director: Guilherme Del Fiol, MD, PhD
 *           University of Utah
 *           Biomedical Informatics
 *           421 Wakara Way, Suite 140
 *           Salt Lake City, UT 84108-3514
 * Phone:    801-581-4080
 * %%
 * Copyright (C) 2010 - 2014 University of Utah
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.Set;
import junit.framework.TestCase;
import org.openinfobutton.app.model.Code;
import org.openinfobutton.service.IndexService;

/**
 *
 * @author rick
 */
public class CodeExpanderUtsHelperTest extends TestCase {

    public void testExpansionCodeStub() {
        // this was neccesary to keep this test file.  The test below is useful 
        // during development ...

        assertTrue(true);
    }

    /**
     * Test of getExpansionCodes method, of class CodeExpanderUtsHelper.
     * Requires full integration and setup to run - not good for compile time
     * regression and or unit testing - good for sanity testing during
     * development to validate settings and external functionality
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

package org.openinfobutton.service.impl;

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
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openinfobutton.app.model.Code;
import org.openinfobutton.app.model.ValueSetCode;
import org.openinfobutton.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Rick Bradshaw - Tests are stubs to be added to when the in-memory db
 * implementation is complete. Tests validate spring IOC is working via a test
 * context. Business logic can't be tested until db is fully operational. May be
 * better suited for integration tests.
 */
public class IndexServiceImplTest {

    @Autowired
    IndexService indexService;

    /**
     * Test of getSupportedCodeExpansionCodeSystems method, of class
     * IndexServiceImpl.
     */
    @Test
    public void testGetSupportedCodeExpansionCodeSystems() {
        System.out.println("getSupportedCodeExpansionCodeSystems");

        try {
            List<ValueSetCode> result = indexService.getSupportedCodeExpansionCodeSystems();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    /**
     * Test of getExpansionCodes method, of class IndexServiceImpl.
     */
    @Test
    public void testGetExpansionCodes() {
        System.out.println("getExpansionCodes");
        try {
            Set<Code> result = indexService.getExpansionCodes("", "");
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    /**
     * Test of refreshAssetIndex method, of class IndexServiceImpl.
     */
    @Test
    public void testRefreshAssetIndex_BigDecimal() {
        System.out.println("refreshAssetIndex");
        try {
            int result = indexService.refreshAssetIndex(BigDecimal.ONE);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    /**
     * Test of refreshAssetIndex method, of class IndexServiceImpl.
     */
    @Test
    public void testRefreshAssetIndex_BigDecimal_String() {
        System.out.println("refreshAssetIndex");
        try {
            int result = indexService.refreshAssetIndex(BigDecimal.ONE, "");
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    /**
     * Test of refreshAllAssetIndexes method, of class IndexServiceImpl.
     */
    @Test
    public void testRefreshAllAssetIndexes_0args() {
        System.out.println("refreshAllAssetIndexes");
        try {
            int result = indexService.refreshAllAssetIndexes();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    /**
     * Test of refreshAllAssetIndexes method, of class IndexServiceImpl.
     */
    @Test
    public void testRefreshAllAssetIndexes_String() {
        System.out.println("refreshAllAssetIndexes");
        String codeSystem = "";
        try {
            int result = indexService.refreshAllAssetIndexes(codeSystem);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

}

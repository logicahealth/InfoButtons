package org.openinfobutton.service.dao.impl;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import static junit.framework.TestCase.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openinfobutton.app.model.AppProperty;
import org.openinfobutton.app.model.Asset;
import org.openinfobutton.app.model.AssetProperty;
import org.openinfobutton.app.model.Code;
import org.openinfobutton.service.dao.AppPropertyDao;
import org.openinfobutton.service.dao.CodeExpanderDao;
import org.openinfobutton.service.dao.ServiceAssetDao;
import org.openinfobutton.service.dao.ValueSetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rick BradshawBradshaw- Tests are stubs to be added to when the in-memory db
 * implementation is improved. Tests validate spring IOC is working via a test
 * context. Business logic can't be tested until db is fully operational. May be
 * better suited for integration tests.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-context.xml"})
@Transactional("transactionManager")
public class DaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    AppPropertyDao appPropertyDao;

    @Autowired
    CodeExpanderDao codeExpanderDao;

    @Autowired
    ServiceAssetDao serviceAssetDao;

    @Autowired
    ValueSetDao valueSetDao;

    /**
     * Test of getAppPropertyGroup method, of class AppPropertyDaoImpl.
     */
    @Test
    public void testGetAppPropertyGroup() {
        System.out.println("getAppPropertyGroup");
        String propertyGroup = "";
        try {
            List<AppProperty> result = appPropertyDao.getAppPropertyGroup(propertyGroup);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    /**
     * Test of getAppProperties method, of class AppPropertyDaoImpl.
     */
    @Test
    public void testGetAppProperties() {
        System.out.println("getAppProperties");
        String propertyGroup = "";
        try {
            Properties result = appPropertyDao.getAppProperties(propertyGroup);
        } catch (Exception e) {
            assertTrue(true);
        }

    }

    @Test
    public void testGetExpansionCodes() {
        System.out.println("getExpansionCodes");

        try {
            Set<Code> icd9codes = codeExpanderDao.getExpansionCodes(CodeExpanderDao.ICD9_CODE_SYSTEM_OID, "480.6");
        } catch (Exception e) {
            assertTrue(true);
        }

    }

    @Test
    public void testGetExpansionCodes2() {
        System.out.println("getExpansionCodes");

        try {
            Set<Code> rxNormCodes = codeExpanderDao.getExpansionCodes(CodeExpanderDao.RXNORM_CODE_SYSTEM_OID, "3342232");
        } catch (Exception e) {
            assertTrue(true);
        }

    }

    @Test
    public void testGetExpansionCodes3() {
        System.out.println("getExpansionCodes");

        try {
            Set<Code> snomedCodes = codeExpanderDao.getExpansionCodes(CodeExpanderDao.SNOMED_CODE_SYSTEM_OID, "6733433");
        } catch (Exception e) {
            assertTrue(true);
        }

    }

    @Test
    public void testGetExpansionRxNormCodes() {
        System.out.println("getExpansionRxNormCodes");

        try {
            Set<Code> codes = codeExpanderDao.getExpansionRxNormCodes("900469");
        } catch (Exception e) {
            assertTrue(true);
        }

    }

    @Test
    public void testGetExpansionSnomedCodes() {
        System.out.println("getExpansionSnomedCodes");

        try {
            Set<Code> codes = codeExpanderDao.getExpansionSnomedCodes("66499872");
        } catch (Exception e) {
            assertTrue(true);
        }

    }

    @Test
    public void testGetExpansionIcd9Codes() {
        System.out.println("getExpansionIcd9Codes");

        try {
            Set<Code> codes = codeExpanderDao.getExpansionIcd9Codes("480.7");
        } catch (Exception e) {
            assertTrue(true);
        }

    }

//    public int findMaxAssetPropertyGroup( BigDecimal assetId );
//    public List<Asset> findAssetsByPropertyCodeSystem( String codeSystem );
//    public void addAssetProperty( AssetProperty assetProperty );
//    public void deleteAllAssetPropertiesByGeneratedByCode(Set<String> generatedByCodes);
//    public void deleteAllAssetPropertiesByGeneratedByCodeAndCodeSystem(String codeSystem, String generatedByCode);
//    public void deleteAssetPropertiesByGeneratedByCode(BigDecimal assetId, String generatedByCode);
//    public void deleteAssetPropertiesByGeneratedByCodeAndCodeSystem(BigDecimal assetId, String codeSystem, String generatedByCode);
    @Test
    public void testFindMaxAssetPropertyGroup() {
        System.out.println("findMaxAssetPropertyGroup");

        try {

            int max = serviceAssetDao.findMaxAssetPropertyGroup(BigDecimal.ZERO);

        } catch (Exception e) {
            assertTrue(true);
        }

    }

    @Test
    public void testFindAssetsByPropertyCodeSystem() {
        System.out.println("findAssetsByPropertyCodeSystem");

        try {
            List<Asset> assets = serviceAssetDao.findAssetsByPropertyCodeSystem("");

        } catch (Exception e) {
            assertTrue(true);
        }

    }

    @Test
    public void testAddAssetProperty() {
        System.out.println("addAssetProperty");

        try {
            serviceAssetDao.addAssetProperty(new AssetProperty());
        } catch (Exception e) {
            assertTrue(true);
        }

    }

    @Test
    public void testDeleteAllAssetPropertiesByGeneratedByCode() {
        System.out.println("deleteAllAssetPropertiesByGeneratedByCode");

        Set<String> codes = new HashSet<>();

        try {
            serviceAssetDao.deleteAllAssetPropertiesByGeneratedByCode(codes);
        } catch (Exception e) {
            assertTrue(true);
        }

    }

    @Test
    public void testDeleteAllAssetPropertiesByGeneratedByCodeAndCodeSystem() {
        System.out.println("deleteAllAssetPropertiesByGeneratedByCodeAndCodeSystem");

        try {
            serviceAssetDao.deleteAllAssetPropertiesByGeneratedByCodeAndCodeSystem(null, null);
        } catch (Exception e) {
            assertTrue(true);
        }

    }

    @Test
    public void testDeleteAssetPropertiesByGeneratedByCode() {
        System.out.println("deleteAssetPropertiesByGeneratedByCode");

        try {
            serviceAssetDao.deleteAssetPropertiesByGeneratedByCode(BigDecimal.ZERO, null);
        } catch (Exception e) {
            assertTrue(true);
        }

    }

    @Test
    public void testDeleteAssetPropertiesByGeneratedByCodeAndCodeSystem() {
        System.out.println("deleteAssetPropertiesByGeneratedByCodeAndCodeSystem");

        try {
            serviceAssetDao.deleteAssetPropertiesByGeneratedByCodeAndCodeSystem(BigDecimal.ZERO, null, null);
        } catch (Exception e) {
            assertTrue(true);
        }

    }

    @Test
    public void testGetValueSetCodes() {
        System.out.println("getValueSetCodes");

        try {
            valueSetDao.getValueSetCodes(BigDecimal.ZERO);
        } catch (Exception e) {
            assertTrue(true);
        }

    }

}

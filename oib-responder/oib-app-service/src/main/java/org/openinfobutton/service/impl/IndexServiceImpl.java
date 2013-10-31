package org.openinfobutton.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.openinfobutton.app.model.Asset;
import org.openinfobutton.app.model.AssetProperty;
import org.openinfobutton.app.model.Code;
import org.openinfobutton.app.model.ValueSetCode;
import org.openinfobutton.service.IndexService;
import org.openinfobutton.service.dao.AppPropertyDao;
import org.openinfobutton.service.dao.CodeExpanderDao;
import org.openinfobutton.service.dao.ServiceAssetDao;
import org.openinfobutton.service.dao.ValueSetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rick
 */
@Service
public class IndexServiceImpl implements IndexService {
    
    
    @Autowired
    ServiceAssetDao serviceAssetDao;

    @Autowired
    ValueSetDao valueSetDao;
    
    @Autowired
    AppPropertyDao appPropertyDao;
    
    @Autowired
    CodeExpanderDao codeExpanderDao;

    @Override
    @Transactional
    public List<ValueSetCode> getSupportedCodeExpansionCodeSystems() {
        
        Properties appProperties = appPropertyDao.getAppProperties("app.valueset.id");
        String expansionCodeValueSetId = appProperties.getProperty("SUPPORTED_EXPANSION_CODE_SYSTEMS");
        List<ValueSetCode> supportedCodes = valueSetDao.getValueSetCodes(new BigDecimal(expansionCodeValueSetId));
        
        return supportedCodes;
    }

    @Override
    @Transactional
    public Set<Code> getExpansionCodes(String codeSystem, String code) {
        return codeExpanderDao.getExpansionCodes(codeSystem, code);
    }

    @Override
    @Transactional
    public int refreshAssetIndex(BigDecimal assetId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    @Transactional
    public int refreshAssetIndex(BigDecimal assetId, String codeSystem ) {
        
        serviceAssetDao.deleteAssetPropertiesByGeneratedByCodeAndCodeSystem(assetId, codeSystem, GENERATED_BY_ONTOLOGY_RELATIONSHIP);
        
        Asset asset = serviceAssetDao.get(assetId);
        List<AssetProperty> assetProperties = asset.getAssetProperties();
        int maxPropertyGroupNumber = serviceAssetDao.findMaxAssetPropertyGroup(assetId);
        
        for ( AssetProperty assetProperty:assetProperties ) {
            
            String propertyCodeSystem = assetProperty.getCodeSystem(); 
            
            if ( propertyCodeSystem != null && propertyCodeSystem.equals(codeSystem) ) {
        
                Set<Code> expansionCodes = codeExpanderDao.getExpansionCodes(codeSystem, assetProperty.getCode() );
            
                for ( Code newCode:expansionCodes ) {

                    System.out.println(asset + "===> Indexing code=" + newCode.getCode() + " " + newCode.getDisplayName() );
                    
                    AssetProperty newAssetProperty = new AssetProperty();
                    newAssetProperty.setAsset( assetProperty.getAsset() );
                    newAssetProperty.setPropertyName( "mainSearchCriteria.v" );
                    newAssetProperty.setCodeSystem( newCode.getCodeSystemOid() );
                    newAssetProperty.setCode(newCode.getCode());
                    newAssetProperty.setDisplayName( newCode.getDisplayName() );
                    newAssetProperty.setPropertyGroupNumber( new BigInteger( "" + ++maxPropertyGroupNumber ) );
                    newAssetProperty.setPropertyType( "CODE" );
                    newAssetProperty.setGeneratedByCode( GENERATED_BY_ONTOLOGY_RELATIONSHIP );
                                        
                    serviceAssetDao.addAssetProperty(newAssetProperty);
                }
            }
            
        }
        
        return 1;
    }
    
    @Override
    @Transactional
    public int refreshAllAssetIndexes() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    @Transactional
    public int refreshAllAssetIndexes( String codeSystem ) {

        List<Asset> assets = serviceAssetDao.findAssetsByPropertyCodeSystem(codeSystem);
        
        for ( Asset asset:assets ) {
            System.out.println("Refreshing asset (" + asset.getAssetId() + ") " + asset.getDisplayName() );
            refreshAssetIndex(asset.getAssetId(), codeSystem);
        }
        
        return 1;
    }
    
}

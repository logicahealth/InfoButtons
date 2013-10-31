package org.openinfobutton.service.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import org.openinfobutton.app.dao.IAssetDao;
import org.openinfobutton.app.model.Asset;
import org.openinfobutton.app.model.AssetProperty;

/**
 *
 * @author rick
 */
public interface ServiceAssetDao extends IAssetDao {
    
    public int findMaxAssetPropertyGroup( BigDecimal assetId );

    public List<Asset> findAssetsByPropertyCodeSystem( String codeSystem );
    
    public void addAssetProperty( AssetProperty assetProperty );
    
    public void deleteAllAssetPropertiesByGeneratedByCode(Set<String> generatedByCodes);

    public void deleteAllAssetPropertiesByGeneratedByCodeAndCodeSystem(String codeSystem, String generatedByCode);

    public void deleteAssetPropertiesByGeneratedByCode(BigDecimal assetId, String generatedByCode);
    
    public void deleteAssetPropertiesByGeneratedByCodeAndCodeSystem(BigDecimal assetId, String codeSystem, String generatedByCode);
    
}
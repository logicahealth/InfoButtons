package org.openinfobutton.service.dao.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.openinfobutton.app.dao.DaoBase;
import org.openinfobutton.app.model.Asset;
import org.openinfobutton.app.model.AssetProperty;
import org.openinfobutton.service.dao.ServiceAssetDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rick
 */
@Repository
public class ServiceAssetDaoImpl extends DaoBase<Asset> implements ServiceAssetDao {

    @Override
    public void addAssetProperty( AssetProperty assetProperty ) {
        getSessionFactory().getCurrentSession().save( assetProperty );
    }
    
    @Override
    public List<Asset> findAssetsByPropertyCodeSystem( String codeSystem ) {
        String hql = "select distinct ap.asset from AssetProperty ap where ap.codeSystem = :codeSystem";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql.toString());
        query.setParameter("codeSystem", codeSystem);
        return query.list();
    }
    
    public List<AssetProperty> findAssetPropertiesByGeneratedCode( Set<String> generatedByCodes ) {
        throw new UnsupportedOperationException("Not supported yet.");        
    }
    
    public int findMaxAssetPropertyGroup( BigDecimal assetId ) {

        String hql = "select max(ap.propertyGroupNumber) as maxValue from AssetProperty ap where ap.asset.assetId = :assetId ";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql.toString());
        query.setParameter("assetId", assetId);
        BigInteger maxPropertyGroupNumber = (BigInteger)query.iterate().next();
     
        return maxPropertyGroupNumber.intValue();
    }
    
    @Override
    public void deleteAllAssetPropertiesByGeneratedByCode(Set<String> generatedByCodes) {

        String hql = "delete from AssetProperty ap where ap.assetId=:assetId and ap.generatedByCode in (:generatedByCodes)";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql.toString());
        query.setParameter("generatedByCodes", generatedByCodes);
        query.executeUpdate();

    }

    @Override
    public void deleteAllAssetPropertiesByGeneratedByCodeAndCodeSystem(String codeSystem, String generatedByCode) {

        String hql = "delete from AssetProperty ap where ap.asset.assetId=:assetId and ap.codeSystem=:codeSystem and ap.generatedByCode=:generatedByCode";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql.toString());
        query.setParameter("codeSystem", codeSystem);
        query.setParameter("generatedByCode", generatedByCode);
        query.executeUpdate();

    }

    @Override
    public void deleteAssetPropertiesByGeneratedByCode(BigDecimal assetId, String generatedByCode) {

        String hql = "delete from AssetProperty ap where ap.asset.assetId=:assetId and ap.generatedByCode=:generatedByCode";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql.toString());
        query.setParameter("assetId", assetId);
        query.setParameter("generatedByCode", generatedByCode);
        query.executeUpdate();

    }

    @Override
    public void deleteAssetPropertiesByGeneratedByCodeAndCodeSystem(BigDecimal assetId, String codeSystem, String generatedByCode) {

        String hql = "delete from AssetProperty ap where ap.asset.assetId=:assetId and ap.codeSystem=:codeSystem and ap.generatedByCode=:generatedByCode";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql.toString());
        query.setParameter("assetId", assetId);
        query.setParameter("codeSystem", codeSystem);
        query.setParameter("generatedByCode", generatedByCode);
        query.executeUpdate();

    }

}

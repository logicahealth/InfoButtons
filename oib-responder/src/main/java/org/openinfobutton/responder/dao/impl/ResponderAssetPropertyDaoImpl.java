package org.openinfobutton.responder.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.openinfobutton.app.dao.DaoBase;
import org.openinfobutton.app.model.AssetProperty;
import org.openinfobutton.responder.dao.ResponderAssetPropertyDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ResponderAssetPropertyDaoImpl extends DaoBase<AssetProperty> implements ResponderAssetPropertyDao {

    @Transactional
    public List<AssetProperty> findByAssetId(BigDecimal assetId)
    {

        List<AssetProperty> assetProperties = getSessionFactory().getCurrentSession()
                .createCriteria(AssetProperty.class).add(Restrictions.eq("asset.id", assetId)).list();
        return assetProperties;
    }
}

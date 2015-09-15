package org.openinfobutton.responder.dao;

import org.openinfobutton.app.dao.AssetPropertyDaoI;
import org.openinfobutton.app.model.AssetProperty;

import java.math.BigDecimal;
import java.util.List;

public interface ResponderAssetPropertyDao extends AssetPropertyDaoI {

    List<AssetProperty> findByAssetId(BigDecimal assetId);
}

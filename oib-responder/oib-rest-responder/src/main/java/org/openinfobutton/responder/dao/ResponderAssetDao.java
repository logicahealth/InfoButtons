package org.openinfobutton.responder.dao;

import java.util.Collection;
import java.util.Map;
import org.openinfobutton.app.dao.AssetDaoI;
import org.openinfobutton.app.model.Asset;

/**
 *
 * @author rick
 */
public interface ResponderAssetDao extends AssetDaoI {

    Collection<Asset> findByInfobuttonRequest(Map<String, String> requestParameters);

}

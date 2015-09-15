package org.openinfobutton.responder.controller;

import org.openinfobutton.app.model.Asset;
import org.openinfobutton.app.model.AssetProperty;
import org.openinfobutton.responder.dao.ResponderAssetDao;
import org.openinfobutton.responder.dao.ResponderAssetPropertyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "assetManager")
public class OpenInfobuttonAssetManagerController {

    @Autowired
    ResponderAssetDao dao;

    @Autowired
    ResponderAssetPropertyDao daoP;

    @RequestMapping(produces="application/json", value = "assets", method = RequestMethod.GET)
    @ResponseBody
    public Set<Asset> getAssets()
    {
        List<Asset> assets = new ArrayList<>();
        try
        {
            assets = dao.findAll();
        }
        catch (Exception e)
        {

            String eMessage = "Unable to connect to database and retrieve assets";
            System.err.println(eMessage);
        }
        Set<Asset> uniqueAssets = new HashSet<>(assets);
        return uniqueAssets;
    }

    @RequestMapping(produces="application/json", value="asset/{assetId}", method= RequestMethod.GET)
    @ResponseBody
    public Asset getAsset(@PathVariable final BigDecimal assetId)
    {

        Asset asset = new Asset();
        try
        {
            asset = dao.get(assetId);
        }
        catch (Exception e)
        {
            String eMessage = "Unable to connect to database and retrieve asset";
            System.err.println(eMessage);
            e.printStackTrace();
        }
        return asset;
    }

    @RequestMapping(produces="application/json", value="assetProperties/{assetId}", method= RequestMethod.GET)
    @ResponseBody
    public List<AssetProperty> getAssetProperties(@PathVariable final BigDecimal assetId)
    {

        List<AssetProperty> assetProperties = new ArrayList<>();
        try
        {
            assetProperties = daoP.findByAssetId(assetId);
        }
        catch (Exception e)
        {
            String eMessage = "Unable to connect to database and retrieve asset";
            System.err.println(eMessage);
            e.printStackTrace();
        }
        return assetProperties;
    }
}

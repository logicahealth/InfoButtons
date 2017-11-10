package org.openinfobutton.responder.controller;

import org.openinfobutton.app.model.Asset;
import org.openinfobutton.app.model.AssetProperty;
import org.openinfobutton.responder.dao.ResponderAssetDao;
import org.openinfobutton.responder.dao.ResponderAssetPropertyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collection;

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

    @RequestMapping(produces="application/json", value="asset", params={"url"}, method= RequestMethod.GET)
    @ResponseBody
    public Collection<Asset> getAssetByUrl(@RequestParam(value = "url") String url)
    {
        try
        {
            System.out.println("Searching by " + url);
            return dao.findByAssetUrl(url);
        }
        catch (Exception e)
        {
            String eMessage = "Unable to connect to database and retrieve asset";
            System.err.println(eMessage);
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(produces="application/json", value="copyAsset/{assetId}", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void copyAsset(@PathVariable final BigDecimal assetId)
    {

        Asset asset;
        try
        {
            asset = (Asset)dao.get(assetId).clone();
            dao.save(asset);
        }
        catch (Exception e)
        {
            String eMessage = "Unable to connect to database and copy asset";
            System.err.println(eMessage);
            e.printStackTrace();
        }
    }

    @RequestMapping(produces="application/json", value="deleteAsset/{assetId}", method= RequestMethod.GET)
         @ResponseStatus(HttpStatus.OK)
         public void deleteAsset(@PathVariable final BigDecimal assetId)
    {

        try
        {
            dao.delete(assetId);
        }
        catch (Exception e)
        {
            String eMessage = "Unable to connect to database and delete asset";
            System.err.println(eMessage);
            e.printStackTrace();
        }
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

    @RequestMapping(produces="application/json", value="deleteAssetProperty/{assetPropertyId}", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAssetProperty(@PathVariable final BigDecimal assetPropertyId)
    {

        try
        {

            AssetProperty property = daoP.get(assetPropertyId);
            Asset asset = dao.get(property.getAsset().getAssetId());
            asset.getAssetProperties().remove(property);
            dao.save(asset);
        }
        catch (Exception e)
        {
            String eMessage = "Unable to connect to database and delete asset property";
            System.err.println(eMessage);
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "asset/update", method = RequestMethod.POST)
    @ResponseBody
    public String createOrUpdateAsset(@RequestBody Asset asset)
    {
        try {
            dao.save(asset);
            return asset.getAssetId().toString();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return new BigDecimal(-1.0).toString();
    }

    @RequestMapping(value = "assetProperty/update", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void createOrUpdateAssetProperties(@RequestBody List<AssetProperty> assetProperties)
    {
        try {
            for (AssetProperty assetProperty : assetProperties)
            {
                daoP.save(assetProperty);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

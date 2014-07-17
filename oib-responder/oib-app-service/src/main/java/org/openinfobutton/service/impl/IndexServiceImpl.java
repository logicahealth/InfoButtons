/**
 * -----------------------------------------------------------------------------------
 * (c) 2010-2014 OpenInfobutton Project, Biomedical Informatics, University of Utah
 * Contact: {@code <andrew.iskander@utah.edu>}
 * Biomedical Informatics
 * 421 Wakara Way, Ste 140
 * Salt Lake City, UT 84108-3514
 * Day Phone: 1-801-581-4080
 * -----------------------------------------------------------------------------------
 *
 * @author Andrew Iskander {@code <andrew.iskander@utah.edu>}
 * @version Jul 15, 2014
 */
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

// TODO: Auto-generated Javadoc
/**
 * The Class IndexServiceImpl.
 *
 * @author rick
 */
@Service
public class IndexServiceImpl
    implements IndexService
{

    /** The service asset dao. */
    @Autowired
    ServiceAssetDao serviceAssetDao;

    /** The value set dao. */
    @Autowired
    ValueSetDao valueSetDao;

    /** The app property dao. */
    @Autowired
    AppPropertyDao appPropertyDao;

    /** The code expander dao. */
    @Autowired
    CodeExpanderDao codeExpanderDao;

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.service.IndexService#getSupportedCodeExpansionCodeSystems()
     */
    @Override
    @Transactional
    public List<ValueSetCode> getSupportedCodeExpansionCodeSystems()
    {

        final Properties appProperties = appPropertyDao.getAppProperties( "app.valueset.id" );
        final String expansionCodeValueSetId = appProperties.getProperty( "SUPPORTED_EXPANSION_CODE_SYSTEMS" );
        final List<ValueSetCode> supportedCodes =
            valueSetDao.getValueSetCodes( new BigDecimal( expansionCodeValueSetId ) );

        return supportedCodes;
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.service.IndexService#getExpansionCodes(java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public Set<Code> getExpansionCodes( String codeSystem, String code )
    {
        return codeExpanderDao.getExpansionCodes( codeSystem, code );
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.service.IndexService#refreshAssetIndex(java.math.BigDecimal)
     */
    @Override
    @Transactional
    public int refreshAssetIndex( BigDecimal assetId )
    {
        throw new UnsupportedOperationException( "Not supported yet." );
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.service.IndexService#refreshAssetIndex(java.math.BigDecimal, java.lang.String)
     */
    @Override
    @Transactional
    public int refreshAssetIndex( BigDecimal assetId, String codeSystem )
    {

        serviceAssetDao.deleteAssetPropertiesByGeneratedByCodeAndCodeSystem( assetId, codeSystem,
                                                                             GENERATED_BY_ONTOLOGY_RELATIONSHIP );

        final Asset asset = serviceAssetDao.get( assetId );
        final List<AssetProperty> assetProperties = asset.getAssetProperties();
        int maxPropertyGroupNumber = serviceAssetDao.findMaxAssetPropertyGroup( assetId );

        for ( final AssetProperty assetProperty : assetProperties )
        {

            final String propertyCodeSystem = assetProperty.getCodeSystem();

            if ( propertyCodeSystem != null && propertyCodeSystem.equals( codeSystem ) )
            {

                final Set<Code> expansionCodes =
                    codeExpanderDao.getExpansionCodes( codeSystem, assetProperty.getCode() );

                for ( final Code newCode : expansionCodes )
                {

                    System.out.println( asset + "===> Indexing code=" + newCode.getCode() + " "
                        + newCode.getDisplayName() );

                    final AssetProperty newAssetProperty = new AssetProperty();
                    newAssetProperty.setAsset( assetProperty.getAsset() );
                    newAssetProperty.setPropertyName( "mainSearchCriteria.v" );
                    newAssetProperty.setCodeSystem( newCode.getCodeSystemOid() );
                    newAssetProperty.setCode( newCode.getCode() );
                    newAssetProperty.setDisplayName( newCode.getDisplayName() );
                    newAssetProperty.setPropertyGroupNumber( new BigInteger( "" + ++maxPropertyGroupNumber ) );
                    newAssetProperty.setPropertyType( "CODE" );
                    newAssetProperty.setGeneratedByCode( GENERATED_BY_ONTOLOGY_RELATIONSHIP );

                    serviceAssetDao.addAssetProperty( newAssetProperty );
                }
            }

        }

        return 1;
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.service.IndexService#refreshAllAssetIndexes()
     */
    @Override
    @Transactional
    public int refreshAllAssetIndexes()
    {
        throw new UnsupportedOperationException( "Not supported yet." );
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.service.IndexService#refreshAllAssetIndexes(java.lang.String)
     */
    @Override
    @Transactional
    public int refreshAllAssetIndexes( String codeSystem )
    {

        final List<Asset> assets = serviceAssetDao.findAssetsByPropertyCodeSystem( codeSystem );

        for ( final Asset asset : assets )
        {
            System.out.println( "Refreshing asset (" + asset.getAssetId() + ") " + asset.getDisplayName() );
            refreshAssetIndex( asset.getAssetId(), codeSystem );
        }

        return 1;
    }

}

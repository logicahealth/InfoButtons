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
package edu.utah.further.subsetdb.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.utah.further.core.api.context.Implementation;
import edu.utah.further.core.api.data.Dao;
import edu.utah.further.subsetdb.domain.Concept;
import edu.utah.further.subsetdb.domain.Subset;

// TODO: Auto-generated Javadoc
/**
 * The Class SubsetDbDaoImpl.
 */
@Implementation
@Repository( "subsetDbDao" )
public class SubsetDbDaoImpl
    implements SubsetDbDao
{

    /**
     * Handles generic DAO operations and searches.
     */
    @Autowired
    @Qualifier( "subsetlogDao" )
    private Dao dao;

    @Override
    @Transactional
    public Boolean isConceptInSubset( String code, String codeSystem, String subsetName )
    {

        final Concept concept = getConceptByCodeAndCodeSystem( code, codeSystem );
        final Subset subset = getSubsetByName(subsetName );

        Set<Subset> subsets = new HashSet<Subset>();
        if (concept != null && subset != null) {
            subsets = concept.getSubsets();
            return subsets.contains(subset);
        } else {

            return false;
        }
    }

    /*
     * (non-Javadoc)
     * @see edu.utah.further.subsetdb.service.SubsetDbDao#getConceptByCodeAndCodeSystem(java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public Concept getConceptByCodeAndCodeSystem( String code, String codeSystem )
    {

        final Map<String, Object> properties = new HashMap<String, Object>();
        properties.put( "codeSystem", codeSystem );
        properties.put( "code", code );

        final List concept = dao.findByProperties( Concept.class, properties );
        if ( concept.size() == 1 )
        {
            return (Concept) concept.get( 0 );
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @see edu.utah.further.subsetdb.service.SubsetDbDao#getSubsetByName(java.lang.String)
     */
    @Override
    @Transactional
    public Subset getSubsetByName( String subsetName )
    {

        final List subset = dao.findByProperty( Subset.class, "name", subsetName );
        if ( subset.size() == 1 )
        {
            return (Subset) subset.get( 0 );
        }
        return null;
    }

}

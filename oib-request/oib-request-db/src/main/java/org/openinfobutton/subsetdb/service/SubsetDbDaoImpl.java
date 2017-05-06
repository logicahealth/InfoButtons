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
package org.openinfobutton.subsetdb.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openinfobutton.subsetdb.domain.Subset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.openinfobutton.subsetdb.domain.Concept;

// TODO: Auto-generated Javadoc
/**
 * The Class SubsetDbDaoImpl.
 */
@Repository( "databaseValueSets" )
public class SubsetDbDaoImpl
    implements SubsetDbDao
{

    /**
     * The session factory.
     */
    @Autowired
    @Qualifier ("sessionFactory")
    SessionFactory sessionFactory;

    /**
     * Sets the session factory.
     *
     * @param sessionFactory the new session factory
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Gets the session factory.
     *
     * @return the session factory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

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
     * @see SubsetDbDao#getConceptByCodeAndCodeSystem(java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public Concept getConceptByCodeAndCodeSystem( String code, String codeSystem )
    {

        final Map<String, Object> properties = new HashMap<String, Object>();
        properties.put( "codeSystem", codeSystem );
        properties.put( "code", code );

        final List concept = getSessionFactory().getCurrentSession().createCriteria(Concept.class).
                add(Restrictions.eq("codeSystem", codeSystem)).add(Restrictions.eq("code", code)).list();
        if ( concept.size() == 1 )
        {
            return (Concept) concept.get( 0 );
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @see SubsetDbDao#getSubsetByName(java.lang.String)
     */
    @Override
    @Transactional
    public Subset getSubsetByName( String subsetName )
    {

        final List subset = getSessionFactory().getCurrentSession().createCriteria(Subset.class).
                add(Restrictions.eq("name", subsetName)).list();
        if ( subset.size() == 1 )
        {
            return (Subset) subset.get( 0 );
        }
        return null;
    }

}

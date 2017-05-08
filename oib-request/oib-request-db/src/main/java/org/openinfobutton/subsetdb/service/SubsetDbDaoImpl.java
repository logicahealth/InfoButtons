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

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.openinfobutton.subsetdb.domain.SubsetJson;
import org.openinfobutton.valuset.matcher.model.ValueSets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
     *
     *The jackson object mapper
     */
    final ObjectMapper objectMapper = new ObjectMapper();

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

        final ValueSets subset = getSubsetByName(subsetName );

        if (subset != null) {

            return processValueSet(subset, code, codeSystem);
        }
        return false;

    }

    /*
     * (non-Javadoc)
     * @see SubsetDbDao#getSubsetByName(java.lang.String)
     */
    @Transactional
    public ValueSets getSubsetByName( String subsetName )
    {

        final List subset = getSessionFactory().getCurrentSession().createCriteria(SubsetJson.class).
                setProjection(Projections.projectionList()
                    .add(Projections.property("valueSet"), "valueSet")).
                add(Restrictions.eq("name", subsetName)).list();
        if ( subset.size() > 0 )
        {
            try {
                return objectMapper.readValue(((Blob)subset.get( 0 )).getBinaryStream() , ValueSets.class);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private Boolean processValueSet (ValueSets valueSet, String code, String codeSystem) {

        for (ValueSets.CodeSystem vsCodeSystem : valueSet.getValueSet().getCodeSystems())
        {

            if (vsCodeSystem.getCodeSystem().equals(codeSystem)) {

                for (ValueSets.Code vsCode : vsCodeSystem.getCodes())
                {
                    if (vsCode.getCode().equals(code))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

}

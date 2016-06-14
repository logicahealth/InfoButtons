package org.utah.edu.semmedDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;


/**
 * Created by JoeNarus on 5/23/16.
 */
@Repository
public class SemmedServiceDaoImpl implements SemmedServiceDao {

    @Autowired
    SessionFactory sessionFactory;

    public SemmedServiceDaoImpl() {

    }

    @Transactional
    public List<RecentCitationsEntity> getCitations(List<String> PMIDs) {

//        List<RecentCitationsEntity> listUser = (List<RecentCitationsEntity>) sessionFactory.getCurrentSession()
//                .createCriteria(RecentCitationsEntity.class)
//                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return (List<RecentCitationsEntity>) sessionFactory.getCurrentSession()
                .createCriteria(RecentCitationsEntity.class).add(Restrictions.in("pmid", PMIDs)).list();

    }

    @Transactional
    public List<ConceptFrequencySemmedEntity> getFilters(List<String> PMIDs) {

        String query = "select tf " +
                "FROM ConceptFrequencySemmedEntity tf " +
                "WHERE tf.pmid IN ('3424234', '24299975', '10019768') " +
                "group by tf.cui";


        String query2 = "select tf.cui, tf.semGroup as semantic_group, tf.preferredName as term, idf.conceptCount as frequency_in_collection, count(tf) as frequency_in_results " +
        "FROM ConceptFrequencySemmedEntity as tf, InverseConceptFrequencySemmedEntity as idf " +
        "WHERE tf.pmid IN ('3424234', '24299975', '10019768') AND tf.cui = idf.cui group by tf.cui";

        org.hibernate.Query query1 = sessionFactory.getCurrentSession().createQuery(query);
        //query1.setParameterList("pmids",PMIDs);

        return query1.list();
    }
}

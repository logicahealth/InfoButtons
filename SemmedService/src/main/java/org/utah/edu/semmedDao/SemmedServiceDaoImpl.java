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

        return (List<RecentCitationsEntity>) sessionFactory.getCurrentSession()
                .createCriteria(RecentCitationsEntity.class).add(Restrictions.in("pmid", PMIDs)).list();

    }

    @Transactional
    public List<InverseConceptFrequencySemmedEntity> getFilters(List<String> PMIDs) {



        List<ConceptFrequencySemmedEntity> a = sessionFactory.getCurrentSession()
                .createCriteria(ConceptFrequencySemmedEntity.class).add(Restrictions.in("pmid", PMIDs)).list();

        List<String> CUIs = new ArrayList<String>();
        for (ConceptFrequencySemmedEntity b: a) {
            CUIs.add(b.getCui());
            System.out.println(b.getCui());
        }


        List<InverseConceptFrequencySemmedEntity> c = sessionFactory.getCurrentSession()
                .createCriteria(InverseConceptFrequencySemmedEntity.class).add(Restrictions.in("cui", CUIs)).list();


        return c;
    }
}

package org.utah.edu.semmed.db.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;


import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.utah.edu.semmed.db.domain.InverseConceptFrequencySemmedEntity;
import org.utah.edu.semmed.db.domain.RecentCitationsEntity;
import org.utah.edu.semmed.web.wrappers.Filter;


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
    public List<org.utah.edu.semmed.web.wrappers.Filter> getFilters(List<String> PMIDs) {
        List<String> CUIs = new ArrayList<String>();
        Map<String,Integer> frequencies = new HashMap<String,Integer>();
        List<Filter> filtersTemp = new ArrayList<Filter>();
        Map<String, ArrayList<String>> values = new HashMap<String, ArrayList<String>>();

        java.sql.Connection conn = null;

        StringBuilder builder = new StringBuilder();

        PreparedStatement pstmt = null;


        for( int i = 0 ; i < PMIDs.size(); i++ ) {
            builder.append("?,");
        }


        String stmt = "select CUI from SemanticMedline.CONCEPT_FREQUENCY_SEMMED where PMID in ("
                + builder.deleteCharAt( builder.length() -1 ).toString() + ")";


        try {
            conn = DriverManager.getConnection("jdbc:mysql://mysql.chpc.utah.edu:3306/SemanticMedline", "semmed", "mahdifatemeh");

            pstmt = conn.prepareStatement(stmt);
            int index = 1;
            for( String o : PMIDs ) {
                pstmt.setString(  index++, o ); // or whatever it applies
            }


            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
               CUIs.add(rs.getString(1));
               if(frequencies.containsKey(rs.getString(1))) {
                   int temp = frequencies.get(rs.getString(1));
                   temp++;
                    frequencies.put(rs.getString(1), temp);
               }
                else
                   frequencies.put(rs.getString(1), 1);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

//        List<ConceptFrequencySemmedEntity> a = sessionFactory.getCurrentSession()
//                .createCriteria(ConceptFrequencySemmedEntity.class).add(Restrictions.in("pmid", PMIDs)).list();
//
//        List<String> CUIs = new ArrayList<String>();
//        for (ConceptFrequencySemmedEntity b: a) {
//            System.out.println();
//        }



        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(InverseConceptFrequencySemmedEntity.class);
        criteria.add(Restrictions.in("cui", CUIs));

        List<InverseConceptFrequencySemmedEntity> c = criteria.list();

        for(InverseConceptFrequencySemmedEntity temp : c) {
            Filter temp1 = new Filter(temp.getCui(), temp.getSemGroup(), temp.getPreferredName(), temp.getConceptCount(), frequencies.get(temp.getCui()));
            filtersTemp.add(temp1);
        }


        return filtersTemp;
    }
}

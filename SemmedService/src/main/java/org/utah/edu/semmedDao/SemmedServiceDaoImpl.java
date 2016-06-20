package org.utah.edu.semmedDao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.persistence.*;
import java.sql.*;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
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
        List<String> CUIs = new ArrayList<String>();
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

            for( Object o : PMIDs ) {
                pstmt.setObject(  index++, o ); // or whatever it applies
            }

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                CUIs.add(rs.getString(1));
            }

            //***********////////// SECOND QUERY ////////////****************//
//
//            StringBuilder builder2 = new StringBuilder();
//
//            PreparedStatement pstmt2 = null;
//
//            for( int i = 0 ; i < CUIs.size(); i++ ) {
//                builder2.append("?,");
//            }
//
//            String stmt2 = "select * from SemanticMedline.INVERSE_CONCEPT_FREQUENCY_SEMMED where CUI in ("
//                    + builder.deleteCharAt( builder2.length() -1 ).toString() + ")";
//
//            pstmt2 = conn.prepareStatement(stmt2);
//            index = 1;
//
//            for( Object o : CUIs ) {
//                pstmt2.setObject(  index++, o ); // or whatever it applies
//            }
//
//            ResultSet rs2 = pstmt2.executeQuery();
//            ResultSetMetaData rsmd = rs2.getMetaData();
//            int columnCount = rsmd.getColumnCount();
//            while(rs2.next()) {
//                ArrayList<String> a = new ArrayList<String>();
//                for (int i = 2; i <= columnCount; i++) {
//                    a.add(rs2.getString(i));
//                }
//                values.put(rs2.getString(1), a);
//            }

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


        List<InverseConceptFrequencySemmedEntity> c = sessionFactory.getCurrentSession()
                .createCriteria(InverseConceptFrequencySemmedEntity.class).add(Restrictions.in("cui", CUIs)).list();


        return c;
    }
}

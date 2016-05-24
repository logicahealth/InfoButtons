package org.utah.edu.semmedDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.Transactional;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;


/**
 * Created by JoeNarus on 5/23/16.
 */
public class SemmedServiceDaoImpl implements SemmedServiceDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public void ContactDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://mysql.chpc.utah.edu:3306");
        dataSource.setUsername("semmed");
        dataSource.setPassword("mahdifatemeh");

        return dataSource;
    }

    @Transactional
    public List<String> getCitations(List<String> PMIDs) {
        String queryCitations = "SELECT Citationjson FROM SemanticMedline.RECENT_CITATIONS WHERE PMID in (';";
        long count = 1;
        for (String s: PMIDs) {
            queryCitations += s;
            if(count != PMIDs.size()) {
                queryCitations += ", ";
            }
            count++;
        }
        queryCitations += "');";

        ContactDAOImpl(getDataSource());


        List<String> data = jdbcTemplate.query(queryCitations, new RowMapper<String>(){
            public String mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                return rs.getString(1);
            }
        });


        return data;
    }
}

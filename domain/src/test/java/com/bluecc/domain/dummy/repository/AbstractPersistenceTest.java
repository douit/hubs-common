package com.bluecc.domain.dummy.repository;

import com.bluecc.domain.guice.GuiceTestRunner;
import com.bluecc.domain.guice.Transactional;
import com.bluecc.domain.util.JdbcHelper;
import org.junit.Before;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RunWith(GuiceTestRunner.class)
public abstract class AbstractPersistenceTest {
    @Inject
    private DataSource dataSource;
    @Inject
    JdbcHelper jdbcHelper;

    @Before
    @Transactional
    public void setUp(){
        System.out.println("truncate tables");
        jdbcHelper.truncate("LOCATION", "USER",
                "tweet", "TWEET_USER");
    }

    @Transactional
    public void truncateAll() {
        try (Connection connection = dataSource.getConnection()) {
            List<String> tables = new ArrayList<String>();
            DatabaseMetaData md = connection.getMetaData();
            // ResultSet rs = md.getTables(null, null, null,
            //         new String[] { "TABLE" });
            ResultSet rs = md.getTables("hubs", "", null,
                    new String[] { "TABLE" });
            try {
                while (rs.next()) {
                    tables.add(rs.getString("TABLE_NAME"));
                }
            } finally {
                rs.close();
            }

            // tables.forEach(t -> System.out.println(t));

            java.sql.Statement stmt = connection.createStatement();
            try {
                // stmt.execute("SET REFERENTIAL_INTEGRITY FALSE");
                for (String table : tables) {
                    stmt.execute("TRUNCATE TABLE " + table);
                }
                // stmt.execute("SET REFERENTIAL_INTEGRITY TRUE");
            } finally {
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.bluecc.domain.dummy.repository;


import com.bluecc.domain.guice.GuiceTestRunner;
import org.junit.Test;
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
public class DatabaseMetaTest {
    @Inject
    private DataSource dataSource;

    @Test
    public void retrieveTables() {
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

                    String tableName = rs.getString("TABLE_NAME");  //表名
                    String tableType = rs.getString("TABLE_TYPE");  //表类型
                    String remarks = rs.getString("REMARKS");       //表备注
                    System.out.println(tableName + " - " + tableType + " - " + remarks);
                }
            } finally {
                rs.close();
            }

            System.out.println("total tables: "+tables.size());
            // tables.forEach(t -> System.out.println(t));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.bluecc.domain.util;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcHelper {
    @Inject
    private DataSource dataSource;

    public void truncate(String... tables) {
        try (Connection connection = dataSource.getConnection()) {
            try (java.sql.Statement stmt = connection.createStatement()) {
                // stmt.execute("SET REFERENTIAL_INTEGRITY FALSE");
                for (String table : tables) {
                    stmt.execute("TRUNCATE TABLE " + table);
                }
                // stmt.execute("SET REFERENTIAL_INTEGRITY TRUE");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

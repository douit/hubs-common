package com.bluecc.income.dummy.store;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Singleton
@Slf4j
public class MysqlFac implements IDataSourceFac {

    HikariDataSource ds;

    @Inject
    MysqlFac(@Named("url") String url,
             @Named("user") String user,
             @Named("password") String password) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setUsername(user);
        config.setPassword(password);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        ds = new HikariDataSource(config);
        log.info(".. config with data source url: {}", url);
    }

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public DataSource getDataSource() {
        return ds;
    }
}


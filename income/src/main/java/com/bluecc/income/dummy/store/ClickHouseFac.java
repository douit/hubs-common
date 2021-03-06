package com.bluecc.income.dummy.store;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.inject.Singleton;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Singleton
public class ClickHouseFac implements IDataSourceFac{

    HikariDataSource ds;

    ClickHouseFac() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:clickhouse://127.0.0.1:9000/default");
        config.setDriverClassName("com.github.housepower.jdbc.ClickHouseDriver");
        config.setUsername("default");
        config.setPassword("");
//        config.addDataSourceProperty("cachePrepStmts", "true");
//        config.addDataSourceProperty("prepStmtCacheSize", "250");
//        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        ds = new HikariDataSource(config);
    }

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public DataSource getDataSource(){
        return ds;
    }
}


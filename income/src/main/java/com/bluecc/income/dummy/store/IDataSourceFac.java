package com.bluecc.income.dummy.store;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public interface IDataSourceFac {
    Connection getConnection() throws SQLException;
    DataSource getDataSource();
}


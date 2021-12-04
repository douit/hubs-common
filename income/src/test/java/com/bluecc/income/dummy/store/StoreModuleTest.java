package com.bluecc.income.dummy.store;

import com.bluecc.income.helper.TenantHubs;
import com.bluecc.income.helper.TestHubs;
import org.junit.Test;

import javax.inject.Inject;

import java.sql.SQLException;

import static com.bluecc.income.dummy.store.StoreModule.startup;
import static org.junit.Assert.*;

public class StoreModuleTest {

    @TenantHubs
    @Inject
    IDataSourceFac dataSourceFac;
    @TestHubs
    @Inject
    IDataSourceFac testSourceFac;

    @Test
    public void testStartup() throws SQLException {
        StoreModuleTest test=startup(StoreModuleTest.class);
        assertNotNull(test.dataSourceFac.getConnection());
        assertNotNull(test.testSourceFac.getConnection());
    }
}


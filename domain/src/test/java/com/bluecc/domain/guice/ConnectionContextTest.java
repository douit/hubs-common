package com.bluecc.domain.guice;

import com.google.inject.Inject;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(GuiceTestRunner.class)
public class ConnectionContextTest {

    @Inject
    private ConnectionContext context;

    @After
    public void tearDown() {
        context.removeConnection();
    }

    @Test
    public void get_connection() {
        assertNotNull(context.getConnection(true));
        assertNotNull(context.getConnection());
        context.removeConnection();
        assertNull(context.getConnection());
    }
}

package com.bluecc.hubs.fund;

import org.junit.Test;

import static com.bluecc.hubs.fund.Util.pretty;
import static org.junit.Assert.assertNotNull;

public class HeadEntityResourcesTest {

    @Test
    public void getHeadEntities() {
        pretty(HeadEntityResources.getHeadEntities());
        assertNotNull(HeadEntityResources.get("FinAccount"));
    }
}

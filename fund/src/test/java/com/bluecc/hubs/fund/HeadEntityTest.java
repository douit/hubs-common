package com.bluecc.hubs.fund;

import org.junit.Test;

import static com.bluecc.hubs.fund.Util.pretty;
import static org.junit.Assert.*;

public class HeadEntityTest {

    @Test
    public void getHeadEntities() {
        pretty(HeadEntity.getHeadEntities());
    }
}

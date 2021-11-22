package com.bluecc.gentool;

import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.EntityMetaManager;
import com.bluecc.hubs.fund.Util;
import com.google.common.collect.Sets;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class EntityMetaManagerTest {

    EntityMetaManager entityMetaManager;
    MetaTool main = new MetaTool();
    @Before
    public void setUp() throws Exception {
        System.out.println(Util.getCurrentDirectory());
        entityMetaManager=new EntityMetaManager();
    }

    @Test
    public void getEntityMeta() {
        EntityMeta meta=entityMetaManager.getEntityMeta("Party");
        main.digest(meta);
    }

    @Test
    public void getOrderEntityMeta() {
        EntityMeta meta=entityMetaManager.getEntityMeta("OrderHeader");
        main.digest(meta);
        System.out.println("=====================");
        meta=entityMetaManager.getEntityMeta("OrderItem");
        main.digest(meta);
    }


}
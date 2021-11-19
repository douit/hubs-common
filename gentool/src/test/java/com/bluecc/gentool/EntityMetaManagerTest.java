package com.bluecc.gentool;

import com.bluecc.gentool.common.EntityMeta;
import com.bluecc.gentool.common.Util;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EntityMetaManagerTest {

    EntityMetaManager entityMetaManager;
    @Before
    public void setUp() throws Exception {
        System.out.println(Util.getCurrentDirectory());
        entityMetaManager=new EntityMetaManager();
    }

    @Test
    public void getEntityMeta() {
        EntityMeta meta=entityMetaManager.getEntityMeta("Party");
        meta.getFields().forEach(f -> System.out.format("%s %s %s\n",
                f.getName(), f.getSqlType(), f.getJavaType()));
    }
}
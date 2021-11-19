package com.bluecc.gentool;

import com.bluecc.gentool.common.EntityMeta;
import com.bluecc.gentool.common.Util;
import com.bluecc.gentool.dummy.DummyTemplateProcs;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class SqlGenToolTest {
    EntityMetaManager entityMetaManager;
    // MetaTool main = new MetaTool();
    @Before
    public void setUp() throws Exception {
        System.out.println(Util.getCurrentDirectory());
        entityMetaManager=new EntityMetaManager();
    }

    @Test
    public void genDDL() {
        EntityMeta meta=entityMetaManager.getEntityMeta("Quote");
        DummyTemplateProcs procs=new DummyTemplateProcs();
        try {
            String cnt=procs.procSql("mysql", meta);
            System.out.println(cnt);
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
}
package com.bluecc.testkit;

import org.junit.runner.RunWith;

@RunWith(GuiceStoreRunner.class)
public class AbstractStoreProcTest extends AbstractProcTest {
    @Override
    protected void setupEntities(String...entities){
        setupEntities(false, entities);
    }
}


package com.bluecc.income;

import org.junit.runner.RunWith;

@RunWith(GuiceTestRunner.class)
public class AbstractOnceProcTest extends AbstractProcTest {
    @Override
    protected void setupEntities(String...entities){
        setupEntities(true, entities);
    }
}


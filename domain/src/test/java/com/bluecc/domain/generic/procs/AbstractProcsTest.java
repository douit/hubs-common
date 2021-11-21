package com.bluecc.domain.generic.procs;

import com.bluecc.domain.guice.GuiceTestRunner;
import com.bluecc.domain.util.JdbcHelper;
import com.bluecc.domain.util.RandomNum;
import com.google.inject.Inject;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

@RunWith(GuiceTestRunner.class)
public class AbstractProcsTest {
    @Inject
    JdbcHelper jdbcHelper;
    public void addTestData() {

    }

    protected BigDecimal randDecimal(int min, int max){
        return BigDecimal.valueOf(RandomNum.getRandInt(min, max));
    }
}

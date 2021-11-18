package com.bluecc.domain.generic.procs;

import com.bluecc.domain.dummy.guice.GuiceTestRunner;
import com.bluecc.domain.util.RandomNum;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

@RunWith(GuiceTestRunner.class)
public class AbstractProcsTest {
    public void addTestData() {

    }

    protected BigDecimal randDecimal(int min, int max){
        return BigDecimal.valueOf(RandomNum.getRandInt(min, max));
    }
}

package com.bluecc.hubs.fund;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withinPercentage;

public class StopwatchTest {
    @Test
    public void test() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        Thread.sleep(1000); //Do something
        stopwatch.stop();
        assertThat(stopwatch.elapsed(TimeUnit.MILLISECONDS))
                .isCloseTo(1000, withinPercentage(1L));
    }
}

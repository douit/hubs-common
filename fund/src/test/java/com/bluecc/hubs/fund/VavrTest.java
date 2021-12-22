package com.bluecc.hubs.fund;

import io.vavr.control.Try;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VavrTest {
    @Test
    public void testTry(){
        Try<Integer> result = Try.of(() -> 1 / 0);
        assertTrue(result.isFailure());
        System.out.println(result.getCause().getMessage());
        System.out.println(result.toString());
    }

    @Test
    public void givenBadCode_whenTryHandles_thenCorrect2() {
        Try<Integer> computation = Try.of(() -> 1 / 0);
        int errorSentinel = computation.getOrElse(-1);

        assertEquals(-1, errorSentinel);
    }
}

package com.bluecc.hubs.fund;

import java.math.BigDecimal;

public final class Calcs {
    public static int sum(int a, int b) {
        return a + b;
    }

    public static BigDecimal sumDecimal(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }
}

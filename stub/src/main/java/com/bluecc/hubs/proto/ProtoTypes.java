package com.bluecc.hubs.proto;

import com.bluecc.hubs.stub.DecimalValue;

public class ProtoTypes {
    public static java.math.BigDecimal getBigDecimal(DecimalValue serialized){
        java.math.MathContext mc = new java.math.MathContext(serialized.getPrecision());
        java.math.BigDecimal deserialized = new java.math.BigDecimal(
                new java.math.BigInteger(serialized.getValue().toByteArray()),
                serialized.getScale(),
                mc);
        return deserialized;
    }
}


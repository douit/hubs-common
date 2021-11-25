package com.bluecc.hubs;

import com.bluecc.hubs.stub.Currency;
import com.bluecc.hubs.stub.DecimalValue;
import com.bluecc.hubs.stub.FixedPoint;
import com.bluecc.hubs.stub.Indicator;
import com.google.protobuf.Timestamp;
import com.google.type.Money;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.math.MathContext;

public class ProtoTypes {
    public static java.math.BigDecimal getBigDecimal(DecimalValue serialized){
        java.math.MathContext mc = new java.math.MathContext(serialized.getPrecision());
        java.math.BigDecimal deserialized = new java.math.BigDecimal(
                new java.math.BigInteger(serialized.getValue().toByteArray()),
                serialized.getScale(),
                mc);
        return deserialized;
    }
    public static java.math.BigDecimal getBigDecimal(Currency serialized){
        return new BigDecimal(serialized.getValue());
    }

    protected static Money toGoogleMoney(final BigDecimal decimal) {
        return Money.newBuilder()
                .setCurrencyCode("USD")
                .setUnits(decimal.longValue())
                .setNanos(decimal.remainder(BigDecimal.ONE).movePointRight(decimal.scale()).intValue())
                .build();
    }

    public static BigDecimal getBigDecimal(FixedPoint fixedPoint) {
        BigDecimal val=new BigDecimal(fixedPoint.getValue())
                .movePointLeft(fixedPoint.getScalingPosition());
        return val;
    }

    public static FixedPoint getFixedPoint(BigDecimal val){
        return FixedPoint.newBuilder()
                .setValue(val.longValue())
                .setScalingPosition(val.scale())
                .build();
    }

    public static FixedPoint getFixedPoint(String val){
        return getFixedPoint(new BigDecimal(val));
    }

    public static DateTime getDateTime(Timestamp ts){
        return new DateTime(ts.getSeconds()*1000);
    }

    public static Indicator castIndicator(String c) {
        switch (c.toUpperCase()) {
            case "Y":
                return Indicator.YES;
            case "N":
                return Indicator.NO;
            default:
                return Indicator.UNKNOWN;
        }
    }

    public static char getIndicatorChar(Indicator indicator){
        switch (indicator){
            case YES: return 'Y';
            case NO: return 'N';
        }
        return ' ';
    }
}


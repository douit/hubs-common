package com.bluecc.hubs;

import com.bluecc.hubs.stub.*;
import com.google.common.collect.Lists;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Message;
import com.google.protobuf.Timestamp;
import com.google.type.Money;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.time.ZoneOffset;
import java.util.List;

@Slf4j
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

    public static java.time.LocalDateTime getLocalDateTime(Timestamp ts){
        return java.time.LocalDateTime.ofEpochSecond(ts.getSeconds(), ts.getNanos(), ZoneOffset.UTC);
    }
    public static java.time.LocalDate getLocalDate(Timestamp ts){
        return getLocalDateTime(ts).toLocalDate();
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

    public static String getEntityTypeByMessage(Message msg){
        Descriptors.Descriptor descriptor = msg.getDescriptorForType();
        String entityType=descriptor.getOptions().getExtension(RoutinesProto.entityType);
        return entityType;
    }

    public static String[] getEntityKeys(Message msg) {
        EntityKey keys=msg.getDescriptorForType().getOptions().getExtension(RoutinesProto.keys);
        return keys.getKeys().split(", ");
    }
    public static String[] getEntityKeys(Descriptors.Descriptor descriptor) {
        EntityKey keys=descriptor.getOptions().getExtension(RoutinesProto.keys);
        return keys.getKeys().split(", ");
    }

    public static String getEntityIden(Message msg, String delimiter) {
        List<String> result = getEntityIdenValues(msg);
        return String.join(delimiter, result);
    }

    public static List<String> getEntityIdenValues(Message msg) {
        Descriptors.Descriptor descriptor = msg.getDescriptorForType();
        List<String> result= Lists.newArrayList();
        for (String entityKey : getEntityKeys(msg)) {
            // log.info(".. entity-iden "+entityKey);
            Object val= msg.getField(descriptor.findFieldByName(entityKey));
            result.add(val.toString());
        }
        return result;
    }
}


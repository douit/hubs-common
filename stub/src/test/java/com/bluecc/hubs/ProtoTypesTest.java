package com.bluecc.hubs;

import com.bluecc.hubs.feed.ProtoStuffs;
import com.bluecc.hubs.stub.*;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.type.Date;
import com.google.type.Money;
import com.google.type.TimeOfDay;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.time.LocalTime;

import static com.bluecc.hubs.ProtoTypes.getBigDecimal;
import static com.bluecc.hubs.ProtoTypes.getTimeOfDay;
import static org.junit.Assert.*;

public class ProtoTypesTest {
    @Test
    public void testCurrency(){
        BigDecimal val=new BigDecimal(750000000, new MathContext(9));
        System.out.println(val+", "+val.scale());
        BigDecimal remainVal=val.movePointLeft(9);
        System.out.println(remainVal);

        val=new BigDecimal(-750);
        remainVal=val.movePointLeft(2);
        System.out.println(remainVal);

        Currency currency=Currency.newBuilder()
                .setCurrencyUomId("CNY").setValue("0.75")
                .build();
        System.out.println(currency);
    }

    @Test
    public void toGoogleMoney() {
        BigDecimal curr=new BigDecimal("18.7500000");
        System.out.println(curr+", "+curr.longValue()+", "
                +curr.precision()+", "+curr.scale());
        Money money=ProtoTypes.toGoogleMoney(curr);
        System.out.println(money);
    }

    @Test
    public void testFixedPoint() {
        FixedPoint fixedPoint= FixedPoint.newBuilder()
                .setValue(1875)
                .setScalingPosition(2)
                .build();
        BigDecimal val = getBigDecimal(fixedPoint);
        BigDecimal curr = new BigDecimal("18.75");
        assertEquals(curr, val);

        System.out.println(curr + ", " + curr.longValue() + ", "
                + curr.precision() + ", " + curr.scale());
    }

    @Test
    public void testEntitySerializer() throws InvalidProtocolBufferException {
        PersonFlatData flatData=ProtoStuffs.personFlatData();
        byte[] bytes=ProtoTypes.serializeEntityWithEnvelope(flatData);
        PersonFlatData resultData=(PersonFlatData) ProtoTypes.deserializeEntityWithEnvelope(bytes);
        assertEquals(flatData.getLastName(), resultData.getLastName());

    }

    @Test
    public void testPeriod(){
        PeriodData periodData=PeriodData.newBuilder()
                .setFromDate(Date.newBuilder().setYear(1997).build())
                .setFromDate(Date.newBuilder().setYear(1998).build())
                .build();
        System.out.println(periodData);
    }

    @Test
    public void testTime(){
        LocalTime localTime=LocalTime.now();
        System.out.println(localTime);
        TimeOfDay timeOfDay = getTimeOfDay(localTime);
        System.out.println(timeOfDay);
    }

    @Test
    public void testHasTable(){
        ContactMechData contactMechData= ContactMechData.newBuilder().build();
        System.out.println(ProtoTypes.getTableByMessage(contactMechData));
        assertEquals("contact_mech", ProtoTypes.getTableByMessage(contactMechData));
        assertTrue(ProtoTypes.hasTable(contactMechData));
    }
}
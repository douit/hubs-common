package com.bluecc.hubs;

import com.bluecc.hubs.feed.DataFill;
import com.bluecc.hubs.feed.ProtoStuffs;
import com.bluecc.hubs.stub.*;
import com.google.protobuf.Descriptors;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Timestamp;
import com.google.type.Date;
import com.google.type.Money;
import com.google.type.TimeOfDay;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import static com.bluecc.hubs.ProtoTypes.*;
import static com.bluecc.hubs.stereotypes.PartySeedData.ContactMechType_ELECTRONIC_ADDRESS;
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
    public void testDateTimeZoneOffset(){
        // ZoneId.getAvailableZoneIds().forEach(z -> System.out.println(z));
        System.out.println("default: "+ZoneOffset.systemDefault());
        ZoneOffset offset=ZoneOffset.systemDefault().getRules().getOffset(LocalDateTime.now());
        ZoneOffset offsetUtc=ZoneOffset.UTC.getRules().getOffset(LocalDateTime.now());
        ZoneOffset offsetShanghai=ZoneId.of("Asia/Shanghai").getRules().getOffset(LocalDateTime.now());
        System.out.println(offset);
        System.out.println(offsetUtc);
        System.out.println(offsetShanghai);

        // String orig="2006-04-25 12:46:27.122";
        String orig="2006-04-25 12:46:27";
        Timestamp ts=getTimestamp(orig);
        System.out.println(orig+" -> "+ProtoTypes.getLocalDateTime(ts));

        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dt=LocalDateTime.parse(orig, formatter);
        System.out.println(dt);
        // dt.toEpochSecond(ZoneOffset.UTC);
        ts= getTimestamp(dt.toInstant(ZoneOffset.UTC));
        System.out.println("UTC: "+orig+" -> "+ProtoTypes.getLocalDateTime(ts));
        ts= getTimestamp(dt.toInstant(offset));
        // ??????8??????
        System.out.println("Asia/Shanghai: "+orig+" -> "+ProtoTypes.getLocalDateTime(ts));
    }

    @Test
    public void test_parseBest_secondOption() throws Exception {
        DateTimeFormatter test = DateTimeFormatter.ofPattern("yyyy-MM-dd[ HH:mm[XXX]]");
        TemporalAccessor result = test.parseBest("2011-06-30", ZonedDateTime::from, LocalDate::from);
        assertEquals(result, LocalDate.of(2011, 6, 30));
        assertTrue(result instanceof LocalDate);


        result = ZonedDateTime.parse("2007-12-03T10:15:30+01:00[Europe/Paris]");
        // System.out.println(result);
        assertNotNull(result);
    }

    @Test
    public void testDateTimeStandardFormat(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        LocalDateTime parse = LocalDateTime.parse("2012-10-01T09:45:00.000+02:00", formatter);
        System.out.println(parse);
    }

    @Test
    public void testHasTable(){
        ContactMechData contactMechData= ContactMechData.newBuilder().build();
        System.out.println(ProtoTypes.getTableByMessage(contactMechData));
        assertEquals("contact_mech", ProtoTypes.getTableByMessage(contactMechData));
        assertTrue(ProtoTypes.hasTable(contactMechData));
    }

    @Test
    public void testMessageFields(){
        ContactMechType_ELECTRONIC_ADDRESS.getAllFields().keySet()
                .forEach(f -> System.out.println(f.getName()));
        System.out.println(ContactMechType_ELECTRONIC_ADDRESS);
        Descriptors.Descriptor descriptor=ContactMechType_ELECTRONIC_ADDRESS.getDescriptorForType();
        System.out.println(ContactMechType_ELECTRONIC_ADDRESS
                .hasField(descriptor.findFieldByName("has_table")));
        System.out.println("val: "+castIndicator("Y"));

        ContactMechTypeData data=ContactMechTypeData.newBuilder()
                .setContactMechTypeId("ELECTRONIC_ADDRESS")
                .setDescription("Electronic Address")
                .setHasTable(castIndicator("N"))
                .build();
        System.out.println(data.getHasTable());
        System.out.println(data
                .hasField(descriptor.findFieldByName("has_table")));

        data=ContactMechTypeData.newBuilder()
                .setContactMechTypeId("ELECTRONIC_ADDRESS")
                .setDescription("Electronic Address")
                .setHasTable(castIndicator("Y"))
                .build();
        System.out.println(data
                .hasField(descriptor.findFieldByName("has_table")));
        System.out.println(data);
    }

    @Test
    public void testToString(){
        System.out.println(LocalDateTime.now().toString());
        System.out.println(new BigDecimal("2.5"));
    }

    @Test
    public void testIndicator(){
        assertEquals(Indicator.SECOND, castIndicator("2"));
        System.out.println(Indicator.SECOND);
        assertEquals('2', ProtoTypes.getIndicatorChar(Indicator.SECOND));
    }
}


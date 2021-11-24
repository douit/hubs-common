package com.bluecc.hubs.stub;

import com.bluecc.hubs.ProtoJsonUtils;
import com.bluecc.hubs.proto.DataFill;
import com.bluecc.hubs.ProtoTypes;
import com.google.protobuf.*;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class ProtoTest {
    @Test
    public void testProto() throws IOException {
        StringValue val = StringValue.newBuilder()
                .setValue("samlet")
                .build();
        System.out.println(val.toString());
        String jsonVal = ProtoJsonUtils.toJson(val);
        System.out.println(jsonVal);

        System.out.println(ProtoJsonUtils.toProtoBean(StringValue.newBuilder(), jsonVal));
    }

    @Test
    public void testParseProtoJson() throws IOException {
        Collection<Feature> features = RouteGuideUtil.parseFeatures(RouteGuideUtil.getDefaultFeaturesFile());
        features.forEach(e -> System.out.println(e));
    }

    @Test
    public void testTimestamp() {
        long millis = System.currentTimeMillis();
        // the Joda Time's [`ISODateTimeFormat.dateTime()`](
        // http://www.joda.org/joda-time/apidocs/org/joda/time/format/ISODateTimeFormat.html#dateTime%2D%2D
        // ) to obtain a formatter capable of generating timestamps in this format.

        Timestamp timestamp = getTimestamp(millis);
        HelloReply reply = HelloReply.newBuilder()
                .setMessage("hi")
                .setTimestamp(timestamp)
                .build();
        System.out.println(reply);
        System.out.println(reply.getTimestamp());
        //
        DateTime dt=new DateTime(reply.getTimestamp().getSeconds()*1000);
        System.out.println(dt);
        System.out.println(dt.toString(ISODateTimeFormat.dateTime()));
        // try {
        //     String dtString=dt.toString(ISODateTimeFormat.dateTime());
        //     Timestamp ts=Timestamp.parser().parseFrom(dtString.getBytes(StandardCharsets.UTF_8));
        //     System.out.println(ts);
        // } catch (InvalidProtocolBufferException e) {
        //     e.printStackTrace();
        // }
        millis=dt.getMillis();
        Timestamp ts = getTimestamp(millis);
        System.out.println(ts);
    }

    private Timestamp getTimestamp(long millis) {
        return Timestamp.newBuilder().setSeconds(millis / 1000)
                .setNanos((int) ((millis % 1000) * 1000000)).build();
    }

    @Test
    public void testDateTimeParse(){
        String dtStrLong="2001-01-01 12:00:00.0";
        // String dtStr="2001-01-01T12:00:00";
        // DateTimeFormatter parser= ISODateTimeFormat.dateTimeNoMillis();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.S");
        System.out.println(fmt.parseDateTime(dtStrLong));

        String dtStr="2001-05-13 00:00:00";
        fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(fmt.parseDateTime(dtStr));

        System.out.println(dtStrLong.substring(0, dtStr.length()));

        // https://www.joda.org/joda-time/userguide.html#Custom_Formatters
        // if you wanted to use the ISO standard format for datetime, which is yyyy-MM-dd'T'HH:mm:ss.SSSZZ
    }

    // https://stackoverflow.com/questions/1051732/what-is-the-best-approach-for-serializing-bigdecimal-biginteger-to-protocolbuffe
    @Test
    public void testDecimal(){
        java.math.BigDecimal bigDecimal = new java.math.BigDecimal("1234.56789");
        DecimalValue serialized = DecimalValue.newBuilder()
                .setScale(bigDecimal.scale())
                .setPrecision(bigDecimal.precision())
                .setValue(ByteString.copyFrom(bigDecimal.unscaledValue().toByteArray()))
                .build();
        System.out.println(serialized);

        java.math.MathContext mc = new java.math.MathContext(serialized.getPrecision());
        java.math.BigDecimal deserialized = new java.math.BigDecimal(
                new java.math.BigInteger(serialized.getValue().toByteArray()),
                serialized.getScale(),
                mc);
        System.out.println(deserialized);
        assertEquals( bigDecimal, deserialized);
        System.out.println("DecimalValue size: " + serialized.getSerializedSize());
        // System.out.println("String: " + StringValue.of(pi).getSerializedSize());
    }

    @Test
    public void testFieldMeta(){
        DateTime thruDate=DateTime.now();
        DateTime startDate=thruDate.minusDays(10);
        ShipmentTimeEstimateData estimateData=ShipmentTimeEstimateData.newBuilder()
                .setFromDate(getTimestamp(startDate.getMillis()))
                .setThruDate(getTimestamp(thruDate.getMillis()))
                .build();
        for (Map.Entry<Descriptors.FieldDescriptor, Object> fld :
                estimateData.getAllFields().entrySet()) {
            System.out.print(fld.getKey().getName()+", ");
            System.out.print(fld.getKey().getNumber()+", ");
            System.out.println(fld.getValue().toString());
        }

        // estimateData.getAllFields().put(
        // ShipmentTimeEstimateData.getDescriptor();
    }

    @Test
    public void testRepeatedFieldMeta(){
        Descriptors.Descriptor descriptor=OrderItemData.getDescriptor();
        descriptor.getFields().forEach(f ->
                System.out.format("%s, %s\n", f.getName(), f.isRepeated()));

        GeneratedMessageV3.Builder<?> builder=OrderItemData.newBuilder();
        // Descriptors.FieldDescriptor fieldDescriptor = message.getDescriptorForType().findFieldByName("fieldXyz");
        Descriptors.FieldDescriptor fieldDescriptor =descriptor.findFieldByName("order_adjustment");
        OrderAdjustmentData adjustmentData= OrderAdjustmentData.newBuilder()
                .setAmount(DataFill.getCurrencyValue("12.345"))
                .build();
        builder.addRepeatedField(fieldDescriptor, adjustmentData);
        builder.addRepeatedField(fieldDescriptor, OrderAdjustmentData.newBuilder()
                .setAmount(DataFill.getCurrencyValue("34.345"))
                .build());
        System.out.println(builder.build());
        System.out.println(ProtoJsonUtils.toJson(builder.build()));

        OrderItemData orderItemData=(OrderItemData)builder.build();
        orderItemData.getOrderAdjustmentList().forEach(a ->
                System.out.println(ProtoTypes.getBigDecimal(a.getAmount())));
    }

    @Test
    public void testSerializedData() throws InvalidProtocolBufferException {
        ShipmentTimeEstimateData estimateData=createShipmentTime();
        byte[] bytes = estimateData.toByteArray();
        System.out.println(bytes.length);

        ShipmentTimeEstimateData newData=ShipmentTimeEstimateData.parseFrom(bytes);
        System.out.println(newData);
    }

    @Test
    public void testProcessMessageByFindField(){
        ShipmentTimeEstimateData estimateData=createShipmentTime();
        GeneratedMessageV3 msg=estimateData;
        Descriptors.FieldDescriptor fld=msg.getDescriptorForType().findFieldByName("thru_date");
        Timestamp ts=(Timestamp)msg.getField(fld);
        System.out.println(ts);
    }

    private ShipmentTimeEstimateData createShipmentTime() {
        DateTime thruDate=DateTime.now();
        DateTime startDate=thruDate.minusDays(10);
        return ShipmentTimeEstimateData.newBuilder()
                .setFromDate(getTimestamp(startDate.getMillis()))
                .setThruDate(getTimestamp(thruDate.getMillis()))
                .build();
    }

    @Test
    public void testPeriod(){
        DateTime thruDate=DateTime.now();
        DateTime startDate=thruDate.minusDays(10);
        ShipmentTimeEstimateData estimateData=ShipmentTimeEstimateData.newBuilder()
                .setFromDate(getTimestamp(startDate.getMillis()))
                .setThruDate(getTimestamp(thruDate.getMillis()))
                .build();

        DateTime testDate=thruDate.minusDays(5);
        assertTrue(isInPeriod(estimateData, testDate));
        assertFalse(isInPeriod(estimateData, thruDate.minusDays(11)));
    }

    DateTime getDateTime(Timestamp ts){
        return new DateTime(ts.getSeconds()*1000);
    }

    boolean isInPeriod(ShipmentTimeEstimateData estimateData, DateTime dt){
        DateTime start=getDateTime(estimateData.getFromDate());
        DateTime end=getDateTime(estimateData.getThruDate());
        Period period = new Period(start, end);
        // https://www.joda.org/joda-time/key_period.html
        return dt.isAfter(start.toInstant()) && dt.isBefore(end.toInstant());
    }
}

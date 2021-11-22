package com.bluecc.hubs.proto;

import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.Util;
import com.bluecc.hubs.stub.*;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Map;
import java.util.stream.Collectors;

import static com.bluecc.hubs.fund.SeedReader.collectEntityData;
import static com.bluecc.hubs.fund.Util.pretty;

@Slf4j
public class DataFill {

    public static void main(String[] args) {
        String dataFile = "dataset/sample/sales_order.xml";
        Multimap<String, JsonObject> dataList = ArrayListMultimap.create();
        collectEntityData(dataList, dataFile, false);

        DataFill dataFill=new DataFill();
        dataFill.setupData(dataList);
    }

    void setupData(Multimap<String, JsonObject> dataList){
        for (String key : dataList.keySet()) {
            System.out.println(key + ":");
            for (JsonObject jsonObject : dataList.get(key)) {
                // pretty(jsonObject);
                Builder<?> msg=fillData(key, jsonObject);
                if(msg!=null){
                    System.out.println("\t[ok] "+msg.build().toString()
                            .replace("\n", "\n\t"));
                }
            }
        }
    }

    static final String DT_STR="2001-05-13 00:00:00";
    static final DateTimeFormatter FMT = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    public static DateTime trimParse(String dtStr){
        return FMT.parseDateTime(dtStr.substring(0, DT_STR.length()));
    }

    private Timestamp getTimestamp(long millis) {
        return Timestamp.newBuilder().setSeconds(millis / 1000)
                .setNanos((int) ((millis % 1000) * 1000000)).build();
    }

    Timestamp getTimestamp(DateTime dt){
        return getTimestamp(dt.getMillis());
    }

    Timestamp getTimestamp(String dtStr){
        return getTimestamp(trimParse(dtStr));
    }

    public  Builder<?> fillData(String entityName, JsonObject jsonObject) {
        Builder<?> msg=null;
        switch (entityName) {
            case "Party": {
                msg = PartyFlatData.newBuilder();
                convertData(msg, jsonObject, PartyFlatData.getDescriptor());
                break;
            }
            case "Person": {
                msg = PersonFlatData.newBuilder();
                convertData(msg, jsonObject, PersonFlatData.getDescriptor());
                break;
            }
            case "PartyRole": {
                msg = PartyRoleData.newBuilder();
                convertData(msg, jsonObject, PartyRoleData.getDescriptor());
                break;
            }
            case "PartyStatus": {
                msg = PartyStatusData.newBuilder();
                convertData(msg, jsonObject, PartyStatusData.getDescriptor());
                break;
            }
            case "UserLogin": {
                msg = UserLoginData.newBuilder();
                convertData(msg, jsonObject, UserLoginData.getDescriptor());
                break;
            }
            case "UserLoginSecurityGroup": {
                msg = UserLoginSecurityGroupData.newBuilder();
                convertData(msg, jsonObject, UserLoginSecurityGroupData.getDescriptor());
                break;
            }
            case "Product": {
                msg = ProductFlatData.newBuilder();
                convertData(msg, jsonObject, ProductFlatData.getDescriptor());
                break;
            }
            case "ProductPrice": {
                msg = ProductPriceData.newBuilder();
                convertData(msg, jsonObject, ProductPriceData.getDescriptor());
                break;
            }
            default:
                log.warn(".. ignore " + entityName);
        }
        return msg;
    }

    private  void convertData(Builder<?> msg, JsonObject jsonObject, Descriptors.Descriptor descriptor) {
        // System.out.println("field names: "+descriptor.getFields().stream().map(f ->
        //         f.getName()).collect(Collectors.joining(", ")));
        log.info(jsonObject.toString());
        // for (Map.Entry<Descriptors.FieldDescriptor, Object> fld : msg.getAllFields().entrySet()) {
        for (Descriptors.FieldDescriptor fld : descriptor.getFields()) {
            JsonElement val = jsonObject.get(fld.getName());
            // System.out.format("\t%s = %s\n", fld.getName(), val==null?"_":val.getAsString());
            if (val != null) {
                switch (fld.getType()) {
                    case STRING:
                        msg.setField(fld, val.getAsString());
                        // System.out.println("** put "+fld.getName()+" - "+val.getAsString());
                        break;
                    case MESSAGE:
                        setFieldWithMessage(msg, fld, val);
                        break;
                    case ENUM:
                        // System.out.println("\tenum: "+fld.getEnumType().getName());
                        setFieldWithEnum(msg, fld, val);
                        break;
                    default:
                        // throw new RuntimeException("Cannot handle type: "
                        //         + fld.getKey().getType() + ", for field "
                        //         + fld.getKey().getName());
                        log.error("Cannot handle type: "
                                        + fld.getType() + ", for field "
                                        + fld.getName());
                }
            }
        }
    }

    private  void setFieldWithMessage(Builder<?> msg, Descriptors.FieldDescriptor fld, JsonElement val) {
        String msgType=fld.getMessageType().getName();
        switch (msgType){
            case "TypeSymbol":
                TypeSymbol typeSymbol= TypeSymbol.newBuilder()
                        .setTypeName(fld.getName())
                        .setValueId(val.getAsString())
                        .build();
                msg.setField(fld, typeSymbol);
                break;
            case "Timestamp":
                msg.setField(fld, getTimestamp(val.getAsString()));
                break;
            case "DecimalValue":
                java.math.BigDecimal bigDecimal = new java.math.BigDecimal(val.getAsString());
                DecimalValue serialized = DecimalValue.newBuilder()
                        .setScale(bigDecimal.scale())
                        .setPrecision(bigDecimal.precision())
                        .setValue(ByteString.copyFrom(bigDecimal.unscaledValue().toByteArray()))
                        .build();
                msg.setField(fld, serialized);
                break;
            default:
                log.error("\t🚫 "+ fld.getMessageType().getName()+" -> "+val);
        }
    }

    private  void setFieldWithEnum(Builder<?> msg, Descriptors.FieldDescriptor fld, JsonElement val) {
        String msgType=fld.getEnumType().getName();
        switch (msgType){
            case "Indicator":
                String c=val.getAsString();
                Indicator indicator=castIndicator(c);
                msg.setField(fld, indicator.getValueDescriptor());
                break;

            default:
                log.error("\t🚫 "+ fld.getMessageType().getName());
        }
    }

    private Indicator castIndicator(String c) {
        switch (c.toUpperCase()){
            case "Y": return Indicator.YES;
            case "N": return Indicator.NO;
            default:
                return Indicator.UNKNOWN;
        }
    }
}

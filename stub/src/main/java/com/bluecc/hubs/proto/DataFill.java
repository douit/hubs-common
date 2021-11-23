package com.bluecc.hubs.proto;

import com.beust.jcommander.Parameter;
import com.bluecc.hubs.stub.*;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.google.protobuf.Timestamp;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.inject.Inject;
import java.util.Base64;

import static com.bluecc.hubs.fund.SeedReader.collectEntityData;
import static com.bluecc.hubs.proto.ProtoModule.startup;

@Slf4j
public class DataFill {

    // specify the option, the value will be set to false: --flat-mode false
    @Parameter(names = {"--flat-mode", "-f"}, arity = 1)
    boolean flatMode = true;

    public static void main(String[] args) {
        String dataFile = "dataset/sample/sales_order.xml";
        // String dataFile = "dataset/OrderDemoData.xml";
        Multimap<String, JsonObject> dataList = ArrayListMultimap.create();
        collectEntityData(dataList, dataFile, false);

        DataFill dataFill = startup(DataFill.class);
        dataFill.setupData(dataList);
    }

    @Inject
    ProtoMeta protoMeta;
    DataBuilder dataBuilder = new DataBuilder();

    void setupData(Multimap<String, JsonObject> dataList) {
        for (String key : dataList.keySet()) {
            System.out.println(key + ":");
            for (JsonObject jsonObject : dataList.get(key)) {
                // pretty(jsonObject);
                Builder<?> msg = flatMode ? fillDataWithFlatMode(key, jsonObject)
                        : fillDataWithHeadMode(key, jsonObject);
                if (msg != null) {
                    System.out.println("\t[ok] " + msg.build().toString()
                            .replace("\n", "\n\t"));
                }
            }
        }
    }

    static final String DT_STR = "2001-05-13 00:00:00";
    static final DateTimeFormatter FMT = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    public static DateTime trimParse(String dtStr) {
        return FMT.parseDateTime(dtStr.substring(0, DT_STR.length()));
    }

    public static Timestamp getTimestamp(long millis) {
        return Timestamp.newBuilder().setSeconds(millis / 1000)
                .setNanos((int) ((millis % 1000) * 1000000)).build();
    }

    public static Timestamp getTimestamp(DateTime dt) {
        return getTimestamp(dt.getMillis());
    }

    public static Timestamp getTimestamp(String dtStr) {
        return getTimestamp(trimParse(dtStr));
    }

    public Builder<?> fillDataWithHeadMode(String entityName, JsonObject jsonObject) {
        DataBuilder.ProtoBuilder protoBuilder = dataBuilder.procData(entityName, false);
        convertData(entityName, protoBuilder.getBuilder(), jsonObject,
                protoBuilder.getDescriptor());
        return protoBuilder.getBuilder();
    }

    public Builder<?> fillDataWithFlatMode(String entityName, JsonObject jsonObject) {
        Builder<?> msg = null;
        switch (entityName) {
            case "Party": {
                msg = PartyFlatData.newBuilder();
                convertData(entityName, msg, jsonObject, PartyFlatData.getDescriptor());
                break;
            }
            case "Person": {
                msg = PersonFlatData.newBuilder();
                convertData(entityName, msg, jsonObject, PersonFlatData.getDescriptor());
                break;
            }
            case "PartyRole": {
                msg = PartyRoleData.newBuilder();
                convertData(entityName, msg, jsonObject, PartyRoleData.getDescriptor());
                break;
            }
            case "PartyStatus": {
                msg = PartyStatusData.newBuilder();
                convertData(entityName, msg, jsonObject, PartyStatusData.getDescriptor());
                break;
            }
            case "UserLogin": {
                msg = UserLoginData.newBuilder();
                convertData(entityName, msg, jsonObject, UserLoginData.getDescriptor());
                break;
            }
            case "UserLoginSecurityGroup": {
                msg = UserLoginSecurityGroupData.newBuilder();
                convertData(entityName, msg, jsonObject, UserLoginSecurityGroupData.getDescriptor());
                break;
            }
            case "Product": {
                msg = ProductFlatData.newBuilder();
                convertData(entityName, msg, jsonObject, ProductFlatData.getDescriptor());
                break;
            }
            case "ProductPrice": {
                msg = ProductPriceData.newBuilder();
                convertData(entityName, msg, jsonObject, ProductPriceData.getDescriptor());
                break;
            }
            default:
                // log.warn(".. ignore " + entityName);
                DataBuilder.ProtoBuilder protoBuilder = dataBuilder.procData(entityName, true);
                convertData(entityName, protoBuilder.getBuilder(), jsonObject,
                        protoBuilder.getDescriptor());
                msg = protoBuilder.getBuilder();
        }
        return msg;
    }

    private void convertData(String entityName, Builder<?> msg, JsonObject jsonObject, Descriptors.Descriptor descriptor) {
        // System.out.println("field names: "+descriptor.getFields().stream().map(f ->
        //         f.getName()).collect(Collectors.joining(", ")));
        // log.info("{}/{}: {}", entityName, descriptor.getName(), jsonObject.toString());
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
                    case INT64:
                        msg.setField(fld, val.getAsLong());
                        break;
                    case INT32:
                        msg.setField(fld, val.getAsInt());
                        break;
                    case DOUBLE:
                        msg.setField(fld, val.getAsDouble());
                        break;
                    case FLOAT:
                        msg.setField(fld, val.getAsFloat());
                        break;
                    case BYTES:
                        // msg.setField(fld, val.get);
                        setBase64Field(msg, fld, val.getAsString());
                        break;
                    case MESSAGE:
                        setFieldWithMessage(entityName, msg, fld, val);
                        break;
                    case ENUM:
                        // System.out.println("\tenum: "+fld.getEnumType().getName());
                        setFieldWithEnum(msg, fld, val);
                        break;

                    default:
                        throw new RuntimeException("Cannot handle type: "
                                + fld.getType() + ", for field "
                                + fld.getName());
                        // log.error("Cannot handle type: "
                        //                 + fld.getType() + ", for field "
                        //                 + fld.getName());
                }
            }
        }
    }

    private void setBase64Field(Builder<?> msg, Descriptors.FieldDescriptor fld, String asString) {
        byte[] decodedBytes = Base64.getDecoder().decode(asString);
        msg.setField(fld, ByteString.copyFrom(decodedBytes));
    }

    private void setFieldWithMessage(String entityName, Builder<?> msg, Descriptors.FieldDescriptor fld, JsonElement val) {
        String msgType = fld.getMessageType().getName();
        switch (msgType) {
            case "TypeSymbol":
                TypeSymbol typeSymbol = TypeSymbol.newBuilder()
                        .setTypeName(fld.getName())
                        .setValueId(val.getAsString())
                        .build();
                msg.setField(fld, typeSymbol);
                break;
            case "Timestamp":
                msg.setField(fld, getTimestamp(val.getAsString()));
                break;
            case "DecimalValue":
                DecimalValue serialized = getDecimalValue(val);
                msg.setField(fld, serialized);
                break;
            default:
                proessEntityField(entityName, msg, fld, val);
        }
    }

    private void proessEntityField(String entityName, Builder<?> msg, Descriptors.FieldDescriptor fld, JsonElement val) {
        Descriptors.Descriptor descriptor = fld.getMessageType();
        String entityType = descriptor.getOptions().getExtension(RoutinesProto.entityType);
        log.info("process entity field type {}({}), in {}", entityType,
                fld.isRepeated() ? "*" : "1", entityName);

        // TODO 根据值id, 从当前数据集中加载相应的实体值

        log.error("\t🚫 " + fld.getMessageType().getName() + " -> " + val);
        throw new RuntimeException("Cannot handle " + descriptor.getName() + " -> " + val);
    }

    public static DecimalValue getDecimalValue(JsonElement val) {
        return getDecimalValue(val.getAsString());
    }

    public static DecimalValue getDecimalValue(String val) {
        java.math.BigDecimal bigDecimal = new java.math.BigDecimal(val);
        DecimalValue serialized = DecimalValue.newBuilder()
                .setScale(bigDecimal.scale())
                .setPrecision(bigDecimal.precision())
                .setValue(ByteString.copyFrom(bigDecimal.unscaledValue().toByteArray()))
                .build();
        return serialized;
    }

    private void setFieldWithEnum(Builder<?> msg, Descriptors.FieldDescriptor fld, JsonElement val) {
        String msgType = fld.getEnumType().getName();
        switch (msgType) {
            case "Indicator":
                String c = val.getAsString();
                Indicator indicator = castIndicator(c);
                msg.setField(fld, indicator.getValueDescriptor());
                break;

            default:
                log.error("\t🚫 " + fld.getMessageType().getName());
                throw new RuntimeException("Cannot handle " + fld.getMessageType().getName());
        }
    }

    private Indicator castIndicator(String c) {
        switch (c.toUpperCase()) {
            case "Y":
                return Indicator.YES;
            case "N":
                return Indicator.NO;
            default:
                return Indicator.UNKNOWN;
        }
    }
}

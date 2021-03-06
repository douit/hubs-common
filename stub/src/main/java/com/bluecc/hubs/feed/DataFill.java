package com.bluecc.hubs.feed;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.stub.*;
import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.google.protobuf.Message;
import com.google.protobuf.Timestamp;
import com.google.type.Date;
import com.google.type.TimeOfDay;
import jodd.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
import java.util.Base64;
import java.util.Set;
import java.util.stream.Collectors;

import static com.bluecc.hubs.ProtoTypes.*;
import static com.bluecc.hubs.fund.SeedReader.collectEntityData;

/**
 * $ just s proto.DataFill -f sample --source dataset/sample/sales_order.xml --sink redis
 * 127.0.0.1:6379> hgetall ProductPrice
 */
@Slf4j
public class DataFill {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Opts {
        @Parameter(names = {"--silent", "-s"})
        boolean silent;
        // specify the option, the value will be set to false: --flat-mode false
        @Parameter(names = {"--flat-mode", "-l"}, arity = 1)
        boolean flatMode = true;

        @Parameter(names = {"--fn", "-f"})
        String fn = "sample";

        @Parameter(names = {"--source", "-o"})
        String source = "dataset/sample/sales_order.xml";
        @Parameter(names = {"--sink", "-k"})
        String sink = "console";
    }

    public static void main(String[] args) {
        Opts opts = new Opts();
        JCommander.newBuilder()
                .addObject(opts)
                .build()
                .parse(args);

        switch (opts.fn) {
            case "sample": {
                process(opts, opts.source, opts.sink);
                break;
            }
            case "info": {
                System.out.println("Support sinks: console, redis");
                break;
            }
            default:
                System.out.println("Cannot handle fn " + opts.fn);
        }
    }

    private static void process(Opts opts, String source, String sink) {
        // String dataFile = "dataset/sample/sales_order.xml";
        // String dataFile = "dataset/OrderDemoData.xml";
        Multimap<String, JsonObject> dataList = ArrayListMultimap.create();
        collectEntityData(dataList, source, false);

        // DataFill dataFill = startup(DataFill.class);
        DataFill dataFill = new DataFill(opts);
        switch (sink) {
            case "console":
                printMessages(dataList, dataFill);
                break;
            case "redis":
                pushToRedis(dataList, dataFill);
                break;
            default:
                System.out.println("Unknown sink target " + sink);
        }
    }

    private static void printMessages(Multimap<String, JsonObject> dataList, DataFill dataFill) {
        dataFill.setupData(dataList).asMap()
                .forEach((key, msgs) -> {
                    System.out.println(key + ":");
                    msgs.forEach(msg ->
                            System.out.println("\t[ok] " +
                                    ProtoTypes.getEntityIden(msg, ":") + "; " +
                                    msg.toString().replace("\n", "\n\t")));
                });
    }

    private static void pushToRedis(Multimap<String, JsonObject> dataList, DataFill dataFill) {
        FactBag factBag = ProtoModule.startup(FactBag.class);

        dataFill.setupData(dataList).asMap()
                .forEach((key, msgs) -> {
                    System.out.println(key + ":");
                    msgs.forEach(msg -> {
                        System.out.println("\t[ok] " +
                                ProtoTypes.getEntityIden(msg, ":") + "; " +
                                msg.toString().replace("\n", "\n\t"));
                        factBag.putEntityData(key, msg);
                    });
                });
        factBag.getSharedData().shutdown();
    }

    DataBuilder dataBuilder = new DataBuilder();
    Opts opts;

    public DataFill() {
        this(new Opts());
    }

    DataFill(Opts opts) {
        this.opts = opts;
    }

    public Multimap<String, Message> setupData(Multimap<String, JsonObject> dataList) {
        Multimap<String, Message> result = ArrayListMultimap.create();
        for (String key : dataList.keySet()) {
            // System.out.println(key + ":");
            for (JsonObject jsonObject : dataList.get(key)) {
                // pretty(jsonObject);
                Builder<?> msgBuilder = opts.flatMode ? fillDataWithFlatMode(key, jsonObject)
                        : fillDataWithHeadMode(key, jsonObject);
                if (msgBuilder != null) {
                    Message msg=msgBuilder.build();
                    result.put(key, msg);
                    // log.info("input json: {}", jsonObject); // ok
                    // log.info("(flat: {}) key {} -> {}", opts.flatMode, key, msg);
                }
            }
        }
        return result;
    }

    public Builder<?> fillDataWithHeadMode(String entityName, JsonObject jsonObject) {
        DataBuilder.ProtoBuilder protoBuilder = dataBuilder.procData(entityName, false);
        convertData(entityName, protoBuilder.getBuilder(), jsonObject,
                protoBuilder.getDescriptor());
        return protoBuilder.getBuilder();
    }

    public Builder<?> fillDataWithFlatMode(String entityName, JsonObject jsonObject) {
        Builder<?> msg = null;
        // log.warn(".. ignore " + entityName);
        DataBuilder.ProtoBuilder protoBuilder = dataBuilder.procData(entityName, true);
        convertData(entityName, protoBuilder.getBuilder(), jsonObject,
                protoBuilder.getDescriptor());
        msg = protoBuilder.getBuilder();
        return msg;
    }

    private void convertData(String entityName, Builder<?> msg, JsonObject jsonObject, Descriptors.Descriptor descriptor) {
        // for debug
        if(entityName.equals("UserLogin")) {
            Set<String> flds=descriptor.getFields().stream().map(f ->
                    f.getName()).collect(Collectors.toSet());
            log.debug("descriptor for {}", descriptor.getName());
            log.debug("field names: " + String.join(", ", flds));
            Preconditions.checkArgument(flds.contains("party_id"), "field party_id?");
        }

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
                        try {
                            msg.setField(fld, val.getAsLong());
                        } catch (NumberFormatException e) {
                            log.warn("entity {} field {} has invalidate value, cause a error {}, set it to default 0",
                                    entityName, fld.getName(), e.getMessage());
                            msg.setField(fld, 0L);
                        }
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
        if (StringUtil.isNotEmpty(val.getAsString())) {
            switch (msgType) {
                case "TypeSymbol":
                    TypeSymbol typeSymbol = TypeSymbol.newBuilder()
                            .setTypeName(fld.getName())
                            .setValueId(val.getAsString())
                            .build();
                    msg.setField(fld, typeSymbol);
                    break;
                case "Timestamp":
                    Timestamp ts = getTimestamp(val.getAsString());
                    if (ts != null) {
                        msg.setField(fld, ts);
                    }
                    break;
                // case "Date":
                //     msg.setField(fld, getDate(val.getAsString()));
                //     break;
                case "TimeOfDay":
                    TimeOfDay timeOfDay=ProtoTypes.getTimeOfDay(LocalTime.parse(val.getAsString()));
                    msg.setField(fld, timeOfDay);
                    break;
                case "Date":
                    Date dt=ProtoTypes.getDate(val.getAsString());
                    msg.setField(fld, dt);
                    break;
                case "DecimalValue":
                    DecimalValue serialized = getDecimalValue(val);
                    msg.setField(fld, serialized);
                    break;
                case "Currency":
                    msg.setField(fld, getCurrencyValue(val.getAsString()));
                    break;
                case "FixedPoint":
                    try {
                        msg.setField(fld, getFixedPoint(val.getAsString()));
                    } catch (NumberFormatException e) {
                        log.warn("entity {} field {} value is invalidate number format: {}, cause: {}",
                                entityName, fld.getName(), val.getAsString(), e.getMessage());
                    }
                    break;
                default:
                    proessEntityField(entityName, msg, fld, val);
            }
        }
    }

    private void proessEntityField(String entityName, Builder<?> msg, Descriptors.FieldDescriptor fld, JsonElement val) {
        Descriptors.Descriptor descriptor = fld.getMessageType();
        String entityType = descriptor.getOptions().getExtension(RoutinesProto.entityType);
        log.info("process entity field type {}({}), in {}", entityType,
                fld.isRepeated() ? "*" : "1", entityName);

        // TODO ?????????id, ?????????????????????????????????????????????

        log.error("\t???? " + fld.getMessageType().getName() + " -> " + val);
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

    public static Currency getCurrencyValue(String val) {
        Currency serialized = Currency.newBuilder().setValue(val).build();
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
                log.error("\t???? " + fld.getMessageType().getName());
                throw new RuntimeException("Cannot handle " + fld.getMessageType().getName());
        }
    }

}

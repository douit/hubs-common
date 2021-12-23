package com.bluecc.hubs;

import com.bluecc.hubs.fund.MetaTypes;
import com.bluecc.hubs.fund.Util;
import com.bluecc.hubs.feed.DataBuilder;
import com.bluecc.hubs.stub.*;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.protobuf.*;
import com.google.protobuf.StringValue;
import com.google.type.Date;
import com.google.type.Money;
import com.google.type.TimeOfDay;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
// import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class ProtoTypes {
    public static java.math.BigDecimal getBigDecimal(DecimalValue serialized) {
        java.math.MathContext mc = new java.math.MathContext(serialized.getPrecision());
        java.math.BigDecimal deserialized = new java.math.BigDecimal(
                new java.math.BigInteger(serialized.getValue().toByteArray()),
                serialized.getScale(),
                mc);
        return deserialized;
    }

    public static java.math.BigDecimal getBigDecimal(Currency serialized) {
        try {
            return new BigDecimal(serialized.getValue());
        } catch (NumberFormatException e) {
            log.warn("Cannot parse value as decimal '{}'", serialized.getValue());
            return BigDecimal.ZERO;
        }
    }

    public static Currency getCurrency(String val) {
        return getCurrency(new BigDecimal(val));
    }

    public static Currency getCurrency(java.math.BigDecimal val) {
        return Currency.newBuilder()
                .setCurrencyUomId("CNY")
                .setValue(val.toString())
                .build();
    }

    // public static FixedPoint getFixedPoint(java.math.BigDecimal val){
    //     return FixedPoint.newBuilder()
    //             .setValue(val.toString())
    //             .build();
    // }

    protected static Money toGoogleMoney(final BigDecimal decimal) {
        return Money.newBuilder()
                .setCurrencyCode("USD")
                .setUnits(decimal.longValue())
                .setNanos(decimal.remainder(BigDecimal.ONE).movePointRight(decimal.scale()).intValue())
                .build();
    }

    public static BigDecimal getBigDecimal(FixedPoint fixedPoint) {
        BigDecimal val = new BigDecimal(fixedPoint.getValue())
                .movePointLeft(fixedPoint.getScalingPosition());
        return val;
    }

    public static FixedPoint getFixedPoint(BigDecimal val) {
        return FixedPoint.newBuilder()
                .setValue(val.longValue())
                .setScalingPosition(val.scale())
                .build();
    }

    public static FixedPoint getFixedPoint(String val) {
        return getFixedPoint(new BigDecimal(val));
    }

    // public static DateTime getDateTime(Timestamp ts) {
    //     return new DateTime(ts.getSeconds() * 1000);
    // }

    public static java.time.LocalTime getTime(TimeOfDay timeOfDay) {
        return LocalTime.of(timeOfDay.getHours(),
                timeOfDay.getMinutes(),
                timeOfDay.getSeconds(),
                timeOfDay.getNanos());
    }

    public static java.time.LocalDateTime getLocalDateTime(Timestamp ts) {
        return java.time.LocalDateTime.ofEpochSecond(ts.getSeconds(),
                ts.getNanos(), ZoneOffset.UTC);
    }

    public static Date nowDate() {
        return getDate(LocalDate.now());
    }

    public static Timestamp now() {
        long millis = System.currentTimeMillis();
        Timestamp timestamp = Timestamp.newBuilder().setSeconds(millis / 1000)
                .setNanos((int) ((millis % 1000) * 1000000)).build();
        return timestamp;
    }

    // public static Timestamp getTimestamp(LocalDate dt) {
    //     return getTimestamp()
    // }

    public static com.google.type.Date getDate(String localDate) {
        return getDate(LocalDate.parse(localDate));
    }

    public static com.google.type.Date getDate(LocalDate localDate) {
        if (localDate != null) {
            return Date.newBuilder()
                    .setYear(localDate.getYear())
                    .setMonth(localDate.getMonthValue())
                    .setDay(localDate.getDayOfMonth())
                    .build();
        }
        return null;
    }

    public static TimeOfDay getTimeOfDay(String localTime) {
        return getTimeOfDay(LocalTime.parse(localTime));
    }

    public static TimeOfDay getTimeOfDay(LocalTime localTime) {
        if (localTime != null) {
            TimeOfDay timeOfDay = TimeOfDay.newBuilder()
                    .setHours(localTime.getHour())
                    .setMinutes(localTime.getMinute())
                    .setSeconds(localTime.getSecond())
                    .setNanos(localTime.getNano())
                    .build();
            return timeOfDay;
        }
        return null;
    }

    public static Timestamp getTimestamp(LocalDateTime dt) {
        return getTimestamp(dt.toInstant(ZoneOffset.UTC));
    }

    public static Timestamp getTimestamp(Instant ts) {
        Timestamp timestamp = Timestamp.newBuilder().setSeconds(ts.getEpochSecond())
                .setNanos(ts.getNano()).build();
        return timestamp;
    }


    static final String DT_STR = "2001-05-13 00:00:00";
    static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static LocalDateTime trimParse(String dtStr) {
        if (dtStr == null || dtStr.isEmpty()) {
            return null;
        }

        if (dtStr.length() < DT_STR.length()) {
            log.warn("the datetime-string format is invalidate: {}", dtStr);
            return null;
        }
        // return FMT.parseDateTime(dtStr.substring(0, DT_STR.length()));
        return LocalDateTime.parse(dtStr.substring(0, DT_STR.length()), FMT);
    }

    public static Timestamp getTimestamp(long millis) {
        return Timestamp.newBuilder().setSeconds(millis / 1000)
                .setNanos((int) ((millis % 1000) * 1000000)).build();
    }

    static final ZoneOffset offsetLocal = ZoneOffset.systemDefault().getRules().getOffset(LocalDateTime.now());

    public static Timestamp getTimestampAtLocal(LocalDateTime dt) {
        return ProtoTypes.getTimestamp(dt.toInstant(offsetLocal));
    }

    public static Timestamp nowTimestamp() {
        return getTimestamp(LocalDateTime.now());
    }

    public static Timestamp getTimestamp(String dtStr) {
        if (dtStr == null || dtStr.isEmpty()) {
            return null;
        }
        return getTimestamp(trimParse(dtStr));
    }


    public static java.time.LocalDate getLocalDate(Timestamp ts) {
        return getLocalDateTime(ts).toLocalDate();
    }

    public static java.time.LocalDate getLocalDate(com.google.type.Date dt) {
        return java.time.LocalDate.of(dt.getYear(), dt.getMonth(), dt.getDay());
    }

    public static Indicator getIndicator(Character c) {
        return castIndicator(c.toString());
    }

    public static Indicator castIndicator(String c) {
        switch (c.toUpperCase()) {
            case "Y":
                return Indicator.YES;
            case "N":
                return Indicator.NO;
            default:
                Indicator indicator;
                char firstChar = c.charAt(0);
                if (Character.isUpperCase(firstChar)) {
                    indicator = Indicator.valueOf(c);
                } else {
                    indicator = Indicator.forNumber(Integer.parseInt(c));
                }
                if (indicator == null) {
                    indicator = Indicator.UNKNOWN;
                }
                return indicator;
        }
    }

    public static char getIndicatorChar(Indicator indicator) {
        switch (indicator) {
            case YES:
                return 'Y';
            case NO:
                return 'N';
            case UNKNOWN:
                return ' ';
            default:
                if (indicator.getNumber() >= 65 && indicator.getNumber() <= 72) {
                    return (char) indicator.getNumber();
                }
                return String.valueOf(indicator.getNumber()).charAt(0);
        }
    }

    public static String getTableByMessage(Message msg) {
        return Util.toSnakecase(getEntityTypeByMessage(msg));
    }

    public static String getEntityTypeByMessage(Message msg, String defaultName) {
        String name = getEntityTypeByMessage(msg);
        if (name.isEmpty()) {
            return defaultName;
        }
        return name;
    }

    public static String getEntityTypeByMessage(Message msg) {
        Descriptors.Descriptor descriptor = msg.getDescriptorForType();
        return getEntityType(descriptor);
    }

    public static String getEntityType(Descriptors.Descriptor descriptor) {
        String entityType = descriptor.getOptions().getExtension(RoutinesProto.entityType);
        return entityType;
    }

    public static boolean isFlatMessage(Message msg) {
        Descriptors.Descriptor descriptor = msg.getDescriptorForType();
        boolean flat = descriptor.getOptions().getExtension(RoutinesProto.flat);
        return flat;
    }

    public static boolean isCombine(Message msg) {
        EntityKey keys = msg.getDescriptorForType().getOptions().getExtension(RoutinesProto.keys);
        return keys.getCombine();
    }

    public static boolean hasTable(Message msg) {
        return MetaTypes.hasTable(getEntityTypeByMessage(msg));
    }

    public static Set<String> getEntityKeySet(Message msg) {
        return Arrays.stream(getEntityKeys(msg))
                .collect(Collectors.toSet());
    }

    public static String[] getEntityKeys(Message msg) {
        EntityKey keys = msg.getDescriptorForType().getOptions().getExtension(RoutinesProto.keys);
        return keys.getKeys().split(", ");
    }

    public static void setEntityKey(Message.Builder builder, String idVal) {
        Descriptors.Descriptor descriptor = builder.getDescriptorForType();
        String fldName = getEntityKeys(descriptor)[0];
        builder.setField(descriptor.findFieldByName(fldName), idVal);
    }

    public static String[] getEntityKeys(Descriptors.Descriptor descriptor) {
        EntityKey keys = descriptor.getOptions().getExtension(RoutinesProto.keys);
        return keys.getKeys().split(", ");
    }

    public static String getEntityIden(Message msg, String delimiter) {
        List<String> result = getEntityIdenValues(msg);
        return String.join(delimiter, result);
    }

    public static List<String> getEntityIdenValues(Message msg) {
        Descriptors.Descriptor descriptor = msg.getDescriptorForType();
        List<String> result = Lists.newArrayList();
        for (String entityKey : getEntityKeys(msg)) {
            // log.info(".. entity-iden "+entityKey);
            Object val = msg.getField(descriptor.findFieldByName(entityKey));
            result.add(val.toString());
        }
        return result;
    }

    public static Envelope packGeneral(String dataType, Message protoMess) {
        Envelope envelope = Envelope.newBuilder()
                .setDataType(dataType)
                .setData(Any.pack(protoMess))
                .build();
        return envelope;
    }

    public static Envelope packEntity(Message protoMess) {
        Envelope envelope = Envelope.newBuilder()
                .setDataType(getEntityTypeByMessage(protoMess))
                .setData(Any.pack(protoMess))
                .setFlat(isFlatMessage(protoMess))
                .build();
        return envelope;
    }

    public static Envelope packString(String value) {
        return Envelope.newBuilder()
                .setDataType("string")
                .setData(Any.pack(StringValue.newBuilder()
                        .setValue(value)
                        .build()))
                .build();
    }

    public static Envelope packValueMap(Map<String, Value> map){
        Struct struct= Struct.newBuilder()
                .putAllFields(map)
                .build();
        return Envelope.newBuilder()
                .setDataType("value-map")
                .setData(Any.pack(struct))
                .build();
    }

    public static byte[] serializeEntityWithEnvelope(Message protoMess) {
        return packEntity(protoMess).toByteArray();
    }

    public static Message.Builder extractEnvelopeData(Envelope request) throws InvalidProtocolBufferException {
        Message msg = unpackEntity(request);
        Message.Builder builder = DataBuilder.procData(request.getDataType(),
                false, msg).getBuilder();
        return builder;
    }

    public static Message unpackEntity(Envelope request) throws InvalidProtocolBufferException {
        Any any = request.getData();
        Class<? extends Message> entityClass =
                DataBuilder.getEntityClass(request.getDataType(), request.getFlat());
        Message msg = any.unpack(entityClass);
        return msg;
    }

    public static Try<Map<String, Value>> unpackValueMap(Envelope request) {
        Any any = request.getData();
        return Try.of(()-> any.unpack(Struct.class).getFieldsMap());
    }

    public static Try<String> unpackString(Envelope request) {
        return Try.of(()-> {
            Any any = request.getData();
            Preconditions.checkArgument(any.is(StringValue.class),
                    "pack-object is not string value");
            return any.unpack(StringValue.class).getValue();
        });
    }

    public static Message deserializeEntityWithEnvelope(byte[] cnt) throws InvalidProtocolBufferException {
        Envelope envelope = Envelope.parseFrom(cnt);
        return unpackEntity(envelope);
    }

    public static List<String> getFilledFieldNames(Message message) {
        return message.getAllFields().keySet().stream()
                .map(f -> f.getName())
                .collect(Collectors.toList());
    }

    public static boolean hasFieldValue(Message toData, String fld) {
        return getFilledFieldNames(toData).contains(fld);
    }
}


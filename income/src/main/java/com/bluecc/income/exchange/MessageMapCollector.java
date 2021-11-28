package com.bluecc.income.exchange;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.stub.*;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Message;
import com.google.protobuf.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static com.bluecc.hubs.ProtoTypes.getFixedPoint;

// @Slf4j
public class MessageMapCollector {
    private static final Logger log = LoggerFactory.getLogger(MessageMapCollector.class);

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResultData{
        List<String> relatedFields;
        String childId;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SlaveData{
        Map<String, Object> keys;
    }

    public Map<String, ResultData> getResultContext() {
        return resultContext;
    }

    private final Map<String, ResultData> resultContext=Maps.newConcurrentMap();
    private Multimap<String, SlaveData> slaveContext= ArrayListMultimap.create();

    // private List<IProc> procs= Lists.newArrayList();
    IMapDataCollector collector;

    public MessageMapCollector(IMapDataCollector collector) {
        this.collector = collector;
    }

    public static MessageMapCollector collect(IMapDataCollector collector) {
        return new MessageMapCollector(collector);
    }

    public Map<String, ResultData> fillMap(Message msg) {
        fillMap(null, null, msg);
        return resultContext;
    }

    public void fillMap(Message parentMsg,
                        Descriptors.FieldDescriptor parentFld,
                        Message msg) {
        Map<String, Object> dataMap = Maps.newHashMap();
        Descriptors.Descriptor descriptor = msg.getDescriptorForType();
        String entityType = descriptor.getOptions().getExtension(RoutinesProto.entityType);
        EntityNames symbol = EntityNames.valueOfType(entityType);
        String resultFld = parentFld == null ? "_" : parentFld.getName();
        log.info("** process {}({}) => {}, {}", entityType, resultFld, symbol, symbol.getTableKeys());

        Map<Descriptors.FieldDescriptor, Object> allFields = msg.getAllFields();
        // System.out.println(allFields.keySet().stream().map(f -> f.getName())
        //         .collect(Collectors.toList()));
        for (Map.Entry<Descriptors.FieldDescriptor, Object> objectEntry : allFields.entrySet()) {
            Descriptors.FieldDescriptor fld = objectEntry.getKey();
            Object fldVal = objectEntry.getValue();
            // for (Descriptors.FieldDescriptor fld : descriptor.getFields())
            switch (fld.getType()) {
                case STRING:
                case INT64:
                case INT32:
                case DOUBLE:
                case FLOAT:
                case BYTES:
                    dataMap.put(fld.getName(), fldVal); // keep
                    break;
                case MESSAGE:
                    getMessageField(msg, fld, fldVal, dataMap);
                    break;
                case ENUM:
                    getEnumField(msg, fld, fldVal, dataMap);
                    break;
                default:
                    throw new RuntimeException("Cannot handle type: "
                            + fld.getType() + ", for field "
                            + fld.getName());
            }
        }
        this.collector.collect(new IMapDataCollector.CollectorContext(this,
                        symbol, parentMsg, parentFld),
                dataMap);
    }

    private void getMessageField(Message msg,
                                 Descriptors.FieldDescriptor fld,
                                 Object fldVal,
                                 Map<String, Object> dataMap) {
        String msgType = fld.getMessageType().getName();
        String fldName = fld.getName();
        switch (msgType) {
            case "TypeSymbol":
                TypeSymbol symbol = (TypeSymbol) fldVal;
                dataMap.put(fldName, symbol.getValueId());
                break;
            case "Timestamp": {
                Timestamp val = (Timestamp) fldVal;
                dataMap.put(fldName, ProtoTypes.getDateTime(val));
                break;
            }
            case "Currency": {
                Currency val = (Currency) fldVal;
                log.debug("-> currency value " + val.getValue());
                System.out.println("-> currency value " + val.getValue() + ", field: " + fld.getName());
                dataMap.put(fldName, new BigDecimal(val.getValue()));
                break;
            }
            case "FixedPoint":
                dataMap.put(fldName, ProtoTypes.getBigDecimal((FixedPoint) fldVal));
                break;
            default:
                getEntityField(msg, fld, fldVal);
        }
    }

    private void getEnumField(Message msg,
                              Descriptors.FieldDescriptor fld,
                              Object fldVal,
                              Map<String, Object> dataMap) {
        String msgType = fld.getEnumType().getName();
        switch (msgType) {
            case "Indicator":
                dataMap.put(fld.getName(),
                        ProtoTypes.getIndicatorChar((Indicator) fldVal));
                break;

            default:
                log.error("\t🚫 " + fld.getMessageType().getName());
                throw new RuntimeException("Cannot handle " + fld.getMessageType().getName());
        }
    }

    private void getEntityField(Message parentMsg,
                                Descriptors.FieldDescriptor fld,
                                Object fldVal) {
        log.info("field value type is {}, message type is{}, and repeated: {}",
                fldVal.getClass().getName(),
                fld.getMessageType().getName(),
                fld.isRepeated());
        if(fld.isRepeated()){
            for(GeneratedMessageV3 val:(Collection<GeneratedMessageV3>)fldVal){
                MessageMapCollector messageMapCollector =
                        new MessageMapCollector(this.collector);
                messageMapCollector.fillMap(parentMsg, fld, val);
                slaveContext.putAll(messageMapCollector.slaveContext);
            }
        }else {
            MessageMapCollector messageMapCollector = new MessageMapCollector(this.collector);
            messageMapCollector.fillMap(parentMsg, fld, (GeneratedMessageV3) fldVal);
            resultContext.putAll(messageMapCollector.getResultContext());
        }
    }

    public void putResult(String name, List<String> tableFields, String idval) {
        resultContext.put(name, new ResultData(tableFields, idval));
    }

    public void putSlave(String name, Map<String, Object> keys){
        this.slaveContext.put(name, new SlaveData(keys));
    }
}


package com.bluecc.income.exchange;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.stub.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.JsonElement;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Timestamp;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.bluecc.hubs.ProtoTypes.getFixedPoint;

// @Slf4j
public class MessageMapCollector {
    private static final Logger log = LoggerFactory.getLogger(MessageMapCollector.class);

    // private List<IProc> procs= Lists.newArrayList();
    IMapDataCollector collector;
    public MessageMapCollector(IMapDataCollector collector) {
        this.collector=collector;
    }

    public static MessageMapCollector collect(IMapDataCollector collector){
        return new MessageMapCollector(collector);
    }

    public void fillMap(GeneratedMessageV3 msg) {
        fillMap(null, null, msg);
    }
    public void fillMap(GeneratedMessageV3 parentMsg,
                        Descriptors.FieldDescriptor parentFld,
                        GeneratedMessageV3 msg) {
        Map<String, Object> dataMap= Maps.newHashMap();
        Descriptors.Descriptor descriptor = msg.getDescriptorForType();
        String entityType=descriptor.getOptions().getExtension(RoutinesProto.entityType);
        EntityNames symbol=EntityNames.valueOfType(entityType);
        String resultFld=parentFld==null?"_":parentFld.getName();
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
        this.collector.collect(new IMapDataCollector.CollectorContext(
                symbol, parentMsg, parentFld),
                dataMap);
    }

    private void getMessageField(GeneratedMessageV3 msg,
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

    private void getEnumField(GeneratedMessageV3 msg,
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

    private void getEntityField(GeneratedMessageV3 parentMsg,
                                Descriptors.FieldDescriptor fld,
                                Object fldVal) {
        MessageMapCollector messageMapCollector=new MessageMapCollector(this.collector);
        messageMapCollector.fillMap(parentMsg, fld, (GeneratedMessageV3)fldVal);
    }
}


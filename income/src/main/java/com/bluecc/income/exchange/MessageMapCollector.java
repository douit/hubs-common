package com.bluecc.income.exchange;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.stub.*;
import com.google.common.collect.Lists;
import com.google.gson.JsonElement;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Timestamp;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static com.bluecc.hubs.ProtoTypes.getFixedPoint;

@Slf4j
public class MessageMapCollector {
    private List<IProc> procs= Lists.newArrayList();
    MessageMapCollector(){

    }
    public void fillMap(GeneratedMessageV3 msg, Map<String, Object> dataMap) {
        Descriptors.Descriptor descriptor = msg.getDescriptorForType();
        for (Descriptors.FieldDescriptor fld : descriptor.getFields()) {
            switch (fld.getType()) {
                case STRING:
                case INT64:
                case INT32:
                case DOUBLE:
                case FLOAT:
                case BYTES:
                    dataMap.put(fld.getName(), msg.getField(fld)); // keep
                    break;
                case MESSAGE:
                    getMessageField(msg, fld, dataMap);
                    break;
                case ENUM:
                    getEnumField(msg, fld, dataMap);
                    break;
                default:
                    throw new RuntimeException("Cannot handle type: "
                            + fld.getType() + ", for field "
                            + fld.getName());
            }
        }
    }

    private void getMessageField(GeneratedMessageV3 msg,
                                 Descriptors.FieldDescriptor fld,
                                 Map<String, Object> dataMap) {
        String msgType = fld.getMessageType().getName();
        String fldName = fld.getName();
        switch (msgType) {
            case "TypeSymbol":
                TypeSymbol symbol = (TypeSymbol) msg.getField(fld);
                dataMap.put(fldName, symbol.getValueId());
                break;
            case "Timestamp": {
                Timestamp val = (Timestamp) msg.getField(fld);
                dataMap.put(fldName, ProtoTypes.getDateTime(val));
                break;
            }
            case "Currency": {
                Currency val = (Currency) msg.getField(fld);
                dataMap.put(fldName, new BigDecimal(val.getValue()));
                break;
            }
            case "FixedPoint":
                dataMap.put(fldName, ProtoTypes.getBigDecimal((FixedPoint) msg.getField(fld)));
                break;
            default:
                getEntityField(msg, fld, dataMap);
        }
    }

    private void getEnumField(GeneratedMessageV3 msg,
                              Descriptors.FieldDescriptor fld,
                              Map<String, Object> dataMap) {
        String msgType = fld.getEnumType().getName();
        switch (msgType) {
            case "Indicator":
                dataMap.put(fld.getName(),
                        ProtoTypes.getIndicatorChar((Indicator) msg.getField(fld)));
                break;

            default:
                log.error("\t🚫 " + fld.getMessageType().getName());
                throw new RuntimeException("Cannot handle " + fld.getMessageType().getName());
        }
    }

    private void getEntityField(GeneratedMessageV3 msg,
                                Descriptors.FieldDescriptor fld,
                                Map<String, Object> dataMap) {

    }
}

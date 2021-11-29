package com.bluecc.income.exchange;

import com.google.common.collect.Maps;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class FlatMessageCollector extends MessageMapCollector{
    public FlatMessageCollector() {
        super(null, new TravelContext());
    }

    public static Map<String, Object> extract(Message msg){
        return new FlatMessageCollector().extractFromMessage(msg);
    }

    public Map<String, Object> extractFromMessage(Message msg){
        Map<String, Object> map= Maps.newHashMap();
        extractToMap(msg, map);
        return map;
    }

    @Override
    protected void getEntityField(Message parentMsg,
                                  Descriptors.FieldDescriptor fld,
                                  Object fldVal) {
        log.error("field value type is {}, message type is{}, and repeated: {}",
                fldVal.getClass().getName(),
                fld.getMessageType().getName(),
                fld.isRepeated());
        throw new RuntimeException("Cannot handle field message type: "
                +fld.getMessageType().getName());
    }
}

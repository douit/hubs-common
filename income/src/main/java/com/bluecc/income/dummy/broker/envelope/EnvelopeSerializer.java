package com.bluecc.income.dummy.broker.envelope;

import com.bluecc.hubs.ProtoTypes;
import com.google.protobuf.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

@Slf4j
public class EnvelopeSerializer implements Serializer<Message> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, Message data) {
        try {
            if (data == null){
                log.warn("Null received at serializing");
                return null;
            }
            log.debug("Serializing...");
            return ProtoTypes.serializeEntityWithEnvelope(data);
        } catch (Exception e) {
            throw new SerializationException("Error when serializing Message to byte[]");
        }
    }

    @Override
    public void close() {
    }
}

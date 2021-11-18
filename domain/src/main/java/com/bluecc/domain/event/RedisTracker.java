package com.bluecc.domain.event;

import com.bluecc.domain.guice.EventData;
import com.bluecc.domain.guice.IEventProvider;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import javax.inject.Singleton;

@Singleton
@Slf4j
public class RedisTracker implements IEventProvider {
    public enum EventType{
        SUCCESS, FAIL, END
    }
    @Data
    @Builder
    public static class EventMessage {
        EventType eventType;
        EventData eventData;
        Object eventObject;
        String errorMessage;
    }

    RedissonClient client;

    RedisTracker() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://127.0.0.1:6379");

        client = Redisson.create(config);
    }

    @Override
    public void onSuccess(EventData eventData, Object eventObject) {
        RTopic publishTopic = client.getTopic(eventData.getEventName());
        long clientsReceivedMessage
                = publishTopic.publish(EventMessage.builder()
                        .eventType(EventType.SUCCESS)
                .eventData(eventData)
                .eventObject(eventObject)
                .build());
        log.info("✔ clients received message: {}", clientsReceivedMessage);
    }

    @Override
    public void onFail(EventData eventData, Exception e) {
        RTopic publishTopic = client.getTopic(eventData.getEventName());
        long clientsReceivedMessage
                = publishTopic.publish(EventMessage.builder()
                .eventType(EventType.FAIL)
                .eventData(eventData)
                .errorMessage(e.getMessage())
                .build());
        log.info("✖ clients received message: {}", clientsReceivedMessage);
    }

    @Override
    public void onEnd(EventData eventData) {
        RTopic publishTopic = client.getTopic(eventData.getEventName());
        long clientsReceivedMessage
                = publishTopic.publish(EventMessage.builder()
                .eventType(EventType.END)
                .eventData(eventData)
                .build());
        log.info("▍ clients received message: {}", clientsReceivedMessage);
    }
}

package com.bluecc.income.procs;

import com.bluecc.hubs.feed.LiveObjects;
import com.bluecc.hubs.stub.Envelope;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RTopic;
import org.redisson.api.listener.MessageListener;

import javax.inject.Inject;
import java.util.List;
import java.util.function.Consumer;

@Slf4j
public class EventBus {
    @Data
    @AllArgsConstructor
    static class Observer implements MessageListener<byte[]>{
        String topic;
        Consumer<Envelope> consumer;

        @Override
        public void onMessage(CharSequence channel, byte[] msg) {
            try {
                consumer.accept(Envelope.parseFrom(msg));
            } catch (InvalidProtocolBufferException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    @Inject
    LiveObjects liveObjects;
    List<Observer> observerList;
    public void subscribe(String topicName, Consumer<Envelope> consumer){
        RTopic topic = liveObjects.redisson().getTopic(topicName);
        topic.addListener(byte[].class, new Observer(topicName, consumer));
    }

    /**
     *
     * @param topicName topic name
     * @param data message data
     * @return the number of clients that received the message
     */
    public long send(String topicName, Envelope data){
        RTopic topic = liveObjects.redisson().getTopic(topicName);
        return topic.publish(data.toByteArray());
    }
}

package com.bluecc.income.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class Sender {
    // private static final String MODULE = InfoProducer.class.getName();
    private final KafkaProducer<String, String> producer;
    private final String topic;
    private final Boolean isAsync;

    public static final String KAFKA_SERVER_URL = "localhost";
    public static final int KAFKA_SERVER_PORT = 9092;
    public static final String CLIENT_ID = "hubsProducer";
    AtomicLong messageNo = new AtomicLong(1);

    public Sender(String topic, Boolean isAsync) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", KAFKA_SERVER_URL + ":" + KAFKA_SERVER_PORT);
        properties.put("client.id", CLIENT_ID);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<>(properties);
        this.topic = topic;
        this.isAsync = isAsync;
    }

    public String send(String messageStr) {
        long messageNumber = messageNo.getAndIncrement();
        long startTime = System.currentTimeMillis();
        ProducerRecord<String, String> rec = new ProducerRecord<>(topic,
                Long.toString(messageNumber), messageStr);
        String calluid=UUID.randomUUID().toString();
        byte[] callid=calluid.getBytes(StandardCharsets.UTF_8);
        rec.headers().add("serial", Long.toString(messageNumber).getBytes(StandardCharsets.UTF_8))
                .add("type", "application/json".getBytes(StandardCharsets.UTF_8))
                .add("fn", "service".getBytes(StandardCharsets.UTF_8))
                .add("callid", callid);

        if (isAsync) { // Send asynchronously
            producer.send(rec, new KafkaCallBack(startTime, messageNumber, messageStr));
        } else { // Send synchronously
            try {
                producer.send(rec).get();
                System.out.println("Sent message: (" + messageStr + ")");
            } catch (InterruptedException | ExecutionException e) {
                // e.printStackTrace();
                // handle the exception
                log.error(e.getMessage(), e);
            }
        }

        return calluid;
    }
}

@Slf4j
class KafkaCallBack implements Callback {
    // private static final String MODULE = KafkaCallBack.class.getName();
    private final long startTime;
    private final long key;
    private final String message;

    public KafkaCallBack(long startTime, long key, String message) {
        this.startTime = startTime;
        this.key = key;
        this.message = message;
    }

    /**
     * onCompletion method will be called when the record sent to the Kafka Server has been acknowledged.
     *
     * @param metadata  The metadata contains the partition and offset of the record. Null if an error occurred.
     * @param exception The exception thrown during processing of this record. Null if no error occurred.
     */
    public void onCompletion(RecordMetadata metadata, Exception exception) {
        long elapsedTime = System.currentTimeMillis() - startTime;
        if (metadata != null) {
            log.debug(
                    "message(" + key + ", " + message + ") sent to partition(" + metadata.partition() +
                            "), " +
                            "offset(" + metadata.offset() + ") in " + elapsedTime + " ms");
        } else {
            // exception.printStackTrace();
            log.error(exception.getMessage(), exception);
        }
    }
}
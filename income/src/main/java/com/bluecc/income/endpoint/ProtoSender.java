package com.bluecc.income.endpoint;

import com.google.protobuf.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import javax.inject.Singleton;
import java.util.Properties;

import static com.bluecc.income.endpoint.Sender.KAFKA_SERVER_PORT;
import static com.bluecc.income.endpoint.Sender.KAFKA_SERVER_URL;

@Singleton
@Slf4j
public class ProtoSender {
    KafkaProducer<String, Message> producer;
    ProtoSender(){
        producer = createKafkaProducer(PKG_SER);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("*** shutting down proto-sender since JVM is shutting down");
            ProtoSender.this.producer.close();
            System.err.println("*** proto-sender shut down");
        }));
    }

    public void send(String topic, String key, Message data){
        producer.send(new ProducerRecord<>(topic, key, data));
        log.info("Message sent: {}", data);
    }

    public static final String CONSUMER_APP_ID = "consumer_id";
    public static final String CONSUMER_GROUP_ID = "group_id";

    public static final String PKG_SER="com.bluecc.income.dummy.broker.envelope.EnvelopeSerializer";
    public static KafkaProducer<String, Message> createKafkaProducer(String serializer) {

        Properties props = new Properties();
        // props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafka.getBootstrapServers());
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVER_URL + ":" + KAFKA_SERVER_PORT);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, CONSUMER_APP_ID);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, serializer);

        return new KafkaProducer<>(props);

    }

}


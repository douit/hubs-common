package com.bluecc.income.endpoint;

import com.google.protobuf.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import javax.inject.Singleton;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import static com.bluecc.income.endpoint.ProtoSender.CONSUMER_APP_ID;
import static com.bluecc.income.endpoint.ProtoSender.CONSUMER_GROUP_ID;
import static com.bluecc.income.endpoint.Sender.KAFKA_SERVER_PORT;
import static com.bluecc.income.endpoint.Sender.KAFKA_SERVER_URL;

@Singleton
@Slf4j
public class ProtoReceiver {
    KafkaConsumer<String, Message> consumer;
    ProtoReceiver(){
        consumer = createKafkaConsumer(PKG_DE);
    }

    public void receive(List<String> topics){
        consumer.subscribe(topics);
        while (true) {
            ConsumerRecords<String, Message> records = consumer.poll(Duration.ofSeconds(1));
            records.forEach(record -> {
                log.info("Message received: {}" , record.value());
            });
        }
    }

    public static String PKG_DE="com.bluecc.income.dummy.broker.envelope.EnvelopeDeserializer";
    public static KafkaConsumer<String, Message> createKafkaConsumer(String deserializer) {
        Properties props = new Properties();
        // props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafka.getBootstrapServers());
        // props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafka.getBootstrapServers());
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVER_URL + ":" + KAFKA_SERVER_PORT);
        props.put(ConsumerConfig.CLIENT_ID_CONFIG, CONSUMER_APP_ID);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, CONSUMER_GROUP_ID);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);

        return new KafkaConsumer<>(props);

    }
}


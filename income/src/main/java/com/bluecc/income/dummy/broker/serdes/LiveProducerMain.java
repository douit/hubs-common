package com.bluecc.income.dummy.broker.serdes;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

import static com.bluecc.income.endpoint.Sender.KAFKA_SERVER_PORT;
import static com.bluecc.income.endpoint.Sender.KAFKA_SERVER_URL;

/**
 * $ just i dummy.broker.serdes.LiveConsumerMain
 * $ just i dummy.broker.serdes.LiveProducerMain
 */
public class LiveProducerMain {
    public static final String SERDES_SER="com.bluecc.income.dummy.broker.serdes.CustomSerializer";
    public static void main(String[] args) throws InterruptedException {
        MessageDto msgProd = MessageDto.builder().message("test").version("1.0").build();

        KafkaProducer<String, MessageDto> producer = createKafkaProducer(SERDES_SER);
        producer.send(new ProducerRecord<String, MessageDto>(TOPIC, "1", msgProd));
        System.out.println("Message sent " + msgProd);
        producer.close();

        Thread.sleep(1000);
    }

    static final String TOPIC = "serde-test";
    static final String CONSUMER_APP_ID = "consumer_id";
    static final String CONSUMER_GROUP_ID = "group_id";

    static KafkaConsumer<String, MessageDto> createKafkaConsumer(String deserializer) {

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

    public static KafkaProducer<String, MessageDto> createKafkaProducer(String serializer) {

        Properties props = new Properties();
        // props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafka.getBootstrapServers());
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVER_URL + ":" + KAFKA_SERVER_PORT);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, CONSUMER_APP_ID);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, serializer);

        return new KafkaProducer<>(props);

    }

}

package com.bluecc.income.dummy.broker.serdes;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

import static com.bluecc.income.dummy.broker.serdes.LiveProducerMain.TOPIC;
import static com.bluecc.income.dummy.broker.serdes.LiveProducerMain.createKafkaConsumer;

public class LiveConsumerMain {
    public static String SERDES_DE="com.bluecc.income.dummy.broker.serdes.CustomDeserializer";

    public static void main(String[] args) throws InterruptedException {
        MessageDto msgProd = MessageDto.builder().message("test").version("1.0").build();

        AtomicReference<MessageDto> msgCons = new AtomicReference<>();

        KafkaConsumer<String, MessageDto> consumer = createKafkaConsumer(SERDES_DE);
        consumer.subscribe(Arrays.asList(TOPIC));
        while (true) {
            ConsumerRecords<String, MessageDto> records = consumer.poll(Duration.ofSeconds(1));
            records.forEach(record -> {
                msgCons.set(record.value());
                System.out.println("Message received " + record.value());
            });
        }

        // consumer.close();
        // assertEquals(msgProd, msgCons.get());
        // System.out.println(msgCons.get());
    }
}

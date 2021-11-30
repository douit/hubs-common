package com.bluecc.income.dummy.broker.envelope;

import com.bluecc.income.dummy.broker.serdes.MessageDto;
import com.google.protobuf.Message;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

import static com.bluecc.income.dummy.broker.envelope.EnvelopeProducerMain.TOPIC;
import static com.bluecc.income.dummy.broker.envelope.EnvelopeProducerMain.createKafkaConsumer;

public class EnvelopeConsumerMain {
    public static String PKG_DE="com.bluecc.income.dummy.broker.envelope.EnvelopeDeserializer";

    public static void main(String[] args) throws InterruptedException {
        // MessageDto msgProd = MessageDto.builder().message("test").version("1.0").build();
        AtomicReference<Message> msgCons = new AtomicReference<>();

        KafkaConsumer<String, Message> consumer = createKafkaConsumer(PKG_DE);
        consumer.subscribe(Arrays.asList(TOPIC));
        while (true) {
            ConsumerRecords<String, Message> records = consumer.poll(Duration.ofSeconds(1));
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

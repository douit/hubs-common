package com.bluecc.income.dummy.broker.envelope;

import com.bluecc.hubs.feed.ProtoStuffs;
import com.bluecc.hubs.stub.PersonFlatData;
import com.google.protobuf.Message;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

import static com.bluecc.income.endpoint.ProtoSender.*;
import static com.bluecc.income.endpoint.Sender.KAFKA_SERVER_PORT;
import static com.bluecc.income.endpoint.Sender.KAFKA_SERVER_URL;

/**
 * $ just i dummy.broker.envelope.EnvelopeConsumerMain
 * $ just i dummy.broker.envelope.EnvelopeProducerMain
 */
public class EnvelopeProducerMain {

    public static void main(String[] args) throws InterruptedException {
        // MessageDto msgProd = MessageDto.builder().message("test").version("1.0").build();
        PersonFlatData flatData= ProtoStuffs.personFlatData();

        KafkaProducer<String, Message> producer = createKafkaProducer(PKG_SER);
        producer.send(new ProducerRecord<String, Message>(
                TOPIC, "1", flatData));
        System.out.println("Message sent " + flatData);
        producer.close();

        Thread.sleep(1000);
    }

    static final String TOPIC = "pkg-test";

}

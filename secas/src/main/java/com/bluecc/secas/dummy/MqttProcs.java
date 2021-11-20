package com.bluecc.secas.dummy;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MqttProcs {
    public static void main(String[] args) throws Exception {
        String publisherId = UUID.randomUUID().toString();
        // IMqttClient publisher = new MqttClient("tcp://iot.eclipse.org:1883",publisherId);
        IMqttClient publisher = new MqttClient("tcp://localhost:1883",publisherId);

        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        publisher.connect(options);

        EngineTemperatureSensor sensor=new EngineTemperatureSensor(publisher);
        sensor.call();
        
        receiveMessages();

        System.out.println("end.");
        System.exit(0);
    }

    private static void receiveMessages() throws InterruptedException, MqttException {
        System.out.println(".. receive messages");
        String publisherId = UUID.randomUUID().toString();
        IMqttClient subscriber = new MqttClient("tcp://localhost:1883",publisherId);

        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        subscriber.connect(options);

        CountDownLatch receivedSignal = new CountDownLatch(10);
        subscriber.subscribe(EngineTemperatureSensor.TOPIC, (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String cnt=new String(payload, StandardCharsets.UTF_8);
            System.out.println(cnt);

            // ... payload handling omitted
            receivedSignal.countDown();
        });

        receivedSignal.await(15, TimeUnit.SECONDS);
    }
}

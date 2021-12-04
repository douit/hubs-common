package com.bluecc.hubs.feed;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import javax.inject.Singleton;

@Singleton
public class SharedData {
    RedissonClient client;

    SharedData() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://127.0.0.1:6379");

        client = Redisson.create(config);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("*** shutting down redis-connection since JVM is shutting down");
            SharedData.this.shutdown();
            System.err.println("*** redis-connection shut down");
        }));
    }

    public RedissonClient getClient() {
        return client;
    }

    public void shutdown(){
        client.shutdown();
    }

}


package com.bluecc.hubs.feed;

import com.google.common.collect.Lists;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import javax.inject.Singleton;

@Singleton
public class SharedData implements ISharedData{
    RedissonClient client;

    SharedData() {
        Config config = new Config();
        // config.setCodec(new org.redisson.codec.KryoCodec(Lists.newArrayList(byte[].class)));
        // config.setNettyThreads(2);
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


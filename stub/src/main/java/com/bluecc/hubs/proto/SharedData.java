package com.bluecc.hubs.proto;

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
    }

    public RedissonClient getClient() {
        return client;
    }

}


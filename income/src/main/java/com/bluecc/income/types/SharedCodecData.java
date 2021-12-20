package com.bluecc.income.types;

import com.beust.jcommander.internal.Lists;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class SharedCodecData {
    RedissonClient client;
    ObjectRegistries objectRegistries;

    @Inject
    SharedCodecData(ObjectRegistries objectRegistries) {
        Config config = new Config();

        List<Class<?>> classes= Lists.newArrayList(objectRegistries.modelClasses);
        classes.add(org.redisson.RedissonReference.class);
        classes.add(java.time.LocalDateTime.class);
        classes.add(java.math.BigDecimal.class);
        classes.add(com.bluecc.income.types.AppKey.class);
        config.setCodec(new org.redisson.codec.KryoCodec(classes));
        config.useSingleServer()
                .setAddress("redis://127.0.0.1:6379");

        client = Redisson.create(config);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("*** shutting down redis-connection since JVM is shutting down");
            SharedCodecData.this.shutdown();
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


package com.bluecc.income;


import com.bluecc.hubs.feed.FactBag;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import javax.inject.Inject;

@RunWith(GuiceTestRunner.class)
public class AbstractRemoteTest {
    @Inject
    FactBag factBag;
    protected  RedissonClient redisson;

    @Before
    public void setUp() throws Exception {
        redisson=factBag.getSharedData().getClient();
    }

    public static Config createConfig() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://127.0.0.1:6379");
        return config;
    }

    public static RedissonClient createInstance() {
        Config config = createConfig();
        return Redisson.create(config);
    }
}

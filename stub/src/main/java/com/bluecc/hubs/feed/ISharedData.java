package com.bluecc.hubs.feed;

import org.redisson.api.RedissonClient;

public interface ISharedData {
    RedissonClient getClient();
    void shutdown();
}

package com.bluecc.hubs.feed;

import org.redisson.api.RLiveObjectService;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.redisson.api.condition.Condition;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Singleton
public class LiveObjects extends AbstractLiveObjects{
    ISharedData sharedData;
    RLiveObjectService service;

    @Inject
    LiveObjects(ISharedData sharedData){
        this.sharedData=sharedData;
        this.service=sharedData.getClient().getLiveObjectService();
    }

    @Override
    public RedissonClient redisson(){
        return this.sharedData.getClient();
    }

    @Override
    public RLiveObjectService getService() {
        return service;
    }
}

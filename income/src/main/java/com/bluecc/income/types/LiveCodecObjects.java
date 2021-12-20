package com.bluecc.income.types;

import com.bluecc.hubs.feed.AbstractLiveObjects;
import com.bluecc.hubs.feed.SharedData;
import org.redisson.api.RLiveObjectService;
import org.redisson.api.RedissonClient;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LiveCodecObjects extends AbstractLiveObjects {
    SharedCodecData sharedData;
    RLiveObjectService service;

    @Inject
    LiveCodecObjects(SharedCodecData sharedData){
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

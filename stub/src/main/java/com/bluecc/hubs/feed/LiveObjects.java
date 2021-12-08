package com.bluecc.hubs.feed;

import org.redisson.api.RLiveObjectService;
import org.redisson.api.condition.Condition;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Singleton
public class LiveObjects {
    SharedData sharedData;
    RLiveObjectService service;

    @Inject
    LiveObjects(SharedData sharedData){
        this.sharedData=sharedData;
        this.service=sharedData.getClient().getLiveObjectService();
    }

    public RLiveObjectService getService() {
        return service;
    }

    public <T> T persist(T detachedObject){
        return service.persist(detachedObject);
    }

    public <T> T merge(T detachedObject){
        return service.merge(detachedObject);
    }

    public boolean expire(Object o, long timeToLive, TimeUnit timeUnit){
        return service.asRMap(o).expire(timeToLive, timeUnit);
    }

    public boolean expireInSeconds(Object o, long timeToLive){
        return expire(o, timeToLive, TimeUnit.SECONDS);
    }

    public boolean exists(Object o){
        return service.asLiveObject(o).isExists();
    }

    public void update(Object o, Map<String, Object> props){
        service.asRMap(o).putAll(props);
    }

    public <T> T get(Class<T> entityClass, Object id){
        return service.get(entityClass, id);
    }

    public <T> Collection<T> find(Class<T> entityClass, Condition condition){
        return service.find(entityClass, condition);
    }
}

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
public class LiveObjects {
    SharedData sharedData;
    RLiveObjectService service;

    @Inject
    LiveObjects(SharedData sharedData){
        this.sharedData=sharedData;
        this.service=sharedData.getClient().getLiveObjectService();
    }

    public RedissonClient redisson(){
        return this.sharedData.getClient();
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

    @SafeVarargs
    public final <T> void addQueue(String queueName, T... data){
        RQueue<T> queue = redisson().getQueue(queueName);
        queue.addAll(Arrays.asList(data));
    }

    /**
     * Retrieves and removes the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    public <T> T pollQueue(String queueName){
        RQueue<T> queue = redisson().getQueue(queueName);
        return queue.poll();
    }
}

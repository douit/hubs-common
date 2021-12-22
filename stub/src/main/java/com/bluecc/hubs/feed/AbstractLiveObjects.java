package com.bluecc.hubs.feed;

import org.redisson.api.RAtomicLong;
import org.redisson.api.RLiveObjectService;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.redisson.api.condition.Condition;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class AbstractLiveObjects {

    public abstract RedissonClient redisson();

    public abstract RLiveObjectService getService();

    public <T> T persist(T detachedObject){
        return getService().persist(detachedObject);
    }

    public <T> T merge(T detachedObject){
        return getService().merge(detachedObject);
    }

    public boolean expire(Object o, long timeToLive, TimeUnit timeUnit){
        return getService().asRMap(o).expire(timeToLive, timeUnit);
    }

    public boolean expireInSeconds(Object o, long timeToLive){
        return expire(o, timeToLive, TimeUnit.SECONDS);
    }

    public boolean exists(Object o){
        return getService().asLiveObject(o).isExists();
    }

    public void update(Object o, Map<String, Object> props){
        getService().asRMap(o).putAll(props);
    }

    public <T> T get(Class<T> entityClass, Object id){
        return getService().get(entityClass, id);
    }

    public <T> T getDetach(Class<T> entityClass, Object id){
        T o=get(entityClass, id);
        return getService().detach(o);
    }

    public <T> Collection<T> find(Class<T> entityClass, Condition condition){
        return getService().find(entityClass, condition);
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

    public long getSeqId(String subject){
        RAtomicLong atomicLong = redisson().getAtomicLong(subject);
        return atomicLong.getAndIncrement();
    }
}

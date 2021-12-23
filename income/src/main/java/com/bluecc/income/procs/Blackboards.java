package com.bluecc.income.procs;

import com.bluecc.hubs.feed.LiveObjects;
import com.bluecc.hubs.stub.Envelope;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.control.Try;
import org.redisson.api.*;
// import org.redisson.client.codec.ByteArrayCodec;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Blackboards {
    @Inject
    LiveObjects liveObjects;

    public Map<String, Try<Envelope>> getBuckets(String... bucketNames) {
        RBuckets buckets = boards();
        Map<String, byte[]> items = buckets.get(bucketNames);
        return items.entrySet().stream()
                .map(e -> Tuple.of(e.getKey(), Try.of(() -> Envelope.parseFrom(e.getValue()))))
                .collect(Collectors.toMap(Tuple2::_1, Tuple2::_2));
    }

    private RBuckets boards() {
        RBuckets buckets = liveObjects.redisson().getBuckets();
        return buckets;
    }

    public void putBuckets(Map<String, Envelope> map) {
        Map<String, byte[]> items = extractBytesMap(map);
        boards().set(items);
    }

    private Map<String, byte[]> extractBytesMap(Map<String, Envelope> map) {
        return map.entrySet().stream().map(e -> Tuple.of(e.getKey(), e.getValue().toByteArray()))
                .collect(Collectors.toMap(Tuple2::_1, Tuple2::_2));
    }

    public void addToGroup(String groupName, String... bucketNames) {
        RedissonClient redisson = liveObjects.redisson();
        RMap<String, RBucket<byte[]>> group = getBucketMap(groupName);
        Arrays.stream(bucketNames).forEach(name ->
                group.put(name, redisson.getBucket(name)));
    }

    private RMap<String, RBucket<byte[]>> getBucketMap(String groupName) {
        RedissonClient redisson = liveObjects.redisson();
        RMap<String, RBucket<byte[]>> group =
                redisson.getMap(groupName);
        return group;
    }

    public Try<Envelope> getDataFromGroup(String groupName, String key){
        return Try.of(()-> {
            byte[] cnt=getBucketMap(groupName).get(key).get();
            return Envelope.parseFrom(cnt);
        });
    }
}

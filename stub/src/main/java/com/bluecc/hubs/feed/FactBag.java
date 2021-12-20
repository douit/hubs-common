package com.bluecc.hubs.feed;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.fund.FnUtil;
import com.bluecc.hubs.fund.descriptor.INameSymbol;
import com.bluecc.hubs.stub.Envelope;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import org.redisson.api.RMap;

import javax.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

import static com.bluecc.hubs.ProtoTypes.getEntityType;
import static com.bluecc.hubs.fund.FnUtil.wrap;

public class FactBag {
    ISharedData sharedData;

    @Inject
    public FactBag(ISharedData sharedData) {
        this.sharedData = sharedData;
    }

    public ISharedData getSharedData() {
        return sharedData;
    }

    public FactBag addItemToBag(String bag, String entityName,
                             String key,
                             GeneratedMessageV3 msg) {
        getMap(bag, entityName).put(key, msg.toByteArray());
        return this;
    }

    private RMap<Object, Object> getMap(String bag, String entityName) {
        return sharedData.getClient().getMap(bag + "." + entityName);
    }

    public byte[] getItemFromBag(String bag, String entityName, String key) {
        return (byte[]) getMap(bag, entityName).get(key);
    }

    public void putData(String bag, String key, Envelope evenlope){
        sharedData.getClient().getMap(bag).put(key, evenlope.toByteArray());
    }

    public void putEntityData(String bag, Message entityData){
        String key= ProtoTypes.getEntityIden(entityData, ":");
        sharedData.getClient().getMap(bag).put(key, entityData.toByteArray());
    }

    public void clearMap(String bag){
        sharedData.getClient().getMap(bag).clear();
    }

    public void getEntityData(String key, Message.Builder builder) throws InvalidProtocolBufferException {
        String bag=getEntityType(builder.getDescriptorForType());
        byte[] cnt=(byte[]) sharedData.getClient().getMap(bag).get(key);
        builder.mergeFrom(cnt);
    }

    public RMap<String, byte[]> all(INameSymbol bag){
        return all(bag.getEntityName());
    }

    public <T> List<T> allTypes(String ent, FnUtil.CheckedFunction<byte[],T> parseFn){
        List<T> ds= all(ent)
                .readAllMap()
                .values().stream()
                .map(wrap(parseFn))
                .collect(Collectors.toList());
        return ds;
    }

    public RMap<String, byte[]> all(String entityName){
        return sharedData.getClient().getMap(entityName);
    }

    public Envelope getData(String bag, String key) throws InvalidProtocolBufferException {
        byte[] cnt=(byte[]) sharedData.getClient().getMap(bag).get(key);
        return Envelope.parseFrom(cnt);
    }

}

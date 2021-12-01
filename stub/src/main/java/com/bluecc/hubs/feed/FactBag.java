package com.bluecc.hubs.feed;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.stub.Envelope;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import org.redisson.api.RMap;

import javax.inject.Inject;

public class FactBag {
    public SharedData getSharedData() {
        return sharedData;
    }

    SharedData sharedData;

    @Inject
    public FactBag(SharedData sharedData) {
        this.sharedData = sharedData;
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

    public Envelope getData(String bag, String key) throws InvalidProtocolBufferException {
        byte[] cnt=(byte[]) sharedData.getClient().getMap(bag).get(key);
        return Envelope.parseFrom(cnt);
    }

}

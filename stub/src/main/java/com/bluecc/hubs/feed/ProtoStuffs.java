package com.bluecc.hubs.feed;

import com.bluecc.hubs.stub.PersonFlatData;

public class ProtoStuffs {
    public static PersonFlatData personFlatData(){
        return PersonFlatData.newBuilder()
                .setFirstName("samlet")
                .setLastName("wu")
                .build();
    }
}

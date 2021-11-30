package com.bluecc.hubs.proto;

import com.bluecc.hubs.stub.PersonFlatData;

public class ProtoStuffs {
    public static PersonFlatData personFlatData(){
        return PersonFlatData.newBuilder()
                .setFirstName("samlet")
                .setLastName("wu")
                .build();
    }
}

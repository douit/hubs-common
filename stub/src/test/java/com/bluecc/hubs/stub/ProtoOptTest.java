package com.bluecc.hubs.stub;

import com.google.protobuf.Descriptors;
import org.junit.jupiter.api.Test;

public class ProtoOptTest {
    @Test
    void testOptions(){
        Descriptors.Descriptor descriptor=PersonObject.getDescriptor();
        descriptor.getOptions().getAllFields().forEach((k,v) ->
                System.out.println(k.getName()+": "+v.toString()));

        // get by extension
        String entityType=descriptor.getOptions().getExtension(RoutinesProto.entityType);
        System.out.println(entityType);
    }
}

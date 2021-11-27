package com.bluecc.hubs.stub;

import com.google.protobuf.Descriptors;
import org.junit.Test;

import java.util.Arrays;

import static com.bluecc.hubs.fund.Util.pretty;
import static org.junit.Assert.*;

public class ProtoOptTest {
    @Test
    public void testOptions(){
        Descriptors.Descriptor descriptor=PersonObject.getDescriptor();
        descriptor.getOptions().getAllFields().forEach((k,v) ->
                System.out.println(k.getName()+": "+v.toString()));

        // get by extension
        String entityType=descriptor.getOptions().getExtension(RoutinesProto.entityType);
        System.out.println(entityType);

        EntityKey keys=descriptor.getOptions().getExtension(RoutinesProto.keys);
        System.out.println(keys);

        keys=OrderItemFlatData.getDescriptor().getOptions().getExtension(RoutinesProto.keys);
        pretty(keys.getKeys().split(", "));
    }

}

package com.bluecc.hubs.stub;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.protobuf.Descriptors;
import org.junit.Test;

import java.util.EnumMap;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class ProtoEnumTest {
    @Test
    public void testIndicator(){
        Indicator indicator=Indicator.YES;
        System.out.println(indicator.getClass().getSimpleName());

        // test enum-map
        EnumMap<Indicator, Function<StatusProposal, Response>> actionMap=new EnumMap<>(Indicator.class);

        actionMap.put(Indicator.YES, in ->{
            return Response.newBuilder()
                    .setResult(Response.Result.OK)
                    .setMessage("all done")
                    .build();
        });

        assertThat(actionMap.containsKey(Indicator.YES)).isTrue();

        // test multimap
        Multimap<Indicator, Function<StatusProposal, Response>> actionMultimap=
                ArrayListMultimap.create();
        actionMultimap.put(Indicator.YES, in ->{
            return Response.newBuilder()
                    .setResult(Response.Result.OK)
                    .setMessage("all done")
                    .build();
        });

        assertThat(actionMultimap.containsKey(Indicator.YES)).isTrue();
    }

    @Test
    public void testDescriptor(){
        Descriptors.EnumValueDescriptor enumVal= Indicator.getDescriptor().findValueByName("YES");
        System.out.println(enumVal);
        System.out.println(enumVal.getNumber());

        System.out.println(Indicator.valueOf("NO"));
        System.out.println(Indicator.forNumber(0));
    }
}

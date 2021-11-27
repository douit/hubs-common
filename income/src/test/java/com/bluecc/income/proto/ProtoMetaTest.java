package com.bluecc.income.proto;

import com.bluecc.hubs.stub.PersonFlatData;
import com.bluecc.income.exchange.MessageMapCollector;
import com.google.protobuf.Descriptors;
import org.junit.Test;

import java.util.Map;
import java.util.stream.Collectors;

import static com.bluecc.income.exchange.MessageMapCollector.collect;

public class ProtoMetaTest {
    @Test
    public void testMetaFields(){
        PersonFlatData flatData= PersonFlatData.newBuilder()
                .setPartyId(Long.toString(System.currentTimeMillis()))
                .setLastName("samlet")
                .setFirstName("wu")
                .build();
        flatData.getAllFields().keySet().forEach(e -> System.out.println(e));

        // Map<Descriptors.FieldDescriptor, Object> allFields = flatData.getAllFields();
        // System.out.println(allFields.keySet().stream().map(f -> f.getName())
        //         .collect(Collectors.toList()));

        System.out.println("-----------");
        collect((c, e) -> {
            System.out.println("Ⓜ️ "+c.getSymbol()+" -> "+e);
        }).fillMap(flatData);
    }
}

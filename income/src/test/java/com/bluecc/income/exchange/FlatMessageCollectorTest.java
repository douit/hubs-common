package com.bluecc.income.exchange;

import com.bluecc.hubs.fund.Sequence;
import com.bluecc.hubs.stub.PersonFlatData;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
public class FlatMessageCollectorTest {

    Sequence sequence=new Sequence(null);
    @Test
    public void extractFromMessage() {
        String newId=sequence.nextStringId();
        PersonFlatData flatData= PersonFlatData.newBuilder()
                .setPartyId(newId)
                .setLastName("samlet")
                .setFirstName("wu")
                .build();
        FlatMessageCollector.extract(flatData).forEach((k,v)->
                System.out.println(k+": "+v));
        assertThat(FlatMessageCollector.extract(flatData))
                .containsKey("party_id")
                .containsKey("last_name")
                .containsKey("first_name")
                .containsValue(newId);
    }
}
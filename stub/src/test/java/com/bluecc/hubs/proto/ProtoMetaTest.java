package com.bluecc.hubs.proto;

import com.bluecc.hubs.fund.EntityMeta;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProtoMetaTest {

    @Test
    public void findRelationQueryMeta() {
        ProtoMeta protoMeta=new ProtoMeta();
        EntityMeta.RelationQueryMeta queryMeta=protoMeta.findRelationQueryMeta(
                "Party", "acctg_trans");
        System.out.println(queryMeta);

        assertThat(queryMeta.getFieldNames()).containsOnly("partyId");
    }
}
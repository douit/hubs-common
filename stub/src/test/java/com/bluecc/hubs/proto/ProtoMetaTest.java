package com.bluecc.hubs.proto;

import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.ProtoMeta;
import org.junit.Test;

import static com.bluecc.hubs.fund.Util.pretty;
import static org.assertj.core.api.Assertions.assertThat;

public class ProtoMetaTest {

    ProtoMeta protoMeta=new ProtoMeta();
    @Test
    public void findRelationQueryMeta() {

        EntityMeta.RelationQueryMeta queryMeta=protoMeta.findRelationQueryMeta(
                "Party", "acctg_trans");
        System.out.println(queryMeta);

        assertThat(queryMeta.getFieldNames()).containsOnly("partyId");

        queryMeta=protoMeta.findRelationQueryMeta(
                "Shipment", "origin_contact_mech");
        System.out.println(queryMeta);
        assertThat(queryMeta.getFieldNames()).containsOnly("originContactMechId");
    }

    @Test
    public void dumpMetaToJson(){
        pretty(protoMeta.getEntityMeta("Person"));
    }
}

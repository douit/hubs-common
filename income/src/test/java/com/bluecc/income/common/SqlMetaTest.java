package com.bluecc.income.common;

import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.hubs.fund.SqlMeta;
import com.bluecc.income.dao.PartyDelegator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SqlMetaTest {
    ProtoMeta protoMeta=new ProtoMeta();
    @Test
    public void testJoinRowSql(){
        SqlMeta sqlMeta = protoMeta.getSqlMeta("Party");
        SqlMeta.ViewDecl view = sqlMeta.leftJoin(PartyDelegator.PARTY_CONTACT_MECH);
        System.out.println(view.getSql());
        assertTrue(view.getSql().startsWith("select pa.party_id pa_party_id, " +
                "pa.party_type_id pa_party_type_id, pa.external_id"));

        //
        sqlMeta = protoMeta.getSqlMeta("Party", true);
        view = sqlMeta.leftJoin(PartyDelegator.PARTY_CONTACT_MECH);
        System.out.println(view.getSql());
        assertTrue(view.getSql().startsWith("select pa.party_id pa_party_id, pcm.party_id pcm_party_id, "));
    }

}

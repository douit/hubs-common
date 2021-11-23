package com.bluecc.content.dummy;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;

import static com.bluecc.content.dummy.DummyMaintain.maybeCreateSchema;

public class DummyQueryMain {
    public static void main(String[] args) {
        CqlSession session = CqlSession.builder().build();
        CqlIdentifier keyspaceId=CqlIdentifier.fromCql("lombok");
        maybeCreateSchema(session, keyspaceId);
    }

    void query(){
        // SelectFrom selectUser = selectFrom("product");
    }
}

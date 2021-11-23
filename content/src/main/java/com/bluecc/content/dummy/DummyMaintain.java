package com.bluecc.content.dummy;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;

public class DummyMaintain {
    public static void main(String[] args) {
        CqlSession session = CqlSession.builder().build();
        CqlIdentifier keyspaceId=CqlIdentifier.fromCql("lombok");
        maybeCreateSchema(session, keyspaceId);
    }

    private static void maybeCreateSchema(CqlSession session, CqlIdentifier keyspaceId) {
        session.execute(
                SimpleStatement.newInstance(
                                String.format(
                                        "CREATE KEYSPACE IF NOT EXISTS %s "
                                                + "WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1}",
                                        keyspaceId.asCql(false)))
                        .setExecutionProfileName("slow"));
        session.execute(
                SimpleStatement.newInstance(
                                String.format(
                                        "CREATE TABLE IF NOT EXISTS %s.product( "
                                                + "id int PRIMARY KEY, description text)",
                                        keyspaceId.asCql(false)))
                        .setExecutionProfileName("slow"));
    }
}

package com.bluecc.income.procs;

import com.bluecc.hubs.stub.PartyData;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.AbstractStoreProcTest;
import com.google.common.collect.Sets;
import io.grpc.stub.StreamObserver;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Set;

import static com.bluecc.income.dao.PartyDelegator.PARTY_CONTACT_MECH;
import static com.bluecc.income.dao.PartyDelegator.PERSON;
import static org.junit.Assert.*;

public class PartyRpcTest extends AbstractStoreProcTest {
    @Inject
    PartyRpc partyRpc;

    @Test
    public void findList() {
        Set<String> incls = Sets.newHashSet(
                PARTY_CONTACT_MECH,
                PERSON);
        partyRpc.findList(QueryList.newBuilder()
                .addAllRelations(incls)
                .build(), new StreamObserver<PartyData>() {
            @Override
            public void onNext(PartyData value) {
                System.out.println(value);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                System.out.println("end.");
            }
        });
    }
}
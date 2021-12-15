package com.bluecc.income.procs;

import com.bluecc.hubs.stub.PartyData;
import com.bluecc.hubs.stub.PartyServiceGrpc;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.PartyDelegator;
import com.bluecc.income.model.Party;
import com.google.common.collect.Maps;
import io.grpc.stub.StreamObserver;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static com.bluecc.income.dao.PartyDelegator.PARTY_CONTACT_MECH;

public class PartyRpc extends PartyServiceGrpc.PartyServiceImplBase {
    @Inject
    PartyDelegator partyDelegator;

    @Override
    public void findList(QueryList request, StreamObserver<PartyData> responseObserver) {
        partyDelegator.process(c -> {
            PartyDelegator.Dao dao = c.getHandle().attach(PartyDelegator.Dao.class);
            Map<String, Party> dataMap = Maps.newHashMap();
            Set<String> incls = new HashSet<>(request.getRelationsList());

            // chain-queries
            Consumer<Map<String, Party>> chain = partyDelegator.person(dao, false);
            if (incls.contains(PARTY_CONTACT_MECH)) {
                chain = chain.andThen(partyDelegator.partyContactMech(dao, true));
            }
            chain.accept(dataMap);

            // convert
            dataMap.values().stream().map(data -> {
                PartyData.Builder partyData = data.toHeadBuilder();
                data.getRelPerson().forEach(e -> partyData.setPerson(e.toHeadBuilder()));
                data.getRelPartyContactMech().forEach(e -> partyData.addPartyContactMech(e.toDataBuilder()));
                return partyData.build();
            }).forEach(e -> responseObserver.onNext(e));
            responseObserver.onCompleted();
        });
    }
}

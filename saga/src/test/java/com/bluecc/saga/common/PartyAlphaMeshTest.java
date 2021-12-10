package com.bluecc.saga.common;

import akka.Done;
import akka.actor.testkit.typed.javadsl.TestKitJunitResource;
import akka.actor.typed.ActorRef;
import com.bluecc.saga.common.PartyAlphaMesh.Conductors.PartyConductor;
import org.junit.ClassRule;
import org.junit.Test;
import org.scalatestplus.junit.JUnitSuite;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class PartyAlphaMeshTest extends JUnitSuite {
    @ClassRule
    public static final TestKitJunitResource testKit = new TestKitJunitResource();

    @Test
    public void testPartyActor(){
        ActorRef<PartyAlphaMesh.Event> actor =
                testKit.spawn(PartyConductor.create(
                        new PartyAlphaMesh.DataAccessor() {
                            @Override
                            public CompletionStage<Done> update(PartyAlphaMesh.Event event) {
                                return CompletableFuture.completedFuture(Done.getInstance());
                            }
                        },
                        PartyAlphaMesh.ReEnable.INSTANCE));

    }
}


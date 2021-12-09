package com.bluecc.saga.common;

import akka.Done;
import akka.actor.testkit.typed.javadsl.TestKitJunitResource;
import akka.actor.typed.ActorRef;
import com.bluecc.saga.common.PartyActor;
import com.bluecc.saga.common.PartyActor.Conductors.PartyConductor;
import org.junit.ClassRule;
import org.junit.Test;
import org.scalatestplus.junit.JUnitSuite;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class PartyActorTest extends JUnitSuite {
    @ClassRule
    public static final TestKitJunitResource testKit = new TestKitJunitResource();

    @Test
    public void testPartyActor(){
        ActorRef<PartyActor.Event> actor =
                testKit.spawn(PartyConductor.create(
                        new PartyActor.DataAccessor() {
                            @Override
                            public CompletionStage<Done> update(PartyActor.Event event) {
                                return CompletableFuture.completedFuture(Done.getInstance());
                            }
                        },
                        PartyActor.ReEnable.INSTANCE));

    }
}


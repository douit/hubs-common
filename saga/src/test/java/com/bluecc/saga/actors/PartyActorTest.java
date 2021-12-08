package com.bluecc.saga.actors;

import akka.Done;
import akka.actor.testkit.typed.javadsl.TestKitJunitResource;
import akka.actor.typed.ActorRef;
import com.bluecc.saga.actors.PartyActor.Conductors.PartyConductor;
import com.bluecc.saga.dummy.actor.SimpleActorTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.scalatestplus.junit.JUnitSuite;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static org.junit.Assert.*;

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


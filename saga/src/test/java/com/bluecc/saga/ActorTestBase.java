package com.bluecc.saga;

import akka.actor.testkit.typed.javadsl.TestKitJunitResource;
import org.junit.ClassRule;

public class ActorTestBase {

    @ClassRule
    public static final TestKitJunitResource testKit = new TestKitJunitResource();
}

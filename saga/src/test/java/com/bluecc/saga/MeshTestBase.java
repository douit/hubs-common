package com.bluecc.saga;

import akka.actor.testkit.typed.javadsl.TestKitJunitResource;
import com.bluecc.testkit.AbstractProcTest;
import com.bluecc.testkit.AbstractStoreProcTest;
import org.junit.ClassRule;

public class MeshTestBase extends AbstractStoreProcTest {

    @ClassRule
    public static final TestKitJunitResource testKit = new TestKitJunitResource();
}

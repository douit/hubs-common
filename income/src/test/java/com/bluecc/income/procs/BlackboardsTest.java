package com.bluecc.income.procs;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.stub.Envelope;
import com.bluecc.income.AbstractStoreProcTest;
import com.google.common.collect.ImmutableMap;
import io.vavr.control.Try;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.*;

public class BlackboardsTest extends AbstractStoreProcTest {
    @Inject
    Blackboards blackboards;

    @Test
    public void getDataFromGroup() {
        blackboards.putBuckets(ImmutableMap.of("test1",
                ProtoTypes.packString("test content")));
        Try<Envelope> data = blackboards.getBuckets("test1").get("test1");
        System.out.println(unpack(data));
        assertEquals("test content", unpack(data));

        blackboards.addToGroup("test-group", "test1");
        String r = unpack(blackboards.getDataFromGroup("test-group", "test1"));
        System.out.println(r);
        assertEquals("test content", r);

        assertTrue(blackboards.getDataFromGroup("test-group", "doesn't exist")
                .isFailure());
    }

    private String unpack(Try<Envelope> data) {
        return ProtoTypes.unpackString(data.get()).get();
    }
}
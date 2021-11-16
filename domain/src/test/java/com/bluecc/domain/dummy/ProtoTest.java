package com.bluecc.domain.dummy;

import com.bluecc.hubs.ProtoJsonUtils;
import com.bluecc.hubs.stub.StringValue;
import org.junit.Test;

import java.io.IOException;

public class ProtoTest {
    @Test
    public void testProto() throws IOException {
        StringValue val= StringValue.newBuilder()
                .setValue("samlet")
                .build();
        System.out.println(val.toString());
        String jsonVal= ProtoJsonUtils.toJson(val);
        System.out.println(jsonVal);

        System.out.println(ProtoJsonUtils.toProtoBean(StringValue.newBuilder(), jsonVal));
    }
}

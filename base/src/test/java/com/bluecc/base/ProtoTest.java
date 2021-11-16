package com.bluecc.base;

import com.bluecc.packer.routines.StringValue;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ProtoTest {
    @Test
    void testProto() throws IOException {
        StringValue val= StringValue.newBuilder()
                .setValue("samlet")
                .build();
        System.out.println(val.toString());
        String jsonVal=ProtoJsonUtils.toJson(val);
        System.out.println(jsonVal);

        System.out.println(ProtoJsonUtils.toProtoBean(StringValue.newBuilder(), jsonVal));
    }
}

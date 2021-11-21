package com.bluecc.hubs.stub;

import com.bluecc.hubs.ProtoJsonUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collection;

public class ProtoTest {
    @Test
    void testProto() throws IOException {
        StringValue val= StringValue.newBuilder()
                .setValue("samlet")
                .build();
        System.out.println(val.toString());
        String jsonVal= ProtoJsonUtils.toJson(val);
        System.out.println(jsonVal);

        System.out.println(ProtoJsonUtils.toProtoBean(StringValue.newBuilder(), jsonVal));
    }

    @Test
    void testParseProtoJson() throws IOException {
        Collection<Feature> features =RouteGuideUtil.parseFeatures(RouteGuideUtil.getDefaultFeaturesFile());
        features.forEach(e -> System.out.println(e));
    }
}

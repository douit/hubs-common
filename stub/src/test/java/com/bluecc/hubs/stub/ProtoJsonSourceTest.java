package com.bluecc.hubs.stub;

import com.bluecc.hubs.ProtoJsonUtils;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.util.JsonFormat;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ProtoJsonSourceTest {
    public static URL getPartyFile() {
        return ProtoJsonSourceTest.class.getResource("/data/party_simple.json");
    }

    @Test
    public void testSimple() throws IOException {
        String json=IOUtils.toString(getPartyFile(), StandardCharsets.UTF_8);
        PartyFlatData.Builder builder= PartyFlatData.newBuilder();
        JsonFormat.parser().merge(json, builder);
        PartyFlatData data=builder.build();
        System.out.println(data);
    }
}

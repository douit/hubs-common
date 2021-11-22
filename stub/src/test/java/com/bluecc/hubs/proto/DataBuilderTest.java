package com.bluecc.hubs.proto;

import com.bluecc.hubs.stub.RoutinesProto;
import com.bluecc.hubs.stub.ShipmentPackageRouteSegData;
import com.google.protobuf.ByteString;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

class DataBuilderTest {

    @Test
    void procData() {
        DataBuilder dataBuilder=new DataBuilder();
        DataBuilder.ProtoBuilder protoBuilder=dataBuilder.procData("OrderItem", true);

        String entityType=protoBuilder.descriptor.getOptions()
                .getExtension(RoutinesProto.entityType);
        System.out.println(entityType);
        assertEquals("OrderItem", entityType);
    }

    @Test
    void procBinaryData(){
        String originalInput = "上海磐石";
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
        ByteString bval=ByteString.copyFromUtf8(encodedString);
        ShipmentPackageRouteSegData segData=ShipmentPackageRouteSegData.newBuilder()
                .setInternationalInvoice(bval)
                .build();
        byte[] decodedBytes = Base64.getDecoder().decode(
                segData.getInternationalInvoice().toStringUtf8());
        String output=new String(decodedBytes, StandardCharsets.UTF_8);
        System.out.println(output);
        assertEquals(output, originalInput);
    }
}


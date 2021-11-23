package com.bluecc.hubs.proto;

import com.bluecc.hubs.stub.Envelope;
import com.bluecc.hubs.stub.ShipmentTimeEstimateData;
import com.bluecc.hubs.stub.StringValue;
import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static com.bluecc.hubs.proto.DataFill.getTimestamp;
import static org.junit.Assert.*;

@RunWith(GuiceTestRunner.class)
public class FactBagTest {
    @Inject
    FactBag factBag;

    @Test
    public void getItemFromBag() throws InvalidProtocolBufferException {
        ShipmentTimeEstimateData data = createShipmentTime();
        String bag = "default";
        factBag.addItemToBag(bag, "ShipmentTimeEstimate",
                "p1", data);
        ShipmentTimeEstimateData result = ShipmentTimeEstimateData.parseFrom(
                factBag.getItemFromBag(bag,
                        "ShipmentTimeEstimate",
                        "p1"));
        System.out.println(result);
    }

    private ShipmentTimeEstimateData createShipmentTime() {
        DateTime thruDate = DateTime.now();
        DateTime startDate = thruDate.minusDays(10);
        return ShipmentTimeEstimateData.newBuilder()
                .setFromDate(getTimestamp(startDate.getMillis()))
                .setThruDate(getTimestamp(thruDate.getMillis()))
                .build();
    }

    @Test
    public void testEnvelope() throws InvalidProtocolBufferException {
        StringValue protoMess=StringValue.newBuilder().setValue("hi").build();
        Any anyMessage = Any.pack(protoMess);
        StringValue resultMess=anyMessage.unpack(StringValue.class);
        System.out.println(resultMess.getValue());
        assertEquals("hi", resultMess.getValue());

        Envelope envelope= Envelope.newBuilder()
                .setDataType("string")
                .setData(Any.pack(protoMess))
                .build();
        factBag.putData("test", "p2", envelope);
        Envelope resultData=factBag.getData("test", "p2");
        System.out.println(resultData.getDataType());
        assertTrue(resultData.getData().is(StringValue.class));
        StringValue resultVal=resultData.getData().unpack(StringValue.class);
        assertEquals("string", resultData.getDataType());
        assertEquals("hi", resultVal.getValue());
    }
}


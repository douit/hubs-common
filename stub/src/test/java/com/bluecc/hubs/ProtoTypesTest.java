package com.bluecc.hubs;

import com.bluecc.hubs.feed.ProtoStuffs;
import com.bluecc.hubs.stub.Currency;
import com.bluecc.hubs.stub.FixedPoint;
import com.bluecc.hubs.stub.PersonFlatData;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.type.Money;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static com.bluecc.hubs.ProtoTypes.getBigDecimal;
import static org.junit.Assert.*;

public class ProtoTypesTest {
    @Test
    public void testCurrency(){
        BigDecimal val=new BigDecimal(750000000, new MathContext(9));
        System.out.println(val+", "+val.scale());
        BigDecimal remainVal=val.movePointLeft(9);
        System.out.println(remainVal);

        val=new BigDecimal(-750);
        remainVal=val.movePointLeft(2);
        System.out.println(remainVal);

        Currency currency=Currency.newBuilder()
                .setCurrencyUomId("CNY").setValue("0.75")
                .build();
        System.out.println(currency);
    }

    @Test
    public void toGoogleMoney() {
        BigDecimal curr=new BigDecimal("18.7500000");
        System.out.println(curr+", "+curr.longValue()+", "
                +curr.precision()+", "+curr.scale());
        Money money=ProtoTypes.toGoogleMoney(curr);
        System.out.println(money);
    }

    @Test
    public void testFixedPoint() {
        FixedPoint fixedPoint= FixedPoint.newBuilder()
                .setValue(1875)
                .setScalingPosition(2)
                .build();
        BigDecimal val = getBigDecimal(fixedPoint);
        BigDecimal curr = new BigDecimal("18.75");
        assertEquals(curr, val);

        System.out.println(curr + ", " + curr.longValue() + ", "
                + curr.precision() + ", " + curr.scale());
    }

    @Test
    public void testEntitySerializer() throws InvalidProtocolBufferException {
        PersonFlatData flatData=ProtoStuffs.personFlatData();
        byte[] bytes=ProtoTypes.serializeEntityWithEnvelope(flatData);
        PersonFlatData resultData=(PersonFlatData) ProtoTypes.deserializeEntityWithEnvelope(bytes);
        assertEquals(flatData.getLastName(), resultData.getLastName());

    }

}
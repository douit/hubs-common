package com.bluecc.income.exchange;

import com.bluecc.hubs.stub.EntityValue;
import com.bluecc.hubs.stub.OrderHeaderFlatData;
import com.bluecc.income.model.OrderHeader;
import org.junit.Test;

import static com.bluecc.hubs.ProtoTypes.*;
import static com.bluecc.hubs.ProtoTypes.getCurrency;
import static org.junit.Assert.*;

public class ModelSerializerTest {

    @Test
    public void toStringMap() {
        OrderHeader orderHeader=OrderHeader.fromData(OrderHeader_DEMO10090());
        ModelSerializer.toStringMap(orderHeader).forEach((k, v) ->{
            System.out.println(k+": "+v);
        });
    }

    @Test
    public void testToEntityValue(){
        OrderHeader orderHeader=OrderHeader.fromData(OrderHeader_DEMO10090());
        EntityValue entityValue= EntityValue.newBuilder()
                .putAllValues(ModelSerializer.toStringMap(orderHeader))
                .build();
        System.out.println(entityValue);
    }

    static OrderHeaderFlatData OrderHeader_DEMO10090() {
        return OrderHeaderFlatData.newBuilder()
                .setCreatedBy("admin")
                .setCurrencyUom("USD")
                .setEntryDate(getTimestamp("2008-04-23 16:49:27.392"))
                .setGrandTotal(getCurrency("50.85"))
                .setInvoicePerShipment(castIndicator("Y"))
                .setOrderDate(getTimestamp("2008-04-23 16:49:27.392"))
                .setOrderId("DEMO10090")
                .setOrderTypeId("SALES_ORDER")
                .setPriority(castIndicator("2"))
                .setProductStoreId("9000")
                .setRemainingSubTotal(getCurrency("38.40"))
                .setSalesChannelEnumId("WEB_SALES_CHANNEL")
                .setStatusId("ORDER_APPROVED")
                .setVisitId("10002")
                .setWebSiteId("WebStore")
                .build();
    }
}
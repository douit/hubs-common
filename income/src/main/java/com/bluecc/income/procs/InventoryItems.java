package com.bluecc.income.procs;

import com.bluecc.hubs.stub.InventoryItemFlatData;
import com.bluecc.hubs.stub.PaymentFlatData;
import com.bluecc.income.dao.InventoryItemDelegator;

public class InventoryItems extends InventoryItemDelegator {
    public void setInventoryItemStatus(InventoryItemFlatData invItem, String statusId){
        process(c ->{
            update(c, InventoryItemFlatData.newBuilder()
                    .setInventoryItemId(invItem.getInventoryItemId())
                    .setStatusId(statusId)
                    .build());
        });
    }
}

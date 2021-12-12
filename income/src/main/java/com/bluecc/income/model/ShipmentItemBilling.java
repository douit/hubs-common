package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;

import com.bluecc.hubs.stub.ShipmentItemBillingData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ShipmentItemBillingData.class,
        symbol = EntityNames.ShipmentItemBilling)
public class ShipmentItemBilling implements IEventModel<ShipmentItemBillingData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String shipmentId;
    @RIndex String shipmentItemSeqId;
    @RIndex String invoiceId;
    @RIndex String invoiceItemSeqId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ShipmentItemBillingData.Builder toDataBuilder() {
        ShipmentItemBillingData.Builder builder = ShipmentItemBillingData.newBuilder();
        if (shipmentId != null) {
            builder.setShipmentId(shipmentId);
        }
        if (shipmentItemSeqId != null) {
            builder.setShipmentItemSeqId(shipmentItemSeqId);
        }
        if (invoiceId != null) {
            builder.setInvoiceId(invoiceId);
        }
        if (invoiceItemSeqId != null) {
            builder.setInvoiceItemSeqId(invoiceItemSeqId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
        if (id != null) {
            builder.setId(id);
        }
                    
        return builder;
    }

    public static ShipmentItemBilling fromData(ShipmentItemBillingData data) {
        return ShipmentItemBilling.builder()
                .shipmentId(data.getShipmentId())
                .shipmentItemSeqId(data.getShipmentItemSeqId())
                .invoiceId(data.getInvoiceId())
                .invoiceItemSeqId(data.getInvoiceItemSeqId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}

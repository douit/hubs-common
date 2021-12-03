package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.ShipmentPackageContentData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentPackageContent implements IEventModel<ShipmentPackageContentData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String shipmentId;
    String shipmentPackageSeqId;
    String shipmentItemSeqId;
    java.math.BigDecimal quantity;
    String subProductId;
    java.math.BigDecimal subProductQuantity;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ShipmentPackageContentData.Builder toDataBuilder() {
        ShipmentPackageContentData.Builder builder = ShipmentPackageContentData.newBuilder();
        if (shipmentId != null) {
            builder.setShipmentId(shipmentId);
        }
        if (shipmentPackageSeqId != null) {
            builder.setShipmentPackageSeqId(shipmentPackageSeqId);
        }
        if (shipmentItemSeqId != null) {
            builder.setShipmentItemSeqId(shipmentItemSeqId);
        }
        if (quantity != null) {
            builder.setQuantity(getFixedPoint(quantity));
        }
        if (subProductId != null) {
            builder.setSubProductId(subProductId);
        }
        if (subProductQuantity != null) {
            builder.setSubProductQuantity(getFixedPoint(subProductQuantity));
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

    public static ShipmentPackageContent fromData(ShipmentPackageContentData data) {
        return ShipmentPackageContent.builder()
                .shipmentId(data.getShipmentId())
                .shipmentPackageSeqId(data.getShipmentPackageSeqId())
                .shipmentItemSeqId(data.getShipmentItemSeqId())
                .quantity(getBigDecimal(data.getQuantity()))
                .subProductId(data.getSubProductId())
                .subProductQuantity(getBigDecimal(data.getSubProductQuantity()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}

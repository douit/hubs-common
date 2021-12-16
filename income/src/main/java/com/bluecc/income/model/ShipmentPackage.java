//// Generated, DO NOT EDIT
package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;
// import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;
import static com.bluecc.hubs.fund.FnUtil.getter;

import com.bluecc.hubs.stub.ShipmentPackageData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ShipmentPackageData.class,
        symbol = EntityNames.ShipmentPackage)
public class ShipmentPackage implements IEventModel<ShipmentPackageData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String shipmentId;
    @RIndex String shipmentPackageSeqId;
    String shipmentBoxTypeId;
    java.time.LocalDateTime dateCreated;
    java.math.BigDecimal boxLength;
    java.math.BigDecimal boxHeight;
    java.math.BigDecimal boxWidth;
    String dimensionUomId;
    java.math.BigDecimal weight;
    String weightUomId;
    java.math.BigDecimal insuredValue;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ShipmentPackageData.Builder toDataBuilder() {
        ShipmentPackageData.Builder builder = ShipmentPackageData.newBuilder();
        if (shipmentId != null) {
            builder.setShipmentId(shipmentId);
        }
        if (shipmentPackageSeqId != null) {
            builder.setShipmentPackageSeqId(shipmentPackageSeqId);
        }
        if (shipmentBoxTypeId != null) {
            builder.setShipmentBoxTypeId(shipmentBoxTypeId);
        }
        if (dateCreated != null) {
            builder.setDateCreated(getTimestamp(dateCreated));
        }
        if (boxLength != null) {
            builder.setBoxLength(getFixedPoint(boxLength));
        }
        if (boxHeight != null) {
            builder.setBoxHeight(getFixedPoint(boxHeight));
        }
        if (boxWidth != null) {
            builder.setBoxWidth(getFixedPoint(boxWidth));
        }
        if (dimensionUomId != null) {
            builder.setDimensionUomId(dimensionUomId);
        }
        if (weight != null) {
            builder.setWeight(getFixedPoint(weight));
        }
        if (weightUomId != null) {
            builder.setWeightUomId(weightUomId);
        }
        if (insuredValue != null) {
            builder.setInsuredValue(getCurrency(insuredValue));
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

    public static ShipmentPackage fromData(ShipmentPackageData data) {
        return ShipmentPackage.builder()
                .shipmentId(data.getShipmentId())
                .shipmentPackageSeqId(data.getShipmentPackageSeqId())
                .shipmentBoxTypeId(data.getShipmentBoxTypeId())
                .dateCreated(getLocalDateTime(data.getDateCreated()))
                .boxLength(getBigDecimal(data.getBoxLength()))
                .boxHeight(getBigDecimal(data.getBoxHeight()))
                .boxWidth(getBigDecimal(data.getBoxWidth()))
                .dimensionUomId(data.getDimensionUomId())
                .weight(getBigDecimal(data.getWeight()))
                .weightUomId(data.getWeightUomId())
                .insuredValue(getBigDecimal(data.getInsuredValue()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: shipmentId, shipmentPackageSeqId

-- fields --
    
    String shipmentId
    String shipmentPackageSeqId
    String shipmentBoxTypeId
    java.time.LocalDateTime dateCreated
    java.math.BigDecimal boxLength
    java.math.BigDecimal boxHeight
    java.math.BigDecimal boxWidth
    String dimensionUomId
    java.math.BigDecimal weight
    String weightUomId
    java.math.BigDecimal insuredValue

-- relations --
    
    - Shipment (one, autoRelation: false, keymaps: shipmentId)
    - ShipmentBoxType (one, autoRelation: false, keymaps: shipmentBoxTypeId)
    + CarrierShipmentBoxType (many, autoRelation: false, keymaps: shipmentBoxTypeId)
    - DimensionUom (one, autoRelation: false, keymaps: dimensionUomId -> uomId)
    - WeightUom (one, autoRelation: false, keymaps: weightUomId -> uomId)
    + ShipmentPackageContent (many, autoRelation: true, keymaps: shipmentId, shipmentPackageSeqId)
    + ShipmentPackageRouteSeg (many, autoRelation: true, keymaps: shipmentId, shipmentPackageSeqId)
    + ShipmentReceipt (many, autoRelation: true, keymaps: shipmentId, shipmentPackageSeqId)
    + ShippingDocument (many, autoRelation: true, keymaps: shipmentId, shipmentPackageSeqId)
*/


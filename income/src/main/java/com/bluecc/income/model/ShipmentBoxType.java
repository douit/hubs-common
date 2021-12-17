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
import com.google.gson.annotations.SerializedName;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;
import static com.bluecc.hubs.fund.FnUtil.getter;

import com.bluecc.hubs.stub.ShipmentBoxTypeData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ShipmentBoxTypeData.class,
        symbol = EntityNames.ShipmentBoxType)
public class ShipmentBoxType implements IEventModel<ShipmentBoxTypeData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("shipment_box_type_id")
	@RId 
    String shipmentBoxTypeId;
    @SerializedName("description") 
    String description;
    @SerializedName("dimension_uom_id") 
    String dimensionUomId;
    @SerializedName("box_length") 
    java.math.BigDecimal boxLength;
    @SerializedName("box_width") 
    java.math.BigDecimal boxWidth;
    @SerializedName("box_height") 
    java.math.BigDecimal boxHeight;
    @SerializedName("weight_uom_id") 
    String weightUomId;
    @SerializedName("box_weight") 
    java.math.BigDecimal boxWeight;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    
    @Override
    public String getId(){
        return shipmentBoxTypeId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ShipmentBoxTypeData.Builder toDataBuilder() {
        ShipmentBoxTypeData.Builder builder = ShipmentBoxTypeData.newBuilder();
        if (shipmentBoxTypeId != null) {
            builder.setShipmentBoxTypeId(shipmentBoxTypeId);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (dimensionUomId != null) {
            builder.setDimensionUomId(dimensionUomId);
        }
        if (boxLength != null) {
            builder.setBoxLength(getFixedPoint(boxLength));
        }
        if (boxWidth != null) {
            builder.setBoxWidth(getFixedPoint(boxWidth));
        }
        if (boxHeight != null) {
            builder.setBoxHeight(getFixedPoint(boxHeight));
        }
        if (weightUomId != null) {
            builder.setWeightUomId(weightUomId);
        }
        if (boxWeight != null) {
            builder.setBoxWeight(getFixedPoint(boxWeight));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static ShipmentBoxType fromData(ShipmentBoxTypeData data) {
        return ShipmentBoxType.builder()
                .shipmentBoxTypeId(data.getShipmentBoxTypeId())
                .description(data.getDescription())
                .dimensionUomId(data.getDimensionUomId())
                .boxLength(getBigDecimal(data.getBoxLength()))
                .boxWidth(getBigDecimal(data.getBoxWidth()))
                .boxHeight(getBigDecimal(data.getBoxHeight()))
                .weightUomId(data.getWeightUomId())
                .boxWeight(getBigDecimal(data.getBoxWeight()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: shipmentBoxTypeId

-- fields --
    
    String shipmentBoxTypeId
    String description
    String dimensionUomId
    java.math.BigDecimal boxLength
    java.math.BigDecimal boxWidth
    java.math.BigDecimal boxHeight
    String weightUomId
    java.math.BigDecimal boxWeight

-- relations --
    
    - DimensionUom (one, autoRelation: false, keymaps: dimensionUomId -> uomId)
    - WeightUom (one, autoRelation: false, keymaps: weightUomId -> uomId)
    + CarrierShipmentBoxType (many, autoRelation: true, keymaps: shipmentBoxTypeId)
    + DefaultProduct (many, autoRelation: true, keymaps: shipmentBoxTypeId -> defaultShipmentBoxTypeId)
    + ShipmentPackage (many, autoRelation: true, keymaps: shipmentBoxTypeId)
*/


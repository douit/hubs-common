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
import org.redisson.api.annotation.*;

import com.bluecc.hubs.stub.ShipmentBoxTypeData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class ShipmentBoxType implements IEventModel<ShipmentBoxTypeData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String shipmentBoxTypeId;
    String description;
    String dimensionUomId;
    java.math.BigDecimal boxLength;
    java.math.BigDecimal boxWidth;
    java.math.BigDecimal boxHeight;
    String weightUomId;
    java.math.BigDecimal boxWeight;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
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

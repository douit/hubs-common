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

import com.bluecc.hubs.stub.ProductFacilityLocationData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductFacilityLocationData.class,
        symbol = EntityNames.ProductFacilityLocation)
public class ProductFacilityLocation implements IEventModel<ProductFacilityLocationData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_id")
	@RIndex 
    String productId;
    @SerializedName("facility_id")
	@RIndex 
    String facilityId;
    @SerializedName("location_seq_id")
	@RIndex 
    String locationSeqId;
    @SerializedName("minimum_stock") 
    java.math.BigDecimal minimumStock;
    @SerializedName("move_quantity") 
    java.math.BigDecimal moveQuantity;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    @SerializedName("id")
	@RId 
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductFacilityLocationData.Builder toDataBuilder() {
        ProductFacilityLocationData.Builder builder = ProductFacilityLocationData.newBuilder();
        if (getProductId() != null) {
            builder.setProductId(getProductId());
        }
        if (getFacilityId() != null) {
            builder.setFacilityId(getFacilityId());
        }
        if (getLocationSeqId() != null) {
            builder.setLocationSeqId(getLocationSeqId());
        }
        if (getMinimumStock() != null) {
            builder.setMinimumStock(getFixedPoint(getMinimumStock()));
        }
        if (getMoveQuantity() != null) {
            builder.setMoveQuantity(getFixedPoint(getMoveQuantity()));
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
        if (getId() != null) {
            builder.setId(getId());
        }
                    
        return builder;
    }

    public static ProductFacilityLocation fromData(ProductFacilityLocationData data) {
        return fromPrototype(data).build();
    }

    public static ProductFacilityLocation.ProductFacilityLocationBuilder fromPrototype(ProductFacilityLocationData data) {
        return ProductFacilityLocation.builder()
                .productId(data.getProductId())
                .facilityId(data.getFacilityId())
                .locationSeqId(data.getLocationSeqId())
                .minimumStock(getBigDecimal(data.getMinimumStock()))
                .moveQuantity(getBigDecimal(data.getMoveQuantity()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: productId, facilityId, locationSeqId

-- fields --
    
    String productId
    String facilityId
    String locationSeqId
    java.math.BigDecimal minimumStock
    java.math.BigDecimal moveQuantity

-- relations --
    
    - Product (one, autoRelation: false, keymaps: productId)
    - Facility (one-nofk, autoRelation: false, keymaps: facilityId)
    - FacilityLocation (one, autoRelation: false, keymaps: facilityId, locationSeqId)
    + InventoryItem (many, autoRelation: true, keymaps: productId, facilityId, locationSeqId)
*/


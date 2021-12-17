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

import com.bluecc.hubs.stub.ProductFacilityData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductFacilityData.class,
        symbol = EntityNames.ProductFacility)
public class ProductFacility implements IEventModel<ProductFacilityData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_id")
	@RIndex 
    String productId;
    @SerializedName("facility_id")
	@RIndex 
    String facilityId;
    @SerializedName("minimum_stock") 
    java.math.BigDecimal minimumStock;
    @SerializedName("reorder_quantity") 
    java.math.BigDecimal reorderQuantity;
    @SerializedName("days_to_ship") 
    Long daysToShip;
    @SerializedName("replenish_method_enum_id") 
    String replenishMethodEnumId;
    @SerializedName("last_inventory_count") 
    java.math.BigDecimal lastInventoryCount;
    @SerializedName("requirement_method_enum_id") 
    String requirementMethodEnumId;
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

    public ProductFacilityData.Builder toDataBuilder() {
        ProductFacilityData.Builder builder = ProductFacilityData.newBuilder();
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (facilityId != null) {
            builder.setFacilityId(facilityId);
        }
        if (minimumStock != null) {
            builder.setMinimumStock(getFixedPoint(minimumStock));
        }
        if (reorderQuantity != null) {
            builder.setReorderQuantity(getFixedPoint(reorderQuantity));
        }
        if (daysToShip != null) {
            builder.setDaysToShip(daysToShip);
        }
        if (replenishMethodEnumId != null) {
            builder.setReplenishMethodEnumId(replenishMethodEnumId);
        }
        if (lastInventoryCount != null) {
            builder.setLastInventoryCount(getFixedPoint(lastInventoryCount));
        }
        if (requirementMethodEnumId != null) {
            builder.setRequirementMethodEnumId(requirementMethodEnumId);
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

    public static ProductFacility fromData(ProductFacilityData data) {
        return ProductFacility.builder()
                .productId(data.getProductId())
                .facilityId(data.getFacilityId())
                .minimumStock(getBigDecimal(data.getMinimumStock()))
                .reorderQuantity(getBigDecimal(data.getReorderQuantity()))
                .daysToShip(data.getDaysToShip())
                .replenishMethodEnumId(data.getReplenishMethodEnumId())
                .lastInventoryCount(getBigDecimal(data.getLastInventoryCount()))
                .requirementMethodEnumId(data.getRequirementMethodEnumId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: productId, facilityId

-- fields --
    
    String productId
    String facilityId
    java.math.BigDecimal minimumStock
    java.math.BigDecimal reorderQuantity
    Long daysToShip
    String replenishMethodEnumId
    java.math.BigDecimal lastInventoryCount
    String requirementMethodEnumId

-- relations --
    
    - Product (one, autoRelation: false, keymaps: productId)
    - Facility (one, autoRelation: false, keymaps: facilityId)
    - RequirementMethodEnumeration (one, autoRelation: false, keymaps: requirementMethodEnumId -> enumId)
    - Enumeration (one, autoRelation: false, keymaps: replenishMethodEnumId -> enumId)
    + InventoryItem (many, autoRelation: true, keymaps: productId, facilityId)
*/


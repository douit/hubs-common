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

import com.bluecc.hubs.stub.SupplierProductFeatureData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = SupplierProductFeatureData.class,
        symbol = EntityNames.SupplierProductFeature)
public class SupplierProductFeature implements IEventModel<SupplierProductFeatureData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("party_id")
	@RIndex 
    String partyId;
    @SerializedName("product_feature_id")
	@RIndex 
    String productFeatureId;
    @SerializedName("description") 
    String description;
    @SerializedName("uom_id") 
    String uomId;
    @SerializedName("id_code") 
    String idCode;
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

    public SupplierProductFeatureData.Builder toDataBuilder() {
        SupplierProductFeatureData.Builder builder = SupplierProductFeatureData.newBuilder();
        if (getPartyId() != null) {
            builder.setPartyId(getPartyId());
        }
        if (getProductFeatureId() != null) {
            builder.setProductFeatureId(getProductFeatureId());
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getUomId() != null) {
            builder.setUomId(getUomId());
        }
        if (getIdCode() != null) {
            builder.setIdCode(getIdCode());
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

    public static SupplierProductFeature fromData(SupplierProductFeatureData data) {
        return fromPrototype(data).build();
    }

    public static SupplierProductFeature.SupplierProductFeatureBuilder fromPrototype(SupplierProductFeatureData data) {
        return SupplierProductFeature.builder()
                .partyId(data.getPartyId())
                .productFeatureId(data.getProductFeatureId())
                .description(data.getDescription())
                .uomId(data.getUomId())
                .idCode(data.getIdCode())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: partyId, productFeatureId

-- fields --
    
    String partyId
    String productFeatureId
    String description
    String uomId
    String idCode

-- relations --
    
    - Party (one, autoRelation: false, keymaps: partyId)
    - ProductFeature (one, autoRelation: false, keymaps: productFeatureId)
    - Uom (one, autoRelation: false, keymaps: uomId)
*/


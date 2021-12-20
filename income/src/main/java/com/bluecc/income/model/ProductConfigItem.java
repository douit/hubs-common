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

import com.bluecc.hubs.stub.ProductConfigItemData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductConfigItemData.class,
        symbol = EntityNames.ProductConfigItem)
public class ProductConfigItem implements IEventModel<ProductConfigItemData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("config_item_id")
	@RId 
    String configItemId;
    @SerializedName("config_item_type_id") 
    String configItemTypeId;
    @SerializedName("config_item_name") 
    String configItemName;
    @SerializedName("description") 
    String description;
    @SerializedName("long_description") 
    String longDescription;
    @SerializedName("image_url") 
    String imageUrl;
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
        return configItemId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductConfigItemData.Builder toDataBuilder() {
        ProductConfigItemData.Builder builder = ProductConfigItemData.newBuilder();
        if (getConfigItemId() != null) {
            builder.setConfigItemId(getConfigItemId());
        }
        if (getConfigItemTypeId() != null) {
            builder.setConfigItemTypeId(getConfigItemTypeId());
        }
        if (getConfigItemName() != null) {
            builder.setConfigItemName(getConfigItemName());
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getLongDescription() != null) {
            builder.setLongDescription(getLongDescription());
        }
        if (getImageUrl() != null) {
            builder.setImageUrl(getImageUrl());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static ProductConfigItem fromData(ProductConfigItemData data) {
        return fromPrototype(data).build();
    }

    public static ProductConfigItem.ProductConfigItemBuilder fromPrototype(ProductConfigItemData data) {
        return ProductConfigItem.builder()
                .configItemId(data.getConfigItemId())
                .configItemTypeId(data.getConfigItemTypeId())
                .configItemName(data.getConfigItemName())
                .description(data.getDescription())
                .longDescription(data.getLongDescription())
                .imageUrl(data.getImageUrl())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
    }

    
}


/*
-- keys: configItemId

-- fields --
    
    String configItemId
    String configItemTypeId
    String configItemName
    String description
    String longDescription
    String imageUrl

-- relations --
    
    + ProdConfItemContent (many, autoRelation: true, keymaps: configItemId)
    + ConfigItemProductConfig (many, autoRelation: true, keymaps: configItemId)
    + ConfigItemProductConfigConfig (many, autoRelation: true, keymaps: configItemId)
    + ConfigItemProductConfigOption (many, autoRelation: true, keymaps: configItemId)
    + ConfigItemProductConfigOptionIactn (many, autoRelation: true, keymaps: configItemId)
    + ConfigItemToProductConfigOptionIactn (many, autoRelation: true, keymaps: configItemId -> configItemIdTo)
    + ConfigItemProductConfigProduct (many, autoRelation: true, keymaps: configItemId)
*/


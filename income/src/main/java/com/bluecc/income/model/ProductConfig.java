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

import com.bluecc.hubs.stub.ProductConfigData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductConfigData.class,
        symbol = EntityNames.ProductConfig)
public class ProductConfig implements IEventModel<ProductConfigData.Builder>, HasId, Serializable, WithDescription, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_id")
	@RIndex 
    String productId;
    @SerializedName("config_item_id")
	@RIndex 
    String configItemId;
    @SerializedName("sequence_num")
	@RIndex 
    Long sequenceNum;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("description") 
    String description;
    @SerializedName("long_description") 
    String longDescription;
    @SerializedName("config_type_id") 
    String configTypeId;
    @SerializedName("default_config_option_id") 
    String defaultConfigOptionId;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("is_mandatory") 
    Character isMandatory;
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

    public ProductConfigData.Builder toDataBuilder() {
        ProductConfigData.Builder builder = ProductConfigData.newBuilder();
        if (getProductId() != null) {
            builder.setProductId(getProductId());
        }
        if (getConfigItemId() != null) {
            builder.setConfigItemId(getConfigItemId());
        }
        if (getSequenceNum() != null) {
            builder.setSequenceNum(getSequenceNum());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getLongDescription() != null) {
            builder.setLongDescription(getLongDescription());
        }
        if (getConfigTypeId() != null) {
            builder.setConfigTypeId(getConfigTypeId());
        }
        if (getDefaultConfigOptionId() != null) {
            builder.setDefaultConfigOptionId(getDefaultConfigOptionId());
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
        }
        if (getIsMandatory() != null) {
            builder.setIsMandatory(getIndicator(getIsMandatory()));
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

    public static ProductConfig fromData(ProductConfigData data) {
        return fromPrototype(data).build();
    }

    public static ProductConfig.ProductConfigBuilder fromPrototype(ProductConfigData data) {
        return ProductConfig.builder()
                .productId(data.getProductId())
                .configItemId(data.getConfigItemId())
                .sequenceNum(data.getSequenceNum())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .description(data.getDescription())
                .longDescription(data.getLongDescription())
                .configTypeId(data.getConfigTypeId())
                .defaultConfigOptionId(data.getDefaultConfigOptionId())
                .thruDate(getLocalDateTime(data.getThruDate()))
                .isMandatory(getIndicatorChar(data.getIsMandatory()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: productId, configItemId, sequenceNum, fromDate

-- fields --
    
    String productId
    String configItemId
    Long sequenceNum
    java.time.LocalDateTime fromDate
    String description
    String longDescription
    String configTypeId
    String defaultConfigOptionId
    java.time.LocalDateTime thruDate
    Character isMandatory

-- relations --
    
    - ProductProduct (one, autoRelation: false, keymaps: productId)
    - ConfigItemProductConfigItem (one, autoRelation: false, keymaps: configItemId)
*/


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

import com.bluecc.hubs.stub.ProductConfigOptionData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductConfigOptionData.class,
        symbol = EntityNames.ProductConfigOption)
public class ProductConfigOption implements IEventModel<ProductConfigOptionData.Builder>, HasId, Serializable, WithDescription, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("config_item_id")
	@RIndex 
    String configItemId;
    @SerializedName("config_option_id")
	@RIndex 
    String configOptionId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("config_option_name") 
    String configOptionName;
    @SerializedName("description") 
    String description;
    @SerializedName("sequence_num") 
    Long sequenceNum;
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

    public ProductConfigOptionData.Builder toDataBuilder() {
        ProductConfigOptionData.Builder builder = ProductConfigOptionData.newBuilder();
        if (configItemId != null) {
            builder.setConfigItemId(configItemId);
        }
        if (configOptionId != null) {
            builder.setConfigOptionId(configOptionId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (configOptionName != null) {
            builder.setConfigOptionName(configOptionName);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (sequenceNum != null) {
            builder.setSequenceNum(sequenceNum);
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

    public static ProductConfigOption fromData(ProductConfigOptionData data) {
        return ProductConfigOption.builder()
                .configItemId(data.getConfigItemId())
                .configOptionId(data.getConfigOptionId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .configOptionName(data.getConfigOptionName())
                .description(data.getDescription())
                .sequenceNum(data.getSequenceNum())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: configItemId, configOptionId

-- fields --
    
    String configItemId
    String configOptionId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    String configOptionName
    String description
    Long sequenceNum

-- relations --
    
    - ConfigItemProductConfigItem (one, autoRelation: false, keymaps: configItemId)
    + ConfigOptionProductConfigConfig (many, autoRelation: true, keymaps: configItemId, configOptionId)
    + ConfigOptionProductConfigOptionIactn (many, autoRelation: true, keymaps: configItemId, configOptionId)
    + ConfigOptionToProductConfigOptionIactn (many, autoRelation: true, keymaps: configItemId -> configItemIdTo, configOptionId -> configOptionIdTo)
    + ConfigOptionProductConfigProduct (many, autoRelation: true, keymaps: configItemId, configOptionId)
*/


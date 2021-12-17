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

import com.bluecc.hubs.stub.FixedAssetDepMethodData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = FixedAssetDepMethodData.class,
        symbol = EntityNames.FixedAssetDepMethod)
public class FixedAssetDepMethod implements IEventModel<FixedAssetDepMethodData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("depreciation_custom_method_id")
	@RIndex 
    String depreciationCustomMethodId;
    @SerializedName("fixed_asset_id")
	@RIndex 
    String fixedAssetId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
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

    public FixedAssetDepMethodData.Builder toDataBuilder() {
        FixedAssetDepMethodData.Builder builder = FixedAssetDepMethodData.newBuilder();
        if (depreciationCustomMethodId != null) {
            builder.setDepreciationCustomMethodId(depreciationCustomMethodId);
        }
        if (fixedAssetId != null) {
            builder.setFixedAssetId(fixedAssetId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
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

    public static FixedAssetDepMethod fromData(FixedAssetDepMethodData data) {
        return FixedAssetDepMethod.builder()
                .depreciationCustomMethodId(data.getDepreciationCustomMethodId())
                .fixedAssetId(data.getFixedAssetId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: depreciationCustomMethodId, fixedAssetId

-- fields --
    
    String depreciationCustomMethodId
    String fixedAssetId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate

-- relations --
    
    - CustomMethod (one, autoRelation: false, keymaps: depreciationCustomMethodId -> customMethodId)
    - FixedAsset (one, autoRelation: false, keymaps: fixedAssetId)
*/


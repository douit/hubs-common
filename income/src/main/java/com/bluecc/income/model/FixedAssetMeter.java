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

import com.bluecc.hubs.stub.FixedAssetMeterData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = FixedAssetMeterData.class,
        symbol = EntityNames.FixedAssetMeter)
public class FixedAssetMeter implements IEventModel<FixedAssetMeterData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("fixed_asset_id")
	@RIndex 
    String fixedAssetId;
    @SerializedName("product_meter_type_id")
	@RIndex 
    String productMeterTypeId;
    @SerializedName("reading_date") 
    java.time.LocalDateTime readingDate;
    @SerializedName("meter_value") 
    java.math.BigDecimal meterValue;
    @SerializedName("reading_reason_enum_id") 
    String readingReasonEnumId;
    @SerializedName("maint_hist_seq_id") 
    String maintHistSeqId;
    @SerializedName("work_effort_id") 
    String workEffortId;
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

    public FixedAssetMeterData.Builder toDataBuilder() {
        FixedAssetMeterData.Builder builder = FixedAssetMeterData.newBuilder();
        if (fixedAssetId != null) {
            builder.setFixedAssetId(fixedAssetId);
        }
        if (productMeterTypeId != null) {
            builder.setProductMeterTypeId(productMeterTypeId);
        }
        if (readingDate != null) {
            builder.setReadingDate(getTimestamp(readingDate));
        }
        if (meterValue != null) {
            builder.setMeterValue(getFixedPoint(meterValue));
        }
        if (readingReasonEnumId != null) {
            builder.setReadingReasonEnumId(readingReasonEnumId);
        }
        if (maintHistSeqId != null) {
            builder.setMaintHistSeqId(maintHistSeqId);
        }
        if (workEffortId != null) {
            builder.setWorkEffortId(workEffortId);
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

    public static FixedAssetMeter fromData(FixedAssetMeterData data) {
        return FixedAssetMeter.builder()
                .fixedAssetId(data.getFixedAssetId())
                .productMeterTypeId(data.getProductMeterTypeId())
                .readingDate(getLocalDateTime(data.getReadingDate()))
                .meterValue(getBigDecimal(data.getMeterValue()))
                .readingReasonEnumId(data.getReadingReasonEnumId())
                .maintHistSeqId(data.getMaintHistSeqId())
                .workEffortId(data.getWorkEffortId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: fixedAssetId, productMeterTypeId, readingDate

-- fields --
    
    String fixedAssetId
    String productMeterTypeId
    java.time.LocalDateTime readingDate
    java.math.BigDecimal meterValue
    String readingReasonEnumId
    String maintHistSeqId
    String workEffortId

-- relations --
    
    - FixedAssetMaint (one, autoRelation: false, keymaps: fixedAssetId, maintHistSeqId)
    - ProductMeterType (one, autoRelation: false, keymaps: productMeterTypeId)
*/


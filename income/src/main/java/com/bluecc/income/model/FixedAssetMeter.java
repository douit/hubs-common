package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;

import com.bluecc.hubs.stub.FixedAssetMeterData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = FixedAssetMeterData.class,
        symbol = EntityNames.FixedAssetMeter)
public class FixedAssetMeter implements IEventModel<FixedAssetMeterData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String fixedAssetId;
    @RIndex String productMeterTypeId;
    java.time.LocalDateTime readingDate;
    java.math.BigDecimal meterValue;
    String readingReasonEnumId;
    String maintHistSeqId;
    String workEffortId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
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


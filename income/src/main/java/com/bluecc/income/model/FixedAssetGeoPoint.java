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
import com.bluecc.hubs.stub.FixedAssetGeoPointData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FixedAssetGeoPoint implements IEventModel<FixedAssetGeoPointData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String fixedAssetId;
    String geoPointId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public FixedAssetGeoPointData.Builder toDataBuilder() {
        FixedAssetGeoPointData.Builder builder = FixedAssetGeoPointData.newBuilder();
        if (fixedAssetId != null) {
            builder.setFixedAssetId(fixedAssetId);
        }
        if (geoPointId != null) {
            builder.setGeoPointId(geoPointId);
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

    public static FixedAssetGeoPoint fromData(FixedAssetGeoPointData data) {
        return FixedAssetGeoPoint.builder()
                .fixedAssetId(data.getFixedAssetId())
                .geoPointId(data.getGeoPointId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}

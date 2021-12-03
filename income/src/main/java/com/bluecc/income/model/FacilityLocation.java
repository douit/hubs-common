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
import com.bluecc.hubs.stub.FacilityLocationData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FacilityLocation implements IEventModel<FacilityLocationData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String facilityId;
    String locationSeqId;
    String locationTypeEnumId;
    String areaId;
    String aisleId;
    String sectionId;
    String levelId;
    String positionId;
    String geoPointId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public FacilityLocationData.Builder toDataBuilder() {
        FacilityLocationData.Builder builder = FacilityLocationData.newBuilder();
        if (facilityId != null) {
            builder.setFacilityId(facilityId);
        }
        if (locationSeqId != null) {
            builder.setLocationSeqId(locationSeqId);
        }
        if (locationTypeEnumId != null) {
            builder.setLocationTypeEnumId(locationTypeEnumId);
        }
        if (areaId != null) {
            builder.setAreaId(areaId);
        }
        if (aisleId != null) {
            builder.setAisleId(aisleId);
        }
        if (sectionId != null) {
            builder.setSectionId(sectionId);
        }
        if (levelId != null) {
            builder.setLevelId(levelId);
        }
        if (positionId != null) {
            builder.setPositionId(positionId);
        }
        if (geoPointId != null) {
            builder.setGeoPointId(geoPointId);
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

    public static FacilityLocation fromData(FacilityLocationData data) {
        return FacilityLocation.builder()
                .facilityId(data.getFacilityId())
                .locationSeqId(data.getLocationSeqId())
                .locationTypeEnumId(data.getLocationTypeEnumId())
                .areaId(data.getAreaId())
                .aisleId(data.getAisleId())
                .sectionId(data.getSectionId())
                .levelId(data.getLevelId())
                .positionId(data.getPositionId())
                .geoPointId(data.getGeoPointId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}

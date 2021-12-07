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
import org.redisson.api.annotation.*;

import com.bluecc.hubs.stub.GeoPointData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class GeoPoint implements IEventModel<GeoPointData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String geoPointId;
    String geoPointTypeEnumId;
    String description;
    String dataSourceId;
    String latitude;
    String longitude;
    java.math.BigDecimal elevation;
    String elevationUomId;
    String information;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public GeoPointData.Builder toDataBuilder() {
        GeoPointData.Builder builder = GeoPointData.newBuilder();
        if (geoPointId != null) {
            builder.setGeoPointId(geoPointId);
        }
        if (geoPointTypeEnumId != null) {
            builder.setGeoPointTypeEnumId(geoPointTypeEnumId);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (dataSourceId != null) {
            builder.setDataSourceId(dataSourceId);
        }
        if (latitude != null) {
            builder.setLatitude(latitude);
        }
        if (longitude != null) {
            builder.setLongitude(longitude);
        }
        if (elevation != null) {
            builder.setElevation(getFixedPoint(elevation));
        }
        if (elevationUomId != null) {
            builder.setElevationUomId(elevationUomId);
        }
        if (information != null) {
            builder.setInformation(information);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static GeoPoint fromData(GeoPointData data) {
        return GeoPoint.builder()
                .geoPointId(data.getGeoPointId())
                .geoPointTypeEnumId(data.getGeoPointTypeEnumId())
                .description(data.getDescription())
                .dataSourceId(data.getDataSourceId())
                .latitude(data.getLatitude())
                .longitude(data.getLongitude())
                .elevation(getBigDecimal(data.getElevation()))
                .elevationUomId(data.getElevationUomId())
                .information(data.getInformation())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}

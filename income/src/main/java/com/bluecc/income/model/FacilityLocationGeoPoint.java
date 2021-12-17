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

import com.bluecc.hubs.stub.FacilityLocationGeoPointData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = FacilityLocationGeoPointData.class,
        symbol = EntityNames.FacilityLocationGeoPoint)
public class FacilityLocationGeoPoint implements IEventModel<FacilityLocationGeoPointData.Builder>, HasId, Serializable, WithLocation, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("facility_id")
	@RIndex 
    String facilityId;
    @SerializedName("location_seq_id")
	@RIndex 
    String locationSeqId;
    @SerializedName("geo_point_id")
	@RIndex 
    String geoPointId;
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

    public FacilityLocationGeoPointData.Builder toDataBuilder() {
        FacilityLocationGeoPointData.Builder builder = FacilityLocationGeoPointData.newBuilder();
        if (facilityId != null) {
            builder.setFacilityId(facilityId);
        }
        if (locationSeqId != null) {
            builder.setLocationSeqId(locationSeqId);
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

    public static FacilityLocationGeoPoint fromData(FacilityLocationGeoPointData data) {
        return FacilityLocationGeoPoint.builder()
                .facilityId(data.getFacilityId())
                .locationSeqId(data.getLocationSeqId())
                .geoPointId(data.getGeoPointId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: facilityId, locationSeqId, geoPointId, fromDate

-- fields --
    
    String facilityId
    String locationSeqId
    String geoPointId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate

-- relations --
    
    - FacilityLocation (one, autoRelation: false, keymaps: facilityId, locationSeqId)
    - GeoPoint (one, autoRelation: false, keymaps: geoPointId)
*/


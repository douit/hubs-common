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
        if (getFacilityId() != null) {
            builder.setFacilityId(getFacilityId());
        }
        if (getLocationSeqId() != null) {
            builder.setLocationSeqId(getLocationSeqId());
        }
        if (getGeoPointId() != null) {
            builder.setGeoPointId(getGeoPointId());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
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

    public static FacilityLocationGeoPoint fromData(FacilityLocationGeoPointData data) {
        return fromPrototype(data).build();
    }

    public static FacilityLocationGeoPoint.FacilityLocationGeoPointBuilder fromPrototype(FacilityLocationGeoPointData data) {
        return FacilityLocationGeoPoint.builder()
                .facilityId(data.getFacilityId())
                .locationSeqId(data.getLocationSeqId())
                .geoPointId(data.getGeoPointId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
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


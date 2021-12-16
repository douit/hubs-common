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

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;
import static com.bluecc.hubs.fund.FnUtil.getter;

import com.bluecc.hubs.stub.ProductFacilityAssocData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductFacilityAssocData.class,
        symbol = EntityNames.ProductFacilityAssoc)
public class ProductFacilityAssoc implements IEventModel<ProductFacilityAssocData.Builder>, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @RIndex String productId;
    @RIndex String facilityId;
    @RIndex String facilityIdTo;
    @RIndex String facilityAssocTypeId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    Long sequenceNum;
    Long transitTime;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductFacilityAssocData.Builder toDataBuilder() {
        ProductFacilityAssocData.Builder builder = ProductFacilityAssocData.newBuilder();
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (facilityId != null) {
            builder.setFacilityId(facilityId);
        }
        if (facilityIdTo != null) {
            builder.setFacilityIdTo(facilityIdTo);
        }
        if (facilityAssocTypeId != null) {
            builder.setFacilityAssocTypeId(facilityAssocTypeId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (sequenceNum != null) {
            builder.setSequenceNum(sequenceNum);
        }
        if (transitTime != null) {
            builder.setTransitTime(transitTime);
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

    public static ProductFacilityAssoc fromData(ProductFacilityAssocData data) {
        return ProductFacilityAssoc.builder()
                .productId(data.getProductId())
                .facilityId(data.getFacilityId())
                .facilityIdTo(data.getFacilityIdTo())
                .facilityAssocTypeId(data.getFacilityAssocTypeId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .sequenceNum(data.getSequenceNum())
                .transitTime(data.getTransitTime())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: productId, facilityId, facilityIdTo, facilityAssocTypeId, fromDate

-- fields --
    
    String productId
    String facilityId
    String facilityIdTo
    String facilityAssocTypeId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    Long sequenceNum
    Long transitTime

-- relations --
    
    - Product (one, autoRelation: false, keymaps: productId)
    - FromFacility (one, autoRelation: false, keymaps: facilityId)
    - ToFacility (one, autoRelation: false, keymaps: facilityIdTo -> facilityId)
    - FacilityAssocType (one, autoRelation: false, keymaps: facilityAssocTypeId)
*/


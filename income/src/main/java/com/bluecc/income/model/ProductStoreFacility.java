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

import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;

import com.bluecc.hubs.stub.ProductStoreFacilityFlatData;

import com.bluecc.hubs.stub.ProductStoreFacilityData;
import com.bluecc.income.dao.ProductStoreFacilityDelegator;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductStoreFacilityData.class,
        symbol = EntityNames.ProductStoreFacility)
public class ProductStoreFacility implements IEventModel<ProductStoreFacilityFlatData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String productStoreId;
    @RIndex String facilityId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    Long sequenceNum;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductStoreFacilityFlatData.Builder toDataBuilder() {
        ProductStoreFacilityFlatData.Builder builder = ProductStoreFacilityFlatData.newBuilder();
        if (productStoreId != null) {
            builder.setProductStoreId(productStoreId);
        }
        if (facilityId != null) {
            builder.setFacilityId(facilityId);
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

    public static ProductStoreFacility fromData(ProductStoreFacilityFlatData data) {
        return ProductStoreFacility.builder()
                .productStoreId(data.getProductStoreId())
                .facilityId(data.getFacilityId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .sequenceNum(data.getSequenceNum())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

        // relations
     
    @Exclude
    List<ProductStore> relProductStore= new ArrayList<>();

    public ProductStoreFacilityDelegator.Agent agent(IProc.ProcContext ctx,
                                             ProductStoreFacilityDelegator delegator){
        return delegator.getAgent(ctx, this.getId());
    }

    public ProductStoreFacilityData.Builder toHeadBuilder() {
        ProductStoreFacilityData.Builder builder = ProductStoreFacilityData.newBuilder();
        if (productStoreId != null) {
            builder.setProductStoreId(productStoreId);
        }
        if (facilityId != null) {
            builder.setFacilityId(facilityId);
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

}

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

import com.bluecc.hubs.stub.ProductStoreFacilityFlatData;

import com.bluecc.hubs.stub.ProductStoreFacilityData;
import com.bluecc.income.dao.ProductStoreFacilityDelegator;
import static com.bluecc.income.dao.ProductStoreFacilityDelegator.*;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductStoreFacilityData.class,
        symbol = EntityNames.ProductStoreFacility)
public class ProductStoreFacility implements IEventModel<ProductStoreFacilityFlatData.Builder>, HasId, Serializable, WithSuppliers, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_store_id")
	@RIndex 
    String productStoreId;
    @SerializedName("facility_id")
	@RIndex 
    String facilityId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("sequence_num") 
    Long sequenceNum;
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
    @SerializedName("tenant_id") 
    String tenantId;
    

        
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
        if (tenantId != null) {
            builder.setTenantId(tenantId);
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
                .tenantId(data.getTenantId())
                
                .build();
    }

        // relations
     
    @Exclude
    @Singular("addProductStore")
    @SerializedName("product_store") 
    List<ProductStore> relProductStore= new ArrayList<>(); 
    @Exclude
    @Singular("addFacility")
    @SerializedName("facility") 
    List<Facility> relFacility= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    @SerializedName("tenant") 
    List<Tenant> relTenant= new ArrayList<>();

    public Map<String, Supplier<List<?>>> suppliers(){
        Map<String, Supplier<List<?>>> supplierMap=Maps.newHashMap();
         
        supplierMap.put(PRODUCT_STORE, getter(this, ProductStoreFacility::getRelProductStore)); 
        supplierMap.put(FACILITY, getter(this, ProductStoreFacility::getRelFacility)); 
        supplierMap.put(TENANT, getter(this, ProductStoreFacility::getRelTenant));

        return supplierMap;
    };

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


/*
-- keys: productStoreId, facilityId, fromDate

-- fields --
    
    String productStoreId
    String facilityId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    Long sequenceNum

-- relations --
    
    - ProductStore (one, autoRelation: false, keymaps: productStoreId)
    - Facility (one, autoRelation: false, keymaps: facilityId)
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/


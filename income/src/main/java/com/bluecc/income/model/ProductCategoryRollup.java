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

import com.bluecc.hubs.stub.ProductCategoryRollupFlatData;

import com.bluecc.hubs.stub.ProductCategoryRollupData;
import com.bluecc.income.dao.ProductCategoryRollupDelegator;
import static com.bluecc.income.dao.ProductCategoryRollupDelegator.*;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductCategoryRollupData.class,
        symbol = EntityNames.ProductCategoryRollup)
public class ProductCategoryRollup implements IEventModel<ProductCategoryRollupFlatData.Builder>, HasId, Serializable, WithSuppliers, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_category_id")
	@RIndex 
    String productCategoryId;
    @SerializedName("parent_product_category_id")
	@RIndex 
    String parentProductCategoryId;
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

    public ProductCategoryRollupFlatData.Builder toDataBuilder() {
        ProductCategoryRollupFlatData.Builder builder = ProductCategoryRollupFlatData.newBuilder();
        if (getProductCategoryId() != null) {
            builder.setProductCategoryId(getProductCategoryId());
        }
        if (getParentProductCategoryId() != null) {
            builder.setParentProductCategoryId(getParentProductCategoryId());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
        }
        if (getSequenceNum() != null) {
            builder.setSequenceNum(getSequenceNum());
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
        if (getTenantId() != null) {
            builder.setTenantId(getTenantId());
        }
                    
        return builder;
    }

    public static ProductCategoryRollup fromData(ProductCategoryRollupFlatData data) {
        return fromPrototype(data).build();
    }

    public static ProductCategoryRollup.ProductCategoryRollupBuilder fromPrototype(ProductCategoryRollupFlatData data) {
        return ProductCategoryRollup.builder()
                .productCategoryId(data.getProductCategoryId())
                .parentProductCategoryId(data.getParentProductCategoryId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .sequenceNum(data.getSequenceNum())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                .tenantId(data.getTenantId())
                ;
    }

        // relations
     
    @Exclude
    @Singular("addCurrentProductCategory")
    @SerializedName("current_product_category") 
    List<ProductCategory> relCurrentProductCategory= new ArrayList<>(); 
    @Exclude
    @Singular("addParentProductCategory")
    @SerializedName("parent_product_category") 
    List<ProductCategory> relParentProductCategory= new ArrayList<>(); 
    @Exclude
    @Singular("addChildProductCategoryRollup")
    @SerializedName("child_product_category_rollup") 
    List<ProductCategoryRollup> relChildProductCategoryRollup= new ArrayList<>(); 
    @Exclude
    @Singular("addParentProductCategoryRollup")
    @SerializedName("parent_product_category_rollup") 
    List<ProductCategoryRollup> relParentProductCategoryRollup= new ArrayList<>(); 
    @Exclude
    @Singular("addSiblingProductCategoryRollup")
    @SerializedName("sibling_product_category_rollup") 
    List<ProductCategoryRollup> relSiblingProductCategoryRollup= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    @SerializedName("tenant") 
    List<Tenant> relTenant= new ArrayList<>();

    public Map<String, Supplier<List<?>>> suppliers(){
        Map<String, Supplier<List<?>>> supplierMap=Maps.newHashMap();
         
        supplierMap.put(CURRENT_PRODUCT_CATEGORY, getter(this, ProductCategoryRollup::getRelCurrentProductCategory)); 
        supplierMap.put(PARENT_PRODUCT_CATEGORY, getter(this, ProductCategoryRollup::getRelParentProductCategory)); 
        supplierMap.put(CHILD_PRODUCT_CATEGORY_ROLLUP, getter(this, ProductCategoryRollup::getRelChildProductCategoryRollup)); 
        supplierMap.put(PARENT_PRODUCT_CATEGORY_ROLLUP, getter(this, ProductCategoryRollup::getRelParentProductCategoryRollup)); 
        supplierMap.put(SIBLING_PRODUCT_CATEGORY_ROLLUP, getter(this, ProductCategoryRollup::getRelSiblingProductCategoryRollup)); 
        supplierMap.put(TENANT, getter(this, ProductCategoryRollup::getRelTenant));

        return supplierMap;
    };

    public ProductCategoryRollupDelegator.Agent agent(IProc.ProcContext ctx,
                                             ProductCategoryRollupDelegator delegator){
        return delegator.getAgent(ctx, this.getId());
    }

    public ProductCategoryRollupData.Builder toHeadBuilder() {
        ProductCategoryRollupData.Builder builder = ProductCategoryRollupData.newBuilder();
        if (getProductCategoryId() != null) {
            builder.setProductCategoryId(getProductCategoryId());
        }
        if (getParentProductCategoryId() != null) {
            builder.setParentProductCategoryId(getParentProductCategoryId());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
        }
        if (getSequenceNum() != null) {
            builder.setSequenceNum(getSequenceNum());
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

}


/*
-- keys: productCategoryId, parentProductCategoryId, fromDate

-- fields --
    
    String productCategoryId
    String parentProductCategoryId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    Long sequenceNum

-- relations --
    
    - CurrentProductCategory (one, autoRelation: false, keymaps: productCategoryId)
    - ParentProductCategory (one, autoRelation: false, keymaps: parentProductCategoryId -> productCategoryId)
    + ChildProductCategoryRollup (many, autoRelation: false, keymaps: productCategoryId -> parentProductCategoryId)
    + ParentProductCategoryRollup (many, autoRelation: false, keymaps: parentProductCategoryId -> productCategoryId)
    + SiblingProductCategoryRollup (many, autoRelation: false, keymaps: parentProductCategoryId)
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/


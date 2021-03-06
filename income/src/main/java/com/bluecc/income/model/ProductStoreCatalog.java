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

import com.bluecc.hubs.stub.ProductStoreCatalogFlatData;

import com.bluecc.hubs.stub.ProductStoreCatalogData;
import com.bluecc.income.dao.ProductStoreCatalogDelegator;
import static com.bluecc.income.dao.ProductStoreCatalogDelegator.*;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductStoreCatalogData.class,
        symbol = EntityNames.ProductStoreCatalog)
public class ProductStoreCatalog implements IEventModel<ProductStoreCatalogFlatData.Builder>, HasId, Serializable, WithSuppliers, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_store_id")
	@RIndex 
    String productStoreId;
    @SerializedName("prod_catalog_id")
	@RIndex 
    String prodCatalogId;
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

    public ProductStoreCatalogFlatData.Builder toDataBuilder() {
        ProductStoreCatalogFlatData.Builder builder = ProductStoreCatalogFlatData.newBuilder();
        if (getProductStoreId() != null) {
            builder.setProductStoreId(getProductStoreId());
        }
        if (getProdCatalogId() != null) {
            builder.setProdCatalogId(getProdCatalogId());
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

    public static ProductStoreCatalog fromData(ProductStoreCatalogFlatData data) {
        return fromPrototype(data).build();
    }

    public static ProductStoreCatalog.ProductStoreCatalogBuilder fromPrototype(ProductStoreCatalogFlatData data) {
        return ProductStoreCatalog.builder()
                .productStoreId(data.getProductStoreId())
                .prodCatalogId(data.getProdCatalogId())
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
    @Singular("addProductStore")
    @SerializedName("product_store") 
    List<ProductStore> relProductStore= new ArrayList<>(); 
    @Exclude
    @Singular("addProdCatalog")
    @SerializedName("prod_catalog") 
    List<ProdCatalog> relProdCatalog= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    @SerializedName("tenant") 
    List<Tenant> relTenant= new ArrayList<>();

    public Map<String, Supplier<List<?>>> suppliers(){
        Map<String, Supplier<List<?>>> supplierMap=Maps.newHashMap();
         
        supplierMap.put(PRODUCT_STORE, getter(this, ProductStoreCatalog::getRelProductStore)); 
        supplierMap.put(PROD_CATALOG, getter(this, ProductStoreCatalog::getRelProdCatalog)); 
        supplierMap.put(TENANT, getter(this, ProductStoreCatalog::getRelTenant));

        return supplierMap;
    };

    public ProductStoreCatalogDelegator.Agent agent(IProc.ProcContext ctx,
                                             ProductStoreCatalogDelegator delegator){
        return delegator.getAgent(ctx, this.getId());
    }

    public ProductStoreCatalogData.Builder toHeadBuilder() {
        ProductStoreCatalogData.Builder builder = ProductStoreCatalogData.newBuilder();
        if (getProductStoreId() != null) {
            builder.setProductStoreId(getProductStoreId());
        }
        if (getProdCatalogId() != null) {
            builder.setProdCatalogId(getProdCatalogId());
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
-- keys: productStoreId, prodCatalogId, fromDate

-- fields --
    
    String productStoreId
    String prodCatalogId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    Long sequenceNum

-- relations --
    
    - ProductStore (one, autoRelation: false, keymaps: productStoreId)
    - ProdCatalog (one, autoRelation: false, keymaps: prodCatalogId)
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/


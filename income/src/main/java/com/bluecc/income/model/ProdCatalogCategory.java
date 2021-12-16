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

import com.bluecc.hubs.stub.ProdCatalogCategoryFlatData;

import com.bluecc.hubs.stub.ProdCatalogCategoryData;
import com.bluecc.income.dao.ProdCatalogCategoryDelegator;
import static com.bluecc.income.dao.ProdCatalogCategoryDelegator.*;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProdCatalogCategoryData.class,
        symbol = EntityNames.ProdCatalogCategory)
public class ProdCatalogCategory implements IEventModel<ProdCatalogCategoryFlatData.Builder>, Serializable, WithSuppliers, WithPeriod {
    private static final long serialVersionUID = 1L;

    @RIndex String prodCatalogId;
    @RIndex String productCategoryId;
    @RIndex String prodCatalogCategoryTypeId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    Long sequenceNum;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    String tenantId;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProdCatalogCategoryFlatData.Builder toDataBuilder() {
        ProdCatalogCategoryFlatData.Builder builder = ProdCatalogCategoryFlatData.newBuilder();
        if (prodCatalogId != null) {
            builder.setProdCatalogId(prodCatalogId);
        }
        if (productCategoryId != null) {
            builder.setProductCategoryId(productCategoryId);
        }
        if (prodCatalogCategoryTypeId != null) {
            builder.setProdCatalogCategoryTypeId(prodCatalogCategoryTypeId);
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

    public static ProdCatalogCategory fromData(ProdCatalogCategoryFlatData data) {
        return ProdCatalogCategory.builder()
                .prodCatalogId(data.getProdCatalogId())
                .productCategoryId(data.getProductCategoryId())
                .prodCatalogCategoryTypeId(data.getProdCatalogCategoryTypeId())
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
    @Singular("addProdCatalog")
    List<ProdCatalog> relProdCatalog= new ArrayList<>(); 
    @Exclude
    @Singular("addProductCategory")
    List<ProductCategory> relProductCategory= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    List<Tenant> relTenant= new ArrayList<>();

    public Map<String, Supplier<List<?>>> suppliers(){
        Map<String, Supplier<List<?>>> supplierMap=Maps.newHashMap();
         
        supplierMap.put(PROD_CATALOG, getter(this, ProdCatalogCategory::getRelProdCatalog)); 
        supplierMap.put(PRODUCT_CATEGORY, getter(this, ProdCatalogCategory::getRelProductCategory)); 
        supplierMap.put(TENANT, getter(this, ProdCatalogCategory::getRelTenant));

        return supplierMap;
    };

    public ProdCatalogCategoryDelegator.Agent agent(IProc.ProcContext ctx,
                                             ProdCatalogCategoryDelegator delegator){
        return delegator.getAgent(ctx, this.getId());
    }

    public ProdCatalogCategoryData.Builder toHeadBuilder() {
        ProdCatalogCategoryData.Builder builder = ProdCatalogCategoryData.newBuilder();
        if (prodCatalogId != null) {
            builder.setProdCatalogId(prodCatalogId);
        }
        if (productCategoryId != null) {
            builder.setProductCategoryId(productCategoryId);
        }
        if (prodCatalogCategoryTypeId != null) {
            builder.setProdCatalogCategoryTypeId(prodCatalogCategoryTypeId);
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
-- keys: prodCatalogId, productCategoryId, prodCatalogCategoryTypeId, fromDate

-- fields --
    
    String prodCatalogId
    String productCategoryId
    String prodCatalogCategoryTypeId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    Long sequenceNum

-- relations --
    
    - ProdCatalog (one, autoRelation: false, keymaps: prodCatalogId)
    - ProductCategory (one, autoRelation: false, keymaps: productCategoryId)
    - ProdCatalogCategoryType (one, autoRelation: false, keymaps: prodCatalogCategoryTypeId)
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/


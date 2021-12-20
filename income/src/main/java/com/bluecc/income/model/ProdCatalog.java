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

import com.bluecc.hubs.stub.ProdCatalogFlatData;

import com.bluecc.hubs.stub.ProdCatalogData;
import com.bluecc.income.dao.ProdCatalogDelegator;
import static com.bluecc.income.dao.ProdCatalogDelegator.*;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProdCatalogData.class,
        symbol = EntityNames.ProdCatalog)
public class ProdCatalog implements IEventModel<ProdCatalogFlatData.Builder>, HasId, Serializable, WithSuppliers {
    private static final long serialVersionUID = 1L;

    @SerializedName("prod_catalog_id")
	@RId 
    String prodCatalogId;
    @SerializedName("catalog_name") 
    String catalogName;
    @SerializedName("use_quick_add") 
    Character useQuickAdd;
    @SerializedName("style_sheet") 
    String styleSheet;
    @SerializedName("header_logo") 
    String headerLogo;
    @SerializedName("content_path_prefix") 
    String contentPathPrefix;
    @SerializedName("template_path_prefix") 
    String templatePathPrefix;
    @SerializedName("view_allow_perm_reqd") 
    Character viewAllowPermReqd;
    @SerializedName("purchase_allow_perm_reqd") 
    Character purchaseAllowPermReqd;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    @SerializedName("tenant_id") 
    String tenantId;
    
    @Override
    public String getId(){
        return prodCatalogId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProdCatalogFlatData.Builder toDataBuilder() {
        ProdCatalogFlatData.Builder builder = ProdCatalogFlatData.newBuilder();
        if (getProdCatalogId() != null) {
            builder.setProdCatalogId(getProdCatalogId());
        }
        if (getCatalogName() != null) {
            builder.setCatalogName(getCatalogName());
        }
        if (getUseQuickAdd() != null) {
            builder.setUseQuickAdd(getIndicator(getUseQuickAdd()));
        }
        if (getStyleSheet() != null) {
            builder.setStyleSheet(getStyleSheet());
        }
        if (getHeaderLogo() != null) {
            builder.setHeaderLogo(getHeaderLogo());
        }
        if (getContentPathPrefix() != null) {
            builder.setContentPathPrefix(getContentPathPrefix());
        }
        if (getTemplatePathPrefix() != null) {
            builder.setTemplatePathPrefix(getTemplatePathPrefix());
        }
        if (getViewAllowPermReqd() != null) {
            builder.setViewAllowPermReqd(getIndicator(getViewAllowPermReqd()));
        }
        if (getPurchaseAllowPermReqd() != null) {
            builder.setPurchaseAllowPermReqd(getIndicator(getPurchaseAllowPermReqd()));
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
        if (getTenantId() != null) {
            builder.setTenantId(getTenantId());
        }
                    
        return builder;
    }

    public static ProdCatalog fromData(ProdCatalogFlatData data) {
        return fromPrototype(data).build();
    }

    public static ProdCatalog.ProdCatalogBuilder fromPrototype(ProdCatalogFlatData data) {
        return ProdCatalog.builder()
                .prodCatalogId(data.getProdCatalogId())
                .catalogName(data.getCatalogName())
                .useQuickAdd(getIndicatorChar(data.getUseQuickAdd()))
                .styleSheet(data.getStyleSheet())
                .headerLogo(data.getHeaderLogo())
                .contentPathPrefix(data.getContentPathPrefix())
                .templatePathPrefix(data.getTemplatePathPrefix())
                .viewAllowPermReqd(getIndicatorChar(data.getViewAllowPermReqd()))
                .purchaseAllowPermReqd(getIndicatorChar(data.getPurchaseAllowPermReqd()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .tenantId(data.getTenantId())
                ;
    }

        // relations
     
    @Exclude
    @Singular("addProdCatalogCategory")
    @SerializedName("prod_catalog_category") 
    List<ProdCatalogCategory> relProdCatalogCategory= new ArrayList<>(); 
    @Exclude
    @Singular("addProductStoreCatalog")
    @SerializedName("product_store_catalog") 
    List<ProductStoreCatalog> relProductStoreCatalog= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    @SerializedName("tenant") 
    List<Tenant> relTenant= new ArrayList<>();

    public Map<String, Supplier<List<?>>> suppliers(){
        Map<String, Supplier<List<?>>> supplierMap=Maps.newHashMap();
         
        supplierMap.put(PROD_CATALOG_CATEGORY, getter(this, ProdCatalog::getRelProdCatalogCategory)); 
        supplierMap.put(PRODUCT_STORE_CATALOG, getter(this, ProdCatalog::getRelProductStoreCatalog)); 
        supplierMap.put(TENANT, getter(this, ProdCatalog::getRelTenant));

        return supplierMap;
    };

    public ProdCatalogDelegator.Agent agent(IProc.ProcContext ctx,
                                             ProdCatalogDelegator delegator){
        return delegator.getAgent(ctx, this.getProdCatalogId());
    }

    public ProdCatalogData.Builder toHeadBuilder() {
        ProdCatalogData.Builder builder = ProdCatalogData.newBuilder();
        if (getProdCatalogId() != null) {
            builder.setProdCatalogId(getProdCatalogId());
        }
        if (getCatalogName() != null) {
            builder.setCatalogName(getCatalogName());
        }
        if (getUseQuickAdd() != null) {
            builder.setUseQuickAdd(getIndicator(getUseQuickAdd()));
        }
        if (getStyleSheet() != null) {
            builder.setStyleSheet(getStyleSheet());
        }
        if (getHeaderLogo() != null) {
            builder.setHeaderLogo(getHeaderLogo());
        }
        if (getContentPathPrefix() != null) {
            builder.setContentPathPrefix(getContentPathPrefix());
        }
        if (getTemplatePathPrefix() != null) {
            builder.setTemplatePathPrefix(getTemplatePathPrefix());
        }
        if (getViewAllowPermReqd() != null) {
            builder.setViewAllowPermReqd(getIndicator(getViewAllowPermReqd()));
        }
        if (getPurchaseAllowPermReqd() != null) {
            builder.setPurchaseAllowPermReqd(getIndicator(getPurchaseAllowPermReqd()));
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

}


/*
-- keys: prodCatalogId

-- fields --
    
    String prodCatalogId
    String catalogName
    Character useQuickAdd
    String styleSheet
    String headerLogo
    String contentPathPrefix
    String templatePathPrefix
    Character viewAllowPermReqd
    Character purchaseAllowPermReqd

-- relations --
    
    + CartAbandonedLine (many, autoRelation: true, keymaps: prodCatalogId)
    + ProdCatalogCategory (many, autoRelation: true, keymaps: prodCatalogId)
    + ProdCatalogInvFacility (many, autoRelation: true, keymaps: prodCatalogId)
    + ProdCatalogRole (many, autoRelation: true, keymaps: prodCatalogId)
    + ProductStoreCatalog (many, autoRelation: true, keymaps: prodCatalogId)
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/


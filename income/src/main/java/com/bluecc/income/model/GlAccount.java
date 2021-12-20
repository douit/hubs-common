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

import com.bluecc.hubs.stub.GlAccountData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = GlAccountData.class,
        symbol = EntityNames.GlAccount)
public class GlAccount implements IEventModel<GlAccountData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("gl_account_id")
	@RId 
    String glAccountId;
    @SerializedName("gl_account_type_id") 
    String glAccountTypeId;
    @SerializedName("gl_account_class_id") 
    String glAccountClassId;
    @SerializedName("gl_resource_type_id") 
    String glResourceTypeId;
    @SerializedName("gl_xbrl_class_id") 
    String glXbrlClassId;
    @SerializedName("parent_gl_account_id") 
    String parentGlAccountId;
    @SerializedName("account_code") 
    String accountCode;
    @SerializedName("account_name") 
    String accountName;
    @SerializedName("description") 
    String description;
    @SerializedName("product_id") 
    String productId;
    @SerializedName("external_id") 
    String externalId;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    
    @Override
    public String getId(){
        return glAccountId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public GlAccountData.Builder toDataBuilder() {
        GlAccountData.Builder builder = GlAccountData.newBuilder();
        if (getGlAccountId() != null) {
            builder.setGlAccountId(getGlAccountId());
        }
        if (getGlAccountTypeId() != null) {
            builder.setGlAccountTypeId(getGlAccountTypeId());
        }
        if (getGlAccountClassId() != null) {
            builder.setGlAccountClassId(getGlAccountClassId());
        }
        if (getGlResourceTypeId() != null) {
            builder.setGlResourceTypeId(getGlResourceTypeId());
        }
        if (getGlXbrlClassId() != null) {
            builder.setGlXbrlClassId(getGlXbrlClassId());
        }
        if (getParentGlAccountId() != null) {
            builder.setParentGlAccountId(getParentGlAccountId());
        }
        if (getAccountCode() != null) {
            builder.setAccountCode(getAccountCode());
        }
        if (getAccountName() != null) {
            builder.setAccountName(getAccountName());
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getProductId() != null) {
            builder.setProductId(getProductId());
        }
        if (getExternalId() != null) {
            builder.setExternalId(getExternalId());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static GlAccount fromData(GlAccountData data) {
        return fromPrototype(data).build();
    }

    public static GlAccount.GlAccountBuilder fromPrototype(GlAccountData data) {
        return GlAccount.builder()
                .glAccountId(data.getGlAccountId())
                .glAccountTypeId(data.getGlAccountTypeId())
                .glAccountClassId(data.getGlAccountClassId())
                .glResourceTypeId(data.getGlResourceTypeId())
                .glXbrlClassId(data.getGlXbrlClassId())
                .parentGlAccountId(data.getParentGlAccountId())
                .accountCode(data.getAccountCode())
                .accountName(data.getAccountName())
                .description(data.getDescription())
                .productId(data.getProductId())
                .externalId(data.getExternalId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
    }

    
}


/*
-- keys: glAccountId

-- fields --
    
    String glAccountId
    String glAccountTypeId
    String glAccountClassId
    String glResourceTypeId
    String glXbrlClassId
    String parentGlAccountId
    String accountCode
    String accountName
    String description
    String productId
    String externalId

-- relations --
    
    - GlAccountType (one, autoRelation: false, keymaps: glAccountTypeId)
    - GlAccountClass (one, autoRelation: false, keymaps: glAccountClassId)
    - GlResourceType (one, autoRelation: false, keymaps: glResourceTypeId)
    - GlXbrlClass (one, autoRelation: false, keymaps: glXbrlClassId)
    - ParentGlAccount (one, autoRelation: false, keymaps: parentGlAccountId -> glAccountId)
    + AcctgTransEntry (many, autoRelation: true, keymaps: glAccountId)
    + PostToFinAccount (many, autoRelation: true, keymaps: glAccountId -> postToGlAccountId)
    + FinAccountTypeGlAccount (many, autoRelation: true, keymaps: glAccountId)
    + AssetFixedAssetTypeGlAccount (many, autoRelation: true, keymaps: glAccountId -> assetGlAccountId)
    + AccumulatedDepreciationFixedAssetTypeGlAccount (many, autoRelation: true, keymaps: glAccountId -> accDepGlAccountId)
    + DepreciationFixedAssetTypeGlAccount (many, autoRelation: true, keymaps: glAccountId -> depGlAccountId)
    + ProfitFixedAssetTypeGlAccount (many, autoRelation: true, keymaps: glAccountId -> profitGlAccountId)
    + LossFixedAssetTypeGlAccount (many, autoRelation: true, keymaps: glAccountId -> lossGlAccountId)
    + ChildGlAccount (many, autoRelation: true, keymaps: glAccountId -> parentGlAccountId)
    + GlAccountCategoryMember (many, autoRelation: true, keymaps: glAccountId)
    + GlAccountGroupMember (many, autoRelation: true, keymaps: glAccountId)
    + GlAccountHistory (many, autoRelation: true, keymaps: glAccountId)
    + GlAccountOrganization (many, autoRelation: true, keymaps: glAccountId)
    + GlAccountRole (many, autoRelation: true, keymaps: glAccountId)
    + GlAccountTypeDefault (many, autoRelation: true, keymaps: glAccountId)
    + GlBudgetXref (many, autoRelation: true, keymaps: glAccountId)
    + GlReconciliation (many, autoRelation: true, keymaps: glAccountId)
    + OverrideInvoiceItem (many, autoRelation: true, keymaps: glAccountId -> overrideGlAccountId)
    + DefaultInvoiceItemType (many, autoRelation: true, keymaps: glAccountId -> defaultGlAccountId)
    + InvoiceItemTypeGlAccount (many, autoRelation: true, keymaps: glAccountId)
    + OverrideOrderAdjustment (many, autoRelation: true, keymaps: glAccountId -> overrideGlAccountId)
    + OverrideOrderItem (many, autoRelation: true, keymaps: glAccountId -> overrideGlAccountId)
    + PartyGlAccount (many, autoRelation: true, keymaps: glAccountId)
    + Payment (many, autoRelation: true, keymaps: glAccountId -> overrideGlAccountId)
    + PaymentApplication (many, autoRelation: true, keymaps: glAccountId -> overrideGlAccountId)
    + PaymentMethod (many, autoRelation: true, keymaps: glAccountId)
    + DefaultPaymentMethodType (many, autoRelation: true, keymaps: glAccountId -> defaultGlAccountId)
    + PaymentMethodTypeGlAccount (many, autoRelation: true, keymaps: glAccountId)
    + ProductCategoryGlAccount (many, autoRelation: true, keymaps: glAccountId)
    + ProductGlAccount (many, autoRelation: true, keymaps: glAccountId)
    + OverrideQuoteAdjustment (many, autoRelation: true, keymaps: glAccountId -> overrideGlAccountId)
    + OverrideReturnAdjustment (many, autoRelation: true, keymaps: glAccountId -> overrideGlAccountId)
    + TaxAuthorityGlAccount (many, autoRelation: true, keymaps: glAccountId)
    + VarianceReasonGlAccount (many, autoRelation: true, keymaps: glAccountId)
*/


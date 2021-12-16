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

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;

import com.bluecc.hubs.stub.GlAccountData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = GlAccountData.class,
        symbol = EntityNames.GlAccount)
public class GlAccount implements IEventModel<GlAccountData.Builder>, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @RId String glAccountId;
    String glAccountTypeId;
    String glAccountClassId;
    String glResourceTypeId;
    String glXbrlClassId;
    String parentGlAccountId;
    String accountCode;
    String accountName;
    String description;
    String productId;
    String externalId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public GlAccountData.Builder toDataBuilder() {
        GlAccountData.Builder builder = GlAccountData.newBuilder();
        if (glAccountId != null) {
            builder.setGlAccountId(glAccountId);
        }
        if (glAccountTypeId != null) {
            builder.setGlAccountTypeId(glAccountTypeId);
        }
        if (glAccountClassId != null) {
            builder.setGlAccountClassId(glAccountClassId);
        }
        if (glResourceTypeId != null) {
            builder.setGlResourceTypeId(glResourceTypeId);
        }
        if (glXbrlClassId != null) {
            builder.setGlXbrlClassId(glXbrlClassId);
        }
        if (parentGlAccountId != null) {
            builder.setParentGlAccountId(parentGlAccountId);
        }
        if (accountCode != null) {
            builder.setAccountCode(accountCode);
        }
        if (accountName != null) {
            builder.setAccountName(accountName);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (externalId != null) {
            builder.setExternalId(externalId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static GlAccount fromData(GlAccountData data) {
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
                
                .build();
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


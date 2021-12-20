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

import com.bluecc.hubs.stub.AcctgTransEntryData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = AcctgTransEntryData.class,
        symbol = EntityNames.AcctgTransEntry)
public class AcctgTransEntry implements IEventModel<AcctgTransEntryData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("acctg_trans_id")
	@RIndex 
    String acctgTransId;
    @SerializedName("acctg_trans_entry_seq_id")
	@RIndex 
    String acctgTransEntrySeqId;
    @SerializedName("acctg_trans_entry_type_id") 
    String acctgTransEntryTypeId;
    @SerializedName("description") 
    String description;
    @SerializedName("voucher_ref") 
    String voucherRef;
    @SerializedName("party_id") 
    String partyId;
    @SerializedName("role_type_id") 
    String roleTypeId;
    @SerializedName("their_party_id") 
    String theirPartyId;
    @SerializedName("product_id") 
    String productId;
    @SerializedName("their_product_id") 
    String theirProductId;
    @SerializedName("inventory_item_id") 
    String inventoryItemId;
    @SerializedName("gl_account_type_id") 
    String glAccountTypeId;
    @SerializedName("gl_account_id") 
    String glAccountId;
    @SerializedName("organization_party_id") 
    String organizationPartyId;
    @SerializedName("amount") 
    java.math.BigDecimal amount;
    @SerializedName("currency_uom_id") 
    String currencyUomId;
    @SerializedName("orig_amount") 
    java.math.BigDecimal origAmount;
    @SerializedName("orig_currency_uom_id") 
    String origCurrencyUomId;
    @SerializedName("debit_credit_flag") 
    Character debitCreditFlag;
    @SerializedName("due_date") 
    java.time.LocalDate dueDate;
    @SerializedName("group_id") 
    String groupId;
    @SerializedName("tax_id") 
    String taxId;
    @SerializedName("reconcile_status_id") 
    String reconcileStatusId;
    @SerializedName("settlement_term_id") 
    String settlementTermId;
    @SerializedName("is_summary") 
    Character isSummary;
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

    public AcctgTransEntryData.Builder toDataBuilder() {
        AcctgTransEntryData.Builder builder = AcctgTransEntryData.newBuilder();
        if (getAcctgTransId() != null) {
            builder.setAcctgTransId(getAcctgTransId());
        }
        if (getAcctgTransEntrySeqId() != null) {
            builder.setAcctgTransEntrySeqId(getAcctgTransEntrySeqId());
        }
        if (getAcctgTransEntryTypeId() != null) {
            builder.setAcctgTransEntryTypeId(getAcctgTransEntryTypeId());
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getVoucherRef() != null) {
            builder.setVoucherRef(getVoucherRef());
        }
        if (getPartyId() != null) {
            builder.setPartyId(getPartyId());
        }
        if (getRoleTypeId() != null) {
            builder.setRoleTypeId(getRoleTypeId());
        }
        if (getTheirPartyId() != null) {
            builder.setTheirPartyId(getTheirPartyId());
        }
        if (getProductId() != null) {
            builder.setProductId(getProductId());
        }
        if (getTheirProductId() != null) {
            builder.setTheirProductId(getTheirProductId());
        }
        if (getInventoryItemId() != null) {
            builder.setInventoryItemId(getInventoryItemId());
        }
        if (getGlAccountTypeId() != null) {
            builder.setGlAccountTypeId(getGlAccountTypeId());
        }
        if (getGlAccountId() != null) {
            builder.setGlAccountId(getGlAccountId());
        }
        if (getOrganizationPartyId() != null) {
            builder.setOrganizationPartyId(getOrganizationPartyId());
        }
        if (getAmount() != null) {
            builder.setAmount(getCurrency(getAmount()));
        }
        if (getCurrencyUomId() != null) {
            builder.setCurrencyUomId(getCurrencyUomId());
        }
        if (getOrigAmount() != null) {
            builder.setOrigAmount(getCurrency(getOrigAmount()));
        }
        if (getOrigCurrencyUomId() != null) {
            builder.setOrigCurrencyUomId(getOrigCurrencyUomId());
        }
        if (getDebitCreditFlag() != null) {
            builder.setDebitCreditFlag(getIndicator(getDebitCreditFlag()));
        }
        if (getDueDate() != null) {
            builder.setDueDate(getDate(getDueDate()));
        }
        if (getGroupId() != null) {
            builder.setGroupId(getGroupId());
        }
        if (getTaxId() != null) {
            builder.setTaxId(getTaxId());
        }
        if (getReconcileStatusId() != null) {
            builder.setReconcileStatusId(getReconcileStatusId());
        }
        if (getSettlementTermId() != null) {
            builder.setSettlementTermId(getSettlementTermId());
        }
        if (getIsSummary() != null) {
            builder.setIsSummary(getIndicator(getIsSummary()));
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

    public static AcctgTransEntry fromData(AcctgTransEntryData data) {
        return fromPrototype(data).build();
    }

    public static AcctgTransEntry.AcctgTransEntryBuilder fromPrototype(AcctgTransEntryData data) {
        return AcctgTransEntry.builder()
                .acctgTransId(data.getAcctgTransId())
                .acctgTransEntrySeqId(data.getAcctgTransEntrySeqId())
                .acctgTransEntryTypeId(data.getAcctgTransEntryTypeId())
                .description(data.getDescription())
                .voucherRef(data.getVoucherRef())
                .partyId(data.getPartyId())
                .roleTypeId(data.getRoleTypeId())
                .theirPartyId(data.getTheirPartyId())
                .productId(data.getProductId())
                .theirProductId(data.getTheirProductId())
                .inventoryItemId(data.getInventoryItemId())
                .glAccountTypeId(data.getGlAccountTypeId())
                .glAccountId(data.getGlAccountId())
                .organizationPartyId(data.getOrganizationPartyId())
                .amount(getBigDecimal(data.getAmount()))
                .currencyUomId(data.getCurrencyUomId())
                .origAmount(getBigDecimal(data.getOrigAmount()))
                .origCurrencyUomId(data.getOrigCurrencyUomId())
                .debitCreditFlag(getIndicatorChar(data.getDebitCreditFlag()))
                .dueDate(getLocalDate(data.getDueDate()))
                .groupId(data.getGroupId())
                .taxId(data.getTaxId())
                .reconcileStatusId(data.getReconcileStatusId())
                .settlementTermId(data.getSettlementTermId())
                .isSummary(getIndicatorChar(data.getIsSummary()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: acctgTransId, acctgTransEntrySeqId

-- fields --
    
    String acctgTransId
    String acctgTransEntrySeqId
    String acctgTransEntryTypeId
    String description
    String voucherRef
    String partyId
    String roleTypeId
    String theirPartyId
    String productId
    String theirProductId
    String inventoryItemId
    String glAccountTypeId
    String glAccountId
    String organizationPartyId
    java.math.BigDecimal amount
    String currencyUomId
    java.math.BigDecimal origAmount
    String origCurrencyUomId
    Character debitCreditFlag
    java.time.LocalDate dueDate
    String groupId
    String taxId
    String reconcileStatusId
    String settlementTermId
    Character isSummary

-- relations --
    
    - AcctgTransEntryType (one, autoRelation: false, keymaps: acctgTransEntryTypeId)
    - CurrencyUom (one, autoRelation: false, keymaps: currencyUomId -> uomId)
    - OrigCurrencyUom (one, autoRelation: false, keymaps: origCurrencyUomId -> uomId)
    - AcctgTrans (one, autoRelation: false, keymaps: acctgTransId)
    - InventoryItem (one, autoRelation: false, keymaps: inventoryItemId)
    - Party (one, autoRelation: false, keymaps: partyId)
    - RoleType (one, autoRelation: false, keymaps: roleTypeId)
    - PartyRole (one-nofk, autoRelation: false, keymaps: partyId, roleTypeId)
    - GlAccountType (one, autoRelation: false, keymaps: glAccountTypeId)
    - GlAccount (one, autoRelation: false, keymaps: glAccountId)
    - GlAccountOrganization (one, autoRelation: false, keymaps: glAccountId, organizationPartyId)
    - StatusItem (one, autoRelation: false, keymaps: reconcileStatusId -> statusId)
    - SettlementTerm (one, autoRelation: false, keymaps: settlementTermId)
    + GlReconciliationEntry (many, autoRelation: true, keymaps: acctgTransId, acctgTransEntrySeqId)
*/


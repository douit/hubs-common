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

import com.bluecc.hubs.stub.AcctgTransData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = AcctgTransData.class,
        symbol = EntityNames.AcctgTrans)
public class AcctgTrans implements IEventModel<AcctgTransData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("acctg_trans_id")
	@RId 
    String acctgTransId;
    @SerializedName("acctg_trans_type_id") 
    String acctgTransTypeId;
    @SerializedName("description") 
    String description;
    @SerializedName("transaction_date") 
    java.time.LocalDateTime transactionDate;
    @SerializedName("is_posted") 
    Character isPosted;
    @SerializedName("posted_date") 
    java.time.LocalDateTime postedDate;
    @SerializedName("scheduled_posting_date") 
    java.time.LocalDateTime scheduledPostingDate;
    @SerializedName("gl_journal_id") 
    String glJournalId;
    @SerializedName("gl_fiscal_type_id") 
    String glFiscalTypeId;
    @SerializedName("voucher_ref") 
    String voucherRef;
    @SerializedName("voucher_date") 
    java.time.LocalDateTime voucherDate;
    @SerializedName("group_status_id") 
    String groupStatusId;
    @SerializedName("fixed_asset_id") 
    String fixedAssetId;
    @SerializedName("inventory_item_id") 
    String inventoryItemId;
    @SerializedName("physical_inventory_id") 
    String physicalInventoryId;
    @SerializedName("party_id") 
    String partyId;
    @SerializedName("role_type_id") 
    String roleTypeId;
    @SerializedName("invoice_id") 
    String invoiceId;
    @SerializedName("payment_id") 
    String paymentId;
    @SerializedName("fin_account_trans_id") 
    String finAccountTransId;
    @SerializedName("shipment_id") 
    String shipmentId;
    @SerializedName("receipt_id") 
    String receiptId;
    @SerializedName("work_effort_id") 
    String workEffortId;
    @SerializedName("their_acctg_trans_id") 
    String theirAcctgTransId;
    @SerializedName("created_date") 
    java.time.LocalDateTime createdDate;
    @SerializedName("created_by_user_login_id") 
    String createdByUserLogin;
    @SerializedName("last_modified_date") 
    java.time.LocalDateTime lastModifiedDate;
    @SerializedName("last_modified_by_user_login_id") 
    String lastModifiedByUserLogin;
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
        return acctgTransId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public AcctgTransData.Builder toDataBuilder() {
        AcctgTransData.Builder builder = AcctgTransData.newBuilder();
        if (getAcctgTransId() != null) {
            builder.setAcctgTransId(getAcctgTransId());
        }
        if (getAcctgTransTypeId() != null) {
            builder.setAcctgTransTypeId(getAcctgTransTypeId());
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getTransactionDate() != null) {
            builder.setTransactionDate(getTimestamp(getTransactionDate()));
        }
        if (getIsPosted() != null) {
            builder.setIsPosted(getIndicator(getIsPosted()));
        }
        if (getPostedDate() != null) {
            builder.setPostedDate(getTimestamp(getPostedDate()));
        }
        if (getScheduledPostingDate() != null) {
            builder.setScheduledPostingDate(getTimestamp(getScheduledPostingDate()));
        }
        if (getGlJournalId() != null) {
            builder.setGlJournalId(getGlJournalId());
        }
        if (getGlFiscalTypeId() != null) {
            builder.setGlFiscalTypeId(getGlFiscalTypeId());
        }
        if (getVoucherRef() != null) {
            builder.setVoucherRef(getVoucherRef());
        }
        if (getVoucherDate() != null) {
            builder.setVoucherDate(getTimestamp(getVoucherDate()));
        }
        if (getGroupStatusId() != null) {
            builder.setGroupStatusId(getGroupStatusId());
        }
        if (getFixedAssetId() != null) {
            builder.setFixedAssetId(getFixedAssetId());
        }
        if (getInventoryItemId() != null) {
            builder.setInventoryItemId(getInventoryItemId());
        }
        if (getPhysicalInventoryId() != null) {
            builder.setPhysicalInventoryId(getPhysicalInventoryId());
        }
        if (getPartyId() != null) {
            builder.setPartyId(getPartyId());
        }
        if (getRoleTypeId() != null) {
            builder.setRoleTypeId(getRoleTypeId());
        }
        if (getInvoiceId() != null) {
            builder.setInvoiceId(getInvoiceId());
        }
        if (getPaymentId() != null) {
            builder.setPaymentId(getPaymentId());
        }
        if (getFinAccountTransId() != null) {
            builder.setFinAccountTransId(getFinAccountTransId());
        }
        if (getShipmentId() != null) {
            builder.setShipmentId(getShipmentId());
        }
        if (getReceiptId() != null) {
            builder.setReceiptId(getReceiptId());
        }
        if (getWorkEffortId() != null) {
            builder.setWorkEffortId(getWorkEffortId());
        }
        if (getTheirAcctgTransId() != null) {
            builder.setTheirAcctgTransId(getTheirAcctgTransId());
        }
        if (getCreatedDate() != null) {
            builder.setCreatedDate(getTimestamp(getCreatedDate()));
        }
        if (getCreatedByUserLogin() != null) {
            builder.setCreatedByUserLogin(getCreatedByUserLogin());
        }
        if (getLastModifiedDate() != null) {
            builder.setLastModifiedDate(getTimestamp(getLastModifiedDate()));
        }
        if (getLastModifiedByUserLogin() != null) {
            builder.setLastModifiedByUserLogin(getLastModifiedByUserLogin());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static AcctgTrans fromData(AcctgTransData data) {
        return fromPrototype(data).build();
    }

    public static AcctgTrans.AcctgTransBuilder fromPrototype(AcctgTransData data) {
        return AcctgTrans.builder()
                .acctgTransId(data.getAcctgTransId())
                .acctgTransTypeId(data.getAcctgTransTypeId())
                .description(data.getDescription())
                .transactionDate(getLocalDateTime(data.getTransactionDate()))
                .isPosted(getIndicatorChar(data.getIsPosted()))
                .postedDate(getLocalDateTime(data.getPostedDate()))
                .scheduledPostingDate(getLocalDateTime(data.getScheduledPostingDate()))
                .glJournalId(data.getGlJournalId())
                .glFiscalTypeId(data.getGlFiscalTypeId())
                .voucherRef(data.getVoucherRef())
                .voucherDate(getLocalDateTime(data.getVoucherDate()))
                .groupStatusId(data.getGroupStatusId())
                .fixedAssetId(data.getFixedAssetId())
                .inventoryItemId(data.getInventoryItemId())
                .physicalInventoryId(data.getPhysicalInventoryId())
                .partyId(data.getPartyId())
                .roleTypeId(data.getRoleTypeId())
                .invoiceId(data.getInvoiceId())
                .paymentId(data.getPaymentId())
                .finAccountTransId(data.getFinAccountTransId())
                .shipmentId(data.getShipmentId())
                .receiptId(data.getReceiptId())
                .workEffortId(data.getWorkEffortId())
                .theirAcctgTransId(data.getTheirAcctgTransId())
                .createdDate(getLocalDateTime(data.getCreatedDate()))
                .createdByUserLogin(data.getCreatedByUserLogin())
                .lastModifiedDate(getLocalDateTime(data.getLastModifiedDate()))
                .lastModifiedByUserLogin(data.getLastModifiedByUserLogin())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
    }

    
}


/*
-- keys: acctgTransId

-- fields --
    
    String acctgTransId
    String acctgTransTypeId
    String description
    java.time.LocalDateTime transactionDate
    Character isPosted
    java.time.LocalDateTime postedDate
    java.time.LocalDateTime scheduledPostingDate
    String glJournalId
    String glFiscalTypeId
    String voucherRef
    java.time.LocalDateTime voucherDate
    String groupStatusId
    String fixedAssetId
    String inventoryItemId
    String physicalInventoryId
    String partyId
    String roleTypeId
    String invoiceId
    String paymentId
    String finAccountTransId
    String shipmentId
    String receiptId
    String workEffortId
    String theirAcctgTransId
    java.time.LocalDateTime createdDate
    String createdByUserLogin
    java.time.LocalDateTime lastModifiedDate
    String lastModifiedByUserLogin

-- relations --
    
    - AcctgTransType (one, autoRelation: false, keymaps: acctgTransTypeId)
    - GlJournal (one, autoRelation: false, keymaps: glJournalId)
    - GlFiscalType (one, autoRelation: false, keymaps: glFiscalTypeId)
    - StatusItem (one, autoRelation: false, keymaps: groupStatusId -> statusId)
    - FixedAsset (one, autoRelation: false, keymaps: fixedAssetId)
    - PhysicalInventory (one, autoRelation: false, keymaps: physicalInventoryId)
    - InventoryItem (one, autoRelation: false, keymaps: inventoryItemId)
    - InventoryItemVariance (one, autoRelation: false, keymaps: inventoryItemId, physicalInventoryId)
    - Party (one, autoRelation: false, keymaps: partyId)
    - RoleType (one, autoRelation: false, keymaps: roleTypeId)
    - PartyRole (one-nofk, autoRelation: false, keymaps: partyId, roleTypeId)
    - Invoice (one, autoRelation: false, keymaps: invoiceId)
    - Payment (one, autoRelation: false, keymaps: paymentId)
    - FinAccountTrans (one, autoRelation: false, keymaps: finAccountTransId)
    - Shipment (one, autoRelation: false, keymaps: shipmentId)
    - ShipmentReceipt (one, autoRelation: false, keymaps: receiptId)
    - WorkEffort (one, autoRelation: false, keymaps: workEffortId)
    + AcctgTransTypeAttr (many, autoRelation: false, keymaps: acctgTransTypeId)
    + AcctgTransAttribute (many, autoRelation: true, keymaps: acctgTransId)
    + AcctgTransEntry (many, autoRelation: true, keymaps: acctgTransId)
    + GlReconciliationEntry (many, autoRelation: true, keymaps: acctgTransId)
*/


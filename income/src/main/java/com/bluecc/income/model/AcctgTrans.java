package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.AcctgTransData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AcctgTrans implements IEventModel<AcctgTransData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String acctgTransId;
    String acctgTransTypeId;
    String description;
    java.time.LocalDateTime transactionDate;
    Character isPosted;
    java.time.LocalDateTime postedDate;
    java.time.LocalDateTime scheduledPostingDate;
    String glJournalId;
    String glFiscalTypeId;
    String voucherRef;
    java.time.LocalDateTime voucherDate;
    String groupStatusId;
    String fixedAssetId;
    String inventoryItemId;
    String physicalInventoryId;
    String partyId;
    String roleTypeId;
    String invoiceId;
    String paymentId;
    String finAccountTransId;
    String shipmentId;
    String receiptId;
    String workEffortId;
    String theirAcctgTransId;
    java.time.LocalDateTime createdDate;
    String createdByUserLogin;
    java.time.LocalDateTime lastModifiedDate;
    String lastModifiedByUserLogin;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public AcctgTransData.Builder toDataBuilder() {
        AcctgTransData.Builder builder = AcctgTransData.newBuilder();
        if (acctgTransId != null) {
            builder.setAcctgTransId(acctgTransId);
        }
        if (acctgTransTypeId != null) {
            builder.setAcctgTransTypeId(acctgTransTypeId);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (transactionDate != null) {
            builder.setTransactionDate(getTimestamp(transactionDate));
        }
        if (isPosted != null) {
            builder.setIsPosted(getIndicator(isPosted));
        }
        if (postedDate != null) {
            builder.setPostedDate(getTimestamp(postedDate));
        }
        if (scheduledPostingDate != null) {
            builder.setScheduledPostingDate(getTimestamp(scheduledPostingDate));
        }
        if (glJournalId != null) {
            builder.setGlJournalId(glJournalId);
        }
        if (glFiscalTypeId != null) {
            builder.setGlFiscalTypeId(glFiscalTypeId);
        }
        if (voucherRef != null) {
            builder.setVoucherRef(voucherRef);
        }
        if (voucherDate != null) {
            builder.setVoucherDate(getTimestamp(voucherDate));
        }
        if (groupStatusId != null) {
            builder.setGroupStatusId(groupStatusId);
        }
        if (fixedAssetId != null) {
            builder.setFixedAssetId(fixedAssetId);
        }
        if (inventoryItemId != null) {
            builder.setInventoryItemId(inventoryItemId);
        }
        if (physicalInventoryId != null) {
            builder.setPhysicalInventoryId(physicalInventoryId);
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (roleTypeId != null) {
            builder.setRoleTypeId(roleTypeId);
        }
        if (invoiceId != null) {
            builder.setInvoiceId(invoiceId);
        }
        if (paymentId != null) {
            builder.setPaymentId(paymentId);
        }
        if (finAccountTransId != null) {
            builder.setFinAccountTransId(finAccountTransId);
        }
        if (shipmentId != null) {
            builder.setShipmentId(shipmentId);
        }
        if (receiptId != null) {
            builder.setReceiptId(receiptId);
        }
        if (workEffortId != null) {
            builder.setWorkEffortId(workEffortId);
        }
        if (theirAcctgTransId != null) {
            builder.setTheirAcctgTransId(theirAcctgTransId);
        }
        if (createdDate != null) {
            builder.setCreatedDate(getTimestamp(createdDate));
        }
        if (createdByUserLogin != null) {
            builder.setCreatedByUserLogin(createdByUserLogin);
        }
        if (lastModifiedDate != null) {
            builder.setLastModifiedDate(getTimestamp(lastModifiedDate));
        }
        if (lastModifiedByUserLogin != null) {
            builder.setLastModifiedByUserLogin(lastModifiedByUserLogin);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static AcctgTrans fromData(AcctgTransData data) {
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
                
                .build();
    }

    
}

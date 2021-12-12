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

import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;

import com.bluecc.hubs.stub.AcctgTransEntryData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = AcctgTransEntryData.class,
        symbol = EntityNames.AcctgTransEntry)
public class AcctgTransEntry implements IEventModel<AcctgTransEntryData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String acctgTransId;
    @RIndex String acctgTransEntrySeqId;
    String acctgTransEntryTypeId;
    String description;
    String voucherRef;
    String partyId;
    String roleTypeId;
    String theirPartyId;
    String productId;
    String theirProductId;
    String inventoryItemId;
    String glAccountTypeId;
    String glAccountId;
    String organizationPartyId;
    java.math.BigDecimal amount;
    String currencyUomId;
    java.math.BigDecimal origAmount;
    String origCurrencyUomId;
    Character debitCreditFlag;
    java.time.LocalDate dueDate;
    String groupId;
    String taxId;
    String reconcileStatusId;
    String settlementTermId;
    Character isSummary;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public AcctgTransEntryData.Builder toDataBuilder() {
        AcctgTransEntryData.Builder builder = AcctgTransEntryData.newBuilder();
        if (acctgTransId != null) {
            builder.setAcctgTransId(acctgTransId);
        }
        if (acctgTransEntrySeqId != null) {
            builder.setAcctgTransEntrySeqId(acctgTransEntrySeqId);
        }
        if (acctgTransEntryTypeId != null) {
            builder.setAcctgTransEntryTypeId(acctgTransEntryTypeId);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (voucherRef != null) {
            builder.setVoucherRef(voucherRef);
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (roleTypeId != null) {
            builder.setRoleTypeId(roleTypeId);
        }
        if (theirPartyId != null) {
            builder.setTheirPartyId(theirPartyId);
        }
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (theirProductId != null) {
            builder.setTheirProductId(theirProductId);
        }
        if (inventoryItemId != null) {
            builder.setInventoryItemId(inventoryItemId);
        }
        if (glAccountTypeId != null) {
            builder.setGlAccountTypeId(glAccountTypeId);
        }
        if (glAccountId != null) {
            builder.setGlAccountId(glAccountId);
        }
        if (organizationPartyId != null) {
            builder.setOrganizationPartyId(organizationPartyId);
        }
        if (amount != null) {
            builder.setAmount(getCurrency(amount));
        }
        if (currencyUomId != null) {
            builder.setCurrencyUomId(currencyUomId);
        }
        if (origAmount != null) {
            builder.setOrigAmount(getCurrency(origAmount));
        }
        if (origCurrencyUomId != null) {
            builder.setOrigCurrencyUomId(origCurrencyUomId);
        }
        if (debitCreditFlag != null) {
            builder.setDebitCreditFlag(getIndicator(debitCreditFlag));
        }
        if (dueDate != null) {
            builder.setDueDate(getDate(dueDate));
        }
        if (groupId != null) {
            builder.setGroupId(groupId);
        }
        if (taxId != null) {
            builder.setTaxId(taxId);
        }
        if (reconcileStatusId != null) {
            builder.setReconcileStatusId(reconcileStatusId);
        }
        if (settlementTermId != null) {
            builder.setSettlementTermId(settlementTermId);
        }
        if (isSummary != null) {
            builder.setIsSummary(getIndicator(isSummary));
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

    public static AcctgTransEntry fromData(AcctgTransEntryData data) {
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
                
                .build();
    }

    
}

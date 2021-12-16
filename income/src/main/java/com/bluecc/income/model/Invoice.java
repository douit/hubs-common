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

import com.bluecc.hubs.stub.InvoiceFlatData;

import com.bluecc.hubs.stub.InvoiceData;
import com.bluecc.income.dao.InvoiceDelegator;
import static com.bluecc.income.dao.InvoiceDelegator.*;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = InvoiceData.class,
        symbol = EntityNames.Invoice)
public class Invoice implements IEventModel<InvoiceFlatData.Builder>, Serializable, WithSuppliers, WithDescription {
    private static final long serialVersionUID = 1L;

    @RId String invoiceId;
    String invoiceTypeId;
    String partyIdFrom;
    String partyId;
    String roleTypeId;
    String statusId;
    String billingAccountId;
    String contactMechId;
    java.time.LocalDateTime invoiceDate;
    java.time.LocalDateTime dueDate;
    java.time.LocalDateTime paidDate;
    String invoiceMessage;
    String referenceNumber;
    String description;
    String currencyUomId;
    String recurrenceInfoId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String tenantId;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public InvoiceFlatData.Builder toDataBuilder() {
        InvoiceFlatData.Builder builder = InvoiceFlatData.newBuilder();
        if (invoiceId != null) {
            builder.setInvoiceId(invoiceId);
        }
        if (invoiceTypeId != null) {
            builder.setInvoiceTypeId(invoiceTypeId);
        }
        if (partyIdFrom != null) {
            builder.setPartyIdFrom(partyIdFrom);
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (roleTypeId != null) {
            builder.setRoleTypeId(roleTypeId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (billingAccountId != null) {
            builder.setBillingAccountId(billingAccountId);
        }
        if (contactMechId != null) {
            builder.setContactMechId(contactMechId);
        }
        if (invoiceDate != null) {
            builder.setInvoiceDate(getTimestamp(invoiceDate));
        }
        if (dueDate != null) {
            builder.setDueDate(getTimestamp(dueDate));
        }
        if (paidDate != null) {
            builder.setPaidDate(getTimestamp(paidDate));
        }
        if (invoiceMessage != null) {
            builder.setInvoiceMessage(invoiceMessage);
        }
        if (referenceNumber != null) {
            builder.setReferenceNumber(referenceNumber);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (currencyUomId != null) {
            builder.setCurrencyUomId(currencyUomId);
        }
        if (recurrenceInfoId != null) {
            builder.setRecurrenceInfoId(recurrenceInfoId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
        if (tenantId != null) {
            builder.setTenantId(tenantId);
        }
                    
        return builder;
    }

    public static Invoice fromData(InvoiceFlatData data) {
        return Invoice.builder()
                .invoiceId(data.getInvoiceId())
                .invoiceTypeId(data.getInvoiceTypeId())
                .partyIdFrom(data.getPartyIdFrom())
                .partyId(data.getPartyId())
                .roleTypeId(data.getRoleTypeId())
                .statusId(data.getStatusId())
                .billingAccountId(data.getBillingAccountId())
                .contactMechId(data.getContactMechId())
                .invoiceDate(getLocalDateTime(data.getInvoiceDate()))
                .dueDate(getLocalDateTime(data.getDueDate()))
                .paidDate(getLocalDateTime(data.getPaidDate()))
                .invoiceMessage(data.getInvoiceMessage())
                .referenceNumber(data.getReferenceNumber())
                .description(data.getDescription())
                .currencyUomId(data.getCurrencyUomId())
                .recurrenceInfoId(data.getRecurrenceInfoId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .tenantId(data.getTenantId())
                
                .build();
    }

        // relations
     
    @Exclude
    @Singular("addFromParty")
    List<Party> relFromParty= new ArrayList<>(); 
    @Exclude
    @Singular("addParty")
    List<Party> relParty= new ArrayList<>(); 
    @Exclude
    @Singular("addPartyRole")
    List<PartyRole> relPartyRole= new ArrayList<>(); 
    @Exclude
    @Singular("addBillingAccount")
    List<BillingAccount> relBillingAccount= new ArrayList<>(); 
    @Exclude
    @Singular("addContactMech")
    List<ContactMech> relContactMech= new ArrayList<>(); 
    @Exclude
    @Singular("addRecurrenceInfo")
    List<RecurrenceInfo> relRecurrenceInfo= new ArrayList<>(); 
    @Exclude
    @Singular("addAcctgTrans")
    List<AcctgTrans> relAcctgTrans= new ArrayList<>(); 
    @Exclude
    @Singular("addInvoiceItem")
    List<InvoiceItem> relInvoiceItem= new ArrayList<>(); 
    @Exclude
    @Singular("addInvoiceRole")
    List<InvoiceRole> relInvoiceRole= new ArrayList<>(); 
    @Exclude
    @Singular("addInvoiceStatus")
    List<InvoiceStatus> relInvoiceStatus= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderAdjustmentBilling")
    List<OrderAdjustmentBilling> relOrderAdjustmentBilling= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderItemBilling")
    List<OrderItemBilling> relOrderItemBilling= new ArrayList<>(); 
    @Exclude
    @Singular("addPaymentApplication")
    List<PaymentApplication> relPaymentApplication= new ArrayList<>(); 
    @Exclude
    @Singular("addShipmentItemBilling")
    List<ShipmentItemBilling> relShipmentItemBilling= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    List<Tenant> relTenant= new ArrayList<>();

    public Map<String, Supplier<List<?>>> suppliers(){
        Map<String, Supplier<List<?>>> supplierMap=Maps.newHashMap();
         
        supplierMap.put(FROM_PARTY, getter(this, Invoice::getRelFromParty)); 
        supplierMap.put(PARTY, getter(this, Invoice::getRelParty)); 
        supplierMap.put(PARTY_ROLE, getter(this, Invoice::getRelPartyRole)); 
        supplierMap.put(BILLING_ACCOUNT, getter(this, Invoice::getRelBillingAccount)); 
        supplierMap.put(CONTACT_MECH, getter(this, Invoice::getRelContactMech)); 
        supplierMap.put(RECURRENCE_INFO, getter(this, Invoice::getRelRecurrenceInfo)); 
        supplierMap.put(ACCTG_TRANS, getter(this, Invoice::getRelAcctgTrans)); 
        supplierMap.put(INVOICE_ITEM, getter(this, Invoice::getRelInvoiceItem)); 
        supplierMap.put(INVOICE_ROLE, getter(this, Invoice::getRelInvoiceRole)); 
        supplierMap.put(INVOICE_STATUS, getter(this, Invoice::getRelInvoiceStatus)); 
        supplierMap.put(ORDER_ADJUSTMENT_BILLING, getter(this, Invoice::getRelOrderAdjustmentBilling)); 
        supplierMap.put(ORDER_ITEM_BILLING, getter(this, Invoice::getRelOrderItemBilling)); 
        supplierMap.put(PAYMENT_APPLICATION, getter(this, Invoice::getRelPaymentApplication)); 
        supplierMap.put(SHIPMENT_ITEM_BILLING, getter(this, Invoice::getRelShipmentItemBilling)); 
        supplierMap.put(TENANT, getter(this, Invoice::getRelTenant));

        return supplierMap;
    };

    public InvoiceDelegator.Agent agent(IProc.ProcContext ctx,
                                             InvoiceDelegator delegator){
        return delegator.getAgent(ctx, this.getInvoiceId());
    }

    public InvoiceData.Builder toHeadBuilder() {
        InvoiceData.Builder builder = InvoiceData.newBuilder();
        if (invoiceId != null) {
            builder.setInvoiceId(invoiceId);
        }
        if (invoiceTypeId != null) {
            builder.setInvoiceTypeId(invoiceTypeId);
        }
        if (roleTypeId != null) {
            builder.setRoleTypeId(roleTypeId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (invoiceDate != null) {
            builder.setInvoiceDate(getTimestamp(invoiceDate));
        }
        if (dueDate != null) {
            builder.setDueDate(getTimestamp(dueDate));
        }
        if (paidDate != null) {
            builder.setPaidDate(getTimestamp(paidDate));
        }
        if (invoiceMessage != null) {
            builder.setInvoiceMessage(invoiceMessage);
        }
        if (referenceNumber != null) {
            builder.setReferenceNumber(referenceNumber);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (currencyUomId != null) {
            builder.setCurrencyUomId(currencyUomId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

}


/*
-- keys: invoiceId

-- fields --
    
    String invoiceId
    String invoiceTypeId
    String partyIdFrom
    String partyId
    String roleTypeId
    String statusId
    String billingAccountId
    String contactMechId
    java.time.LocalDateTime invoiceDate
    java.time.LocalDateTime dueDate
    java.time.LocalDateTime paidDate
    String invoiceMessage
    String referenceNumber
    String description
    String currencyUomId
    String recurrenceInfoId

-- relations --
    
    - InvoiceType (one, autoRelation: false, keymaps: invoiceTypeId)
    + InvoiceTypeAttr (many, autoRelation: false, keymaps: invoiceTypeId)
    - FromParty (one, autoRelation: false, keymaps: partyIdFrom -> partyId)
    - Party (one, autoRelation: false, keymaps: partyId)
    - RoleType (one, autoRelation: false, keymaps: roleTypeId)
    - PartyRole (one-nofk, autoRelation: false, keymaps: partyId, roleTypeId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    - BillingAccount (one, autoRelation: false, keymaps: billingAccountId)
    - ContactMech (one, autoRelation: false, keymaps: contactMechId)
    - CurrencyUom (one, autoRelation: false, keymaps: currencyUomId -> uomId)
    - RecurrenceInfo (one, autoRelation: false, keymaps: recurrenceInfoId)
    + AcctgTrans (many, autoRelation: true, keymaps: invoiceId)
    + InvoiceAttribute (many, autoRelation: true, keymaps: invoiceId)
    + InvoiceContactMech (many, autoRelation: true, keymaps: invoiceId)
    + InvoiceContent (many, autoRelation: true, keymaps: invoiceId)
    + InvoiceItem (many, autoRelation: true, keymaps: invoiceId)
    + InvoiceNote (many, autoRelation: true, keymaps: invoiceId)
    + InvoiceRole (many, autoRelation: true, keymaps: invoiceId)
    + InvoiceStatus (many, autoRelation: true, keymaps: invoiceId)
    + InvoiceTerm (many, autoRelation: true, keymaps: invoiceId)
    + OrderAdjustmentBilling (many, autoRelation: true, keymaps: invoiceId)
    + OrderItemBilling (many, autoRelation: true, keymaps: invoiceId)
    + PaymentApplication (many, autoRelation: true, keymaps: invoiceId)
    + ReturnItemBilling (many, autoRelation: true, keymaps: invoiceId)
    + ShipmentItemBilling (many, autoRelation: true, keymaps: invoiceId)
    + TimeEntry (many, autoRelation: true, keymaps: invoiceId)
    + WorkEffortBilling (many, autoRelation: true, keymaps: invoiceId)
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/


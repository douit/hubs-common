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

import com.bluecc.hubs.stub.ReturnHeaderData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ReturnHeaderData.class,
        symbol = EntityNames.ReturnHeader)
public class ReturnHeader implements IEventModel<ReturnHeaderData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("return_id")
	@RId 
    String returnId;
    @SerializedName("return_header_type_id") 
    String returnHeaderTypeId;
    @SerializedName("status_id") 
    String statusId;
    @SerializedName("created_by") 
    String createdBy;
    @SerializedName("from_party_id") 
    String fromPartyId;
    @SerializedName("to_party_id") 
    String toPartyId;
    @SerializedName("payment_method_id") 
    String paymentMethodId;
    @SerializedName("fin_account_id") 
    String finAccountId;
    @SerializedName("billing_account_id") 
    String billingAccountId;
    @SerializedName("entry_date") 
    java.time.LocalDateTime entryDate;
    @SerializedName("origin_contact_mech_id") 
    String originContactMechId;
    @SerializedName("destination_facility_id") 
    String destinationFacilityId;
    @SerializedName("needs_inventory_receive") 
    Character needsInventoryReceive;
    @SerializedName("currency_uom_id") 
    String currencyUomId;
    @SerializedName("supplier_rma_id") 
    String supplierRmaId;
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
        return returnId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ReturnHeaderData.Builder toDataBuilder() {
        ReturnHeaderData.Builder builder = ReturnHeaderData.newBuilder();
        if (returnId != null) {
            builder.setReturnId(returnId);
        }
        if (returnHeaderTypeId != null) {
            builder.setReturnHeaderTypeId(returnHeaderTypeId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (createdBy != null) {
            builder.setCreatedBy(createdBy);
        }
        if (fromPartyId != null) {
            builder.setFromPartyId(fromPartyId);
        }
        if (toPartyId != null) {
            builder.setToPartyId(toPartyId);
        }
        if (paymentMethodId != null) {
            builder.setPaymentMethodId(paymentMethodId);
        }
        if (finAccountId != null) {
            builder.setFinAccountId(finAccountId);
        }
        if (billingAccountId != null) {
            builder.setBillingAccountId(billingAccountId);
        }
        if (entryDate != null) {
            builder.setEntryDate(getTimestamp(entryDate));
        }
        if (originContactMechId != null) {
            builder.setOriginContactMechId(originContactMechId);
        }
        if (destinationFacilityId != null) {
            builder.setDestinationFacilityId(destinationFacilityId);
        }
        if (needsInventoryReceive != null) {
            builder.setNeedsInventoryReceive(getIndicator(needsInventoryReceive));
        }
        if (currencyUomId != null) {
            builder.setCurrencyUomId(currencyUomId);
        }
        if (supplierRmaId != null) {
            builder.setSupplierRmaId(supplierRmaId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static ReturnHeader fromData(ReturnHeaderData data) {
        return ReturnHeader.builder()
                .returnId(data.getReturnId())
                .returnHeaderTypeId(data.getReturnHeaderTypeId())
                .statusId(data.getStatusId())
                .createdBy(data.getCreatedBy())
                .fromPartyId(data.getFromPartyId())
                .toPartyId(data.getToPartyId())
                .paymentMethodId(data.getPaymentMethodId())
                .finAccountId(data.getFinAccountId())
                .billingAccountId(data.getBillingAccountId())
                .entryDate(getLocalDateTime(data.getEntryDate()))
                .originContactMechId(data.getOriginContactMechId())
                .destinationFacilityId(data.getDestinationFacilityId())
                .needsInventoryReceive(getIndicatorChar(data.getNeedsInventoryReceive()))
                .currencyUomId(data.getCurrencyUomId())
                .supplierRmaId(data.getSupplierRmaId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: returnId

-- fields --
    
    String returnId
    String returnHeaderTypeId
    String statusId
    String createdBy
    String fromPartyId
    String toPartyId
    String paymentMethodId
    String finAccountId
    String billingAccountId
    java.time.LocalDateTime entryDate
    String originContactMechId
    String destinationFacilityId
    Character needsInventoryReceive
    String currencyUomId
    String supplierRmaId

-- relations --
    
    - ReturnHeaderType (one, autoRelation: false, keymaps: returnHeaderTypeId)
    - Party (one, autoRelation: false, keymaps: fromPartyId -> partyId)
    - ToParty (one, autoRelation: false, keymaps: toPartyId -> partyId)
    - BillingAccount (one, autoRelation: false, keymaps: billingAccountId)
    - FinAccount (one, autoRelation: false, keymaps: finAccountId)
    - PaymentMethod (one, autoRelation: false, keymaps: paymentMethodId)
    - Facility (one, autoRelation: false, keymaps: destinationFacilityId -> facilityId)
    - ContactMech (one, autoRelation: false, keymaps: originContactMechId -> contactMechId)
    - PostalAddress (one-nofk, autoRelation: false, keymaps: originContactMechId -> contactMechId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    - Uom (one, autoRelation: false, keymaps: currencyUomId -> uomId)
    - UserLogin (one-nofk, autoRelation: false, keymaps: createdBy -> userLoginId)
    + CommunicationEventReturn (many, autoRelation: true, keymaps: returnId)
    + PosTerminalLog (many, autoRelation: true, keymaps: returnId)
    + ReturnAdjustment (many, autoRelation: true, keymaps: returnId)
    + ReturnContactMech (many, autoRelation: true, keymaps: returnId)
    + ReturnItem (many, autoRelation: true, keymaps: returnId)
    + ReturnItemBilling (many, autoRelation: true, keymaps: returnId)
    + ReturnItemShipment (many, autoRelation: true, keymaps: returnId)
    + ReturnStatus (many, autoRelation: true, keymaps: returnId)
    + PrimaryShipment (many, autoRelation: true, keymaps: returnId -> primaryReturnId)
    + TrackingCodeOrderReturn (many, autoRelation: true, keymaps: returnId)
*/


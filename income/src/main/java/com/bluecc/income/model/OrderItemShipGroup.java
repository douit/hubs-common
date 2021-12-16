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

import com.bluecc.hubs.stub.OrderItemShipGroupData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = OrderItemShipGroupData.class,
        symbol = EntityNames.OrderItemShipGroup)
public class OrderItemShipGroup implements IEventModel<OrderItemShipGroupData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String orderId;
    @RIndex String shipGroupSeqId;
    String shipmentMethodTypeId;
    String supplierPartyId;
    String supplierAgreementId;
    String vendorPartyId;
    String carrierPartyId;
    String carrierRoleTypeId;
    String facilityId;
    String contactMechId;
    String telecomContactMechId;
    String trackingNumber;
    String shippingInstructions;
    Character maySplit;
    String giftMessage;
    Character isGift;
    java.time.LocalDateTime shipAfterDate;
    java.time.LocalDateTime shipByDate;
    java.time.LocalDateTime estimatedShipDate;
    java.time.LocalDateTime estimatedDeliveryDate;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public OrderItemShipGroupData.Builder toDataBuilder() {
        OrderItemShipGroupData.Builder builder = OrderItemShipGroupData.newBuilder();
        if (orderId != null) {
            builder.setOrderId(orderId);
        }
        if (shipGroupSeqId != null) {
            builder.setShipGroupSeqId(shipGroupSeqId);
        }
        if (shipmentMethodTypeId != null) {
            builder.setShipmentMethodTypeId(shipmentMethodTypeId);
        }
        if (supplierPartyId != null) {
            builder.setSupplierPartyId(supplierPartyId);
        }
        if (supplierAgreementId != null) {
            builder.setSupplierAgreementId(supplierAgreementId);
        }
        if (vendorPartyId != null) {
            builder.setVendorPartyId(vendorPartyId);
        }
        if (carrierPartyId != null) {
            builder.setCarrierPartyId(carrierPartyId);
        }
        if (carrierRoleTypeId != null) {
            builder.setCarrierRoleTypeId(carrierRoleTypeId);
        }
        if (facilityId != null) {
            builder.setFacilityId(facilityId);
        }
        if (contactMechId != null) {
            builder.setContactMechId(contactMechId);
        }
        if (telecomContactMechId != null) {
            builder.setTelecomContactMechId(telecomContactMechId);
        }
        if (trackingNumber != null) {
            builder.setTrackingNumber(trackingNumber);
        }
        if (shippingInstructions != null) {
            builder.setShippingInstructions(shippingInstructions);
        }
        if (maySplit != null) {
            builder.setMaySplit(getIndicator(maySplit));
        }
        if (giftMessage != null) {
            builder.setGiftMessage(giftMessage);
        }
        if (isGift != null) {
            builder.setIsGift(getIndicator(isGift));
        }
        if (shipAfterDate != null) {
            builder.setShipAfterDate(getTimestamp(shipAfterDate));
        }
        if (shipByDate != null) {
            builder.setShipByDate(getTimestamp(shipByDate));
        }
        if (estimatedShipDate != null) {
            builder.setEstimatedShipDate(getTimestamp(estimatedShipDate));
        }
        if (estimatedDeliveryDate != null) {
            builder.setEstimatedDeliveryDate(getTimestamp(estimatedDeliveryDate));
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

    public static OrderItemShipGroup fromData(OrderItemShipGroupData data) {
        return OrderItemShipGroup.builder()
                .orderId(data.getOrderId())
                .shipGroupSeqId(data.getShipGroupSeqId())
                .shipmentMethodTypeId(data.getShipmentMethodTypeId())
                .supplierPartyId(data.getSupplierPartyId())
                .supplierAgreementId(data.getSupplierAgreementId())
                .vendorPartyId(data.getVendorPartyId())
                .carrierPartyId(data.getCarrierPartyId())
                .carrierRoleTypeId(data.getCarrierRoleTypeId())
                .facilityId(data.getFacilityId())
                .contactMechId(data.getContactMechId())
                .telecomContactMechId(data.getTelecomContactMechId())
                .trackingNumber(data.getTrackingNumber())
                .shippingInstructions(data.getShippingInstructions())
                .maySplit(getIndicatorChar(data.getMaySplit()))
                .giftMessage(data.getGiftMessage())
                .isGift(getIndicatorChar(data.getIsGift()))
                .shipAfterDate(getLocalDateTime(data.getShipAfterDate()))
                .shipByDate(getLocalDateTime(data.getShipByDate()))
                .estimatedShipDate(getLocalDateTime(data.getEstimatedShipDate()))
                .estimatedDeliveryDate(getLocalDateTime(data.getEstimatedDeliveryDate()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: orderId, shipGroupSeqId

-- fields --
    
    String orderId
    String shipGroupSeqId
    String shipmentMethodTypeId
    String supplierPartyId
    String supplierAgreementId
    String vendorPartyId
    String carrierPartyId
    String carrierRoleTypeId
    String facilityId
    String contactMechId
    String telecomContactMechId
    String trackingNumber
    String shippingInstructions
    Character maySplit
    String giftMessage
    Character isGift
    java.time.LocalDateTime shipAfterDate
    java.time.LocalDateTime shipByDate
    java.time.LocalDateTime estimatedShipDate
    java.time.LocalDateTime estimatedDeliveryDate

-- relations --
    
    - OrderHeader (one, autoRelation: false, keymaps: orderId)
    - SupplierParty (one, autoRelation: false, keymaps: supplierPartyId -> partyId)
    - SupplierAgreement (one, autoRelation: false, keymaps: supplierAgreementId -> agreementId)
    - VendorParty (one, autoRelation: false, keymaps: vendorPartyId -> partyId)
    - CarrierShipmentMethod (one, autoRelation: false, keymaps: shipmentMethodTypeId, carrierPartyId -> partyId, carrierRoleTypeId -> roleTypeId)
    - CarrierParty (one, autoRelation: false, keymaps: carrierPartyId -> partyId)
    - CarrierPartyRole (one, autoRelation: false, keymaps: carrierPartyId -> partyId, carrierRoleTypeId -> roleTypeId)
    - Facility (one, autoRelation: false, keymaps: facilityId)
    - ShipmentMethodType (one, autoRelation: false, keymaps: shipmentMethodTypeId)
    - ContactMech (one, autoRelation: false, keymaps: contactMechId)
    - PostalAddress (one, autoRelation: false, keymaps: contactMechId)
    - TelecomContactMech (one, autoRelation: false, keymaps: telecomContactMechId -> contactMechId)
    - TelecomTelecomNumber (one, autoRelation: false, keymaps: telecomContactMechId -> contactMechId)
    + OrderAdjustment (many, autoRelation: true, keymaps: orderId, shipGroupSeqId)
    + FromOrderItemAssoc (many, autoRelation: true, keymaps: orderId, shipGroupSeqId)
    + ToOrderItemAssoc (many, autoRelation: true, keymaps: orderId -> toOrderId, shipGroupSeqId -> toShipGroupSeqId)
    + OrderItemShipGroupAssoc (many, autoRelation: true, keymaps: orderId, shipGroupSeqId)
    + OrderItemShipGrpInvRes (many, autoRelation: true, keymaps: orderId, shipGroupSeqId)
    + OrderPaymentPreference (many, autoRelation: true, keymaps: orderId, shipGroupSeqId)
    + PrimaryPicklistBin (many, autoRelation: true, keymaps: orderId -> primaryOrderId, shipGroupSeqId -> primaryShipGroupSeqId)
    + PicklistItem (many, autoRelation: true, keymaps: orderId, shipGroupSeqId)
    + PrimaryShipment (many, autoRelation: true, keymaps: orderId -> primaryOrderId, shipGroupSeqId -> primaryShipGroupSeqId)
*/


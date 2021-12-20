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

import com.bluecc.hubs.stub.OrderItemShipGroupData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = OrderItemShipGroupData.class,
        symbol = EntityNames.OrderItemShipGroup)
public class OrderItemShipGroup implements IEventModel<OrderItemShipGroupData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("order_id")
	@RIndex 
    String orderId;
    @SerializedName("ship_group_seq_id")
	@RIndex 
    String shipGroupSeqId;
    @SerializedName("shipment_method_type_id") 
    String shipmentMethodTypeId;
    @SerializedName("supplier_party_id") 
    String supplierPartyId;
    @SerializedName("supplier_agreement_id") 
    String supplierAgreementId;
    @SerializedName("vendor_party_id") 
    String vendorPartyId;
    @SerializedName("carrier_party_id") 
    String carrierPartyId;
    @SerializedName("carrier_role_type_id") 
    String carrierRoleTypeId;
    @SerializedName("facility_id") 
    String facilityId;
    @SerializedName("contact_mech_id") 
    String contactMechId;
    @SerializedName("telecom_contact_mech_id") 
    String telecomContactMechId;
    @SerializedName("tracking_number") 
    String trackingNumber;
    @SerializedName("shipping_instructions") 
    String shippingInstructions;
    @SerializedName("may_split") 
    Character maySplit;
    @SerializedName("gift_message") 
    String giftMessage;
    @SerializedName("is_gift") 
    Character isGift;
    @SerializedName("ship_after_date") 
    java.time.LocalDateTime shipAfterDate;
    @SerializedName("ship_by_date") 
    java.time.LocalDateTime shipByDate;
    @SerializedName("estimated_ship_date") 
    java.time.LocalDateTime estimatedShipDate;
    @SerializedName("estimated_delivery_date") 
    java.time.LocalDateTime estimatedDeliveryDate;
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

    public OrderItemShipGroupData.Builder toDataBuilder() {
        OrderItemShipGroupData.Builder builder = OrderItemShipGroupData.newBuilder();
        if (getOrderId() != null) {
            builder.setOrderId(getOrderId());
        }
        if (getShipGroupSeqId() != null) {
            builder.setShipGroupSeqId(getShipGroupSeqId());
        }
        if (getShipmentMethodTypeId() != null) {
            builder.setShipmentMethodTypeId(getShipmentMethodTypeId());
        }
        if (getSupplierPartyId() != null) {
            builder.setSupplierPartyId(getSupplierPartyId());
        }
        if (getSupplierAgreementId() != null) {
            builder.setSupplierAgreementId(getSupplierAgreementId());
        }
        if (getVendorPartyId() != null) {
            builder.setVendorPartyId(getVendorPartyId());
        }
        if (getCarrierPartyId() != null) {
            builder.setCarrierPartyId(getCarrierPartyId());
        }
        if (getCarrierRoleTypeId() != null) {
            builder.setCarrierRoleTypeId(getCarrierRoleTypeId());
        }
        if (getFacilityId() != null) {
            builder.setFacilityId(getFacilityId());
        }
        if (getContactMechId() != null) {
            builder.setContactMechId(getContactMechId());
        }
        if (getTelecomContactMechId() != null) {
            builder.setTelecomContactMechId(getTelecomContactMechId());
        }
        if (getTrackingNumber() != null) {
            builder.setTrackingNumber(getTrackingNumber());
        }
        if (getShippingInstructions() != null) {
            builder.setShippingInstructions(getShippingInstructions());
        }
        if (getMaySplit() != null) {
            builder.setMaySplit(getIndicator(getMaySplit()));
        }
        if (getGiftMessage() != null) {
            builder.setGiftMessage(getGiftMessage());
        }
        if (getIsGift() != null) {
            builder.setIsGift(getIndicator(getIsGift()));
        }
        if (getShipAfterDate() != null) {
            builder.setShipAfterDate(getTimestamp(getShipAfterDate()));
        }
        if (getShipByDate() != null) {
            builder.setShipByDate(getTimestamp(getShipByDate()));
        }
        if (getEstimatedShipDate() != null) {
            builder.setEstimatedShipDate(getTimestamp(getEstimatedShipDate()));
        }
        if (getEstimatedDeliveryDate() != null) {
            builder.setEstimatedDeliveryDate(getTimestamp(getEstimatedDeliveryDate()));
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

    public static OrderItemShipGroup fromData(OrderItemShipGroupData data) {
        return fromPrototype(data).build();
    }

    public static OrderItemShipGroup.OrderItemShipGroupBuilder fromPrototype(OrderItemShipGroupData data) {
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
                ;
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


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

import com.bluecc.hubs.stub.ContactMechData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ContactMechData.class,
        symbol = EntityNames.ContactMech)
public class ContactMech implements IEventModel<ContactMechData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("contact_mech_id")
	@RId 
    String contactMechId;
    @SerializedName("contact_mech_type_id") 
    String contactMechTypeId;
    @SerializedName("info_string") 
    String infoString;
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
        return contactMechId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ContactMechData.Builder toDataBuilder() {
        ContactMechData.Builder builder = ContactMechData.newBuilder();
        if (getContactMechId() != null) {
            builder.setContactMechId(getContactMechId());
        }
        if (getContactMechTypeId() != null) {
            builder.setContactMechTypeId(getContactMechTypeId());
        }
        if (getInfoString() != null) {
            builder.setInfoString(getInfoString());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static ContactMech fromData(ContactMechData data) {
        return fromPrototype(data).build();
    }

    public static ContactMech.ContactMechBuilder fromPrototype(ContactMechData data) {
        return ContactMech.builder()
                .contactMechId(data.getContactMechId())
                .contactMechTypeId(data.getContactMechTypeId())
                .infoString(data.getInfoString())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
    }

    
}


/*
-- keys: contactMechId

-- fields --
    
    String contactMechId
    String contactMechTypeId
    String infoString

-- relations --
    
    - ContactMechType (one, autoRelation: false, keymaps: contactMechTypeId)
    + ContactMechTypeAttr (many, autoRelation: false, keymaps: contactMechTypeId)
    + BillingAccount (many, autoRelation: true, keymaps: contactMechId)
    + CheckAccount (many, autoRelation: true, keymaps: contactMechId)
    + FromCommunicationEvent (many, autoRelation: true, keymaps: contactMechId -> contactMechIdFrom)
    + ToCommunicationEvent (many, autoRelation: true, keymaps: contactMechId -> contactMechIdTo)
    + CommunicationEventRole (many, autoRelation: true, keymaps: contactMechId)
    + ContactListCommStatus (many, autoRelation: true, keymaps: contactMechId)
    + PreferredContactListParty (many, autoRelation: true, keymaps: contactMechId -> preferredContactMechId)
    + ContactMechAttribute (many, autoRelation: true, keymaps: contactMechId)
    + FromContactMechLink (many, autoRelation: true, keymaps: contactMechId -> contactMechIdFrom)
    + ToContactMechLink (many, autoRelation: true, keymaps: contactMechId -> contactMechIdTo)
    + CreditCard (many, autoRelation: true, keymaps: contactMechId)
    + FulfillCustRequest (many, autoRelation: true, keymaps: contactMechId -> fulfillContactMechId)
    + EftAccount (many, autoRelation: true, keymaps: contactMechId)
    + FacilityContactMech (many, autoRelation: true, keymaps: contactMechId)
    + FacilityContactMechPurpose (many, autoRelation: true, keymaps: contactMechId)
    - FtpAddress (one-nofk, autoRelation: true, keymaps: contactMechId)
    + GiftCard (many, autoRelation: true, keymaps: contactMechId)
    + Invoice (many, autoRelation: true, keymaps: contactMechId)
    + InvoiceContactMech (many, autoRelation: true, keymaps: contactMechId)
    + OrderContactMech (many, autoRelation: true, keymaps: contactMechId)
    + OrderItemContactMech (many, autoRelation: true, keymaps: contactMechId)
    + OrderItemShipGroup (many, autoRelation: true, keymaps: contactMechId)
    + TelecomOrderItemShipGroup (many, autoRelation: true, keymaps: contactMechId -> telecomContactMechId)
    + PartyContactMech (many, autoRelation: true, keymaps: contactMechId)
    + PartyContactMechPurpose (many, autoRelation: true, keymaps: contactMechId)
    + PayPalPaymentMethod (many, autoRelation: true, keymaps: contactMechId)
    - PostalAddress (one-nofk, autoRelation: true, keymaps: contactMechId)
    + ProdPromoCodeContactMech (many, autoRelation: true, keymaps: contactMechId)
    + RespondingParty (many, autoRelation: true, keymaps: contactMechId)
    + ReturnContactMech (many, autoRelation: true, keymaps: contactMechId)
    + ReturnHeader (many, autoRelation: true, keymaps: contactMechId -> originContactMechId)
    + OriginShipment (many, autoRelation: true, keymaps: contactMechId -> originContactMechId)
    + DestShipment (many, autoRelation: true, keymaps: contactMechId -> destinationContactMechId)
    + ShipmentContactMech (many, autoRelation: true, keymaps: contactMechId)
    + OriginShipmentRouteSegment (many, autoRelation: true, keymaps: contactMechId -> originContactMechId)
    + DestShipmentRouteSegment (many, autoRelation: true, keymaps: contactMechId -> destContactMechId)
    + ShoppingList (many, autoRelation: true, keymaps: contactMechId)
    + Subscription (many, autoRelation: true, keymaps: contactMechId)
    - TelecomNumber (one-nofk, autoRelation: true, keymaps: contactMechId)
    + WorkEffortContactMech (many, autoRelation: true, keymaps: contactMechId)
    + WorkEffortEventReminder (many, autoRelation: true, keymaps: contactMechId)
*/


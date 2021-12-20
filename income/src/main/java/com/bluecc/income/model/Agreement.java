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

import com.bluecc.hubs.stub.AgreementData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = AgreementData.class,
        symbol = EntityNames.Agreement)
public class Agreement implements IEventModel<AgreementData.Builder>, HasId, Serializable, WithDescription, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("agreement_id")
	@RId 
    String agreementId;
    @SerializedName("product_id") 
    String productId;
    @SerializedName("party_id_from") 
    String partyIdFrom;
    @SerializedName("party_id_to") 
    String partyIdTo;
    @SerializedName("role_type_id_from") 
    String roleTypeIdFrom;
    @SerializedName("role_type_id_to") 
    String roleTypeIdTo;
    @SerializedName("agreement_type_id") 
    String agreementTypeId;
    @SerializedName("agreement_date") 
    java.time.LocalDateTime agreementDate;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("description") 
    String description;
    @SerializedName("text_data") 
    String textData;
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
        return agreementId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public AgreementData.Builder toDataBuilder() {
        AgreementData.Builder builder = AgreementData.newBuilder();
        if (getAgreementId() != null) {
            builder.setAgreementId(getAgreementId());
        }
        if (getProductId() != null) {
            builder.setProductId(getProductId());
        }
        if (getPartyIdFrom() != null) {
            builder.setPartyIdFrom(getPartyIdFrom());
        }
        if (getPartyIdTo() != null) {
            builder.setPartyIdTo(getPartyIdTo());
        }
        if (getRoleTypeIdFrom() != null) {
            builder.setRoleTypeIdFrom(getRoleTypeIdFrom());
        }
        if (getRoleTypeIdTo() != null) {
            builder.setRoleTypeIdTo(getRoleTypeIdTo());
        }
        if (getAgreementTypeId() != null) {
            builder.setAgreementTypeId(getAgreementTypeId());
        }
        if (getAgreementDate() != null) {
            builder.setAgreementDate(getTimestamp(getAgreementDate()));
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getTextData() != null) {
            builder.setTextData(getTextData());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static Agreement fromData(AgreementData data) {
        return fromPrototype(data).build();
    }

    public static Agreement.AgreementBuilder fromPrototype(AgreementData data) {
        return Agreement.builder()
                .agreementId(data.getAgreementId())
                .productId(data.getProductId())
                .partyIdFrom(data.getPartyIdFrom())
                .partyIdTo(data.getPartyIdTo())
                .roleTypeIdFrom(data.getRoleTypeIdFrom())
                .roleTypeIdTo(data.getRoleTypeIdTo())
                .agreementTypeId(data.getAgreementTypeId())
                .agreementDate(getLocalDateTime(data.getAgreementDate()))
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .description(data.getDescription())
                .textData(data.getTextData())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
    }

    
}


/*
-- keys: agreementId

-- fields --
    
    String agreementId
    String productId
    String partyIdFrom
    String partyIdTo
    String roleTypeIdFrom
    String roleTypeIdTo
    String agreementTypeId
    java.time.LocalDateTime agreementDate
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    String description
    String textData

-- relations --
    
    - Product (one, autoRelation: false, keymaps: productId)
    - FromParty (one-nofk, autoRelation: false, keymaps: partyIdFrom -> partyId)
    - FromRoleType (one-nofk, autoRelation: false, keymaps: roleTypeIdFrom -> roleTypeId)
    - FromPartyRole (one, autoRelation: false, keymaps: partyIdFrom -> partyId, roleTypeIdFrom -> roleTypeId)
    - ToParty (one-nofk, autoRelation: false, keymaps: partyIdTo -> partyId)
    - ToRoleType (one-nofk, autoRelation: false, keymaps: roleTypeIdTo -> roleTypeId)
    - ToPartyRole (one, autoRelation: false, keymaps: partyIdTo -> partyId, roleTypeIdTo -> roleTypeId)
    + PartyRelationship (many, autoRelation: false, keymaps: roleTypeIdFrom, roleTypeIdTo, partyIdFrom, partyIdTo)
    - AgreementType (one, autoRelation: false, keymaps: agreementTypeId)
    + AgreementTypeAttr (many, autoRelation: false, keymaps: agreementTypeId)
    + Addendum (many, autoRelation: true, keymaps: agreementId)
    + AgreementAttribute (many, autoRelation: true, keymaps: agreementId)
    + AgreementContent (many, autoRelation: true, keymaps: agreementId)
    + AgreementFacilityAppl (many, autoRelation: true, keymaps: agreementId)
    + AgreementGeographicalApplic (many, autoRelation: true, keymaps: agreementId)
    + AgreementItem (many, autoRelation: true, keymaps: agreementId)
    + AgreementPartyApplic (many, autoRelation: true, keymaps: agreementId)
    + AgreementProductAppl (many, autoRelation: true, keymaps: agreementId)
    + AgreementPromoAppl (many, autoRelation: true, keymaps: agreementId)
    + AgreementRole (many, autoRelation: true, keymaps: agreementId)
    + AgreementTerm (many, autoRelation: true, keymaps: agreementId)
    + AgreementWorkEffortApplic (many, autoRelation: true, keymaps: agreementId)
    + SupplierOrderItemShipGroup (many, autoRelation: true, keymaps: agreementId -> supplierAgreementId)
*/


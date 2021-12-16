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

import com.bluecc.hubs.stub.AgreementData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = AgreementData.class,
        symbol = EntityNames.Agreement)
public class Agreement implements IEventModel<AgreementData.Builder>, Serializable, WithDescription, WithPeriod {
    private static final long serialVersionUID = 1L;

    @RId String agreementId;
    String productId;
    String partyIdFrom;
    String partyIdTo;
    String roleTypeIdFrom;
    String roleTypeIdTo;
    String agreementTypeId;
    java.time.LocalDateTime agreementDate;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    String description;
    String textData;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public AgreementData.Builder toDataBuilder() {
        AgreementData.Builder builder = AgreementData.newBuilder();
        if (agreementId != null) {
            builder.setAgreementId(agreementId);
        }
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (partyIdFrom != null) {
            builder.setPartyIdFrom(partyIdFrom);
        }
        if (partyIdTo != null) {
            builder.setPartyIdTo(partyIdTo);
        }
        if (roleTypeIdFrom != null) {
            builder.setRoleTypeIdFrom(roleTypeIdFrom);
        }
        if (roleTypeIdTo != null) {
            builder.setRoleTypeIdTo(roleTypeIdTo);
        }
        if (agreementTypeId != null) {
            builder.setAgreementTypeId(agreementTypeId);
        }
        if (agreementDate != null) {
            builder.setAgreementDate(getTimestamp(agreementDate));
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (textData != null) {
            builder.setTextData(textData);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static Agreement fromData(AgreementData data) {
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
                
                .build();
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


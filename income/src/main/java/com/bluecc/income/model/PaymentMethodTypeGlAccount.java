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

import com.bluecc.hubs.stub.PaymentMethodTypeGlAccountData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PaymentMethodTypeGlAccountData.class,
        symbol = EntityNames.PaymentMethodTypeGlAccount)
public class PaymentMethodTypeGlAccount implements IEventModel<PaymentMethodTypeGlAccountData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String paymentMethodTypeId;
    @RIndex String organizationPartyId;
    String glAccountId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public PaymentMethodTypeGlAccountData.Builder toDataBuilder() {
        PaymentMethodTypeGlAccountData.Builder builder = PaymentMethodTypeGlAccountData.newBuilder();
        if (paymentMethodTypeId != null) {
            builder.setPaymentMethodTypeId(paymentMethodTypeId);
        }
        if (organizationPartyId != null) {
            builder.setOrganizationPartyId(organizationPartyId);
        }
        if (glAccountId != null) {
            builder.setGlAccountId(glAccountId);
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

    public static PaymentMethodTypeGlAccount fromData(PaymentMethodTypeGlAccountData data) {
        return PaymentMethodTypeGlAccount.builder()
                .paymentMethodTypeId(data.getPaymentMethodTypeId())
                .organizationPartyId(data.getOrganizationPartyId())
                .glAccountId(data.getGlAccountId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: paymentMethodTypeId, organizationPartyId

-- fields --
    
    String paymentMethodTypeId
    String organizationPartyId
    String glAccountId

-- relations --
    
    - PaymentMethodType (one, autoRelation: false, keymaps: paymentMethodTypeId)
    - OrganizationParty (one, autoRelation: false, keymaps: organizationPartyId -> partyId)
    - GlAccount (one, autoRelation: false, keymaps: glAccountId)
*/

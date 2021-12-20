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

import com.bluecc.hubs.stub.PaymentMethodTypeGlAccountData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PaymentMethodTypeGlAccountData.class,
        symbol = EntityNames.PaymentMethodTypeGlAccount)
public class PaymentMethodTypeGlAccount implements IEventModel<PaymentMethodTypeGlAccountData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("payment_method_type_id")
	@RIndex 
    String paymentMethodTypeId;
    @SerializedName("organization_party_id")
	@RIndex 
    String organizationPartyId;
    @SerializedName("gl_account_id") 
    String glAccountId;
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

    public PaymentMethodTypeGlAccountData.Builder toDataBuilder() {
        PaymentMethodTypeGlAccountData.Builder builder = PaymentMethodTypeGlAccountData.newBuilder();
        if (getPaymentMethodTypeId() != null) {
            builder.setPaymentMethodTypeId(getPaymentMethodTypeId());
        }
        if (getOrganizationPartyId() != null) {
            builder.setOrganizationPartyId(getOrganizationPartyId());
        }
        if (getGlAccountId() != null) {
            builder.setGlAccountId(getGlAccountId());
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

    public static PaymentMethodTypeGlAccount fromData(PaymentMethodTypeGlAccountData data) {
        return fromPrototype(data).build();
    }

    public static PaymentMethodTypeGlAccount.PaymentMethodTypeGlAccountBuilder fromPrototype(PaymentMethodTypeGlAccountData data) {
        return PaymentMethodTypeGlAccount.builder()
                .paymentMethodTypeId(data.getPaymentMethodTypeId())
                .organizationPartyId(data.getOrganizationPartyId())
                .glAccountId(data.getGlAccountId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
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


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

import com.bluecc.hubs.stub.PaymentMethodData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PaymentMethodData.class,
        symbol = EntityNames.PaymentMethod)
public class PaymentMethod implements IEventModel<PaymentMethodData.Builder>, HasId, Serializable, WithDescription, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("payment_method_id")
	@RId 
    String paymentMethodId;
    @SerializedName("payment_method_type_id") 
    String paymentMethodTypeId;
    @SerializedName("party_id") 
    String partyId;
    @SerializedName("gl_account_id") 
    String glAccountId;
    @SerializedName("fin_account_id") 
    String finAccountId;
    @SerializedName("description") 
    String description;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
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
        return paymentMethodId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public PaymentMethodData.Builder toDataBuilder() {
        PaymentMethodData.Builder builder = PaymentMethodData.newBuilder();
        if (getPaymentMethodId() != null) {
            builder.setPaymentMethodId(getPaymentMethodId());
        }
        if (getPaymentMethodTypeId() != null) {
            builder.setPaymentMethodTypeId(getPaymentMethodTypeId());
        }
        if (getPartyId() != null) {
            builder.setPartyId(getPartyId());
        }
        if (getGlAccountId() != null) {
            builder.setGlAccountId(getGlAccountId());
        }
        if (getFinAccountId() != null) {
            builder.setFinAccountId(getFinAccountId());
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static PaymentMethod fromData(PaymentMethodData data) {
        return fromPrototype(data).build();
    }

    public static PaymentMethod.PaymentMethodBuilder fromPrototype(PaymentMethodData data) {
        return PaymentMethod.builder()
                .paymentMethodId(data.getPaymentMethodId())
                .paymentMethodTypeId(data.getPaymentMethodTypeId())
                .partyId(data.getPartyId())
                .glAccountId(data.getGlAccountId())
                .finAccountId(data.getFinAccountId())
                .description(data.getDescription())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
    }

    
}


/*
-- keys: paymentMethodId

-- fields --
    
    String paymentMethodId
    String paymentMethodTypeId
    String partyId
    String glAccountId
    String finAccountId
    String description
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate

-- relations --
    
    - PaymentMethodType (one, autoRelation: false, keymaps: paymentMethodTypeId)
    - Party (one, autoRelation: false, keymaps: partyId)
    - GlAccount (one, autoRelation: false, keymaps: glAccountId)
    - FinAccount (one, autoRelation: false, keymaps: finAccountId)
    - CheckAccount (one-nofk, autoRelation: true, keymaps: paymentMethodId)
    - CreditCard (one-nofk, autoRelation: true, keymaps: paymentMethodId)
    - EftAccount (one-nofk, autoRelation: true, keymaps: paymentMethodId)
    + ReplenishFinAccount (many, autoRelation: true, keymaps: paymentMethodId -> replenishPaymentId)
    - GiftCard (one-nofk, autoRelation: true, keymaps: paymentMethodId)
    + OrderPaymentPreference (many, autoRelation: true, keymaps: paymentMethodId)
    + PartyAcctgPreference (many, autoRelation: true, keymaps: paymentMethodId -> refundPaymentMethodId)
    - PayPalPaymentMethod (one-nofk, autoRelation: true, keymaps: paymentMethodId)
    + Payment (many, autoRelation: true, keymaps: paymentMethodId)
    + PaymentGatewayResponse (many, autoRelation: true, keymaps: paymentMethodId)
    + ReturnHeader (many, autoRelation: true, keymaps: paymentMethodId)
    + ShoppingList (many, autoRelation: true, keymaps: paymentMethodId)
*/


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

import com.bluecc.hubs.stub.PaymentGlAccountTypeMapData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PaymentGlAccountTypeMapData.class,
        symbol = EntityNames.PaymentGlAccountTypeMap)
public class PaymentGlAccountTypeMap implements IEventModel<PaymentGlAccountTypeMapData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("payment_type_id")
	@RIndex 
    String paymentTypeId;
    @SerializedName("organization_party_id")
	@RIndex 
    String organizationPartyId;
    @SerializedName("gl_account_type_id") 
    String glAccountTypeId;
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

    public PaymentGlAccountTypeMapData.Builder toDataBuilder() {
        PaymentGlAccountTypeMapData.Builder builder = PaymentGlAccountTypeMapData.newBuilder();
        if (paymentTypeId != null) {
            builder.setPaymentTypeId(paymentTypeId);
        }
        if (organizationPartyId != null) {
            builder.setOrganizationPartyId(organizationPartyId);
        }
        if (glAccountTypeId != null) {
            builder.setGlAccountTypeId(glAccountTypeId);
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

    public static PaymentGlAccountTypeMap fromData(PaymentGlAccountTypeMapData data) {
        return PaymentGlAccountTypeMap.builder()
                .paymentTypeId(data.getPaymentTypeId())
                .organizationPartyId(data.getOrganizationPartyId())
                .glAccountTypeId(data.getGlAccountTypeId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: paymentTypeId, organizationPartyId

-- fields --
    
    String paymentTypeId
    String organizationPartyId
    String glAccountTypeId

-- relations --
    
    - PaymentType (one, autoRelation: false, keymaps: paymentTypeId)
    - Party (one, autoRelation: false, keymaps: organizationPartyId -> partyId)
    - GlAccountType (one, autoRelation: false, keymaps: glAccountTypeId)
*/


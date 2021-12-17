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

import com.bluecc.hubs.stub.PaymentContentTypeData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PaymentContentTypeData.class,
        symbol = EntityNames.PaymentContentType)
public class PaymentContentType implements IEventModel<PaymentContentTypeData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("payment_content_type_id")
	@RId 
    String paymentContentTypeId;
    @SerializedName("parent_type_id") 
    String parentTypeId;
    @SerializedName("has_table") 
    Character hasTable;
    @SerializedName("description") 
    String description;
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
        return paymentContentTypeId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public PaymentContentTypeData.Builder toDataBuilder() {
        PaymentContentTypeData.Builder builder = PaymentContentTypeData.newBuilder();
        if (paymentContentTypeId != null) {
            builder.setPaymentContentTypeId(paymentContentTypeId);
        }
        if (parentTypeId != null) {
            builder.setParentTypeId(parentTypeId);
        }
        if (hasTable != null) {
            builder.setHasTable(getIndicator(hasTable));
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static PaymentContentType fromData(PaymentContentTypeData data) {
        return PaymentContentType.builder()
                .paymentContentTypeId(data.getPaymentContentTypeId())
                .parentTypeId(data.getParentTypeId())
                .hasTable(getIndicatorChar(data.getHasTable()))
                .description(data.getDescription())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: paymentContentTypeId

-- fields --
    
    String paymentContentTypeId
    String parentTypeId
    Character hasTable
    String description

-- relations --
    
    - ParentPaymentContentType (one, autoRelation: false, keymaps: parentTypeId -> paymentContentTypeId)
    + PaymentContent (many, autoRelation: true, keymaps: paymentContentTypeId)
    + ChildPaymentContentType (many, autoRelation: true, keymaps: paymentContentTypeId -> parentTypeId)
*/


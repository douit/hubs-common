package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;

import com.bluecc.hubs.stub.PaymentContentTypeData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PaymentContentTypeData.class,
        symbol = EntityNames.PaymentContentType)
public class PaymentContentType implements IEventModel<PaymentContentTypeData.Builder>, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @RId String paymentContentTypeId;
    String parentTypeId;
    Character hasTable;
    String description;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
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


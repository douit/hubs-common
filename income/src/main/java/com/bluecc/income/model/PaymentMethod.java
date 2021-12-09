package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.stub.PaymentMethodData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class PaymentMethod implements IEventModel<PaymentMethodData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String paymentMethodId;
    String paymentMethodTypeId;
    String partyId;
    String glAccountId;
    String finAccountId;
    String description;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public PaymentMethodData.Builder toDataBuilder() {
        PaymentMethodData.Builder builder = PaymentMethodData.newBuilder();
        if (paymentMethodId != null) {
            builder.setPaymentMethodId(paymentMethodId);
        }
        if (paymentMethodTypeId != null) {
            builder.setPaymentMethodTypeId(paymentMethodTypeId);
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (glAccountId != null) {
            builder.setGlAccountId(glAccountId);
        }
        if (finAccountId != null) {
            builder.setFinAccountId(finAccountId);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static PaymentMethod fromData(PaymentMethodData data) {
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
                
                .build();
    }

    
}

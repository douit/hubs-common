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

import com.bluecc.hubs.stub.QuoteItemData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class QuoteItem implements IEventModel<QuoteItemData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String quoteId;
    @RIndex String quoteItemSeqId;
    String productId;
    String productFeatureId;
    String deliverableTypeId;
    String skillTypeId;
    String uomId;
    String workEffortId;
    String custRequestId;
    String custRequestItemSeqId;
    java.math.BigDecimal quantity;
    java.math.BigDecimal selectedAmount;
    java.math.BigDecimal quoteUnitPrice;
    java.time.LocalDateTime reservStart;
    java.math.BigDecimal reservLength;
    java.math.BigDecimal reservPersons;
    String configId;
    java.time.LocalDateTime estimatedDeliveryDate;
    String comments;
    Character isPromo;
    Long leadTimeDays;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public QuoteItemData.Builder toDataBuilder() {
        QuoteItemData.Builder builder = QuoteItemData.newBuilder();
        if (quoteId != null) {
            builder.setQuoteId(quoteId);
        }
        if (quoteItemSeqId != null) {
            builder.setQuoteItemSeqId(quoteItemSeqId);
        }
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (productFeatureId != null) {
            builder.setProductFeatureId(productFeatureId);
        }
        if (deliverableTypeId != null) {
            builder.setDeliverableTypeId(deliverableTypeId);
        }
        if (skillTypeId != null) {
            builder.setSkillTypeId(skillTypeId);
        }
        if (uomId != null) {
            builder.setUomId(uomId);
        }
        if (workEffortId != null) {
            builder.setWorkEffortId(workEffortId);
        }
        if (custRequestId != null) {
            builder.setCustRequestId(custRequestId);
        }
        if (custRequestItemSeqId != null) {
            builder.setCustRequestItemSeqId(custRequestItemSeqId);
        }
        if (quantity != null) {
            builder.setQuantity(getFixedPoint(quantity));
        }
        if (selectedAmount != null) {
            builder.setSelectedAmount(getFixedPoint(selectedAmount));
        }
        if (quoteUnitPrice != null) {
            builder.setQuoteUnitPrice(getCurrency(quoteUnitPrice));
        }
        if (reservStart != null) {
            builder.setReservStart(getTimestamp(reservStart));
        }
        if (reservLength != null) {
            builder.setReservLength(getFixedPoint(reservLength));
        }
        if (reservPersons != null) {
            builder.setReservPersons(getFixedPoint(reservPersons));
        }
        if (configId != null) {
            builder.setConfigId(configId);
        }
        if (estimatedDeliveryDate != null) {
            builder.setEstimatedDeliveryDate(getTimestamp(estimatedDeliveryDate));
        }
        if (comments != null) {
            builder.setComments(comments);
        }
        if (isPromo != null) {
            builder.setIsPromo(getIndicator(isPromo));
        }
        if (leadTimeDays != null) {
            builder.setLeadTimeDays(leadTimeDays);
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

    public static QuoteItem fromData(QuoteItemData data) {
        return QuoteItem.builder()
                .quoteId(data.getQuoteId())
                .quoteItemSeqId(data.getQuoteItemSeqId())
                .productId(data.getProductId())
                .productFeatureId(data.getProductFeatureId())
                .deliverableTypeId(data.getDeliverableTypeId())
                .skillTypeId(data.getSkillTypeId())
                .uomId(data.getUomId())
                .workEffortId(data.getWorkEffortId())
                .custRequestId(data.getCustRequestId())
                .custRequestItemSeqId(data.getCustRequestItemSeqId())
                .quantity(getBigDecimal(data.getQuantity()))
                .selectedAmount(getBigDecimal(data.getSelectedAmount()))
                .quoteUnitPrice(getBigDecimal(data.getQuoteUnitPrice()))
                .reservStart(getLocalDateTime(data.getReservStart()))
                .reservLength(getBigDecimal(data.getReservLength()))
                .reservPersons(getBigDecimal(data.getReservPersons()))
                .configId(data.getConfigId())
                .estimatedDeliveryDate(getLocalDateTime(data.getEstimatedDeliveryDate()))
                .comments(data.getComments())
                .isPromo(getIndicatorChar(data.getIsPromo()))
                .leadTimeDays(data.getLeadTimeDays())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}

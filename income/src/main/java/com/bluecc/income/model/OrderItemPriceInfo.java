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
import com.bluecc.hubs.stub.OrderItemPriceInfoData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemPriceInfo implements IEventModel<OrderItemPriceInfoData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String orderItemPriceInfoId;
    String orderId;
    String orderItemSeqId;
    String productPriceRuleId;
    String productPriceActionSeqId;
    java.math.BigDecimal modifyAmount;
    String description;
    String rateCode;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public OrderItemPriceInfoData.Builder toDataBuilder() {
        OrderItemPriceInfoData.Builder builder = OrderItemPriceInfoData.newBuilder();
        if (orderItemPriceInfoId != null) {
            builder.setOrderItemPriceInfoId(orderItemPriceInfoId);
        }
        if (orderId != null) {
            builder.setOrderId(orderId);
        }
        if (orderItemSeqId != null) {
            builder.setOrderItemSeqId(orderItemSeqId);
        }
        if (productPriceRuleId != null) {
            builder.setProductPriceRuleId(productPriceRuleId);
        }
        if (productPriceActionSeqId != null) {
            builder.setProductPriceActionSeqId(productPriceActionSeqId);
        }
        if (modifyAmount != null) {
            builder.setModifyAmount(getCurrency(modifyAmount));
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (rateCode != null) {
            builder.setRateCode(rateCode);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static OrderItemPriceInfo fromData(OrderItemPriceInfoData data) {
        return OrderItemPriceInfo.builder()
                .orderItemPriceInfoId(data.getOrderItemPriceInfoId())
                .orderId(data.getOrderId())
                .orderItemSeqId(data.getOrderItemSeqId())
                .productPriceRuleId(data.getProductPriceRuleId())
                .productPriceActionSeqId(data.getProductPriceActionSeqId())
                .modifyAmount(getBigDecimal(data.getModifyAmount()))
                .description(data.getDescription())
                .rateCode(data.getRateCode())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}
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
import com.bluecc.hubs.stub.ProductContentData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductContent implements IEventModel<ProductContentData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String productId;
    String contentId;
    String productContentTypeId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    java.time.LocalDateTime purchaseFromDate;
    java.time.LocalDateTime purchaseThruDate;
    Long useCountLimit;
    Long useTime;
    String useTimeUomId;
    String useRoleTypeId;
    Long sequenceNum;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductContentData.Builder toDataBuilder() {
        ProductContentData.Builder builder = ProductContentData.newBuilder();
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (contentId != null) {
            builder.setContentId(contentId);
        }
        if (productContentTypeId != null) {
            builder.setProductContentTypeId(productContentTypeId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (purchaseFromDate != null) {
            builder.setPurchaseFromDate(getTimestamp(purchaseFromDate));
        }
        if (purchaseThruDate != null) {
            builder.setPurchaseThruDate(getTimestamp(purchaseThruDate));
        }
        if (useCountLimit != null) {
            builder.setUseCountLimit(useCountLimit);
        }
        if (useTime != null) {
            builder.setUseTime(useTime);
        }
        if (useTimeUomId != null) {
            builder.setUseTimeUomId(useTimeUomId);
        }
        if (useRoleTypeId != null) {
            builder.setUseRoleTypeId(useRoleTypeId);
        }
        if (sequenceNum != null) {
            builder.setSequenceNum(sequenceNum);
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

    public static ProductContent fromData(ProductContentData data) {
        return ProductContent.builder()
                .productId(data.getProductId())
                .contentId(data.getContentId())
                .productContentTypeId(data.getProductContentTypeId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .purchaseFromDate(getLocalDateTime(data.getPurchaseFromDate()))
                .purchaseThruDate(getLocalDateTime(data.getPurchaseThruDate()))
                .useCountLimit(data.getUseCountLimit())
                .useTime(data.getUseTime())
                .useTimeUomId(data.getUseTimeUomId())
                .useRoleTypeId(data.getUseRoleTypeId())
                .sequenceNum(data.getSequenceNum())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}

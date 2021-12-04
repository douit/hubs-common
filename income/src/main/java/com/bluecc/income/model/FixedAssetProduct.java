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
import com.bluecc.hubs.stub.FixedAssetProductData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FixedAssetProduct implements IEventModel<FixedAssetProductData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String fixedAssetId;
    String productId;
    String fixedAssetProductTypeId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    String comments;
    Long sequenceNum;
    java.math.BigDecimal quantity;
    String quantityUomId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public FixedAssetProductData.Builder toDataBuilder() {
        FixedAssetProductData.Builder builder = FixedAssetProductData.newBuilder();
        if (fixedAssetId != null) {
            builder.setFixedAssetId(fixedAssetId);
        }
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (fixedAssetProductTypeId != null) {
            builder.setFixedAssetProductTypeId(fixedAssetProductTypeId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (comments != null) {
            builder.setComments(comments);
        }
        if (sequenceNum != null) {
            builder.setSequenceNum(sequenceNum);
        }
        if (quantity != null) {
            builder.setQuantity(getFixedPoint(quantity));
        }
        if (quantityUomId != null) {
            builder.setQuantityUomId(quantityUomId);
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

    public static FixedAssetProduct fromData(FixedAssetProductData data) {
        return FixedAssetProduct.builder()
                .fixedAssetId(data.getFixedAssetId())
                .productId(data.getProductId())
                .fixedAssetProductTypeId(data.getFixedAssetProductTypeId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .comments(data.getComments())
                .sequenceNum(data.getSequenceNum())
                .quantity(getBigDecimal(data.getQuantity()))
                .quantityUomId(data.getQuantityUomId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
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
import com.bluecc.hubs.stub.ProductStorePromoApplData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductStorePromoAppl implements IEventModel<ProductStorePromoApplData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String productStoreId;
    String productPromoId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    Long sequenceNum;
    Character manualOnly;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductStorePromoApplData.Builder toDataBuilder() {
        ProductStorePromoApplData.Builder builder = ProductStorePromoApplData.newBuilder();
        if (productStoreId != null) {
            builder.setProductStoreId(productStoreId);
        }
        if (productPromoId != null) {
            builder.setProductPromoId(productPromoId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (sequenceNum != null) {
            builder.setSequenceNum(sequenceNum);
        }
        if (manualOnly != null) {
            builder.setManualOnly(getIndicator(manualOnly));
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

    public static ProductStorePromoAppl fromData(ProductStorePromoApplData data) {
        return ProductStorePromoAppl.builder()
                .productStoreId(data.getProductStoreId())
                .productPromoId(data.getProductPromoId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .sequenceNum(data.getSequenceNum())
                .manualOnly(getIndicatorChar(data.getManualOnly()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}

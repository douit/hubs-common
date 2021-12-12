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

import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;

import com.bluecc.hubs.stub.ProductFeatureCategoryApplData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductFeatureCategoryApplData.class,
        symbol = EntityNames.ProductFeatureCategoryAppl)
public class ProductFeatureCategoryAppl implements IEventModel<ProductFeatureCategoryApplData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String productCategoryId;
    @RIndex String productFeatureCategoryId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductFeatureCategoryApplData.Builder toDataBuilder() {
        ProductFeatureCategoryApplData.Builder builder = ProductFeatureCategoryApplData.newBuilder();
        if (productCategoryId != null) {
            builder.setProductCategoryId(productCategoryId);
        }
        if (productFeatureCategoryId != null) {
            builder.setProductFeatureCategoryId(productFeatureCategoryId);
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
        if (id != null) {
            builder.setId(id);
        }
                    
        return builder;
    }

    public static ProductFeatureCategoryAppl fromData(ProductFeatureCategoryApplData data) {
        return ProductFeatureCategoryAppl.builder()
                .productCategoryId(data.getProductCategoryId())
                .productFeatureCategoryId(data.getProductFeatureCategoryId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}

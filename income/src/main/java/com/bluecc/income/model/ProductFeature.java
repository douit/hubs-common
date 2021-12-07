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

import com.bluecc.hubs.stub.ProductFeatureData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class ProductFeature implements IEventModel<ProductFeatureData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String productFeatureId;
    String productFeatureTypeId;
    String productFeatureCategoryId;
    String description;
    String uomId;
    java.math.BigDecimal numberSpecified;
    java.math.BigDecimal defaultAmount;
    Long defaultSequenceNum;
    String abbrev;
    String idCode;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductFeatureData.Builder toDataBuilder() {
        ProductFeatureData.Builder builder = ProductFeatureData.newBuilder();
        if (productFeatureId != null) {
            builder.setProductFeatureId(productFeatureId);
        }
        if (productFeatureTypeId != null) {
            builder.setProductFeatureTypeId(productFeatureTypeId);
        }
        if (productFeatureCategoryId != null) {
            builder.setProductFeatureCategoryId(productFeatureCategoryId);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (uomId != null) {
            builder.setUomId(uomId);
        }
        if (numberSpecified != null) {
            builder.setNumberSpecified(getFixedPoint(numberSpecified));
        }
        if (defaultAmount != null) {
            builder.setDefaultAmount(getCurrency(defaultAmount));
        }
        if (defaultSequenceNum != null) {
            builder.setDefaultSequenceNum(defaultSequenceNum);
        }
        if (abbrev != null) {
            builder.setAbbrev(abbrev);
        }
        if (idCode != null) {
            builder.setIdCode(idCode);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static ProductFeature fromData(ProductFeatureData data) {
        return ProductFeature.builder()
                .productFeatureId(data.getProductFeatureId())
                .productFeatureTypeId(data.getProductFeatureTypeId())
                .productFeatureCategoryId(data.getProductFeatureCategoryId())
                .description(data.getDescription())
                .uomId(data.getUomId())
                .numberSpecified(getBigDecimal(data.getNumberSpecified()))
                .defaultAmount(getBigDecimal(data.getDefaultAmount()))
                .defaultSequenceNum(data.getDefaultSequenceNum())
                .abbrev(data.getAbbrev())
                .idCode(data.getIdCode())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}

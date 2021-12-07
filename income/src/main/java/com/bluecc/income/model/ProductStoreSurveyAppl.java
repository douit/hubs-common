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

import com.bluecc.hubs.stub.ProductStoreSurveyApplData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class ProductStoreSurveyAppl implements IEventModel<ProductStoreSurveyApplData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String productStoreSurveyId;
    String productStoreId;
    String surveyApplTypeId;
    String groupName;
    String surveyId;
    String productId;
    String productCategoryId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    String surveyTemplate;
    String resultTemplate;
    Long sequenceNum;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductStoreSurveyApplData.Builder toDataBuilder() {
        ProductStoreSurveyApplData.Builder builder = ProductStoreSurveyApplData.newBuilder();
        if (productStoreSurveyId != null) {
            builder.setProductStoreSurveyId(productStoreSurveyId);
        }
        if (productStoreId != null) {
            builder.setProductStoreId(productStoreId);
        }
        if (surveyApplTypeId != null) {
            builder.setSurveyApplTypeId(surveyApplTypeId);
        }
        if (groupName != null) {
            builder.setGroupName(groupName);
        }
        if (surveyId != null) {
            builder.setSurveyId(surveyId);
        }
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (productCategoryId != null) {
            builder.setProductCategoryId(productCategoryId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (surveyTemplate != null) {
            builder.setSurveyTemplate(surveyTemplate);
        }
        if (resultTemplate != null) {
            builder.setResultTemplate(resultTemplate);
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
                    
        return builder;
    }

    public static ProductStoreSurveyAppl fromData(ProductStoreSurveyApplData data) {
        return ProductStoreSurveyAppl.builder()
                .productStoreSurveyId(data.getProductStoreSurveyId())
                .productStoreId(data.getProductStoreId())
                .surveyApplTypeId(data.getSurveyApplTypeId())
                .groupName(data.getGroupName())
                .surveyId(data.getSurveyId())
                .productId(data.getProductId())
                .productCategoryId(data.getProductCategoryId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .surveyTemplate(data.getSurveyTemplate())
                .resultTemplate(data.getResultTemplate())
                .sequenceNum(data.getSequenceNum())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}

//// Generated, DO NOT EDIT
package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;
// import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.gson.annotations.SerializedName;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;
import static com.bluecc.hubs.fund.FnUtil.getter;

import com.bluecc.hubs.stub.ProductStoreSurveyApplData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductStoreSurveyApplData.class,
        symbol = EntityNames.ProductStoreSurveyAppl)
public class ProductStoreSurveyAppl implements IEventModel<ProductStoreSurveyApplData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_store_survey_id")
	@RId 
    String productStoreSurveyId;
    @SerializedName("product_store_id") 
    String productStoreId;
    @SerializedName("survey_appl_type_id") 
    String surveyApplTypeId;
    @SerializedName("group_name") 
    String groupName;
    @SerializedName("survey_id") 
    String surveyId;
    @SerializedName("product_id") 
    String productId;
    @SerializedName("product_category_id") 
    String productCategoryId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("survey_template") 
    String surveyTemplate;
    @SerializedName("result_template") 
    String resultTemplate;
    @SerializedName("sequence_num") 
    Long sequenceNum;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    
    @Override
    public String getId(){
        return productStoreSurveyId;
    }

        
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


/*
-- keys: productStoreSurveyId

-- fields --
    
    String productStoreSurveyId
    String productStoreId
    String surveyApplTypeId
    String groupName
    String surveyId
    String productId
    String productCategoryId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    String surveyTemplate
    String resultTemplate
    Long sequenceNum

-- relations --
    
    - ProductStore (one, autoRelation: false, keymaps: productStoreId)
    - Survey (one, autoRelation: false, keymaps: surveyId)
    - SurveyApplType (one, autoRelation: false, keymaps: surveyApplTypeId)
    - Product (one-nofk, autoRelation: false, keymaps: productId)
    - ProductCategory (one-nofk, autoRelation: false, keymaps: productCategoryId)
    + WorkEffortSurveyAppl (many, autoRelation: true, keymaps: productStoreSurveyId -> surveyId)
*/


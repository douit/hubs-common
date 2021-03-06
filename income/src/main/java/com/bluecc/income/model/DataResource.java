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

import com.bluecc.hubs.stub.DataResourceData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = DataResourceData.class,
        symbol = EntityNames.DataResource)
public class DataResource implements IEventModel<DataResourceData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("data_resource_id")
	@RId 
    String dataResourceId;
    @SerializedName("data_resource_type_id") 
    String dataResourceTypeId;
    @SerializedName("data_template_type_id") 
    String dataTemplateTypeId;
    @SerializedName("data_category_id") 
    String dataCategoryId;
    @SerializedName("data_source_id") 
    String dataSourceId;
    @SerializedName("status_id") 
    String statusId;
    @SerializedName("data_resource_name") 
    String dataResourceName;
    @SerializedName("locale_string") 
    String localeString;
    @SerializedName("mime_type_id") 
    String mimeTypeId;
    @SerializedName("character_set_id") 
    String characterSetId;
    @SerializedName("object_info") 
    String objectInfo;
    @SerializedName("survey_id") 
    String surveyId;
    @SerializedName("survey_response_id") 
    String surveyResponseId;
    @SerializedName("related_detail_id") 
    String relatedDetailId;
    @SerializedName("is_public") 
    Character isPublic;
    @SerializedName("created_date") 
    java.time.LocalDateTime createdDate;
    @SerializedName("created_by_user_login_id") 
    String createdByUserLogin;
    @SerializedName("last_modified_date") 
    java.time.LocalDateTime lastModifiedDate;
    @SerializedName("last_modified_by_user_login_id") 
    String lastModifiedByUserLogin;
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
        return dataResourceId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public DataResourceData.Builder toDataBuilder() {
        DataResourceData.Builder builder = DataResourceData.newBuilder();
        if (getDataResourceId() != null) {
            builder.setDataResourceId(getDataResourceId());
        }
        if (getDataResourceTypeId() != null) {
            builder.setDataResourceTypeId(getDataResourceTypeId());
        }
        if (getDataTemplateTypeId() != null) {
            builder.setDataTemplateTypeId(getDataTemplateTypeId());
        }
        if (getDataCategoryId() != null) {
            builder.setDataCategoryId(getDataCategoryId());
        }
        if (getDataSourceId() != null) {
            builder.setDataSourceId(getDataSourceId());
        }
        if (getStatusId() != null) {
            builder.setStatusId(getStatusId());
        }
        if (getDataResourceName() != null) {
            builder.setDataResourceName(getDataResourceName());
        }
        if (getLocaleString() != null) {
            builder.setLocaleString(getLocaleString());
        }
        if (getMimeTypeId() != null) {
            builder.setMimeTypeId(getMimeTypeId());
        }
        if (getCharacterSetId() != null) {
            builder.setCharacterSetId(getCharacterSetId());
        }
        if (getObjectInfo() != null) {
            builder.setObjectInfo(getObjectInfo());
        }
        if (getSurveyId() != null) {
            builder.setSurveyId(getSurveyId());
        }
        if (getSurveyResponseId() != null) {
            builder.setSurveyResponseId(getSurveyResponseId());
        }
        if (getRelatedDetailId() != null) {
            builder.setRelatedDetailId(getRelatedDetailId());
        }
        if (getIsPublic() != null) {
            builder.setIsPublic(getIndicator(getIsPublic()));
        }
        if (getCreatedDate() != null) {
            builder.setCreatedDate(getTimestamp(getCreatedDate()));
        }
        if (getCreatedByUserLogin() != null) {
            builder.setCreatedByUserLogin(getCreatedByUserLogin());
        }
        if (getLastModifiedDate() != null) {
            builder.setLastModifiedDate(getTimestamp(getLastModifiedDate()));
        }
        if (getLastModifiedByUserLogin() != null) {
            builder.setLastModifiedByUserLogin(getLastModifiedByUserLogin());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static DataResource fromData(DataResourceData data) {
        return fromPrototype(data).build();
    }

    public static DataResource.DataResourceBuilder fromPrototype(DataResourceData data) {
        return DataResource.builder()
                .dataResourceId(data.getDataResourceId())
                .dataResourceTypeId(data.getDataResourceTypeId())
                .dataTemplateTypeId(data.getDataTemplateTypeId())
                .dataCategoryId(data.getDataCategoryId())
                .dataSourceId(data.getDataSourceId())
                .statusId(data.getStatusId())
                .dataResourceName(data.getDataResourceName())
                .localeString(data.getLocaleString())
                .mimeTypeId(data.getMimeTypeId())
                .characterSetId(data.getCharacterSetId())
                .objectInfo(data.getObjectInfo())
                .surveyId(data.getSurveyId())
                .surveyResponseId(data.getSurveyResponseId())
                .relatedDetailId(data.getRelatedDetailId())
                .isPublic(getIndicatorChar(data.getIsPublic()))
                .createdDate(getLocalDateTime(data.getCreatedDate()))
                .createdByUserLogin(data.getCreatedByUserLogin())
                .lastModifiedDate(getLocalDateTime(data.getLastModifiedDate()))
                .lastModifiedByUserLogin(data.getLastModifiedByUserLogin())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
    }

    
}


/*
-- keys: dataResourceId

-- fields --
    
    String dataResourceId
    String dataResourceTypeId
    String dataTemplateTypeId
    String dataCategoryId
    String dataSourceId
    String statusId
    String dataResourceName
    String localeString
    String mimeTypeId
    String characterSetId
    String objectInfo
    String surveyId
    String surveyResponseId
    String relatedDetailId
    Character isPublic
    java.time.LocalDateTime createdDate
    String createdByUserLogin
    java.time.LocalDateTime lastModifiedDate
    String lastModifiedByUserLogin

-- relations --
    
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    - DataResourceType (one, autoRelation: false, keymaps: dataResourceTypeId)
    - DataTemplateType (one, autoRelation: false, keymaps: dataTemplateTypeId)
    - DataCategory (one, autoRelation: false, keymaps: dataCategoryId)
    - DataSource (one, autoRelation: false, keymaps: dataSourceId)
    - MimeType (one-nofk, autoRelation: false, keymaps: mimeTypeId)
    - CharacterSet (one, autoRelation: false, keymaps: characterSetId)
    + DataResourceTypeAttr (many, autoRelation: false, keymaps: dataResourceTypeId)
    - CreatedByUserLogin (one, autoRelation: false, keymaps: createdByUserLogin -> userLoginId)
    - LastModifiedByUserLogin (one, autoRelation: false, keymaps: lastModifiedByUserLogin -> userLoginId)
    - Survey (one, autoRelation: false, keymaps: surveyId)
    - SurveyResponse (one, autoRelation: false, keymaps: surveyResponseId)
    - AudioDataResource (one-nofk, autoRelation: true, keymaps: dataResourceId)
    + Content (many, autoRelation: true, keymaps: dataResourceId)
    + TemplateContent (many, autoRelation: true, keymaps: dataResourceId -> templateDataResourceId)
    + OldContentRevisionItem (many, autoRelation: true, keymaps: dataResourceId -> oldDataResourceId)
    + NewContentRevisionItem (many, autoRelation: true, keymaps: dataResourceId -> newDataResourceId)
    + DataResourceAttribute (many, autoRelation: true, keymaps: dataResourceId)
    + DataResourceMetaData (many, autoRelation: true, keymaps: dataResourceId)
    + DataResourcePurpose (many, autoRelation: true, keymaps: dataResourceId)
    + DataResourceRole (many, autoRelation: true, keymaps: dataResourceId)
    - ElectronicText (one-nofk, autoRelation: true, keymaps: dataResourceId)
    - ImageDataResource (one-nofk, autoRelation: true, keymaps: dataResourceId)
    - OtherDataResource (one-nofk, autoRelation: true, keymaps: dataResourceId)
    + ProductFeatureDataResource (many, autoRelation: true, keymaps: dataResourceId)
    - VideoDataResource (one-nofk, autoRelation: true, keymaps: dataResourceId)
*/


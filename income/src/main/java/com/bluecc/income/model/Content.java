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

import com.bluecc.hubs.stub.ContentData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ContentData.class,
        symbol = EntityNames.Content)
public class Content implements IEventModel<ContentData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("content_id")
	@RId 
    String contentId;
    @SerializedName("content_type_id") 
    String contentTypeId;
    @SerializedName("owner_content_id") 
    String ownerContentId;
    @SerializedName("decorator_content_id") 
    String decoratorContentId;
    @SerializedName("instance_of_content_id") 
    String instanceOfContentId;
    @SerializedName("data_resource_id") 
    String dataResourceId;
    @SerializedName("template_data_resource_id") 
    String templateDataResourceId;
    @SerializedName("data_source_id") 
    String dataSourceId;
    @SerializedName("status_id") 
    String statusId;
    @SerializedName("privilege_enum_id") 
    String privilegeEnumId;
    @SerializedName("service_name") 
    String serviceName;
    @SerializedName("custom_method_id") 
    String customMethodId;
    @SerializedName("content_name") 
    String contentName;
    @SerializedName("description") 
    String description;
    @SerializedName("locale_string") 
    String localeString;
    @SerializedName("mime_type_id") 
    String mimeTypeId;
    @SerializedName("character_set_id") 
    String characterSetId;
    @SerializedName("child_leaf_count") 
    Long childLeafCount;
    @SerializedName("child_branch_count") 
    Long childBranchCount;
    @SerializedName("created_date") 
    java.time.LocalDateTime createdDate;
    @SerializedName("created_by_user_login") 
    String createdByUserLogin;
    @SerializedName("last_modified_date") 
    java.time.LocalDateTime lastModifiedDate;
    @SerializedName("last_modified_by_user_login") 
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
        return contentId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ContentData.Builder toDataBuilder() {
        ContentData.Builder builder = ContentData.newBuilder();
        if (contentId != null) {
            builder.setContentId(contentId);
        }
        if (contentTypeId != null) {
            builder.setContentTypeId(contentTypeId);
        }
        if (ownerContentId != null) {
            builder.setOwnerContentId(ownerContentId);
        }
        if (decoratorContentId != null) {
            builder.setDecoratorContentId(decoratorContentId);
        }
        if (instanceOfContentId != null) {
            builder.setInstanceOfContentId(instanceOfContentId);
        }
        if (dataResourceId != null) {
            builder.setDataResourceId(dataResourceId);
        }
        if (templateDataResourceId != null) {
            builder.setTemplateDataResourceId(templateDataResourceId);
        }
        if (dataSourceId != null) {
            builder.setDataSourceId(dataSourceId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (privilegeEnumId != null) {
            builder.setPrivilegeEnumId(privilegeEnumId);
        }
        if (serviceName != null) {
            builder.setServiceName(serviceName);
        }
        if (customMethodId != null) {
            builder.setCustomMethodId(customMethodId);
        }
        if (contentName != null) {
            builder.setContentName(contentName);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (localeString != null) {
            builder.setLocaleString(localeString);
        }
        if (mimeTypeId != null) {
            builder.setMimeTypeId(mimeTypeId);
        }
        if (characterSetId != null) {
            builder.setCharacterSetId(characterSetId);
        }
        if (childLeafCount != null) {
            builder.setChildLeafCount(childLeafCount);
        }
        if (childBranchCount != null) {
            builder.setChildBranchCount(childBranchCount);
        }
        if (createdDate != null) {
            builder.setCreatedDate(getTimestamp(createdDate));
        }
        if (createdByUserLogin != null) {
            builder.setCreatedByUserLogin(createdByUserLogin);
        }
        if (lastModifiedDate != null) {
            builder.setLastModifiedDate(getTimestamp(lastModifiedDate));
        }
        if (lastModifiedByUserLogin != null) {
            builder.setLastModifiedByUserLogin(lastModifiedByUserLogin);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static Content fromData(ContentData data) {
        return Content.builder()
                .contentId(data.getContentId())
                .contentTypeId(data.getContentTypeId())
                .ownerContentId(data.getOwnerContentId())
                .decoratorContentId(data.getDecoratorContentId())
                .instanceOfContentId(data.getInstanceOfContentId())
                .dataResourceId(data.getDataResourceId())
                .templateDataResourceId(data.getTemplateDataResourceId())
                .dataSourceId(data.getDataSourceId())
                .statusId(data.getStatusId())
                .privilegeEnumId(data.getPrivilegeEnumId())
                .serviceName(data.getServiceName())
                .customMethodId(data.getCustomMethodId())
                .contentName(data.getContentName())
                .description(data.getDescription())
                .localeString(data.getLocaleString())
                .mimeTypeId(data.getMimeTypeId())
                .characterSetId(data.getCharacterSetId())
                .childLeafCount(data.getChildLeafCount())
                .childBranchCount(data.getChildBranchCount())
                .createdDate(getLocalDateTime(data.getCreatedDate()))
                .createdByUserLogin(data.getCreatedByUserLogin())
                .lastModifiedDate(getLocalDateTime(data.getLastModifiedDate()))
                .lastModifiedByUserLogin(data.getLastModifiedByUserLogin())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: contentId

-- fields --
    
    String contentId
    String contentTypeId
    String ownerContentId
    String decoratorContentId
    String instanceOfContentId
    String dataResourceId
    String templateDataResourceId
    String dataSourceId
    String statusId
    String privilegeEnumId
    String serviceName
    String customMethodId
    String contentName
    String description
    String localeString
    String mimeTypeId
    String characterSetId
    Long childLeafCount
    Long childBranchCount
    java.time.LocalDateTime createdDate
    String createdByUserLogin
    java.time.LocalDateTime lastModifiedDate
    String lastModifiedByUserLogin

-- relations --
    
    - ContentType (one, autoRelation: false, keymaps: contentTypeId)
    - DataResource (one, autoRelation: false, keymaps: dataResourceId)
    - TemplateDataResource (one, autoRelation: false, keymaps: templateDataResourceId -> dataResourceId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    - PrivilegeEnumeration (one, autoRelation: false, keymaps: privilegeEnumId -> enumId)
    - CustomMethod (one, autoRelation: false, keymaps: customMethodId)
    - MimeType (one-nofk, autoRelation: false, keymaps: mimeTypeId)
    - CharacterSet (one, autoRelation: false, keymaps: characterSetId)
    + ContentTypeAttr (many, autoRelation: false, keymaps: contentTypeId)
    - CreatedByUserLogin (one, autoRelation: false, keymaps: createdByUserLogin -> userLoginId)
    - LastModifiedByUserLogin (one, autoRelation: false, keymaps: lastModifiedByUserLogin -> userLoginId)
    + ProductFeatureDataResource (many, autoRelation: false, keymaps: dataResourceId)
    - DataSource (one, autoRelation: false, keymaps: dataSourceId)
    - DecoratorContent (one, autoRelation: false, keymaps: decoratorContentId -> contentId)
    - OwnerContent (one, autoRelation: false, keymaps: ownerContentId -> contentId)
    - InstanceOfContent (one, autoRelation: false, keymaps: instanceOfContentId -> contentId)
    + ContentAssocDataResourceViewFrom (many, autoRelation: false, keymaps: contentId -> contentIdStart)
    + ContentAssocDataResourceViewTo (many, autoRelation: false, keymaps: contentId -> contentIdStart)
    + AgreementContent (many, autoRelation: true, keymaps: contentId)
    + FromCommEventContentAssoc (many, autoRelation: true, keymaps: contentId)
    + ContentApproval (many, autoRelation: true, keymaps: contentId)
    + FromContentAssoc (many, autoRelation: true, keymaps: contentId)
    + ToContentAssoc (many, autoRelation: true, keymaps: contentId -> contentIdTo)
    + ContentAttribute (many, autoRelation: true, keymaps: contentId)
    + ContentKeyword (many, autoRelation: true, keymaps: contentId)
    + ContentMetaData (many, autoRelation: true, keymaps: contentId)
    + ContentPurpose (many, autoRelation: true, keymaps: contentId)
    + ContentRevision (many, autoRelation: true, keymaps: contentId)
    + ContentRole (many, autoRelation: true, keymaps: contentId)
    + CustRequestContent (many, autoRelation: true, keymaps: contentId)
    + FacilityContent (many, autoRelation: true, keymaps: contentId)
    + InvoiceContent (many, autoRelation: true, keymaps: contentId)
    + OrderContent (many, autoRelation: true, keymaps: contentId)
    + PartyContent (many, autoRelation: true, keymaps: contentId)
    + PartyResume (many, autoRelation: true, keymaps: contentId)
    + PaymentContent (many, autoRelation: true, keymaps: contentId)
    + PortalPage (many, autoRelation: true, keymaps: contentId -> helpContentId)
    + ProdConfItemContent (many, autoRelation: true, keymaps: contentId)
    + ProductCategoryContent (many, autoRelation: true, keymaps: contentId)
    + ProductContent (many, autoRelation: true, keymaps: contentId)
    + ProductPromoContent (many, autoRelation: true, keymaps: contentId)
    + SubscriptionResource (many, autoRelation: true, keymaps: contentId)
    + SurveyResponseAnswer (many, autoRelation: true, keymaps: contentId)
    + WebPage (many, autoRelation: true, keymaps: contentId)
    + WebSiteContent (many, autoRelation: true, keymaps: contentId)
    + WebSitePathAlias (many, autoRelation: true, keymaps: contentId)
    - WebSitePublishPoint (one-nofk, autoRelation: true, keymaps: contentId)
    + WorkEffortContent (many, autoRelation: true, keymaps: contentId)
*/


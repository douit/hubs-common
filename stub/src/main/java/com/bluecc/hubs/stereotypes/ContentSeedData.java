package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.ContentAssocTypeData;
import com.bluecc.hubs.stub.ContentPurposeOperationData;
import com.bluecc.hubs.stub.DataCategoryData;
import com.bluecc.hubs.stub.ContentTypeData;
import com.bluecc.hubs.stub.ElectronicTextData;
import com.bluecc.hubs.stub.RoleTypeData;
import com.bluecc.hubs.stub.MetaDataPredicateData;
import com.bluecc.hubs.stub.MimeTypeData;
import com.bluecc.hubs.stub.WebSiteContentTypeData;
import com.bluecc.hubs.stub.WebAnalyticsTypeData;
import com.bluecc.hubs.stub.StatusItemData;
import com.bluecc.hubs.stub.StatusValidChangeData;
import com.bluecc.hubs.stub.SubscriptionTypeData;
import com.bluecc.hubs.stub.ContentPurposeTypeData;
import com.bluecc.hubs.stub.FileExtensionData;
import com.bluecc.hubs.stub.SecurityGroupPermissionData;
import com.bluecc.hubs.stub.DataTemplateTypeData;
import com.bluecc.hubs.stub.CharacterSetData;
import com.bluecc.hubs.stub.ContentAssocPredicateData;
import com.bluecc.hubs.stub.SurveyApplTypeData;
import com.bluecc.hubs.stub.MimeTypeHtmlTemplateData;
import com.bluecc.hubs.stub.SecurityPermissionData;
import com.bluecc.hubs.stub.EnumerationData;
import com.bluecc.hubs.stub.SurveyQuestionTypeData;
import com.bluecc.hubs.stub.ContentOperationData;
import com.bluecc.hubs.stub.EnumerationTypeData;
import com.bluecc.hubs.stub.DocumentTypeData;
import com.bluecc.hubs.stub.DataResourceData;
import com.bluecc.hubs.stub.StatusTypeData;
import com.bluecc.hubs.stub.ContentData;
import com.bluecc.hubs.stub.DataResourceTypeData;

public final class ContentSeedData {
    public final static ContentAssocTypeData ContentAssocType_TEMPLATE_MEMBER = ContentAssocTypeData.newBuilder()
        .setContentAssocTypeId("TEMPLATE_MEMBER")
        .setDescription("Template Member")
        .build();


    public final static ContentAssocTypeData ContentAssocType_STRUCTURE_DEF = ContentAssocTypeData.newBuilder()
        .setContentAssocTypeId("STRUCTURE_DEF")
        .setDescription("Document Structure Definition")
        .build();


    public final static ContentAssocTypeData ContentAssocType_TXFORM_DEF = ContentAssocTypeData.newBuilder()
        .setContentAssocTypeId("TXFORM_DEF")
        .setDescription("Transformation Definition")
        .build();


    public final static ContentAssocTypeData ContentAssocType_LIST_ENTRY = ContentAssocTypeData.newBuilder()
        .setContentAssocTypeId("LIST_ENTRY")
        .setDescription("List Entry")
        .build();


    public final static ContentAssocTypeData ContentAssocType_TREE_CHILD = ContentAssocTypeData.newBuilder()
        .setContentAssocTypeId("TREE_CHILD")
        .setDescription("Tree Child")
        .build();


    public final static ContentAssocTypeData ContentAssocType_GRAPH_LINK = ContentAssocTypeData.newBuilder()
        .setContentAssocTypeId("GRAPH_LINK")
        .setDescription("Graph Link")
        .build();


    public final static ContentAssocTypeData ContentAssocType_ALTERNATE_LOCALE = ContentAssocTypeData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setDescription("Alternate Locale")
        .build();


    public final static ContentAssocTypeData ContentAssocType_ALTERNATE_ROLE = ContentAssocTypeData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_ROLE")
        .setDescription("Alternate Role")
        .build();


    public final static ContentAssocTypeData ContentAssocType_RESPONSE = ContentAssocTypeData.newBuilder()
        .setContentAssocTypeId("RESPONSE")
        .setDescription("Response")
        .build();


    public final static ContentAssocTypeData ContentAssocType_SUB_CONTENT = ContentAssocTypeData.newBuilder()
        .setContentAssocTypeId("SUB_CONTENT")
        .setDescription("Sub-Content")
        .build();


    public final static ContentAssocTypeData ContentAssocType_TOPIC = ContentAssocTypeData.newBuilder()
        .setContentAssocTypeId("TOPIC")
        .setDescription("Topic")
        .build();


    public final static ContentAssocTypeData ContentAssocType_DESCRIPTION = ContentAssocTypeData.newBuilder()
        .setContentAssocTypeId("DESCRIPTION")
        .setDescription("Description")
        .build();


    public final static ContentAssocTypeData ContentAssocType_SUBSITE = ContentAssocTypeData.newBuilder()
        .setContentAssocTypeId("SUBSITE")
        .setDescription("SubSite")
        .build();


    public final static ContentAssocTypeData ContentAssocType_DEPARTMENT = ContentAssocTypeData.newBuilder()
        .setContentAssocTypeId("DEPARTMENT")
        .setDescription("Department")
        .build();


    public final static ContentAssocTypeData ContentAssocType_RELATED_CONTENT = ContentAssocTypeData.newBuilder()
        .setContentAssocTypeId("RELATED_CONTENT")
        .setDescription("Related content")
        .build();


    public final static ContentAssocTypeData ContentAssocType_PUBLISH_LINK = ContentAssocTypeData.newBuilder()
        .setContentAssocTypeId("PUBLISH_LINK")
        .setDescription("Publish link")
        .build();


    public final static ContentAssocTypeData ContentAssocType_ATTRIBUTE = ContentAssocTypeData.newBuilder()
        .setContentAssocTypeId("ATTRIBUTE")
        .setDescription("Attribute")
        .build();


    public final static ContentAssocTypeData ContentAssocType_AUTHOR = ContentAssocTypeData.newBuilder()
        .setContentAssocTypeId("AUTHOR")
        .setDescription("Author")
        .build();


    public final static ContentAssocTypeData ContentAssocType_SUMMARY = ContentAssocTypeData.newBuilder()
        .setContentAssocTypeId("SUMMARY")
        .setDescription("Summary")
        .build();


    public final static ContentAssocTypeData ContentAssocType_INSTANCE = ContentAssocTypeData.newBuilder()
        .setContentAssocTypeId("INSTANCE")
        .setDescription("Instance Of")
        .build();


    public final static ContentAssocTypeData ContentAssocType_ALTERNATIVE_URL = ContentAssocTypeData.newBuilder()
        .setContentAssocTypeId("ALTERNATIVE_URL")
        .setDescription("Alternative URL")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_ARTICLE_CONTENT_CREATE_CONTENT_AUTHOR_CTNT_PUBLISHED_CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_CREATE")
        .setContentPurposeTypeId("ARTICLE")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_AUTHOR")
        .setStatusId("CTNT_PUBLISHED")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_ARTICLE_CONTENT_CREATE_CONTENT_AUTHOR__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_CREATE")
        .setContentPurposeTypeId("ARTICLE")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_AUTHOR")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_ARTICLE_CONTENT_CREATE_CONTENT_EDITOR__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_CREATE")
        .setContentPurposeTypeId("ARTICLE")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_EDITOR")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_ARTICLE_CONTENT_CREATE_SUB_OWNER__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_CREATE_SUB")
        .setContentPurposeTypeId("ARTICLE")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("OWNER")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_ARTICLE_CONTENT_UPDATE_CONTENT_AUTHOR__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_UPDATE")
        .setContentPurposeTypeId("ARTICLE")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_AUTHOR")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_ARTICLE_CONTENT_UPDATE_CONTENT_EDITOR__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_UPDATE")
        .setContentPurposeTypeId("ARTICLE")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_EDITOR")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_ARTICLE_CONTENT_UPDATE_OWNER_CTNT_INITIAL_DRAFT_CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_UPDATE")
        .setContentPurposeTypeId("ARTICLE")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("OWNER")
        .setStatusId("CTNT_INITIAL_DRAFT")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_ARTICLE_CONTENT_PUBLISH_CONTENT_EDITOR__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_PUBLISH")
        .setContentPurposeTypeId("ARTICLE")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_EDITOR")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_ARTICLE_CONTENT_PUBLISH_CONTENT_PUBLISHER_CTNT_PUBLISHED_CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_PUBLISH")
        .setContentPurposeTypeId("ARTICLE")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_PUBLISHER")
        .setStatusId("CTNT_PUBLISHED")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_ARTICLE_CONTENT_PUBLISH_OWNER__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_PUBLISH")
        .setContentPurposeTypeId("ARTICLE")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("OWNER")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_ARTICLE_CONTENT_PUBLISH_SELF_CONTENT_AUTHOR_CTNT_PUBLISHED_CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_PUBLISH_SELF")
        .setContentPurposeTypeId("ARTICLE")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_AUTHOR")
        .setStatusId("CTNT_PUBLISHED")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_ARTICLE_CONTENT_RESPOND_CONTENT_USER_CTNT_PUBLISHED_CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_RESPOND")
        .setContentPurposeTypeId("ARTICLE")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_USER")
        .setStatusId("CTNT_PUBLISHED")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_ARTICLE_CONTENT_VIEW_CONTENT_AUTHOR_CTNT_PUBLISHED_CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_VIEW")
        .setContentPurposeTypeId("ARTICLE")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_AUTHOR")
        .setStatusId("CTNT_PUBLISHED")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_ARTICLE_CONTENT_VIEW_CONTENT_EDITOR__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_VIEW")
        .setContentPurposeTypeId("ARTICLE")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_EDITOR")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_ARTICLE_CONTENT_VIEW_OWNER_CTNT_INITIAL_DRAFT_CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_VIEW")
        .setContentPurposeTypeId("ARTICLE")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("OWNER")
        .setStatusId("CTNT_INITIAL_DRAFT")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_ARTICLE_CONTENT_LINK_FROM__NA___NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_LINK_FROM")
        .setContentPurposeTypeId("ARTICLE")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("_NA_")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_ARTICLE_CONTENT_LINK_TO__NA___NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_LINK_TO")
        .setContentPurposeTypeId("ARTICLE")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("_NA_")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_RESPONSE_CONTENT_CREATE_CONTENT_EDITOR__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_CREATE")
        .setContentPurposeTypeId("RESPONSE")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_EDITOR")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_RESPONSE_CONTENT_UPDATE_CONTENT_EDITOR__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_UPDATE")
        .setContentPurposeTypeId("RESPONSE")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_EDITOR")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_RESPONSE_CONTENT_UPDATE_OWNER__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_UPDATE")
        .setContentPurposeTypeId("RESPONSE")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("OWNER")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_RESPONSE_CONTENT_PUBLISH_CONTENT_PUBLISHER_CTNT_PUBLISHED_CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_PUBLISH")
        .setContentPurposeTypeId("RESPONSE")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_PUBLISHER")
        .setStatusId("CTNT_PUBLISHED")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_RESPONSE_CONTENT_PUBLISH_CONTENT_USER_CTNT_PUBLISHED_CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_PUBLISH")
        .setContentPurposeTypeId("RESPONSE")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_USER")
        .setStatusId("CTNT_PUBLISHED")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_RESPONSE_CONTENT_RESPOND_CONTENT_USER_CTNT_PUBLISHED_CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_RESPOND")
        .setContentPurposeTypeId("RESPONSE")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_USER")
        .setStatusId("CTNT_PUBLISHED")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_RESPONSE_CONTENT_LINK_FROM__NA___NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_LINK_FROM")
        .setContentPurposeTypeId("RESPONSE")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("_NA_")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_RESPONSE_CONTENT_LINK_TO__NA___NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_LINK_TO")
        .setContentPurposeTypeId("RESPONSE")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("_NA_")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_SECTION_CONTENT_UPDATE_CONTENT_AUTHOR__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_UPDATE")
        .setContentPurposeTypeId("SECTION")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_AUTHOR")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_SECTION_CONTENT_UPDATE_CONTENT_EDITOR__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_UPDATE")
        .setContentPurposeTypeId("SECTION")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_EDITOR")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_SECTION_CONTENT_UPDATE_OWNER_CTNT_INITIAL_DRAFT_CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_UPDATE")
        .setContentPurposeTypeId("SECTION")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("OWNER")
        .setStatusId("CTNT_INITIAL_DRAFT")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_SECTION_CONTENT_PUBLISH_CONTENT_EDITOR__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_PUBLISH")
        .setContentPurposeTypeId("SECTION")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_EDITOR")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_SECTION_CONTENT_PUBLISH_CONTENT_PUBLISHER_CTNT_PUBLISHED_CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_PUBLISH")
        .setContentPurposeTypeId("SECTION")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_PUBLISHER")
        .setStatusId("CTNT_PUBLISHED")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_SECTION_CONTENT_PUBLISH_OWNER__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_PUBLISH")
        .setContentPurposeTypeId("SECTION")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("OWNER")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_SECTION_CONTENT_VIEW_CONTENT_AUTHOR__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_VIEW")
        .setContentPurposeTypeId("SECTION")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_AUTHOR")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_SECTION_CONTENT_VIEW_CONTENT_EDITOR__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_VIEW")
        .setContentPurposeTypeId("SECTION")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_EDITOR")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_SECTION_CONTENT_VIEW_OWNER__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_VIEW")
        .setContentPurposeTypeId("SECTION")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("OWNER")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_SECTION_CONTENT_VIEW__NA__CTNT_PUBLISHED_CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_VIEW")
        .setContentPurposeTypeId("SECTION")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("_NA_")
        .setStatusId("CTNT_PUBLISHED")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_USER_CONTENT_UPDATE_OWNER__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_UPDATE")
        .setContentPurposeTypeId("USER")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("OWNER")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation__NA__HAS_OWNER_ROLE_OWNER__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("HAS_OWNER_ROLE")
        .setContentPurposeTypeId("_NA_")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("OWNER")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation__NA__HAS_USER_ROLE_CONTENT_USER__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("HAS_USER_ROLE")
        .setContentPurposeTypeId("_NA_")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_USER")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation__NA__HAS_AUTHOR_ROLE_CONTENT_AUTHOR__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("HAS_AUTHOR_ROLE")
        .setContentPurposeTypeId("_NA_")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_AUTHOR")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation__NA__HAS_EDITOR_ROLE_CONTENT_EDITOR__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("HAS_EDITOR_ROLE")
        .setContentPurposeTypeId("_NA_")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_EDITOR")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation__NA__HAS_ADMIN_ROLE_CONTENT_ADMIN__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("HAS_ADMIN_ROLE")
        .setContentPurposeTypeId("_NA_")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_ADMIN")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation__NA__HAS_PUBLISHER_ROLE_CONTENT_PUBLISHER__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("HAS_PUBLISHER_ROLE")
        .setContentPurposeTypeId("_NA_")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_PUBLISHER")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation__NA__CONTENT_PUBLISH_CONTENT_PUBLISHER__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_PUBLISH")
        .setContentPurposeTypeId("_NA_")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_PUBLISHER")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation__NA__CONTENT_VIEW_CONTENT_ADMIN__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_VIEW")
        .setContentPurposeTypeId("_NA_")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_ADMIN")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation__NA__CONTENT_VIEW_CONTENT_USER_CTNT_PUBLISHED_CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_VIEW")
        .setContentPurposeTypeId("_NA_")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_USER")
        .setStatusId("CTNT_PUBLISHED")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation__NA__CONTENT_LINK_TO_OWNER__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_LINK_TO")
        .setContentPurposeTypeId("_NA_")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("OWNER")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation__NA__CONTENT_LINK_FROM_OWNER__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_LINK_FROM")
        .setContentPurposeTypeId("_NA_")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("OWNER")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation__NA__CONTENT_LINK_TO_CONTENT_ADMIN__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_LINK_TO")
        .setContentPurposeTypeId("_NA_")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_ADMIN")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation__NA__CONTENT_LINK_FROM_CONTENT_ADMIN__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_LINK_FROM")
        .setContentPurposeTypeId("_NA_")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_ADMIN")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation__NA___NA__CONTENT_ADMIN__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("_NA_")
        .setContentPurposeTypeId("_NA_")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_ADMIN")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation__NA__CONTENT_ADMIN_CONTENT_ADMIN__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_ADMIN")
        .setContentPurposeTypeId("_NA_")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_ADMIN")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation__NA__CONTENT_UPDATE_CONTENT_ADMIN__NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_UPDATE")
        .setContentPurposeTypeId("_NA_")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("CONTENT_ADMIN")
        .setStatusId("_NA_")
        .build();


    public final static ContentPurposeOperationData ContentPurposeOperation_RESPONSE_CONTENT_CREATE__NA___NA__CNT_PRV_NA_ = ContentPurposeOperationData.newBuilder()
        .setContentOperationId("CONTENT_CREATE")
        .setContentPurposeTypeId("RESPONSE")
        .setPrivilegeEnumId("CNT_PRV_NA_")
        .setRoleTypeId("_NA_")
        .setStatusId("_NA_")
        .build();


    public final static DataCategoryData DataCategory_ROOT = DataCategoryData.newBuilder()
        .setDataCategoryId("ROOT")
        .build();


    public final static DataCategoryData DataCategory_BUSINESS = DataCategoryData.newBuilder()
        .setCategoryName("Business")
        .setDataCategoryId("BUSINESS")
        .setParentCategoryId("ROOT")
        .build();


    public final static DataCategoryData DataCategory_TECHNOLOGY = DataCategoryData.newBuilder()
        .setCategoryName("Technology")
        .setDataCategoryId("TECHNOLOGY")
        .setParentCategoryId("ROOT")
        .build();


    public final static DataCategoryData DataCategory_PERSONAL = DataCategoryData.newBuilder()
        .setCategoryName("Personal")
        .setDataCategoryId("PERSONAL")
        .setParentCategoryId("ROOT")
        .build();


    public final static DataCategoryData DataCategory_LEGAL = DataCategoryData.newBuilder()
        .setCategoryName("Legal")
        .setDataCategoryId("LEGAL")
        .setParentCategoryId("ROOT")
        .build();


    public final static DataCategoryData DataCategory_POLITICAL = DataCategoryData.newBuilder()
        .setCategoryName("Political")
        .setDataCategoryId("POLITICAL")
        .setParentCategoryId("ROOT")
        .build();


    public final static DataCategoryData DataCategory_FINANCIAL = DataCategoryData.newBuilder()
        .setCategoryName("Financial")
        .setDataCategoryId("FINANCIAL")
        .setParentCategoryId("ROOT")
        .build();


    public final static DataCategoryData DataCategory_BUS_RETAIL = DataCategoryData.newBuilder()
        .setCategoryName("Retail")
        .setDataCategoryId("BUS_RETAIL")
        .setParentCategoryId("BUSINESS")
        .build();


    public final static DataCategoryData DataCategory_BUS_SERVICE = DataCategoryData.newBuilder()
        .setCategoryName("Service")
        .setDataCategoryId("BUS_SERVICE")
        .setParentCategoryId("BUSINESS")
        .build();


    public final static DataCategoryData DataCategory_BUS_MANU = DataCategoryData.newBuilder()
        .setCategoryName("Manufacturing")
        .setDataCategoryId("BUS_MANU")
        .setParentCategoryId("BUSINESS")
        .build();


    public final static DataCategoryData DataCategory_TECH_SOFT = DataCategoryData.newBuilder()
        .setCategoryName("Software")
        .setDataCategoryId("TECH_SOFT")
        .setParentCategoryId("TECHNOLOGY")
        .build();


    public final static DataCategoryData DataCategory_TECH_SOFT_OFBIZ = DataCategoryData.newBuilder()
        .setCategoryName("Apache OFBiz")
        .setDataCategoryId("TECH_SOFT_OFBIZ")
        .setParentCategoryId("TECH_SOFT")
        .build();


    public final static DataCategoryData DataCategory_TECH_SOFT_LINUX = DataCategoryData.newBuilder()
        .setCategoryName("Linux")
        .setDataCategoryId("TECH_SOFT_LINUX")
        .setParentCategoryId("TECH_SOFT")
        .build();


    public final static DataCategoryData DataCategory_TECH_SOFT_JAVA = DataCategoryData.newBuilder()
        .setCategoryName("Java")
        .setDataCategoryId("TECH_SOFT_JAVA")
        .setParentCategoryId("TECH_SOFT")
        .build();


    public final static DataCategoryData DataCategory_TECH_HARD = DataCategoryData.newBuilder()
        .setCategoryName("Hardware")
        .setDataCategoryId("TECH_HARD")
        .setParentCategoryId("TECHNOLOGY")
        .build();


    public final static DataCategoryData DataCategory_TECH_SERV = DataCategoryData.newBuilder()
        .setCategoryName("Service")
        .setDataCategoryId("TECH_SERV")
        .setParentCategoryId("TECHNOLOGY")
        .build();


    public final static DataCategoryData DataCategory_TEMPLATE = DataCategoryData.newBuilder()
        .setCategoryName("Template")
        .setDataCategoryId("TEMPLATE")
        .setParentCategoryId("ROOT")
        .build();


    public final static ContentTypeData ContentType_DOCUMENT = ContentTypeData.newBuilder()
        .setContentTypeId("DOCUMENT")
        .setDescription("Document")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContentTypeData ContentType_TEMPLATE = ContentTypeData.newBuilder()
        .setContentTypeId("TEMPLATE")
        .setDescription("Template or Form")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContentTypeData ContentType_DECORATOR = ContentTypeData.newBuilder()
        .setContentTypeId("DECORATOR")
        .setDescription("Decorator")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("TEMPLATE")
        .build();


    public final static ContentTypeData ContentType_ANNOTATION = ContentTypeData.newBuilder()
        .setContentTypeId("ANNOTATION")
        .setDescription("Annotation")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContentTypeData ContentType_MENU_CONTAINER = ContentTypeData.newBuilder()
        .setContentTypeId("MENU_CONTAINER")
        .setDescription("Menu Container")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContentTypeData ContentType_OUTLINE_NODE = ContentTypeData.newBuilder()
        .setContentTypeId("OUTLINE_NODE")
        .setDescription("Outline Node")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("DOCUMENT")
        .build();


    public final static ContentTypeData ContentType_PAGE_NODE = ContentTypeData.newBuilder()
        .setContentTypeId("PAGE_NODE")
        .setDescription("Page Node")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("DOCUMENT")
        .build();


    public final static ContentTypeData ContentType_SUBPAGE_NODE = ContentTypeData.newBuilder()
        .setContentTypeId("SUBPAGE_NODE")
        .setDescription("Sub Page Node")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("DOCUMENT")
        .build();


    public final static ContentTypeData ContentType_CONTENT_LIST = ContentTypeData.newBuilder()
        .setContentTypeId("CONTENT_LIST")
        .setDescription("Content List")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContentTypeData ContentType_TREE_ROOT = ContentTypeData.newBuilder()
        .setContentTypeId("TREE_ROOT")
        .setDescription("Tree Root")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContentTypeData ContentType_GRAPH_ROOT = ContentTypeData.newBuilder()
        .setContentTypeId("GRAPH_ROOT")
        .setDescription("Graph Root")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContentTypeData ContentType_STRUCTURE_NODE = ContentTypeData.newBuilder()
        .setContentTypeId("STRUCTURE_NODE")
        .setDescription("Structure Node")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContentTypeData ContentType_STRUCTURE_LEAF = ContentTypeData.newBuilder()
        .setContentTypeId("STRUCTURE_LEAF")
        .setDescription("Structure Leaf")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContentTypeData ContentType_STRUCTURE_DEF = ContentTypeData.newBuilder()
        .setContentTypeId("STRUCTURE_DEF")
        .setDescription("Structure Definition (like DTD)")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContentTypeData ContentType_TXFORM_DEF = ContentTypeData.newBuilder()
        .setContentTypeId("TXFORM_DEF")
        .setDescription("Transformation Definition (like XSLT)")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContentTypeData ContentType_PLACEHOLDER = ContentTypeData.newBuilder()
        .setContentTypeId("PLACEHOLDER")
        .setDescription("Place Holder")
        .build();


    public final static ContentTypeData ContentType_WEB_SITE_PUB_PT = ContentTypeData.newBuilder()
        .setContentTypeId("WEB_SITE_PUB_PT")
        .setDescription("Web Site Publish Point")
        .setHasTable(castIndicator("Y"))
        .setParentTypeId("PLACEHOLDER")
        .build();


    public final static ContentTypeData ContentType_FORUM_ROOT = ContentTypeData.newBuilder()
        .setContentTypeId("FORUM_ROOT")
        .setDescription("Forum Root")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("PLACEHOLDER")
        .build();


    public final static ContentTypeData ContentType_BLOG_ROOT = ContentTypeData.newBuilder()
        .setContentTypeId("BLOG_ROOT")
        .setDescription("Blog Root")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("PLACEHOLDER")
        .build();


    public final static ContentTypeData ContentType_FAQ_ROOT = ContentTypeData.newBuilder()
        .setContentTypeId("FAQ_ROOT")
        .setDescription("FAQ Root")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("PLACEHOLDER")
        .build();


    public final static ContentTypeData ContentType_DEPARTMENT = ContentTypeData.newBuilder()
        .setContentTypeId("DEPARTMENT")
        .setDescription("Department")
        .setParentTypeId("PLACEHOLDER")
        .build();


    public final static ContentTypeData ContentType_PEOPLE = ContentTypeData.newBuilder()
        .setContentTypeId("PEOPLE")
        .setDescription("People")
        .setParentTypeId("PLACEHOLDER")
        .build();


    public final static ContentTypeData ContentType_PERSON = ContentTypeData.newBuilder()
        .setContentTypeId("PERSON")
        .setDescription("Person")
        .setParentTypeId("PLACEHOLDER")
        .build();


    public final static ContentTypeData ContentType_TOPIC = ContentTypeData.newBuilder()
        .setContentTypeId("TOPIC")
        .setDescription("Topic")
        .setParentTypeId("PLACEHOLDER")
        .build();


    public final static ElectronicTextData ElectronicText_STDWRAP001 = ElectronicTextData.newBuilder()
        .setDataResourceId("STDWRAP001")
        .build();


    public final static ElectronicTextData ElectronicText_LEFTBAR = ElectronicTextData.newBuilder()
        .setDataResourceId("LEFTBAR")
        .build();


    public final static ElectronicTextData ElectronicText_TMPLT_IMG_CENTER = ElectronicTextData.newBuilder()
        .setDataResourceId("TMPLT_IMG_CENTER")
        .build();


    public final static ElectronicTextData ElectronicText_TEMPLATE_IMAGE_LEFT = ElectronicTextData.newBuilder()
        .setDataResourceId("TEMPLATE_IMAGE_LEFT")
        .build();


    public final static ElectronicTextData ElectronicText_TEMPLATE_TEXT_ONLY = ElectronicTextData.newBuilder()
        .setDataResourceId("TEMPLATE_TEXT_ONLY")
        .build();


    public final static ElectronicTextData ElectronicText_WRAP_ARTICLE = ElectronicTextData.newBuilder()
        .setDataResourceId("WRAP_ARTICLE")
        .build();


    public final static ElectronicTextData ElectronicText_WRAP_ARTICLE_TABLE = ElectronicTextData.newBuilder()
        .setDataResourceId("WRAP_ARTICLE_TABLE")
        .build();


    public final static ElectronicTextData ElectronicText_WRAP_NEXT_PREV = ElectronicTextData.newBuilder()
        .setDataResourceId("WRAP_NEXT_PREV")
        .build();


    public final static ElectronicTextData ElectronicText_WRAP_STD_001 = ElectronicTextData.newBuilder()
        .setDataResourceId("WRAP_STD_001")
        .build();


    public final static ElectronicTextData ElectronicText_WRAP_STD_LOOP = ElectronicTextData.newBuilder()
        .setDataResourceId("WRAP_STD_LOOP")
        .build();


    public final static ElectronicTextData ElectronicText_WRAP_VIEW = ElectronicTextData.newBuilder()
        .setDataResourceId("WRAP_VIEW")
        .build();


    public final static ElectronicTextData ElectronicText_IMAGE_CENTERED = ElectronicTextData.newBuilder()
        .setDataResourceId("IMAGE_CENTERED")
        .build();


    public final static ElectronicTextData ElectronicText_IMAGE_LEFT = ElectronicTextData.newBuilder()
        .setDataResourceId("IMAGE_LEFT")
        .build();


    public final static ElectronicTextData ElectronicText_TEMPLATE_TEXT = ElectronicTextData.newBuilder()
        .setDataResourceId("TEMPLATE_TEXT")
        .build();


    public final static ElectronicTextData ElectronicText_TMPLT_IMG_CENTER_FL = ElectronicTextData.newBuilder()
        .setDataResourceId("TMPLT_IMG_CENTER_FL")
        .build();


    public final static RoleTypeData RoleType_LOGGEDIN = RoleTypeData.newBuilder()
        .setDescription("Logged In")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("LOGGEDIN")
        .build();


    public final static RoleTypeData RoleType_CONTENT = RoleTypeData.newBuilder()
        .setDescription("Content Member")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("CONTENT")
        .build();


    public final static RoleTypeData RoleType_CONTENT_ADMIN = RoleTypeData.newBuilder()
        .setDescription("Content Administrator")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CONTENT")
        .setRoleTypeId("CONTENT_ADMIN")
        .build();


    public final static RoleTypeData RoleType_CONTENT_PUBLISHER = RoleTypeData.newBuilder()
        .setDescription("Content Publisher")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CONTENT")
        .setRoleTypeId("CONTENT_PUBLISHER")
        .build();


    public final static RoleTypeData RoleType_CONTENT_EDITOR = RoleTypeData.newBuilder()
        .setDescription("Content Editor")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CONTENT")
        .setRoleTypeId("CONTENT_EDITOR")
        .build();


    public final static RoleTypeData RoleType_CONTENT_AUTHOR = RoleTypeData.newBuilder()
        .setDescription("Content Author")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CONTENT")
        .setRoleTypeId("CONTENT_AUTHOR")
        .build();


    public final static RoleTypeData RoleType_CONTENT_USER = RoleTypeData.newBuilder()
        .setDescription("Content User")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CONTENT")
        .setRoleTypeId("CONTENT_USER")
        .build();


    public final static RoleTypeData RoleType_CONTENT_GUEST = RoleTypeData.newBuilder()
        .setDescription("Content Guest")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CONTENT")
        .setRoleTypeId("CONTENT_GUEST")
        .build();


    public final static MetaDataPredicateData MetaDataPredicate_author_name = MetaDataPredicateData.newBuilder()
        .setDescription("Name of the author or creator of the subject.")
        .setMetaDataPredicateId("author-name")
        .build();


    public final static MetaDataPredicateData MetaDataPredicate_author_email = MetaDataPredicateData.newBuilder()
        .setDescription("eMail address of the author or creator of the subject.")
        .setMetaDataPredicateId("author-email")
        .build();


    public final static MetaDataPredicateData MetaDataPredicate_event_date = MetaDataPredicateData.newBuilder()
        .setDescription("The date and time of the event in format [yyyy-MM-dd hh:mm:ss].")
        .setMetaDataPredicateId("event-date")
        .build();


    public final static MetaDataPredicateData MetaDataPredicate_event_location = MetaDataPredicateData.newBuilder()
        .setDescription("The location where subject event took place.")
        .setMetaDataPredicateId("event-location")
        .build();


    public final static MetaDataPredicateData MetaDataPredicate_event_person_name = MetaDataPredicateData.newBuilder()
        .setDescription("The name of a person involved in the subject event.")
        .setMetaDataPredicateId("event-person-name")
        .build();


    public final static MimeTypeData MimeType_application_octet_stream = MimeTypeData.newBuilder()
        .setDescription("Arbitrary Binary Data")
        .setMimeTypeId("application/octet-stream")
        .build();


    public final static MimeTypeData MimeType_application_pkcs7_signature = MimeTypeData.newBuilder()
        .setDescription("PKCS7 Signature")
        .setMimeTypeId("application/pkcs7-signature")
        .build();


    public final static MimeTypeData MimeType_application_postscript = MimeTypeData.newBuilder()
        .setDescription("Postsctipt Application/Script")
        .setMimeTypeId("application/postscript")
        .build();


    public final static MimeTypeData MimeType_application_zip = MimeTypeData.newBuilder()
        .setDescription("ZIP Data")
        .setMimeTypeId("application/zip")
        .build();


    public final static MimeTypeData MimeType_application_pdf = MimeTypeData.newBuilder()
        .setDescription("Adobe Portable Document Format (PDF)")
        .setMimeTypeId("application/pdf")
        .build();


    public final static MimeTypeData MimeType_application_msword = MimeTypeData.newBuilder()
        .setDescription("Microsoft Word")
        .setMimeTypeId("application/msword")
        .build();


    public final static MimeTypeData MimeType_application_x_shockwave_flash = MimeTypeData.newBuilder()
        .setDescription("Shockwave Flash Movie")
        .setMimeTypeId("application/x-shockwave-flash")
        .build();


    public final static MimeTypeData MimeType_application_x_zip_compressed = MimeTypeData.newBuilder()
        .setDescription("ZIP compressed file")
        .setMimeTypeId("application/x-zip-compressed")
        .build();


    public final static MimeTypeData MimeType_application_x_tgz = MimeTypeData.newBuilder()
        .setDescription("Gzipped Tar archive file")
        .setMimeTypeId("application/x-tgz")
        .build();


    public final static MimeTypeData MimeType_application_vnd_oasis_opendocument_text = MimeTypeData.newBuilder()
        .setDescription("OpenOffice OpenDocument Text")
        .setMimeTypeId("application/vnd.oasis.opendocument.text")
        .build();


    public final static MimeTypeData MimeType_application_vnd_oasis_opendocument_spreadsheet = MimeTypeData.newBuilder()
        .setDescription("OpenOffice OpenDocument Spreadsheet")
        .setMimeTypeId("application/vnd.oasis.opendocument.spreadsheet")
        .build();


    public final static MimeTypeData MimeType_application_vnd_ofbiz_survey = MimeTypeData.newBuilder()
        .setDescription("Survey")
        .setMimeTypeId("application/vnd.ofbiz.survey")
        .build();


    public final static MimeTypeData MimeType_application_vnd_ofbiz_survey_response = MimeTypeData.newBuilder()
        .setDescription("Survey Response")
        .setMimeTypeId("application/vnd.ofbiz.survey.response")
        .build();


    public final static MimeTypeData MimeType_application_vnd_ms_powerpoint = MimeTypeData.newBuilder()
        .setDescription("Microsoft PowerPoint")
        .setMimeTypeId("application/vnd.ms-powerpoint")
        .build();


    public final static MimeTypeData MimeType_application_vnd_ms_excel = MimeTypeData.newBuilder()
        .setDescription("Microsoft Excel")
        .setMimeTypeId("application/vnd.ms-excel")
        .build();


    public final static MimeTypeData MimeType_audio_basic = MimeTypeData.newBuilder()
        .setDescription("Basic Audio")
        .setMimeTypeId("audio/basic")
        .build();


    public final static MimeTypeData MimeType_audio_mpeg = MimeTypeData.newBuilder()
        .setDescription("MP3 Audio")
        .setMimeTypeId("audio/mpeg")
        .build();


    public final static MimeTypeData MimeType_audio_mp4 = MimeTypeData.newBuilder()
        .setDescription("MP4 Audio")
        .setMimeTypeId("audio/mp4")
        .build();


    public final static MimeTypeData MimeType_audio_x_ms_wax = MimeTypeData.newBuilder()
        .setDescription("WAX Audio")
        .setMimeTypeId("audio/x-ms-wax")
        .build();


    public final static MimeTypeData MimeType_audio_wav = MimeTypeData.newBuilder()
        .setDescription("WAV Audio")
        .setMimeTypeId("audio/wav")
        .build();


    public final static MimeTypeData MimeType_audio_ogg = MimeTypeData.newBuilder()
        .setDescription("OGG Audio")
        .setMimeTypeId("audio/ogg")
        .build();


    public final static MimeTypeData MimeType_audio_x_ogg = MimeTypeData.newBuilder()
        .setDescription("OGG Audio")
        .setMimeTypeId("audio/x-ogg")
        .build();


    public final static MimeTypeData MimeType_audio_vorbis = MimeTypeData.newBuilder()
        .setDescription("Vorbis Audio")
        .setMimeTypeId("audio/vorbis")
        .build();


    public final static MimeTypeData MimeType_audio_x_flac = MimeTypeData.newBuilder()
        .setDescription("FLAC Audio")
        .setMimeTypeId("audio/x-flac")
        .build();


    public final static MimeTypeData MimeType_audio_flac = MimeTypeData.newBuilder()
        .setDescription("FLAC Audio")
        .setMimeTypeId("audio/flac")
        .build();


    public final static MimeTypeData MimeType_image_jpeg = MimeTypeData.newBuilder()
        .setDescription("JPEG/JPG Image")
        .setMimeTypeId("image/jpeg")
        .build();


    public final static MimeTypeData MimeType_image_pjpeg = MimeTypeData.newBuilder()
        .setDescription("Progressive JPEG/JPG Image")
        .setMimeTypeId("image/pjpeg")
        .build();


    public final static MimeTypeData MimeType_image_gif = MimeTypeData.newBuilder()
        .setDescription("GIF Image")
        .setMimeTypeId("image/gif")
        .build();


    public final static MimeTypeData MimeType_image_tiff = MimeTypeData.newBuilder()
        .setDescription("TIFF Image")
        .setMimeTypeId("image/tiff")
        .build();


    public final static MimeTypeData MimeType_image_png = MimeTypeData.newBuilder()
        .setDescription("PNG Image")
        .setMimeTypeId("image/png")
        .build();


    public final static MimeTypeData MimeType_image_svg_xml = MimeTypeData.newBuilder()
        .setDescription("Image SVG")
        .setMimeTypeId("image/svg+xml")
        .build();


    public final static MimeTypeData MimeType_message_external_body = MimeTypeData.newBuilder()
        .setDescription("External Body Message")
        .setMimeTypeId("message/external-body")
        .build();


    public final static MimeTypeData MimeType_message_http = MimeTypeData.newBuilder()
        .setDescription("HTTP Message")
        .setMimeTypeId("message/http")
        .build();


    public final static MimeTypeData MimeType_message_s_http = MimeTypeData.newBuilder()
        .setDescription("HTTPS/S-HTTP Message")
        .setMimeTypeId("message/s-http")
        .build();


    public final static MimeTypeData MimeType_message_news = MimeTypeData.newBuilder()
        .setDescription("News Message")
        .setMimeTypeId("message/news")
        .build();


    public final static MimeTypeData MimeType_message_partial = MimeTypeData.newBuilder()
        .setDescription("Partial Message")
        .setMimeTypeId("message/partial")
        .build();


    public final static MimeTypeData MimeType_message_rfc822 = MimeTypeData.newBuilder()
        .setDescription("RFC 822 Headered Message")
        .setMimeTypeId("message/rfc822")
        .build();


    public final static MimeTypeData MimeType_model_mesh = MimeTypeData.newBuilder()
        .setDescription("Mesh Model")
        .setMimeTypeId("model/mesh")
        .build();


    public final static MimeTypeData MimeType_model_vrml = MimeTypeData.newBuilder()
        .setDescription("VRML Model")
        .setMimeTypeId("model/vrml")
        .build();


    public final static MimeTypeData MimeType_multipart_alternative = MimeTypeData.newBuilder()
        .setDescription("Mutliple Alternative Multipart")
        .setMimeTypeId("multipart/alternative")
        .build();


    public final static MimeTypeData MimeType_multipart_digest = MimeTypeData.newBuilder()
        .setDescription("Digest of Messages Multipart")
        .setMimeTypeId("multipart/digest")
        .build();


    public final static MimeTypeData MimeType_multipart_encrypted = MimeTypeData.newBuilder()
        .setDescription("Encrypted Multipart")
        .setMimeTypeId("multipart/encrypted")
        .build();


    public final static MimeTypeData MimeType_multipart_form_data = MimeTypeData.newBuilder()
        .setDescription("Form Data Multipart")
        .setMimeTypeId("multipart/form-data")
        .build();


    public final static MimeTypeData MimeType_multipart_mixed = MimeTypeData.newBuilder()
        .setDescription("Mixed Type Multipart")
        .setMimeTypeId("multipart/mixed")
        .build();


    public final static MimeTypeData MimeType_multipart_related = MimeTypeData.newBuilder()
        .setDescription("Related Multipart")
        .setMimeTypeId("multipart/related")
        .build();


    public final static MimeTypeData MimeType_multipart_signed = MimeTypeData.newBuilder()
        .setDescription("Signed Multipart")
        .setMimeTypeId("multipart/signed")
        .build();


    public final static MimeTypeData MimeType_text_css = MimeTypeData.newBuilder()
        .setDescription("CSS Text")
        .setMimeTypeId("text/css")
        .build();


    public final static MimeTypeData MimeType_text_csv = MimeTypeData.newBuilder()
        .setDescription("Comma Separated Value Text")
        .setMimeTypeId("text/csv")
        .build();


    public final static MimeTypeData MimeType_text_enriched = MimeTypeData.newBuilder()
        .setDescription("Enriched Text")
        .setMimeTypeId("text/enriched")
        .build();


    public final static MimeTypeData MimeType_text_html = MimeTypeData.newBuilder()
        .setDescription("HTML Text")
        .setMimeTypeId("text/html")
        .build();


    public final static MimeTypeData MimeType_text_plain = MimeTypeData.newBuilder()
        .setDescription("Plain Text")
        .setMimeTypeId("text/plain")
        .build();


    public final static MimeTypeData MimeType_text_rtf = MimeTypeData.newBuilder()
        .setDescription("RTF Rich Text")
        .setMimeTypeId("text/rtf")
        .build();


    public final static MimeTypeData MimeType_text_richtext = MimeTypeData.newBuilder()
        .setDescription("Rich Text")
        .setMimeTypeId("text/richtext")
        .build();


    public final static MimeTypeData MimeType_text_sgml = MimeTypeData.newBuilder()
        .setDescription("SGML Text")
        .setMimeTypeId("text/sgml")
        .build();


    public final static MimeTypeData MimeType_text_tab_separated_values = MimeTypeData.newBuilder()
        .setDescription("Tab Separated Value Text")
        .setMimeTypeId("text/tab-separated-values")
        .build();


    public final static MimeTypeData MimeType_text_x_diff = MimeTypeData.newBuilder()
        .setDescription("diff for patching files")
        .setMimeTypeId("text/x-diff")
        .build();


    public final static MimeTypeData MimeType_text_xml = MimeTypeData.newBuilder()
        .setDescription("XML Text")
        .setMimeTypeId("text/xml")
        .build();


    public final static MimeTypeData MimeType_text_x_vcard = MimeTypeData.newBuilder()
        .setDescription("electronic business card")
        .setMimeTypeId("text/x-vcard")
        .build();


    public final static MimeTypeData MimeType_video_avi = MimeTypeData.newBuilder()
        .setDescription("AVI Video")
        .setMimeTypeId("video/avi")
        .build();


    public final static MimeTypeData MimeType_video_mpeg = MimeTypeData.newBuilder()
        .setDescription("MPEG/MPG Video")
        .setMimeTypeId("video/mpeg")
        .build();


    public final static MimeTypeData MimeType_video_mp4 = MimeTypeData.newBuilder()
        .setDescription("MPEG-4 (H.264) Video")
        .setMimeTypeId("video/mp4")
        .build();


    public final static MimeTypeData MimeType_video_quicktime = MimeTypeData.newBuilder()
        .setDescription("Quicktime Video")
        .setMimeTypeId("video/quicktime")
        .build();


    public final static MimeTypeData MimeType_video_x_ms_asf = MimeTypeData.newBuilder()
        .setDescription("ASF Video")
        .setMimeTypeId("video/x-ms-asf")
        .build();


    public final static MimeTypeData MimeType_video_x_flv = MimeTypeData.newBuilder()
        .setDescription("Flash Streaming Video")
        .setMimeTypeId("video/x-flv")
        .build();


    public final static MimeTypeData MimeType_video_x_ms_wvx = MimeTypeData.newBuilder()
        .setDescription("WVX Video")
        .setMimeTypeId("video/x-ms-wvx")
        .build();


    public final static MimeTypeData MimeType_video_x_ms_wm = MimeTypeData.newBuilder()
        .setDescription("WM Video")
        .setMimeTypeId("video/x-ms-wm")
        .build();


    public final static MimeTypeData MimeType_video_x_ms_wmv = MimeTypeData.newBuilder()
        .setDescription("WMV Video")
        .setMimeTypeId("video/x-ms-wmv")
        .build();


    public final static MimeTypeData MimeType_video_x_ms_wmx = MimeTypeData.newBuilder()
        .setDescription("WMX Video")
        .setMimeTypeId("video/x-ms-wmx")
        .build();


    public final static MimeTypeData MimeType_video_3gpp = MimeTypeData.newBuilder()
        .setDescription("3GP Mobile Video")
        .setMimeTypeId("video/3gpp")
        .build();


    public final static WebSiteContentTypeData WebSiteContentType_BLOG_ROOT = WebSiteContentTypeData.newBuilder()
        .setDescription("Blog Root")
        .setHasTable(castIndicator("N"))
        .setWebSiteContentTypeId("BLOG_ROOT")
        .build();


    public final static WebSiteContentTypeData WebSiteContentType_DEFAULT_PAGE = WebSiteContentTypeData.newBuilder()
        .setDescription("Default Page")
        .setHasTable(castIndicator("N"))
        .setWebSiteContentTypeId("DEFAULT_PAGE")
        .build();


    public final static WebSiteContentTypeData WebSiteContentType_FORUM_ROOT = WebSiteContentTypeData.newBuilder()
        .setDescription("Forum Root")
        .setHasTable(castIndicator("N"))
        .setWebSiteContentTypeId("FORUM_ROOT")
        .build();


    public final static WebSiteContentTypeData WebSiteContentType_MENU_ROOT = WebSiteContentTypeData.newBuilder()
        .setDescription("Menu Containers")
        .setHasTable(castIndicator("N"))
        .setWebSiteContentTypeId("MENU_ROOT")
        .build();


    public final static WebSiteContentTypeData WebSiteContentType_ERROR_ROOT = WebSiteContentTypeData.newBuilder()
        .setDescription("Error Page Containers")
        .setHasTable(castIndicator("N"))
        .setWebSiteContentTypeId("ERROR_ROOT")
        .build();


    public final static WebSiteContentTypeData WebSiteContentType_PUBLISH_POINT = WebSiteContentTypeData.newBuilder()
        .setDescription("Publish Point")
        .setHasTable(castIndicator("N"))
        .setWebSiteContentTypeId("PUBLISH_POINT")
        .build();


    public final static WebSiteContentTypeData WebSiteContentType_WEB_PAGE = WebSiteContentTypeData.newBuilder()
        .setDescription("Web Page")
        .setHasTable(castIndicator("N"))
        .setWebSiteContentTypeId("WEB_PAGE")
        .build();


    public final static WebSiteContentTypeData WebSiteContentType_MAINTENANCE_PAGE = WebSiteContentTypeData.newBuilder()
        .setDescription("Maintenance Page")
        .setHasTable(castIndicator("N"))
        .setWebSiteContentTypeId("MAINTENANCE_PAGE")
        .build();


    public final static WebAnalyticsTypeData WebAnalyticsType_WEB_ANALYTICS = WebAnalyticsTypeData.newBuilder()
        .setDescription("Web Analytics")
        .setHasTable(castIndicator("N"))
        .setWebAnalyticsTypeId("WEB_ANALYTICS")
        .build();


    public final static WebAnalyticsTypeData WebAnalyticsType_GOOGLE_ANALYTICS = WebAnalyticsTypeData.newBuilder()
        .setDescription("Google Analytics")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("WEB_ANALYTICS")
        .setWebAnalyticsTypeId("GOOGLE_ANALYTICS")
        .build();


    public final static WebAnalyticsTypeData WebAnalyticsType_BING_ANALYTICS = WebAnalyticsTypeData.newBuilder()
        .setDescription("Bing Analytics")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("WEB_ANALYTICS")
        .setWebAnalyticsTypeId("BING_ANALYTICS")
        .build();


    public final static WebAnalyticsTypeData WebAnalyticsType_BACKEND_ANALYTICS = WebAnalyticsTypeData.newBuilder()
        .setDescription("Backend Analytics")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("WEB_ANALYTICS")
        .setWebAnalyticsTypeId("BACKEND_ANALYTICS")
        .build();


    public final static StatusItemData StatusItem_CNTAP_NOT_READY = StatusItemData.newBuilder()
        .setDescription("Not Ready for Approval")
        .setSequenceId("01")
        .setStatusCode("NOT_READY")
        .setStatusId("CNTAP_NOT_READY")
        .setStatusTypeId("CNTNTAPPR_STATUS")
        .build();


    public final static StatusItemData StatusItem_CNTAP_READY = StatusItemData.newBuilder()
        .setDescription("Ready for Approval")
        .setSequenceId("02")
        .setStatusCode("READY")
        .setStatusId("CNTAP_READY")
        .setStatusTypeId("CNTNTAPPR_STATUS")
        .build();


    public final static StatusItemData StatusItem_CNTAP_IN_PROCESS = StatusItemData.newBuilder()
        .setDescription("Approval In Process")
        .setSequenceId("03")
        .setStatusCode("IN_PROCESS")
        .setStatusId("CNTAP_IN_PROCESS")
        .setStatusTypeId("CNTNTAPPR_STATUS")
        .build();


    public final static StatusItemData StatusItem_CNTAP_SOFT_REJ = StatusItemData.newBuilder()
        .setDescription("Soft Rejected")
        .setSequenceId("11")
        .setStatusCode("SOFT_REJ")
        .setStatusId("CNTAP_SOFT_REJ")
        .setStatusTypeId("CNTNTAPPR_STATUS")
        .build();


    public final static StatusItemData StatusItem_CNTAP_REJECTED = StatusItemData.newBuilder()
        .setDescription("Rejected")
        .setSequenceId("12")
        .setStatusCode("REJECTED")
        .setStatusId("CNTAP_REJECTED")
        .setStatusTypeId("CNTNTAPPR_STATUS")
        .build();


    public final static StatusItemData StatusItem_CNTAP_APPROVED = StatusItemData.newBuilder()
        .setDescription("Approved")
        .setSequenceId("21")
        .setStatusCode("APPROVED")
        .setStatusId("CNTAP_APPROVED")
        .setStatusTypeId("CNTNTAPPR_STATUS")
        .build();


    public final static StatusItemData StatusItem_CTNT_IN_PROGRESS = StatusItemData.newBuilder()
        .setDescription("In Progress")
        .setSequenceId("01")
        .setStatusCode("IN_PROGRESS")
        .setStatusId("CTNT_IN_PROGRESS")
        .setStatusTypeId("CONTENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_CTNT_INITIAL_DRAFT = StatusItemData.newBuilder()
        .setDescription("Initial Draft")
        .setSequenceId("02")
        .setStatusCode("INITIAL_DRAFT")
        .setStatusId("CTNT_INITIAL_DRAFT")
        .setStatusTypeId("CONTENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_CTNT_REVISED_DRAFT = StatusItemData.newBuilder()
        .setDescription("Revised Draft")
        .setSequenceId("03")
        .setStatusCode("REVISED_DRAFT")
        .setStatusId("CTNT_REVISED_DRAFT")
        .setStatusTypeId("CONTENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_CTNT_FINAL_DRAFT = StatusItemData.newBuilder()
        .setDescription("Final Draft")
        .setSequenceId("04")
        .setStatusCode("FINAL_DRAFT")
        .setStatusId("CTNT_FINAL_DRAFT")
        .setStatusTypeId("CONTENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_CTNT_PUBLISHED = StatusItemData.newBuilder()
        .setDescription("Published")
        .setSequenceId("05")
        .setStatusCode("PUBLISHED")
        .setStatusId("CTNT_PUBLISHED")
        .setStatusTypeId("CONTENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_CTNT_DEACTIVATED = StatusItemData.newBuilder()
        .setDescription("Deactivated")
        .setSequenceId("99")
        .setStatusCode("DEACTIVATED")
        .setStatusId("CTNT_DEACTIVATED")
        .setStatusTypeId("CONTENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_CTNT_AVAILABLE = StatusItemData.newBuilder()
        .setDescription("Available")
        .setSequenceId("10")
        .setStatusCode("AVAILABLE")
        .setStatusId("CTNT_AVAILABLE")
        .setStatusTypeId("CONTENT_STATUS")
        .build();


    public final static StatusValidChangeData StatusValidChange_CTNT_IN_PROGRESS_CTNT_INITIAL_DRAFT = StatusValidChangeData.newBuilder()
        .setStatusId("CTNT_IN_PROGRESS")
        .setStatusIdTo("CTNT_INITIAL_DRAFT")
        .setTransitionName("First draft")
        .build();


    public final static StatusValidChangeData StatusValidChange_CTNT_IN_PROGRESS_CTNT_PUBLISHED = StatusValidChangeData.newBuilder()
        .setStatusId("CTNT_IN_PROGRESS")
        .setStatusIdTo("CTNT_PUBLISHED")
        .setTransitionName("published, not revised")
        .build();


    public final static StatusValidChangeData StatusValidChange_CTNT_IN_PROGRESS_CTNT_AVAILABLE = StatusValidChangeData.newBuilder()
        .setStatusId("CTNT_IN_PROGRESS")
        .setStatusIdTo("CTNT_AVAILABLE")
        .setTransitionName("Available")
        .build();


    public final static StatusValidChangeData StatusValidChange_CTNT_IN_PROGRESS_IM_PENDING = StatusValidChangeData.newBuilder()
        .setStatusId("CTNT_IN_PROGRESS")
        .setStatusIdTo("IM_PENDING")
        .setTransitionName("Image Pending")
        .build();


    public final static StatusValidChangeData StatusValidChange_CTNT_INITIAL_DRAFT_CTNT_REVISED_DRAFT = StatusValidChangeData.newBuilder()
        .setStatusId("CTNT_INITIAL_DRAFT")
        .setStatusIdTo("CTNT_REVISED_DRAFT")
        .setTransitionName("Draft revised")
        .build();


    public final static StatusValidChangeData StatusValidChange_CTNT_INITIAL_DRAFT_CTNT_PUBLISHED = StatusValidChangeData.newBuilder()
        .setStatusId("CTNT_INITIAL_DRAFT")
        .setStatusIdTo("CTNT_PUBLISHED")
        .setTransitionName("Initial draft published")
        .build();


    public final static StatusValidChangeData StatusValidChange_CTNT_REVISED_DRAFT_CTNT_FINAL_DRAFT = StatusValidChangeData.newBuilder()
        .setStatusId("CTNT_REVISED_DRAFT")
        .setStatusIdTo("CTNT_FINAL_DRAFT")
        .setTransitionName("Final draft")
        .build();


    public final static StatusValidChangeData StatusValidChange_CTNT_REVISED_DRAFT_CTNT_PUBLISHED = StatusValidChangeData.newBuilder()
        .setStatusId("CTNT_REVISED_DRAFT")
        .setStatusIdTo("CTNT_PUBLISHED")
        .setTransitionName("Revised draft published")
        .build();


    public final static StatusValidChangeData StatusValidChange_CTNT_FINAL_DRAFT_CTNT_PUBLISHED = StatusValidChangeData.newBuilder()
        .setStatusId("CTNT_FINAL_DRAFT")
        .setStatusIdTo("CTNT_PUBLISHED")
        .setTransitionName("Final draft Published")
        .build();


    public final static StatusValidChangeData StatusValidChange_CTNT_PUBLISHED_CTNT_DEACTIVATED = StatusValidChangeData.newBuilder()
        .setStatusId("CTNT_PUBLISHED")
        .setStatusIdTo("CTNT_DEACTIVATED")
        .setTransitionName("Deactivated")
        .build();


    public final static StatusValidChangeData StatusValidChange_CTNT_AVAILABLE_CTNT_DEACTIVATED = StatusValidChangeData.newBuilder()
        .setStatusId("CTNT_AVAILABLE")
        .setStatusIdTo("CTNT_DEACTIVATED")
        .setTransitionName("Available to Deactivated")
        .build();


    public final static SubscriptionTypeData SubscriptionType_NEWSGROUP_SUBSCR = SubscriptionTypeData.newBuilder()
        .setDescription("Newsgroup")
        .setHasTable(castIndicator("N"))
        .setSubscriptionTypeId("NEWSGROUP_SUBSCR")
        .build();


    public final static SubscriptionTypeData SubscriptionType_OTHER_SUBSCR = SubscriptionTypeData.newBuilder()
        .setDescription("Other")
        .setHasTable(castIndicator("N"))
        .setSubscriptionTypeId("OTHER_SUBSCR")
        .build();


    public final static SubscriptionTypeData SubscriptionType_PRODUCT_INFO_SUBSCR = SubscriptionTypeData.newBuilder()
        .setDescription("Product Info")
        .setHasTable(castIndicator("N"))
        .setSubscriptionTypeId("PRODUCT_INFO_SUBSCR")
        .build();


    public final static ContentPurposeTypeData ContentPurposeType_ARTICLE = ContentPurposeTypeData.newBuilder()
        .setContentPurposeTypeId("ARTICLE")
        .setDescription("Article")
        .build();


    public final static ContentPurposeTypeData ContentPurposeType_MESSAGE = ContentPurposeTypeData.newBuilder()
        .setContentPurposeTypeId("MESSAGE")
        .setDescription("Message")
        .build();


    public final static ContentPurposeTypeData ContentPurposeType_FEEDBACK = ContentPurposeTypeData.newBuilder()
        .setContentPurposeTypeId("FEEDBACK")
        .setDescription("Feedback")
        .build();


    public final static ContentPurposeTypeData ContentPurposeType_COMMENT = ContentPurposeTypeData.newBuilder()
        .setContentPurposeTypeId("COMMENT")
        .setDescription("Comment")
        .build();


    public final static ContentPurposeTypeData ContentPurposeType_PRODUCT_INFO = ContentPurposeTypeData.newBuilder()
        .setContentPurposeTypeId("PRODUCT_INFO")
        .setDescription("Product Info")
        .build();


    public final static ContentPurposeTypeData ContentPurposeType_PROJECT_INFO = ContentPurposeTypeData.newBuilder()
        .setContentPurposeTypeId("PROJECT_INFO")
        .setDescription("Project Info")
        .build();


    public final static ContentPurposeTypeData ContentPurposeType_COMPANY_INFO = ContentPurposeTypeData.newBuilder()
        .setContentPurposeTypeId("COMPANY_INFO")
        .setDescription("Company Info")
        .build();


    public final static ContentPurposeTypeData ContentPurposeType_ADVERTISEMENT = ContentPurposeTypeData.newBuilder()
        .setContentPurposeTypeId("ADVERTISEMENT")
        .setDescription("Advertisement")
        .build();


    public final static ContentPurposeTypeData ContentPurposeType_GENERAL_INFO = ContentPurposeTypeData.newBuilder()
        .setContentPurposeTypeId("GENERAL_INFO")
        .setDescription("General Info")
        .build();


    public final static ContentPurposeTypeData ContentPurposeType_LEGAL_INFO = ContentPurposeTypeData.newBuilder()
        .setContentPurposeTypeId("LEGAL_INFO")
        .setDescription("Legal Info")
        .build();


    public final static ContentPurposeTypeData ContentPurposeType_DESCRIPTION = ContentPurposeTypeData.newBuilder()
        .setContentPurposeTypeId("DESCRIPTION")
        .setDescription("Description")
        .build();


    public final static ContentPurposeTypeData ContentPurposeType_OWNER = ContentPurposeTypeData.newBuilder()
        .setContentPurposeTypeId("OWNER")
        .setDescription("Owner")
        .build();


    public final static ContentPurposeTypeData ContentPurposeType_RESPONSE = ContentPurposeTypeData.newBuilder()
        .setContentPurposeTypeId("RESPONSE")
        .setDescription("Response")
        .build();


    public final static ContentPurposeTypeData ContentPurposeType__NA_ = ContentPurposeTypeData.newBuilder()
        .setContentPurposeTypeId("_NA_")
        .setDescription("Not Applicable")
        .build();


    public final static ContentPurposeTypeData ContentPurposeType_SECTION = ContentPurposeTypeData.newBuilder()
        .setContentPurposeTypeId("SECTION")
        .setDescription("Section")
        .build();


    public final static ContentPurposeTypeData ContentPurposeType_TOPIC = ContentPurposeTypeData.newBuilder()
        .setContentPurposeTypeId("TOPIC")
        .setDescription("Topic")
        .build();


    public final static ContentPurposeTypeData ContentPurposeType_SUMMARY = ContentPurposeTypeData.newBuilder()
        .setContentPurposeTypeId("SUMMARY")
        .setDescription("Summary")
        .build();


    public final static ContentPurposeTypeData ContentPurposeType_MAIN_ARTICLE = ContentPurposeTypeData.newBuilder()
        .setContentPurposeTypeId("MAIN_ARTICLE")
        .setDescription("Main Content")
        .build();


    public final static ContentPurposeTypeData ContentPurposeType_SUB_ARTICLE = ContentPurposeTypeData.newBuilder()
        .setContentPurposeTypeId("SUB_ARTICLE")
        .setDescription("Sub Content")
        .build();


    public final static ContentPurposeTypeData ContentPurposeType_USER = ContentPurposeTypeData.newBuilder()
        .setContentPurposeTypeId("USER")
        .setDescription("User")
        .build();


    public final static ContentPurposeTypeData ContentPurposeType_FAQ = ContentPurposeTypeData.newBuilder()
        .setContentPurposeTypeId("FAQ")
        .setDescription("FAQ")
        .build();


    public final static ContentPurposeTypeData ContentPurposeType_SOURCE = ContentPurposeTypeData.newBuilder()
        .setContentPurposeTypeId("SOURCE")
        .setDescription("General Source")
        .build();


    public final static ContentPurposeTypeData ContentPurposeType_LANDING_PAGE_IMAGE = ContentPurposeTypeData.newBuilder()
        .setContentPurposeTypeId("LANDING_PAGE_IMAGE")
        .setDescription("Landing Page Image")
        .build();


    public final static FileExtensionData FileExtension_asf = FileExtensionData.newBuilder()
        .setFileExtensionId("asf")
        .setMimeTypeId("video/x-ms-asf")
        .build();


    public final static FileExtensionData FileExtension_asx = FileExtensionData.newBuilder()
        .setFileExtensionId("asx")
        .setMimeTypeId("video/x-ms-asf")
        .build();


    public final static FileExtensionData FileExtension_avi = FileExtensionData.newBuilder()
        .setFileExtensionId("avi")
        .setMimeTypeId("video/avi")
        .build();


    public final static FileExtensionData FileExtension_css = FileExtensionData.newBuilder()
        .setFileExtensionId("css")
        .setMimeTypeId("text/css")
        .build();


    public final static FileExtensionData FileExtension_flv = FileExtensionData.newBuilder()
        .setFileExtensionId("flv")
        .setMimeTypeId("video/x-flv")
        .build();


    public final static FileExtensionData FileExtension_jpg = FileExtensionData.newBuilder()
        .setFileExtensionId("jpg")
        .setMimeTypeId("image/jpeg")
        .build();


    public final static FileExtensionData FileExtension_jpeg = FileExtensionData.newBuilder()
        .setFileExtensionId("jpeg")
        .setMimeTypeId("image/jpeg")
        .build();


    public final static FileExtensionData FileExtension_tif = FileExtensionData.newBuilder()
        .setFileExtensionId("tif")
        .setMimeTypeId("image/tiff")
        .build();


    public final static FileExtensionData FileExtension_tiff = FileExtensionData.newBuilder()
        .setFileExtensionId("tiff")
        .setMimeTypeId("image/tiff")
        .build();


    public final static FileExtensionData FileExtension_gif = FileExtensionData.newBuilder()
        .setFileExtensionId("gif")
        .setMimeTypeId("image/gif")
        .build();


    public final static FileExtensionData FileExtension_svg = FileExtensionData.newBuilder()
        .setFileExtensionId("svg")
        .setMimeTypeId("image/svg+xml")
        .build();


    public final static FileExtensionData FileExtension_png = FileExtensionData.newBuilder()
        .setFileExtensionId("png")
        .setMimeTypeId("image/png")
        .build();


    public final static FileExtensionData FileExtension_mp4 = FileExtensionData.newBuilder()
        .setFileExtensionId("mp4")
        .setMimeTypeId("video/mp4")
        .build();


    public final static FileExtensionData FileExtension_m4v = FileExtensionData.newBuilder()
        .setFileExtensionId("m4v")
        .setMimeTypeId("video/mp4")
        .build();


    public final static FileExtensionData FileExtension_mpg = FileExtensionData.newBuilder()
        .setFileExtensionId("mpg")
        .setMimeTypeId("video/mpeg")
        .build();


    public final static FileExtensionData FileExtension_mpeg = FileExtensionData.newBuilder()
        .setFileExtensionId("mpeg")
        .setMimeTypeId("video/mpeg")
        .build();


    public final static FileExtensionData FileExtension_mov = FileExtensionData.newBuilder()
        .setFileExtensionId("mov")
        .setMimeTypeId("video/quicktime")
        .build();


    public final static FileExtensionData FileExtension_pdf = FileExtensionData.newBuilder()
        .setFileExtensionId("pdf")
        .setMimeTypeId("application/pdf")
        .build();


    public final static FileExtensionData FileExtension_ps = FileExtensionData.newBuilder()
        .setFileExtensionId("ps")
        .setMimeTypeId("application/postscript")
        .build();


    public final static FileExtensionData FileExtension_qt = FileExtensionData.newBuilder()
        .setFileExtensionId("qt")
        .setMimeTypeId("video/quicktime")
        .build();


    public final static FileExtensionData FileExtension_rtf = FileExtensionData.newBuilder()
        .setFileExtensionId("rtf")
        .setMimeTypeId("text/rtf")
        .build();


    public final static FileExtensionData FileExtension_swf = FileExtensionData.newBuilder()
        .setFileExtensionId("swf")
        .setMimeTypeId("application/x-shockwave-flash")
        .build();


    public final static FileExtensionData FileExtension_txt = FileExtensionData.newBuilder()
        .setFileExtensionId("txt")
        .setMimeTypeId("text/plain")
        .build();


    public final static FileExtensionData FileExtension_htm = FileExtensionData.newBuilder()
        .setFileExtensionId("htm")
        .setMimeTypeId("text/html")
        .build();


    public final static FileExtensionData FileExtension_html = FileExtensionData.newBuilder()
        .setFileExtensionId("html")
        .setMimeTypeId("text/html")
        .build();


    public final static FileExtensionData FileExtension_xml = FileExtensionData.newBuilder()
        .setFileExtensionId("xml")
        .setMimeTypeId("text/xml")
        .build();


    public final static FileExtensionData FileExtension_vrml = FileExtensionData.newBuilder()
        .setFileExtensionId("vrml")
        .setMimeTypeId("model/vrml")
        .build();


    public final static FileExtensionData FileExtension_doc = FileExtensionData.newBuilder()
        .setFileExtensionId("doc")
        .setMimeTypeId("application/msword")
        .build();


    public final static FileExtensionData FileExtension_odt = FileExtensionData.newBuilder()
        .setFileExtensionId("odt")
        .setMimeTypeId("application/vnd.oasis.opendocument.text")
        .build();


    public final static FileExtensionData FileExtension_wvx = FileExtensionData.newBuilder()
        .setFileExtensionId("wvx")
        .setMimeTypeId("video/x-ms-wvx")
        .build();


    public final static FileExtensionData FileExtension_wm = FileExtensionData.newBuilder()
        .setFileExtensionId("wm")
        .setMimeTypeId("video/x-ms-wm")
        .build();


    public final static FileExtensionData FileExtension_wmv = FileExtensionData.newBuilder()
        .setFileExtensionId("wmv")
        .setMimeTypeId("video/x-ms-wmv")
        .build();


    public final static FileExtensionData FileExtension_wmx = FileExtensionData.newBuilder()
        .setFileExtensionId("wmx")
        .setMimeTypeId("video/x-ms-wmx")
        .build();


    public final static FileExtensionData FileExtension_zip = FileExtensionData.newBuilder()
        .setFileExtensionId("zip")
        .setMimeTypeId("application/zip")
        .build();


    public final static FileExtensionData FileExtension_vcf = FileExtensionData.newBuilder()
        .setFileExtensionId("vcf")
        .setMimeTypeId("text/x-vcard")
        .build();


    public final static FileExtensionData FileExtension_wav = FileExtensionData.newBuilder()
        .setFileExtensionId("wav")
        .setMimeTypeId("audio/wav")
        .build();


    public final static FileExtensionData FileExtension_mp3 = FileExtensionData.newBuilder()
        .setFileExtensionId("mp3")
        .setMimeTypeId("audio/mpeg")
        .build();


    public final static FileExtensionData FileExtension_ogg = FileExtensionData.newBuilder()
        .setFileExtensionId("ogg")
        .setMimeTypeId("audio/ogg")
        .build();


    public final static FileExtensionData FileExtension_flac = FileExtensionData.newBuilder()
        .setFileExtensionId("flac")
        .setMimeTypeId("audio/flac")
        .build();


    public final static FileExtensionData FileExtension_vorbis = FileExtensionData.newBuilder()
        .setFileExtensionId("vorbis")
        .setMimeTypeId("audio/ogg")
        .build();


    public final static FileExtensionData FileExtension_dflt = FileExtensionData.newBuilder()
        .setFileExtensionId("dflt")
        .setMimeTypeId("application/octet-stream")
        .build();


    public final static FileExtensionData FileExtension_3gp = FileExtensionData.newBuilder()
        .setFileExtensionId("3gp")
        .setMimeTypeId("video/3gpp")
        .build();


    public final static SecurityGroupPermissionData SecurityGroupPermission_SUPER_CONTENTMGR_ADMIN_ = SecurityGroupPermissionData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setGroupId("SUPER")
        .setPermissionId("CONTENTMGR_ADMIN")
        .build();


    public final static DataTemplateTypeData DataTemplateType_NONE = DataTemplateTypeData.newBuilder()
        .setDataTemplateTypeId("NONE")
        .setDescription("No Template")
        .build();


    public final static DataTemplateTypeData DataTemplateType_FTL = DataTemplateTypeData.newBuilder()
        .setDataTemplateTypeId("FTL")
        .setDescription("FreeMarker")
        .setExtension("ftl")
        .build();


    public final static DataTemplateTypeData DataTemplateType_WM = DataTemplateTypeData.newBuilder()
        .setDataTemplateTypeId("WM")
        .setDescription("WebMacro")
        .setExtension("wm")
        .build();


    public final static DataTemplateTypeData DataTemplateType_XSLT = DataTemplateTypeData.newBuilder()
        .setDataTemplateTypeId("XSLT")
        .setDescription("XSLT")
        .setExtension("xsl")
        .build();


    public final static DataTemplateTypeData DataTemplateType_SCREEN_COMBINED = DataTemplateTypeData.newBuilder()
        .setDataTemplateTypeId("SCREEN_COMBINED")
        .setDescription("Screen widget")
        .setExtension("xml")
        .build();


    public final static CharacterSetData CharacterSet_ISO_8859_1 = CharacterSetData.newBuilder()
        .setCharacterSetId("ISO-8859-1")
        .setDescription("ISO-8859-1 English")
        .build();


    public final static CharacterSetData CharacterSet_ISO_8859_2 = CharacterSetData.newBuilder()
        .setCharacterSetId("ISO-8859-2")
        .setDescription("ISO-8859-2 ?")
        .build();


    public final static CharacterSetData CharacterSet_ISO_8859_3 = CharacterSetData.newBuilder()
        .setCharacterSetId("ISO-8859-3")
        .setDescription("ISO-8859-3 ?")
        .build();


    public final static CharacterSetData CharacterSet_ISO_8859_4 = CharacterSetData.newBuilder()
        .setCharacterSetId("ISO-8859-4")
        .setDescription("ISO-8859-4 ?")
        .build();


    public final static CharacterSetData CharacterSet_ISO_8859_5 = CharacterSetData.newBuilder()
        .setCharacterSetId("ISO-8859-5")
        .setDescription("ISO-8859-5 ?")
        .build();


    public final static CharacterSetData CharacterSet_ISO_8859_6 = CharacterSetData.newBuilder()
        .setCharacterSetId("ISO-8859-6")
        .setDescription("ISO-8859-6 Latin/Arabic")
        .build();


    public final static CharacterSetData CharacterSet_ISO_8859_7 = CharacterSetData.newBuilder()
        .setCharacterSetId("ISO-8859-7")
        .setDescription("ISO-8859-7 ?")
        .build();


    public final static CharacterSetData CharacterSet_ISO_8859_8 = CharacterSetData.newBuilder()
        .setCharacterSetId("ISO-8859-8")
        .setDescription("ISO-8859-8 Latin/Hebrew")
        .build();


    public final static CharacterSetData CharacterSet_ISO_8859_9 = CharacterSetData.newBuilder()
        .setCharacterSetId("ISO-8859-9")
        .setDescription("ISO-8859-9 ?")
        .build();


    public final static CharacterSetData CharacterSet_ISO_8859_10 = CharacterSetData.newBuilder()
        .setCharacterSetId("ISO-8859-10")
        .setDescription("ISO-8859-10 ?")
        .build();


    public final static CharacterSetData CharacterSet_US_ASCII = CharacterSetData.newBuilder()
        .setCharacterSetId("US-ASCII")
        .setDescription("US-ASCII as defined in ANSI X3.4-1986")
        .build();


    public final static CharacterSetData CharacterSet_UTF_8 = CharacterSetData.newBuilder()
        .setCharacterSetId("UTF-8")
        .setDescription("Unicode 8 bit")
        .build();


    public final static CharacterSetData CharacterSet_UTF_16 = CharacterSetData.newBuilder()
        .setCharacterSetId("UTF-16")
        .setDescription("Unicode 16 bit")
        .build();


    public final static ContentAssocPredicateData ContentAssocPredicate_member_of = ContentAssocPredicateData.newBuilder()
        .setContentAssocPredicateId("member-of")
        .setDescription("The object is a member of the subject.")
        .build();


    public final static ContentAssocPredicateData ContentAssocPredicate_defines = ContentAssocPredicateData.newBuilder()
        .setContentAssocPredicateId("defines")
        .setDescription("The object defines the subject.")
        .build();


    public final static ContentAssocPredicateData ContentAssocPredicate_extends = ContentAssocPredicateData.newBuilder()
        .setContentAssocPredicateId("extends")
        .setDescription("The object extends the subject.")
        .build();


    public final static ContentAssocPredicateData ContentAssocPredicate_related_to = ContentAssocPredicateData.newBuilder()
        .setContentAssocPredicateId("related-to")
        .setDescription("The object is related to the subject.")
        .build();


    public final static ContentAssocPredicateData ContentAssocPredicate_references = ContentAssocPredicateData.newBuilder()
        .setContentAssocPredicateId("references")
        .setDescription("The object references the subject.")
        .build();


    public final static ContentAssocPredicateData ContentAssocPredicate_topifies = ContentAssocPredicateData.newBuilder()
        .setContentAssocPredicateId("topifies")
        .setDescription("Topifies")
        .build();


    public final static ContentAssocPredicateData ContentAssocPredicate_categorizes = ContentAssocPredicateData.newBuilder()
        .setContentAssocPredicateId("categorizes")
        .setDescription("Categorizes")
        .build();


    public final static SurveyApplTypeData SurveyApplType_CART_ADD = SurveyApplTypeData.newBuilder()
        .setDescription("Add-To Cart")
        .setSurveyApplTypeId("CART_ADD")
        .build();


    public final static SurveyApplTypeData SurveyApplType_CHECK_OUT = SurveyApplTypeData.newBuilder()
        .setDescription("Check-Out")
        .setSurveyApplTypeId("CHECK_OUT")
        .build();


    public final static SurveyApplTypeData SurveyApplType_GENERAL_POLL = SurveyApplTypeData.newBuilder()
        .setDescription("General Poll")
        .setSurveyApplTypeId("GENERAL_POLL")
        .build();


    public final static SurveyApplTypeData SurveyApplType_RANDOM_POLL = SurveyApplTypeData.newBuilder()
        .setDescription("Random Poll")
        .setSurveyApplTypeId("RANDOM_POLL")
        .build();


    public final static SurveyApplTypeData SurveyApplType_CUSTOMER_PROFILE = SurveyApplTypeData.newBuilder()
        .setDescription("Customer Profile")
        .setSurveyApplTypeId("CUSTOMER_PROFILE")
        .build();


    public final static SurveyApplTypeData SurveyApplType_SORDER_PLACE = SurveyApplTypeData.newBuilder()
        .setDescription("Sales Order Placement")
        .setSurveyApplTypeId("SORDER_PLACE")
        .build();


    public final static SurveyApplTypeData SurveyApplType_PORDER_PLACE = SurveyApplTypeData.newBuilder()
        .setDescription("Purchase Order Placement")
        .setSurveyApplTypeId("PORDER_PLACE")
        .build();


    public final static SurveyApplTypeData SurveyApplType_PORDITM_PLACE = SurveyApplTypeData.newBuilder()
        .setDescription("Purchase Order Item Placement")
        .setSurveyApplTypeId("PORDITM_PLACE")
        .build();


    public final static MimeTypeHtmlTemplateData MimeTypeHtmlTemplate_application_x_shockwave_flash = MimeTypeHtmlTemplateData.newBuilder()
        .setMimeTypeId("application/x-shockwave-flash")
        .setTemplateLocation("component://content/template/mime-type/Flash-swf.ftl")
        .build();


    public final static MimeTypeHtmlTemplateData MimeTypeHtmlTemplate_image_jpeg = MimeTypeHtmlTemplateData.newBuilder()
        .setMimeTypeId("image/jpeg")
        .setTemplateLocation("component://content/template/mime-type/Image.ftl")
        .build();


    public final static MimeTypeHtmlTemplateData MimeTypeHtmlTemplate_image_pjpeg = MimeTypeHtmlTemplateData.newBuilder()
        .setMimeTypeId("image/pjpeg")
        .setTemplateLocation("component://content/template/mime-type/Image.ftl")
        .build();


    public final static MimeTypeHtmlTemplateData MimeTypeHtmlTemplate_image_gif = MimeTypeHtmlTemplateData.newBuilder()
        .setMimeTypeId("image/gif")
        .setTemplateLocation("component://content/template/mime-type/Image.ftl")
        .build();


    public final static MimeTypeHtmlTemplateData MimeTypeHtmlTemplate_image_tiff = MimeTypeHtmlTemplateData.newBuilder()
        .setMimeTypeId("image/tiff")
        .setTemplateLocation("component://content/template/mime-type/Image.ftl")
        .build();


    public final static MimeTypeHtmlTemplateData MimeTypeHtmlTemplate_image_png = MimeTypeHtmlTemplateData.newBuilder()
        .setMimeTypeId("image/png")
        .setTemplateLocation("component://content/template/mime-type/Image.ftl")
        .build();


    public final static MimeTypeHtmlTemplateData MimeTypeHtmlTemplate_video_quicktime = MimeTypeHtmlTemplateData.newBuilder()
        .setMimeTypeId("video/quicktime")
        .setTemplateLocation("component://content/template/mime-type/QuickTime.ftl")
        .build();


    public final static MimeTypeHtmlTemplateData MimeTypeHtmlTemplate_video_mp4 = MimeTypeHtmlTemplateData.newBuilder()
        .setMimeTypeId("video/mp4")
        .setTemplateLocation("component://content/template/mime-type/QuickTime.ftl")
        .build();


    public final static MimeTypeHtmlTemplateData MimeTypeHtmlTemplate_video_x_flv = MimeTypeHtmlTemplateData.newBuilder()
        .setMimeTypeId("video/x-flv")
        .setTemplateLocation("component://content/template/mime-type/Flash-flv.ftl")
        .build();


    public final static SecurityPermissionData SecurityPermission_CONTENTMGR_VIEW = SecurityPermissionData.newBuilder()
        .setDescription("View operations in the Content Manager.")
        .setPermissionId("CONTENTMGR_VIEW")
        .build();


    public final static SecurityPermissionData SecurityPermission_CONTENTMGR_CREATE = SecurityPermissionData.newBuilder()
        .setDescription("Create operations in the Content Manager.")
        .setPermissionId("CONTENTMGR_CREATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_CONTENTMGR_UPDATE = SecurityPermissionData.newBuilder()
        .setDescription("Update operations in the Content Manager.")
        .setPermissionId("CONTENTMGR_UPDATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_CONTENTMGR_DELETE = SecurityPermissionData.newBuilder()
        .setDescription("Delete operations in the Content Manager.")
        .setPermissionId("CONTENTMGR_DELETE")
        .build();


    public final static SecurityPermissionData SecurityPermission_CONTENTMGR_ADMIN = SecurityPermissionData.newBuilder()
        .setDescription("ALL operations in the Content Manager.")
        .setPermissionId("CONTENTMGR_ADMIN")
        .build();


    public final static SecurityPermissionData SecurityPermission_CONTENTMGR_ROLE_VIEW = SecurityPermissionData.newBuilder()
        .setDescription("Limited View operations in the Content Manager.")
        .setPermissionId("CONTENTMGR_ROLE_VIEW")
        .build();


    public final static SecurityPermissionData SecurityPermission_CONTENTMGR_ROLE_CREATE = SecurityPermissionData.newBuilder()
        .setDescription("Limited Create operations in the Content Manager.")
        .setPermissionId("CONTENTMGR_ROLE_CREATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_CONTENTMGR_ROLE_UPDATE = SecurityPermissionData.newBuilder()
        .setDescription("Limited Update operations in the Content Manager.")
        .setPermissionId("CONTENTMGR_ROLE_UPDATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_CONTENTMGR_ROLE_DELETE = SecurityPermissionData.newBuilder()
        .setDescription("Limited Delete operations in the Content Manager.")
        .setPermissionId("CONTENTMGR_ROLE_DELETE")
        .build();


    public final static EnumerationData Enumeration_CNT_PRV_NA_ = EnumerationData.newBuilder()
        .setDescription("Not Applicable")
        .setEnumCode("_NA_")
        .setEnumId("CNT_PRV_NA_")
        .setEnumTypeId("CONTENT_PRIVILEGE")
        .setSequenceId("00")
        .build();


    public final static EnumerationData Enumeration_CNT_PRV_BRONZE = EnumerationData.newBuilder()
        .setDescription("Bronze Level")
        .setEnumCode("BRONZE")
        .setEnumId("CNT_PRV_BRONZE")
        .setEnumTypeId("CONTENT_PRIVILEGE")
        .setSequenceId("10")
        .build();


    public final static EnumerationData Enumeration_CNT_PRV_SILVER = EnumerationData.newBuilder()
        .setDescription("Silver Level")
        .setEnumCode("SILVER")
        .setEnumId("CNT_PRV_SILVER")
        .setEnumTypeId("CONTENT_PRIVILEGE")
        .setSequenceId("20")
        .build();


    public final static EnumerationData Enumeration_CNT_PRV_GOLD = EnumerationData.newBuilder()
        .setDescription("Gold Level")
        .setEnumCode("GOLD")
        .setEnumId("CNT_PRV_GOLD")
        .setEnumTypeId("CONTENT_PRIVILEGE")
        .setSequenceId("30")
        .build();


    public final static EnumerationData Enumeration_SUBSCRIBE_BRONZE = EnumerationData.newBuilder()
        .setDescription("Bronze Level")
        .setEnumCode("BRONZE")
        .setEnumId("SUBSCRIBE_BRONZE")
        .setEnumTypeId("SUBSCRIPTION_TYPE")
        .setSequenceId("10")
        .build();


    public final static EnumerationData Enumeration_SUBSCRIBE_GOLD = EnumerationData.newBuilder()
        .setDescription("Gold Level")
        .setEnumCode("GOLD")
        .setEnumId("SUBSCRIBE_GOLD")
        .setEnumTypeId("SUBSCRIPTION_TYPE")
        .setSequenceId("30")
        .build();


    public final static EnumerationData Enumeration_SUBSCRIBE_SILVER = EnumerationData.newBuilder()
        .setDescription("Silver Level")
        .setEnumCode("SILVER")
        .setEnumId("SUBSCRIBE_SILVER")
        .setEnumTypeId("SUBSCRIPTION_TYPE")
        .setSequenceId("20")
        .build();


    public final static SurveyQuestionTypeData SurveyQuestionType_BOOLEAN = SurveyQuestionTypeData.newBuilder()
        .setDescription("Boolean (Yes/No)")
        .setSurveyQuestionTypeId("BOOLEAN")
        .build();


    public final static SurveyQuestionTypeData SurveyQuestionType_CONTENT = SurveyQuestionTypeData.newBuilder()
        .setDescription("Content Record")
        .setSurveyQuestionTypeId("CONTENT")
        .build();


    public final static SurveyQuestionTypeData SurveyQuestionType_COUNTRY = SurveyQuestionTypeData.newBuilder()
        .setDescription("Country")
        .setSurveyQuestionTypeId("COUNTRY")
        .build();


    public final static SurveyQuestionTypeData SurveyQuestionType_CREDIT_CARD = SurveyQuestionTypeData.newBuilder()
        .setDescription("Credit Card Number")
        .setSurveyQuestionTypeId("CREDIT_CARD")
        .build();


    public final static SurveyQuestionTypeData SurveyQuestionType_GEO = SurveyQuestionTypeData.newBuilder()
        .setDescription("Geo List")
        .setSurveyQuestionTypeId("GEO")
        .build();


    public final static SurveyQuestionTypeData SurveyQuestionType_GIFT_CARD = SurveyQuestionTypeData.newBuilder()
        .setDescription("Gift Card Number")
        .setSurveyQuestionTypeId("GIFT_CARD")
        .build();


    public final static SurveyQuestionTypeData SurveyQuestionType_DATE = SurveyQuestionTypeData.newBuilder()
        .setDescription("Date String (mm/dd/yyyy)")
        .setSurveyQuestionTypeId("DATE")
        .build();


    public final static SurveyQuestionTypeData SurveyQuestionType_EMAIL = SurveyQuestionTypeData.newBuilder()
        .setDescription("Email Address")
        .setSurveyQuestionTypeId("EMAIL")
        .build();


    public final static SurveyQuestionTypeData SurveyQuestionType_ENUMERATION = SurveyQuestionTypeData.newBuilder()
        .setDescription("Enumeration")
        .setSurveyQuestionTypeId("ENUMERATION")
        .build();


    public final static SurveyQuestionTypeData SurveyQuestionType_NUMBER_CURRENCY = SurveyQuestionTypeData.newBuilder()
        .setDescription("Numeric (Currency)")
        .setSurveyQuestionTypeId("NUMBER_CURRENCY")
        .build();


    public final static SurveyQuestionTypeData SurveyQuestionType_NUMBER_FLOAT = SurveyQuestionTypeData.newBuilder()
        .setDescription("Numeric (Float)")
        .setSurveyQuestionTypeId("NUMBER_FLOAT")
        .build();


    public final static SurveyQuestionTypeData SurveyQuestionType_NUMBER_LONG = SurveyQuestionTypeData.newBuilder()
        .setDescription("Numeric (Long)")
        .setSurveyQuestionTypeId("NUMBER_LONG")
        .build();


    public final static SurveyQuestionTypeData SurveyQuestionType_OPTION = SurveyQuestionTypeData.newBuilder()
        .setDescription("Selected Option")
        .setSurveyQuestionTypeId("OPTION")
        .build();


    public final static SurveyQuestionTypeData SurveyQuestionType_PASSWORD = SurveyQuestionTypeData.newBuilder()
        .setDescription("Password")
        .setSurveyQuestionTypeId("PASSWORD")
        .build();


    public final static SurveyQuestionTypeData SurveyQuestionType_SEPERATOR_LINE = SurveyQuestionTypeData.newBuilder()
        .setDescription("Seperator Line")
        .setSurveyQuestionTypeId("SEPERATOR_LINE")
        .build();


    public final static SurveyQuestionTypeData SurveyQuestionType_SEPERATOR_TEXT = SurveyQuestionTypeData.newBuilder()
        .setDescription("Seperator Text")
        .setSurveyQuestionTypeId("SEPERATOR_TEXT")
        .build();


    public final static SurveyQuestionTypeData SurveyQuestionType_STATE_PROVINCE = SurveyQuestionTypeData.newBuilder()
        .setDescription("State/Province")
        .setSurveyQuestionTypeId("STATE_PROVINCE")
        .build();


    public final static SurveyQuestionTypeData SurveyQuestionType_TEXT_SHORT = SurveyQuestionTypeData.newBuilder()
        .setDescription("Short Text (single-line)")
        .setSurveyQuestionTypeId("TEXT_SHORT")
        .build();


    public final static SurveyQuestionTypeData SurveyQuestionType_TEXT_LONG = SurveyQuestionTypeData.newBuilder()
        .setDescription("Long Text (single-line)")
        .setSurveyQuestionTypeId("TEXT_LONG")
        .build();


    public final static SurveyQuestionTypeData SurveyQuestionType_TEXTAREA = SurveyQuestionTypeData.newBuilder()
        .setDescription("Text (multi-line)")
        .setSurveyQuestionTypeId("TEXTAREA")
        .build();


    public final static SurveyQuestionTypeData SurveyQuestionType_URL = SurveyQuestionTypeData.newBuilder()
        .setDescription("URL")
        .setSurveyQuestionTypeId("URL")
        .build();


    public final static ContentOperationData ContentOperation_CONTENT_ADMIN = ContentOperationData.newBuilder()
        .setContentOperationId("CONTENT_ADMIN")
        .setDescription("Content Admin")
        .build();


    public final static ContentOperationData ContentOperation_CONTENT_CREATE = ContentOperationData.newBuilder()
        .setContentOperationId("CONTENT_CREATE")
        .setDescription("Content Create")
        .build();


    public final static ContentOperationData ContentOperation_CONTENT_UPDATE = ContentOperationData.newBuilder()
        .setContentOperationId("CONTENT_UPDATE")
        .setDescription("Content Update")
        .build();


    public final static ContentOperationData ContentOperation_CONTENT_DELETE = ContentOperationData.newBuilder()
        .setContentOperationId("CONTENT_DELETE")
        .setDescription("Content Delete")
        .build();


    public final static ContentOperationData ContentOperation_CONTENT_VIEW = ContentOperationData.newBuilder()
        .setContentOperationId("CONTENT_VIEW")
        .setDescription("Content View")
        .build();


    public final static ContentOperationData ContentOperation_CONTENT_PUBLISH = ContentOperationData.newBuilder()
        .setContentOperationId("CONTENT_PUBLISH")
        .setDescription("Content Publish")
        .build();


    public final static ContentOperationData ContentOperation_CONTENT_RESPOND = ContentOperationData.newBuilder()
        .setContentOperationId("CONTENT_RESPOND")
        .setDescription("Content Respond")
        .build();


    public final static ContentOperationData ContentOperation_CONTENT_PUBLISH_SELF = ContentOperationData.newBuilder()
        .setContentOperationId("CONTENT_PUBLISH_SELF")
        .setDescription("Content Publish")
        .build();


    public final static ContentOperationData ContentOperation__NA_ = ContentOperationData.newBuilder()
        .setContentOperationId("_NA_")
        .setDescription("Not Applicable")
        .build();


    public final static ContentOperationData ContentOperation_HAS_OWNER_ROLE = ContentOperationData.newBuilder()
        .setContentOperationId("HAS_OWNER_ROLE")
        .setDescription("Has User Role")
        .build();


    public final static ContentOperationData ContentOperation_HAS_USER_ROLE = ContentOperationData.newBuilder()
        .setContentOperationId("HAS_USER_ROLE")
        .setDescription("Has User Role")
        .build();


    public final static ContentOperationData ContentOperation_HAS_AUTHOR_ROLE = ContentOperationData.newBuilder()
        .setContentOperationId("HAS_AUTHOR_ROLE")
        .setDescription("Has Author Role")
        .build();


    public final static ContentOperationData ContentOperation_HAS_EDITOR_ROLE = ContentOperationData.newBuilder()
        .setContentOperationId("HAS_EDITOR_ROLE")
        .setDescription("Has Editor Role")
        .build();


    public final static ContentOperationData ContentOperation_HAS_ADMIN_ROLE = ContentOperationData.newBuilder()
        .setContentOperationId("HAS_ADMIN_ROLE")
        .setDescription("Has Admin Role")
        .build();


    public final static ContentOperationData ContentOperation_HAS_PUBLISHER_ROLE = ContentOperationData.newBuilder()
        .setContentOperationId("HAS_PUBLISHER_ROLE")
        .setDescription("Has Publisher Role")
        .build();


    public final static ContentOperationData ContentOperation_CONTENT_CREATE_SUB = ContentOperationData.newBuilder()
        .setContentOperationId("CONTENT_CREATE_SUB")
        .setDescription("Create SubContent")
        .build();


    public final static ContentOperationData ContentOperation_CONTENT_VIEW_SHORT = ContentOperationData.newBuilder()
        .setContentOperationId("CONTENT_VIEW_SHORT")
        .setDescription("View Short Desc")
        .build();


    public final static ContentOperationData ContentOperation_CHILD_CREATE = ContentOperationData.newBuilder()
        .setContentOperationId("CHILD_CREATE")
        .setDescription("Child Create")
        .build();


    public final static ContentOperationData ContentOperation_CHILD_UPDATE = ContentOperationData.newBuilder()
        .setContentOperationId("CHILD_UPDATE")
        .setDescription("Child Update")
        .build();


    public final static ContentOperationData ContentOperation_CHILD_DELETE = ContentOperationData.newBuilder()
        .setContentOperationId("CHILD_DELETE")
        .setDescription("Child Delete")
        .build();


    public final static ContentOperationData ContentOperation_CHILD_VIEW = ContentOperationData.newBuilder()
        .setContentOperationId("CHILD_VIEW")
        .setDescription("Child View")
        .build();


    public final static ContentOperationData ContentOperation_CONTENT_LINK = ContentOperationData.newBuilder()
        .setContentOperationId("CONTENT_LINK")
        .setDescription("Content Link")
        .build();


    public final static ContentOperationData ContentOperation_CONTENT_LINK_TO = ContentOperationData.newBuilder()
        .setContentOperationId("CONTENT_LINK_TO")
        .setDescription("Content Link To")
        .build();


    public final static ContentOperationData ContentOperation_CONTENT_LINK_FROM = ContentOperationData.newBuilder()
        .setContentOperationId("CONTENT_LINK_FROM")
        .setDescription("Content Link From")
        .build();


    public final static EnumerationTypeData EnumerationType_CONTENT_PRIVILEGE = EnumerationTypeData.newBuilder()
        .setDescription("Content Privilege")
        .setEnumTypeId("CONTENT_PRIVILEGE")
        .build();


    public final static EnumerationTypeData EnumerationType_SUBSCRIPTION_TYPE = EnumerationTypeData.newBuilder()
        .setDescription("Subscription Level")
        .setEnumTypeId("SUBSCRIPTION_TYPE")
        .build();


    public final static DocumentTypeData DocumentType_SHIPPING_DOCUMENT = DocumentTypeData.newBuilder()
        .setDescription("Shipping")
        .setDocumentTypeId("SHIPPING_DOCUMENT")
        .setHasTable(castIndicator("Y"))
        .build();


    public final static DocumentTypeData DocumentType_BILL_OF_LADING = DocumentTypeData.newBuilder()
        .setDescription("Bill Of Lading")
        .setDocumentTypeId("BILL_OF_LADING")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("SHIPPING_DOCUMENT")
        .build();


    public final static DocumentTypeData DocumentType_EXPORT_DOCUMENTATION = DocumentTypeData.newBuilder()
        .setDescription("Export")
        .setDocumentTypeId("EXPORT_DOCUMENTATION")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("SHIPPING_DOCUMENT")
        .build();


    public final static DocumentTypeData DocumentType_HAZ_MAT_DOCUMENT = DocumentTypeData.newBuilder()
        .setDescription("Haz Mat")
        .setDocumentTypeId("HAZ_MAT_DOCUMENT")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("SHIPPING_DOCUMENT")
        .build();


    public final static DocumentTypeData DocumentType_MANIFEST = DocumentTypeData.newBuilder()
        .setDescription("Manifest")
        .setDocumentTypeId("MANIFEST")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("SHIPPING_DOCUMENT")
        .build();


    public final static DocumentTypeData DocumentType_OTHER_SHIP_DOCUMENT = DocumentTypeData.newBuilder()
        .setDescription("Other Shipping")
        .setDocumentTypeId("OTHER_SHIP_DOCUMENT")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("SHIPPING_DOCUMENT")
        .build();


    public final static DocumentTypeData DocumentType_PACKAGING_SLIP = DocumentTypeData.newBuilder()
        .setDescription("Packing Slip")
        .setDocumentTypeId("PACKAGING_SLIP")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("SHIPPING_DOCUMENT")
        .build();


    public final static DocumentTypeData DocumentType_PORT_CHARGE_DOCUMENT = DocumentTypeData.newBuilder()
        .setDescription("Port Charge")
        .setDocumentTypeId("PORT_CHARGE_DOCUMENT")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("SHIPPING_DOCUMENT")
        .build();


    public final static DocumentTypeData DocumentType_TAX_TARIFF_DOCUMENT = DocumentTypeData.newBuilder()
        .setDescription("Tax Tariff")
        .setDocumentTypeId("TAX_TARIFF_DOCUMENT")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("SHIPPING_DOCUMENT")
        .build();


    public final static DataResourceData DataResource_STDWRAP001 = DataResourceData.newBuilder()
        .setDataResourceId("STDWRAP001")
        .setDataResourceName("Standard SubContent Wrapper")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setDataTemplateTypeId("FTL")
        .setMimeTypeId("text/html")
        .build();


    public final static DataResourceData DataResource_BLOG_TPL_TOPLEFT = DataResourceData.newBuilder()
        .setCreatedDate(getTimestamp("2004-01-16 01:24:06.522"))
        .setDataResourceId("BLOG_TPL_TOPLEFT")
        .setDataResourceName("Float left")
        .setDataResourceTypeId("URL_RESOURCE")
        .setDataTemplateTypeId("SCREEN_COMBINED")
        .setLastModifiedDate(getTimestamp("2004-01-16 19:20:58.891"))
        .setMimeTypeId("text/html")
        .setObjectInfo("component://ecommerce/widget/blog/BlogTemplates.xml#FloatLeft")
        .build();


    public final static DataResourceData DataResource_BLOG_TPL_TOPCENTER = DataResourceData.newBuilder()
        .setCreatedDate(getTimestamp("2004-01-16 01:24:06.522"))
        .setDataResourceId("BLOG_TPL_TOPCENTER")
        .setDataResourceName("Top centered")
        .setDataResourceTypeId("URL_RESOURCE")
        .setDataTemplateTypeId("SCREEN_COMBINED")
        .setLastModifiedDate(getTimestamp("2004-01-16 19:20:58.891"))
        .setMimeTypeId("text/html")
        .setObjectInfo("component://ecommerce/widget/blog/BlogTemplates.xml#TopCenter")
        .build();


    public final static DataResourceData DataResource_ECOM_BLANK = DataResourceData.newBuilder()
        .setCreatedDate(getTimestamp("2004-01-16 01:24:06.522"))
        .setDataCategoryId("TEMPLATE")
        .setDataResourceId("ECOM_BLANK")
        .setDataResourceName("Plain Decorator")
        .setDataResourceTypeId("URL_RESOURCE")
        .setDataTemplateTypeId("SCREEN_COMBINED")
        .setLastModifiedDate(getTimestamp("2004-01-16 19:20:58.891"))
        .setMimeTypeId("text/html")
        .setObjectInfo("component://ecommerce/widget/CommonScreens.xml#CommonEmptyDecorator")
        .build();


    public final static DataResourceData DataResource_ECOM_LEFT = DataResourceData.newBuilder()
        .setCreatedDate(getTimestamp("2004-01-16 01:24:06.522"))
        .setDataCategoryId("TEMPLATE")
        .setDataResourceId("ECOM_LEFT")
        .setDataResourceName("Left Decorator")
        .setDataResourceTypeId("URL_RESOURCE")
        .setDataTemplateTypeId("SCREEN_COMBINED")
        .setLastModifiedDate(getTimestamp("2004-01-16 19:20:58.891"))
        .setMimeTypeId("text/html")
        .setObjectInfo("component://ecommerce/widget/CommonScreens.xml#CommonLeftDecorator")
        .build();


    public final static DataResourceData DataResource_ECOM_RIGHT = DataResourceData.newBuilder()
        .setCreatedDate(getTimestamp("2004-01-16 01:24:06.522"))
        .setDataCategoryId("TEMPLATE")
        .setDataResourceId("ECOM_RIGHT")
        .setDataResourceName("Right Decorator")
        .setDataResourceTypeId("URL_RESOURCE")
        .setDataTemplateTypeId("SCREEN_COMBINED")
        .setLastModifiedDate(getTimestamp("2004-01-16 19:20:58.891"))
        .setMimeTypeId("text/html")
        .setObjectInfo("component://ecommerce/widget/CommonScreens.xml#CommonRightDecorator")
        .build();


    public final static DataResourceData DataResource_ECOM_LEFTRIGHT = DataResourceData.newBuilder()
        .setCreatedDate(getTimestamp("2004-01-16 01:24:06.522"))
        .setDataCategoryId("TEMPLATE")
        .setDataResourceId("ECOM_LEFTRIGHT")
        .setDataResourceName("Left/Right Decorator")
        .setDataResourceTypeId("URL_RESOURCE")
        .setDataTemplateTypeId("SCREEN_COMBINED")
        .setLastModifiedDate(getTimestamp("2004-01-16 19:20:58.891"))
        .setMimeTypeId("text/html")
        .setObjectInfo("component://ecommerce/widget/CommonScreens.xml#CommonLeftRightDecorator")
        .build();


    public final static DataResourceData DataResource_WRAP_STD_LOOP = DataResourceData.newBuilder()
        .setDataResourceId("WRAP_STD_LOOP")
        .setDataResourceName("Loop Wrap")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setDataTemplateTypeId("FTL")
        .setMimeTypeId("text/html")
        .build();


    public final static DataResourceData DataResource_AFIBC_LOGO = DataResourceData.newBuilder()
        .setDataResourceId("AFIBC_LOGO")
        .setDataResourceName("SFIBC Logo")
        .setDataResourceTypeId("IMAGE_OBJECT")
        .setDataTemplateTypeId("NONE")
        .setObjectInfo("sfibc_logo.png")
        .build();


    public final static DataResourceData DataResource_AGEP_LOGO = DataResourceData.newBuilder()
        .setDataResourceId("AGEP_LOGO")
        .setDataResourceName("AGEP Logo")
        .setDataResourceTypeId("IMAGE_OBJECT")
        .setDataTemplateTypeId("NONE")
        .setObjectInfo("agep_logo.png")
        .build();


    public final static DataResourceData DataResource_AGINC_LOGO = DataResourceData.newBuilder()
        .setDataResourceId("AGINC_LOGO")
        .setDataResourceName("AGINC Logo")
        .setDataResourceTypeId("IMAGE_OBJECT")
        .setDataTemplateTypeId("NONE")
        .setObjectInfo("aginc_logo.png")
        .build();


    public final static DataResourceData DataResource_ARTICLE_WRAP = DataResourceData.newBuilder()
        .setDataResourceId("ARTICLE_WRAP")
        .setDataResourceTypeId("OFBIZ_FILE")
        .setDataTemplateTypeId("FTL")
        .build();


    public final static DataResourceData DataResource_LEFTBAR = DataResourceData.newBuilder()
        .setDataResourceId("LEFTBAR")
        .setDataResourceName("Left Bar")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setDataTemplateTypeId("FTL")
        .setObjectInfo("LEFT BAR")
        .build();


    public final static DataResourceData DataResource_RP_MEDAL = DataResourceData.newBuilder()
        .setDataResourceId("RP_MEDAL")
        .setDataResourceName("Project Reliance Medallion Logo")
        .setDataResourceTypeId("IMAGE_OBJECT")
        .setDataTemplateTypeId("NONE")
        .setObjectInfo("pr_medal.png")
        .build();


    public final static DataResourceData DataResource_TMPLT_IMG_CENTER = DataResourceData.newBuilder()
        .setDataResourceId("TMPLT_IMG_CENTER")
        .setDataResourceName("Image Centered")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setDataTemplateTypeId("FTL")
        .setMimeTypeId("text/html")
        .build();


    public final static DataResourceData DataResource_TEMPLATE_IMAGE_LEFT = DataResourceData.newBuilder()
        .setDataResourceId("TEMPLATE_IMAGE_LEFT")
        .setDataResourceName("Image Left")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setDataTemplateTypeId("FTL")
        .setMimeTypeId("text/html")
        .build();


    public final static DataResourceData DataResource_TEMPLATE_TEXT_ONLY = DataResourceData.newBuilder()
        .setDataResourceId("TEMPLATE_TEXT_ONLY")
        .setDataResourceName("Template Text")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setDataTemplateTypeId("FTL")
        .setMimeTypeId("text/html")
        .build();


    public final static DataResourceData DataResource_VIEW_WRAP = DataResourceData.newBuilder()
        .setDataResourceId("VIEW_WRAP")
        .setDataResourceTypeId("OFBIZ_FILE")
        .setDataTemplateTypeId("FTL")
        .build();


    public final static DataResourceData DataResource_WRAP_ARTICLE = DataResourceData.newBuilder()
        .setDataResourceId("WRAP_ARTICLE")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setDataTemplateTypeId("FTL")
        .build();


    public final static DataResourceData DataResource_WRAP_ARTICLE_TABLE = DataResourceData.newBuilder()
        .setDataResourceId("WRAP_ARTICLE_TABLE")
        .setDataResourceName("Article wrap with table elements")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setDataTemplateTypeId("FTL")
        .build();


    public final static DataResourceData DataResource_WRAP_NEXT_PREV = DataResourceData.newBuilder()
        .setDataResourceId("WRAP_NEXT_PREV")
        .setDataResourceName("Next/Prev wrapper")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setDataTemplateTypeId("FTL")
        .build();


    public final static DataResourceData DataResource_WRAP_STD_001 = DataResourceData.newBuilder()
        .setDataResourceId("WRAP_STD_001")
        .setDataResourceName("Standard SubContent Wrapper")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setDataTemplateTypeId("FTL")
        .setMimeTypeId("text/html")
        .build();


    public final static DataResourceData DataResource_WRAP_VIEW = DataResourceData.newBuilder()
        .setDataResourceId("WRAP_VIEW")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setDataTemplateTypeId("FTL")
        .build();


    public final static DataResourceData DataResource_IMAGE_CENTERED = DataResourceData.newBuilder()
        .setDataResourceId("IMAGE_CENTERED")
        .setDataResourceName("Image Centered")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setDataTemplateTypeId("FTL")
        .setMimeTypeId("text/html")
        .build();


    public final static DataResourceData DataResource_IMAGE_LEFT = DataResourceData.newBuilder()
        .setDataResourceId("IMAGE_LEFT")
        .setDataResourceName("Image Left")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setDataTemplateTypeId("FTL")
        .setMimeTypeId("text/html")
        .build();


    public final static DataResourceData DataResource_TEMPLATE_TEXT = DataResourceData.newBuilder()
        .setDataResourceId("TEMPLATE_TEXT")
        .setDataResourceName("Template Text")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setDataTemplateTypeId("FTL")
        .setMimeTypeId("text/html")
        .build();


    public final static DataResourceData DataResource_TMPLT_IMG_CENTER_FL = DataResourceData.newBuilder()
        .setDataResourceId("TMPLT_IMG_CENTER_FL")
        .setDataResourceName("Image Centered")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setDataTemplateTypeId("FTL")
        .setMimeTypeId("text/html")
        .build();


    public final static DataResourceData DataResource_TEMPLATE_COMPOSITE = DataResourceData.newBuilder()
        .setDataResourceId("TEMPLATE_COMPOSITE")
        .setDataResourceTypeId("CONTEXT_FILE")
        .setDataTemplateTypeId("FTL")
        .setObjectInfo("/content/TemplateComposite.ftl")
        .build();


    public final static DataResourceData DataResource_HELP_TEMPL = DataResourceData.newBuilder()
        .setDataResourceId("HELP_TEMPL")
        .setDataResourceName("Help template file")
        .setDataResourceTypeId("OFBIZ_FILE")
        .setDataTemplateTypeId("FTL")
        .setIsPublic(castIndicator("Y"))
        .setMimeTypeId("text/html")
        .setObjectInfo("applications/content/template/HelpTemplate.ftl")
        .setStatusId("CTNT_IN_PROGRESS")
        .build();


    public final static DataResourceData DataResource_NOCONTENTFOUND = DataResourceData.newBuilder()
        .setCreatedDate(getTimestamp("2004-08-06 11:40:15.818"))
        .setDataResourceId("NOCONTENTFOUND")
        .setDataResourceTypeId("OFBIZ_FILE")
        .setDataTemplateTypeId("NONE")
        .setMimeTypeId("image/png")
        .setObjectInfo("/applications/content/webapp/content/images/nocontentfound.png")
        .build();


    public final static DataResourceData DataResource_NOTEXTFOUND = DataResourceData.newBuilder()
        .setCreatedDate(getTimestamp("2004-08-06 11:40:15.818"))
        .setDataResourceId("NOTEXTFOUND")
        .setDataResourceTypeId("OFBIZ_FILE")
        .setDataTemplateTypeId("NONE")
        .setMimeTypeId("text/html")
        .setObjectInfo("/applications/content/webapp/content/images/notextfound.html")
        .build();


    public final static StatusTypeData StatusType_CNTNTAPPR_STATUS = StatusTypeData.newBuilder()
        .setDescription("Content Approval Status")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("CNTNTAPPR_STATUS")
        .build();


    public final static StatusTypeData StatusType_SERVER_HIT_STATUS = StatusTypeData.newBuilder()
        .setDescription("Server Hit")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("SERVER_HIT_STATUS")
        .build();


    public final static StatusTypeData StatusType_WEB_CONTENT_STATUS = StatusTypeData.newBuilder()
        .setDescription("Web Content")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("WEB_CONTENT_STATUS")
        .build();


    public final static StatusTypeData StatusType_CONTENT_STATUS = StatusTypeData.newBuilder()
        .setDescription("Content")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("CONTENT_STATUS")
        .build();


    public final static ContentData Content_TEMPLATE_MASTER = ContentData.newBuilder()
        .setContentId("TEMPLATE_MASTER")
        .setContentTypeId("TREE_ROOT")
        .setDescription("Template Master")
        .build();


    public final static ContentData Content_STDWRAP001 = ContentData.newBuilder()
        .setContentId("STDWRAP001")
        .setContentName("Standard SubContent Wrapper")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("STDWRAP001")
        .setDescription("Standard SubContent Wrapper")
        .setMimeTypeId("text/html")
        .build();


    public final static ContentData Content_BLOGROOT = ContentData.newBuilder()
        .setChildBranchCount(1)
        .setChildLeafCount(1)
        .setContentId("BLOGROOT")
        .setContentName("Blog Root")
        .setContentTypeId("WEB_SITE_PUB_PT")
        .setDescription("Blog Root")
        .build();


    public final static ContentData Content_LEFTBAR = ContentData.newBuilder()
        .setContentId("LEFTBAR")
        .setContentName("Left Bar")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("LEFTBAR")
        .setDescription("Left Bar")
        .build();


    public final static ContentData Content_OWNER_BLOG_CONTENT = ContentData.newBuilder()
        .setContentId("OWNER_BLOG_CONTENT")
        .setContentName("Blog Content Owner")
        .setContentTypeId("PLACEHOLDER")
        .build();


    public final static ContentData Content_TMPLT_IMG_CENTER = ContentData.newBuilder()
        .setContentId("TMPLT_IMG_CENTER")
        .setContentName("Image Centered")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("IMAGE_CENTERED")
        .setDescription("Image centered above text")
        .setMimeTypeId("text/html")
        .build();


    public final static ContentData Content_TEMPLATE_IMAGE_LEFT = ContentData.newBuilder()
        .setContentId("TEMPLATE_IMAGE_LEFT")
        .setContentName("Image Left")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("IMAGE_LEFT")
        .setDescription("Image with text flowing around")
        .setMimeTypeId("text/html")
        .build();


    public final static ContentData Content_TEMPLATE_TEXT_ONLY = ContentData.newBuilder()
        .setContentId("TEMPLATE_TEXT_ONLY")
        .setContentName("Template Text")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("TEMPLATE_TEXT")
        .setDescription("Template Text Only")
        .setMimeTypeId("text/html")
        .build();


    public final static ContentData Content_VIEW_WRAP = ContentData.newBuilder()
        .setContentId("VIEW_WRAP")
        .setContentName("View Wrap")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("VIEW_WRAP")
        .build();


    public final static ContentData Content_WRAP_ARTICLE = ContentData.newBuilder()
        .setContentId("WRAP_ARTICLE")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("WRAP_ARTICLE")
        .build();


    public final static ContentData Content_WRAP_NEXT_PREV = ContentData.newBuilder()
        .setContentId("WRAP_NEXT_PREV")
        .setContentName("Next-Prev wrapper")
        .setContentTypeId("ANNOTATION")
        .setDataResourceId("WRAP_NEXT_PREV")
        .setDescription("Next and Previous wrapper")
        .build();


    public final static ContentData Content_WRAP_STD_LOOP = ContentData.newBuilder()
        .setContentId("WRAP_STD_LOOP")
        .setContentName("Loop Wrap")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("WRAP_STD_LOOP")
        .setMimeTypeId("text/html")
        .build();


    public final static ContentData Content_WRAP_VIEW = ContentData.newBuilder()
        .setContentId("WRAP_VIEW")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("WRAP_VIEW")
        .build();


    public final static ContentData Content_ARTICLE_WRAP = ContentData.newBuilder()
        .setContentId("ARTICLE_WRAP")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("ARTICLE_WRAP")
        .build();


    public final static ContentData Content_BLOG_MASTER = ContentData.newBuilder()
        .setContentId("BLOG_MASTER")
        .setContentName("Blog Master")
        .setContentTypeId("DOCUMENT")
        .build();


    public final static ContentData Content_NOCONTENTFOUND = ContentData.newBuilder()
        .setContentId("NOCONTENTFOUND")
        .setContentName("No Content Found")
        .setContentTypeId("DOCUMENT")
        .setCreatedDate(getTimestamp("2004-08-06 11:40:15.818"))
        .setDataResourceId("NOCONTENTFOUND")
        .setDescription("No Content Found")
        .build();


    public final static ContentData Content_NOTEXTFOUND = ContentData.newBuilder()
        .setContentId("NOTEXTFOUND")
        .setContentName("No Text Found")
        .setContentTypeId("DOCUMENT")
        .setCreatedDate(getTimestamp("2004-08-06 11:40:15.818"))
        .setDataResourceId("NOTEXTFOUND")
        .setDescription("No Text Found")
        .build();


    public final static DataResourceTypeData DataResourceType_LOCAL_FILE = DataResourceTypeData.newBuilder()
        .setDataResourceTypeId("LOCAL_FILE")
        .setDescription("Local File")
        .setHasTable(castIndicator("N"))
        .build();


    public final static DataResourceTypeData DataResourceType_OFBIZ_FILE = DataResourceTypeData.newBuilder()
        .setDataResourceTypeId("OFBIZ_FILE")
        .setDescription("File (rel to OFBIZ_HOME)")
        .setHasTable(castIndicator("N"))
        .build();


    public final static DataResourceTypeData DataResourceType_CONTEXT_FILE = DataResourceTypeData.newBuilder()
        .setDataResourceTypeId("CONTEXT_FILE")
        .setDescription("File (rel to webapp root)")
        .setHasTable(castIndicator("N"))
        .build();


    public final static DataResourceTypeData DataResourceType_LOCAL_FILE_BIN = DataResourceTypeData.newBuilder()
        .setDataResourceTypeId("LOCAL_FILE_BIN")
        .setDescription("Local Binary File")
        .setHasTable(castIndicator("N"))
        .build();


    public final static DataResourceTypeData DataResourceType_OFBIZ_FILE_BIN = DataResourceTypeData.newBuilder()
        .setDataResourceTypeId("OFBIZ_FILE_BIN")
        .setDescription("Binary File (rel to OFBIZ_HOME)")
        .setHasTable(castIndicator("N"))
        .build();


    public final static DataResourceTypeData DataResourceType_CONTEXT_FILE_BIN = DataResourceTypeData.newBuilder()
        .setDataResourceTypeId("CONTEXT_FILE_BIN")
        .setDescription("Binary File (rel to webapp root)")
        .setHasTable(castIndicator("N"))
        .build();


    public final static DataResourceTypeData DataResourceType_LINK = DataResourceTypeData.newBuilder()
        .setDataResourceTypeId("LINK")
        .setDescription("HyperLink")
        .setHasTable(castIndicator("N"))
        .build();


    public final static DataResourceTypeData DataResourceType_URL_RESOURCE = DataResourceTypeData.newBuilder()
        .setDataResourceTypeId("URL_RESOURCE")
        .setDescription("URL Resource")
        .setHasTable(castIndicator("N"))
        .build();


    public final static DataResourceTypeData DataResourceType_SHORT_TEXT = DataResourceTypeData.newBuilder()
        .setDataResourceTypeId("SHORT_TEXT")
        .setDescription("Short Text")
        .setHasTable(castIndicator("N"))
        .build();


    public final static DataResourceTypeData DataResourceType_ELECTRONIC_TEXT = DataResourceTypeData.newBuilder()
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setDescription("Long Text")
        .setHasTable(castIndicator("Y"))
        .build();


    public final static DataResourceTypeData DataResourceType_AUDIO_OBJECT = DataResourceTypeData.newBuilder()
        .setDataResourceTypeId("AUDIO_OBJECT")
        .setDescription("Audio")
        .setHasTable(castIndicator("Y"))
        .build();


    public final static DataResourceTypeData DataResourceType_IMAGE_OBJECT = DataResourceTypeData.newBuilder()
        .setDataResourceTypeId("IMAGE_OBJECT")
        .setDescription("Image")
        .setHasTable(castIndicator("Y"))
        .build();


    public final static DataResourceTypeData DataResourceType_OTHER_OBJECT = DataResourceTypeData.newBuilder()
        .setDataResourceTypeId("OTHER_OBJECT")
        .setDescription("Other")
        .setHasTable(castIndicator("Y"))
        .build();


    public final static DataResourceTypeData DataResourceType_VIDEO_OBJECT = DataResourceTypeData.newBuilder()
        .setDataResourceTypeId("VIDEO_OBJECT")
        .setDescription("Video")
        .setHasTable(castIndicator("Y"))
        .build();


    public final static DataResourceTypeData DataResourceType_SURVEY = DataResourceTypeData.newBuilder()
        .setDataResourceTypeId("SURVEY")
        .setDescription("Survey")
        .setHasTable(castIndicator("N"))
        .build();


    public final static DataResourceTypeData DataResourceType_SURVEY_RESPONSE = DataResourceTypeData.newBuilder()
        .setDataResourceTypeId("SURVEY_RESPONSE")
        .setDescription("Survey Response")
        .setHasTable(castIndicator("N"))
        .build();

}

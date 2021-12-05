package com.bluecc.hubs.stereotypes;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.stereotypes.ContentSeedData.*;import com.bluecc.hubs.stub.ContentAssocTypeData;
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

public final class ContentSeedDataList {
    public static final List<ContentAssocTypeData> contentAssocTypeList=ImmutableList.of(        
            ContentAssocType_TEMPLATE_MEMBER,        
            ContentAssocType_STRUCTURE_DEF,        
            ContentAssocType_TXFORM_DEF,        
            ContentAssocType_LIST_ENTRY,        
            ContentAssocType_TREE_CHILD,        
            ContentAssocType_GRAPH_LINK,        
            ContentAssocType_ALTERNATE_LOCALE,        
            ContentAssocType_ALTERNATE_ROLE,        
            ContentAssocType_RESPONSE,        
            ContentAssocType_SUB_CONTENT,        
            ContentAssocType_TOPIC,        
            ContentAssocType_DESCRIPTION,        
            ContentAssocType_SUBSITE,        
            ContentAssocType_DEPARTMENT,        
            ContentAssocType_RELATED_CONTENT,        
            ContentAssocType_PUBLISH_LINK,        
            ContentAssocType_ATTRIBUTE,        
            ContentAssocType_AUTHOR,        
            ContentAssocType_SUMMARY,        
            ContentAssocType_INSTANCE,        
            ContentAssocType_ALTERNATIVE_URL);

    public static final List<ContentPurposeOperationData> contentPurposeOperationList=ImmutableList.of(        
            ContentPurposeOperation_ARTICLE_CONTENT_CREATE_CONTENT_AUTHOR_CTNT_PUBLISHED_CNT_PRV_NA_,        
            ContentPurposeOperation_ARTICLE_CONTENT_CREATE_CONTENT_AUTHOR__NA__CNT_PRV_NA_,        
            ContentPurposeOperation_ARTICLE_CONTENT_CREATE_CONTENT_EDITOR__NA__CNT_PRV_NA_,        
            ContentPurposeOperation_ARTICLE_CONTENT_CREATE_SUB_OWNER__NA__CNT_PRV_NA_,        
            ContentPurposeOperation_ARTICLE_CONTENT_UPDATE_CONTENT_AUTHOR__NA__CNT_PRV_NA_,        
            ContentPurposeOperation_ARTICLE_CONTENT_UPDATE_CONTENT_EDITOR__NA__CNT_PRV_NA_,        
            ContentPurposeOperation_ARTICLE_CONTENT_UPDATE_OWNER_CTNT_INITIAL_DRAFT_CNT_PRV_NA_,        
            ContentPurposeOperation_ARTICLE_CONTENT_PUBLISH_CONTENT_EDITOR__NA__CNT_PRV_NA_,        
            ContentPurposeOperation_ARTICLE_CONTENT_PUBLISH_CONTENT_PUBLISHER_CTNT_PUBLISHED_CNT_PRV_NA_,        
            ContentPurposeOperation_ARTICLE_CONTENT_PUBLISH_OWNER__NA__CNT_PRV_NA_,        
            ContentPurposeOperation_ARTICLE_CONTENT_PUBLISH_SELF_CONTENT_AUTHOR_CTNT_PUBLISHED_CNT_PRV_NA_,        
            ContentPurposeOperation_ARTICLE_CONTENT_RESPOND_CONTENT_USER_CTNT_PUBLISHED_CNT_PRV_NA_,        
            ContentPurposeOperation_ARTICLE_CONTENT_VIEW_CONTENT_AUTHOR_CTNT_PUBLISHED_CNT_PRV_NA_,        
            ContentPurposeOperation_ARTICLE_CONTENT_VIEW_CONTENT_EDITOR__NA__CNT_PRV_NA_,        
            ContentPurposeOperation_ARTICLE_CONTENT_VIEW_OWNER_CTNT_INITIAL_DRAFT_CNT_PRV_NA_,        
            ContentPurposeOperation_ARTICLE_CONTENT_LINK_FROM__NA___NA__CNT_PRV_NA_,        
            ContentPurposeOperation_ARTICLE_CONTENT_LINK_TO__NA___NA__CNT_PRV_NA_,        
            ContentPurposeOperation_RESPONSE_CONTENT_CREATE_CONTENT_EDITOR__NA__CNT_PRV_NA_,        
            ContentPurposeOperation_RESPONSE_CONTENT_UPDATE_CONTENT_EDITOR__NA__CNT_PRV_NA_,        
            ContentPurposeOperation_RESPONSE_CONTENT_UPDATE_OWNER__NA__CNT_PRV_NA_,        
            ContentPurposeOperation_RESPONSE_CONTENT_PUBLISH_CONTENT_PUBLISHER_CTNT_PUBLISHED_CNT_PRV_NA_,        
            ContentPurposeOperation_RESPONSE_CONTENT_PUBLISH_CONTENT_USER_CTNT_PUBLISHED_CNT_PRV_NA_,        
            ContentPurposeOperation_RESPONSE_CONTENT_RESPOND_CONTENT_USER_CTNT_PUBLISHED_CNT_PRV_NA_,        
            ContentPurposeOperation_RESPONSE_CONTENT_LINK_FROM__NA___NA__CNT_PRV_NA_,        
            ContentPurposeOperation_RESPONSE_CONTENT_LINK_TO__NA___NA__CNT_PRV_NA_,        
            ContentPurposeOperation_SECTION_CONTENT_UPDATE_CONTENT_AUTHOR__NA__CNT_PRV_NA_,        
            ContentPurposeOperation_SECTION_CONTENT_UPDATE_CONTENT_EDITOR__NA__CNT_PRV_NA_,        
            ContentPurposeOperation_SECTION_CONTENT_UPDATE_OWNER_CTNT_INITIAL_DRAFT_CNT_PRV_NA_,        
            ContentPurposeOperation_SECTION_CONTENT_PUBLISH_CONTENT_EDITOR__NA__CNT_PRV_NA_,        
            ContentPurposeOperation_SECTION_CONTENT_PUBLISH_CONTENT_PUBLISHER_CTNT_PUBLISHED_CNT_PRV_NA_,        
            ContentPurposeOperation_SECTION_CONTENT_PUBLISH_OWNER__NA__CNT_PRV_NA_,        
            ContentPurposeOperation_SECTION_CONTENT_VIEW_CONTENT_AUTHOR__NA__CNT_PRV_NA_,        
            ContentPurposeOperation_SECTION_CONTENT_VIEW_CONTENT_EDITOR__NA__CNT_PRV_NA_,        
            ContentPurposeOperation_SECTION_CONTENT_VIEW_OWNER__NA__CNT_PRV_NA_,        
            ContentPurposeOperation_SECTION_CONTENT_VIEW__NA__CTNT_PUBLISHED_CNT_PRV_NA_,        
            ContentPurposeOperation_USER_CONTENT_UPDATE_OWNER__NA__CNT_PRV_NA_,        
            ContentPurposeOperation__NA__HAS_OWNER_ROLE_OWNER__NA__CNT_PRV_NA_,        
            ContentPurposeOperation__NA__HAS_USER_ROLE_CONTENT_USER__NA__CNT_PRV_NA_,        
            ContentPurposeOperation__NA__HAS_AUTHOR_ROLE_CONTENT_AUTHOR__NA__CNT_PRV_NA_,        
            ContentPurposeOperation__NA__HAS_EDITOR_ROLE_CONTENT_EDITOR__NA__CNT_PRV_NA_,        
            ContentPurposeOperation__NA__HAS_ADMIN_ROLE_CONTENT_ADMIN__NA__CNT_PRV_NA_,        
            ContentPurposeOperation__NA__HAS_PUBLISHER_ROLE_CONTENT_PUBLISHER__NA__CNT_PRV_NA_,        
            ContentPurposeOperation__NA__CONTENT_PUBLISH_CONTENT_PUBLISHER__NA__CNT_PRV_NA_,        
            ContentPurposeOperation__NA__CONTENT_VIEW_CONTENT_ADMIN__NA__CNT_PRV_NA_,        
            ContentPurposeOperation__NA__CONTENT_VIEW_CONTENT_USER_CTNT_PUBLISHED_CNT_PRV_NA_,        
            ContentPurposeOperation__NA__CONTENT_LINK_TO_OWNER__NA__CNT_PRV_NA_,        
            ContentPurposeOperation__NA__CONTENT_LINK_FROM_OWNER__NA__CNT_PRV_NA_,        
            ContentPurposeOperation__NA__CONTENT_LINK_TO_CONTENT_ADMIN__NA__CNT_PRV_NA_,        
            ContentPurposeOperation__NA__CONTENT_LINK_FROM_CONTENT_ADMIN__NA__CNT_PRV_NA_,        
            ContentPurposeOperation__NA___NA__CONTENT_ADMIN__NA__CNT_PRV_NA_,        
            ContentPurposeOperation__NA__CONTENT_ADMIN_CONTENT_ADMIN__NA__CNT_PRV_NA_,        
            ContentPurposeOperation__NA__CONTENT_UPDATE_CONTENT_ADMIN__NA__CNT_PRV_NA_,        
            ContentPurposeOperation_RESPONSE_CONTENT_CREATE__NA___NA__CNT_PRV_NA_);

    public static final List<DataCategoryData> dataCategoryList=ImmutableList.of(        
            DataCategory_ROOT,        
            DataCategory_BUSINESS,        
            DataCategory_TECHNOLOGY,        
            DataCategory_PERSONAL,        
            DataCategory_LEGAL,        
            DataCategory_POLITICAL,        
            DataCategory_FINANCIAL,        
            DataCategory_BUS_RETAIL,        
            DataCategory_BUS_SERVICE,        
            DataCategory_BUS_MANU,        
            DataCategory_TECH_SOFT,        
            DataCategory_TECH_SOFT_OFBIZ,        
            DataCategory_TECH_SOFT_LINUX,        
            DataCategory_TECH_SOFT_JAVA,        
            DataCategory_TECH_HARD,        
            DataCategory_TECH_SERV,        
            DataCategory_TEMPLATE);

    public static final List<ContentTypeData> contentTypeList=ImmutableList.of(        
            ContentType_DOCUMENT,        
            ContentType_TEMPLATE,        
            ContentType_DECORATOR,        
            ContentType_ANNOTATION,        
            ContentType_MENU_CONTAINER,        
            ContentType_OUTLINE_NODE,        
            ContentType_PAGE_NODE,        
            ContentType_SUBPAGE_NODE,        
            ContentType_CONTENT_LIST,        
            ContentType_TREE_ROOT,        
            ContentType_GRAPH_ROOT,        
            ContentType_STRUCTURE_NODE,        
            ContentType_STRUCTURE_LEAF,        
            ContentType_STRUCTURE_DEF,        
            ContentType_TXFORM_DEF,        
            ContentType_PLACEHOLDER,        
            ContentType_WEB_SITE_PUB_PT,        
            ContentType_FORUM_ROOT,        
            ContentType_BLOG_ROOT,        
            ContentType_FAQ_ROOT,        
            ContentType_DEPARTMENT,        
            ContentType_PEOPLE,        
            ContentType_PERSON,        
            ContentType_TOPIC);

    public static final List<ElectronicTextData> electronicTextList=ImmutableList.of(        
            ElectronicText_STDWRAP001,        
            ElectronicText_LEFTBAR,        
            ElectronicText_TMPLT_IMG_CENTER,        
            ElectronicText_TEMPLATE_IMAGE_LEFT,        
            ElectronicText_TEMPLATE_TEXT_ONLY,        
            ElectronicText_WRAP_ARTICLE,        
            ElectronicText_WRAP_ARTICLE_TABLE,        
            ElectronicText_WRAP_NEXT_PREV,        
            ElectronicText_WRAP_STD_001,        
            ElectronicText_WRAP_STD_LOOP,        
            ElectronicText_WRAP_VIEW,        
            ElectronicText_IMAGE_CENTERED,        
            ElectronicText_IMAGE_LEFT,        
            ElectronicText_TEMPLATE_TEXT,        
            ElectronicText_TMPLT_IMG_CENTER_FL);

    public static final List<RoleTypeData> roleTypeList=ImmutableList.of(        
            RoleType_LOGGEDIN,        
            RoleType_CONTENT,        
            RoleType_CONTENT_ADMIN,        
            RoleType_CONTENT_PUBLISHER,        
            RoleType_CONTENT_EDITOR,        
            RoleType_CONTENT_AUTHOR,        
            RoleType_CONTENT_USER,        
            RoleType_CONTENT_GUEST);

    public static final List<MetaDataPredicateData> metaDataPredicateList=ImmutableList.of(        
            MetaDataPredicate_author_name,        
            MetaDataPredicate_author_email,        
            MetaDataPredicate_event_date,        
            MetaDataPredicate_event_location,        
            MetaDataPredicate_event_person_name);

    public static final List<MimeTypeData> mimeTypeList=ImmutableList.of(        
            MimeType_application_octet_stream,        
            MimeType_application_pkcs7_signature,        
            MimeType_application_postscript,        
            MimeType_application_zip,        
            MimeType_application_pdf,        
            MimeType_application_msword,        
            MimeType_application_x_shockwave_flash,        
            MimeType_application_x_zip_compressed,        
            MimeType_application_x_tgz,        
            MimeType_application_vnd_oasis_opendocument_text,        
            MimeType_application_vnd_oasis_opendocument_spreadsheet,        
            MimeType_application_vnd_ofbiz_survey,        
            MimeType_application_vnd_ofbiz_survey_response,        
            MimeType_application_vnd_ms_powerpoint,        
            MimeType_application_vnd_ms_excel,        
            MimeType_audio_basic,        
            MimeType_audio_mpeg,        
            MimeType_audio_mp4,        
            MimeType_audio_x_ms_wax,        
            MimeType_audio_wav,        
            MimeType_audio_ogg,        
            MimeType_audio_x_ogg,        
            MimeType_audio_vorbis,        
            MimeType_audio_x_flac,        
            MimeType_audio_flac,        
            MimeType_image_jpeg,        
            MimeType_image_pjpeg,        
            MimeType_image_gif,        
            MimeType_image_tiff,        
            MimeType_image_png,        
            MimeType_image_svg_xml,        
            MimeType_message_external_body,        
            MimeType_message_http,        
            MimeType_message_s_http,        
            MimeType_message_news,        
            MimeType_message_partial,        
            MimeType_message_rfc822,        
            MimeType_model_mesh,        
            MimeType_model_vrml,        
            MimeType_multipart_alternative,        
            MimeType_multipart_digest,        
            MimeType_multipart_encrypted,        
            MimeType_multipart_form_data,        
            MimeType_multipart_mixed,        
            MimeType_multipart_related,        
            MimeType_multipart_signed,        
            MimeType_text_css,        
            MimeType_text_csv,        
            MimeType_text_enriched,        
            MimeType_text_html,        
            MimeType_text_plain,        
            MimeType_text_rtf,        
            MimeType_text_richtext,        
            MimeType_text_sgml,        
            MimeType_text_tab_separated_values,        
            MimeType_text_x_diff,        
            MimeType_text_xml,        
            MimeType_text_x_vcard,        
            MimeType_video_avi,        
            MimeType_video_mpeg,        
            MimeType_video_mp4,        
            MimeType_video_quicktime,        
            MimeType_video_x_ms_asf,        
            MimeType_video_x_flv,        
            MimeType_video_x_ms_wvx,        
            MimeType_video_x_ms_wm,        
            MimeType_video_x_ms_wmv,        
            MimeType_video_x_ms_wmx,        
            MimeType_video_3gpp);

    public static final List<WebSiteContentTypeData> webSiteContentTypeList=ImmutableList.of(        
            WebSiteContentType_BLOG_ROOT,        
            WebSiteContentType_DEFAULT_PAGE,        
            WebSiteContentType_FORUM_ROOT,        
            WebSiteContentType_MENU_ROOT,        
            WebSiteContentType_ERROR_ROOT,        
            WebSiteContentType_PUBLISH_POINT,        
            WebSiteContentType_WEB_PAGE,        
            WebSiteContentType_MAINTENANCE_PAGE);

    public static final List<WebAnalyticsTypeData> webAnalyticsTypeList=ImmutableList.of(        
            WebAnalyticsType_WEB_ANALYTICS,        
            WebAnalyticsType_GOOGLE_ANALYTICS,        
            WebAnalyticsType_BING_ANALYTICS,        
            WebAnalyticsType_BACKEND_ANALYTICS);

    public static final List<StatusItemData> statusItemList=ImmutableList.of(        
            StatusItem_CNTAP_NOT_READY,        
            StatusItem_CNTAP_READY,        
            StatusItem_CNTAP_IN_PROCESS,        
            StatusItem_CNTAP_SOFT_REJ,        
            StatusItem_CNTAP_REJECTED,        
            StatusItem_CNTAP_APPROVED,        
            StatusItem_CTNT_IN_PROGRESS,        
            StatusItem_CTNT_INITIAL_DRAFT,        
            StatusItem_CTNT_REVISED_DRAFT,        
            StatusItem_CTNT_FINAL_DRAFT,        
            StatusItem_CTNT_PUBLISHED,        
            StatusItem_CTNT_DEACTIVATED,        
            StatusItem_CTNT_AVAILABLE);

    public static final List<StatusValidChangeData> statusValidChangeList=ImmutableList.of(        
            StatusValidChange_CTNT_IN_PROGRESS_CTNT_INITIAL_DRAFT,        
            StatusValidChange_CTNT_IN_PROGRESS_CTNT_PUBLISHED,        
            StatusValidChange_CTNT_IN_PROGRESS_CTNT_AVAILABLE,        
            StatusValidChange_CTNT_IN_PROGRESS_IM_PENDING,        
            StatusValidChange_CTNT_INITIAL_DRAFT_CTNT_REVISED_DRAFT,        
            StatusValidChange_CTNT_INITIAL_DRAFT_CTNT_PUBLISHED,        
            StatusValidChange_CTNT_REVISED_DRAFT_CTNT_FINAL_DRAFT,        
            StatusValidChange_CTNT_REVISED_DRAFT_CTNT_PUBLISHED,        
            StatusValidChange_CTNT_FINAL_DRAFT_CTNT_PUBLISHED,        
            StatusValidChange_CTNT_PUBLISHED_CTNT_DEACTIVATED,        
            StatusValidChange_CTNT_AVAILABLE_CTNT_DEACTIVATED);

    public static final List<SubscriptionTypeData> subscriptionTypeList=ImmutableList.of(        
            SubscriptionType_NEWSGROUP_SUBSCR,        
            SubscriptionType_OTHER_SUBSCR,        
            SubscriptionType_PRODUCT_INFO_SUBSCR);

    public static final List<ContentPurposeTypeData> contentPurposeTypeList=ImmutableList.of(        
            ContentPurposeType_ARTICLE,        
            ContentPurposeType_MESSAGE,        
            ContentPurposeType_FEEDBACK,        
            ContentPurposeType_COMMENT,        
            ContentPurposeType_PRODUCT_INFO,        
            ContentPurposeType_PROJECT_INFO,        
            ContentPurposeType_COMPANY_INFO,        
            ContentPurposeType_ADVERTISEMENT,        
            ContentPurposeType_GENERAL_INFO,        
            ContentPurposeType_LEGAL_INFO,        
            ContentPurposeType_DESCRIPTION,        
            ContentPurposeType_OWNER,        
            ContentPurposeType_RESPONSE,        
            ContentPurposeType__NA_,        
            ContentPurposeType_SECTION,        
            ContentPurposeType_TOPIC,        
            ContentPurposeType_SUMMARY,        
            ContentPurposeType_MAIN_ARTICLE,        
            ContentPurposeType_SUB_ARTICLE,        
            ContentPurposeType_USER,        
            ContentPurposeType_FAQ,        
            ContentPurposeType_SOURCE,        
            ContentPurposeType_LANDING_PAGE_IMAGE);

    public static final List<FileExtensionData> fileExtensionList=ImmutableList.of(        
            FileExtension_asf,        
            FileExtension_asx,        
            FileExtension_avi,        
            FileExtension_css,        
            FileExtension_flv,        
            FileExtension_jpg,        
            FileExtension_jpeg,        
            FileExtension_tif,        
            FileExtension_tiff,        
            FileExtension_gif,        
            FileExtension_svg,        
            FileExtension_png,        
            FileExtension_mp4,        
            FileExtension_m4v,        
            FileExtension_mpg,        
            FileExtension_mpeg,        
            FileExtension_mov,        
            FileExtension_pdf,        
            FileExtension_ps,        
            FileExtension_qt,        
            FileExtension_rtf,        
            FileExtension_swf,        
            FileExtension_txt,        
            FileExtension_htm,        
            FileExtension_html,        
            FileExtension_xml,        
            FileExtension_vrml,        
            FileExtension_doc,        
            FileExtension_odt,        
            FileExtension_wvx,        
            FileExtension_wm,        
            FileExtension_wmv,        
            FileExtension_wmx,        
            FileExtension_zip,        
            FileExtension_vcf,        
            FileExtension_wav,        
            FileExtension_mp3,        
            FileExtension_ogg,        
            FileExtension_flac,        
            FileExtension_vorbis,        
            FileExtension_dflt,        
            FileExtension_3gp);

    public static final List<SecurityGroupPermissionData> securityGroupPermissionList=ImmutableList.of(        
            SecurityGroupPermission_SUPER_CONTENTMGR_ADMIN_);

    public static final List<DataTemplateTypeData> dataTemplateTypeList=ImmutableList.of(        
            DataTemplateType_NONE,        
            DataTemplateType_FTL,        
            DataTemplateType_WM,        
            DataTemplateType_XSLT,        
            DataTemplateType_SCREEN_COMBINED);

    public static final List<CharacterSetData> characterSetList=ImmutableList.of(        
            CharacterSet_ISO_8859_1,        
            CharacterSet_ISO_8859_2,        
            CharacterSet_ISO_8859_3,        
            CharacterSet_ISO_8859_4,        
            CharacterSet_ISO_8859_5,        
            CharacterSet_ISO_8859_6,        
            CharacterSet_ISO_8859_7,        
            CharacterSet_ISO_8859_8,        
            CharacterSet_ISO_8859_9,        
            CharacterSet_ISO_8859_10,        
            CharacterSet_US_ASCII,        
            CharacterSet_UTF_8,        
            CharacterSet_UTF_16);

    public static final List<ContentAssocPredicateData> contentAssocPredicateList=ImmutableList.of(        
            ContentAssocPredicate_member_of,        
            ContentAssocPredicate_defines,        
            ContentAssocPredicate_extends,        
            ContentAssocPredicate_related_to,        
            ContentAssocPredicate_references,        
            ContentAssocPredicate_topifies,        
            ContentAssocPredicate_categorizes);

    public static final List<SurveyApplTypeData> surveyApplTypeList=ImmutableList.of(        
            SurveyApplType_CART_ADD,        
            SurveyApplType_CHECK_OUT,        
            SurveyApplType_GENERAL_POLL,        
            SurveyApplType_RANDOM_POLL,        
            SurveyApplType_CUSTOMER_PROFILE,        
            SurveyApplType_SORDER_PLACE,        
            SurveyApplType_PORDER_PLACE,        
            SurveyApplType_PORDITM_PLACE);

    public static final List<MimeTypeHtmlTemplateData> mimeTypeHtmlTemplateList=ImmutableList.of(        
            MimeTypeHtmlTemplate_application_x_shockwave_flash,        
            MimeTypeHtmlTemplate_image_jpeg,        
            MimeTypeHtmlTemplate_image_pjpeg,        
            MimeTypeHtmlTemplate_image_gif,        
            MimeTypeHtmlTemplate_image_tiff,        
            MimeTypeHtmlTemplate_image_png,        
            MimeTypeHtmlTemplate_video_quicktime,        
            MimeTypeHtmlTemplate_video_mp4,        
            MimeTypeHtmlTemplate_video_x_flv);

    public static final List<SecurityPermissionData> securityPermissionList=ImmutableList.of(        
            SecurityPermission_CONTENTMGR_VIEW,        
            SecurityPermission_CONTENTMGR_CREATE,        
            SecurityPermission_CONTENTMGR_UPDATE,        
            SecurityPermission_CONTENTMGR_DELETE,        
            SecurityPermission_CONTENTMGR_ADMIN,        
            SecurityPermission_CONTENTMGR_ROLE_VIEW,        
            SecurityPermission_CONTENTMGR_ROLE_CREATE,        
            SecurityPermission_CONTENTMGR_ROLE_UPDATE,        
            SecurityPermission_CONTENTMGR_ROLE_DELETE);

    public static final List<EnumerationData> enumerationList=ImmutableList.of(        
            Enumeration_CNT_PRV_NA_,        
            Enumeration_CNT_PRV_BRONZE,        
            Enumeration_CNT_PRV_SILVER,        
            Enumeration_CNT_PRV_GOLD,        
            Enumeration_SUBSCRIBE_BRONZE,        
            Enumeration_SUBSCRIBE_GOLD,        
            Enumeration_SUBSCRIBE_SILVER);

    public static final List<SurveyQuestionTypeData> surveyQuestionTypeList=ImmutableList.of(        
            SurveyQuestionType_BOOLEAN,        
            SurveyQuestionType_CONTENT,        
            SurveyQuestionType_COUNTRY,        
            SurveyQuestionType_CREDIT_CARD,        
            SurveyQuestionType_GEO,        
            SurveyQuestionType_GIFT_CARD,        
            SurveyQuestionType_DATE,        
            SurveyQuestionType_EMAIL,        
            SurveyQuestionType_ENUMERATION,        
            SurveyQuestionType_NUMBER_CURRENCY,        
            SurveyQuestionType_NUMBER_FLOAT,        
            SurveyQuestionType_NUMBER_LONG,        
            SurveyQuestionType_OPTION,        
            SurveyQuestionType_PASSWORD,        
            SurveyQuestionType_SEPERATOR_LINE,        
            SurveyQuestionType_SEPERATOR_TEXT,        
            SurveyQuestionType_STATE_PROVINCE,        
            SurveyQuestionType_TEXT_SHORT,        
            SurveyQuestionType_TEXT_LONG,        
            SurveyQuestionType_TEXTAREA,        
            SurveyQuestionType_URL);

    public static final List<ContentOperationData> contentOperationList=ImmutableList.of(        
            ContentOperation_CONTENT_ADMIN,        
            ContentOperation_CONTENT_CREATE,        
            ContentOperation_CONTENT_UPDATE,        
            ContentOperation_CONTENT_DELETE,        
            ContentOperation_CONTENT_VIEW,        
            ContentOperation_CONTENT_PUBLISH,        
            ContentOperation_CONTENT_RESPOND,        
            ContentOperation_CONTENT_PUBLISH_SELF,        
            ContentOperation__NA_,        
            ContentOperation_HAS_OWNER_ROLE,        
            ContentOperation_HAS_USER_ROLE,        
            ContentOperation_HAS_AUTHOR_ROLE,        
            ContentOperation_HAS_EDITOR_ROLE,        
            ContentOperation_HAS_ADMIN_ROLE,        
            ContentOperation_HAS_PUBLISHER_ROLE,        
            ContentOperation_CONTENT_CREATE_SUB,        
            ContentOperation_CONTENT_VIEW_SHORT,        
            ContentOperation_CHILD_CREATE,        
            ContentOperation_CHILD_UPDATE,        
            ContentOperation_CHILD_DELETE,        
            ContentOperation_CHILD_VIEW,        
            ContentOperation_CONTENT_LINK,        
            ContentOperation_CONTENT_LINK_TO,        
            ContentOperation_CONTENT_LINK_FROM);

    public static final List<EnumerationTypeData> enumerationTypeList=ImmutableList.of(        
            EnumerationType_CONTENT_PRIVILEGE,        
            EnumerationType_SUBSCRIPTION_TYPE);

    public static final List<DocumentTypeData> documentTypeList=ImmutableList.of(        
            DocumentType_SHIPPING_DOCUMENT,        
            DocumentType_BILL_OF_LADING,        
            DocumentType_EXPORT_DOCUMENTATION,        
            DocumentType_HAZ_MAT_DOCUMENT,        
            DocumentType_MANIFEST,        
            DocumentType_OTHER_SHIP_DOCUMENT,        
            DocumentType_PACKAGING_SLIP,        
            DocumentType_PORT_CHARGE_DOCUMENT,        
            DocumentType_TAX_TARIFF_DOCUMENT);

    public static final List<DataResourceData> dataResourceList=ImmutableList.of(        
            DataResource_STDWRAP001,        
            DataResource_BLOG_TPL_TOPLEFT,        
            DataResource_BLOG_TPL_TOPCENTER,        
            DataResource_ECOM_BLANK,        
            DataResource_ECOM_LEFT,        
            DataResource_ECOM_RIGHT,        
            DataResource_ECOM_LEFTRIGHT,        
            DataResource_WRAP_STD_LOOP,        
            DataResource_AFIBC_LOGO,        
            DataResource_AGEP_LOGO,        
            DataResource_AGINC_LOGO,        
            DataResource_ARTICLE_WRAP,        
            DataResource_LEFTBAR,        
            DataResource_RP_MEDAL,        
            DataResource_TMPLT_IMG_CENTER,        
            DataResource_TEMPLATE_IMAGE_LEFT,        
            DataResource_TEMPLATE_TEXT_ONLY,        
            DataResource_VIEW_WRAP,        
            DataResource_WRAP_ARTICLE,        
            DataResource_WRAP_ARTICLE_TABLE,        
            DataResource_WRAP_NEXT_PREV,        
            DataResource_WRAP_STD_001,        
            DataResource_WRAP_VIEW,        
            DataResource_IMAGE_CENTERED,        
            DataResource_IMAGE_LEFT,        
            DataResource_TEMPLATE_TEXT,        
            DataResource_TMPLT_IMG_CENTER_FL,        
            DataResource_TEMPLATE_COMPOSITE,        
            DataResource_HELP_TEMPL,        
            DataResource_NOCONTENTFOUND,        
            DataResource_NOTEXTFOUND);

    public static final List<StatusTypeData> statusTypeList=ImmutableList.of(        
            StatusType_CNTNTAPPR_STATUS,        
            StatusType_SERVER_HIT_STATUS,        
            StatusType_WEB_CONTENT_STATUS,        
            StatusType_CONTENT_STATUS);

    public static final List<ContentData> contentList=ImmutableList.of(        
            Content_TEMPLATE_MASTER,        
            Content_STDWRAP001,        
            Content_BLOGROOT,        
            Content_LEFTBAR,        
            Content_OWNER_BLOG_CONTENT,        
            Content_TMPLT_IMG_CENTER,        
            Content_TEMPLATE_IMAGE_LEFT,        
            Content_TEMPLATE_TEXT_ONLY,        
            Content_VIEW_WRAP,        
            Content_WRAP_ARTICLE,        
            Content_WRAP_NEXT_PREV,        
            Content_WRAP_STD_LOOP,        
            Content_WRAP_VIEW,        
            Content_ARTICLE_WRAP,        
            Content_BLOG_MASTER,        
            Content_NOCONTENTFOUND,        
            Content_NOTEXTFOUND);

    public static final List<DataResourceTypeData> dataResourceTypeList=ImmutableList.of(        
            DataResourceType_LOCAL_FILE,        
            DataResourceType_OFBIZ_FILE,        
            DataResourceType_CONTEXT_FILE,        
            DataResourceType_LOCAL_FILE_BIN,        
            DataResourceType_OFBIZ_FILE_BIN,        
            DataResourceType_CONTEXT_FILE_BIN,        
            DataResourceType_LINK,        
            DataResourceType_URL_RESOURCE,        
            DataResourceType_SHORT_TEXT,        
            DataResourceType_ELECTRONIC_TEXT,        
            DataResourceType_AUDIO_OBJECT,        
            DataResourceType_IMAGE_OBJECT,        
            DataResourceType_OTHER_OBJECT,        
            DataResourceType_VIDEO_OBJECT,        
            DataResourceType_SURVEY,        
            DataResourceType_SURVEY_RESPONSE);

}

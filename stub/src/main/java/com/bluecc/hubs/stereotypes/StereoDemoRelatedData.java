package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.ElectronicTextData;
import com.bluecc.hubs.stub.ContentAssocData;
import com.bluecc.hubs.stub.DataResourceData;
import com.bluecc.hubs.stub.ContentData;

public final class StereoDemoRelatedData {
    public final static ElectronicTextData ElectronicText_RELATED_1 = ElectronicTextData.newBuilder()
        .setDataResourceId("RELATED_1")
        .setTextData("...")
        .build();


    public final static ElectronicTextData ElectronicText_RELATED_2 = ElectronicTextData.newBuilder()
        .setDataResourceId("RELATED_2")
        .setTextData("...")
        .build();


    public final static ElectronicTextData ElectronicText_RELATED_3 = ElectronicTextData.newBuilder()
        .setDataResourceId("RELATED_3")
        .setTextData("...")
        .build();


    public final static ElectronicTextData ElectronicText_RELATED_4 = ElectronicTextData.newBuilder()
        .setDataResourceId("RELATED_4")
        .setTextData("...")
        .build();


    public final static ContentAssocData ContentAssoc_RELATED_1_ECMC180000_RELATED_CONTENT_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("RELATED_CONTENT")
        .setContentId("RELATED_1")
        .setContentIdTo("ECMC180000")
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-03-01 12:00:00.000"))
        .setFromDate(getTimestamp("2004-03-01 12:00:00.000"))
        .build();


    public final static ContentAssocData ContentAssoc_RELATED_2_ECMC180000_RELATED_CONTENT_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("RELATED_CONTENT")
        .setContentId("RELATED_2")
        .setContentIdTo("ECMC180000")
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-03-01 12:00:00.000"))
        .setFromDate(getTimestamp("2004-03-01 12:00:00.000"))
        .build();


    public final static ContentAssocData ContentAssoc_RELATED_3_ECMC180001_RELATED_CONTENT_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("RELATED_CONTENT")
        .setContentId("RELATED_3")
        .setContentIdTo("ECMC180001")
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-03-01 12:00:00.000"))
        .setFromDate(getTimestamp("2004-03-01 12:00:00.000"))
        .build();


    public final static ContentAssocData ContentAssoc_RELATED_4_ECMC180001_RELATED_CONTENT_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("RELATED_CONTENT")
        .setContentId("RELATED_4")
        .setContentIdTo("ECMC180001")
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-03-01 12:00:00.000"))
        .setFromDate(getTimestamp("2004-03-01 12:00:00.000"))
        .build();


    public final static DataResourceData DataResource_RELATED_1 = DataResourceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-03-30 07:57:39.734"))
        .setDataResourceId("RELATED_1")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setDataTemplateTypeId("NONE")
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2004-03-30 07:57:39.734"))
        .setStatusId("CTNT_PUBLISHED")
        .build();


    public final static DataResourceData DataResource_RELATED_2 = DataResourceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-03-30 07:57:39.734"))
        .setDataResourceId("RELATED_2")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setDataTemplateTypeId("NONE")
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2004-03-30 07:57:39.734"))
        .setStatusId("CTNT_PUBLISHED")
        .build();


    public final static DataResourceData DataResource_RELATED_3 = DataResourceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-03-30 07:57:39.734"))
        .setDataResourceId("RELATED_3")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setDataTemplateTypeId("NONE")
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2004-03-30 07:57:39.734"))
        .setStatusId("CTNT_PUBLISHED")
        .build();


    public final static DataResourceData DataResource_RELATED_4 = DataResourceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-03-30 07:57:39.734"))
        .setDataResourceId("RELATED_4")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setDataTemplateTypeId("NONE")
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2004-03-30 07:57:39.734"))
        .setStatusId("CTNT_PUBLISHED")
        .build();


    public final static ContentData Content_RELATED_1 = ContentData.newBuilder()
        .setContentId("RELATED_1")
        .setContentName("Re:How to operate the Rocket Launcher Widget - Marvelous")
        .setContentTypeId("DOCUMENT")
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-03-30 07:57:39.671"))
        .setDataResourceId("RELATED_1")
        .setDescription("Re:How to operate the Rocket Launcher Widget - Marvelous")
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2004-03-30 07:57:39.671"))
        .setOwnerContentId("ECMC180000")
        .setPrivilegeEnumId("CNT_PRV_BRONZE")
        .setStatusId("CTNT_PUBLISHED")
        .build();


    public final static ContentData Content_RELATED_2 = ContentData.newBuilder()
        .setContentId("RELATED_2")
        .setContentName("Re:How to operate the Rocket Launcher Widget - Ridiculous")
        .setContentTypeId("DOCUMENT")
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-03-30 07:57:39.671"))
        .setDataResourceId("RELATED_2")
        .setDescription("Re:How to operate the Rocket Launcher Widget - Ridiculous")
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2004-03-30 07:57:39.671"))
        .setOwnerContentId("ECMC180000")
        .setPrivilegeEnumId("CNT_PRV_BRONZE")
        .setStatusId("CTNT_PUBLISHED")
        .build();


    public final static ContentData Content_RELATED_3 = ContentData.newBuilder()
        .setContentId("RELATED_3")
        .setContentName("Re:Future Directions in Rocket Launcher Widgets")
        .setContentTypeId("DOCUMENT")
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-03-30 07:57:39.671"))
        .setDataResourceId("RELATED_3")
        .setDescription("Re:Future Directions in Rocket Launcher Widgets")
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2004-03-30 07:57:39.671"))
        .setOwnerContentId("ECMC180001")
        .setPrivilegeEnumId("CNT_PRV_BRONZE")
        .setStatusId("CTNT_PUBLISHED")
        .build();


    public final static ContentData Content_RELATED_4 = ContentData.newBuilder()
        .setContentId("RELATED_4")
        .setContentName("Re:Future Directions in Rocket Launcher Widgets")
        .setContentTypeId("DOCUMENT")
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-03-30 07:57:39.671"))
        .setDataResourceId("RELATED_4")
        .setDescription("Re:Future Directions in Rocket Launcher Widgets")
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2004-03-30 07:57:39.671"))
        .setOwnerContentId("ECMC180001")
        .setPrivilegeEnumId("CNT_PRV_BRONZE")
        .setStatusId("CTNT_PUBLISHED")
        .build();

}

package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.ElectronicTextData;
import com.bluecc.hubs.stub.ContentAssocData;
import com.bluecc.hubs.stub.DataResourceData;
import com.bluecc.hubs.stub.ProductContentData;
import com.bluecc.hubs.stub.ContentData;

public final class StereoDemoProductI18nData {
    public final static ElectronicTextData ElectronicText_GZ2644DESCFR = ElectronicTextData.newBuilder()
        .setDataResourceId("GZ2644DESCFR")
        .setTextData("Gizmo rond lumineux")
        .build();


    public final static ElectronicTextData ElectronicText_GZ2644DESCIT = ElectronicTextData.newBuilder()
        .setDataResourceId("GZ2644DESCIT")
        .setTextData("Gizmo rotondo con luci")
        .build();


    public final static ElectronicTextData ElectronicText_GZ2644DESCEN = ElectronicTextData.newBuilder()
        .setDataResourceId("GZ2644DESCEN")
        .setTextData("Round Gizmo with lights")
        .build();


    public final static ElectronicTextData ElectronicText_GZ2644NAMEFR = ElectronicTextData.newBuilder()
        .setDataResourceId("GZ2644NAMEFR")
        .setTextData("Gizmo Rond")
        .build();


    public final static ElectronicTextData ElectronicText_GZ2644NAMEIT = ElectronicTextData.newBuilder()
        .setDataResourceId("GZ2644NAMEIT")
        .setTextData("Gizmo Rotondo")
        .build();


    public final static ElectronicTextData ElectronicText_GZ2644NAMEEN = ElectronicTextData.newBuilder()
        .setDataResourceId("GZ2644NAMEEN")
        .setTextData("Round Gizmo")
        .build();


    public final static ContentAssocData ContentAssoc_GZ2644DESCEN_GZ2644DESCIT_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("GZ2644DESCEN")
        .setContentIdTo("GZ2644DESCIT")
        .setFromDate(getTimestamp("2006-09-22 00:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_GZ2644DESCEN_GZ2644DESCFR_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("GZ2644DESCEN")
        .setContentIdTo("GZ2644DESCFR")
        .setFromDate(getTimestamp("2006-09-22 00:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_GZ2644NAMEEN_GZ2644NAMEIT_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("GZ2644NAMEEN")
        .setContentIdTo("GZ2644NAMEIT")
        .setFromDate(getTimestamp("2006-09-22 00:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_GZ2644NAMEEN_GZ2644NAMEFR_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("GZ2644NAMEEN")
        .setContentIdTo("GZ2644NAMEFR")
        .setFromDate(getTimestamp("2006-09-22 00:00:00.0"))
        .build();


    public final static DataResourceData DataResource_GZ2644DESCFR = DataResourceData.newBuilder()
        .setDataResourceId("GZ2644DESCFR")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("fr")
        .build();


    public final static DataResourceData DataResource_GZ2644DESCIT = DataResourceData.newBuilder()
        .setDataResourceId("GZ2644DESCIT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("it")
        .build();


    public final static DataResourceData DataResource_GZ2644DESCEN = DataResourceData.newBuilder()
        .setDataResourceId("GZ2644DESCEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_GZ2644NAMEFR = DataResourceData.newBuilder()
        .setDataResourceId("GZ2644NAMEFR")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("fr")
        .build();


    public final static DataResourceData DataResource_GZ2644NAMEIT = DataResourceData.newBuilder()
        .setDataResourceId("GZ2644NAMEIT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("it")
        .build();


    public final static DataResourceData DataResource_GZ2644NAMEEN = DataResourceData.newBuilder()
        .setDataResourceId("GZ2644NAMEEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static ProductContentData ProductContent_GZ_2644_GZ2644DESCEN_DESCRIPTION_ = ProductContentData.newBuilder()
        .setContentId("GZ2644DESCEN")
        .setFromDate(getTimestamp("2006-09-22 00:00:00.0"))
        .setProductContentTypeId("DESCRIPTION")
        .setProductId("GZ-2644")
        .build();


    public final static ProductContentData ProductContent_GZ_2644_GZ2644NAMEEN_PRODUCT_NAME_ = ProductContentData.newBuilder()
        .setContentId("GZ2644NAMEEN")
        .setFromDate(getTimestamp("2006-09-22 00:00:00.0"))
        .setProductContentTypeId("PRODUCT_NAME")
        .setProductId("GZ-2644")
        .build();


    public final static ContentData Content_GZ2644DESCFR = ContentData.newBuilder()
        .setContentId("GZ2644DESCFR")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("GZ2644DESCFR")
        .setDescription("DESCRIPTION FR Round Gizmo")
        .setLocaleString("fr")
        .build();


    public final static ContentData Content_GZ2644DESCIT = ContentData.newBuilder()
        .setContentId("GZ2644DESCIT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("GZ2644DESCIT")
        .setDescription("DESCRIPTION IT Round Gizmo")
        .setLocaleString("it")
        .build();


    public final static ContentData Content_GZ2644DESCEN = ContentData.newBuilder()
        .setContentId("GZ2644DESCEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("GZ2644DESCEN")
        .setDescription("DESCRIPTION EN Round Gizmo")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_GZ2644NAMEFR = ContentData.newBuilder()
        .setContentId("GZ2644NAMEFR")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("GZ2644NAMEFR")
        .setDescription("DESCRIPTION FR Round Gizmo")
        .setLocaleString("fr")
        .build();


    public final static ContentData Content_GZ2644NAMEIT = ContentData.newBuilder()
        .setContentId("GZ2644NAMEIT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("GZ2644NAMEIT")
        .setDescription("DESCRIPTION IT Round Gizmo")
        .setLocaleString("it")
        .build();


    public final static ContentData Content_GZ2644NAMEEN = ContentData.newBuilder()
        .setContentId("GZ2644NAMEEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("GZ2644NAMEEN")
        .setDescription("DESCRIPTION EN Round Gizmo")
        .setLocaleString("en")
        .build();

}

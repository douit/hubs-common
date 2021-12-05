package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.ElectronicTextData;
import com.bluecc.hubs.stub.ContentAssocData;
import com.bluecc.hubs.stub.DataResourceData;
import com.bluecc.hubs.stub.ContentData;

public final class StereoDemoContentAltUrl {
    public final static ElectronicTextData ElectronicText_DRS_CNT_URL005 = ElectronicTextData.newBuilder()
        .setDataResourceId("DRS_CNT_URL005")
        .setTextData("Cute Kid")
        .build();

    public final static ElectronicTextData ElectronicText_DRS_CNT_URL006 = ElectronicTextData.newBuilder()
        .setDataResourceId("DRS_CNT_URL006")
        .setTextData("Next Linus")
        .build();

    public final static ElectronicTextData ElectronicText_DRS_CNT_URL007 = ElectronicTextData.newBuilder()
        .setDataResourceId("DRS_CNT_URL007")
        .setTextData("2008 Elections")
        .build();

    public final static ContentAssocData ContentAssoc_BLG10000_CNT_ALTURL_005_ALTERNATIVE_URL_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATIVE_URL")
        .setContentId("BLG10000")
        .setContentIdTo("CNT_ALTURL_005")
        .setFromDate(getTimestamp("2011-06-23 01:01:01"))
        .build();

    public final static ContentAssocData ContentAssoc_BLG10010_CNT_ALTURL_006_ALTERNATIVE_URL_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATIVE_URL")
        .setContentId("BLG10010")
        .setContentIdTo("CNT_ALTURL_006")
        .setFromDate(getTimestamp("2011-06-23 01:01:01"))
        .build();

    public final static ContentAssocData ContentAssoc_BLG10007_CNT_ALTURL_007_ALTERNATIVE_URL_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATIVE_URL")
        .setContentId("BLG10007")
        .setContentIdTo("CNT_ALTURL_007")
        .setFromDate(getTimestamp("2011-06-23 01:01:01"))
        .build();

    public final static ContentData Content_CNT_ALTURL_005 = ContentData.newBuilder()
        .setContentId("CNT_ALTURL_005")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRS_CNT_URL005")
        .setLocaleString("en_US")
        .setStatusId("CTNT_IN_PROGRESS")
        .build();

    public final static ContentData Content_CNT_ALTURL_006 = ContentData.newBuilder()
        .setContentId("CNT_ALTURL_006")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRS_CNT_URL006")
        .setLocaleString("en_US")
        .setStatusId("CTNT_IN_PROGRESS")
        .build();

    public final static ContentData Content_CNT_ALTURL_007 = ContentData.newBuilder()
        .setContentId("CNT_ALTURL_007")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRS_CNT_URL007")
        .setLocaleString("en_US")
        .setStatusId("CTNT_IN_PROGRESS")
        .build();

}

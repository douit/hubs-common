package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.ElectronicTextData;
import com.bluecc.hubs.stub.ContentAssocData;
import com.bluecc.hubs.stub.DataResourceData;
import com.bluecc.hubs.stub.ContentData;

public final class StereoDemoRelatedData {
    public final static ElectronicTextData ElectronicText_RELATED_1 = ElectronicTextData.newBuilder()
        .setDataResourceId("RELATED_1")
        .build();

    public final static ElectronicTextData ElectronicText_RELATED_2 = ElectronicTextData.newBuilder()
        .setDataResourceId("RELATED_2")
        .build();

    public final static ElectronicTextData ElectronicText_RELATED_3 = ElectronicTextData.newBuilder()
        .setDataResourceId("RELATED_3")
        .build();

    public final static ElectronicTextData ElectronicText_RELATED_4 = ElectronicTextData.newBuilder()
        .setDataResourceId("RELATED_4")
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

}

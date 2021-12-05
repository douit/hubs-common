package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.DataResourceData;

public final class StereoDemoTemplateData {
    public final static DataResourceData DataResource_TPL_XML_MB = DataResourceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-06-14 11:40:15.818"))
        .setDataResourceId("TPL_XML_MB")
        .setDataResourceTypeId("LOCAL_FILE")
        .setDataTemplateTypeId("FTL")
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2004-06-14 11:40:15.818"))
        .setObjectInfo("component://ecommerce/template/content/TplMbContent.ftl")
        .build();

}

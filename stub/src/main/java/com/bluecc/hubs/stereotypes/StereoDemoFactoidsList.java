package com.bluecc.hubs.stereotypes;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.stereotypes.StereoDemoFactoids.*;import com.bluecc.hubs.stub.ElectronicTextData;
import com.bluecc.hubs.stub.ContentAssocData;
import com.bluecc.hubs.stub.DataResourceData;
import com.bluecc.hubs.stub.ContentData;

public final class StereoDemoFactoidsList {
    public static final List<ElectronicTextData> electronicTextList=ImmutableList.of(        
            ElectronicText_FACT_1,        
            ElectronicText_FACT_2,        
            ElectronicText_FACT_3,        
            ElectronicText_FACT_4,        
            ElectronicText_FACT_5);

    public static final List<ContentAssocData> contentAssocList=ImmutableList.of(        
            ContentAssoc_FACT_1_WebStoreFACTOID_PUBLISH_LINK_,        
            ContentAssoc_FACT_2_WebStoreFACTOID_PUBLISH_LINK_,        
            ContentAssoc_FACT_3_WebStoreFACTOID_PUBLISH_LINK_,        
            ContentAssoc_FACT_4_WebStoreFACTOID_PUBLISH_LINK_,        
            ContentAssoc_FACT_5_WebStoreFACTOID_PUBLISH_LINK_,        
            ContentAssoc_FACT_1_WebStoreFACTOID_SUB_CONTENT_,        
            ContentAssoc_FACT_2_WebStoreFACTOID_SUB_CONTENT_,        
            ContentAssoc_FACT_3_WebStoreFACTOID_SUB_CONTENT_,        
            ContentAssoc_FACT_4_WebStoreFACTOID_SUB_CONTENT_,        
            ContentAssoc_FACT_5_WebStoreFACTOID_SUB_CONTENT_);

    public static final List<DataResourceData> dataResourceList=ImmutableList.of(        
            DataResource_FACT_1,        
            DataResource_FACT_2,        
            DataResource_FACT_3,        
            DataResource_FACT_4,        
            DataResource_FACT_5);

    public static final List<ContentData> contentList=ImmutableList.of(        
            Content_FACT_1,        
            Content_FACT_2,        
            Content_FACT_3,        
            Content_FACT_4,        
            Content_FACT_5);

}

package com.bluecc.hubs.stereotypes;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.stereotypes.StereoDemoRelatedData.*;

import com.bluecc.hubs.stub.ElectronicTextData;
import com.bluecc.hubs.stub.ContentAssocData;
import com.bluecc.hubs.stub.DataResourceData;
import com.bluecc.hubs.stub.ContentData;

public final class StereoDemoRelatedDataList {
    public static final List<ElectronicTextData> electronicTextList=ImmutableList.of(        
            ElectronicText_RELATED_1,        
            ElectronicText_RELATED_2,        
            ElectronicText_RELATED_3,        
            ElectronicText_RELATED_4);

    public static final List<ContentAssocData> contentAssocList=ImmutableList.of(        
            ContentAssoc_RELATED_1_ECMC180000_RELATED_CONTENT_,        
            ContentAssoc_RELATED_2_ECMC180000_RELATED_CONTENT_,        
            ContentAssoc_RELATED_3_ECMC180001_RELATED_CONTENT_,        
            ContentAssoc_RELATED_4_ECMC180001_RELATED_CONTENT_);

    public static final List<DataResourceData> dataResourceList=ImmutableList.of(        
            DataResource_RELATED_1,        
            DataResource_RELATED_2,        
            DataResource_RELATED_3,        
            DataResource_RELATED_4);

    public static final List<ContentData> contentList=ImmutableList.of(        
            Content_RELATED_1,        
            Content_RELATED_2,        
            Content_RELATED_3,        
            Content_RELATED_4);

}

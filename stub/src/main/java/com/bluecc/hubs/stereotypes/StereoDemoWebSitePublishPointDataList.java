package com.bluecc.hubs.stereotypes;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.stereotypes.StereoDemoWebSitePublishPointData.*;

import com.bluecc.hubs.stub.ContentAssocData;
import com.bluecc.hubs.stub.ElectronicTextData;
import com.bluecc.hubs.stub.DataResourceData;
import com.bluecc.hubs.stub.ContentAttributeData;
import com.bluecc.hubs.stub.ContentData;
import com.bluecc.hubs.stub.WebSiteContentData;

public final class StereoDemoWebSitePublishPointDataList {
    public static final List<ContentAssocData> contentAssocList=ImmutableList.of(        
            ContentAssoc_WebStoreCONTENT_CNTGIZMOS_SUB_CONTENT_,        
            ContentAssoc_CNTGIZMOS_CNTGIZMOSLRG_SUB_CONTENT_,        
            ContentAssoc_CNTGIZMOS_CNTGIZMOSSML_SUB_CONTENT_,        
            ContentAssoc_CNTGIZMOS_GIZMOSLRG_SUB_CONTENT_,        
            ContentAssoc_CNTGIZMOS_GIZMOSSML_SUB_CONTENT_,        
            ContentAssoc_WebStoreCONTENT_CNTWIDGETS_SUB_CONTENT_,        
            ContentAssoc_CNTWIDGETS_WIDGETSSML_SUB_CONTENT_,        
            ContentAssoc_CNTWIDGETS_WIDGETSLRG_SUB_CONTENT_,        
            ContentAssoc_CNTWIDGETS_CNTWIDGETSLRG_SUB_CONTENT_,        
            ContentAssoc_CNTWIDGETS_CNTWIDGETSSML_SUB_CONTENT_,        
            ContentAssoc_WebStoreCONTENT_POLICY_SUB_CONTENT_,        
            ContentAssoc_WebStoreCONTENT_STORE_POLICIES_SUB_CONTENT_,        
            ContentAssoc_WebStoreCONTENT_STORE_POLICIES2_SUB_CONTENT_,        
            ContentAssoc_WebStoreCONTENT_COOKIE_POLICY_SUB_CONTENT_);

    public static final List<ElectronicTextData> electronicTextList=ImmutableList.of(        
            ElectronicText_STORE_POLICIES,        
            ElectronicText_STORE_POLICIES2,        
            ElectronicText_COOKIE_POLICY);

    public static final List<DataResourceData> dataResourceList=ImmutableList.of(        
            DataResource_STORE_POLICIES,        
            DataResource_STORE_POLICIES2,        
            DataResource_COOKIE_POLICY);

    public static final List<ContentAttributeData> contentAttributeList=ImmutableList.of(        
            ContentAttribute_CNTGIZMOS_publishOperation,        
            ContentAttribute_CNTWIDGETS_publishOperation,        
            ContentAttribute_POLICY_publishOperation);

    public static final List<ContentData> contentList=ImmutableList.of(        
            Content_WebStoreCONTENT,        
            Content_CNTGIZMOS,        
            Content_CNTGIZMOSLRG,        
            Content_CNTGIZMOSSML,        
            Content_GIZMOSLRG,        
            Content_GIZMOSSML,        
            Content_CNTWIDGETS,        
            Content_WIDGETSSML,        
            Content_WIDGETSLRG,        
            Content_CNTWIDGETSLRG,        
            Content_CNTWIDGETSSML,        
            Content_POLICY,        
            Content_WebStoreFACTOID,        
            Content_STORE_POLICIES,        
            Content_STORE_POLICIES2,        
            Content_COOKIE_POLICY);

    public static final List<WebSiteContentData> webSiteContentList=ImmutableList.of(        
            WebSiteContent_WebStore_WebStoreCONTENT_PUBLISH_POINT_);

}

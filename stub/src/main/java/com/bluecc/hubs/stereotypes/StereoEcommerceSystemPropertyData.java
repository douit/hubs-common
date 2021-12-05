package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.SystemPropertyData;

public final class StereoEcommerceSystemPropertyData {
    public final static SystemPropertyData SystemProperty_ecommerce_tagcloud_min_fontsize = SystemPropertyData.newBuilder()
        .setDescription("Minimum font size for the tag cloud.")
        .setSystemPropertyId("tagcloud.min.fontsize")
        .setSystemPropertyValue("8")
        .setSystemResourceId("ecommerce")
        .build();


    public final static SystemPropertyData SystemProperty_ecommerce_tagcloud_max_fontsize = SystemPropertyData.newBuilder()
        .setDescription("Maximum font size for the tag cloud.")
        .setSystemPropertyId("tagcloud.max.fontsize")
        .setSystemPropertyValue("14")
        .setSystemResourceId("ecommerce")
        .build();


    public final static SystemPropertyData SystemProperty_ecommerce_tagcloud_limit = SystemPropertyData.newBuilder()
        .setDescription("Number of tags in the tag cloud.")
        .setSystemPropertyId("tagcloud.limit")
        .setSystemPropertyValue("99")
        .setSystemResourceId("ecommerce")
        .build();

}

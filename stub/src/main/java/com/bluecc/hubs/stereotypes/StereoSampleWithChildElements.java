package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.ElectronicTextData;
import com.bluecc.hubs.stub.ProductFlatData;

public final class StereoSampleWithChildElements {
    public final static ElectronicTextData ElectronicText_GZ_1005_WARN = ElectronicTextData.newBuilder()
        .setDataResourceId("GZ-1005-WARN")
        .setTextData("<b>*** WARNING: this gizmo is known to crash quite often and may malfunction or cease to function due to malicious misuse of certain features ***</b>")
        .build();


    public final static ProductFlatData Product_GZ_1005 = ProductFlatData.newBuilder()
        .setAutoCreateKeywords(castIndicator("Y"))
        .setChargeShipping(castIndicator("Y"))
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setDescription("M$ .NIT gizmo")
        .setInternalName(".NIT Gizmo")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("N"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrimaryProductCategoryId("102")
        .setProductId("GZ-1005")
        .setProductName(".NIT Gizmo")
        .setProductTypeId("FINISHED_GOOD")
        .setTaxable(castIndicator("Y"))
        .setLongDescription("This gizmo only works in certain areas and requires a lot of extra space to move around.<br/><br/>It is not recommended for mission critical applications or those with a low tolerance for pain and frustration.")
        .build();

}

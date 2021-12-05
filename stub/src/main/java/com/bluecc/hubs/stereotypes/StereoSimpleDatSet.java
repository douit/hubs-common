package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.PartyRoleData;
import com.bluecc.hubs.stub.ProductFlatData;
import com.bluecc.hubs.stub.PartyStatusData;
import com.bluecc.hubs.stub.ProductPriceData;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.hubs.stub.UserLoginSecurityGroupData;
import com.bluecc.hubs.stub.PersonFlatData;
import com.bluecc.hubs.stub.UserLoginFlatData;

public final class StereoSimpleDatSet {
    public final static PartyRoleData PartyRole_DemoRepAll_SALES_REP = PartyRoleData.newBuilder()
        .setPartyId("DemoRepAll")
        .setRoleTypeId("SALES_REP")
        .build();

    public final static ProductFlatData Product_GZ_1001 = ProductFlatData.newBuilder()
        .setAutoCreateKeywords(castIndicator("Y"))
        .setChargeShipping(castIndicator("Y"))
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setDescription("Indian style Nan gizmo")
        .setInternalName("Nan Gizmo")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("N"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrimaryProductCategoryId("101")
        .setProductId("GZ-1001")
        .setProductName("Nan Gizmo")
        .setProductTypeId("FINISHED_GOOD")
        .setTaxable(castIndicator("Y"))
        .build();

    public final static ProductFlatData Product_GZ_DIG = ProductFlatData.newBuilder()
        .setAutoCreateKeywords(castIndicator("Y"))
        .setChargeShipping(castIndicator("Y"))
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setDescription("Indian style Nan gizmo")
        .setInternalName("Nan Gizmo")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("N"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrimaryProductCategoryId("101")
        .setProductId("GZ-DIG")
        .setProductName("Nan Gizmo")
        .setProductTypeId("FINISHED_GOOD")
        .setTaxable(castIndicator("Y"))
        .build();

    public final static PartyStatusData PartyStatus_PARTY_ENABLED_DemoRepAll_ = PartyStatusData.newBuilder()
        .setPartyId("DemoRepAll")
        .setStatusDate(getTimestamp("2001-01-01 12:00:00.0"))
        .setStatusId("PARTY_ENABLED")
        .build();

    public final static ProductPriceData ProductPrice_GZ_DIG_DEFAULT_PRICE_PURCHASE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("55.99"))
        .setProductId("GZ-DIG")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();

    public final static ProductPriceData ProductPrice_GZ_DIG_LIST_PRICE_PURCHASE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("80.0"))
        .setProductId("GZ-DIG")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("LIST_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();

    public final static PartyFlatData Party_DemoRepAll = PartyFlatData.newBuilder()
        .setPartyId("DemoRepAll")
        .setPartyTypeId("PERSON")
        .setStatusId("PARTY_ENABLED")
        .build();

    public final static UserLoginSecurityGroupData UserLoginSecurityGroup_DemoRepAll_ORDERENTRY_ALL_ = UserLoginSecurityGroupData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 00:00:00"))
        .setGroupId("ORDERENTRY_ALL")
        .setUserLoginId("DemoRepAll")
        .build();

}

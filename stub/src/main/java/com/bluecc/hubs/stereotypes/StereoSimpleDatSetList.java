package com.bluecc.hubs.stereotypes;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.stereotypes.StereoSimpleDatSet.*;

import com.bluecc.hubs.stub.PartyRoleData;
import com.bluecc.hubs.stub.ProductFlatData;
import com.bluecc.hubs.stub.PartyStatusData;
import com.bluecc.hubs.stub.ProductPriceData;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.hubs.stub.UserLoginSecurityGroupData;
import com.bluecc.hubs.stub.PersonFlatData;
import com.bluecc.hubs.stub.UserLoginFlatData;

public final class StereoSimpleDatSetList {
    public static final List<PartyRoleData> partyRoleList=ImmutableList.of(        
            PartyRole_DemoRepAll_SALES_REP);

    public static final List<ProductFlatData> productList=ImmutableList.of(        
            Product_GZ_1001,        
            Product_GZ_DIG);

    public static final List<PartyStatusData> partyStatusList=ImmutableList.of(        
            PartyStatus_PARTY_ENABLED_DemoRepAll_);

    public static final List<ProductPriceData> productPriceList=ImmutableList.of(        
            ProductPrice_GZ_DIG_DEFAULT_PRICE_PURCHASE_USD__NA__,        
            ProductPrice_GZ_DIG_LIST_PRICE_PURCHASE_USD__NA__);

    public static final List<PartyFlatData> partyList=ImmutableList.of(        
            Party_DemoRepAll);

    public static final List<UserLoginSecurityGroupData> userLoginSecurityGroupList=ImmutableList.of(        
            UserLoginSecurityGroup_DemoRepAll_ORDERENTRY_ALL_);

    public static final List<PersonFlatData> personList=ImmutableList.of(        
            Person_DemoRepAll);

    public static final List<UserLoginFlatData> userLoginList=ImmutableList.of(        
            UserLogin_DemoRepAll);

}

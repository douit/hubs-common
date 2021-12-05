package com.bluecc.hubs.stereotypes;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.stereotypes.StereoEcommerceSecurityData.*;import com.bluecc.hubs.stub.SecurityGroupData;
import com.bluecc.hubs.stub.SecurityGroupPermissionData;

public final class StereoEcommerceSecurityDataList {
    public static final List<SecurityGroupData> securityGroupList=ImmutableList.of(        
            SecurityGroup_ECOMMERCE_CUSTOMER);

    public static final List<SecurityGroupPermissionData> securityGroupPermissionList=ImmutableList.of(        
            SecurityGroupPermission_ECOMMERCE_CUSTOMER_CONTENTMGR_ROLE_CREATE_,        
            SecurityGroupPermission_ECOMMERCE_CUSTOMER_CONTENTMGR_ROLE_UPDATE_);

}

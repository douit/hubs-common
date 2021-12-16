package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.SecurityGroupFlatData;
import com.bluecc.hubs.stub.SecurityGroupPermissionData;

public final class StereoEcommerceSecurityData {
    public final static SecurityGroupFlatData SecurityGroup_ECOMMERCE_CUSTOMER = SecurityGroupFlatData.newBuilder()
        .setDescription("Customer user of ECOMMERCE Limited access to own account")
        .setGroupId("ECOMMERCE_CUSTOMER")
        .build();


    public final static SecurityGroupPermissionData SecurityGroupPermission_ECOMMERCE_CUSTOMER_CONTENTMGR_ROLE_CREATE_ = SecurityGroupPermissionData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setGroupId("ECOMMERCE_CUSTOMER")
        .setPermissionId("CONTENTMGR_ROLE_CREATE")
        .build();


    public final static SecurityGroupPermissionData SecurityGroupPermission_ECOMMERCE_CUSTOMER_CONTENTMGR_ROLE_UPDATE_ = SecurityGroupPermissionData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setGroupId("ECOMMERCE_CUSTOMER")
        .setPermissionId("CONTENTMGR_ROLE_UPDATE")
        .build();

}

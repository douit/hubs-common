package com.bluecc.hubs.stereotypes;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.stereotypes.PartyDemoData.*;

import com.bluecc.hubs.stub.PartyRoleData;
import com.bluecc.hubs.stub.PartyIdentificationTypeData;
import com.bluecc.hubs.stub.PartyStatusData;
import com.bluecc.hubs.stub.ContactMechData;
import com.bluecc.hubs.stub.PartyGroupFlatData;
import com.bluecc.hubs.stub.SecurityGroupFlatData;
import com.bluecc.hubs.stub.PartyIdentificationData;
import com.bluecc.hubs.stub.PostalAddressData;
import com.bluecc.hubs.stub.CommunicationEventRoleData;
import com.bluecc.hubs.stub.PartyRelationshipData;
import com.bluecc.hubs.stub.EmailTemplateSettingData;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.hubs.stub.PartyContactMechPurposeData;
import com.bluecc.hubs.stub.CommunicationEventData;
import com.bluecc.hubs.stub.SecurityGroupPermissionData;
import com.bluecc.hubs.stub.UserLoginSecurityGroupData;
import com.bluecc.hubs.stub.UserLoginFlatData;
import com.bluecc.hubs.stub.PartyContactMechData;

public final class PartyDemoDataList {
    public static List<PartyRoleData> partyRoleList() {
        return ImmutableList.of(        
            PartyRole_admin_EMAIL_ADMIN(),        
            PartyRole_Company__NA_(),        
            PartyRole_DemoEmployee_EMAIL_ADMIN(),        
            PartyRole_DemoSupplier_ACCOUNT(),        
            PartyRole_DemoSupplier_SUPPLIER(),        
            PartyRole_DemoSupplier_BILL_FROM_VENDOR(),        
            PartyRole_DemoSupplier_SHIP_FROM_VENDOR(),        
            PartyRole_DemoSupplier_SUPPLIER_AGENT(),        
            PartyRole_admin_ADDRESSEE(),        
            PartyRole_admin_CONTACT(),        
            PartyRole_Company_ACCOUNT(),        
            PartyRole_DemoGovAgency_GOV_AGENCY());
    }

    public static List<PartyIdentificationTypeData> partyIdentificationTypeList() {
        return ImmutableList.of(        
            PartyIdentificationType_CARD_ID(),        
            PartyIdentificationType_SIRET());
    }

    public static List<PartyStatusData> partyStatusList() {
        return ImmutableList.of(        
            PartyStatus_PARTY_ENABLED_admin_(),        
            PartyStatus_PARTY_ENABLED_Company_(),        
            PartyStatus_PARTY_ENABLED_DemoEmployee_(),        
            PartyStatus_PARTY_ENABLED_DemoSupplier_());
    }

    public static List<ContactMechData> contactMechList() {
        return ImmutableList.of(        
            ContactMech_admin(),        
            ContactMech_9001());
    }

    public static List<PartyGroupFlatData> partyGroupList() {
        return ImmutableList.of(        
            PartyGroup_DemoSupplier(),        
            PartyGroup_DemoAuditor(),        
            PartyGroup_DemoGovAgency());
    }

    public static List<SecurityGroupFlatData> securityGroupList() {
        return ImmutableList.of(        
            SecurityGroup_PARTYADMIN(),        
            SecurityGroup_SECURITYADMIN(),        
            SecurityGroup_AUDITOR());
    }

    public static List<PartyIdentificationData> partyIdentificationList() {
        return ImmutableList.of(        
            PartyIdentification_DemoSupplier_SIRET());
    }

    public static List<PostalAddressData> postalAddressList() {
        return ImmutableList.of(        
            PostalAddress_9001());
    }

    public static List<CommunicationEventRoleData> communicationEventRoleList() {
        return ImmutableList.of(        
            CommunicationEventRole_9000_admin_ADDRESSEE());
    }

    public static List<PartyRelationshipData> partyRelationshipList() {
        return ImmutableList.of(        
            PartyRelationship_admin_Company_EMAIL_ADMIN__NA__(),        
            PartyRelationship_DemoEmployee_Company_EMAIL_ADMIN__NA__(),        
            PartyRelationship_Company_admin_ACCOUNT_CONTACT_());
    }

    public static List<EmailTemplateSettingData> emailTemplateSettingList() {
        return ImmutableList.of(        
            EmailTemplateSetting_PARTY_REGISTER());
    }

    public static List<PartyFlatData> partyList() {
        return ImmutableList.of(        
            Party_admin(),        
            Party_Company(),        
            Party_DemoEmployee(),        
            Party_DemoSupplier(),        
            Party_AcctBigSupplier(),        
            Party_DemoAuditor(),        
            Party_DemoGovAgency());
    }

    public static List<PartyContactMechPurposeData> partyContactMechPurposeList() {
        return ImmutableList.of(        
            PartyContactMechPurpose_admin_admin_PRIMARY_EMAIL_(),        
            PartyContactMechPurpose_DemoSupplier_9001_BILLING_LOCATION_(),        
            PartyContactMechPurpose_DemoSupplier_9001_GENERAL_LOCATION_(),        
            PartyContactMechPurpose_DemoSupplier_9001_PAYMENT_LOCATION_());
    }

    public static List<CommunicationEventData> communicationEventList() {
        return ImmutableList.of(        
            CommunicationEvent_9000());
    }

    public static List<SecurityGroupPermissionData> securityGroupPermissionList() {
        return ImmutableList.of(        
            SecurityGroupPermission_PARTYADMIN_PARTYMGR_ADMIN_(),        
            SecurityGroupPermission_PARTYADMIN_OFBTOOLS_VIEW_(),        
            SecurityGroupPermission_FULLADMIN_PARTYMGR_ADMIN_(),        
            SecurityGroupPermission_FLEXADMIN_PARTYMGR_CREATE_(),        
            SecurityGroupPermission_FLEXADMIN_PARTYMGR_DELETE_(),        
            SecurityGroupPermission_FLEXADMIN_PARTYMGR_UPDATE_(),        
            SecurityGroupPermission_FLEXADMIN_PARTYMGR_NOTE_(),        
            SecurityGroupPermission_FLEXADMIN_PARTYMGR_VIEW_(),        
            SecurityGroupPermission_FLEXADMIN_PARTYMGR_STS_UPDATE_(),        
            SecurityGroupPermission_FLEXADMIN_PARTYMGR_GRP_UPDATE_(),        
            SecurityGroupPermission_FLEXADMIN_PARTYMGR_REL_CREATE_(),        
            SecurityGroupPermission_FLEXADMIN_PARTYMGR_REL_UPDATE_(),        
            SecurityGroupPermission_FLEXADMIN_PARTYMGR_ROLE_CREATE_(),        
            SecurityGroupPermission_FLEXADMIN_PARTYMGR_ROLE_DELETE_(),        
            SecurityGroupPermission_FLEXADMIN_PARTYMGR_PCM_CREATE_(),        
            SecurityGroupPermission_FLEXADMIN_PARTYMGR_PCM_UPDATE_(),        
            SecurityGroupPermission_FLEXADMIN_PARTYMGR_PCM_DELETE_(),        
            SecurityGroupPermission_FLEXADMIN_PARTYMGR_SRC_CREATE_(),        
            SecurityGroupPermission_FLEXADMIN_PARTYMGR_CME_CREATE_(),        
            SecurityGroupPermission_FLEXADMIN_PARTYMGR_CME_UPDATE_(),        
            SecurityGroupPermission_FLEXADMIN_PARTYMGR_CME_DELETE_(),        
            SecurityGroupPermission_VIEWADMIN_PARTYMGR_VIEW_(),        
            SecurityGroupPermission_VIEWADMIN_PARTYMGR_NOTE_(),        
            SecurityGroupPermission_BIZADMIN_PARTYMGR_ADMIN_(),        
            SecurityGroupPermission_FULLADMIN_SECURITY_ADMIN_(),        
            SecurityGroupPermission_FLEXADMIN_SECURITY_CREATE_(),        
            SecurityGroupPermission_FLEXADMIN_SECURITY_DELETE_(),        
            SecurityGroupPermission_FLEXADMIN_SECURITY_UPDATE_(),        
            SecurityGroupPermission_FLEXADMIN_SECURITY_VIEW_(),        
            SecurityGroupPermission_VIEWADMIN_SECURITY_VIEW_(),        
            SecurityGroupPermission_SECURITYADMIN_SECURITY_ADMIN_());
    }

    public static List<UserLoginSecurityGroupData> userLoginSecurityGroupList() {
        return ImmutableList.of(        
            UserLoginSecurityGroup_auditor_VIEWADMIN_());
    }

    public static List<UserLoginFlatData> userLoginList() {
        return ImmutableList.of(        
            UserLogin_DemoSupplier(),        
            UserLogin_auditor());
    }

    public static List<PartyContactMechData> partyContactMechList() {
        return ImmutableList.of(        
            PartyContactMech_admin_admin_(),        
            PartyContactMech_DemoSupplier_9001_());
    }

}

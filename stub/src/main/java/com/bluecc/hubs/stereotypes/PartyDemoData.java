package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
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

public final class PartyDemoData {
    public static PartyRoleData PartyRole_admin_EMAIL_ADMIN() {
        return PartyRoleData.newBuilder()
            .setPartyId("admin")
            .setRoleTypeId("EMAIL_ADMIN")
            .build();
    }


    public static PartyRoleData PartyRole_Company__NA_() {
        return PartyRoleData.newBuilder()
            .setPartyId("Company")
            .setRoleTypeId("_NA_")
            .build();
    }


    public static PartyRoleData PartyRole_DemoEmployee_EMAIL_ADMIN() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoEmployee")
            .setRoleTypeId("EMAIL_ADMIN")
            .build();
    }


    public static PartyRoleData PartyRole_DemoSupplier_ACCOUNT() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoSupplier")
            .setRoleTypeId("ACCOUNT")
            .build();
    }


    public static PartyRoleData PartyRole_DemoSupplier_SUPPLIER() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoSupplier")
            .setRoleTypeId("SUPPLIER")
            .build();
    }


    public static PartyRoleData PartyRole_DemoSupplier_BILL_FROM_VENDOR() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoSupplier")
            .setRoleTypeId("BILL_FROM_VENDOR")
            .build();
    }


    public static PartyRoleData PartyRole_DemoSupplier_SHIP_FROM_VENDOR() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoSupplier")
            .setRoleTypeId("SHIP_FROM_VENDOR")
            .build();
    }


    public static PartyRoleData PartyRole_DemoSupplier_SUPPLIER_AGENT() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoSupplier")
            .setRoleTypeId("SUPPLIER_AGENT")
            .build();
    }


    public static PartyRoleData PartyRole_admin_ADDRESSEE() {
        return PartyRoleData.newBuilder()
            .setPartyId("admin")
            .setRoleTypeId("ADDRESSEE")
            .build();
    }


    public static PartyRoleData PartyRole_admin_CONTACT() {
        return PartyRoleData.newBuilder()
            .setPartyId("admin")
            .setRoleTypeId("CONTACT")
            .build();
    }


    public static PartyRoleData PartyRole_Company_ACCOUNT() {
        return PartyRoleData.newBuilder()
            .setPartyId("Company")
            .setRoleTypeId("ACCOUNT")
            .build();
    }


    public static PartyRoleData PartyRole_DemoGovAgency_GOV_AGENCY() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoGovAgency")
            .setRoleTypeId("GOV_AGENCY")
            .build();
    }


    public static PartyIdentificationTypeData PartyIdentificationType_CARD_ID() {
        return PartyIdentificationTypeData.newBuilder()
            .setDescription("Person card identification number")
            .setPartyIdentificationTypeId("CARD_ID")
            .build();
    }


    public static PartyIdentificationTypeData PartyIdentificationType_SIRET() {
        return PartyIdentificationTypeData.newBuilder()
            .setDescription("French company identification number (SIRET)")
            .setPartyIdentificationTypeId("SIRET")
            .build();
    }


    public static PartyStatusData PartyStatus_PARTY_ENABLED_admin_() {
        return PartyStatusData.newBuilder()
            .setPartyId("admin")
            .setStatusDate(getTimestamp("2001-01-01 12:00:00.0"))
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyStatusData PartyStatus_PARTY_ENABLED_Company_() {
        return PartyStatusData.newBuilder()
            .setPartyId("Company")
            .setStatusDate(getTimestamp("2001-01-01 12:00:00.0"))
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyStatusData PartyStatus_PARTY_ENABLED_DemoEmployee_() {
        return PartyStatusData.newBuilder()
            .setPartyId("DemoEmployee")
            .setStatusDate(getTimestamp("2001-01-01 12:00:00.0"))
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyStatusData PartyStatus_PARTY_ENABLED_DemoSupplier_() {
        return PartyStatusData.newBuilder()
            .setPartyId("DemoSupplier")
            .setStatusDate(getTimestamp("2001-01-01 12:00:00.0"))
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static ContactMechData ContactMech_admin() {
        return ContactMechData.newBuilder()
            .setContactMechId("admin")
            .setContactMechTypeId("EMAIL_ADDRESS")
            .setInfoString("ofbiztest@example.com")
            .build();
    }


    public static ContactMechData ContactMech_9001() {
        return ContactMechData.newBuilder()
            .setContactMechId("9001")
            .setContactMechTypeId("POSTAL_ADDRESS")
            .build();
    }


    public static PartyGroupFlatData PartyGroup_DemoSupplier() {
        return PartyGroupFlatData.newBuilder()
            .setGroupName("Demo Supplier")
            .setPartyId("DemoSupplier")
            .build();
    }


    public static PartyGroupFlatData PartyGroup_DemoAuditor() {
        return PartyGroupFlatData.newBuilder()
            .setGroupName("Demo Auditor")
            .setPartyId("DemoAuditor")
            .build();
    }


    public static PartyGroupFlatData PartyGroup_DemoGovAgency() {
        return PartyGroupFlatData.newBuilder()
            .setGroupName("Demo Government Agency")
            .setPartyId("DemoGovAgency")
            .build();
    }


    public static SecurityGroupFlatData SecurityGroup_PARTYADMIN() {
        return SecurityGroupFlatData.newBuilder()
            .setDescription("Party Admin group, has all party permissions.")
            .setGroupId("PARTYADMIN")
            .setGroupName("Party Admin")
            .build();
    }


    public static SecurityGroupFlatData SecurityGroup_SECURITYADMIN() {
        return SecurityGroupFlatData.newBuilder()
            .setDescription("Security Admin group, has all permissions to modify security settings in party manager.")
            .setGroupId("SECURITYADMIN")
            .setGroupName("Security Admin")
            .build();
    }


    public static SecurityGroupFlatData SecurityGroup_AUDITOR() {
        return SecurityGroupFlatData.newBuilder()
            .setDescription("Auditors group, having only VIEW permissions.")
            .setGroupId("AUDITOR")
            .setGroupName("Auditor")
            .build();
    }


    public static PartyIdentificationData PartyIdentification_DemoSupplier_SIRET() {
        return PartyIdentificationData.newBuilder()
            .setIdValue("1234 5678 90123")
            .setPartyId("DemoSupplier")
            .setPartyIdentificationTypeId("SIRET")
            .build();
    }


    public static PostalAddressData PostalAddress_9001() {
        return PostalAddressData.newBuilder()
            .setAddress1("2004 Factory Blvd")
            .setCity("City of Industry")
            .setContactMechId("9001")
            .setCountryGeoId("USA")
            .setPostalCode("90000")
            .setStateProvinceGeoId("CA")
            .setToName("Demo Supplier Company")
            .build();
    }


    public static CommunicationEventRoleData CommunicationEventRole_9000_admin_ADDRESSEE() {
        return CommunicationEventRoleData.newBuilder()
            .setCommunicationEventId("9000")
            .setContactMechId("admin")
            .setPartyId("admin")
            .setRoleTypeId("ADDRESSEE")
            .setStatusId("COM_ROLE_CREATED")
            .build();
    }


    public static PartyRelationshipData PartyRelationship_admin_Company_EMAIL_ADMIN__NA__() {
        return PartyRelationshipData.newBuilder()
            .setFromDate(getTimestamp("2000-01-01 00:00:00"))
            .setPartyIdFrom("admin")
            .setPartyIdTo("Company")
            .setRoleTypeIdFrom("EMAIL_ADMIN")
            .setRoleTypeIdTo("_NA_")
            .build();
    }


    public static PartyRelationshipData PartyRelationship_DemoEmployee_Company_EMAIL_ADMIN__NA__() {
        return PartyRelationshipData.newBuilder()
            .setFromDate(getTimestamp("2000-01-01 00:00:00"))
            .setPartyIdFrom("DemoEmployee")
            .setPartyIdTo("Company")
            .setRoleTypeIdFrom("EMAIL_ADMIN")
            .setRoleTypeIdTo("_NA_")
            .build();
    }


    public static PartyRelationshipData PartyRelationship_Company_admin_ACCOUNT_CONTACT_() {
        return PartyRelationshipData.newBuilder()
            .setFromDate(getTimestamp("2000-01-01 00:00:00.000"))
            .setPartyIdFrom("Company")
            .setPartyIdTo("admin")
            .setPartyRelationshipTypeId("EMPLOYMENT")
            .setRoleTypeIdFrom("ACCOUNT")
            .setRoleTypeIdTo("CONTACT")
            .build();
    }


    public static EmailTemplateSettingData EmailTemplateSetting_PARTY_REGISTER() {
        return EmailTemplateSettingData.newBuilder()
            .setBccAddress("ofbiztest@example.com")
            .setBodyScreenLocation("component://party/widget/partymgr/PartyScreens.xml#CreateUserNotification")
            .setEmailTemplateSettingId("PARTY_REGISTER")
            .setFromAddress("ofbiztest@example.com")
            .setSubject("New Account Created")
            .build();
    }


    public static PartyFlatData Party_admin() {
        return PartyFlatData.newBuilder()
            .setPartyId("admin")
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyFlatData Party_Company() {
        return PartyFlatData.newBuilder()
            .setPartyId("Company")
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyFlatData Party_DemoEmployee() {
        return PartyFlatData.newBuilder()
            .setPartyId("DemoEmployee")
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyFlatData Party_DemoSupplier() {
        return PartyFlatData.newBuilder()
            .setPartyId("DemoSupplier")
            .setPartyTypeId("PARTY_GROUP")
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyFlatData Party_AcctBigSupplier() {
        return PartyFlatData.newBuilder()
            .setPartyId("AcctBigSupplier")
            .build();
    }


    public static PartyFlatData Party_DemoAuditor() {
        return PartyFlatData.newBuilder()
            .setPartyId("DemoAuditor")
            .setPartyTypeId("PARTY_GROUP")
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyFlatData Party_DemoGovAgency() {
        return PartyFlatData.newBuilder()
            .setPartyId("DemoGovAgency")
            .setPartyTypeId("PARTY_GROUP")
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_admin_admin_PRIMARY_EMAIL_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("admin")
            .setContactMechPurposeTypeId("PRIMARY_EMAIL")
            .setFromDate(getTimestamp("2003-01-01 00:00:00.0"))
            .setPartyId("admin")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_DemoSupplier_9001_BILLING_LOCATION_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("9001")
            .setContactMechPurposeTypeId("BILLING_LOCATION")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoSupplier")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_DemoSupplier_9001_GENERAL_LOCATION_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("9001")
            .setContactMechPurposeTypeId("GENERAL_LOCATION")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoSupplier")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_DemoSupplier_9001_PAYMENT_LOCATION_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("9001")
            .setContactMechPurposeTypeId("PAYMENT_LOCATION")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoSupplier")
            .build();
    }


    public static CommunicationEventData CommunicationEvent_9000() {
        return CommunicationEventData.newBuilder()
            .setCommunicationEventId("9000")
            .setCommunicationEventTypeId("EMAIL_COMMUNICATION")
            .setContactMechIdTo("admin")
            .setContactMechTypeId("EMAIL_ADDRESS")
            .setContent("Every time i think of you, only you...you are always on my mind.......")
            .setContentMimeTypeId("text/plain")
            .setDatetimeStarted(getTimestamp("2008-07-28 13:55:19.0"))
            .setEntryDate(getTimestamp("2008-07-28 13:55:55.827"))
            .setNote("Sent from: my@email.com; Sent Name from: Jo Easy User; Sent to: ofbiztest@example.com; Delivered-To: ofbiztest@example.com; ")
            .setPartyIdTo("admin")
            .setRoleTypeIdFrom("_NA_")
            .setRoleTypeIdTo("_NA_")
            .setStatusId("COM_UNKNOWN_PARTY")
            .setSubject("Why i would use the OFBiz system")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_PARTYADMIN_PARTYMGR_ADMIN_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("PARTYADMIN")
            .setPermissionId("PARTYMGR_ADMIN")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_PARTYADMIN_OFBTOOLS_VIEW_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("PARTYADMIN")
            .setPermissionId("OFBTOOLS_VIEW")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FULLADMIN_PARTYMGR_ADMIN_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FULLADMIN")
            .setPermissionId("PARTYMGR_ADMIN")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_PARTYMGR_CREATE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("PARTYMGR_CREATE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_PARTYMGR_DELETE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("PARTYMGR_DELETE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_PARTYMGR_UPDATE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("PARTYMGR_UPDATE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_PARTYMGR_NOTE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("PARTYMGR_NOTE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_PARTYMGR_VIEW_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("PARTYMGR_VIEW")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_PARTYMGR_STS_UPDATE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("PARTYMGR_STS_UPDATE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_PARTYMGR_GRP_UPDATE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("PARTYMGR_GRP_UPDATE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_PARTYMGR_REL_CREATE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("PARTYMGR_REL_CREATE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_PARTYMGR_REL_UPDATE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("PARTYMGR_REL_UPDATE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_PARTYMGR_ROLE_CREATE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("PARTYMGR_ROLE_CREATE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_PARTYMGR_ROLE_DELETE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("PARTYMGR_ROLE_DELETE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_PARTYMGR_PCM_CREATE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("PARTYMGR_PCM_CREATE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_PARTYMGR_PCM_UPDATE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("PARTYMGR_PCM_UPDATE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_PARTYMGR_PCM_DELETE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("PARTYMGR_PCM_DELETE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_PARTYMGR_SRC_CREATE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("PARTYMGR_SRC_CREATE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_PARTYMGR_CME_CREATE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("PARTYMGR_CME_CREATE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_PARTYMGR_CME_UPDATE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("PARTYMGR_CME_UPDATE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_PARTYMGR_CME_DELETE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("PARTYMGR_CME_DELETE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_VIEWADMIN_PARTYMGR_VIEW_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("VIEWADMIN")
            .setPermissionId("PARTYMGR_VIEW")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_VIEWADMIN_PARTYMGR_NOTE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("VIEWADMIN")
            .setPermissionId("PARTYMGR_NOTE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_BIZADMIN_PARTYMGR_ADMIN_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("BIZADMIN")
            .setPermissionId("PARTYMGR_ADMIN")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FULLADMIN_SECURITY_ADMIN_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FULLADMIN")
            .setPermissionId("SECURITY_ADMIN")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_SECURITY_CREATE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("SECURITY_CREATE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_SECURITY_DELETE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("SECURITY_DELETE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_SECURITY_UPDATE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("SECURITY_UPDATE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_SECURITY_VIEW_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("SECURITY_VIEW")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_VIEWADMIN_SECURITY_VIEW_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("VIEWADMIN")
            .setPermissionId("SECURITY_VIEW")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_SECURITYADMIN_SECURITY_ADMIN_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("SECURITYADMIN")
            .setPermissionId("SECURITY_ADMIN")
            .build();
    }


    public static UserLoginSecurityGroupData UserLoginSecurityGroup_auditor_VIEWADMIN_() {
        return UserLoginSecurityGroupData.newBuilder()
            .setFromDate(getTimestamp("2001-01-01 12:00:00.0"))
            .setGroupId("VIEWADMIN")
            .setUserLoginId("auditor")
            .build();
    }


    public static UserLoginFlatData UserLogin_DemoSupplier() {
        return UserLoginFlatData.newBuilder()
            .setCurrentPassword("{SHA}47b56994cbc2b6d10aa1be30f70165adb305a41a")
            .setPartyId("DemoSupplier")
            .setUserLoginId("DemoSupplier")
            .build();
    }


    public static UserLoginFlatData UserLogin_auditor() {
        return UserLoginFlatData.newBuilder()
            .setCurrentPassword("{SHA}47b56994cbc2b6d10aa1be30f70165adb305a41a")
            .setPartyId("DemoAuditor")
            .setUserLoginId("auditor")
            .build();
    }


    public static PartyContactMechData PartyContactMech_admin_admin_() {
        return PartyContactMechData.newBuilder()
            .setAllowSolicitation(castIndicator("Y"))
            .setContactMechId("admin")
            .setFromDate(getTimestamp("2003-01-01 00:00:00.0"))
            .setPartyId("admin")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoSupplier_9001_() {
        return PartyContactMechData.newBuilder()
            .setAllowSolicitation(castIndicator("Y"))
            .setContactMechId("9001")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoSupplier")
            .build();
    }

}

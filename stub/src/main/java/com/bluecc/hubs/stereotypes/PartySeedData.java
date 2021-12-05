package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.PartyIdentificationTypeData;
import com.bluecc.hubs.stub.ContactMechTypeData;
import com.bluecc.hubs.stub.EnumerationData;
import com.bluecc.hubs.stub.PartyRelationshipTypeData;
import com.bluecc.hubs.stub.RoleTypeData;
import com.bluecc.hubs.stub.PartyContentTypeData;
import com.bluecc.hubs.stub.EnumerationTypeData;
import com.bluecc.hubs.stub.CommunicationEventPrpTypData;
import com.bluecc.hubs.stub.TermTypeData;
import com.bluecc.hubs.stub.StatusItemData;
import com.bluecc.hubs.stub.StatusValidChangeData;
import com.bluecc.hubs.stub.CommunicationEventTypeData;
import com.bluecc.hubs.stub.ContactMechTypePurposeData;
import com.bluecc.hubs.stub.PartyClassificationTypeData;
import com.bluecc.hubs.stub.StatusTypeData;
import com.bluecc.hubs.stub.SecurityGroupPermissionData;
import com.bluecc.hubs.stub.UserPreferenceData;
import com.bluecc.hubs.stub.PartyQualTypeData;
import com.bluecc.hubs.stub.PartyTypeData;
import com.bluecc.hubs.stub.SecurityPermissionData;
import com.bluecc.hubs.stub.ContactMechPurposeTypeData;

public final class PartySeedData {
    public final static PartyIdentificationTypeData PartyIdentificationType_PARTY_IMPORT = PartyIdentificationTypeData.newBuilder()
        .setDescription("Original ID in the system where this record was imported from")
        .setPartyIdentificationTypeId("PARTY_IMPORT")
        .build();


    public final static ContactMechTypeData ContactMechType_ELECTRONIC_ADDRESS = ContactMechTypeData.newBuilder()
        .setContactMechTypeId("ELECTRONIC_ADDRESS")
        .setDescription("Electronic Address")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechTypeData ContactMechType_POSTAL_ADDRESS = ContactMechTypeData.newBuilder()
        .setContactMechTypeId("POSTAL_ADDRESS")
        .setDescription("Postal Address")
        .setHasTable(castIndicator("Y"))
        .build();


    public final static ContactMechTypeData ContactMechType_TELECOM_NUMBER = ContactMechTypeData.newBuilder()
        .setContactMechTypeId("TELECOM_NUMBER")
        .setDescription("Phone Number")
        .setHasTable(castIndicator("Y"))
        .build();


    public final static ContactMechTypeData ContactMechType_EMAIL_ADDRESS = ContactMechTypeData.newBuilder()
        .setContactMechTypeId("EMAIL_ADDRESS")
        .setDescription("Email Address")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ELECTRONIC_ADDRESS")
        .build();


    public final static ContactMechTypeData ContactMechType_IP_ADDRESS = ContactMechTypeData.newBuilder()
        .setContactMechTypeId("IP_ADDRESS")
        .setDescription("Internet IP Address")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ELECTRONIC_ADDRESS")
        .build();


    public final static ContactMechTypeData ContactMechType_DOMAIN_NAME = ContactMechTypeData.newBuilder()
        .setContactMechTypeId("DOMAIN_NAME")
        .setDescription("Internet Domain Name")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ELECTRONIC_ADDRESS")
        .build();


    public final static ContactMechTypeData ContactMechType_WEB_ADDRESS = ContactMechTypeData.newBuilder()
        .setContactMechTypeId("WEB_ADDRESS")
        .setDescription("Web URL/Address")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ELECTRONIC_ADDRESS")
        .build();


    public final static ContactMechTypeData ContactMechType_INTERNAL_PARTYID = ContactMechTypeData.newBuilder()
        .setContactMechTypeId("INTERNAL_PARTYID")
        .setDescription("Internal Note via partyId")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ELECTRONIC_ADDRESS")
        .build();


    public final static ContactMechTypeData ContactMechType_FTP_ADDRESS = ContactMechTypeData.newBuilder()
        .setContactMechTypeId("FTP_ADDRESS")
        .setDescription("Ftp server connection")
        .setHasTable(castIndicator("Y"))
        .setParentTypeId("ELECTRONIC_ADDRESS")
        .build();


    public final static EnumerationData Enumeration_EMPS_FULLTIME = EnumerationData.newBuilder()
        .setDescription("Full-time Employed")
        .setEnumCode("FULLTIME")
        .setEnumId("EMPS_FULLTIME")
        .setEnumTypeId("EMPLOY_STTS")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_EMPS_PARTTIME = EnumerationData.newBuilder()
        .setDescription("Part-time Employed")
        .setEnumCode("PARTTIME")
        .setEnumId("EMPS_PARTTIME")
        .setEnumTypeId("EMPLOY_STTS")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_EMPS_SELF = EnumerationData.newBuilder()
        .setDescription("Self Employed")
        .setEnumCode("SELF")
        .setEnumId("EMPS_SELF")
        .setEnumTypeId("EMPLOY_STTS")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_EMPS_HOUSE = EnumerationData.newBuilder()
        .setDescription("House-Person")
        .setEnumCode("HOUSE")
        .setEnumId("EMPS_HOUSE")
        .setEnumTypeId("EMPLOY_STTS")
        .setSequenceId("04")
        .build();


    public final static EnumerationData Enumeration_EMPS_RETIRED = EnumerationData.newBuilder()
        .setDescription("Retired")
        .setEnumCode("RETIRED")
        .setEnumId("EMPS_RETIRED")
        .setEnumTypeId("EMPLOY_STTS")
        .setSequenceId("05")
        .build();


    public final static EnumerationData Enumeration_EMPS_STUDENT = EnumerationData.newBuilder()
        .setDescription("Student")
        .setEnumCode("STUDENT")
        .setEnumId("EMPS_STUDENT")
        .setEnumTypeId("EMPLOY_STTS")
        .setSequenceId("06")
        .build();


    public final static EnumerationData Enumeration_EMPS_UNEMP = EnumerationData.newBuilder()
        .setDescription("Unemployed")
        .setEnumCode("UNEMP")
        .setEnumId("EMPS_UNEMP")
        .setEnumTypeId("EMPLOY_STTS")
        .setSequenceId("07")
        .build();


    public final static EnumerationData Enumeration_SINGLE = EnumerationData.newBuilder()
        .setDescription("Single")
        .setEnumId("SINGLE")
        .setEnumTypeId("MARITAL_STATUS")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_MARRIED = EnumerationData.newBuilder()
        .setDescription("Married")
        .setEnumId("MARRIED")
        .setEnumTypeId("MARITAL_STATUS")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_PRESS_OWN = EnumerationData.newBuilder()
        .setDescription("Own Home")
        .setEnumCode("OWN")
        .setEnumId("PRESS_OWN")
        .setEnumTypeId("PTY_RESID_STTS")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_PRESS_PVT_TENANT = EnumerationData.newBuilder()
        .setDescription("Private Tenant")
        .setEnumCode("PVT_TENANT")
        .setEnumId("PRESS_PVT_TENANT")
        .setEnumTypeId("PTY_RESID_STTS")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_PRESS_PUB_TENANT = EnumerationData.newBuilder()
        .setDescription("Public Tenant")
        .setEnumCode("PUB_TENANT")
        .setEnumId("PRESS_PUB_TENANT")
        .setEnumTypeId("PTY_RESID_STTS")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_PRESS_PARENTS = EnumerationData.newBuilder()
        .setDescription("With Parents")
        .setEnumCode("PARENTS")
        .setEnumId("PRESS_PARENTS")
        .setEnumTypeId("PTY_RESID_STTS")
        .setSequenceId("04")
        .build();


    public final static EnumerationData Enumeration_PARTY_REGIS_CONFIRM = EnumerationData.newBuilder()
        .setDescription("Party Registration Confirmation")
        .setEnumCode("REGIS_CONFIRM")
        .setEnumId("PARTY_REGIS_CONFIRM")
        .setEnumTypeId("PARTY_EMAIL")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_UPD_PRSNL_INF_CNFRM = EnumerationData.newBuilder()
        .setDescription("Update Personal Info Confirmation")
        .setEnumCode("UPDAT_CONFIRM")
        .setEnumId("UPD_PRSNL_INF_CNFRM")
        .setEnumTypeId("PARTY_EMAIL")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_PRDS_EMAIL_VERIFY = EnumerationData.newBuilder()
        .setDescription("Party Email Address Verification")
        .setEnumCode("EMAIL_VERIFY")
        .setEnumId("PRDS_EMAIL_VERIFY")
        .setEnumTypeId("PARTY_EMAIL")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_PRDS_PARTYINV_EMAIL = EnumerationData.newBuilder()
        .setDescription("Party Invitation")
        .setEnumCode("INVITE_EMAIL")
        .setEnumId("PRDS_PARTYINV_EMAIL")
        .setEnumTypeId("PARTY_EMAIL")
        .setSequenceId("04")
        .build();


    public final static EnumerationData Enumeration_CONT_NOTI_EMAIL = EnumerationData.newBuilder()
        .setDescription("Contact-Us Notification")
        .setEnumCode("CONT_EMAIL")
        .setEnumId("CONT_NOTI_EMAIL")
        .setEnumTypeId("PARTY_EMAIL")
        .setSequenceId("05")
        .build();


    public final static EnumerationData Enumeration_PRDS_CUST_ACTIVATED = EnumerationData.newBuilder()
        .setDescription("Account Activated Notification")
        .setEnumCode("ACCOUNT_ACTIVATED")
        .setEnumId("PRDS_CUST_ACTIVATED")
        .setEnumTypeId("PARTY_EMAIL")
        .setSequenceId("06")
        .build();


    public final static EnumerationData Enumeration_UNSUB_CONT_LIST_NOTI = EnumerationData.newBuilder()
        .setDescription("Unsubscribe Contact List Notification")
        .setEnumCode("UNSUB_CONT_EMAIL")
        .setEnumId("UNSUB_CONT_LIST_NOTI")
        .setEnumTypeId("PARTY_EMAIL")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_SUB_CONT_LIST_NOTI = EnumerationData.newBuilder()
        .setDescription("Subscribe Contact List Notification")
        .setEnumCode("SUB_CONT_EMAIL")
        .setEnumId("SUB_CONT_LIST_NOTI")
        .setEnumTypeId("PARTY_EMAIL")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_UNSUB_CONT_LIST_VERI = EnumerationData.newBuilder()
        .setDescription("Unsubscribe Contact List Verify")
        .setEnumCode("UNSUB_CONT_VERIFY_EMAIL")
        .setEnumId("UNSUB_CONT_LIST_VERI")
        .setEnumTypeId("PARTY_EMAIL")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_CONT_EMAIL_TEMPLATE = EnumerationData.newBuilder()
        .setDescription("Contact List E-mail Template")
        .setEnumCode("CONT_EMAIL_TEMPLATE")
        .setEnumId("CONT_EMAIL_TEMPLATE")
        .setEnumTypeId("PARTY_EMAIL")
        .setSequenceId("04")
        .build();


    public final static EnumerationData Enumeration_ORGANIZATION_PARTY = EnumerationData.newBuilder()
        .setDescription("Organization party")
        .setEnumId("ORGANIZATION_PARTY")
        .setEnumTypeId("GLOBAL_PREFERENCES")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_VISUAL_THEME = EnumerationData.newBuilder()
        .setDescription("Visual Theme")
        .setEnumId("VISUAL_THEME")
        .setEnumTypeId("GLOBAL_PREFERENCES")
        .setSequenceId("02")
        .build();


    public final static PartyRelationshipTypeData PartyRelationshipType_AGENT = PartyRelationshipTypeData.newBuilder()
        .setHasTable(castIndicator("N"))
        .setPartyRelationshipName("Agent")
        .setPartyRelationshipTypeId("AGENT")
        .build();


    public final static PartyRelationshipTypeData PartyRelationshipType_CHILD = PartyRelationshipTypeData.newBuilder()
        .setHasTable(castIndicator("N"))
        .setPartyRelationshipName("Child")
        .setPartyRelationshipTypeId("CHILD")
        .build();


    public final static PartyRelationshipTypeData PartyRelationshipType_CONTACT_REL = PartyRelationshipTypeData.newBuilder()
        .setHasTable(castIndicator("N"))
        .setPartyRelationshipName("Contact Relation")
        .setPartyRelationshipTypeId("CONTACT_REL")
        .build();


    public final static PartyRelationshipTypeData PartyRelationshipType_LEAD_REL = PartyRelationshipTypeData.newBuilder()
        .setHasTable(castIndicator("N"))
        .setPartyRelationshipName("Lead Relation")
        .setPartyRelationshipTypeId("LEAD_REL")
        .build();


    public final static PartyRelationshipTypeData PartyRelationshipType_LEAD_OWNER = PartyRelationshipTypeData.newBuilder()
        .setHasTable(castIndicator("N"))
        .setPartyRelationshipName("Lead Owned by")
        .setPartyRelationshipTypeId("LEAD_OWNER")
        .build();


    public final static PartyRelationshipTypeData PartyRelationshipType_CUSTOMER_REL = PartyRelationshipTypeData.newBuilder()
        .setHasTable(castIndicator("N"))
        .setPartyRelationshipName("Customer")
        .setPartyRelationshipTypeId("CUSTOMER_REL")
        .setRoleTypeIdValidFrom("CUSTOMER")
        .build();


    public final static PartyRelationshipTypeData PartyRelationshipType_DISTRIBUTION_CHANNEL = PartyRelationshipTypeData.newBuilder()
        .setHasTable(castIndicator("N"))
        .setPartyRelationshipName("Distributor")
        .setPartyRelationshipTypeId("DISTRIBUTION_CHANNEL")
        .build();


    public final static PartyRelationshipTypeData PartyRelationshipType_EMPLOYMENT = PartyRelationshipTypeData.newBuilder()
        .setHasTable(castIndicator("Y"))
        .setPartyRelationshipName("Employee")
        .setPartyRelationshipTypeId("EMPLOYMENT")
        .build();


    public final static PartyRelationshipTypeData PartyRelationshipType_FRIEND = PartyRelationshipTypeData.newBuilder()
        .setHasTable(castIndicator("N"))
        .setPartyRelationshipName("Friend")
        .setPartyRelationshipTypeId("FRIEND")
        .build();


    public final static PartyRelationshipTypeData PartyRelationshipType_GROUP_ROLLUP = PartyRelationshipTypeData.newBuilder()
        .setHasTable(castIndicator("N"))
        .setPartyRelationshipName("Group Member")
        .setPartyRelationshipTypeId("GROUP_ROLLUP")
        .build();


    public final static PartyRelationshipTypeData PartyRelationshipType_HOST_SERVER_VISITOR = PartyRelationshipTypeData.newBuilder()
        .setHasTable(castIndicator("N"))
        .setPartyRelationshipName("Host Server Visitor")
        .setPartyRelationshipTypeId("HOST_SERVER_VISITOR")
        .build();


    public final static PartyRelationshipTypeData PartyRelationshipType_VISITOR_ISP = PartyRelationshipTypeData.newBuilder()
        .setHasTable(castIndicator("N"))
        .setPartyRelationshipName("ISP Visitor")
        .setPartyRelationshipTypeId("VISITOR_ISP")
        .build();


    public final static PartyRelationshipTypeData PartyRelationshipType_MANAGER = PartyRelationshipTypeData.newBuilder()
        .setHasTable(castIndicator("N"))
        .setPartyRelationshipName("Manager")
        .setPartyRelationshipTypeId("MANAGER")
        .build();


    public final static PartyRelationshipTypeData PartyRelationshipType_PARENT = PartyRelationshipTypeData.newBuilder()
        .setHasTable(castIndicator("N"))
        .setPartyRelationshipName("Parent")
        .setPartyRelationshipTypeId("PARENT")
        .build();


    public final static PartyRelationshipTypeData PartyRelationshipType_PARTNERSHIP = PartyRelationshipTypeData.newBuilder()
        .setHasTable(castIndicator("N"))
        .setPartyRelationshipName("Partner")
        .setPartyRelationshipTypeId("PARTNERSHIP")
        .build();


    public final static PartyRelationshipTypeData PartyRelationshipType_SALES_AFFILIATE = PartyRelationshipTypeData.newBuilder()
        .setHasTable(castIndicator("N"))
        .setPartyRelationshipName("Sales Affiliate")
        .setPartyRelationshipTypeId("SALES_AFFILIATE")
        .build();


    public final static PartyRelationshipTypeData PartyRelationshipType_SPOUSE = PartyRelationshipTypeData.newBuilder()
        .setHasTable(castIndicator("N"))
        .setPartyRelationshipName("Spouse")
        .setPartyRelationshipTypeId("SPOUSE")
        .build();


    public final static PartyRelationshipTypeData PartyRelationshipType_SUPPLIER_REL = PartyRelationshipTypeData.newBuilder()
        .setHasTable(castIndicator("Y"))
        .setPartyRelationshipName("Supplier")
        .setPartyRelationshipTypeId("SUPPLIER_REL")
        .build();


    public final static PartyRelationshipTypeData PartyRelationshipType_WEB_MASTER_ASSIGNMEN = PartyRelationshipTypeData.newBuilder()
        .setHasTable(castIndicator("N"))
        .setPartyRelationshipName("Web Master")
        .setPartyRelationshipTypeId("WEB_MASTER_ASSIGNMEN")
        .build();


    public final static PartyRelationshipTypeData PartyRelationshipType_ACCOUNT = PartyRelationshipTypeData.newBuilder()
        .setHasTable(castIndicator("N"))
        .setPartyRelationshipName("Account owned by")
        .setPartyRelationshipTypeId("ACCOUNT")
        .build();


    public final static PartyRelationshipTypeData PartyRelationshipType_ASSISTANT = PartyRelationshipTypeData.newBuilder()
        .setHasTable(castIndicator("N"))
        .setPartyRelationshipName("Assistant")
        .setPartyRelationshipTypeId("ASSISTANT")
        .build();


    public final static PartyRelationshipTypeData PartyRelationshipType_OWNER = PartyRelationshipTypeData.newBuilder()
        .setHasTable(castIndicator("N"))
        .setPartyRelationshipName("Owned by")
        .setPartyRelationshipTypeId("OWNER")
        .build();


    public final static PartyRelationshipTypeData PartyRelationshipType_PARENT_ACCOUNT = PartyRelationshipTypeData.newBuilder()
        .setHasTable(castIndicator("N"))
        .setPartyRelationshipName("Parent Account")
        .setPartyRelationshipTypeId("PARENT_ACCOUNT")
        .build();


    public final static PartyRelationshipTypeData PartyRelationshipType_REPORTS_TO = PartyRelationshipTypeData.newBuilder()
        .setHasTable(castIndicator("N"))
        .setPartyRelationshipName("Reports To")
        .setPartyRelationshipTypeId("REPORTS_TO")
        .build();


    public final static PartyRelationshipTypeData PartyRelationshipType_LEAD_OWN_GRP_MEMBER = PartyRelationshipTypeData.newBuilder()
        .setHasTable(castIndicator("N"))
        .setPartyRelationshipName("Lead Owners/Managers")
        .setPartyRelationshipTypeId("LEAD_OWN_GRP_MEMBER")
        .build();


    public final static RoleTypeData RoleType_MAIN_ROLE = RoleTypeData.newBuilder()
        .setDescription("Main Role")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("MAIN_ROLE")
        .build();


    public final static RoleTypeData RoleType_ACCOUNT_LEAD = RoleTypeData.newBuilder()
        .setDescription("Account Lead")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("ACCOUNT_LEAD")
        .build();


    public final static RoleTypeData RoleType_ADMIN = RoleTypeData.newBuilder()
        .setDescription("Administrator")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("ADMIN")
        .build();


    public final static RoleTypeData RoleType_AGENT = RoleTypeData.newBuilder()
        .setDescription("Agent")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("AGENT")
        .build();


    public final static RoleTypeData RoleType_AUTOMATED_AGENT_ROLE = RoleTypeData.newBuilder()
        .setDescription("Automated Agent")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("AUTOMATED_AGENT_ROLE")
        .build();


    public final static RoleTypeData RoleType_CALENDAR_ROLE = RoleTypeData.newBuilder()
        .setDescription("Calendar")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("CALENDAR_ROLE")
        .build();


    public final static RoleTypeData RoleType_CLIENT = RoleTypeData.newBuilder()
        .setDescription("Client")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("CLIENT")
        .build();


    public final static RoleTypeData RoleType_COMMEVENT_ROLE = RoleTypeData.newBuilder()
        .setDescription("Communication Participant")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("COMMEVENT_ROLE")
        .build();


    public final static RoleTypeData RoleType_CONSUMER = RoleTypeData.newBuilder()
        .setDescription("Consumer")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("CONSUMER")
        .build();


    public final static RoleTypeData RoleType_CONTRACTOR = RoleTypeData.newBuilder()
        .setDescription("Contractor")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("CONTRACTOR")
        .build();


    public final static RoleTypeData RoleType_CUSTOMER = RoleTypeData.newBuilder()
        .setDescription("Customer")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("CUSTOMER")
        .build();


    public final static RoleTypeData RoleType_DISTRIBUTION_CHANNEL = RoleTypeData.newBuilder()
        .setDescription("Distribution Channel")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("DISTRIBUTION_CHANNEL")
        .build();


    public final static RoleTypeData RoleType_ISP = RoleTypeData.newBuilder()
        .setDescription("ISP")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("ISP")
        .build();


    public final static RoleTypeData RoleType_HOSTING_SERVER = RoleTypeData.newBuilder()
        .setDescription("Hosting Server")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("HOSTING_SERVER")
        .build();


    public final static RoleTypeData RoleType_MANUFACTURER = RoleTypeData.newBuilder()
        .setDescription("Manufacturer")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("MANUFACTURER")
        .build();


    public final static RoleTypeData RoleType__NA_ = RoleTypeData.newBuilder()
        .setDescription("Not Applicable")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("_NA_")
        .build();


    public final static RoleTypeData RoleType_ORGANIZATION_ROLE = RoleTypeData.newBuilder()
        .setDescription("Organization")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("MAIN_ROLE")
        .setRoleTypeId("ORGANIZATION_ROLE")
        .build();


    public final static RoleTypeData RoleType_OWNER = RoleTypeData.newBuilder()
        .setDescription("Owner")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("OWNER")
        .build();


    public final static RoleTypeData RoleType_PROSPECT = RoleTypeData.newBuilder()
        .setDescription("Prospect")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("PROSPECT")
        .build();


    public final static RoleTypeData RoleType_PERSON_ROLE = RoleTypeData.newBuilder()
        .setDescription("Person")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("PERSON_ROLE")
        .build();


    public final static RoleTypeData RoleType_REFERRER = RoleTypeData.newBuilder()
        .setDescription("Referrer")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("REFERRER")
        .build();


    public final static RoleTypeData RoleType_REQUEST_ROLE = RoleTypeData.newBuilder()
        .setDescription("Request Role")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("REQUEST_ROLE")
        .build();


    public final static RoleTypeData RoleType_REQ_MANAGER = RoleTypeData.newBuilder()
        .setDescription("Request Manager")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("REQUEST_ROLE")
        .setRoleTypeId("REQ_MANAGER")
        .build();


    public final static RoleTypeData RoleType_REQ_REQUESTER = RoleTypeData.newBuilder()
        .setDescription("Requesting Party")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("REQUEST_ROLE")
        .setRoleTypeId("REQ_REQUESTER")
        .build();


    public final static RoleTypeData RoleType_REQ_TAKER = RoleTypeData.newBuilder()
        .setDescription("Request Taker")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("REQUEST_ROLE")
        .setRoleTypeId("REQ_TAKER")
        .build();


    public final static RoleTypeData RoleType_REQ_RESPOND = RoleTypeData.newBuilder()
        .setDescription("Request Respondent")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("REQUEST_ROLE")
        .setRoleTypeId("REQ_RESPOND")
        .build();


    public final static RoleTypeData RoleType_SFA_ROLE = RoleTypeData.newBuilder()
        .setDescription("Sales Force Autm.")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("MAIN_ROLE")
        .setRoleTypeId("SFA_ROLE")
        .build();


    public final static RoleTypeData RoleType_SHAREHOLDER = RoleTypeData.newBuilder()
        .setDescription("Shareholder")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("SHAREHOLDER")
        .build();


    public final static RoleTypeData RoleType_SUBSCRIBER = RoleTypeData.newBuilder()
        .setDescription("Subscriber")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("SUBSCRIBER")
        .build();


    public final static RoleTypeData RoleType_VENDOR = RoleTypeData.newBuilder()
        .setDescription("Vendor")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("VENDOR")
        .build();


    public final static RoleTypeData RoleType_VISITOR = RoleTypeData.newBuilder()
        .setDescription("Visitor")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("VISITOR")
        .build();


    public final static RoleTypeData RoleType_WEB_MASTER = RoleTypeData.newBuilder()
        .setDescription("Web Master")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("WEB_MASTER")
        .build();


    public final static RoleTypeData RoleType_WORKFLOW_ROLE = RoleTypeData.newBuilder()
        .setDescription("Workflow")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("WORKFLOW_ROLE")
        .build();


    public final static RoleTypeData RoleType_ACCOUNTANT = RoleTypeData.newBuilder()
        .setDescription("Accountant")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("ACCOUNTANT")
        .build();


    public final static RoleTypeData RoleType_ACCOUNT = RoleTypeData.newBuilder()
        .setDescription("Account")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("SFA_ROLE")
        .setRoleTypeId("ACCOUNT")
        .build();


    public final static RoleTypeData RoleType_ADDRESSEE = RoleTypeData.newBuilder()
        .setDescription("Addressee")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("COMMEVENT_ROLE")
        .setRoleTypeId("ADDRESSEE")
        .build();


    public final static RoleTypeData RoleType_ASSOCIATION = RoleTypeData.newBuilder()
        .setDescription("Association")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ORGANIZATION_ROLE")
        .setRoleTypeId("ASSOCIATION")
        .build();


    public final static RoleTypeData RoleType_BILL_FROM_VENDOR = RoleTypeData.newBuilder()
        .setDescription("Bill-From Vendor")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("VENDOR")
        .setRoleTypeId("BILL_FROM_VENDOR")
        .build();


    public final static RoleTypeData RoleType_BILL_TO_CUSTOMER = RoleTypeData.newBuilder()
        .setDescription("Bill-To Customer")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CUSTOMER")
        .setRoleTypeId("BILL_TO_CUSTOMER")
        .build();


    public final static RoleTypeData RoleType_BCC = RoleTypeData.newBuilder()
        .setDescription("Blind Copy")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("COMMEVENT_ROLE")
        .setRoleTypeId("BCC")
        .build();


    public final static RoleTypeData RoleType_BULK_CUSTOMER = RoleTypeData.newBuilder()
        .setDescription("Bulk Customer")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CUSTOMER")
        .setRoleTypeId("BULK_CUSTOMER")
        .build();


    public final static RoleTypeData RoleType_CAL_ATTENDEE = RoleTypeData.newBuilder()
        .setDescription("Calendar Attendee")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CALENDAR_ROLE")
        .setRoleTypeId("CAL_ATTENDEE")
        .build();


    public final static RoleTypeData RoleType_CAL_DELEGATE = RoleTypeData.newBuilder()
        .setDescription("Calendar Delegate")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CALENDAR_ROLE")
        .setRoleTypeId("CAL_DELEGATE")
        .build();


    public final static RoleTypeData RoleType_CAL_HOST = RoleTypeData.newBuilder()
        .setDescription("Calendar Host")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CALENDAR_ROLE")
        .setRoleTypeId("CAL_HOST")
        .build();


    public final static RoleTypeData RoleType_CAL_ORGANIZER = RoleTypeData.newBuilder()
        .setDescription("Calendar Organizer")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CALENDAR_ROLE")
        .setRoleTypeId("CAL_ORGANIZER")
        .build();


    public final static RoleTypeData RoleType_CAL_OWNER = RoleTypeData.newBuilder()
        .setDescription("Calendar Owner")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CALENDAR_ROLE")
        .setRoleTypeId("CAL_OWNER")
        .build();


    public final static RoleTypeData RoleType_CARRIER = RoleTypeData.newBuilder()
        .setDescription("Carrier")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ORGANIZATION_ROLE")
        .setRoleTypeId("CARRIER")
        .build();


    public final static RoleTypeData RoleType_COMPETITOR = RoleTypeData.newBuilder()
        .setDescription("Competitor")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ORGANIZATION_ROLE")
        .setRoleTypeId("COMPETITOR")
        .build();


    public final static RoleTypeData RoleType_CONTACT = RoleTypeData.newBuilder()
        .setDescription("Contact")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("SFA_ROLE")
        .setRoleTypeId("CONTACT")
        .build();


    public final static RoleTypeData RoleType_CC = RoleTypeData.newBuilder()
        .setDescription("Carbon Copy")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("COMMEVENT_ROLE")
        .setRoleTypeId("CC")
        .build();


    public final static RoleTypeData RoleType_ORIGINATOR = RoleTypeData.newBuilder()
        .setDescription("Originator")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("COMMEVENT_ROLE")
        .setRoleTypeId("ORIGINATOR")
        .build();


    public final static RoleTypeData RoleType_DISTRIBUTOR = RoleTypeData.newBuilder()
        .setDescription("Distributor")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("DISTRIBUTION_CHANNEL")
        .setRoleTypeId("DISTRIBUTOR")
        .build();


    public final static RoleTypeData RoleType_EMPLOYEE = RoleTypeData.newBuilder()
        .setDescription("Employee")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("PERSON_ROLE")
        .setRoleTypeId("EMPLOYEE")
        .build();


    public final static RoleTypeData RoleType_END_USER_CUSTOMER = RoleTypeData.newBuilder()
        .setDescription("End-User Customer")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CUSTOMER")
        .setRoleTypeId("END_USER_CUSTOMER")
        .build();


    public final static RoleTypeData RoleType_HOUSEHOLD = RoleTypeData.newBuilder()
        .setDescription("Household")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ORGANIZATION_ROLE")
        .setRoleTypeId("HOUSEHOLD")
        .build();


    public final static RoleTypeData RoleType_INTERNAL_ORGANIZATIO = RoleTypeData.newBuilder()
        .setDescription("Internal Organization")
        .setHasTable(castIndicator("Y"))
        .setParentTypeId("ORGANIZATION_ROLE")
        .setRoleTypeId("INTERNAL_ORGANIZATIO")
        .build();


    public final static RoleTypeData RoleType_LEAD = RoleTypeData.newBuilder()
        .setDescription("Lead")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("SFA_ROLE")
        .setRoleTypeId("LEAD")
        .build();


    public final static RoleTypeData RoleType_LTD_ADMIN = RoleTypeData.newBuilder()
        .setDescription("Limited Administrator")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ADMIN")
        .setRoleTypeId("LTD_ADMIN")
        .build();


    public final static RoleTypeData RoleType_ORGANIZATION_UNIT = RoleTypeData.newBuilder()
        .setDescription("Organization Unit")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ORGANIZATION_ROLE")
        .setRoleTypeId("ORGANIZATION_UNIT")
        .build();


    public final static RoleTypeData RoleType_PARTNER = RoleTypeData.newBuilder()
        .setDescription("Partner")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ORGANIZATION_ROLE")
        .setRoleTypeId("PARTNER")
        .build();


    public final static RoleTypeData RoleType_PLACING_CUSTOMER = RoleTypeData.newBuilder()
        .setDescription("Placing Customer")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CUSTOMER")
        .setRoleTypeId("PLACING_CUSTOMER")
        .build();


    public final static RoleTypeData RoleType_REGULATORY_AGENCY = RoleTypeData.newBuilder()
        .setDescription("Regulatory Agency")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ORGANIZATION_ROLE")
        .setRoleTypeId("REGULATORY_AGENCY")
        .build();


    public final static RoleTypeData RoleType_SALES_REP = RoleTypeData.newBuilder()
        .setDescription("Sales Representative")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("PERSON_ROLE")
        .setRoleTypeId("SALES_REP")
        .build();


    public final static RoleTypeData RoleType_SHIP_FROM_VENDOR = RoleTypeData.newBuilder()
        .setDescription("Ship-From Vendor")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("VENDOR")
        .setRoleTypeId("SHIP_FROM_VENDOR")
        .build();


    public final static RoleTypeData RoleType_SHIP_TO_CUSTOMER = RoleTypeData.newBuilder()
        .setDescription("Ship-To Customer")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CUSTOMER")
        .setRoleTypeId("SHIP_TO_CUSTOMER")
        .build();


    public final static RoleTypeData RoleType_SPONSOR = RoleTypeData.newBuilder()
        .setDescription("Sponsor")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("PERSON_ROLE")
        .setRoleTypeId("SPONSOR")
        .build();


    public final static RoleTypeData RoleType_SPOUSE = RoleTypeData.newBuilder()
        .setDescription("Spouse")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("PERSON_ROLE")
        .setRoleTypeId("SPOUSE")
        .build();


    public final static RoleTypeData RoleType_SUPPLIER_AGENT = RoleTypeData.newBuilder()
        .setDescription("Supplier Agent")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("PERSON_ROLE")
        .setRoleTypeId("SUPPLIER_AGENT")
        .build();


    public final static RoleTypeData RoleType_SUPPLIER = RoleTypeData.newBuilder()
        .setDescription("Supplier")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ORGANIZATION_ROLE")
        .setRoleTypeId("SUPPLIER")
        .build();


    public final static RoleTypeData RoleType_TAX_AUTHORITY = RoleTypeData.newBuilder()
        .setDescription("Tax Authority")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ORGANIZATION_ROLE")
        .setRoleTypeId("TAX_AUTHORITY")
        .build();


    public final static RoleTypeData RoleType_UNION = RoleTypeData.newBuilder()
        .setDescription("Union")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ORGANIZATION_ROLE")
        .setRoleTypeId("UNION")
        .build();


    public final static RoleTypeData RoleType_WF_OWNER = RoleTypeData.newBuilder()
        .setDescription("Workflow Owner")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("WORKFLOW_ROLE")
        .setRoleTypeId("WF_OWNER")
        .build();


    public final static RoleTypeData RoleType_GOV_AGENCY = RoleTypeData.newBuilder()
        .setDescription("Government Agency")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ORGANIZATION_ROLE")
        .setRoleTypeId("GOV_AGENCY")
        .build();


    public final static RoleTypeData RoleType_AFFILIATE = RoleTypeData.newBuilder()
        .setDescription("Affiliate")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("SALES_REP")
        .setRoleTypeId("AFFILIATE")
        .build();


    public final static RoleTypeData RoleType_BUYER = RoleTypeData.newBuilder()
        .setDescription("Buyer")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("EMPLOYEE")
        .setRoleTypeId("BUYER")
        .build();


    public final static RoleTypeData RoleType_CASHIER = RoleTypeData.newBuilder()
        .setDescription("Cashier")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("EMPLOYEE")
        .setRoleTypeId("CASHIER")
        .build();


    public final static RoleTypeData RoleType_DEPARTMENT = RoleTypeData.newBuilder()
        .setDescription("Department")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ORGANIZATION_UNIT")
        .setRoleTypeId("DEPARTMENT")
        .build();


    public final static RoleTypeData RoleType_DIVISION = RoleTypeData.newBuilder()
        .setDescription("Division")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ORGANIZATION_UNIT")
        .setRoleTypeId("DIVISION")
        .build();


    public final static RoleTypeData RoleType_FAMILY_MEMBER = RoleTypeData.newBuilder()
        .setDescription("Family Member")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("PERSON_ROLE")
        .setRoleTypeId("FAMILY_MEMBER")
        .build();


    public final static RoleTypeData RoleType_MANAGER = RoleTypeData.newBuilder()
        .setDescription("Manager")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("EMPLOYEE")
        .setRoleTypeId("MANAGER")
        .build();


    public final static RoleTypeData RoleType_ORDER_CLERK = RoleTypeData.newBuilder()
        .setDescription("Order Clerk")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("EMPLOYEE")
        .setRoleTypeId("ORDER_CLERK")
        .build();


    public final static RoleTypeData RoleType_OTHER_INTERNAL_ORGAN = RoleTypeData.newBuilder()
        .setDescription("Other Internal")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("INTERNAL_ORGANIZATIO")
        .setRoleTypeId("OTHER_INTERNAL_ORGAN")
        .build();


    public final static RoleTypeData RoleType_OTHER_ORGANIZATION_U = RoleTypeData.newBuilder()
        .setDescription("Other Organization Unit")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ORGANIZATION_UNIT")
        .setRoleTypeId("OTHER_ORGANIZATION_U")
        .build();


    public final static RoleTypeData RoleType_PARENT_ORGANIZATION = RoleTypeData.newBuilder()
        .setDescription("Parent Organization")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ORGANIZATION_UNIT")
        .setRoleTypeId("PARENT_ORGANIZATION")
        .build();


    public final static RoleTypeData RoleType_PACKER = RoleTypeData.newBuilder()
        .setDescription("Packer")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("EMPLOYEE")
        .setRoleTypeId("PACKER")
        .build();


    public final static RoleTypeData RoleType_PICKER = RoleTypeData.newBuilder()
        .setDescription("Picker")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("EMPLOYEE")
        .setRoleTypeId("PICKER")
        .build();


    public final static RoleTypeData RoleType_RECEIVER = RoleTypeData.newBuilder()
        .setDescription("Receiver")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("EMPLOYEE")
        .setRoleTypeId("RECEIVER")
        .build();


    public final static RoleTypeData RoleType_SHIPMENT_CLERK = RoleTypeData.newBuilder()
        .setDescription("Shipment Clerk")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("EMPLOYEE")
        .setRoleTypeId("SHIPMENT_CLERK")
        .build();


    public final static RoleTypeData RoleType_STOCKER = RoleTypeData.newBuilder()
        .setDescription("Stocker")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("EMPLOYEE")
        .setRoleTypeId("STOCKER")
        .build();


    public final static RoleTypeData RoleType_SUBSIDIARY = RoleTypeData.newBuilder()
        .setDescription("Subsidiary")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ORGANIZATION_UNIT")
        .setRoleTypeId("SUBSIDIARY")
        .build();


    public final static RoleTypeData RoleType_WORKER = RoleTypeData.newBuilder()
        .setDescription("Worker")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("EMPLOYEE")
        .setRoleTypeId("WORKER")
        .build();


    public final static RoleTypeData RoleType_EMAIL_ADMIN = RoleTypeData.newBuilder()
        .setDescription("Email Administrator")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("PERSON_ROLE")
        .setRoleTypeId("EMAIL_ADMIN")
        .build();


    public final static PartyContentTypeData PartyContentType_INTERNAL = PartyContentTypeData.newBuilder()
        .setDescription("Internal Content")
        .setPartyContentTypeId("INTERNAL")
        .build();


    public final static PartyContentTypeData PartyContentType_USERDEF = PartyContentTypeData.newBuilder()
        .setDescription("User Defined Content")
        .setPartyContentTypeId("USERDEF")
        .build();


    public final static PartyContentTypeData PartyContentType_LGOIMGURL = PartyContentTypeData.newBuilder()
        .setDescription("Logo Image URL")
        .setPartyContentTypeId("LGOIMGURL")
        .build();


    public final static PartyContentTypeData PartyContentType_VNDSHPINF = PartyContentTypeData.newBuilder()
        .setDescription("Vendor Shipping Info")
        .setPartyContentTypeId("VNDSHPINF")
        .build();


    public final static EnumerationTypeData EnumerationType_EMPLOY_STTS = EnumerationTypeData.newBuilder()
        .setDescription("Employment Status")
        .setEnumTypeId("EMPLOY_STTS")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_MARITAL_STATUS = EnumerationTypeData.newBuilder()
        .setDescription("Marital Status")
        .setEnumTypeId("MARITAL_STATUS")
        .build();


    public final static EnumerationTypeData EnumerationType_PTY_RESID_STTS = EnumerationTypeData.newBuilder()
        .setDescription("Residence Status")
        .setEnumTypeId("PTY_RESID_STTS")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_PARTY_EMAIL = EnumerationTypeData.newBuilder()
        .setDescription("Party Email Notification")
        .setEnumTypeId("PARTY_EMAIL")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_USER_PREF_GROUPS = EnumerationTypeData.newBuilder()
        .setDescription("User preference groups")
        .setEnumTypeId("USER_PREF_GROUPS")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_GLOBAL_PREFERENCES = EnumerationTypeData.newBuilder()
        .setDescription("Global preferences")
        .setEnumTypeId("GLOBAL_PREFERENCES")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("USER_PREF_GROUPS")
        .build();


    public final static CommunicationEventPrpTypData CommunicationEventPrpTyp_ACTIVITY_REQUEST = CommunicationEventPrpTypData.newBuilder()
        .setCommunicationEventPrpTypId("ACTIVITY_REQUEST")
        .setDescription("Activity Request")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CommunicationEventPrpTypData CommunicationEventPrpTyp_CONFERENCE = CommunicationEventPrpTypData.newBuilder()
        .setCommunicationEventPrpTypId("CONFERENCE")
        .setDescription("Conference")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CommunicationEventPrpTypData CommunicationEventPrpTyp_CUSTOMER_SERVICE_CAL = CommunicationEventPrpTypData.newBuilder()
        .setCommunicationEventPrpTypId("CUSTOMER_SERVICE_CAL")
        .setDescription("Customer Service Call")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CommunicationEventPrpTypData CommunicationEventPrpTyp_INQUIRY = CommunicationEventPrpTypData.newBuilder()
        .setCommunicationEventPrpTypId("INQUIRY")
        .setDescription("Inquiry")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CommunicationEventPrpTypData CommunicationEventPrpTyp_MEETING = CommunicationEventPrpTypData.newBuilder()
        .setCommunicationEventPrpTypId("MEETING")
        .setDescription("Meeting")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CommunicationEventPrpTypData CommunicationEventPrpTyp_SALES_FOLLOW_UP = CommunicationEventPrpTypData.newBuilder()
        .setCommunicationEventPrpTypId("SALES_FOLLOW_UP")
        .setDescription("Sales Follow Up")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CommunicationEventPrpTypData CommunicationEventPrpTyp_SEMINAR = CommunicationEventPrpTypData.newBuilder()
        .setCommunicationEventPrpTypId("SEMINAR")
        .setDescription("Seminar")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CommunicationEventPrpTypData CommunicationEventPrpTyp_SUPPORT_CALL = CommunicationEventPrpTypData.newBuilder()
        .setCommunicationEventPrpTypId("SUPPORT_CALL")
        .setDescription("Support Call")
        .setHasTable(castIndicator("N"))
        .build();


    public final static TermTypeData TermType_FINANCIAL_TERM = TermTypeData.newBuilder()
        .setDescription("Financial")
        .setHasTable(castIndicator("N"))
        .setTermTypeId("FINANCIAL_TERM")
        .build();


    public final static TermTypeData TermType_FIN_PAYMENT_TERM = TermTypeData.newBuilder()
        .setDescription("Payment (net days)")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("FINANCIAL_TERM")
        .setTermTypeId("FIN_PAYMENT_TERM")
        .build();


    public final static TermTypeData TermType_FIN_PAY_NETDAYS_1 = TermTypeData.newBuilder()
        .setDescription("Payment net days, part 1")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("FIN_PAYMENT_TERM")
        .setTermTypeId("FIN_PAY_NETDAYS_1")
        .build();


    public final static TermTypeData TermType_FIN_PAY_NETDAYS_2 = TermTypeData.newBuilder()
        .setDescription("Payment net days, part 2")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("FIN_PAYMENT_TERM")
        .setTermTypeId("FIN_PAY_NETDAYS_2")
        .build();


    public final static TermTypeData TermType_FIN_PAY_NETDAYS_3 = TermTypeData.newBuilder()
        .setDescription("Payment net days, part 3")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("FIN_PAYMENT_TERM")
        .setTermTypeId("FIN_PAY_NETDAYS_3")
        .build();


    public final static TermTypeData TermType_FIN_PAYMENT_DISC = TermTypeData.newBuilder()
        .setDescription("Payment (discounted if paid within specified days)")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("FINANCIAL_TERM")
        .setTermTypeId("FIN_PAYMENT_DISC")
        .build();


    public final static TermTypeData TermType_FIN_PAYMENT_FIXDAY = TermTypeData.newBuilder()
        .setDescription("Payment (due on specified day of month)")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("FINANCIAL_TERM")
        .setTermTypeId("FIN_PAYMENT_FIXDAY")
        .build();


    public final static TermTypeData TermType_FIN_LATE_FEE_TERM = TermTypeData.newBuilder()
        .setDescription("Late Fee (percent)")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("FINANCIAL_TERM")
        .setTermTypeId("FIN_LATE_FEE_TERM")
        .build();


    public final static TermTypeData TermType_FIN_COLLECT_TERM = TermTypeData.newBuilder()
        .setDescription("Penalty For Collection Agency")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("FINANCIAL_TERM")
        .setTermTypeId("FIN_COLLECT_TERM")
        .build();


    public final static TermTypeData TermType_FIN_NORTN_ITEM_TERM = TermTypeData.newBuilder()
        .setDescription("Non-Returnable Sales Item")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("FINANCIAL_TERM")
        .setTermTypeId("FIN_NORTN_ITEM_TERM")
        .build();


    public final static TermTypeData TermType_INCENTIVE = TermTypeData.newBuilder()
        .setDescription("Incentive")
        .setHasTable(castIndicator("N"))
        .setTermTypeId("INCENTIVE")
        .build();


    public final static TermTypeData TermType_LEGAL_TERM = TermTypeData.newBuilder()
        .setDescription("Legal")
        .setHasTable(castIndicator("N"))
        .setTermTypeId("LEGAL_TERM")
        .build();


    public final static TermTypeData TermType_THRESHOLD = TermTypeData.newBuilder()
        .setDescription("Threshold")
        .setHasTable(castIndicator("N"))
        .setTermTypeId("THRESHOLD")
        .build();


    public final static TermTypeData TermType_CLAUSE_FOR_RENEWAL = TermTypeData.newBuilder()
        .setDescription("Clause For Renewal")
        .setHasTable(castIndicator("N"))
        .setTermTypeId("CLAUSE_FOR_RENEWAL")
        .build();


    public final static TermTypeData TermType_AGREEMENT_TERMINATIO = TermTypeData.newBuilder()
        .setDescription("Agreement Termination")
        .setHasTable(castIndicator("N"))
        .setTermTypeId("AGREEMENT_TERMINATIO")
        .build();


    public final static TermTypeData TermType_INDEMNIFICATION = TermTypeData.newBuilder()
        .setDescription("Indemnification")
        .setHasTable(castIndicator("N"))
        .setTermTypeId("INDEMNIFICATION")
        .build();


    public final static TermTypeData TermType_NON_COMPETE = TermTypeData.newBuilder()
        .setDescription("Non-Compete")
        .setHasTable(castIndicator("N"))
        .setTermTypeId("NON_COMPETE")
        .build();


    public final static TermTypeData TermType_EXCLUSIVE_RELATIONSH = TermTypeData.newBuilder()
        .setDescription("Exclusive Relationship")
        .setHasTable(castIndicator("N"))
        .setTermTypeId("EXCLUSIVE_RELATIONSH")
        .build();


    public final static TermTypeData TermType_COMMISSION_TERM = TermTypeData.newBuilder()
        .setDescription("Commission")
        .setHasTable(castIndicator("N"))
        .setTermTypeId("COMMISSION_TERM")
        .build();


    public final static TermTypeData TermType_FIN_COMM_FIXED = TermTypeData.newBuilder()
        .setDescription("Commission Term Fixed Per Unit")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("COMMISSION_TERM")
        .setTermTypeId("FIN_COMM_FIXED")
        .build();


    public final static TermTypeData TermType_FIN_COMM_VARIABLE = TermTypeData.newBuilder()
        .setDescription("Commission Term Variable")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("COMMISSION_TERM")
        .setTermTypeId("FIN_COMM_VARIABLE")
        .build();


    public final static TermTypeData TermType_FIN_COMM_MIN = TermTypeData.newBuilder()
        .setDescription("Commission Term Minimum Per Unit")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("COMMISSION_TERM")
        .setTermTypeId("FIN_COMM_MIN")
        .build();


    public final static TermTypeData TermType_FIN_COMM_MAX = TermTypeData.newBuilder()
        .setDescription("Commission Term Maximum Per Unit")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("COMMISSION_TERM")
        .setTermTypeId("FIN_COMM_MAX")
        .build();


    public final static TermTypeData TermType_INCO_TERM = TermTypeData.newBuilder()
        .setDescription("Incoterm")
        .setHasTable(castIndicator("N"))
        .setTermTypeId("INCO_TERM")
        .build();


    public final static TermTypeData TermType_INCO_TERM_2020 = TermTypeData.newBuilder()
        .setDescription("Incoterm 2020")
        .setParentTypeId("INCO_TERM")
        .setTermTypeId("INCO_TERM_2020")
        .build();


    public final static TermTypeData TermType_INCO_TERM_2020_EXW = TermTypeData.newBuilder()
        .setDescription("Incoterm 2020 Ex Works")
        .setParentTypeId("INCO_TERM_2020")
        .setTermTypeId("INCO_TERM_2020_EXW")
        .build();


    public final static TermTypeData TermType_INCO_TERM_2020_FCA = TermTypeData.newBuilder()
        .setDescription("Incoterm 2020 Free Carrier")
        .setParentTypeId("INCO_TERM_2020")
        .setTermTypeId("INCO_TERM_2020_FCA")
        .build();


    public final static TermTypeData TermType_INCO_TERM_2020_FAS = TermTypeData.newBuilder()
        .setDescription("Incoterm 2020 Free Alongside Ship")
        .setParentTypeId("INCO_TERM_2020")
        .setTermTypeId("INCO_TERM_2020_FAS")
        .build();


    public final static TermTypeData TermType_INCO_TERM_2020_FOB = TermTypeData.newBuilder()
        .setDescription("Incoterm 2020 Free On Board")
        .setParentTypeId("INCO_TERM_2020")
        .setTermTypeId("INCO_TERM_2020_FOB")
        .build();


    public final static TermTypeData TermType_INCO_TERM_2020_CPT = TermTypeData.newBuilder()
        .setDescription("Incoterm 2020 Carriage Paid To")
        .setParentTypeId("INCO_TERM_2020")
        .setTermTypeId("INCO_TERM_2020_CPT")
        .build();


    public final static TermTypeData TermType_INCO_TERM_2020_CFR = TermTypeData.newBuilder()
        .setDescription("Incoterm 2020 Cost and Freight")
        .setParentTypeId("INCO_TERM_2020")
        .setTermTypeId("INCO_TERM_2020_CFR")
        .build();


    public final static TermTypeData TermType_INCO_TERM_2020_CIF = TermTypeData.newBuilder()
        .setDescription("Incoterm 2020 Cost, Insurance and Freight")
        .setParentTypeId("INCO_TERM_2020")
        .setTermTypeId("INCO_TERM_2020_CIF")
        .build();


    public final static TermTypeData TermType_INCO_TERM_2020_CIP = TermTypeData.newBuilder()
        .setDescription("Incoterm 2020 Carriage and Insurance Paid to")
        .setParentTypeId("INCO_TERM_2020")
        .setTermTypeId("INCO_TERM_2020_CIP")
        .build();


    public final static TermTypeData TermType_INCO_TERM_2020_DPU = TermTypeData.newBuilder()
        .setDescription("Incoterm 2020 Delivered at Place Unloaded")
        .setParentTypeId("INCO_TERM_2020")
        .setTermTypeId("INCO_TERM_2020_DPU")
        .build();


    public final static TermTypeData TermType_INCO_TERM_2020_DAP = TermTypeData.newBuilder()
        .setDescription("Incoterm 2020 Delivered at Place")
        .setParentTypeId("INCO_TERM_2020")
        .setTermTypeId("INCO_TERM_2020_DAP")
        .build();


    public final static TermTypeData TermType_INCO_TERM_2020_DDP = TermTypeData.newBuilder()
        .setDescription("Incoterm 2020 Delivered Duty Paid")
        .setParentTypeId("INCO_TERM_2020")
        .setTermTypeId("INCO_TERM_2020_DDP")
        .build();


    public final static TermTypeData TermType_INCO_TERM_2010 = TermTypeData.newBuilder()
        .setDescription("Incoterm 2010")
        .setParentTypeId("INCO_TERM")
        .setTermTypeId("INCO_TERM_2010")
        .build();


    public final static TermTypeData TermType_EXW = TermTypeData.newBuilder()
        .setDescription("Incoterm 2010 Ex Works")
        .setParentTypeId("INCO_TERM_2010")
        .setTermTypeId("EXW")
        .build();


    public final static TermTypeData TermType_FCA = TermTypeData.newBuilder()
        .setDescription("Incoterm 2010 Free Carrier")
        .setParentTypeId("INCO_TERM_2010")
        .setTermTypeId("FCA")
        .build();


    public final static TermTypeData TermType_FAS = TermTypeData.newBuilder()
        .setDescription("Incoterm 2010 Free Alongside Ship")
        .setParentTypeId("INCO_TERM_2010")
        .setTermTypeId("FAS")
        .build();


    public final static TermTypeData TermType_FOB = TermTypeData.newBuilder()
        .setDescription("Incoterm 2010 Free On Board")
        .setParentTypeId("INCO_TERM_2010")
        .setTermTypeId("FOB")
        .build();


    public final static TermTypeData TermType_CFR = TermTypeData.newBuilder()
        .setDescription("Incoterm 2010 Cost and Freight")
        .setParentTypeId("INCO_TERM_2010")
        .setTermTypeId("CFR")
        .build();


    public final static TermTypeData TermType_CIF = TermTypeData.newBuilder()
        .setDescription("Incoterm 2010 Cost, Insurance and Freight")
        .setParentTypeId("INCO_TERM_2010")
        .setTermTypeId("CIF")
        .build();


    public final static TermTypeData TermType_CPT = TermTypeData.newBuilder()
        .setDescription("Incoterm 2010 Carriage Paid To")
        .setParentTypeId("INCO_TERM_2010")
        .setTermTypeId("CPT")
        .build();


    public final static TermTypeData TermType_CIP = TermTypeData.newBuilder()
        .setDescription("Incoterm 2010 Carriage and Insurance Paid to")
        .setParentTypeId("INCO_TERM_2010")
        .setTermTypeId("CIP")
        .build();


    public final static TermTypeData TermType_DDP = TermTypeData.newBuilder()
        .setDescription("Incoterm 2010 Delivered Duty Paid")
        .setParentTypeId("INCO_TERM_2010")
        .setTermTypeId("DDP")
        .build();


    public final static TermTypeData TermType_INCO_TERM_2000 = TermTypeData.newBuilder()
        .setDescription("Incoterm 2000")
        .setParentTypeId("INCO_TERM")
        .setTermTypeId("INCO_TERM_2000")
        .build();


    public final static TermTypeData TermType_DAF = TermTypeData.newBuilder()
        .setDescription("Incoterm 2000 Delivered At Frontier")
        .setParentTypeId("INCO_TERM_2000")
        .setTermTypeId("DAF")
        .build();


    public final static TermTypeData TermType_DES = TermTypeData.newBuilder()
        .setDescription("Incoterm 2000 Delivered Ex Ship")
        .setParentTypeId("INCO_TERM_2000")
        .setTermTypeId("DES")
        .build();


    public final static TermTypeData TermType_DEQ = TermTypeData.newBuilder()
        .setDescription("Incoterm 2000 Delivered Ex Quay")
        .setParentTypeId("INCO_TERM_2000")
        .setTermTypeId("DEQ")
        .build();


    public final static TermTypeData TermType_DDU = TermTypeData.newBuilder()
        .setDescription("Incoterm 2000 Delivered Duty Unpaid")
        .setParentTypeId("INCO_TERM_2000")
        .setTermTypeId("DDU")
        .build();


    public final static TermTypeData TermType_PURCHASING = TermTypeData.newBuilder()
        .setDescription("Purchasing")
        .setTermTypeId("PURCHASING")
        .build();


    public final static TermTypeData TermType_PURCH_VENDOR_ID = TermTypeData.newBuilder()
        .setDescription("Vendor Customer ID")
        .setParentTypeId("PURCHASING")
        .setTermTypeId("PURCH_VENDOR_ID")
        .build();


    public final static TermTypeData TermType_PURCH_FREIGHT = TermTypeData.newBuilder()
        .setDescription("Preferred Freight")
        .setParentTypeId("PURCHASING")
        .setTermTypeId("PURCH_FREIGHT")
        .build();


    public final static TermTypeData TermType_OTHER_TERM = TermTypeData.newBuilder()
        .setDescription("Other")
        .setHasTable(castIndicator("N"))
        .setTermTypeId("OTHER_TERM")
        .build();


    public final static StatusItemData StatusItem_PARTY_ENABLED = StatusItemData.newBuilder()
        .setDescription("Enabled")
        .setSequenceId("01")
        .setStatusCode("ENABLED")
        .setStatusId("PARTY_ENABLED")
        .setStatusTypeId("PARTY_STATUS")
        .build();


    public final static StatusItemData StatusItem_PARTY_DISABLED = StatusItemData.newBuilder()
        .setDescription("Disabled")
        .setSequenceId("99")
        .setStatusCode("DISABLED")
        .setStatusId("PARTY_DISABLED")
        .setStatusTypeId("PARTY_STATUS")
        .build();


    public final static StatusItemData StatusItem_COM_PENDING = StatusItemData.newBuilder()
        .setDescription("Pending")
        .setSequenceId("01")
        .setStatusCode("PENDING")
        .setStatusId("COM_PENDING")
        .setStatusTypeId("COM_EVENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_COM_ENTERED = StatusItemData.newBuilder()
        .setDescription("Entered")
        .setSequenceId("02")
        .setStatusCode("ENTERED")
        .setStatusId("COM_ENTERED")
        .setStatusTypeId("COM_EVENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_COM_IN_PROGRESS = StatusItemData.newBuilder()
        .setDescription("In-Progress")
        .setSequenceId("05")
        .setStatusCode("IN_PROGRESS")
        .setStatusId("COM_IN_PROGRESS")
        .setStatusTypeId("COM_EVENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_COM_UNKNOWN_PARTY = StatusItemData.newBuilder()
        .setDescription("Unknown Party")
        .setSequenceId("07")
        .setStatusCode("UNKNOWN_PARTY")
        .setStatusId("COM_UNKNOWN_PARTY")
        .setStatusTypeId("COM_EVENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_COM_COMPLETE = StatusItemData.newBuilder()
        .setDescription("Closed")
        .setSequenceId("20")
        .setStatusCode("COMPLETE")
        .setStatusId("COM_COMPLETE")
        .setStatusTypeId("COM_EVENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_COM_RESOLVED = StatusItemData.newBuilder()
        .setDescription("Resolved")
        .setSequenceId("21")
        .setStatusCode("RESOLVED")
        .setStatusId("COM_RESOLVED")
        .setStatusTypeId("COM_EVENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_COM_REFERRED = StatusItemData.newBuilder()
        .setDescription("Referred")
        .setSequenceId("22")
        .setStatusCode("REFERRED")
        .setStatusId("COM_REFERRED")
        .setStatusTypeId("COM_EVENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_COM_BOUNCED = StatusItemData.newBuilder()
        .setDescription("Bounced")
        .setSequenceId("50")
        .setStatusCode("BOUNCED")
        .setStatusId("COM_BOUNCED")
        .setStatusTypeId("COM_EVENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_COM_CANCELLED = StatusItemData.newBuilder()
        .setDescription("Cancelled")
        .setSequenceId("99")
        .setStatusCode("CANCELLED")
        .setStatusId("COM_CANCELLED")
        .setStatusTypeId("COM_EVENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_COM_ROLE_CREATED = StatusItemData.newBuilder()
        .setDescription("Created")
        .setSequenceId("01")
        .setStatusCode("ENTERED")
        .setStatusId("COM_ROLE_CREATED")
        .setStatusTypeId("COM_EVENT_ROL_STATUS")
        .build();


    public final static StatusItemData StatusItem_COM_ROLE_READ = StatusItemData.newBuilder()
        .setDescription("Read")
        .setSequenceId("02")
        .setStatusCode("PENDING")
        .setStatusId("COM_ROLE_READ")
        .setStatusTypeId("COM_EVENT_ROL_STATUS")
        .build();


    public final static StatusItemData StatusItem_COM_ROLE_COMPLETED = StatusItemData.newBuilder()
        .setDescription("Closed")
        .setSequenceId("03")
        .setStatusCode("READ")
        .setStatusId("COM_ROLE_COMPLETED")
        .setStatusTypeId("COM_EVENT_ROL_STATUS")
        .build();


    public final static StatusItemData StatusItem_PARTYREL_CREATED = StatusItemData.newBuilder()
        .setDescription("Created")
        .setSequenceId("01")
        .setStatusCode("CREATED")
        .setStatusId("PARTYREL_CREATED")
        .setStatusTypeId("PARTY_REL_STATUS")
        .build();


    public final static StatusItemData StatusItem_PARTYREL_EXPIRED = StatusItemData.newBuilder()
        .setDescription("Expired")
        .setSequenceId("02")
        .setStatusCode("EXPIRED")
        .setStatusId("PARTYREL_EXPIRED")
        .setStatusTypeId("PARTY_REL_STATUS")
        .build();


    public final static StatusItemData StatusItem_PARTYINV_SENT = StatusItemData.newBuilder()
        .setDescription("Invitation Sent")
        .setSequenceId("01")
        .setStatusCode("SENT")
        .setStatusId("PARTYINV_SENT")
        .setStatusTypeId("PARTY_INV_STATUS")
        .build();


    public final static StatusItemData StatusItem_PARTYINV_PENDING = StatusItemData.newBuilder()
        .setDescription("Invitation Pending")
        .setSequenceId("02")
        .setStatusCode("PENDING")
        .setStatusId("PARTYINV_PENDING")
        .setStatusTypeId("PARTY_INV_STATUS")
        .build();


    public final static StatusItemData StatusItem_PARTYINV_ACCEPTED = StatusItemData.newBuilder()
        .setDescription("Invitation Accepted")
        .setSequenceId("05")
        .setStatusCode("ACCEPTED")
        .setStatusId("PARTYINV_ACCEPTED")
        .setStatusTypeId("PARTY_INV_STATUS")
        .build();


    public final static StatusItemData StatusItem_PARTYINV_DECLINED = StatusItemData.newBuilder()
        .setDescription("Invitation Declined")
        .setSequenceId("06")
        .setStatusCode("DECLINED")
        .setStatusId("PARTYINV_DECLINED")
        .setStatusTypeId("PARTY_INV_STATUS")
        .build();


    public final static StatusItemData StatusItem_PARTYINV_CANCELLED = StatusItemData.newBuilder()
        .setDescription("Invitation Cancelled")
        .setSequenceId("10")
        .setStatusCode("CANCELLED")
        .setStatusId("PARTYINV_CANCELLED")
        .setStatusTypeId("PARTY_INV_STATUS")
        .build();


    public final static StatusValidChangeData StatusValidChange_PARTY_ENABLED_PARTY_DISABLED = StatusValidChangeData.newBuilder()
        .setStatusId("PARTY_ENABLED")
        .setStatusIdTo("PARTY_DISABLED")
        .setTransitionName("Disable")
        .build();


    public final static StatusValidChangeData StatusValidChange_PARTY_DISABLED_PARTY_ENABLED = StatusValidChangeData.newBuilder()
        .setStatusId("PARTY_DISABLED")
        .setStatusIdTo("PARTY_ENABLED")
        .setTransitionName("Re-Enable")
        .build();


    public final static StatusValidChangeData StatusValidChange_COM_ENTERED_COM_PENDING = StatusValidChangeData.newBuilder()
        .setStatusId("COM_ENTERED")
        .setStatusIdTo("COM_PENDING")
        .setTransitionName("Set Pending, only visible to originator")
        .build();


    public final static StatusValidChangeData StatusValidChange_COM_ENTERED_COM_IN_PROGRESS = StatusValidChangeData.newBuilder()
        .setStatusId("COM_ENTERED")
        .setStatusIdTo("COM_IN_PROGRESS")
        .setTransitionName("Set In Progress, waiting to be send")
        .build();


    public final static StatusValidChangeData StatusValidChange_COM_ENTERED_COM_COMPLETE = StatusValidChangeData.newBuilder()
        .setStatusId("COM_ENTERED")
        .setStatusIdTo("COM_COMPLETE")
        .setTransitionName("Complete")
        .build();


    public final static StatusValidChangeData StatusValidChange_COM_PENDING_COM_ENTERED = StatusValidChangeData.newBuilder()
        .setStatusId("COM_PENDING")
        .setStatusIdTo("COM_ENTERED")
        .setTransitionName("Entered,visible to all participants")
        .build();


    public final static StatusValidChangeData StatusValidChange_COM_PENDING_COM_IN_PROGRESS = StatusValidChangeData.newBuilder()
        .setStatusId("COM_PENDING")
        .setStatusIdTo("COM_IN_PROGRESS")
        .setTransitionName("Set In Progress, waiting to be send")
        .build();


    public final static StatusValidChangeData StatusValidChange_COM_IN_PROGRESS_COM_COMPLETE = StatusValidChangeData.newBuilder()
        .setStatusId("COM_IN_PROGRESS")
        .setStatusIdTo("COM_COMPLETE")
        .setTransitionName("Complete")
        .build();


    public final static StatusValidChangeData StatusValidChange_COM_IN_PROGRESS_COM_BOUNCED = StatusValidChangeData.newBuilder()
        .setStatusId("COM_IN_PROGRESS")
        .setStatusIdTo("COM_BOUNCED")
        .setTransitionName("Bounced")
        .build();


    public final static StatusValidChangeData StatusValidChange_COM_COMPLETE_COM_RESOLVED = StatusValidChangeData.newBuilder()
        .setStatusId("COM_COMPLETE")
        .setStatusIdTo("COM_RESOLVED")
        .setTransitionName("Resolve")
        .build();


    public final static StatusValidChangeData StatusValidChange_COM_COMPLETE_COM_REFERRED = StatusValidChangeData.newBuilder()
        .setStatusId("COM_COMPLETE")
        .setStatusIdTo("COM_REFERRED")
        .setTransitionName("Refer")
        .build();


    public final static StatusValidChangeData StatusValidChange_COM_COMPLETE_COM_BOUNCED = StatusValidChangeData.newBuilder()
        .setStatusId("COM_COMPLETE")
        .setStatusIdTo("COM_BOUNCED")
        .setTransitionName("Bounced")
        .build();


    public final static StatusValidChangeData StatusValidChange_COM_UNKNOWN_PARTY_COM_COMPLETE = StatusValidChangeData.newBuilder()
        .setStatusId("COM_UNKNOWN_PARTY")
        .setStatusIdTo("COM_COMPLETE")
        .setTransitionName("Complete")
        .build();


    public final static StatusValidChangeData StatusValidChange_COM_UNKNOWN_PARTY_COM_ENTERED = StatusValidChangeData.newBuilder()
        .setStatusId("COM_UNKNOWN_PARTY")
        .setStatusIdTo("COM_ENTERED")
        .setTransitionName("Corrected")
        .build();


    public final static StatusValidChangeData StatusValidChange_COM_PENDING_COM_COMPLETE = StatusValidChangeData.newBuilder()
        .setStatusId("COM_PENDING")
        .setStatusIdTo("COM_COMPLETE")
        .setTransitionName("Complete")
        .build();


    public final static StatusValidChangeData StatusValidChange_COM_ENTERED_COM_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("COM_ENTERED")
        .setStatusIdTo("COM_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_COM_PENDING_COM_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("COM_PENDING")
        .setStatusIdTo("COM_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_COM_IN_PROGRESS_COM_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("COM_IN_PROGRESS")
        .setStatusIdTo("COM_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_COM_COMPLETE_COM_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("COM_COMPLETE")
        .setStatusIdTo("COM_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_COM_RESOLVED_COM_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("COM_RESOLVED")
        .setStatusIdTo("COM_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_COM_REFERRED_COM_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("COM_REFERRED")
        .setStatusIdTo("COM_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_COM_UNKNOWN_PARTY_COM_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("COM_UNKNOWN_PARTY")
        .setStatusIdTo("COM_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_COM_ROLE_CREATED_COM_ROLE_READ = StatusValidChangeData.newBuilder()
        .setStatusId("COM_ROLE_CREATED")
        .setStatusIdTo("COM_ROLE_READ")
        .setTransitionName("Read")
        .build();


    public final static StatusValidChangeData StatusValidChange_COM_ROLE_CREATED_COM_ROLE_COMPLETED = StatusValidChangeData.newBuilder()
        .setStatusId("COM_ROLE_CREATED")
        .setStatusIdTo("COM_ROLE_COMPLETED")
        .setTransitionName("Completed")
        .build();


    public final static StatusValidChangeData StatusValidChange_COM_ROLE_READ_COM_ROLE_COMPLETED = StatusValidChangeData.newBuilder()
        .setStatusId("COM_ROLE_READ")
        .setStatusIdTo("COM_ROLE_COMPLETED")
        .setTransitionName("Completed")
        .build();


    public final static StatusValidChangeData StatusValidChange_PARTYREL_CREATED_PARTYREL_EXPIRED = StatusValidChangeData.newBuilder()
        .setStatusId("PARTYREL_CREATED")
        .setStatusIdTo("PARTYREL_EXPIRED")
        .setTransitionName("Expired")
        .build();


    public final static StatusValidChangeData StatusValidChange_PARTYINV_SENT_PARTYINV_PENDING = StatusValidChangeData.newBuilder()
        .setStatusId("PARTYINV_SENT")
        .setStatusIdTo("PARTYINV_PENDING")
        .setTransitionName("Pending")
        .build();


    public final static StatusValidChangeData StatusValidChange_PARTYINV_SENT_PARTYINV_ACCEPTED = StatusValidChangeData.newBuilder()
        .setStatusId("PARTYINV_SENT")
        .setStatusIdTo("PARTYINV_ACCEPTED")
        .setTransitionName("Accepted")
        .build();


    public final static StatusValidChangeData StatusValidChange_PARTYINV_SENT_PARTYINV_DECLINED = StatusValidChangeData.newBuilder()
        .setStatusId("PARTYINV_SENT")
        .setStatusIdTo("PARTYINV_DECLINED")
        .setTransitionName("Declined")
        .build();


    public final static StatusValidChangeData StatusValidChange_PARTYINV_SENT_PARTYINV_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("PARTYINV_SENT")
        .setStatusIdTo("PARTYINV_CANCELLED")
        .setTransitionName("Cancelled")
        .build();


    public final static StatusValidChangeData StatusValidChange_PARTYINV_PENDING_PARTYINV_ACCEPTED = StatusValidChangeData.newBuilder()
        .setStatusId("PARTYINV_PENDING")
        .setStatusIdTo("PARTYINV_ACCEPTED")
        .setTransitionName("Accepted")
        .build();


    public final static StatusValidChangeData StatusValidChange_PARTYINV_PENDING_PARTYINV_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("PARTYINV_PENDING")
        .setStatusIdTo("PARTYINV_CANCELLED")
        .setTransitionName("Cancelled")
        .build();


    public final static CommunicationEventTypeData CommunicationEventType_EMAIL_COMMUNICATION = CommunicationEventTypeData.newBuilder()
        .setCommunicationEventTypeId("EMAIL_COMMUNICATION")
        .setContactMechTypeId("EMAIL_ADDRESS")
        .setDescription("Email")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CommunicationEventTypeData CommunicationEventType_FACE_TO_FACE_COMMUNI = CommunicationEventTypeData.newBuilder()
        .setCommunicationEventTypeId("FACE_TO_FACE_COMMUNI")
        .setDescription("Face-To-Face")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CommunicationEventTypeData CommunicationEventType_FAX_COMMUNICATION = CommunicationEventTypeData.newBuilder()
        .setCommunicationEventTypeId("FAX_COMMUNICATION")
        .setContactMechTypeId("TELECOM_NUMBER")
        .setDescription("Fax")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CommunicationEventTypeData CommunicationEventType_LETTER_CORRESPONDENC = CommunicationEventTypeData.newBuilder()
        .setCommunicationEventTypeId("LETTER_CORRESPONDENC")
        .setContactMechTypeId("POSTAL_ADDRESS")
        .setDescription("Letter")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CommunicationEventTypeData CommunicationEventType_PHONE_COMMUNICATION = CommunicationEventTypeData.newBuilder()
        .setCommunicationEventTypeId("PHONE_COMMUNICATION")
        .setContactMechTypeId("TELECOM_NUMBER")
        .setDescription("Phone")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CommunicationEventTypeData CommunicationEventType_WEB_SITE_COMMUNICATI = CommunicationEventTypeData.newBuilder()
        .setCommunicationEventTypeId("WEB_SITE_COMMUNICATI")
        .setContactMechTypeId("WEB_ADDRESS")
        .setDescription("Web Site")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CommunicationEventTypeData CommunicationEventType_COMMENT_NOTE = CommunicationEventTypeData.newBuilder()
        .setCommunicationEventTypeId("COMMENT_NOTE")
        .setContactMechTypeId("INTERNAL_PARTYID")
        .setDescription("Comment/Note")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CommunicationEventTypeData CommunicationEventType_AUTO_EMAIL_COMM = CommunicationEventTypeData.newBuilder()
        .setCommunicationEventTypeId("AUTO_EMAIL_COMM")
        .setContactMechTypeId("EMAIL_ADDRESS")
        .setDescription("Auto Email")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CommunicationEventTypeData CommunicationEventType_FILE_TRANSFER_COMM = CommunicationEventTypeData.newBuilder()
        .setCommunicationEventTypeId("FILE_TRANSFER_COMM")
        .setContactMechTypeId("FTP_ADDRESS")
        .setDescription("File transfer")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_EMAIL_ADDRESS_BILLING_EMAIL = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("BILLING_EMAIL")
        .setContactMechTypeId("EMAIL_ADDRESS")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_EMAIL_ADDRESS_MARKETING_EMAIL = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("MARKETING_EMAIL")
        .setContactMechTypeId("EMAIL_ADDRESS")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_EMAIL_ADDRESS_PAYMENT_EMAIL = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("PAYMENT_EMAIL")
        .setContactMechTypeId("EMAIL_ADDRESS")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_EMAIL_ADDRESS_ORDER_EMAIL = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("ORDER_EMAIL")
        .setContactMechTypeId("EMAIL_ADDRESS")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_EMAIL_ADDRESS_OTHER_EMAIL = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("OTHER_EMAIL")
        .setContactMechTypeId("EMAIL_ADDRESS")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_EMAIL_ADDRESS_PRIMARY_EMAIL = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("PRIMARY_EMAIL")
        .setContactMechTypeId("EMAIL_ADDRESS")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_POSTAL_ADDRESS_SHIPPING_LOCATION = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("SHIPPING_LOCATION")
        .setContactMechTypeId("POSTAL_ADDRESS")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_POSTAL_ADDRESS_SHIP_ORIG_LOCATION = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("SHIP_ORIG_LOCATION")
        .setContactMechTypeId("POSTAL_ADDRESS")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_POSTAL_ADDRESS_BILLING_LOCATION = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("BILLING_LOCATION")
        .setContactMechTypeId("POSTAL_ADDRESS")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_POSTAL_ADDRESS_PAYMENT_LOCATION = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("PAYMENT_LOCATION")
        .setContactMechTypeId("POSTAL_ADDRESS")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_POSTAL_ADDRESS_GENERAL_LOCATION = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("GENERAL_LOCATION")
        .setContactMechTypeId("POSTAL_ADDRESS")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_POSTAL_ADDRESS_PUR_RET_LOCATION = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("PUR_RET_LOCATION")
        .setContactMechTypeId("POSTAL_ADDRESS")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_POSTAL_ADDRESS_PRIMARY_LOCATION = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("PRIMARY_LOCATION")
        .setContactMechTypeId("POSTAL_ADDRESS")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_POSTAL_ADDRESS_PREVIOUS_LOCATION = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("PREVIOUS_LOCATION")
        .setContactMechTypeId("POSTAL_ADDRESS")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_TELECOM_NUMBER_FAX_NUMBER = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("FAX_NUMBER")
        .setContactMechTypeId("TELECOM_NUMBER")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_TELECOM_NUMBER_FAX_NUMBER_SEC = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("FAX_NUMBER_SEC")
        .setContactMechTypeId("TELECOM_NUMBER")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_TELECOM_NUMBER_PHONE_DID = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("PHONE_DID")
        .setContactMechTypeId("TELECOM_NUMBER")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_TELECOM_NUMBER_PHONE_HOME = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("PHONE_HOME")
        .setContactMechTypeId("TELECOM_NUMBER")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_TELECOM_NUMBER_PHONE_MOBILE = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("PHONE_MOBILE")
        .setContactMechTypeId("TELECOM_NUMBER")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_TELECOM_NUMBER_PHONE_WORK = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("PHONE_WORK")
        .setContactMechTypeId("TELECOM_NUMBER")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_TELECOM_NUMBER_PHONE_WORK_SEC = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("PHONE_WORK_SEC")
        .setContactMechTypeId("TELECOM_NUMBER")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_TELECOM_NUMBER_PHONE_SHIPPING = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("PHONE_SHIPPING")
        .setContactMechTypeId("TELECOM_NUMBER")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_TELECOM_NUMBER_PHONE_SHIP_ORIG = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("PHONE_SHIP_ORIG")
        .setContactMechTypeId("TELECOM_NUMBER")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_TELECOM_NUMBER_PHONE_BILLING = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("PHONE_BILLING")
        .setContactMechTypeId("TELECOM_NUMBER")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_TELECOM_NUMBER_PHONE_PAYMENT = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("PHONE_PAYMENT")
        .setContactMechTypeId("TELECOM_NUMBER")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_TELECOM_NUMBER_PRIMARY_PHONE = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("PRIMARY_PHONE")
        .setContactMechTypeId("TELECOM_NUMBER")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_TELECOM_NUMBER_PHONE_QUICK = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("PHONE_QUICK")
        .setContactMechTypeId("TELECOM_NUMBER")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_TELECOM_NUMBER_FAX_SHIPPING = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("FAX_SHIPPING")
        .setContactMechTypeId("TELECOM_NUMBER")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_TELECOM_NUMBER_FAX_BILLING = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("FAX_BILLING")
        .setContactMechTypeId("TELECOM_NUMBER")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_TELECOM_NUMBER_PHONE_ASSISTANT = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("PHONE_ASSISTANT")
        .setContactMechTypeId("TELECOM_NUMBER")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_WEB_ADDRESS_PRIMARY_WEB_URL = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("PRIMARY_WEB_URL")
        .setContactMechTypeId("WEB_ADDRESS")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_WEB_ADDRESS_TWITTER_URL = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("TWITTER_URL")
        .setContactMechTypeId("WEB_ADDRESS")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_WEB_ADDRESS_FACEBOOK_URL = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("FACEBOOK_URL")
        .setContactMechTypeId("WEB_ADDRESS")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_WEB_ADDRESS_LINKEDIN_URL = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("LINKEDIN_URL")
        .setContactMechTypeId("WEB_ADDRESS")
        .build();


    public final static PartyClassificationTypeData PartyClassificationType_EEOC_CLASSIFICATION = PartyClassificationTypeData.newBuilder()
        .setDescription("EEOC (Equal Opportunity)")
        .setHasTable(castIndicator("N"))
        .setPartyClassificationTypeId("EEOC_CLASSIFICATION")
        .build();


    public final static PartyClassificationTypeData PartyClassificationType_MINORITY_CLASSIFICAT = PartyClassificationTypeData.newBuilder()
        .setDescription("Minority")
        .setHasTable(castIndicator("N"))
        .setPartyClassificationTypeId("MINORITY_CLASSIFICAT")
        .build();


    public final static PartyClassificationTypeData PartyClassificationType_INCOME_CLASSIFICATIO = PartyClassificationTypeData.newBuilder()
        .setDescription("Income")
        .setHasTable(castIndicator("N"))
        .setPartyClassificationTypeId("INCOME_CLASSIFICATIO")
        .build();


    public final static PartyClassificationTypeData PartyClassificationType_INDUSTRY_CLASSIFICAT = PartyClassificationTypeData.newBuilder()
        .setDescription("Industry")
        .setHasTable(castIndicator("N"))
        .setPartyClassificationTypeId("INDUSTRY_CLASSIFICAT")
        .build();


    public final static PartyClassificationTypeData PartyClassificationType_ORGANIZATION_CLASSIF = PartyClassificationTypeData.newBuilder()
        .setDescription("Organization")
        .setHasTable(castIndicator("N"))
        .setPartyClassificationTypeId("ORGANIZATION_CLASSIF")
        .build();


    public final static PartyClassificationTypeData PartyClassificationType_PERSON_CLASSIFICATIO = PartyClassificationTypeData.newBuilder()
        .setDescription("Person")
        .setHasTable(castIndicator("N"))
        .setPartyClassificationTypeId("PERSON_CLASSIFICATIO")
        .build();


    public final static PartyClassificationTypeData PartyClassificationType_SIZE_CLASSIFICATION = PartyClassificationTypeData.newBuilder()
        .setDescription("Size")
        .setHasTable(castIndicator("N"))
        .setPartyClassificationTypeId("SIZE_CLASSIFICATION")
        .build();


    public final static PartyClassificationTypeData PartyClassificationType_TRADE_CLASSIFICATION = PartyClassificationTypeData.newBuilder()
        .setDescription("Trade")
        .setHasTable(castIndicator("N"))
        .setPartyClassificationTypeId("TRADE_CLASSIFICATION")
        .build();


    public final static PartyClassificationTypeData PartyClassificationType_TRADE_WHOLE_CLASSIFI = PartyClassificationTypeData.newBuilder()
        .setDescription("Wholesale")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("TRADE_CLASSIFICATION")
        .setPartyClassificationTypeId("TRADE_WHOLE_CLASSIFI")
        .build();


    public final static PartyClassificationTypeData PartyClassificationType_TRADE_RETAIL_CLASSIF = PartyClassificationTypeData.newBuilder()
        .setDescription("Retail")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("TRADE_CLASSIFICATION")
        .setPartyClassificationTypeId("TRADE_RETAIL_CLASSIF")
        .build();


    public final static PartyClassificationTypeData PartyClassificationType_ANNUAL_REVENUE = PartyClassificationTypeData.newBuilder()
        .setDescription("Annual Revenue")
        .setHasTable(castIndicator("N"))
        .setPartyClassificationTypeId("ANNUAL_REVENUE")
        .build();


    public final static PartyClassificationTypeData PartyClassificationType_NUMBER_OF_EMPLOYEES = PartyClassificationTypeData.newBuilder()
        .setDescription("Number of Employees")
        .setHasTable(castIndicator("N"))
        .setPartyClassificationTypeId("NUMBER_OF_EMPLOYEES")
        .build();


    public final static PartyClassificationTypeData PartyClassificationType_VALUE_RATING = PartyClassificationTypeData.newBuilder()
        .setDescription("Value Rating")
        .setHasTable(castIndicator("N"))
        .setPartyClassificationTypeId("VALUE_RATING")
        .build();


    public final static PartyClassificationTypeData PartyClassificationType_SIC_CODE = PartyClassificationTypeData.newBuilder()
        .setDescription("SIC Code")
        .setHasTable(castIndicator("N"))
        .setPartyClassificationTypeId("SIC_CODE")
        .build();


    public final static PartyClassificationTypeData PartyClassificationType_OWNERSHIP = PartyClassificationTypeData.newBuilder()
        .setDescription("Ownership")
        .setHasTable(castIndicator("N"))
        .setPartyClassificationTypeId("OWNERSHIP")
        .build();


    public final static StatusTypeData StatusType_PARTY_STATUS = StatusTypeData.newBuilder()
        .setDescription("Party")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("PARTY_STATUS")
        .build();


    public final static StatusTypeData StatusType_CASE_STATUS = StatusTypeData.newBuilder()
        .setDescription("Case")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("CASE_STATUS")
        .build();


    public final static StatusTypeData StatusType_COM_EVENT_STATUS = StatusTypeData.newBuilder()
        .setDescription("Communication Event")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("COM_EVENT_STATUS")
        .build();


    public final static StatusTypeData StatusType_COM_EVENT_ROL_STATUS = StatusTypeData.newBuilder()
        .setDescription("Communication Event Role")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("COM_EVENT_STATUS")
        .setStatusTypeId("COM_EVENT_ROL_STATUS")
        .build();


    public final static StatusTypeData StatusType_PARTY_REL_STATUS = StatusTypeData.newBuilder()
        .setDescription("Party Relationship")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("PARTY_REL_STATUS")
        .build();


    public final static StatusTypeData StatusType_PARTY_INV_STATUS = StatusTypeData.newBuilder()
        .setDescription("Party Invitation")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("PARTY_INV_STATUS")
        .build();


    public final static SecurityGroupPermissionData SecurityGroupPermission_SUPER_PARTYMGR_ADMIN_ = SecurityGroupPermissionData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setGroupId("SUPER")
        .setPermissionId("PARTYMGR_ADMIN")
        .build();


    public final static SecurityGroupPermissionData SecurityGroupPermission_SUPER_SECURITY_ADMIN_ = SecurityGroupPermissionData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setGroupId("SUPER")
        .setPermissionId("SECURITY_ADMIN")
        .build();


    public final static UserPreferenceData UserPreference__NA__ORGANIZATION_PARTY = UserPreferenceData.newBuilder()
        .setUserLoginId("_NA_")
        .setUserPrefGroupTypeId("GLOBAL_PREFERENCES")
        .setUserPrefTypeId("ORGANIZATION_PARTY")
        .setUserPrefValue("DEFAULT")
        .build();


    public final static PartyQualTypeData PartyQualType_EXPERIENCE = PartyQualTypeData.newBuilder()
        .setDescription("Work experience")
        .setHasTable(castIndicator("N"))
        .setPartyQualTypeId("EXPERIENCE")
        .build();


    public final static PartyQualTypeData PartyQualType_CERTIFICATION = PartyQualTypeData.newBuilder()
        .setDescription("Certification")
        .setHasTable(castIndicator("N"))
        .setPartyQualTypeId("CERTIFICATION")
        .build();


    public final static PartyQualTypeData PartyQualType_DEGREE = PartyQualTypeData.newBuilder()
        .setDescription("Degree")
        .setHasTable(castIndicator("N"))
        .setPartyQualTypeId("DEGREE")
        .build();


    public final static PartyTypeData PartyType_AUTOMATED_AGENT = PartyTypeData.newBuilder()
        .setDescription("Automated Agent")
        .setHasTable(castIndicator("N"))
        .setPartyTypeId("AUTOMATED_AGENT")
        .build();


    public final static PartyTypeData PartyType_PERSON = PartyTypeData.newBuilder()
        .setDescription("Person")
        .setHasTable(castIndicator("Y"))
        .setPartyTypeId("PERSON")
        .build();


    public final static PartyTypeData PartyType_PARTY_GROUP = PartyTypeData.newBuilder()
        .setDescription("Party Group")
        .setHasTable(castIndicator("Y"))
        .setPartyTypeId("PARTY_GROUP")
        .build();


    public final static PartyTypeData PartyType_INFORMAL_GROUP = PartyTypeData.newBuilder()
        .setDescription("Informal Group")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("PARTY_GROUP")
        .setPartyTypeId("INFORMAL_GROUP")
        .build();


    public final static PartyTypeData PartyType_FAMILY = PartyTypeData.newBuilder()
        .setDescription("Family")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("INFORMAL_GROUP")
        .setPartyTypeId("FAMILY")
        .build();


    public final static PartyTypeData PartyType_TEAM = PartyTypeData.newBuilder()
        .setDescription("Team")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("INFORMAL_GROUP")
        .setPartyTypeId("TEAM")
        .build();


    public final static PartyTypeData PartyType_LEGAL_ORGANIZATION = PartyTypeData.newBuilder()
        .setDescription("Legal Organization")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("PARTY_GROUP")
        .setPartyTypeId("LEGAL_ORGANIZATION")
        .build();


    public final static PartyTypeData PartyType_CORPORATION = PartyTypeData.newBuilder()
        .setDescription("Corporation")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("LEGAL_ORGANIZATION")
        .setPartyTypeId("CORPORATION")
        .build();


    public final static PartyTypeData PartyType_GOVERNMENT_AGENCY = PartyTypeData.newBuilder()
        .setDescription("Government Agency")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("LEGAL_ORGANIZATION")
        .setPartyTypeId("GOVERNMENT_AGENCY")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_VIEW = SecurityPermissionData.newBuilder()
        .setDescription("View operations in the Party Manager.")
        .setPermissionId("PARTYMGR_VIEW")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_CREATE = SecurityPermissionData.newBuilder()
        .setDescription("Create operations in the Party Manager.")
        .setPermissionId("PARTYMGR_CREATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_UPDATE = SecurityPermissionData.newBuilder()
        .setDescription("Update operations in the Party Manager.")
        .setPermissionId("PARTYMGR_UPDATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_DELETE = SecurityPermissionData.newBuilder()
        .setDescription("Delete operations in the Party Manager.")
        .setPermissionId("PARTYMGR_DELETE")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_ADMIN = SecurityPermissionData.newBuilder()
        .setDescription("ALL operations in the Party Manager.")
        .setPermissionId("PARTYMGR_ADMIN")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_NOTE = SecurityPermissionData.newBuilder()
        .setDescription("Create notes in the Party Manager.")
        .setPermissionId("PARTYMGR_NOTE")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_STS_UPDATE = SecurityPermissionData.newBuilder()
        .setDescription("Update party status in the Party Manager.")
        .setPermissionId("PARTYMGR_STS_UPDATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_GRP_UPDATE = SecurityPermissionData.newBuilder()
        .setDescription("Update PartyGroup or Person detail information.")
        .setPermissionId("PARTYMGR_GRP_UPDATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_REL_CREATE = SecurityPermissionData.newBuilder()
        .setDescription("Create party relationships in the Party Manager.")
        .setPermissionId("PARTYMGR_REL_CREATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_REL_UPDATE = SecurityPermissionData.newBuilder()
        .setDescription("Update party relationships in the Party Manager.")
        .setPermissionId("PARTYMGR_REL_UPDATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_REL_DELETE = SecurityPermissionData.newBuilder()
        .setDescription("Delete party relationships in the Party Manager.")
        .setPermissionId("PARTYMGR_REL_DELETE")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_ROLE_CREATE = SecurityPermissionData.newBuilder()
        .setDescription("Create party roles in the Party Manager.")
        .setPermissionId("PARTYMGR_ROLE_CREATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_ROLE_DELETE = SecurityPermissionData.newBuilder()
        .setDescription("Delete party roles in the Party Manager.")
        .setPermissionId("PARTYMGR_ROLE_DELETE")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_PCM_CREATE = SecurityPermissionData.newBuilder()
        .setDescription("Create party contact mechs in the Party Manager.")
        .setPermissionId("PARTYMGR_PCM_CREATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_PCM_UPDATE = SecurityPermissionData.newBuilder()
        .setDescription("Update party contact mechs in the Party Manager.")
        .setPermissionId("PARTYMGR_PCM_UPDATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_PCM_DELETE = SecurityPermissionData.newBuilder()
        .setDescription("Delete party contact mechs in the Party Manager.")
        .setPermissionId("PARTYMGR_PCM_DELETE")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_SRC_CREATE = SecurityPermissionData.newBuilder()
        .setDescription("Create party to data source relations.")
        .setPermissionId("PARTYMGR_SRC_CREATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_QAL_CREATE = SecurityPermissionData.newBuilder()
        .setDescription("Create party quals in the Party Manager.")
        .setPermissionId("PARTYMGR_QAL_CREATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_QAL_UPDATE = SecurityPermissionData.newBuilder()
        .setDescription("Update party quals in the Party Manager.")
        .setPermissionId("PARTYMGR_QAL_UPDATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_QAL_DELETE = SecurityPermissionData.newBuilder()
        .setDescription("Delete party quals in the Party Manager.")
        .setPermissionId("PARTYMGR_QAL_DELETE")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_CME_CREATE = SecurityPermissionData.newBuilder()
        .setDescription("Create communication event, any from/to party.")
        .setPermissionId("PARTYMGR_CME_CREATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_CME_UPDATE = SecurityPermissionData.newBuilder()
        .setDescription("Update communication event, any from/to party.")
        .setPermissionId("PARTYMGR_CME_UPDATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_CME_DELETE = SecurityPermissionData.newBuilder()
        .setDescription("Delete communication event, any from/to party.")
        .setPermissionId("PARTYMGR_CME_DELETE")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_CME_EMAIL_CREATE = SecurityPermissionData.newBuilder()
        .setDescription("Can create Email communication events for logged-in user.")
        .setPermissionId("PARTYMGR_CME-EMAIL_CREATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_CME_EMAIL_UPDATE = SecurityPermissionData.newBuilder()
        .setDescription("Can update Email communication events for logged-in user.")
        .setPermissionId("PARTYMGR_CME-EMAIL_UPDATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_CME_EMAIL_DELETE = SecurityPermissionData.newBuilder()
        .setDescription("Can delete Email communication events for logged-in user.")
        .setPermissionId("PARTYMGR_CME-EMAIL_DELETE")
        .build();


    public final static SecurityPermissionData SecurityPermission_PARTYMGR_CME_NOTE_CREATE = SecurityPermissionData.newBuilder()
        .setDescription("Can create Internal note communication event for logged-in user.")
        .setPermissionId("PARTYMGR_CME-NOTE_CREATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_SECURITY_VIEW = SecurityPermissionData.newBuilder()
        .setDescription("View operations in the Security Management Screens.")
        .setPermissionId("SECURITY_VIEW")
        .build();


    public final static SecurityPermissionData SecurityPermission_SECURITY_CREATE = SecurityPermissionData.newBuilder()
        .setDescription("Create operations in the Security Management Screens.")
        .setPermissionId("SECURITY_CREATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_SECURITY_UPDATE = SecurityPermissionData.newBuilder()
        .setDescription("Update operations in the Security Management Screens.")
        .setPermissionId("SECURITY_UPDATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_SECURITY_DELETE = SecurityPermissionData.newBuilder()
        .setDescription("Delete operations in the Security Management Screens.")
        .setPermissionId("SECURITY_DELETE")
        .build();


    public final static SecurityPermissionData SecurityPermission_SECURITY_ADMIN = SecurityPermissionData.newBuilder()
        .setDescription("ALL operations in the Security Management Screens.")
        .setPermissionId("SECURITY_ADMIN")
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_SHIPPING_LOCATION = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("SHIPPING_LOCATION")
        .setDescription("Shipping Destination Address")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_SHIP_ORIG_LOCATION = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("SHIP_ORIG_LOCATION")
        .setDescription("Shipping Origin Address")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_BILLING_LOCATION = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("BILLING_LOCATION")
        .setDescription("Billing (AP) Address")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_PAYMENT_LOCATION = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("PAYMENT_LOCATION")
        .setDescription("Payment (AR) Address")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_GENERAL_LOCATION = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("GENERAL_LOCATION")
        .setDescription("General Correspondence Address")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_PUR_RET_LOCATION = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("PUR_RET_LOCATION")
        .setDescription("Purchase Return Address")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_PRIMARY_LOCATION = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("PRIMARY_LOCATION")
        .setDescription("Primary Address")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_PREVIOUS_LOCATION = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("PREVIOUS_LOCATION")
        .setDescription("Previous Address")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_PHONE_SHIPPING = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("PHONE_SHIPPING")
        .setDescription("Shipping Destination Phone Number")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_PHONE_SHIP_ORIG = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("PHONE_SHIP_ORIG")
        .setDescription("Shipping Origin Phone Number")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_PHONE_BILLING = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("PHONE_BILLING")
        .setDescription("Billing (AP) Phone Number")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_PHONE_DID = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("PHONE_DID")
        .setDescription("Direct Inward Dialing Phone Number")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_PHONE_PAYMENT = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("PHONE_PAYMENT")
        .setDescription("Payment (AR) Phone Number")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_PHONE_HOME = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("PHONE_HOME")
        .setDescription("Main Home Phone Number")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_PHONE_WORK = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("PHONE_WORK")
        .setDescription("Main Work Phone Number")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_PHONE_WORK_SEC = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("PHONE_WORK_SEC")
        .setDescription("Secondary Work Phone Number")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_FAX_NUMBER = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("FAX_NUMBER")
        .setDescription("Main Fax Number")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_FAX_NUMBER_SEC = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("FAX_NUMBER_SEC")
        .setDescription("Secondary Fax Number")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_FAX_SHIPPING = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("FAX_SHIPPING")
        .setDescription("Shipping Destination Fax Number")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_FAX_BILLING = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("FAX_BILLING")
        .setDescription("Billing Destination Fax Number")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_PHONE_MOBILE = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("PHONE_MOBILE")
        .setDescription("Main Mobile Phone Number")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_PHONE_ASSISTANT = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("PHONE_ASSISTANT")
        .setDescription("Assistant's Phone Number")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_PRIMARY_PHONE = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("PRIMARY_PHONE")
        .setDescription("Primary Phone Number")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_PHONE_QUICK = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("PHONE_QUICK")
        .setDescription("Quick Calls Phone Number")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_MARKETING_EMAIL = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("MARKETING_EMAIL")
        .setDescription("Primary Marketing Email Address")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_PRIMARY_EMAIL = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("PRIMARY_EMAIL")
        .setDescription("Primary Email Address")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_BILLING_EMAIL = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("BILLING_EMAIL")
        .setDescription("Billing (AP) Email")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_PAYMENT_EMAIL = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("PAYMENT_EMAIL")
        .setDescription("Payment (AR) Email")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_OTHER_EMAIL = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("OTHER_EMAIL")
        .setDescription("Other Email Address")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_SUPPORT_EMAIL = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("SUPPORT_EMAIL")
        .setDescription("Support Email")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_ORDER_EMAIL = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("ORDER_EMAIL")
        .setDescription("Order Notification Email Address")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_PRIMARY_WEB_URL = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("PRIMARY_WEB_URL")
        .setDescription("Primary Website URL")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_TWITTER_URL = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("TWITTER_URL")
        .setDescription("Twitter Website URL")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_FACEBOOK_URL = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("FACEBOOK_URL")
        .setDescription("Facebook Website URL")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_LINKEDIN_URL = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("LINKEDIN_URL")
        .setDescription("LinkedIn Website URL")
        .setHasTable(castIndicator("N"))
        .build();

}

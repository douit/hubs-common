package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.PartyIdentificationTypeData;
import com.bluecc.hubs.stub.EnumerationData;
import com.bluecc.hubs.stub.EnumerationTypeData;
import com.bluecc.hubs.stub.DataSourceData;
import com.bluecc.hubs.stub.StatusItemData;
import com.bluecc.hubs.stub.StatusValidChangeData;
import com.bluecc.hubs.stub.TrackingCodeTypeData;
import com.bluecc.hubs.stub.StatusTypeData;
import com.bluecc.hubs.stub.SegmentGroupTypeData;
import com.bluecc.hubs.stub.DataSourceTypeData;
import com.bluecc.hubs.stub.ContactListTypeData;

public final class MarketingSeedData {
    public final static PartyIdentificationTypeData PartyIdentificationType_VCARD_FN_ORIGIN = PartyIdentificationTypeData.newBuilder()
        .setDescription("VCard reference origin")
        .setPartyIdentificationTypeId("VCARD_FN_ORIGIN")
        .build();


    public final static EnumerationData Enumeration_TKCDSRC_COOKIE = EnumerationData.newBuilder()
        .setDescription("Cookie")
        .setEnumCode("COOKIE")
        .setEnumId("TKCDSRC_COOKIE")
        .setEnumTypeId("TRACKINGCODE_SRC")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_TKCDSRC_URL_PARAM = EnumerationData.newBuilder()
        .setDescription("URL Parameter")
        .setEnumCode("URL_PARAM")
        .setEnumId("TKCDSRC_URL_PARAM")
        .setEnumTypeId("TRACKINGCODE_SRC")
        .setSequenceId("01")
        .build();


    public final static EnumerationTypeData EnumerationType_TRACKINGCODE_SRC = EnumerationTypeData.newBuilder()
        .setDescription("Tracking Code Source")
        .setEnumTypeId("TRACKINGCODE_SRC")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_SLSOPP_TYP_ENUM = EnumerationTypeData.newBuilder()
        .setDescription("Sales Opportunity Type")
        .setEnumTypeId("SLSOPP_TYP_ENUM")
        .build();


    public final static DataSourceData DataSource_OTHER = DataSourceData.newBuilder()
        .setDataSourceId("OTHER")
        .setDataSourceTypeId("LEAD_SOURCE")
        .setDescription("Other")
        .build();


    public final static DataSourceData DataSource_COLD_CALL = DataSourceData.newBuilder()
        .setDataSourceId("COLD_CALL")
        .setDataSourceTypeId("LEAD_SOURCE")
        .setDescription("Cold Call")
        .build();


    public final static DataSourceData DataSource_EXISTING_CUSTOMER = DataSourceData.newBuilder()
        .setDataSourceId("EXISTING_CUSTOMER")
        .setDataSourceTypeId("LEAD_SOURCE")
        .setDescription("Existing Customer")
        .build();


    public final static DataSourceData DataSource_SELF_GENERATED = DataSourceData.newBuilder()
        .setDataSourceId("SELF_GENERATED")
        .setDataSourceTypeId("LEAD_SOURCE")
        .setDescription("Self Generated")
        .build();


    public final static DataSourceData DataSource_EMPLOYEE = DataSourceData.newBuilder()
        .setDataSourceId("EMPLOYEE")
        .setDataSourceTypeId("LEAD_SOURCE")
        .setDescription("Employee")
        .build();


    public final static DataSourceData DataSource_PARTNER = DataSourceData.newBuilder()
        .setDataSourceId("PARTNER")
        .setDataSourceTypeId("LEAD_SOURCE")
        .setDescription("Partner")
        .build();


    public final static DataSourceData DataSource_PUBLIC_RELATIONS = DataSourceData.newBuilder()
        .setDataSourceId("PUBLIC_RELATIONS")
        .setDataSourceTypeId("LEAD_SOURCE")
        .setDescription("Public Relations")
        .build();


    public final static DataSourceData DataSource_DIRECT_MAIL = DataSourceData.newBuilder()
        .setDataSourceId("DIRECT_MAIL")
        .setDataSourceTypeId("LEAD_SOURCE")
        .setDescription("Direct Mail")
        .build();


    public final static DataSourceData DataSource_CONFERENCE = DataSourceData.newBuilder()
        .setDataSourceId("CONFERENCE")
        .setDataSourceTypeId("LEAD_SOURCE")
        .setDescription("Conference")
        .build();


    public final static DataSourceData DataSource_TRADE_SHOW = DataSourceData.newBuilder()
        .setDataSourceId("TRADE_SHOW")
        .setDataSourceTypeId("LEAD_SOURCE")
        .setDescription("Trade Show")
        .build();


    public final static DataSourceData DataSource_WEB_SITE = DataSourceData.newBuilder()
        .setDataSourceId("WEB_SITE")
        .setDataSourceTypeId("LEAD_SOURCE")
        .setDescription("Web Site")
        .build();


    public final static DataSourceData DataSource_WORD_OF_MOUTH = DataSourceData.newBuilder()
        .setDataSourceId("WORD_OF_MOUTH")
        .setDataSourceTypeId("LEAD_SOURCE")
        .setDescription("Word of Mouth")
        .build();


    public final static DataSourceData DataSource_EMAIL = DataSourceData.newBuilder()
        .setDataSourceId("EMAIL")
        .setDataSourceTypeId("LEAD_SOURCE")
        .setDescription("Email")
        .build();


    public final static DataSourceData DataSource_CAMPAIGN = DataSourceData.newBuilder()
        .setDataSourceId("CAMPAIGN")
        .setDataSourceTypeId("LEAD_SOURCE")
        .setDescription("Campaign")
        .build();


    public final static StatusItemData StatusItem_MKTG_CAMP_PLANNED = StatusItemData.newBuilder()
        .setDescription("Planned")
        .setSequenceId("01")
        .setStatusCode("PLANNED")
        .setStatusId("MKTG_CAMP_PLANNED")
        .setStatusTypeId("MKTG_CAMP_STATUS")
        .build();


    public final static StatusItemData StatusItem_MKTG_CAMP_APPROVED = StatusItemData.newBuilder()
        .setDescription("Approved")
        .setSequenceId("02")
        .setStatusCode("APPROVED")
        .setStatusId("MKTG_CAMP_APPROVED")
        .setStatusTypeId("MKTG_CAMP_STATUS")
        .build();


    public final static StatusItemData StatusItem_MKTG_CAMP_INPROGRESS = StatusItemData.newBuilder()
        .setDescription("In Progress")
        .setSequenceId("03")
        .setStatusCode("INPROGRESS")
        .setStatusId("MKTG_CAMP_INPROGRESS")
        .setStatusTypeId("MKTG_CAMP_STATUS")
        .build();


    public final static StatusItemData StatusItem_MKTG_CAMP_COMPLETED = StatusItemData.newBuilder()
        .setDescription("Completed")
        .setSequenceId("04")
        .setStatusCode("COMPLETED")
        .setStatusId("MKTG_CAMP_COMPLETED")
        .setStatusTypeId("MKTG_CAMP_STATUS")
        .build();


    public final static StatusItemData StatusItem_MKTG_CAMP_CANCELLED = StatusItemData.newBuilder()
        .setDescription("Cancelled")
        .setSequenceId("05")
        .setStatusCode("CANCELLED")
        .setStatusId("MKTG_CAMP_CANCELLED")
        .setStatusTypeId("MKTG_CAMP_STATUS")
        .build();


    public final static StatusItemData StatusItem_CLPT_PENDING = StatusItemData.newBuilder()
        .setDescription("Pending Acceptance")
        .setSequenceId("01")
        .setStatusCode("PENDING")
        .setStatusId("CLPT_PENDING")
        .setStatusTypeId("CONTACTLST_PARTY")
        .build();


    public final static StatusItemData StatusItem_CLPT_ACCEPTED = StatusItemData.newBuilder()
        .setDescription("Accepted")
        .setSequenceId("02")
        .setStatusCode("ACCEPTED")
        .setStatusId("CLPT_ACCEPTED")
        .setStatusTypeId("CONTACTLST_PARTY")
        .build();


    public final static StatusItemData StatusItem_CLPT_REJECTED = StatusItemData.newBuilder()
        .setDescription("Rejected")
        .setSequenceId("03")
        .setStatusCode("REJECTED")
        .setStatusId("CLPT_REJECTED")
        .setStatusTypeId("CONTACTLST_PARTY")
        .build();


    public final static StatusItemData StatusItem_CLPT_IN_USE = StatusItemData.newBuilder()
        .setDescription("In Use")
        .setSequenceId("04")
        .setStatusCode("IN_USE")
        .setStatusId("CLPT_IN_USE")
        .setStatusTypeId("CONTACTLST_PARTY")
        .build();


    public final static StatusItemData StatusItem_CLPT_INVALID = StatusItemData.newBuilder()
        .setDescription("Invalid")
        .setSequenceId("05")
        .setStatusCode("INVALID")
        .setStatusId("CLPT_INVALID")
        .setStatusTypeId("CONTACTLST_PARTY")
        .build();


    public final static StatusItemData StatusItem_CLPT_UNSUBS_PENDING = StatusItemData.newBuilder()
        .setDescription("Unsubscription pending")
        .setSequenceId("06")
        .setStatusCode("UNSUBS_PENDING")
        .setStatusId("CLPT_UNSUBS_PENDING")
        .setStatusTypeId("CONTACTLST_PARTY")
        .build();


    public final static StatusItemData StatusItem_CLPT_UNSUBSCRIBED = StatusItemData.newBuilder()
        .setDescription("Unsubscribed")
        .setSequenceId("07")
        .setStatusCode("UNSUBSCRIBED")
        .setStatusId("CLPT_UNSUBSCRIBED")
        .setStatusTypeId("CONTACTLST_PARTY")
        .build();


    public final static StatusItemData StatusItem_LEAD_ASSIGNED = StatusItemData.newBuilder()
        .setDescription("Assigned")
        .setSequenceId("01")
        .setStatusCode("ASSIGNED")
        .setStatusId("LEAD_ASSIGNED")
        .setStatusTypeId("LEAD_STATUS")
        .build();


    public final static StatusItemData StatusItem_LEAD_CONVERTED = StatusItemData.newBuilder()
        .setDescription("Converted")
        .setSequenceId("02")
        .setStatusCode("CONVERTED")
        .setStatusId("LEAD_CONVERTED")
        .setStatusTypeId("LEAD_STATUS")
        .build();


    public final static StatusItemData StatusItem_LEAD_QUALIFIED = StatusItemData.newBuilder()
        .setDescription("Qualified")
        .setSequenceId("03")
        .setStatusCode("QUALIFIED")
        .setStatusId("LEAD_QUALIFIED")
        .setStatusTypeId("LEAD_STATUS")
        .build();


    public final static StatusValidChangeData StatusValidChange_MKTG_CAMP_PLANNED_MKTG_CAMP_APPROVED = StatusValidChangeData.newBuilder()
        .setStatusId("MKTG_CAMP_PLANNED")
        .setStatusIdTo("MKTG_CAMP_APPROVED")
        .setTransitionName("Approve Marketing Campaign")
        .build();


    public final static StatusValidChangeData StatusValidChange_MKTG_CAMP_APPROVED_MKTG_CAMP_INPROGRESS = StatusValidChangeData.newBuilder()
        .setStatusId("MKTG_CAMP_APPROVED")
        .setStatusIdTo("MKTG_CAMP_INPROGRESS")
        .setTransitionName("Marketing Campaign In Progress")
        .build();


    public final static StatusValidChangeData StatusValidChange_MKTG_CAMP_INPROGRESS_MKTG_CAMP_COMPLETED = StatusValidChangeData.newBuilder()
        .setStatusId("MKTG_CAMP_INPROGRESS")
        .setStatusIdTo("MKTG_CAMP_COMPLETED")
        .setTransitionName("Complete Marketing Campaign")
        .build();


    public final static StatusValidChangeData StatusValidChange_MKTG_CAMP_PLANNED_MKTG_CAMP_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("MKTG_CAMP_PLANNED")
        .setStatusIdTo("MKTG_CAMP_CANCELLED")
        .setTransitionName("Cancel Marketing Campaign")
        .build();


    public final static StatusValidChangeData StatusValidChange_MKTG_CAMP_APPROVED_MKTG_CAMP_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("MKTG_CAMP_APPROVED")
        .setStatusIdTo("MKTG_CAMP_CANCELLED")
        .setTransitionName("Cancel Marketing Campaign")
        .build();


    public final static StatusValidChangeData StatusValidChange_MKTG_CAMP_INPROGRESS_MKTG_CAMP_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("MKTG_CAMP_INPROGRESS")
        .setStatusIdTo("MKTG_CAMP_CANCELLED")
        .setTransitionName("Cancel Marketing Campaign")
        .build();


    public final static StatusValidChangeData StatusValidChange_CLPT_PENDING_CLPT_ACCEPTED = StatusValidChangeData.newBuilder()
        .setStatusId("CLPT_PENDING")
        .setStatusIdTo("CLPT_ACCEPTED")
        .setTransitionName("Accept")
        .build();


    public final static StatusValidChangeData StatusValidChange_CLPT_PENDING_CLPT_REJECTED = StatusValidChangeData.newBuilder()
        .setStatusId("CLPT_PENDING")
        .setStatusIdTo("CLPT_REJECTED")
        .setTransitionName("Reject")
        .build();


    public final static StatusValidChangeData StatusValidChange_CLPT_ACCEPTED_CLPT_REJECTED = StatusValidChangeData.newBuilder()
        .setStatusId("CLPT_ACCEPTED")
        .setStatusIdTo("CLPT_REJECTED")
        .setTransitionName("Reject")
        .build();


    public final static StatusValidChangeData StatusValidChange_CLPT_REJECTED_CLPT_ACCEPTED = StatusValidChangeData.newBuilder()
        .setStatusId("CLPT_REJECTED")
        .setStatusIdTo("CLPT_ACCEPTED")
        .setTransitionName("Accept")
        .build();


    public final static StatusValidChangeData StatusValidChange_CLPT_REJECTED_CLPT_PENDING = StatusValidChangeData.newBuilder()
        .setStatusId("CLPT_REJECTED")
        .setStatusIdTo("CLPT_PENDING")
        .setTransitionName("Pending Accept")
        .build();


    public final static StatusValidChangeData StatusValidChange_CLPT_ACCEPTED_CLPT_IN_USE = StatusValidChangeData.newBuilder()
        .setStatusId("CLPT_ACCEPTED")
        .setStatusIdTo("CLPT_IN_USE")
        .setTransitionName("Locked - In Use")
        .build();


    public final static StatusValidChangeData StatusValidChange_CLPT_ACCEPTED_CLPT_INVALID = StatusValidChangeData.newBuilder()
        .setStatusId("CLPT_ACCEPTED")
        .setStatusIdTo("CLPT_INVALID")
        .setTransitionName("Invalid")
        .build();


    public final static StatusValidChangeData StatusValidChange_CLPT_ACCEPTED_CLPT_UNSUBS_PENDING = StatusValidChangeData.newBuilder()
        .setStatusId("CLPT_ACCEPTED")
        .setStatusIdTo("CLPT_UNSUBS_PENDING")
        .setTransitionName("Subscription Accepted - Unsubscription Pending")
        .build();


    public final static StatusValidChangeData StatusValidChange_CLPT_PENDING_CLPT_UNSUBS_PENDING = StatusValidChangeData.newBuilder()
        .setStatusId("CLPT_PENDING")
        .setStatusIdTo("CLPT_UNSUBS_PENDING")
        .setTransitionName("Subscription Pending - Unsubscription Pending")
        .build();


    public final static StatusValidChangeData StatusValidChange_CLPT_IN_USE_CLPT_UNSUBS_PENDING = StatusValidChangeData.newBuilder()
        .setStatusId("CLPT_IN_USE")
        .setStatusIdTo("CLPT_UNSUBS_PENDING")
        .setTransitionName("Subscription In Use - Unsubscription Pending")
        .build();


    public final static StatusValidChangeData StatusValidChange_CLPT_INVALID_CLPT_UNSUBS_PENDING = StatusValidChangeData.newBuilder()
        .setStatusId("CLPT_INVALID")
        .setStatusIdTo("CLPT_UNSUBS_PENDING")
        .setTransitionName("Subscription Invalid - Unsubscription Pending")
        .build();


    public final static StatusValidChangeData StatusValidChange_CLPT_ACCEPTED_CLPT_UNSUBSCRIBED = StatusValidChangeData.newBuilder()
        .setStatusId("CLPT_ACCEPTED")
        .setStatusIdTo("CLPT_UNSUBSCRIBED")
        .setTransitionName("Subscription Accepted - Unsubscribed")
        .build();


    public final static StatusValidChangeData StatusValidChange_CLPT_PENDING_CLPT_UNSUBSCRIBED = StatusValidChangeData.newBuilder()
        .setStatusId("CLPT_PENDING")
        .setStatusIdTo("CLPT_UNSUBSCRIBED")
        .setTransitionName("Subscription Accepted - Unsubscribed")
        .build();


    public final static StatusValidChangeData StatusValidChange_CLPT_IN_USE_CLPT_UNSUBSCRIBED = StatusValidChangeData.newBuilder()
        .setStatusId("CLPT_IN_USE")
        .setStatusIdTo("CLPT_UNSUBSCRIBED")
        .setTransitionName("Subscription In Use - Unsubscribed")
        .build();


    public final static StatusValidChangeData StatusValidChange_CLPT_INVALID_CLPT_UNSUBSCRIBED = StatusValidChangeData.newBuilder()
        .setStatusId("CLPT_INVALID")
        .setStatusIdTo("CLPT_UNSUBSCRIBED")
        .setTransitionName("Subscription Invalid - Unsubscribed")
        .build();


    public final static StatusValidChangeData StatusValidChange_PARTY_ENABLED_LEAD_ASSIGNED = StatusValidChangeData.newBuilder()
        .setStatusId("PARTY_ENABLED")
        .setStatusIdTo("LEAD_ASSIGNED")
        .setTransitionName("Assigned")
        .build();


    public final static StatusValidChangeData StatusValidChange_LEAD_ASSIGNED_LEAD_CONVERTED = StatusValidChangeData.newBuilder()
        .setStatusId("LEAD_ASSIGNED")
        .setStatusIdTo("LEAD_CONVERTED")
        .setTransitionName("Converted")
        .build();


    public final static StatusValidChangeData StatusValidChange_LEAD_ASSIGNED_LEAD_QUALIFIED = StatusValidChangeData.newBuilder()
        .setStatusId("LEAD_ASSIGNED")
        .setStatusIdTo("LEAD_QUALIFIED")
        .setTransitionName("Qualified")
        .build();


    public final static StatusValidChangeData StatusValidChange_LEAD_ASSIGNED_PARTY_DISABLED = StatusValidChangeData.newBuilder()
        .setStatusId("LEAD_ASSIGNED")
        .setStatusIdTo("PARTY_DISABLED")
        .setTransitionName("Disabled")
        .build();


    public final static TrackingCodeTypeData TrackingCodeType_ACCESS = TrackingCodeTypeData.newBuilder()
        .setDescription("Access Code")
        .setTrackingCodeTypeId("ACCESS")
        .build();


    public final static TrackingCodeTypeData TrackingCodeType_INTERNAL = TrackingCodeTypeData.newBuilder()
        .setDescription("Internal")
        .setTrackingCodeTypeId("INTERNAL")
        .build();


    public final static TrackingCodeTypeData TrackingCodeType_EXTERNAL = TrackingCodeTypeData.newBuilder()
        .setDescription("External")
        .setTrackingCodeTypeId("EXTERNAL")
        .build();


    public final static TrackingCodeTypeData TrackingCodeType_PARTNER_MGD = TrackingCodeTypeData.newBuilder()
        .setDescription("Partner Managed")
        .setTrackingCodeTypeId("PARTNER_MGD")
        .build();


    public final static StatusTypeData StatusType_MKTG_CAMP_STATUS = StatusTypeData.newBuilder()
        .setDescription("Marketing Campaign")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("MKTG_CAMP_STATUS")
        .build();


    public final static StatusTypeData StatusType_CONTACTLST_PARTY = StatusTypeData.newBuilder()
        .setDescription("Contact List Party")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("CONTACTLST_PARTY")
        .build();


    public final static StatusTypeData StatusType_LEAD_STATUS = StatusTypeData.newBuilder()
        .setDescription("Lead Status")
        .setParentTypeId("PARTY_STATUS")
        .setStatusTypeId("LEAD_STATUS")
        .build();


    public final static SegmentGroupTypeData SegmentGroupType_MARKET_SEGMENT = SegmentGroupTypeData.newBuilder()
        .setDescription("Market Segment")
        .setSegmentGroupTypeId("MARKET_SEGMENT")
        .build();


    public final static SegmentGroupTypeData SegmentGroupType_SALES_SEGMENT = SegmentGroupTypeData.newBuilder()
        .setDescription("Sales Segment")
        .setSegmentGroupTypeId("SALES_SEGMENT")
        .build();


    public final static DataSourceTypeData DataSourceType_LEAD_SOURCE = DataSourceTypeData.newBuilder()
        .setDataSourceTypeId("LEAD_SOURCE")
        .setDescription("Lead Source")
        .build();


    public final static ContactListTypeData ContactListType_MARKETING = ContactListTypeData.newBuilder()
        .setContactListTypeId("MARKETING")
        .setDescription("Marketing")
        .build();


    public final static ContactListTypeData ContactListType_NEWSLETTER = ContactListTypeData.newBuilder()
        .setContactListTypeId("NEWSLETTER")
        .setDescription("Newsletter")
        .build();


    public final static ContactListTypeData ContactListType_ANNOUNCEMENT = ContactListTypeData.newBuilder()
        .setContactListTypeId("ANNOUNCEMENT")
        .setDescription("Announcement")
        .build();

}

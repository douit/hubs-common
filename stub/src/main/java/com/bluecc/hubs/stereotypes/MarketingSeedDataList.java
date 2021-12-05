package com.bluecc.hubs.stereotypes;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.stereotypes.MarketingSeedData.*;

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

public final class MarketingSeedDataList {
    public static final List<PartyIdentificationTypeData> partyIdentificationTypeList=ImmutableList.of(        
            PartyIdentificationType_VCARD_FN_ORIGIN);

    public static final List<EnumerationData> enumerationList=ImmutableList.of(        
            Enumeration_TKCDSRC_COOKIE,        
            Enumeration_TKCDSRC_URL_PARAM);

    public static final List<EnumerationTypeData> enumerationTypeList=ImmutableList.of(        
            EnumerationType_TRACKINGCODE_SRC,        
            EnumerationType_SLSOPP_TYP_ENUM);

    public static final List<DataSourceData> dataSourceList=ImmutableList.of(        
            DataSource_OTHER,        
            DataSource_COLD_CALL,        
            DataSource_EXISTING_CUSTOMER,        
            DataSource_SELF_GENERATED,        
            DataSource_EMPLOYEE,        
            DataSource_PARTNER,        
            DataSource_PUBLIC_RELATIONS,        
            DataSource_DIRECT_MAIL,        
            DataSource_CONFERENCE,        
            DataSource_TRADE_SHOW,        
            DataSource_WEB_SITE,        
            DataSource_WORD_OF_MOUTH,        
            DataSource_EMAIL,        
            DataSource_CAMPAIGN);

    public static final List<StatusItemData> statusItemList=ImmutableList.of(        
            StatusItem_MKTG_CAMP_PLANNED,        
            StatusItem_MKTG_CAMP_APPROVED,        
            StatusItem_MKTG_CAMP_INPROGRESS,        
            StatusItem_MKTG_CAMP_COMPLETED,        
            StatusItem_MKTG_CAMP_CANCELLED,        
            StatusItem_CLPT_PENDING,        
            StatusItem_CLPT_ACCEPTED,        
            StatusItem_CLPT_REJECTED,        
            StatusItem_CLPT_IN_USE,        
            StatusItem_CLPT_INVALID,        
            StatusItem_CLPT_UNSUBS_PENDING,        
            StatusItem_CLPT_UNSUBSCRIBED,        
            StatusItem_LEAD_ASSIGNED,        
            StatusItem_LEAD_CONVERTED,        
            StatusItem_LEAD_QUALIFIED);

    public static final List<StatusValidChangeData> statusValidChangeList=ImmutableList.of(        
            StatusValidChange_MKTG_CAMP_PLANNED_MKTG_CAMP_APPROVED,        
            StatusValidChange_MKTG_CAMP_APPROVED_MKTG_CAMP_INPROGRESS,        
            StatusValidChange_MKTG_CAMP_INPROGRESS_MKTG_CAMP_COMPLETED,        
            StatusValidChange_MKTG_CAMP_PLANNED_MKTG_CAMP_CANCELLED,        
            StatusValidChange_MKTG_CAMP_APPROVED_MKTG_CAMP_CANCELLED,        
            StatusValidChange_MKTG_CAMP_INPROGRESS_MKTG_CAMP_CANCELLED,        
            StatusValidChange_CLPT_PENDING_CLPT_ACCEPTED,        
            StatusValidChange_CLPT_PENDING_CLPT_REJECTED,        
            StatusValidChange_CLPT_ACCEPTED_CLPT_REJECTED,        
            StatusValidChange_CLPT_REJECTED_CLPT_ACCEPTED,        
            StatusValidChange_CLPT_REJECTED_CLPT_PENDING,        
            StatusValidChange_CLPT_ACCEPTED_CLPT_IN_USE,        
            StatusValidChange_CLPT_ACCEPTED_CLPT_INVALID,        
            StatusValidChange_CLPT_ACCEPTED_CLPT_UNSUBS_PENDING,        
            StatusValidChange_CLPT_PENDING_CLPT_UNSUBS_PENDING,        
            StatusValidChange_CLPT_IN_USE_CLPT_UNSUBS_PENDING,        
            StatusValidChange_CLPT_INVALID_CLPT_UNSUBS_PENDING,        
            StatusValidChange_CLPT_ACCEPTED_CLPT_UNSUBSCRIBED,        
            StatusValidChange_CLPT_PENDING_CLPT_UNSUBSCRIBED,        
            StatusValidChange_CLPT_IN_USE_CLPT_UNSUBSCRIBED,        
            StatusValidChange_CLPT_INVALID_CLPT_UNSUBSCRIBED,        
            StatusValidChange_PARTY_ENABLED_LEAD_ASSIGNED,        
            StatusValidChange_LEAD_ASSIGNED_LEAD_CONVERTED,        
            StatusValidChange_LEAD_ASSIGNED_LEAD_QUALIFIED,        
            StatusValidChange_LEAD_ASSIGNED_PARTY_DISABLED);

    public static final List<TrackingCodeTypeData> trackingCodeTypeList=ImmutableList.of(        
            TrackingCodeType_ACCESS,        
            TrackingCodeType_INTERNAL,        
            TrackingCodeType_EXTERNAL,        
            TrackingCodeType_PARTNER_MGD);

    public static final List<StatusTypeData> statusTypeList=ImmutableList.of(        
            StatusType_MKTG_CAMP_STATUS,        
            StatusType_CONTACTLST_PARTY,        
            StatusType_LEAD_STATUS);

    public static final List<SegmentGroupTypeData> segmentGroupTypeList=ImmutableList.of(        
            SegmentGroupType_MARKET_SEGMENT,        
            SegmentGroupType_SALES_SEGMENT);

    public static final List<DataSourceTypeData> dataSourceTypeList=ImmutableList.of(        
            DataSourceType_LEAD_SOURCE);

    public static final List<ContactListTypeData> contactListTypeList=ImmutableList.of(        
            ContactListType_MARKETING,        
            ContactListType_NEWSLETTER,        
            ContactListType_ANNOUNCEMENT);

}

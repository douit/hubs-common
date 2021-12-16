//// Generated, DO NOT EDIT
package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;
// import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;
import static com.bluecc.hubs.fund.FnUtil.getter;

import com.bluecc.hubs.stub.PartyRoleData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PartyRoleData.class,
        symbol = EntityNames.PartyRole)
public class PartyRole implements IEventModel<PartyRoleData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String partyId;
    @RIndex String roleTypeId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public PartyRoleData.Builder toDataBuilder() {
        PartyRoleData.Builder builder = PartyRoleData.newBuilder();
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (roleTypeId != null) {
            builder.setRoleTypeId(roleTypeId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
        if (id != null) {
            builder.setId(id);
        }
                    
        return builder;
    }

    public static PartyRole fromData(PartyRoleData data) {
        return PartyRole.builder()
                .partyId(data.getPartyId())
                .roleTypeId(data.getRoleTypeId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: partyId, roleTypeId

-- fields --
    
    String partyId
    String roleTypeId

-- relations --
    
    - Party (one, autoRelation: false, keymaps: partyId)
    - RoleType (one, autoRelation: false, keymaps: roleTypeId)
    + RoleTypeAttr (many, autoRelation: false, keymaps: roleTypeId)
    + PartyAttribute (many, autoRelation: false, keymaps: partyId)
    + AcctgTrans (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + AcctgTransEntry (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + FromAgreement (many, autoRelation: true, keymaps: partyId -> partyIdFrom, roleTypeId -> roleTypeIdFrom)
    + ToAgreement (many, autoRelation: true, keymaps: partyId -> partyIdTo, roleTypeId -> roleTypeIdTo)
    + AgreementRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + BillingAccountRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + BudgetRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + CarrierShipmentMethod (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + ToCommunicationEvent (many, autoRelation: true, keymaps: partyId -> partyIdTo, roleTypeId -> roleTypeIdTo)
    + FromCommunicationEvent (many, autoRelation: true, keymaps: partyId -> partyIdFrom, roleTypeId -> roleTypeIdFrom)
    + CommunicationEventRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + ContentRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + CustRequestParty (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + DataResourceRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + ToEmployment (many, autoRelation: true, keymaps: partyId -> partyIdTo, roleTypeId -> roleTypeIdTo)
    + FromEmployment (many, autoRelation: true, keymaps: partyId -> partyIdFrom, roleTypeId -> roleTypeIdFrom)
    + FacilityGroupRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + FacilityParty (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + FinAccountRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + FixedAsset (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + GlAccountOrganization (many, autoRelation: true, keymaps: partyId -> organizationPartyId, roleTypeId)
    + GlAccountRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + Invoice (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + InvoiceRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + ItemIssuanceRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + MarketingCampaignRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + OrderItemRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + CarrierOrderItemShipGroup (many, autoRelation: true, keymaps: partyId -> carrierPartyId, roleTypeId -> carrierRoleTypeId)
    + OrderRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + ToPartyBenefit (many, autoRelation: true, keymaps: partyId -> partyIdTo, roleTypeId -> roleTypeIdTo)
    + FromPartyBenefit (many, autoRelation: true, keymaps: partyId -> partyIdFrom, roleTypeId -> roleTypeIdFrom)
    + PartyContactMech (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + PartyFixedAssetAssignment (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + PartyGlAccount (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + PartyNeed (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + FromPartyRelationship (many, autoRelation: true, keymaps: partyId -> partyIdFrom, roleTypeId -> roleTypeIdFrom)
    + ToPartyRelationship (many, autoRelation: true, keymaps: partyId -> partyIdTo, roleTypeId -> roleTypeIdTo)
    + ToPayment (many, autoRelation: true, keymaps: partyId -> partyIdTo, roleTypeId -> roleTypeIdTo)
    + PayrollPreference (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + EmployeePerfReview (many, autoRelation: true, keymaps: partyId -> employeePartyId, roleTypeId -> employeeRoleTypeId)
    + ManagerPerfReview (many, autoRelation: true, keymaps: partyId -> managerPartyId, roleTypeId -> managerRoleTypeId)
    + EmployeePerfReviewItem (many, autoRelation: true, keymaps: partyId -> employeePartyId, roleTypeId -> employeeRoleTypeId)
    + PerformanceNote (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + PicklistRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + ProdCatalogRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + ProductCategoryRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + ProductRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + ProductStoreGroupRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + ProductStoreRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + QuoteRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + RequirementRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + SalesOpportunityRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + SegmentGroupRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + ShipmentCostEstimate (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + ShipmentReceiptRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + Subscription (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + OriginatedFromSubscription (many, autoRelation: true, keymaps: partyId -> originatedFromPartyId, roleTypeId -> originatedFromRoleTypeId)
    + TimesheetRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + WebSiteRole (many, autoRelation: true, keymaps: partyId, roleTypeId)
    + WorkEffortPartyAssignment (many, autoRelation: true, keymaps: partyId, roleTypeId)
*/


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
import com.google.gson.annotations.SerializedName;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;
import static com.bluecc.hubs.fund.FnUtil.getter;

import com.bluecc.hubs.stub.WorkEffortPartyAssignmentData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = WorkEffortPartyAssignmentData.class,
        symbol = EntityNames.WorkEffortPartyAssignment)
public class WorkEffortPartyAssignment implements IEventModel<WorkEffortPartyAssignmentData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("work_effort_id")
	@RIndex 
    String workEffortId;
    @SerializedName("party_id")
	@RIndex 
    String partyId;
    @SerializedName("role_type_id")
	@RIndex 
    String roleTypeId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("assigned_by_user_login_id") 
    String assignedByUserLoginId;
    @SerializedName("status_id") 
    String statusId;
    @SerializedName("status_date_time") 
    java.time.LocalDateTime statusDateTime;
    @SerializedName("expectation_enum_id") 
    String expectationEnumId;
    @SerializedName("delegate_reason_enum_id") 
    String delegateReasonEnumId;
    @SerializedName("facility_id") 
    String facilityId;
    @SerializedName("comments") 
    String comments;
    @SerializedName("must_rsvp") 
    Character mustRsvp;
    @SerializedName("availability_status_id") 
    String availabilityStatusId;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    @SerializedName("id")
	@RId 
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public WorkEffortPartyAssignmentData.Builder toDataBuilder() {
        WorkEffortPartyAssignmentData.Builder builder = WorkEffortPartyAssignmentData.newBuilder();
        if (workEffortId != null) {
            builder.setWorkEffortId(workEffortId);
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (roleTypeId != null) {
            builder.setRoleTypeId(roleTypeId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (assignedByUserLoginId != null) {
            builder.setAssignedByUserLoginId(assignedByUserLoginId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (statusDateTime != null) {
            builder.setStatusDateTime(getTimestamp(statusDateTime));
        }
        if (expectationEnumId != null) {
            builder.setExpectationEnumId(expectationEnumId);
        }
        if (delegateReasonEnumId != null) {
            builder.setDelegateReasonEnumId(delegateReasonEnumId);
        }
        if (facilityId != null) {
            builder.setFacilityId(facilityId);
        }
        if (comments != null) {
            builder.setComments(comments);
        }
        if (mustRsvp != null) {
            builder.setMustRsvp(getIndicator(mustRsvp));
        }
        if (availabilityStatusId != null) {
            builder.setAvailabilityStatusId(availabilityStatusId);
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

    public static WorkEffortPartyAssignment fromData(WorkEffortPartyAssignmentData data) {
        return WorkEffortPartyAssignment.builder()
                .workEffortId(data.getWorkEffortId())
                .partyId(data.getPartyId())
                .roleTypeId(data.getRoleTypeId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .assignedByUserLoginId(data.getAssignedByUserLoginId())
                .statusId(data.getStatusId())
                .statusDateTime(getLocalDateTime(data.getStatusDateTime()))
                .expectationEnumId(data.getExpectationEnumId())
                .delegateReasonEnumId(data.getDelegateReasonEnumId())
                .facilityId(data.getFacilityId())
                .comments(data.getComments())
                .mustRsvp(getIndicatorChar(data.getMustRsvp()))
                .availabilityStatusId(data.getAvailabilityStatusId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: workEffortId, partyId, roleTypeId, fromDate

-- fields --
    
    String workEffortId
    String partyId
    String roleTypeId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    String assignedByUserLoginId
    String statusId
    java.time.LocalDateTime statusDateTime
    String expectationEnumId
    String delegateReasonEnumId
    String facilityId
    String comments
    Character mustRsvp
    String availabilityStatusId

-- relations --
    
    - WorkEffort (one, autoRelation: false, keymaps: workEffortId)
    - Party (one-nofk, autoRelation: false, keymaps: partyId)
    - PartyRole (one, autoRelation: false, keymaps: partyId, roleTypeId)
    - RoleType (one-nofk, autoRelation: false, keymaps: roleTypeId)
    - AssignedByUserLogin (one, autoRelation: false, keymaps: assignedByUserLoginId -> userLoginId)
    - AssignmentStatusItem (one, autoRelation: false, keymaps: statusId)
    - ExpectationEnumeration (one, autoRelation: false, keymaps: expectationEnumId -> enumId)
    - DelegateReasonEnumeration (one, autoRelation: false, keymaps: delegateReasonEnumId -> enumId)
    - Facility (one, autoRelation: false, keymaps: facilityId)
    - AvailabilityStatusItem (one, autoRelation: false, keymaps: availabilityStatusId -> statusId)
    + ApplicationSandbox (many, autoRelation: true, keymaps: workEffortId, partyId, roleTypeId, fromDate)
*/


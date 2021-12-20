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
        if (getWorkEffortId() != null) {
            builder.setWorkEffortId(getWorkEffortId());
        }
        if (getPartyId() != null) {
            builder.setPartyId(getPartyId());
        }
        if (getRoleTypeId() != null) {
            builder.setRoleTypeId(getRoleTypeId());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
        }
        if (getAssignedByUserLoginId() != null) {
            builder.setAssignedByUserLoginId(getAssignedByUserLoginId());
        }
        if (getStatusId() != null) {
            builder.setStatusId(getStatusId());
        }
        if (getStatusDateTime() != null) {
            builder.setStatusDateTime(getTimestamp(getStatusDateTime()));
        }
        if (getExpectationEnumId() != null) {
            builder.setExpectationEnumId(getExpectationEnumId());
        }
        if (getDelegateReasonEnumId() != null) {
            builder.setDelegateReasonEnumId(getDelegateReasonEnumId());
        }
        if (getFacilityId() != null) {
            builder.setFacilityId(getFacilityId());
        }
        if (getComments() != null) {
            builder.setComments(getComments());
        }
        if (getMustRsvp() != null) {
            builder.setMustRsvp(getIndicator(getMustRsvp()));
        }
        if (getAvailabilityStatusId() != null) {
            builder.setAvailabilityStatusId(getAvailabilityStatusId());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
        if (getId() != null) {
            builder.setId(getId());
        }
                    
        return builder;
    }

    public static WorkEffortPartyAssignment fromData(WorkEffortPartyAssignmentData data) {
        return fromPrototype(data).build();
    }

    public static WorkEffortPartyAssignment.WorkEffortPartyAssignmentBuilder fromPrototype(WorkEffortPartyAssignmentData data) {
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
                ;
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


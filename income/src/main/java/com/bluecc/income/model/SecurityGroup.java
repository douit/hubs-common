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

import com.bluecc.hubs.stub.SecurityGroupFlatData;

import com.bluecc.hubs.stub.SecurityGroupData;
import com.bluecc.income.dao.SecurityGroupDelegator;
import static com.bluecc.income.dao.SecurityGroupDelegator.*;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = SecurityGroupData.class,
        symbol = EntityNames.SecurityGroup)
public class SecurityGroup implements IEventModel<SecurityGroupFlatData.Builder>, HasId, Serializable, WithSuppliers, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("group_id")
	@RId 
    String groupId;
    @SerializedName("group_name") 
    String groupName;
    @SerializedName("description") 
    String description;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    @SerializedName("tenant_id") 
    String tenantId;
    
    @Override
    public String getId(){
        return groupId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public SecurityGroupFlatData.Builder toDataBuilder() {
        SecurityGroupFlatData.Builder builder = SecurityGroupFlatData.newBuilder();
        if (groupId != null) {
            builder.setGroupId(groupId);
        }
        if (groupName != null) {
            builder.setGroupName(groupName);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
        if (tenantId != null) {
            builder.setTenantId(tenantId);
        }
                    
        return builder;
    }

    public static SecurityGroup fromData(SecurityGroupFlatData data) {
        return SecurityGroup.builder()
                .groupId(data.getGroupId())
                .groupName(data.getGroupName())
                .description(data.getDescription())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .tenantId(data.getTenantId())
                
                .build();
    }

        // relations
     
    @Exclude
    @Singular("addPartyRelationship")
    @SerializedName("party_relationship") 
    List<PartyRelationship> relPartyRelationship= new ArrayList<>(); 
    @Exclude
    @Singular("addSecurityGroupPermission")
    @SerializedName("security_group_permission") 
    List<SecurityGroupPermission> relSecurityGroupPermission= new ArrayList<>(); 
    @Exclude
    @Singular("addUserLoginSecurityGroup")
    @SerializedName("user_login_security_group") 
    List<UserLoginSecurityGroup> relUserLoginSecurityGroup= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    @SerializedName("tenant") 
    List<Tenant> relTenant= new ArrayList<>();

    public Map<String, Supplier<List<?>>> suppliers(){
        Map<String, Supplier<List<?>>> supplierMap=Maps.newHashMap();
         
        supplierMap.put(PARTY_RELATIONSHIP, getter(this, SecurityGroup::getRelPartyRelationship)); 
        supplierMap.put(SECURITY_GROUP_PERMISSION, getter(this, SecurityGroup::getRelSecurityGroupPermission)); 
        supplierMap.put(USER_LOGIN_SECURITY_GROUP, getter(this, SecurityGroup::getRelUserLoginSecurityGroup)); 
        supplierMap.put(TENANT, getter(this, SecurityGroup::getRelTenant));

        return supplierMap;
    };

    public SecurityGroupDelegator.Agent agent(IProc.ProcContext ctx,
                                             SecurityGroupDelegator delegator){
        return delegator.getAgent(ctx, this.getGroupId());
    }

    public SecurityGroupData.Builder toHeadBuilder() {
        SecurityGroupData.Builder builder = SecurityGroupData.newBuilder();
        if (groupId != null) {
            builder.setGroupId(groupId);
        }
        if (groupName != null) {
            builder.setGroupName(groupName);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

}


/*
-- keys: groupId

-- fields --
    
    String groupId
    String groupName
    String description

-- relations --
    
    + PartyRelationship (many, autoRelation: true, keymaps: groupId -> securityGroupId)
    + PortalPage (many, autoRelation: true, keymaps: groupId -> securityGroupId)
    + ProtectedView (many, autoRelation: true, keymaps: groupId)
    + SecurityGroupPermission (many, autoRelation: true, keymaps: groupId)
    + UserLoginSecurityGroup (many, autoRelation: true, keymaps: groupId)
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/


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

import com.bluecc.hubs.stub.GlAccountTypeDefaultData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = GlAccountTypeDefaultData.class,
        symbol = EntityNames.GlAccountTypeDefault)
public class GlAccountTypeDefault implements IEventModel<GlAccountTypeDefaultData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("gl_account_type_id")
	@RIndex 
    String glAccountTypeId;
    @SerializedName("organization_party_id")
	@RIndex 
    String organizationPartyId;
    @SerializedName("gl_account_id") 
    String glAccountId;
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

    public GlAccountTypeDefaultData.Builder toDataBuilder() {
        GlAccountTypeDefaultData.Builder builder = GlAccountTypeDefaultData.newBuilder();
        if (getGlAccountTypeId() != null) {
            builder.setGlAccountTypeId(getGlAccountTypeId());
        }
        if (getOrganizationPartyId() != null) {
            builder.setOrganizationPartyId(getOrganizationPartyId());
        }
        if (getGlAccountId() != null) {
            builder.setGlAccountId(getGlAccountId());
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

    public static GlAccountTypeDefault fromData(GlAccountTypeDefaultData data) {
        return fromPrototype(data).build();
    }

    public static GlAccountTypeDefault.GlAccountTypeDefaultBuilder fromPrototype(GlAccountTypeDefaultData data) {
        return GlAccountTypeDefault.builder()
                .glAccountTypeId(data.getGlAccountTypeId())
                .organizationPartyId(data.getOrganizationPartyId())
                .glAccountId(data.getGlAccountId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: glAccountTypeId, organizationPartyId

-- fields --
    
    String glAccountTypeId
    String organizationPartyId
    String glAccountId

-- relations --
    
    - GlAccountType (one, autoRelation: false, keymaps: glAccountTypeId)
    - OrganizationParty (one, autoRelation: false, keymaps: organizationPartyId -> partyId)
    - GlAccount (one, autoRelation: false, keymaps: glAccountId)
*/


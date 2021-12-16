package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;

import com.bluecc.hubs.stub.TaxAuthorityGlAccountData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = TaxAuthorityGlAccountData.class,
        symbol = EntityNames.TaxAuthorityGlAccount)
public class TaxAuthorityGlAccount implements IEventModel<TaxAuthorityGlAccountData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String taxAuthGeoId;
    @RIndex String taxAuthPartyId;
    @RIndex String organizationPartyId;
    String glAccountId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public TaxAuthorityGlAccountData.Builder toDataBuilder() {
        TaxAuthorityGlAccountData.Builder builder = TaxAuthorityGlAccountData.newBuilder();
        if (taxAuthGeoId != null) {
            builder.setTaxAuthGeoId(taxAuthGeoId);
        }
        if (taxAuthPartyId != null) {
            builder.setTaxAuthPartyId(taxAuthPartyId);
        }
        if (organizationPartyId != null) {
            builder.setOrganizationPartyId(organizationPartyId);
        }
        if (glAccountId != null) {
            builder.setGlAccountId(glAccountId);
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

    public static TaxAuthorityGlAccount fromData(TaxAuthorityGlAccountData data) {
        return TaxAuthorityGlAccount.builder()
                .taxAuthGeoId(data.getTaxAuthGeoId())
                .taxAuthPartyId(data.getTaxAuthPartyId())
                .organizationPartyId(data.getOrganizationPartyId())
                .glAccountId(data.getGlAccountId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: taxAuthGeoId, taxAuthPartyId, organizationPartyId

-- fields --
    
    String taxAuthGeoId
    String taxAuthPartyId
    String organizationPartyId
    String glAccountId

-- relations --
    
    - TaxAuthority (one, autoRelation: false, keymaps: taxAuthGeoId, taxAuthPartyId)
    - OrganizationParty (one, autoRelation: false, keymaps: organizationPartyId -> partyId)
    - GlAccount (one, autoRelation: false, keymaps: glAccountId)
*/


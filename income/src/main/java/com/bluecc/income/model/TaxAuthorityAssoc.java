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

import com.bluecc.hubs.stub.TaxAuthorityAssocData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = TaxAuthorityAssocData.class,
        symbol = EntityNames.TaxAuthorityAssoc)
public class TaxAuthorityAssoc implements IEventModel<TaxAuthorityAssocData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("tax_auth_geo_id")
	@RIndex 
    String taxAuthGeoId;
    @SerializedName("tax_auth_party_id")
	@RIndex 
    String taxAuthPartyId;
    @SerializedName("to_tax_auth_geo_id")
	@RIndex 
    String toTaxAuthGeoId;
    @SerializedName("to_tax_auth_party_id")
	@RIndex 
    String toTaxAuthPartyId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("tax_authority_assoc_type_id") 
    String taxAuthorityAssocTypeId;
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

    public TaxAuthorityAssocData.Builder toDataBuilder() {
        TaxAuthorityAssocData.Builder builder = TaxAuthorityAssocData.newBuilder();
        if (taxAuthGeoId != null) {
            builder.setTaxAuthGeoId(taxAuthGeoId);
        }
        if (taxAuthPartyId != null) {
            builder.setTaxAuthPartyId(taxAuthPartyId);
        }
        if (toTaxAuthGeoId != null) {
            builder.setToTaxAuthGeoId(toTaxAuthGeoId);
        }
        if (toTaxAuthPartyId != null) {
            builder.setToTaxAuthPartyId(toTaxAuthPartyId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (taxAuthorityAssocTypeId != null) {
            builder.setTaxAuthorityAssocTypeId(taxAuthorityAssocTypeId);
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

    public static TaxAuthorityAssoc fromData(TaxAuthorityAssocData data) {
        return TaxAuthorityAssoc.builder()
                .taxAuthGeoId(data.getTaxAuthGeoId())
                .taxAuthPartyId(data.getTaxAuthPartyId())
                .toTaxAuthGeoId(data.getToTaxAuthGeoId())
                .toTaxAuthPartyId(data.getToTaxAuthPartyId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .taxAuthorityAssocTypeId(data.getTaxAuthorityAssocTypeId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: taxAuthGeoId, taxAuthPartyId, toTaxAuthGeoId, toTaxAuthPartyId, fromDate

-- fields --
    
    String taxAuthGeoId
    String taxAuthPartyId
    String toTaxAuthGeoId
    String toTaxAuthPartyId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    String taxAuthorityAssocTypeId

-- relations --
    
    - TaxAuthority (one, autoRelation: false, keymaps: taxAuthGeoId, taxAuthPartyId)
    - ToTaxAuthority (one, autoRelation: false, keymaps: toTaxAuthGeoId -> taxAuthGeoId, toTaxAuthPartyId -> taxAuthPartyId)
    - TaxAuthorityAssocType (one, autoRelation: false, keymaps: taxAuthorityAssocTypeId)
*/


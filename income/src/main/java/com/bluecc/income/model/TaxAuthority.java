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

import com.bluecc.hubs.stub.TaxAuthorityData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = TaxAuthorityData.class,
        symbol = EntityNames.TaxAuthority)
public class TaxAuthority implements IEventModel<TaxAuthorityData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("tax_auth_geo_id")
	@RIndex 
    String taxAuthGeoId;
    @SerializedName("tax_auth_party_id")
	@RIndex 
    String taxAuthPartyId;
    @SerializedName("require_tax_id_for_exemption") 
    Character requireTaxIdForExemption;
    @SerializedName("tax_id_format_pattern") 
    String taxIdFormatPattern;
    @SerializedName("include_tax_in_price") 
    Character includeTaxInPrice;
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

    public TaxAuthorityData.Builder toDataBuilder() {
        TaxAuthorityData.Builder builder = TaxAuthorityData.newBuilder();
        if (taxAuthGeoId != null) {
            builder.setTaxAuthGeoId(taxAuthGeoId);
        }
        if (taxAuthPartyId != null) {
            builder.setTaxAuthPartyId(taxAuthPartyId);
        }
        if (requireTaxIdForExemption != null) {
            builder.setRequireTaxIdForExemption(getIndicator(requireTaxIdForExemption));
        }
        if (taxIdFormatPattern != null) {
            builder.setTaxIdFormatPattern(taxIdFormatPattern);
        }
        if (includeTaxInPrice != null) {
            builder.setIncludeTaxInPrice(getIndicator(includeTaxInPrice));
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

    public static TaxAuthority fromData(TaxAuthorityData data) {
        return TaxAuthority.builder()
                .taxAuthGeoId(data.getTaxAuthGeoId())
                .taxAuthPartyId(data.getTaxAuthPartyId())
                .requireTaxIdForExemption(getIndicatorChar(data.getRequireTaxIdForExemption()))
                .taxIdFormatPattern(data.getTaxIdFormatPattern())
                .includeTaxInPrice(getIndicatorChar(data.getIncludeTaxInPrice()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: taxAuthGeoId, taxAuthPartyId

-- fields --
    
    String taxAuthGeoId
    String taxAuthPartyId
    Character requireTaxIdForExemption
    String taxIdFormatPattern
    Character includeTaxInPrice

-- relations --
    
    - TaxAuthGeo (one, autoRelation: false, keymaps: taxAuthGeoId -> geoId)
    - TaxAuthParty (one, autoRelation: false, keymaps: taxAuthPartyId -> partyId)
    + OrderAdjustment (many, autoRelation: true, keymaps: taxAuthGeoId, taxAuthPartyId)
    + PartyTaxAuthInfo (many, autoRelation: true, keymaps: taxAuthGeoId, taxAuthPartyId)
    + VatProductStore (many, autoRelation: true, keymaps: taxAuthGeoId -> vatTaxAuthGeoId, taxAuthPartyId -> vatTaxAuthPartyId)
    + QuoteAdjustment (many, autoRelation: true, keymaps: taxAuthGeoId, taxAuthPartyId)
    + ReturnAdjustment (many, autoRelation: true, keymaps: taxAuthGeoId, taxAuthPartyId)
    + TaxAuthorityAssoc (many, autoRelation: true, keymaps: taxAuthGeoId, taxAuthPartyId)
    + ToTaxAuthorityAssoc (many, autoRelation: true, keymaps: taxAuthGeoId -> toTaxAuthGeoId, taxAuthPartyId -> toTaxAuthPartyId)
    + TaxAuthorityCategory (many, autoRelation: true, keymaps: taxAuthGeoId, taxAuthPartyId)
    + TaxAuthorityGlAccount (many, autoRelation: true, keymaps: taxAuthGeoId, taxAuthPartyId)
    + TaxAuthorityRateProduct (many, autoRelation: true, keymaps: taxAuthGeoId, taxAuthPartyId)
*/


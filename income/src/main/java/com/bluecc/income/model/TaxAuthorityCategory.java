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

import com.bluecc.hubs.stub.TaxAuthorityCategoryData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = TaxAuthorityCategoryData.class,
        symbol = EntityNames.TaxAuthorityCategory)
public class TaxAuthorityCategory implements IEventModel<TaxAuthorityCategoryData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String taxAuthGeoId;
    @RIndex String taxAuthPartyId;
    @RIndex String productCategoryId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public TaxAuthorityCategoryData.Builder toDataBuilder() {
        TaxAuthorityCategoryData.Builder builder = TaxAuthorityCategoryData.newBuilder();
        if (taxAuthGeoId != null) {
            builder.setTaxAuthGeoId(taxAuthGeoId);
        }
        if (taxAuthPartyId != null) {
            builder.setTaxAuthPartyId(taxAuthPartyId);
        }
        if (productCategoryId != null) {
            builder.setProductCategoryId(productCategoryId);
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

    public static TaxAuthorityCategory fromData(TaxAuthorityCategoryData data) {
        return TaxAuthorityCategory.builder()
                .taxAuthGeoId(data.getTaxAuthGeoId())
                .taxAuthPartyId(data.getTaxAuthPartyId())
                .productCategoryId(data.getProductCategoryId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: taxAuthGeoId, taxAuthPartyId, productCategoryId

-- fields --
    
    String taxAuthGeoId
    String taxAuthPartyId
    String productCategoryId

-- relations --
    
    - TaxAuthority (one, autoRelation: false, keymaps: taxAuthGeoId, taxAuthPartyId)
    - ProductCategory (one, autoRelation: false, keymaps: productCategoryId)
*/


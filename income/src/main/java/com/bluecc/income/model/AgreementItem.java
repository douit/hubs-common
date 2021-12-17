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

import com.bluecc.hubs.stub.AgreementItemData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = AgreementItemData.class,
        symbol = EntityNames.AgreementItem)
public class AgreementItem implements IEventModel<AgreementItemData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("agreement_id")
	@RIndex 
    String agreementId;
    @SerializedName("agreement_item_seq_id")
	@RIndex 
    String agreementItemSeqId;
    @SerializedName("agreement_item_type_id") 
    String agreementItemTypeId;
    @SerializedName("currency_uom_id") 
    String currencyUomId;
    @SerializedName("agreement_text") 
    String agreementText;
    @SerializedName("agreement_image") 
    byte[] agreementImage;
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

    public AgreementItemData.Builder toDataBuilder() {
        AgreementItemData.Builder builder = AgreementItemData.newBuilder();
        if (agreementId != null) {
            builder.setAgreementId(agreementId);
        }
        if (agreementItemSeqId != null) {
            builder.setAgreementItemSeqId(agreementItemSeqId);
        }
        if (agreementItemTypeId != null) {
            builder.setAgreementItemTypeId(agreementItemTypeId);
        }
        if (currencyUomId != null) {
            builder.setCurrencyUomId(currencyUomId);
        }
        if (agreementText != null) {
            builder.setAgreementText(agreementText);
        }
        if (agreementImage != null) {
            builder.setAgreementImage(ByteString.copyFrom(agreementImage));
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

    public static AgreementItem fromData(AgreementItemData data) {
        return AgreementItem.builder()
                .agreementId(data.getAgreementId())
                .agreementItemSeqId(data.getAgreementItemSeqId())
                .agreementItemTypeId(data.getAgreementItemTypeId())
                .currencyUomId(data.getCurrencyUomId())
                .agreementText(data.getAgreementText())
                .agreementImage(data.getAgreementImage().toByteArray())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: agreementId, agreementItemSeqId

-- fields --
    
    String agreementId
    String agreementItemSeqId
    String agreementItemTypeId
    String currencyUomId
    String agreementText
    byte[] agreementImage

-- relations --
    
    - Agreement (one, autoRelation: false, keymaps: agreementId)
    - AgreementItemType (one, autoRelation: false, keymaps: agreementItemTypeId)
    + AgreementItemTypeAttr (many, autoRelation: false, keymaps: agreementItemTypeId)
    + Addendum (many, autoRelation: true, keymaps: agreementId, agreementItemSeqId)
    + AgreementEmploymentAppl (many, autoRelation: true, keymaps: agreementId, agreementItemSeqId)
    + AgreementFacilityAppl (many, autoRelation: true, keymaps: agreementId, agreementItemSeqId)
    + AgreementGeographicalApplic (many, autoRelation: true, keymaps: agreementId, agreementItemSeqId)
    + AgreementItemAttribute (many, autoRelation: true, keymaps: agreementId, agreementItemSeqId)
    + AgreementPartyApplic (many, autoRelation: true, keymaps: agreementId, agreementItemSeqId)
    + AgreementProductAppl (many, autoRelation: true, keymaps: agreementId, agreementItemSeqId)
    + AgreementPromoAppl (many, autoRelation: true, keymaps: agreementId, agreementItemSeqId)
    + AgreementTerm (many, autoRelation: true, keymaps: agreementId, agreementItemSeqId)
    + AgreementWorkEffortApplic (many, autoRelation: true, keymaps: agreementId, agreementItemSeqId)
    + SupplierProduct (many, autoRelation: true, keymaps: agreementId, agreementItemSeqId)
*/


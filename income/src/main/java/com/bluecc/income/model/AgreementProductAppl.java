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

import com.bluecc.hubs.stub.AgreementProductApplData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = AgreementProductApplData.class,
        symbol = EntityNames.AgreementProductAppl)
public class AgreementProductAppl implements IEventModel<AgreementProductApplData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("agreement_id")
	@RIndex 
    String agreementId;
    @SerializedName("agreement_item_seq_id")
	@RIndex 
    String agreementItemSeqId;
    @SerializedName("product_id")
	@RIndex 
    String productId;
    @SerializedName("price") 
    java.math.BigDecimal price;
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

    public AgreementProductApplData.Builder toDataBuilder() {
        AgreementProductApplData.Builder builder = AgreementProductApplData.newBuilder();
        if (getAgreementId() != null) {
            builder.setAgreementId(getAgreementId());
        }
        if (getAgreementItemSeqId() != null) {
            builder.setAgreementItemSeqId(getAgreementItemSeqId());
        }
        if (getProductId() != null) {
            builder.setProductId(getProductId());
        }
        if (getPrice() != null) {
            builder.setPrice(getCurrency(getPrice()));
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

    public static AgreementProductAppl fromData(AgreementProductApplData data) {
        return fromPrototype(data).build();
    }

    public static AgreementProductAppl.AgreementProductApplBuilder fromPrototype(AgreementProductApplData data) {
        return AgreementProductAppl.builder()
                .agreementId(data.getAgreementId())
                .agreementItemSeqId(data.getAgreementItemSeqId())
                .productId(data.getProductId())
                .price(getBigDecimal(data.getPrice()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: agreementId, agreementItemSeqId, productId

-- fields --
    
    String agreementId
    String agreementItemSeqId
    String productId
    java.math.BigDecimal price

-- relations --
    
    - Agreement (one-nofk, autoRelation: false, keymaps: agreementId)
    - AgreementItem (one, autoRelation: false, keymaps: agreementId, agreementItemSeqId)
    - Product (one, autoRelation: false, keymaps: productId)
*/


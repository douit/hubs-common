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

import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;

import com.bluecc.hubs.stub.AgreementItemData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = AgreementItemData.class,
        symbol = EntityNames.AgreementItem)
public class AgreementItem implements IEventModel<AgreementItemData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String agreementId;
    @RIndex String agreementItemSeqId;
    String agreementItemTypeId;
    String currencyUomId;
    String agreementText;
    byte[] agreementImage;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
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

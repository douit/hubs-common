package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.AgreementProductApplData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgreementProductAppl implements IEventModel<AgreementProductApplData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String agreementId;
    String agreementItemSeqId;
    String productId;
    java.math.BigDecimal price;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public AgreementProductApplData.Builder toDataBuilder() {
        AgreementProductApplData.Builder builder = AgreementProductApplData.newBuilder();
        if (agreementId != null) {
            builder.setAgreementId(agreementId);
        }
        if (agreementItemSeqId != null) {
            builder.setAgreementItemSeqId(agreementItemSeqId);
        }
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (price != null) {
            builder.setPrice(getCurrency(price));
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

    public static AgreementProductAppl fromData(AgreementProductApplData data) {
        return AgreementProductAppl.builder()
                .agreementId(data.getAgreementId())
                .agreementItemSeqId(data.getAgreementItemSeqId())
                .productId(data.getProductId())
                .price(getBigDecimal(data.getPrice()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}

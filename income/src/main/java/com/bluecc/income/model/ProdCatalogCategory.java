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
import com.bluecc.hubs.stub.ProdCatalogCategoryData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdCatalogCategory implements IEventModel<ProdCatalogCategoryData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String prodCatalogId;
    String productCategoryId;
    String prodCatalogCategoryTypeId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    Long sequenceNum;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProdCatalogCategoryData.Builder toDataBuilder() {
        ProdCatalogCategoryData.Builder builder = ProdCatalogCategoryData.newBuilder();
        if (prodCatalogId != null) {
            builder.setProdCatalogId(prodCatalogId);
        }
        if (productCategoryId != null) {
            builder.setProductCategoryId(productCategoryId);
        }
        if (prodCatalogCategoryTypeId != null) {
            builder.setProdCatalogCategoryTypeId(prodCatalogCategoryTypeId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (sequenceNum != null) {
            builder.setSequenceNum(sequenceNum);
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

    public static ProdCatalogCategory fromData(ProdCatalogCategoryData data) {
        return ProdCatalogCategory.builder()
                .prodCatalogId(data.getProdCatalogId())
                .productCategoryId(data.getProductCategoryId())
                .prodCatalogCategoryTypeId(data.getProdCatalogCategoryTypeId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .sequenceNum(data.getSequenceNum())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}

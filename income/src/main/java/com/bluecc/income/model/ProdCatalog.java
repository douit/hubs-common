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
import com.bluecc.hubs.stub.ProdCatalogFlatData;

import com.bluecc.hubs.stub.ProdCatalogData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdCatalog implements IEventModel<ProdCatalogFlatData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String prodCatalogId;
    String catalogName;
    Character useQuickAdd;
    String styleSheet;
    String headerLogo;
    String contentPathPrefix;
    String templatePathPrefix;
    Character viewAllowPermReqd;
    Character purchaseAllowPermReqd;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProdCatalogFlatData.Builder toDataBuilder() {
        ProdCatalogFlatData.Builder builder = ProdCatalogFlatData.newBuilder();
        if (prodCatalogId != null) {
            builder.setProdCatalogId(prodCatalogId);
        }
        if (catalogName != null) {
            builder.setCatalogName(catalogName);
        }
        if (useQuickAdd != null) {
            builder.setUseQuickAdd(getIndicator(useQuickAdd));
        }
        if (styleSheet != null) {
            builder.setStyleSheet(styleSheet);
        }
        if (headerLogo != null) {
            builder.setHeaderLogo(headerLogo);
        }
        if (contentPathPrefix != null) {
            builder.setContentPathPrefix(contentPathPrefix);
        }
        if (templatePathPrefix != null) {
            builder.setTemplatePathPrefix(templatePathPrefix);
        }
        if (viewAllowPermReqd != null) {
            builder.setViewAllowPermReqd(getIndicator(viewAllowPermReqd));
        }
        if (purchaseAllowPermReqd != null) {
            builder.setPurchaseAllowPermReqd(getIndicator(purchaseAllowPermReqd));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static ProdCatalog fromData(ProdCatalogFlatData data) {
        return ProdCatalog.builder()
                .prodCatalogId(data.getProdCatalogId())
                .catalogName(data.getCatalogName())
                .useQuickAdd(getIndicatorChar(data.getUseQuickAdd()))
                .styleSheet(data.getStyleSheet())
                .headerLogo(data.getHeaderLogo())
                .contentPathPrefix(data.getContentPathPrefix())
                .templatePathPrefix(data.getTemplatePathPrefix())
                .viewAllowPermReqd(getIndicatorChar(data.getViewAllowPermReqd()))
                .purchaseAllowPermReqd(getIndicatorChar(data.getPurchaseAllowPermReqd()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

        
    public ProdCatalogData.Builder toHeadBuilder() {
        ProdCatalogData.Builder builder = ProdCatalogData.newBuilder();
        if (prodCatalogId != null) {
            builder.setProdCatalogId(prodCatalogId);
        }
        if (catalogName != null) {
            builder.setCatalogName(catalogName);
        }
        if (useQuickAdd != null) {
            builder.setUseQuickAdd(getIndicator(useQuickAdd));
        }
        if (styleSheet != null) {
            builder.setStyleSheet(styleSheet);
        }
        if (headerLogo != null) {
            builder.setHeaderLogo(headerLogo);
        }
        if (contentPathPrefix != null) {
            builder.setContentPathPrefix(contentPathPrefix);
        }
        if (templatePathPrefix != null) {
            builder.setTemplatePathPrefix(templatePathPrefix);
        }
        if (viewAllowPermReqd != null) {
            builder.setViewAllowPermReqd(getIndicator(viewAllowPermReqd));
        }
        if (purchaseAllowPermReqd != null) {
            builder.setPurchaseAllowPermReqd(getIndicator(purchaseAllowPermReqd));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

}

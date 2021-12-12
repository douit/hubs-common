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

import com.bluecc.hubs.stub.ProductStoreCatalogFlatData;

import com.bluecc.hubs.stub.ProductStoreCatalogData;
import com.bluecc.income.dao.ProductStoreCatalogDelegator;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductStoreCatalogData.class,
        symbol = EntityNames.ProductStoreCatalog)
public class ProductStoreCatalog implements IEventModel<ProductStoreCatalogFlatData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String productStoreId;
    @RIndex String prodCatalogId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    Long sequenceNum;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductStoreCatalogFlatData.Builder toDataBuilder() {
        ProductStoreCatalogFlatData.Builder builder = ProductStoreCatalogFlatData.newBuilder();
        if (productStoreId != null) {
            builder.setProductStoreId(productStoreId);
        }
        if (prodCatalogId != null) {
            builder.setProdCatalogId(prodCatalogId);
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

    public static ProductStoreCatalog fromData(ProductStoreCatalogFlatData data) {
        return ProductStoreCatalog.builder()
                .productStoreId(data.getProductStoreId())
                .prodCatalogId(data.getProdCatalogId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .sequenceNum(data.getSequenceNum())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

        // relations
     
    List<ProductStore> relProductStore= new ArrayList<>(); 
    List<ProdCatalog> relProdCatalog= new ArrayList<>();

    public ProductStoreCatalogDelegator.Agent agent(IProc.ProcContext ctx,
                                             ProductStoreCatalogDelegator delegator){
        return delegator.getAgent(ctx, this.getId());
    }

    public ProductStoreCatalogData.Builder toHeadBuilder() {
        ProductStoreCatalogData.Builder builder = ProductStoreCatalogData.newBuilder();
        if (productStoreId != null) {
            builder.setProductStoreId(productStoreId);
        }
        if (prodCatalogId != null) {
            builder.setProdCatalogId(prodCatalogId);
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

}

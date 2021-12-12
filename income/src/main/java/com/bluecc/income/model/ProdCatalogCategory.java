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
import com.bluecc.hubs.fund.pubs.Exclude;

import com.bluecc.hubs.stub.ProdCatalogCategoryFlatData;

import com.bluecc.hubs.stub.ProdCatalogCategoryData;
import com.bluecc.income.dao.ProdCatalogCategoryDelegator;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProdCatalogCategoryData.class,
        symbol = EntityNames.ProdCatalogCategory)
public class ProdCatalogCategory implements IEventModel<ProdCatalogCategoryFlatData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String prodCatalogId;
    @RIndex String productCategoryId;
    @RIndex String prodCatalogCategoryTypeId;
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

    public ProdCatalogCategoryFlatData.Builder toDataBuilder() {
        ProdCatalogCategoryFlatData.Builder builder = ProdCatalogCategoryFlatData.newBuilder();
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

    public static ProdCatalogCategory fromData(ProdCatalogCategoryFlatData data) {
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

        // relations
     
    @Exclude
    List<ProdCatalog> relProdCatalog= new ArrayList<>(); 
    @Exclude
    List<ProductCategory> relProductCategory= new ArrayList<>();

    public ProdCatalogCategoryDelegator.Agent agent(IProc.ProcContext ctx,
                                             ProdCatalogCategoryDelegator delegator){
        return delegator.getAgent(ctx, this.getId());
    }

    public ProdCatalogCategoryData.Builder toHeadBuilder() {
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

}

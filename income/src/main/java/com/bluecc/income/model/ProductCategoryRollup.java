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

import com.bluecc.hubs.stub.ProductCategoryRollupFlatData;

import com.bluecc.hubs.stub.ProductCategoryRollupData;
import com.bluecc.income.dao.ProductCategoryRollupDelegator;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductCategoryRollupData.class,
        symbol = EntityNames.ProductCategoryRollup)
public class ProductCategoryRollup implements IEventModel<ProductCategoryRollupFlatData.Builder>, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @RIndex String productCategoryId;
    @RIndex String parentProductCategoryId;
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

    public ProductCategoryRollupFlatData.Builder toDataBuilder() {
        ProductCategoryRollupFlatData.Builder builder = ProductCategoryRollupFlatData.newBuilder();
        if (productCategoryId != null) {
            builder.setProductCategoryId(productCategoryId);
        }
        if (parentProductCategoryId != null) {
            builder.setParentProductCategoryId(parentProductCategoryId);
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

    public static ProductCategoryRollup fromData(ProductCategoryRollupFlatData data) {
        return ProductCategoryRollup.builder()
                .productCategoryId(data.getProductCategoryId())
                .parentProductCategoryId(data.getParentProductCategoryId())
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
    List<ProductCategory> relCurrentProductCategory= new ArrayList<>(); 
    @Exclude
    List<ProductCategory> relParentProductCategory= new ArrayList<>(); 
    @Exclude
    List<ProductCategoryRollup> relChildProductCategoryRollup= new ArrayList<>(); 
    @Exclude
    List<ProductCategoryRollup> relParentProductCategoryRollup= new ArrayList<>(); 
    @Exclude
    List<ProductCategoryRollup> relSiblingProductCategoryRollup= new ArrayList<>();

    public ProductCategoryRollupDelegator.Agent agent(IProc.ProcContext ctx,
                                             ProductCategoryRollupDelegator delegator){
        return delegator.getAgent(ctx, this.getId());
    }

    public ProductCategoryRollupData.Builder toHeadBuilder() {
        ProductCategoryRollupData.Builder builder = ProductCategoryRollupData.newBuilder();
        if (productCategoryId != null) {
            builder.setProductCategoryId(productCategoryId);
        }
        if (parentProductCategoryId != null) {
            builder.setParentProductCategoryId(parentProductCategoryId);
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


/*
-- keys: productCategoryId, parentProductCategoryId, fromDate

-- fields --
    
    String productCategoryId
    String parentProductCategoryId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    Long sequenceNum

-- relations --
    
    - CurrentProductCategory (one, autoRelation: false, keymaps: productCategoryId)
    - ParentProductCategory (one, autoRelation: false, keymaps: parentProductCategoryId -> productCategoryId)
    + ChildProductCategoryRollup (many, autoRelation: false, keymaps: productCategoryId -> parentProductCategoryId)
    + ParentProductCategoryRollup (many, autoRelation: false, keymaps: parentProductCategoryId -> productCategoryId)
    + SiblingProductCategoryRollup (many, autoRelation: false, keymaps: parentProductCategoryId)
*/


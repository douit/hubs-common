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

import com.bluecc.hubs.stub.ProductCategoryRoleData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductCategoryRoleData.class,
        symbol = EntityNames.ProductCategoryRole)
public class ProductCategoryRole implements IEventModel<ProductCategoryRoleData.Builder>, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @RIndex String productCategoryId;
    @RIndex String partyId;
    @RIndex String roleTypeId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    String comments;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductCategoryRoleData.Builder toDataBuilder() {
        ProductCategoryRoleData.Builder builder = ProductCategoryRoleData.newBuilder();
        if (productCategoryId != null) {
            builder.setProductCategoryId(productCategoryId);
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (roleTypeId != null) {
            builder.setRoleTypeId(roleTypeId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (comments != null) {
            builder.setComments(comments);
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

    public static ProductCategoryRole fromData(ProductCategoryRoleData data) {
        return ProductCategoryRole.builder()
                .productCategoryId(data.getProductCategoryId())
                .partyId(data.getPartyId())
                .roleTypeId(data.getRoleTypeId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .comments(data.getComments())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: productCategoryId, partyId, roleTypeId, fromDate

-- fields --
    
    String productCategoryId
    String partyId
    String roleTypeId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    String comments

-- relations --
    
    - Party (one-nofk, autoRelation: false, keymaps: partyId)
    - RoleType (one-nofk, autoRelation: false, keymaps: roleTypeId)
    - PartyRole (one, autoRelation: false, keymaps: partyId, roleTypeId)
    - ProductCategory (one, autoRelation: false, keymaps: productCategoryId)
*/


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

import com.bluecc.hubs.stub.CustRequestItemData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = CustRequestItemData.class,
        symbol = EntityNames.CustRequestItem)
public class CustRequestItem implements IEventModel<CustRequestItemData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("cust_request_id")
	@RIndex 
    String custRequestId;
    @SerializedName("cust_request_item_seq_id")
	@RIndex 
    String custRequestItemSeqId;
    @SerializedName("cust_request_resolution_id") 
    String custRequestResolutionId;
    @SerializedName("status_id") 
    String statusId;
    @SerializedName("priority") 
    Long priority;
    @SerializedName("sequence_num") 
    Long sequenceNum;
    @SerializedName("required_by_date") 
    java.time.LocalDateTime requiredByDate;
    @SerializedName("product_id") 
    String productId;
    @SerializedName("quantity") 
    java.math.BigDecimal quantity;
    @SerializedName("selected_amount") 
    java.math.BigDecimal selectedAmount;
    @SerializedName("maximum_amount") 
    java.math.BigDecimal maximumAmount;
    @SerializedName("reserv_start") 
    java.time.LocalDateTime reservStart;
    @SerializedName("reserv_length") 
    java.math.BigDecimal reservLength;
    @SerializedName("reserv_persons") 
    java.math.BigDecimal reservPersons;
    @SerializedName("config_id") 
    String configId;
    @SerializedName("description") 
    String description;
    @SerializedName("story") 
    String story;
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

    public CustRequestItemData.Builder toDataBuilder() {
        CustRequestItemData.Builder builder = CustRequestItemData.newBuilder();
        if (getCustRequestId() != null) {
            builder.setCustRequestId(getCustRequestId());
        }
        if (getCustRequestItemSeqId() != null) {
            builder.setCustRequestItemSeqId(getCustRequestItemSeqId());
        }
        if (getCustRequestResolutionId() != null) {
            builder.setCustRequestResolutionId(getCustRequestResolutionId());
        }
        if (getStatusId() != null) {
            builder.setStatusId(getStatusId());
        }
        if (getPriority() != null) {
            builder.setPriority(getPriority());
        }
        if (getSequenceNum() != null) {
            builder.setSequenceNum(getSequenceNum());
        }
        if (getRequiredByDate() != null) {
            builder.setRequiredByDate(getTimestamp(getRequiredByDate()));
        }
        if (getProductId() != null) {
            builder.setProductId(getProductId());
        }
        if (getQuantity() != null) {
            builder.setQuantity(getFixedPoint(getQuantity()));
        }
        if (getSelectedAmount() != null) {
            builder.setSelectedAmount(getFixedPoint(getSelectedAmount()));
        }
        if (getMaximumAmount() != null) {
            builder.setMaximumAmount(getCurrency(getMaximumAmount()));
        }
        if (getReservStart() != null) {
            builder.setReservStart(getTimestamp(getReservStart()));
        }
        if (getReservLength() != null) {
            builder.setReservLength(getFixedPoint(getReservLength()));
        }
        if (getReservPersons() != null) {
            builder.setReservPersons(getFixedPoint(getReservPersons()));
        }
        if (getConfigId() != null) {
            builder.setConfigId(getConfigId());
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getStory() != null) {
            builder.setStory(getStory());
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

    public static CustRequestItem fromData(CustRequestItemData data) {
        return fromPrototype(data).build();
    }

    public static CustRequestItem.CustRequestItemBuilder fromPrototype(CustRequestItemData data) {
        return CustRequestItem.builder()
                .custRequestId(data.getCustRequestId())
                .custRequestItemSeqId(data.getCustRequestItemSeqId())
                .custRequestResolutionId(data.getCustRequestResolutionId())
                .statusId(data.getStatusId())
                .priority(data.getPriority())
                .sequenceNum(data.getSequenceNum())
                .requiredByDate(getLocalDateTime(data.getRequiredByDate()))
                .productId(data.getProductId())
                .quantity(getBigDecimal(data.getQuantity()))
                .selectedAmount(getBigDecimal(data.getSelectedAmount()))
                .maximumAmount(getBigDecimal(data.getMaximumAmount()))
                .reservStart(getLocalDateTime(data.getReservStart()))
                .reservLength(getBigDecimal(data.getReservLength()))
                .reservPersons(getBigDecimal(data.getReservPersons()))
                .configId(data.getConfigId())
                .description(data.getDescription())
                .story(data.getStory())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: custRequestId, custRequestItemSeqId

-- fields --
    
    String custRequestId
    String custRequestItemSeqId
    String custRequestResolutionId
    String statusId
    Long priority
    Long sequenceNum
    java.time.LocalDateTime requiredByDate
    String productId
    java.math.BigDecimal quantity
    java.math.BigDecimal selectedAmount
    java.math.BigDecimal maximumAmount
    java.time.LocalDateTime reservStart
    java.math.BigDecimal reservLength
    java.math.BigDecimal reservPersons
    String configId
    String description
    String story

-- relations --
    
    - CustRequest (one, autoRelation: false, keymaps: custRequestId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    - CustRequestResolution (one, autoRelation: false, keymaps: custRequestResolutionId)
    - Product (one, autoRelation: false, keymaps: productId)
    + CustRequestItemNote (many, autoRelation: true, keymaps: custRequestId, custRequestItemSeqId)
    + CustRequestItemWorkEffort (many, autoRelation: true, keymaps: custRequestId, custRequestItemSeqId)
    + CustRequestStatus (many, autoRelation: true, keymaps: custRequestId, custRequestItemSeqId)
    + QuoteItem (many, autoRelation: true, keymaps: custRequestId, custRequestItemSeqId)
    + RequirementCustRequest (many, autoRelation: true, keymaps: custRequestId, custRequestItemSeqId)
*/


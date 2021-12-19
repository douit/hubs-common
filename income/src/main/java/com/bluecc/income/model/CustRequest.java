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

import com.bluecc.hubs.stub.CustRequestData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = CustRequestData.class,
        symbol = EntityNames.CustRequest)
public class CustRequest implements IEventModel<CustRequestData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("cust_request_id")
	@RId 
    String custRequestId;
    @SerializedName("cust_request_type_id") 
    String custRequestTypeId;
    @SerializedName("cust_request_category_id") 
    String custRequestCategoryId;
    @SerializedName("status_id") 
    String statusId;
    @SerializedName("from_party_id") 
    String fromPartyId;
    @SerializedName("priority") 
    Long priority;
    @SerializedName("cust_request_date") 
    java.time.LocalDateTime custRequestDate;
    @SerializedName("response_required_date") 
    java.time.LocalDateTime responseRequiredDate;
    @SerializedName("cust_request_name") 
    String custRequestName;
    @SerializedName("description") 
    String description;
    @SerializedName("maximum_amount_uom_id") 
    String maximumAmountUomId;
    @SerializedName("product_store_id") 
    String productStoreId;
    @SerializedName("sales_channel_enum_id") 
    String salesChannelEnumId;
    @SerializedName("fulfill_contact_mech_id") 
    String fulfillContactMechId;
    @SerializedName("currency_uom_id") 
    String currencyUomId;
    @SerializedName("open_date_time") 
    java.time.LocalDateTime openDateTime;
    @SerializedName("closed_date_time") 
    java.time.LocalDateTime closedDateTime;
    @SerializedName("internal_comment") 
    String internalComment;
    @SerializedName("reason") 
    String reason;
    @SerializedName("created_date") 
    java.time.LocalDateTime createdDate;
    @SerializedName("created_by_user_login_id") 
    String createdByUserLogin;
    @SerializedName("last_modified_date") 
    java.time.LocalDateTime lastModifiedDate;
    @SerializedName("last_modified_by_user_login_id") 
    String lastModifiedByUserLogin;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    @SerializedName("cust_estimated_milli_seconds") 
    Double custEstimatedMilliSeconds;
    @SerializedName("cust_sequence_num") 
    Long custSequenceNum;
    @SerializedName("parent_cust_request_id") 
    String parentCustRequestId;
    @SerializedName("billed") 
    Character billed;
    
    @Override
    public String getId(){
        return custRequestId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public CustRequestData.Builder toDataBuilder() {
        CustRequestData.Builder builder = CustRequestData.newBuilder();
        if (custRequestId != null) {
            builder.setCustRequestId(custRequestId);
        }
        if (custRequestTypeId != null) {
            builder.setCustRequestTypeId(custRequestTypeId);
        }
        if (custRequestCategoryId != null) {
            builder.setCustRequestCategoryId(custRequestCategoryId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (fromPartyId != null) {
            builder.setFromPartyId(fromPartyId);
        }
        if (priority != null) {
            builder.setPriority(priority);
        }
        if (custRequestDate != null) {
            builder.setCustRequestDate(getTimestamp(custRequestDate));
        }
        if (responseRequiredDate != null) {
            builder.setResponseRequiredDate(getTimestamp(responseRequiredDate));
        }
        if (custRequestName != null) {
            builder.setCustRequestName(custRequestName);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (maximumAmountUomId != null) {
            builder.setMaximumAmountUomId(maximumAmountUomId);
        }
        if (productStoreId != null) {
            builder.setProductStoreId(productStoreId);
        }
        if (salesChannelEnumId != null) {
            builder.setSalesChannelEnumId(salesChannelEnumId);
        }
        if (fulfillContactMechId != null) {
            builder.setFulfillContactMechId(fulfillContactMechId);
        }
        if (currencyUomId != null) {
            builder.setCurrencyUomId(currencyUomId);
        }
        if (openDateTime != null) {
            builder.setOpenDateTime(getTimestamp(openDateTime));
        }
        if (closedDateTime != null) {
            builder.setClosedDateTime(getTimestamp(closedDateTime));
        }
        if (internalComment != null) {
            builder.setInternalComment(internalComment);
        }
        if (reason != null) {
            builder.setReason(reason);
        }
        if (createdDate != null) {
            builder.setCreatedDate(getTimestamp(createdDate));
        }
        if (createdByUserLogin != null) {
            builder.setCreatedByUserLogin(createdByUserLogin);
        }
        if (lastModifiedDate != null) {
            builder.setLastModifiedDate(getTimestamp(lastModifiedDate));
        }
        if (lastModifiedByUserLogin != null) {
            builder.setLastModifiedByUserLogin(lastModifiedByUserLogin);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
        if (custEstimatedMilliSeconds != null) {
            builder.setCustEstimatedMilliSeconds(custEstimatedMilliSeconds);
        }
        if (custSequenceNum != null) {
            builder.setCustSequenceNum(custSequenceNum);
        }
        if (parentCustRequestId != null) {
            builder.setParentCustRequestId(parentCustRequestId);
        }
        if (billed != null) {
            builder.setBilled(getIndicator(billed));
        }
                    
        return builder;
    }

    public static CustRequest fromData(CustRequestData data) {
        return CustRequest.builder()
                .custRequestId(data.getCustRequestId())
                .custRequestTypeId(data.getCustRequestTypeId())
                .custRequestCategoryId(data.getCustRequestCategoryId())
                .statusId(data.getStatusId())
                .fromPartyId(data.getFromPartyId())
                .priority(data.getPriority())
                .custRequestDate(getLocalDateTime(data.getCustRequestDate()))
                .responseRequiredDate(getLocalDateTime(data.getResponseRequiredDate()))
                .custRequestName(data.getCustRequestName())
                .description(data.getDescription())
                .maximumAmountUomId(data.getMaximumAmountUomId())
                .productStoreId(data.getProductStoreId())
                .salesChannelEnumId(data.getSalesChannelEnumId())
                .fulfillContactMechId(data.getFulfillContactMechId())
                .currencyUomId(data.getCurrencyUomId())
                .openDateTime(getLocalDateTime(data.getOpenDateTime()))
                .closedDateTime(getLocalDateTime(data.getClosedDateTime()))
                .internalComment(data.getInternalComment())
                .reason(data.getReason())
                .createdDate(getLocalDateTime(data.getCreatedDate()))
                .createdByUserLogin(data.getCreatedByUserLogin())
                .lastModifiedDate(getLocalDateTime(data.getLastModifiedDate()))
                .lastModifiedByUserLogin(data.getLastModifiedByUserLogin())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .custEstimatedMilliSeconds(data.getCustEstimatedMilliSeconds())
                .custSequenceNum(data.getCustSequenceNum())
                .parentCustRequestId(data.getParentCustRequestId())
                .billed(getIndicatorChar(data.getBilled()))
                
                .build();
    }

    
}


/*
-- keys: custRequestId

-- fields --
    
    String custRequestId
    String custRequestTypeId
    String custRequestCategoryId
    String statusId
    String fromPartyId
    Long priority
    java.time.LocalDateTime custRequestDate
    java.time.LocalDateTime responseRequiredDate
    String custRequestName
    String description
    String maximumAmountUomId
    String productStoreId
    String salesChannelEnumId
    String fulfillContactMechId
    String currencyUomId
    java.time.LocalDateTime openDateTime
    java.time.LocalDateTime closedDateTime
    String internalComment
    String reason
    java.time.LocalDateTime createdDate
    String createdByUserLogin
    java.time.LocalDateTime lastModifiedDate
    String lastModifiedByUserLogin
    Double custEstimatedMilliSeconds
    Long custSequenceNum
    String parentCustRequestId
    Character billed

-- relations --
    
    - CustRequestType (one, autoRelation: false, keymaps: custRequestTypeId)
    - CustRequestCategory (one, autoRelation: false, keymaps: custRequestCategoryId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    - FromParty (one, autoRelation: false, keymaps: fromPartyId -> partyId)
    - MaximumAmountUom (one, autoRelation: false, keymaps: maximumAmountUomId -> uomId)
    - ProductStore (one, autoRelation: false, keymaps: productStoreId)
    - SalesChannelEnumeration (one, autoRelation: false, keymaps: salesChannelEnumId -> enumId)
    + CustRequestTypeAttr (many, autoRelation: false, keymaps: custRequestTypeId)
    - FulfillContactMech (one, autoRelation: false, keymaps: fulfillContactMechId -> contactMechId)
    - CurrencyUom (one, autoRelation: false, keymaps: currencyUomId -> uomId)
    - ParentCustRequest (one, autoRelation: false, keymaps: parentCustRequestId -> custRequestId)
    + ChildCustRequest (many, autoRelation: true, keymaps: custRequestId -> parentCustRequestId)
    + CustRequestAttribute (many, autoRelation: true, keymaps: custRequestId)
    + CustRequestCommEvent (many, autoRelation: true, keymaps: custRequestId)
    + CustRequestContent (many, autoRelation: true, keymaps: custRequestId)
    + CustRequestItem (many, autoRelation: true, keymaps: custRequestId)
    + CustRequestItemWorkEffort (many, autoRelation: true, keymaps: custRequestId)
    + CustRequestNote (many, autoRelation: true, keymaps: custRequestId)
    + CustRequestParty (many, autoRelation: true, keymaps: custRequestId)
    + CustRequestStatus (many, autoRelation: true, keymaps: custRequestId)
    + CustRequestWorkEffort (many, autoRelation: true, keymaps: custRequestId)
    + QuoteItem (many, autoRelation: true, keymaps: custRequestId)
    + RequirementCustRequest (many, autoRelation: true, keymaps: custRequestId)
    + RespondingParty (many, autoRelation: true, keymaps: custRequestId)
*/


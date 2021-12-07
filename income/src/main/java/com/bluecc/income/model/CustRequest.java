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
import org.redisson.api.annotation.*;

import com.bluecc.hubs.stub.CustRequestData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class CustRequest implements IEventModel<CustRequestData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String custRequestId;
    String custRequestTypeId;
    String custRequestCategoryId;
    String statusId;
    String fromPartyId;
    Long priority;
    java.time.LocalDateTime custRequestDate;
    java.time.LocalDateTime responseRequiredDate;
    String custRequestName;
    String description;
    String maximumAmountUomId;
    String productStoreId;
    String salesChannelEnumId;
    String fulfillContactMechId;
    String currencyUomId;
    java.time.LocalDateTime openDateTime;
    java.time.LocalDateTime closedDateTime;
    String internalComment;
    String reason;
    java.time.LocalDateTime createdDate;
    String createdByUserLogin;
    java.time.LocalDateTime lastModifiedDate;
    String lastModifiedByUserLogin;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    Double custEstimatedMilliSeconds;
    Long custSequenceNum;
    String parentCustRequestId;
    Character billed;
    

        
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

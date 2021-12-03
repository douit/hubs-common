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
import com.bluecc.hubs.stub.CustRequestItemData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustRequestItem implements IEventModel<CustRequestItemData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String custRequestId;
    String custRequestItemSeqId;
    String custRequestResolutionId;
    String statusId;
    Long priority;
    Long sequenceNum;
    java.time.LocalDateTime requiredByDate;
    String productId;
    java.math.BigDecimal quantity;
    java.math.BigDecimal selectedAmount;
    java.math.BigDecimal maximumAmount;
    java.time.LocalDateTime reservStart;
    java.math.BigDecimal reservLength;
    java.math.BigDecimal reservPersons;
    String configId;
    String description;
    String story;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public CustRequestItemData.Builder toDataBuilder() {
        CustRequestItemData.Builder builder = CustRequestItemData.newBuilder();
        if (custRequestId != null) {
            builder.setCustRequestId(custRequestId);
        }
        if (custRequestItemSeqId != null) {
            builder.setCustRequestItemSeqId(custRequestItemSeqId);
        }
        if (custRequestResolutionId != null) {
            builder.setCustRequestResolutionId(custRequestResolutionId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (priority != null) {
            builder.setPriority(priority);
        }
        if (sequenceNum != null) {
            builder.setSequenceNum(sequenceNum);
        }
        if (requiredByDate != null) {
            builder.setRequiredByDate(getTimestamp(requiredByDate));
        }
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (quantity != null) {
            builder.setQuantity(getFixedPoint(quantity));
        }
        if (selectedAmount != null) {
            builder.setSelectedAmount(getFixedPoint(selectedAmount));
        }
        if (maximumAmount != null) {
            builder.setMaximumAmount(getCurrency(maximumAmount));
        }
        if (reservStart != null) {
            builder.setReservStart(getTimestamp(reservStart));
        }
        if (reservLength != null) {
            builder.setReservLength(getFixedPoint(reservLength));
        }
        if (reservPersons != null) {
            builder.setReservPersons(getFixedPoint(reservPersons));
        }
        if (configId != null) {
            builder.setConfigId(configId);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (story != null) {
            builder.setStory(story);
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

    public static CustRequestItem fromData(CustRequestItemData data) {
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
                
                .build();
    }

    
}

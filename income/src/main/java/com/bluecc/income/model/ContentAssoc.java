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

import com.bluecc.hubs.stub.ContentAssocData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class ContentAssoc implements IEventModel<ContentAssocData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String contentId;
    @RIndex String contentIdTo;
    @RIndex String contentAssocTypeId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    String contentAssocPredicateId;
    String dataSourceId;
    Long sequenceNum;
    String mapKey;
    Long upperCoordinate;
    Long leftCoordinate;
    java.time.LocalDateTime createdDate;
    String createdByUserLogin;
    java.time.LocalDateTime lastModifiedDate;
    String lastModifiedByUserLogin;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ContentAssocData.Builder toDataBuilder() {
        ContentAssocData.Builder builder = ContentAssocData.newBuilder();
        if (contentId != null) {
            builder.setContentId(contentId);
        }
        if (contentIdTo != null) {
            builder.setContentIdTo(contentIdTo);
        }
        if (contentAssocTypeId != null) {
            builder.setContentAssocTypeId(contentAssocTypeId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (contentAssocPredicateId != null) {
            builder.setContentAssocPredicateId(contentAssocPredicateId);
        }
        if (dataSourceId != null) {
            builder.setDataSourceId(dataSourceId);
        }
        if (sequenceNum != null) {
            builder.setSequenceNum(sequenceNum);
        }
        if (mapKey != null) {
            builder.setMapKey(mapKey);
        }
        if (upperCoordinate != null) {
            builder.setUpperCoordinate(upperCoordinate);
        }
        if (leftCoordinate != null) {
            builder.setLeftCoordinate(leftCoordinate);
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
        if (id != null) {
            builder.setId(id);
        }
                    
        return builder;
    }

    public static ContentAssoc fromData(ContentAssocData data) {
        return ContentAssoc.builder()
                .contentId(data.getContentId())
                .contentIdTo(data.getContentIdTo())
                .contentAssocTypeId(data.getContentAssocTypeId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .contentAssocPredicateId(data.getContentAssocPredicateId())
                .dataSourceId(data.getDataSourceId())
                .sequenceNum(data.getSequenceNum())
                .mapKey(data.getMapKey())
                .upperCoordinate(data.getUpperCoordinate())
                .leftCoordinate(data.getLeftCoordinate())
                .createdDate(getLocalDateTime(data.getCreatedDate()))
                .createdByUserLogin(data.getCreatedByUserLogin())
                .lastModifiedDate(getLocalDateTime(data.getLastModifiedDate()))
                .lastModifiedByUserLogin(data.getLastModifiedByUserLogin())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}

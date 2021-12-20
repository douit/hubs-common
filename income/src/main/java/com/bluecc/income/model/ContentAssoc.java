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

import com.bluecc.hubs.stub.ContentAssocData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ContentAssocData.class,
        symbol = EntityNames.ContentAssoc)
public class ContentAssoc implements IEventModel<ContentAssocData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("content_id")
	@RIndex 
    String contentId;
    @SerializedName("content_id_to")
	@RIndex 
    String contentIdTo;
    @SerializedName("content_assoc_type_id")
	@RIndex 
    String contentAssocTypeId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("content_assoc_predicate_id") 
    String contentAssocPredicateId;
    @SerializedName("data_source_id") 
    String dataSourceId;
    @SerializedName("sequence_num") 
    Long sequenceNum;
    @SerializedName("map_key") 
    String mapKey;
    @SerializedName("upper_coordinate") 
    Long upperCoordinate;
    @SerializedName("left_coordinate") 
    Long leftCoordinate;
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
    @SerializedName("id")
	@RId 
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ContentAssocData.Builder toDataBuilder() {
        ContentAssocData.Builder builder = ContentAssocData.newBuilder();
        if (getContentId() != null) {
            builder.setContentId(getContentId());
        }
        if (getContentIdTo() != null) {
            builder.setContentIdTo(getContentIdTo());
        }
        if (getContentAssocTypeId() != null) {
            builder.setContentAssocTypeId(getContentAssocTypeId());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
        }
        if (getContentAssocPredicateId() != null) {
            builder.setContentAssocPredicateId(getContentAssocPredicateId());
        }
        if (getDataSourceId() != null) {
            builder.setDataSourceId(getDataSourceId());
        }
        if (getSequenceNum() != null) {
            builder.setSequenceNum(getSequenceNum());
        }
        if (getMapKey() != null) {
            builder.setMapKey(getMapKey());
        }
        if (getUpperCoordinate() != null) {
            builder.setUpperCoordinate(getUpperCoordinate());
        }
        if (getLeftCoordinate() != null) {
            builder.setLeftCoordinate(getLeftCoordinate());
        }
        if (getCreatedDate() != null) {
            builder.setCreatedDate(getTimestamp(getCreatedDate()));
        }
        if (getCreatedByUserLogin() != null) {
            builder.setCreatedByUserLogin(getCreatedByUserLogin());
        }
        if (getLastModifiedDate() != null) {
            builder.setLastModifiedDate(getTimestamp(getLastModifiedDate()));
        }
        if (getLastModifiedByUserLogin() != null) {
            builder.setLastModifiedByUserLogin(getLastModifiedByUserLogin());
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

    public static ContentAssoc fromData(ContentAssocData data) {
        return fromPrototype(data).build();
    }

    public static ContentAssoc.ContentAssocBuilder fromPrototype(ContentAssocData data) {
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
                ;
    }

    
}


/*
-- keys: contentId, contentIdTo, contentAssocTypeId, fromDate

-- fields --
    
    String contentId
    String contentIdTo
    String contentAssocTypeId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    String contentAssocPredicateId
    String dataSourceId
    Long sequenceNum
    String mapKey
    Long upperCoordinate
    Long leftCoordinate
    java.time.LocalDateTime createdDate
    String createdByUserLogin
    java.time.LocalDateTime lastModifiedDate
    String lastModifiedByUserLogin

-- relations --
    
    - FromContent (one, autoRelation: false, keymaps: contentId)
    - ToContent (one, autoRelation: false, keymaps: contentIdTo -> contentId)
    - ContentAssocType (one, autoRelation: false, keymaps: contentAssocTypeId)
    - CreatedByUserLogin (one, autoRelation: false, keymaps: createdByUserLogin -> userLoginId)
    - LastModifiedByUserLogin (one, autoRelation: false, keymaps: lastModifiedByUserLogin -> userLoginId)
    - ContentAssocPredicate (one, autoRelation: false, keymaps: contentAssocPredicateId)
    - DataSource (one, autoRelation: false, keymaps: dataSourceId)
*/


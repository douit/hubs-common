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

import com.bluecc.hubs.stub.TelecomNumberData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = TelecomNumberData.class,
        symbol = EntityNames.TelecomNumber)
public class TelecomNumber implements IEventModel<TelecomNumberData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("contact_mech_id")
	@RId 
    String contactMechId;
    @SerializedName("country_code") 
    String countryCode;
    @SerializedName("area_code") 
    String areaCode;
    @SerializedName("contact_number") 
    String contactNumber;
    @SerializedName("ask_for_name") 
    String askForName;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    
    @Override
    public String getId(){
        return contactMechId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public TelecomNumberData.Builder toDataBuilder() {
        TelecomNumberData.Builder builder = TelecomNumberData.newBuilder();
        if (getContactMechId() != null) {
            builder.setContactMechId(getContactMechId());
        }
        if (getCountryCode() != null) {
            builder.setCountryCode(getCountryCode());
        }
        if (getAreaCode() != null) {
            builder.setAreaCode(getAreaCode());
        }
        if (getContactNumber() != null) {
            builder.setContactNumber(getContactNumber());
        }
        if (getAskForName() != null) {
            builder.setAskForName(getAskForName());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static TelecomNumber fromData(TelecomNumberData data) {
        return fromPrototype(data).build();
    }

    public static TelecomNumber.TelecomNumberBuilder fromPrototype(TelecomNumberData data) {
        return TelecomNumber.builder()
                .contactMechId(data.getContactMechId())
                .countryCode(data.getCountryCode())
                .areaCode(data.getAreaCode())
                .contactNumber(data.getContactNumber())
                .askForName(data.getAskForName())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
    }

    
}


/*
-- keys: contactMechId

-- fields --
    
    String contactMechId
    String countryCode
    String areaCode
    String contactNumber
    String askForName

-- relations --
    
    - ContactMech (one, autoRelation: false, keymaps: contactMechId)
    + FacilityContactMech (many, autoRelation: true, keymaps: contactMechId)
    + TelecomOrderItemShipGroup (many, autoRelation: true, keymaps: contactMechId -> telecomContactMechId)
    + PartyContactMech (many, autoRelation: true, keymaps: contactMechId)
    + PartyContactMechPurpose (many, autoRelation: true, keymaps: contactMechId)
    + OriginShipment (many, autoRelation: true, keymaps: contactMechId -> originTelecomNumberId)
    + DestinationShipment (many, autoRelation: true, keymaps: contactMechId -> destinationTelecomNumberId)
    + OriginShipmentRouteSegment (many, autoRelation: true, keymaps: contactMechId -> originTelecomNumberId)
    + DestShipmentRouteSegment (many, autoRelation: true, keymaps: contactMechId -> destTelecomNumberId)
    + WorkEffortContactMech (many, autoRelation: true, keymaps: contactMechId)
*/


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

import com.bluecc.hubs.stub.EbayConfigData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = EbayConfigData.class,
        symbol = EntityNames.EbayConfig)
public class EbayConfig implements IEventModel<EbayConfigData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_store_id")
	@RId 
    String productStoreId;
    @SerializedName("dev_id") 
    String devId;
    @SerializedName("app_id") 
    String appId;
    @SerializedName("cert_id") 
    String certId;
    @SerializedName("token") 
    String token;
    @SerializedName("compatibility_level") 
    String compatibilityLevel;
    @SerializedName("site_id") 
    String siteId;
    @SerializedName("xml_gateway_uri") 
    String xmlGatewayUri;
    @SerializedName("custom_xml") 
    String customXml;
    @SerializedName("web_site_id") 
    String webSiteId;
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
        return productStoreId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public EbayConfigData.Builder toDataBuilder() {
        EbayConfigData.Builder builder = EbayConfigData.newBuilder();
        if (getProductStoreId() != null) {
            builder.setProductStoreId(getProductStoreId());
        }
        if (getDevId() != null) {
            builder.setDevId(getDevId());
        }
        if (getAppId() != null) {
            builder.setAppId(getAppId());
        }
        if (getCertId() != null) {
            builder.setCertId(getCertId());
        }
        if (getToken() != null) {
            builder.setToken(getToken());
        }
        if (getCompatibilityLevel() != null) {
            builder.setCompatibilityLevel(getCompatibilityLevel());
        }
        if (getSiteId() != null) {
            builder.setSiteId(getSiteId());
        }
        if (getXmlGatewayUri() != null) {
            builder.setXmlGatewayUri(getXmlGatewayUri());
        }
        if (getCustomXml() != null) {
            builder.setCustomXml(getCustomXml());
        }
        if (getWebSiteId() != null) {
            builder.setWebSiteId(getWebSiteId());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static EbayConfig fromData(EbayConfigData data) {
        return fromPrototype(data).build();
    }

    public static EbayConfig.EbayConfigBuilder fromPrototype(EbayConfigData data) {
        return EbayConfig.builder()
                .productStoreId(data.getProductStoreId())
                .devId(data.getDevId())
                .appId(data.getAppId())
                .certId(data.getCertId())
                .token(data.getToken())
                .compatibilityLevel(data.getCompatibilityLevel())
                .siteId(data.getSiteId())
                .xmlGatewayUri(data.getXmlGatewayUri())
                .customXml(data.getCustomXml())
                .webSiteId(data.getWebSiteId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
    }

    
}


/*
-- keys: productStoreId

-- fields --
    
    String productStoreId
    String devId
    String appId
    String certId
    String token
    String compatibilityLevel
    String siteId
    String xmlGatewayUri
    String customXml
    String webSiteId

-- relations --
    
    - ProductStore (one, autoRelation: false, keymaps: productStoreId)
    - WebSite (one, autoRelation: false, keymaps: webSiteId)
*/


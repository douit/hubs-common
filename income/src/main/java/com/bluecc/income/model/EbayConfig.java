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
public class EbayConfig implements IEventModel<EbayConfigData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String productStoreId;
    String devId;
    String appId;
    String certId;
    String token;
    String compatibilityLevel;
    String siteId;
    String xmlGatewayUri;
    String customXml;
    String webSiteId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public EbayConfigData.Builder toDataBuilder() {
        EbayConfigData.Builder builder = EbayConfigData.newBuilder();
        if (productStoreId != null) {
            builder.setProductStoreId(productStoreId);
        }
        if (devId != null) {
            builder.setDevId(devId);
        }
        if (appId != null) {
            builder.setAppId(appId);
        }
        if (certId != null) {
            builder.setCertId(certId);
        }
        if (token != null) {
            builder.setToken(token);
        }
        if (compatibilityLevel != null) {
            builder.setCompatibilityLevel(compatibilityLevel);
        }
        if (siteId != null) {
            builder.setSiteId(siteId);
        }
        if (xmlGatewayUri != null) {
            builder.setXmlGatewayUri(xmlGatewayUri);
        }
        if (customXml != null) {
            builder.setCustomXml(customXml);
        }
        if (webSiteId != null) {
            builder.setWebSiteId(webSiteId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static EbayConfig fromData(EbayConfigData data) {
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
                
                .build();
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


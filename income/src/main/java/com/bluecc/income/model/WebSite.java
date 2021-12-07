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

import com.bluecc.hubs.stub.WebSiteData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class WebSite implements IEventModel<WebSiteData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String webSiteId;
    String siteName;
    String httpHost;
    String httpPort;
    String httpsHost;
    String httpsPort;
    Character enableHttps;
    String webappPath;
    String standardContentPrefix;
    String secureContentPrefix;
    String cookieDomain;
    String visualThemeSetId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String productStoreId;
    Character allowProductStoreChange;
    String hostedPathAlias;
    Character isDefault;
    Character displayMaintenancePage;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public WebSiteData.Builder toDataBuilder() {
        WebSiteData.Builder builder = WebSiteData.newBuilder();
        if (webSiteId != null) {
            builder.setWebSiteId(webSiteId);
        }
        if (siteName != null) {
            builder.setSiteName(siteName);
        }
        if (httpHost != null) {
            builder.setHttpHost(httpHost);
        }
        if (httpPort != null) {
            builder.setHttpPort(httpPort);
        }
        if (httpsHost != null) {
            builder.setHttpsHost(httpsHost);
        }
        if (httpsPort != null) {
            builder.setHttpsPort(httpsPort);
        }
        if (enableHttps != null) {
            builder.setEnableHttps(getIndicator(enableHttps));
        }
        if (webappPath != null) {
            builder.setWebappPath(webappPath);
        }
        if (standardContentPrefix != null) {
            builder.setStandardContentPrefix(standardContentPrefix);
        }
        if (secureContentPrefix != null) {
            builder.setSecureContentPrefix(secureContentPrefix);
        }
        if (cookieDomain != null) {
            builder.setCookieDomain(cookieDomain);
        }
        if (visualThemeSetId != null) {
            builder.setVisualThemeSetId(visualThemeSetId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
        if (productStoreId != null) {
            builder.setProductStoreId(productStoreId);
        }
        if (allowProductStoreChange != null) {
            builder.setAllowProductStoreChange(getIndicator(allowProductStoreChange));
        }
        if (hostedPathAlias != null) {
            builder.setHostedPathAlias(hostedPathAlias);
        }
        if (isDefault != null) {
            builder.setIsDefault(getIndicator(isDefault));
        }
        if (displayMaintenancePage != null) {
            builder.setDisplayMaintenancePage(getIndicator(displayMaintenancePage));
        }
                    
        return builder;
    }

    public static WebSite fromData(WebSiteData data) {
        return WebSite.builder()
                .webSiteId(data.getWebSiteId())
                .siteName(data.getSiteName())
                .httpHost(data.getHttpHost())
                .httpPort(data.getHttpPort())
                .httpsHost(data.getHttpsHost())
                .httpsPort(data.getHttpsPort())
                .enableHttps(getIndicatorChar(data.getEnableHttps()))
                .webappPath(data.getWebappPath())
                .standardContentPrefix(data.getStandardContentPrefix())
                .secureContentPrefix(data.getSecureContentPrefix())
                .cookieDomain(data.getCookieDomain())
                .visualThemeSetId(data.getVisualThemeSetId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .productStoreId(data.getProductStoreId())
                .allowProductStoreChange(getIndicatorChar(data.getAllowProductStoreChange()))
                .hostedPathAlias(data.getHostedPathAlias())
                .isDefault(getIndicatorChar(data.getIsDefault()))
                .displayMaintenancePage(getIndicatorChar(data.getDisplayMaintenancePage()))
                
                .build();
    }

    
}

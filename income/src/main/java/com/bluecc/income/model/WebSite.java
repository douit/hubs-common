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

import com.bluecc.hubs.stub.WebSiteFlatData;

import com.bluecc.hubs.stub.WebSiteData;
import com.bluecc.income.dao.WebSiteDelegator;
import static com.bluecc.income.dao.WebSiteDelegator.*;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = WebSiteData.class,
        symbol = EntityNames.WebSite)
public class WebSite implements IEventModel<WebSiteFlatData.Builder>, HasId, Serializable, WithSuppliers {
    private static final long serialVersionUID = 1L;

    @SerializedName("web_site_id")
	@RId 
    String webSiteId;
    @SerializedName("site_name") 
    String siteName;
    @SerializedName("http_host") 
    String httpHost;
    @SerializedName("http_port") 
    String httpPort;
    @SerializedName("https_host") 
    String httpsHost;
    @SerializedName("https_port") 
    String httpsPort;
    @SerializedName("enable_https") 
    Character enableHttps;
    @SerializedName("webapp_path") 
    String webappPath;
    @SerializedName("standard_content_prefix") 
    String standardContentPrefix;
    @SerializedName("secure_content_prefix") 
    String secureContentPrefix;
    @SerializedName("cookie_domain") 
    String cookieDomain;
    @SerializedName("visual_theme_set_id") 
    String visualThemeSetId;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    @SerializedName("product_store_id") 
    String productStoreId;
    @SerializedName("allow_product_store_change") 
    Character allowProductStoreChange;
    @SerializedName("hosted_path_alias") 
    String hostedPathAlias;
    @SerializedName("is_default") 
    Character isDefault;
    @SerializedName("display_maintenance_page") 
    Character displayMaintenancePage;
    @SerializedName("tenant_id") 
    String tenantId;
    
    @Override
    public String getId(){
        return webSiteId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public WebSiteFlatData.Builder toDataBuilder() {
        WebSiteFlatData.Builder builder = WebSiteFlatData.newBuilder();
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
        if (tenantId != null) {
            builder.setTenantId(tenantId);
        }
                    
        return builder;
    }

    public static WebSite fromData(WebSiteFlatData data) {
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
                .tenantId(data.getTenantId())
                
                .build();
    }

        // relations
     
    @Exclude
    @Singular("addProductStore")
    @SerializedName("product_store") 
    List<ProductStore> relProductStore= new ArrayList<>(); 
    @Exclude
    @Singular("addEbayConfig")
    @SerializedName("ebay_config") 
    List<EbayConfig> relEbayConfig= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderHeader")
    @SerializedName("order_header") 
    List<OrderHeader> relOrderHeader= new ArrayList<>(); 
    @Exclude
    @Singular("addSubscriptionResource")
    @SerializedName("subscription_resource") 
    List<SubscriptionResource> relSubscriptionResource= new ArrayList<>(); 
    @Exclude
    @Singular("addWebAnalyticsConfig")
    @SerializedName("web_analytics_config") 
    List<WebAnalyticsConfig> relWebAnalyticsConfig= new ArrayList<>(); 
    @Exclude
    @Singular("addWebSiteContent")
    @SerializedName("web_site_content") 
    List<WebSiteContent> relWebSiteContent= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    @SerializedName("tenant") 
    List<Tenant> relTenant= new ArrayList<>();

    public Map<String, Supplier<List<?>>> suppliers(){
        Map<String, Supplier<List<?>>> supplierMap=Maps.newHashMap();
         
        supplierMap.put(PRODUCT_STORE, getter(this, WebSite::getRelProductStore)); 
        supplierMap.put(EBAY_CONFIG, getter(this, WebSite::getRelEbayConfig)); 
        supplierMap.put(ORDER_HEADER, getter(this, WebSite::getRelOrderHeader)); 
        supplierMap.put(SUBSCRIPTION_RESOURCE, getter(this, WebSite::getRelSubscriptionResource)); 
        supplierMap.put(WEB_ANALYTICS_CONFIG, getter(this, WebSite::getRelWebAnalyticsConfig)); 
        supplierMap.put(WEB_SITE_CONTENT, getter(this, WebSite::getRelWebSiteContent)); 
        supplierMap.put(TENANT, getter(this, WebSite::getRelTenant));

        return supplierMap;
    };

    public WebSiteDelegator.Agent agent(IProc.ProcContext ctx,
                                             WebSiteDelegator delegator){
        return delegator.getAgent(ctx, this.getWebSiteId());
    }

    public WebSiteData.Builder toHeadBuilder() {
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

}


/*
-- keys: webSiteId

-- fields --
    
    String webSiteId
    String siteName
    String httpHost
    String httpPort
    String httpsHost
    String httpsPort
    Character enableHttps
    String webappPath
    String standardContentPrefix
    String secureContentPrefix
    String cookieDomain
    String visualThemeSetId
    String productStoreId
    Character allowProductStoreChange
    String hostedPathAlias
    Character isDefault
    Character displayMaintenancePage

-- relations --
    
    - VisualThemeSet (one, autoRelation: false, keymaps: visualThemeSetId)
    - ProductStore (one, autoRelation: false, keymaps: productStoreId)
    + EbayConfig (many, autoRelation: true, keymaps: webSiteId)
    + OrderHeader (many, autoRelation: true, keymaps: webSiteId)
    + SubscriptionResource (many, autoRelation: true, keymaps: webSiteId)
    + WebAnalyticsConfig (many, autoRelation: true, keymaps: webSiteId)
    + WebPage (many, autoRelation: true, keymaps: webSiteId)
    + WebSiteContactList (many, autoRelation: true, keymaps: webSiteId)
    + WebSiteContent (many, autoRelation: true, keymaps: webSiteId)
    + WebSitePathAlias (many, autoRelation: true, keymaps: webSiteId)
    + WebSiteRole (many, autoRelation: true, keymaps: webSiteId)
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/


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

import com.bluecc.hubs.stub.UserLoginFlatData;

import com.bluecc.hubs.stub.UserLoginData;
import com.bluecc.income.dao.UserLoginDelegator;
import static com.bluecc.income.dao.UserLoginDelegator.*;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = UserLoginData.class,
        symbol = EntityNames.UserLogin)
public class UserLogin implements IEventModel<UserLoginFlatData.Builder>, HasId, Serializable, WithSuppliers {
    private static final long serialVersionUID = 1L;

    @SerializedName("user_login_id")
	@RId 
    String userLoginId;
    @SerializedName("current_password") 
    String currentPassword;
    @SerializedName("password_hint") 
    String passwordHint;
    @SerializedName("is_system") 
    Character isSystem;
    @SerializedName("enabled") 
    Character enabled;
    @SerializedName("has_logged_out") 
    Character hasLoggedOut;
    @SerializedName("require_password_change") 
    Character requirePasswordChange;
    @SerializedName("last_currency_uom") 
    String lastCurrencyUom;
    @SerializedName("last_locale") 
    String lastLocale;
    @SerializedName("last_time_zone") 
    String lastTimeZone;
    @SerializedName("disabled_date_time") 
    java.time.LocalDateTime disabledDateTime;
    @SerializedName("successive_failed_logins") 
    Long successiveFailedLogins;
    @SerializedName("external_auth_id") 
    String externalAuthId;
    @SerializedName("user_ldap_dn") 
    String userLdapDn;
    @SerializedName("disabled_by") 
    String disabledBy;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    @SerializedName("party_id") 
    String partyId;
    @SerializedName("tenant_id") 
    String tenantId;
    
    @Override
    public String getId(){
        return userLoginId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public UserLoginFlatData.Builder toDataBuilder() {
        UserLoginFlatData.Builder builder = UserLoginFlatData.newBuilder();
        if (userLoginId != null) {
            builder.setUserLoginId(userLoginId);
        }
        if (currentPassword != null) {
            builder.setCurrentPassword(currentPassword);
        }
        if (passwordHint != null) {
            builder.setPasswordHint(passwordHint);
        }
        if (isSystem != null) {
            builder.setIsSystem(getIndicator(isSystem));
        }
        if (enabled != null) {
            builder.setEnabled(getIndicator(enabled));
        }
        if (hasLoggedOut != null) {
            builder.setHasLoggedOut(getIndicator(hasLoggedOut));
        }
        if (requirePasswordChange != null) {
            builder.setRequirePasswordChange(getIndicator(requirePasswordChange));
        }
        if (lastCurrencyUom != null) {
            builder.setLastCurrencyUom(lastCurrencyUom);
        }
        if (lastLocale != null) {
            builder.setLastLocale(lastLocale);
        }
        if (lastTimeZone != null) {
            builder.setLastTimeZone(lastTimeZone);
        }
        if (disabledDateTime != null) {
            builder.setDisabledDateTime(getTimestamp(disabledDateTime));
        }
        if (successiveFailedLogins != null) {
            builder.setSuccessiveFailedLogins(successiveFailedLogins);
        }
        if (externalAuthId != null) {
            builder.setExternalAuthId(externalAuthId);
        }
        if (userLdapDn != null) {
            builder.setUserLdapDn(userLdapDn);
        }
        if (disabledBy != null) {
            builder.setDisabledBy(disabledBy);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (tenantId != null) {
            builder.setTenantId(tenantId);
        }
                    
        return builder;
    }

    public static UserLogin fromData(UserLoginFlatData data) {
        return UserLogin.builder()
                .userLoginId(data.getUserLoginId())
                .currentPassword(data.getCurrentPassword())
                .passwordHint(data.getPasswordHint())
                .isSystem(getIndicatorChar(data.getIsSystem()))
                .enabled(getIndicatorChar(data.getEnabled()))
                .hasLoggedOut(getIndicatorChar(data.getHasLoggedOut()))
                .requirePasswordChange(getIndicatorChar(data.getRequirePasswordChange()))
                .lastCurrencyUom(data.getLastCurrencyUom())
                .lastLocale(data.getLastLocale())
                .lastTimeZone(data.getLastTimeZone())
                .disabledDateTime(getLocalDateTime(data.getDisabledDateTime()))
                .successiveFailedLogins(data.getSuccessiveFailedLogins())
                .externalAuthId(data.getExternalAuthId())
                .userLdapDn(data.getUserLdapDn())
                .disabledBy(data.getDisabledBy())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .partyId(data.getPartyId())
                .tenantId(data.getTenantId())
                
                .build();
    }

        // relations
     
    @Exclude
    @Singular("addParty")
    List<Party> relParty= new ArrayList<>(); 
    @Exclude
    @Singular("addPerson")
    List<Person> relPerson= new ArrayList<>(); 
    @Exclude
    @Singular("addPartyGroup")
    List<PartyGroup> relPartyGroup= new ArrayList<>(); 
    @Exclude
    @Singular("addChangeByBudgetStatus")
    List<BudgetStatus> relChangeByBudgetStatus= new ArrayList<>(); 
    @Exclude
    @Singular("addCreatedByContent")
    List<Content> relCreatedByContent= new ArrayList<>(); 
    @Exclude
    @Singular("addLastModifiedByContent")
    List<Content> relLastModifiedByContent= new ArrayList<>(); 
    @Exclude
    @Singular("addCreatedByContentAssoc")
    List<ContentAssoc> relCreatedByContentAssoc= new ArrayList<>(); 
    @Exclude
    @Singular("addLastModifiedByContentAssoc")
    List<ContentAssoc> relLastModifiedByContentAssoc= new ArrayList<>(); 
    @Exclude
    @Singular("addCreatedByDataResource")
    List<DataResource> relCreatedByDataResource= new ArrayList<>(); 
    @Exclude
    @Singular("addLastModifiedByDataResource")
    List<DataResource> relLastModifiedByDataResource= new ArrayList<>(); 
    @Exclude
    @Singular("addFinAccountStatus")
    List<FinAccountStatus> relFinAccountStatus= new ArrayList<>(); 
    @Exclude
    @Singular("addChangeByInvoiceStatus")
    List<InvoiceStatus> relChangeByInvoiceStatus= new ArrayList<>(); 
    @Exclude
    @Singular("addIssuedByItemIssuance")
    List<ItemIssuance> relIssuedByItemIssuance= new ArrayList<>(); 
    @Exclude
    @Singular("addAuthJobSandbox")
    List<JobSandbox> relAuthJobSandbox= new ArrayList<>(); 
    @Exclude
    @Singular("addRunAsJobSandbox")
    List<JobSandbox> relRunAsJobSandbox= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderAdjustment")
    List<OrderAdjustment> relOrderAdjustment= new ArrayList<>(); 
    @Exclude
    @Singular("addCreatedByOrderHeader")
    List<OrderHeader> relCreatedByOrderHeader= new ArrayList<>(); 
    @Exclude
    @Singular("addDontCancelSetOrderItem")
    List<OrderItem> relDontCancelSetOrderItem= new ArrayList<>(); 
    @Exclude
    @Singular("addChangeByOrderItem")
    List<OrderItem> relChangeByOrderItem= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderPaymentPreference")
    List<OrderPaymentPreference> relOrderPaymentPreference= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderStatus")
    List<OrderStatus> relOrderStatus= new ArrayList<>(); 
    @Exclude
    @Singular("addCreatedByParty")
    List<Party> relCreatedByParty= new ArrayList<>(); 
    @Exclude
    @Singular("addLastModifiedByParty")
    List<Party> relLastModifiedByParty= new ArrayList<>(); 
    @Exclude
    @Singular("addChangeByPartyStatus")
    List<PartyStatus> relChangeByPartyStatus= new ArrayList<>(); 
    @Exclude
    @Singular("addCreatedByProduct")
    List<Product> relCreatedByProduct= new ArrayList<>(); 
    @Exclude
    @Singular("addLastModifiedByProduct")
    List<Product> relLastModifiedByProduct= new ArrayList<>(); 
    @Exclude
    @Singular("addCreatedByProductFeaturePrice")
    List<ProductFeaturePrice> relCreatedByProductFeaturePrice= new ArrayList<>(); 
    @Exclude
    @Singular("addLastModifiedByProductFeaturePrice")
    List<ProductFeaturePrice> relLastModifiedByProductFeaturePrice= new ArrayList<>(); 
    @Exclude
    @Singular("addCreatedByProductPrice")
    List<ProductPrice> relCreatedByProductPrice= new ArrayList<>(); 
    @Exclude
    @Singular("addLastModifiedByProductPrice")
    List<ProductPrice> relLastModifiedByProductPrice= new ArrayList<>(); 
    @Exclude
    @Singular("addCreatedByProductPromo")
    List<ProductPromo> relCreatedByProductPromo= new ArrayList<>(); 
    @Exclude
    @Singular("addLastModifiedByProductPromo")
    List<ProductPromo> relLastModifiedByProductPromo= new ArrayList<>(); 
    @Exclude
    @Singular("addCreatedByProductPromoCode")
    List<ProductPromoCode> relCreatedByProductPromoCode= new ArrayList<>(); 
    @Exclude
    @Singular("addLastModifiedByProductPromoCode")
    List<ProductPromoCode> relLastModifiedByProductPromoCode= new ArrayList<>(); 
    @Exclude
    @Singular("addProductReview")
    List<ProductReview> relProductReview= new ArrayList<>(); 
    @Exclude
    @Singular("addShipmentReceipt")
    List<ShipmentReceipt> relShipmentReceipt= new ArrayList<>(); 
    @Exclude
    @Singular("addChangeByShipmentStatus")
    List<ShipmentStatus> relChangeByShipmentStatus= new ArrayList<>(); 
    @Exclude
    @Singular("addUserLoginSecurityGroup")
    List<UserLoginSecurityGroup> relUserLoginSecurityGroup= new ArrayList<>(); 
    @Exclude
    @Singular("addAssignedByWorkEffortPartyAssignment")
    List<WorkEffortPartyAssignment> relAssignedByWorkEffortPartyAssignment= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    List<Tenant> relTenant= new ArrayList<>();

    public Map<String, Supplier<List<?>>> suppliers(){
        Map<String, Supplier<List<?>>> supplierMap=Maps.newHashMap();
         
        supplierMap.put(PARTY, getter(this, UserLogin::getRelParty)); 
        supplierMap.put(PERSON, getter(this, UserLogin::getRelPerson)); 
        supplierMap.put(PARTY_GROUP, getter(this, UserLogin::getRelPartyGroup)); 
        supplierMap.put(CHANGE_BY_BUDGET_STATUS, getter(this, UserLogin::getRelChangeByBudgetStatus)); 
        supplierMap.put(CREATED_BY_CONTENT, getter(this, UserLogin::getRelCreatedByContent)); 
        supplierMap.put(LAST_MODIFIED_BY_CONTENT, getter(this, UserLogin::getRelLastModifiedByContent)); 
        supplierMap.put(CREATED_BY_CONTENT_ASSOC, getter(this, UserLogin::getRelCreatedByContentAssoc)); 
        supplierMap.put(LAST_MODIFIED_BY_CONTENT_ASSOC, getter(this, UserLogin::getRelLastModifiedByContentAssoc)); 
        supplierMap.put(CREATED_BY_DATA_RESOURCE, getter(this, UserLogin::getRelCreatedByDataResource)); 
        supplierMap.put(LAST_MODIFIED_BY_DATA_RESOURCE, getter(this, UserLogin::getRelLastModifiedByDataResource)); 
        supplierMap.put(FIN_ACCOUNT_STATUS, getter(this, UserLogin::getRelFinAccountStatus)); 
        supplierMap.put(CHANGE_BY_INVOICE_STATUS, getter(this, UserLogin::getRelChangeByInvoiceStatus)); 
        supplierMap.put(ISSUED_BY_ITEM_ISSUANCE, getter(this, UserLogin::getRelIssuedByItemIssuance)); 
        supplierMap.put(AUTH_JOB_SANDBOX, getter(this, UserLogin::getRelAuthJobSandbox)); 
        supplierMap.put(RUN_AS_JOB_SANDBOX, getter(this, UserLogin::getRelRunAsJobSandbox)); 
        supplierMap.put(ORDER_ADJUSTMENT, getter(this, UserLogin::getRelOrderAdjustment)); 
        supplierMap.put(CREATED_BY_ORDER_HEADER, getter(this, UserLogin::getRelCreatedByOrderHeader)); 
        supplierMap.put(DONT_CANCEL_SET_ORDER_ITEM, getter(this, UserLogin::getRelDontCancelSetOrderItem)); 
        supplierMap.put(CHANGE_BY_ORDER_ITEM, getter(this, UserLogin::getRelChangeByOrderItem)); 
        supplierMap.put(ORDER_PAYMENT_PREFERENCE, getter(this, UserLogin::getRelOrderPaymentPreference)); 
        supplierMap.put(ORDER_STATUS, getter(this, UserLogin::getRelOrderStatus)); 
        supplierMap.put(CREATED_BY_PARTY, getter(this, UserLogin::getRelCreatedByParty)); 
        supplierMap.put(LAST_MODIFIED_BY_PARTY, getter(this, UserLogin::getRelLastModifiedByParty)); 
        supplierMap.put(CHANGE_BY_PARTY_STATUS, getter(this, UserLogin::getRelChangeByPartyStatus)); 
        supplierMap.put(CREATED_BY_PRODUCT, getter(this, UserLogin::getRelCreatedByProduct)); 
        supplierMap.put(LAST_MODIFIED_BY_PRODUCT, getter(this, UserLogin::getRelLastModifiedByProduct)); 
        supplierMap.put(CREATED_BY_PRODUCT_FEATURE_PRICE, getter(this, UserLogin::getRelCreatedByProductFeaturePrice)); 
        supplierMap.put(LAST_MODIFIED_BY_PRODUCT_FEATURE_PRICE, getter(this, UserLogin::getRelLastModifiedByProductFeaturePrice)); 
        supplierMap.put(CREATED_BY_PRODUCT_PRICE, getter(this, UserLogin::getRelCreatedByProductPrice)); 
        supplierMap.put(LAST_MODIFIED_BY_PRODUCT_PRICE, getter(this, UserLogin::getRelLastModifiedByProductPrice)); 
        supplierMap.put(CREATED_BY_PRODUCT_PROMO, getter(this, UserLogin::getRelCreatedByProductPromo)); 
        supplierMap.put(LAST_MODIFIED_BY_PRODUCT_PROMO, getter(this, UserLogin::getRelLastModifiedByProductPromo)); 
        supplierMap.put(CREATED_BY_PRODUCT_PROMO_CODE, getter(this, UserLogin::getRelCreatedByProductPromoCode)); 
        supplierMap.put(LAST_MODIFIED_BY_PRODUCT_PROMO_CODE, getter(this, UserLogin::getRelLastModifiedByProductPromoCode)); 
        supplierMap.put(PRODUCT_REVIEW, getter(this, UserLogin::getRelProductReview)); 
        supplierMap.put(SHIPMENT_RECEIPT, getter(this, UserLogin::getRelShipmentReceipt)); 
        supplierMap.put(CHANGE_BY_SHIPMENT_STATUS, getter(this, UserLogin::getRelChangeByShipmentStatus)); 
        supplierMap.put(USER_LOGIN_SECURITY_GROUP, getter(this, UserLogin::getRelUserLoginSecurityGroup)); 
        supplierMap.put(ASSIGNED_BY_WORK_EFFORT_PARTY_ASSIGNMENT, getter(this, UserLogin::getRelAssignedByWorkEffortPartyAssignment)); 
        supplierMap.put(TENANT, getter(this, UserLogin::getRelTenant));

        return supplierMap;
    };

    public UserLoginDelegator.Agent agent(IProc.ProcContext ctx,
                                             UserLoginDelegator delegator){
        return delegator.getAgent(ctx, this.getUserLoginId());
    }

    public UserLoginData.Builder toHeadBuilder() {
        UserLoginData.Builder builder = UserLoginData.newBuilder();
        if (userLoginId != null) {
            builder.setUserLoginId(userLoginId);
        }
        if (currentPassword != null) {
            builder.setCurrentPassword(currentPassword);
        }
        if (passwordHint != null) {
            builder.setPasswordHint(passwordHint);
        }
        if (isSystem != null) {
            builder.setIsSystem(getIndicator(isSystem));
        }
        if (enabled != null) {
            builder.setEnabled(getIndicator(enabled));
        }
        if (hasLoggedOut != null) {
            builder.setHasLoggedOut(getIndicator(hasLoggedOut));
        }
        if (requirePasswordChange != null) {
            builder.setRequirePasswordChange(getIndicator(requirePasswordChange));
        }
        if (lastCurrencyUom != null) {
            builder.setLastCurrencyUom(lastCurrencyUom);
        }
        if (lastLocale != null) {
            builder.setLastLocale(lastLocale);
        }
        if (lastTimeZone != null) {
            builder.setLastTimeZone(lastTimeZone);
        }
        if (disabledDateTime != null) {
            builder.setDisabledDateTime(getTimestamp(disabledDateTime));
        }
        if (successiveFailedLogins != null) {
            builder.setSuccessiveFailedLogins(successiveFailedLogins);
        }
        if (externalAuthId != null) {
            builder.setExternalAuthId(externalAuthId);
        }
        if (userLdapDn != null) {
            builder.setUserLdapDn(userLdapDn);
        }
        if (disabledBy != null) {
            builder.setDisabledBy(disabledBy);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

}


/*
-- keys: userLoginId

-- fields --
    
    String userLoginId
    String currentPassword
    String passwordHint
    Character isSystem
    Character enabled
    Character hasLoggedOut
    Character requirePasswordChange
    String lastCurrencyUom
    String lastLocale
    String lastTimeZone
    java.time.LocalDateTime disabledDateTime
    Long successiveFailedLogins
    String externalAuthId
    String userLdapDn
    String disabledBy
    String partyId

-- relations --
    
    - Party (one, autoRelation: false, keymaps: partyId)
    - Person (one-nofk, autoRelation: false, keymaps: partyId)
    - PartyGroup (one-nofk, autoRelation: false, keymaps: partyId)
    + Created ByAllocationPlanHeader (many, autoRelation: true, keymaps: userLoginId -> createdByUserLogin)
    + Last Modified ByAllocationPlanHeader (many, autoRelation: true, keymaps: userLoginId -> lastModifiedByUserLogin)
    + Created By User LoginAllocationPlanItem (many, autoRelation: true, keymaps: userLoginId -> createdByUserLogin)
    + Last Modified By User LoginAllocationPlanItem (many, autoRelation: true, keymaps: userLoginId -> lastModifiedByUserLogin)
    + ChangeByBudgetStatus (many, autoRelation: true, keymaps: userLoginId -> changeByUserLoginId)
    + CreatedByContactList (many, autoRelation: true, keymaps: userLoginId -> createdByUserLogin)
    + LastModifiedByContactList (many, autoRelation: true, keymaps: userLoginId -> lastModifiedByUserLogin)
    + ChangeByContactListCommStatus (many, autoRelation: true, keymaps: userLoginId -> changeByUserLoginId)
    + CreatedByContent (many, autoRelation: true, keymaps: userLoginId -> createdByUserLogin)
    + LastModifiedByContent (many, autoRelation: true, keymaps: userLoginId -> lastModifiedByUserLogin)
    + CreatedByContentAssoc (many, autoRelation: true, keymaps: userLoginId -> createdByUserLogin)
    + LastModifiedByContentAssoc (many, autoRelation: true, keymaps: userLoginId -> lastModifiedByUserLogin)
    + ChangeByCustRequestStatus (many, autoRelation: true, keymaps: userLoginId -> changeByUserLoginId)
    + CreatedByDataResource (many, autoRelation: true, keymaps: userLoginId -> createdByUserLogin)
    + LastModifiedByDataResource (many, autoRelation: true, keymaps: userLoginId -> lastModifiedByUserLogin)
    + ExampleStatus (many, autoRelation: true, keymaps: userLoginId -> changeByUserLoginId)
    + UserLoginExcelImportHistory (many, autoRelation: true, keymaps: userLoginId)
    + FinAccountStatus (many, autoRelation: true, keymaps: userLoginId -> changeByUserLoginId)
    + InventoryItemStatus (many, autoRelation: true, keymaps: userLoginId -> changeByUserLoginId)
    + ChangeByInvoiceStatus (many, autoRelation: true, keymaps: userLoginId -> changeByUserLoginId)
    + IssuedByItemIssuance (many, autoRelation: true, keymaps: userLoginId -> issuedByUserLoginId)
    + AuthJobSandbox (many, autoRelation: true, keymaps: userLoginId -> authUserLoginId)
    + RunAsJobSandbox (many, autoRelation: true, keymaps: userLoginId -> runAsUser)
    + ChangeOldPicklistStatusHistory (many, autoRelation: true, keymaps: userLoginId -> changeUserLoginId)
    + OrderAdjustment (many, autoRelation: true, keymaps: userLoginId -> createdByUserLogin)
    + CreatedByOrderHeader (many, autoRelation: true, keymaps: userLoginId -> createdBy)
    + DontCancelSetOrderItem (many, autoRelation: true, keymaps: userLoginId -> dontCancelSetUserLogin)
    + ChangeByOrderItem (many, autoRelation: true, keymaps: userLoginId -> changeByUserLoginId)
    + OrderItemChange (many, autoRelation: true, keymaps: userLoginId -> changeUserLogin)
    + OrderPaymentPreference (many, autoRelation: true, keymaps: userLoginId -> createdByUserLogin)
    + OrderStatus (many, autoRelation: true, keymaps: userLoginId -> statusUserLogin)
    + CreatedByParty (many, autoRelation: true, keymaps: userLoginId -> createdByUserLogin)
    + LastModifiedByParty (many, autoRelation: true, keymaps: userLoginId -> lastModifiedByUserLogin)
    + ChangeByPartyStatus (many, autoRelation: true, keymaps: userLoginId -> changeByUserLoginId)
    + CreatedByPicklistRole (many, autoRelation: true, keymaps: userLoginId -> createdByUserLogin)
    + LastModifiedByPicklistRole (many, autoRelation: true, keymaps: userLoginId -> lastModifiedByUserLogin)
    + ChangePicklistStatus (many, autoRelation: true, keymaps: userLoginId -> changeByUserLoginId)
    + CreatedByProduct (many, autoRelation: true, keymaps: userLoginId -> createdByUserLogin)
    + LastModifiedByProduct (many, autoRelation: true, keymaps: userLoginId -> lastModifiedByUserLogin)
    + CreatedByProductFeaturePrice (many, autoRelation: true, keymaps: userLoginId -> createdByUserLogin)
    + LastModifiedByProductFeaturePrice (many, autoRelation: true, keymaps: userLoginId -> lastModifiedByUserLogin)
    + CreatedByProductPrice (many, autoRelation: true, keymaps: userLoginId -> createdByUserLogin)
    + LastModifiedByProductPrice (many, autoRelation: true, keymaps: userLoginId -> lastModifiedByUserLogin)
    + ChangedByProductPriceChange (many, autoRelation: true, keymaps: userLoginId -> changedByUserLogin)
    + CreatedByProductPromo (many, autoRelation: true, keymaps: userLoginId -> createdByUserLogin)
    + LastModifiedByProductPromo (many, autoRelation: true, keymaps: userLoginId -> lastModifiedByUserLogin)
    + CreatedByProductPromoCode (many, autoRelation: true, keymaps: userLoginId -> createdByUserLogin)
    + LastModifiedByProductPromoCode (many, autoRelation: true, keymaps: userLoginId -> lastModifiedByUserLogin)
    + ProductReview (many, autoRelation: true, keymaps: userLoginId)
    + QuoteAdjustment (many, autoRelation: true, keymaps: userLoginId -> createdByUserLogin)
    + ChangeByRequirementStatus (many, autoRelation: true, keymaps: userLoginId -> changeByUserLoginId)
    + ReturnAdjustment (many, autoRelation: true, keymaps: userLoginId -> createdByUserLogin)
    + ReturnHeader (many, autoRelation: true, keymaps: userLoginId -> createdBy)
    + ChangeByReturnStatus (many, autoRelation: true, keymaps: userLoginId -> changeByUserLoginId)
    + CreatedBySalesForecast (many, autoRelation: true, keymaps: userLoginId -> createdByUserLoginId)
    + ModifiedBySalesForecast (many, autoRelation: true, keymaps: userLoginId -> modifiedByUserLoginId)
    + ModifiedBySalesForecastHistory (many, autoRelation: true, keymaps: userLoginId -> modifiedByUserLoginId)
    + SalesOpportunity (many, autoRelation: true, keymaps: userLoginId -> createdByUserLogin)
    + SalesOpportunityHistory (many, autoRelation: true, keymaps: userLoginId -> modifiedByUserLogin)
    + ShipmentReceipt (many, autoRelation: true, keymaps: userLoginId -> receivedByUserLoginId)
    + ChangeByShipmentStatus (many, autoRelation: true, keymaps: userLoginId -> changeByUserLoginId)
    + ChangeByTestingStatus (many, autoRelation: true, keymaps: userLoginId -> changeByUserLoginId)
    + ApprovedByTimesheet (many, autoRelation: true, keymaps: userLoginId -> approvedByUserLoginId)
    + UserLoginHistory (many, autoRelation: true, keymaps: userLoginId)
    + OriginUserLoginHistory (many, autoRelation: true, keymaps: userLoginId -> originUserLoginId)
    + UserLoginPasswordHistory (many, autoRelation: true, keymaps: userLoginId)
    + UserLoginSecurityGroup (many, autoRelation: true, keymaps: userLoginId)
    - UserLoginSession (one-nofk, autoRelation: true, keymaps: userLoginId)
    + UserPreference (many, autoRelation: true, keymaps: userLoginId)
    + WebUserPreference (many, autoRelation: true, keymaps: userLoginId)
    + AssignedByWorkEffortPartyAssignment (many, autoRelation: true, keymaps: userLoginId -> assignedByUserLoginId)
    + WorkEffortReview (many, autoRelation: true, keymaps: userLoginId)
    + SetByWorkEffortStatus (many, autoRelation: true, keymaps: userLoginId -> setByUserLogin)
    + WorkloadStatus (many, autoRelation: true, keymaps: userLoginId -> changeByUserLoginId)
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/


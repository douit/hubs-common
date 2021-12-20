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
        if (getUserLoginId() != null) {
            builder.setUserLoginId(getUserLoginId());
        }
        if (getCurrentPassword() != null) {
            builder.setCurrentPassword(getCurrentPassword());
        }
        if (getPasswordHint() != null) {
            builder.setPasswordHint(getPasswordHint());
        }
        if (getIsSystem() != null) {
            builder.setIsSystem(getIndicator(getIsSystem()));
        }
        if (getEnabled() != null) {
            builder.setEnabled(getIndicator(getEnabled()));
        }
        if (getHasLoggedOut() != null) {
            builder.setHasLoggedOut(getIndicator(getHasLoggedOut()));
        }
        if (getRequirePasswordChange() != null) {
            builder.setRequirePasswordChange(getIndicator(getRequirePasswordChange()));
        }
        if (getLastCurrencyUom() != null) {
            builder.setLastCurrencyUom(getLastCurrencyUom());
        }
        if (getLastLocale() != null) {
            builder.setLastLocale(getLastLocale());
        }
        if (getLastTimeZone() != null) {
            builder.setLastTimeZone(getLastTimeZone());
        }
        if (getDisabledDateTime() != null) {
            builder.setDisabledDateTime(getTimestamp(getDisabledDateTime()));
        }
        if (getSuccessiveFailedLogins() != null) {
            builder.setSuccessiveFailedLogins(getSuccessiveFailedLogins());
        }
        if (getExternalAuthId() != null) {
            builder.setExternalAuthId(getExternalAuthId());
        }
        if (getUserLdapDn() != null) {
            builder.setUserLdapDn(getUserLdapDn());
        }
        if (getDisabledBy() != null) {
            builder.setDisabledBy(getDisabledBy());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
        if (getPartyId() != null) {
            builder.setPartyId(getPartyId());
        }
        if (getTenantId() != null) {
            builder.setTenantId(getTenantId());
        }
                    
        return builder;
    }

    public static UserLogin fromData(UserLoginFlatData data) {
        return fromPrototype(data).build();
    }

    public static UserLogin.UserLoginBuilder fromPrototype(UserLoginFlatData data) {
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
                ;
    }

        // relations
     
    @Exclude
    @Singular("addParty")
    @SerializedName("party") 
    List<Party> relParty= new ArrayList<>(); 
    @Exclude
    @Singular("addPerson")
    @SerializedName("person") 
    List<Person> relPerson= new ArrayList<>(); 
    @Exclude
    @Singular("addPartyGroup")
    @SerializedName("party_group") 
    List<PartyGroup> relPartyGroup= new ArrayList<>(); 
    @Exclude
    @Singular("addChangeByBudgetStatus")
    @SerializedName("change_by_budget_status") 
    List<BudgetStatus> relChangeByBudgetStatus= new ArrayList<>(); 
    @Exclude
    @Singular("addCreatedByContent")
    @SerializedName("created_by_content") 
    List<Content> relCreatedByContent= new ArrayList<>(); 
    @Exclude
    @Singular("addLastModifiedByContent")
    @SerializedName("last_modified_by_content") 
    List<Content> relLastModifiedByContent= new ArrayList<>(); 
    @Exclude
    @Singular("addCreatedByContentAssoc")
    @SerializedName("created_by_content_assoc") 
    List<ContentAssoc> relCreatedByContentAssoc= new ArrayList<>(); 
    @Exclude
    @Singular("addLastModifiedByContentAssoc")
    @SerializedName("last_modified_by_content_assoc") 
    List<ContentAssoc> relLastModifiedByContentAssoc= new ArrayList<>(); 
    @Exclude
    @Singular("addCreatedByDataResource")
    @SerializedName("created_by_data_resource") 
    List<DataResource> relCreatedByDataResource= new ArrayList<>(); 
    @Exclude
    @Singular("addLastModifiedByDataResource")
    @SerializedName("last_modified_by_data_resource") 
    List<DataResource> relLastModifiedByDataResource= new ArrayList<>(); 
    @Exclude
    @Singular("addFinAccountStatus")
    @SerializedName("fin_account_status") 
    List<FinAccountStatus> relFinAccountStatus= new ArrayList<>(); 
    @Exclude
    @Singular("addChangeByInvoiceStatus")
    @SerializedName("change_by_invoice_status") 
    List<InvoiceStatus> relChangeByInvoiceStatus= new ArrayList<>(); 
    @Exclude
    @Singular("addIssuedByItemIssuance")
    @SerializedName("issued_by_item_issuance") 
    List<ItemIssuance> relIssuedByItemIssuance= new ArrayList<>(); 
    @Exclude
    @Singular("addAuthJobSandbox")
    @SerializedName("auth_job_sandbox") 
    List<JobSandbox> relAuthJobSandbox= new ArrayList<>(); 
    @Exclude
    @Singular("addRunAsJobSandbox")
    @SerializedName("run_as_job_sandbox") 
    List<JobSandbox> relRunAsJobSandbox= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderAdjustment")
    @SerializedName("order_adjustment") 
    List<OrderAdjustment> relOrderAdjustment= new ArrayList<>(); 
    @Exclude
    @Singular("addCreatedByOrderHeader")
    @SerializedName("created_by_order_header") 
    List<OrderHeader> relCreatedByOrderHeader= new ArrayList<>(); 
    @Exclude
    @Singular("addDontCancelSetOrderItem")
    @SerializedName("dont_cancel_set_order_item") 
    List<OrderItem> relDontCancelSetOrderItem= new ArrayList<>(); 
    @Exclude
    @Singular("addChangeByOrderItem")
    @SerializedName("change_by_order_item") 
    List<OrderItem> relChangeByOrderItem= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderPaymentPreference")
    @SerializedName("order_payment_preference") 
    List<OrderPaymentPreference> relOrderPaymentPreference= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderStatus")
    @SerializedName("order_status") 
    List<OrderStatus> relOrderStatus= new ArrayList<>(); 
    @Exclude
    @Singular("addCreatedByParty")
    @SerializedName("created_by_party") 
    List<Party> relCreatedByParty= new ArrayList<>(); 
    @Exclude
    @Singular("addLastModifiedByParty")
    @SerializedName("last_modified_by_party") 
    List<Party> relLastModifiedByParty= new ArrayList<>(); 
    @Exclude
    @Singular("addChangeByPartyStatus")
    @SerializedName("change_by_party_status") 
    List<PartyStatus> relChangeByPartyStatus= new ArrayList<>(); 
    @Exclude
    @Singular("addCreatedByProduct")
    @SerializedName("created_by_product") 
    List<Product> relCreatedByProduct= new ArrayList<>(); 
    @Exclude
    @Singular("addLastModifiedByProduct")
    @SerializedName("last_modified_by_product") 
    List<Product> relLastModifiedByProduct= new ArrayList<>(); 
    @Exclude
    @Singular("addCreatedByProductFeaturePrice")
    @SerializedName("created_by_product_feature_price") 
    List<ProductFeaturePrice> relCreatedByProductFeaturePrice= new ArrayList<>(); 
    @Exclude
    @Singular("addLastModifiedByProductFeaturePrice")
    @SerializedName("last_modified_by_product_feature_price") 
    List<ProductFeaturePrice> relLastModifiedByProductFeaturePrice= new ArrayList<>(); 
    @Exclude
    @Singular("addCreatedByProductPrice")
    @SerializedName("created_by_product_price") 
    List<ProductPrice> relCreatedByProductPrice= new ArrayList<>(); 
    @Exclude
    @Singular("addLastModifiedByProductPrice")
    @SerializedName("last_modified_by_product_price") 
    List<ProductPrice> relLastModifiedByProductPrice= new ArrayList<>(); 
    @Exclude
    @Singular("addCreatedByProductPromo")
    @SerializedName("created_by_product_promo") 
    List<ProductPromo> relCreatedByProductPromo= new ArrayList<>(); 
    @Exclude
    @Singular("addLastModifiedByProductPromo")
    @SerializedName("last_modified_by_product_promo") 
    List<ProductPromo> relLastModifiedByProductPromo= new ArrayList<>(); 
    @Exclude
    @Singular("addCreatedByProductPromoCode")
    @SerializedName("created_by_product_promo_code") 
    List<ProductPromoCode> relCreatedByProductPromoCode= new ArrayList<>(); 
    @Exclude
    @Singular("addLastModifiedByProductPromoCode")
    @SerializedName("last_modified_by_product_promo_code") 
    List<ProductPromoCode> relLastModifiedByProductPromoCode= new ArrayList<>(); 
    @Exclude
    @Singular("addProductReview")
    @SerializedName("product_review") 
    List<ProductReview> relProductReview= new ArrayList<>(); 
    @Exclude
    @Singular("addQuoteAdjustment")
    @SerializedName("quote_adjustment") 
    List<QuoteAdjustment> relQuoteAdjustment= new ArrayList<>(); 
    @Exclude
    @Singular("addReturnHeader")
    @SerializedName("return_header") 
    List<ReturnHeader> relReturnHeader= new ArrayList<>(); 
    @Exclude
    @Singular("addShipmentReceipt")
    @SerializedName("shipment_receipt") 
    List<ShipmentReceipt> relShipmentReceipt= new ArrayList<>(); 
    @Exclude
    @Singular("addChangeByShipmentStatus")
    @SerializedName("change_by_shipment_status") 
    List<ShipmentStatus> relChangeByShipmentStatus= new ArrayList<>(); 
    @Exclude
    @Singular("addUserLoginSecurityGroup")
    @SerializedName("user_login_security_group") 
    List<UserLoginSecurityGroup> relUserLoginSecurityGroup= new ArrayList<>(); 
    @Exclude
    @Singular("addAssignedByWorkEffortPartyAssignment")
    @SerializedName("assigned_by_work_effort_party_assignment") 
    List<WorkEffortPartyAssignment> relAssignedByWorkEffortPartyAssignment= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    @SerializedName("tenant") 
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
        supplierMap.put(QUOTE_ADJUSTMENT, getter(this, UserLogin::getRelQuoteAdjustment)); 
        supplierMap.put(RETURN_HEADER, getter(this, UserLogin::getRelReturnHeader)); 
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
        if (getUserLoginId() != null) {
            builder.setUserLoginId(getUserLoginId());
        }
        if (getCurrentPassword() != null) {
            builder.setCurrentPassword(getCurrentPassword());
        }
        if (getPasswordHint() != null) {
            builder.setPasswordHint(getPasswordHint());
        }
        if (getIsSystem() != null) {
            builder.setIsSystem(getIndicator(getIsSystem()));
        }
        if (getEnabled() != null) {
            builder.setEnabled(getIndicator(getEnabled()));
        }
        if (getHasLoggedOut() != null) {
            builder.setHasLoggedOut(getIndicator(getHasLoggedOut()));
        }
        if (getRequirePasswordChange() != null) {
            builder.setRequirePasswordChange(getIndicator(getRequirePasswordChange()));
        }
        if (getLastCurrencyUom() != null) {
            builder.setLastCurrencyUom(getLastCurrencyUom());
        }
        if (getLastLocale() != null) {
            builder.setLastLocale(getLastLocale());
        }
        if (getLastTimeZone() != null) {
            builder.setLastTimeZone(getLastTimeZone());
        }
        if (getDisabledDateTime() != null) {
            builder.setDisabledDateTime(getTimestamp(getDisabledDateTime()));
        }
        if (getSuccessiveFailedLogins() != null) {
            builder.setSuccessiveFailedLogins(getSuccessiveFailedLogins());
        }
        if (getExternalAuthId() != null) {
            builder.setExternalAuthId(getExternalAuthId());
        }
        if (getUserLdapDn() != null) {
            builder.setUserLdapDn(getUserLdapDn());
        }
        if (getDisabledBy() != null) {
            builder.setDisabledBy(getDisabledBy());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
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


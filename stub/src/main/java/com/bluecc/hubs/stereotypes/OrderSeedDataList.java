package com.bluecc.hubs.stereotypes;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.stereotypes.OrderSeedData.*;import com.bluecc.hubs.stub.OrderItemAssocTypeData;
import com.bluecc.hubs.stub.EnumerationData;
import com.bluecc.hubs.stub.OrderItemTypeData;
import com.bluecc.hubs.stub.OrderDenylistTypeData;
import com.bluecc.hubs.stub.ReturnAdjustmentTypeData;
import com.bluecc.hubs.stub.EnumerationTypeData;
import com.bluecc.hubs.stub.CustRequestResolutionData;
import com.bluecc.hubs.stub.ReturnHeaderTypeData;
import com.bluecc.hubs.stub.ReturnTypeData;
import com.bluecc.hubs.stub.CustRequestTypeData;
import com.bluecc.hubs.stub.StatusItemData;
import com.bluecc.hubs.stub.StatusValidChangeData;
import com.bluecc.hubs.stub.WorkReqFulfTypeData;
import com.bluecc.hubs.stub.AllocationPlanTypeData;
import com.bluecc.hubs.stub.OrderTypeData;
import com.bluecc.hubs.stub.ReturnItemTypeMapData;
import com.bluecc.hubs.stub.StatusTypeData;
import com.bluecc.hubs.stub.ShoppingListTypeData;
import com.bluecc.hubs.stub.RequirementTypeData;
import com.bluecc.hubs.stub.ReturnReasonData;
import com.bluecc.hubs.stub.OrderAdjustmentTypeData;
import com.bluecc.hubs.stub.QuoteTypeData;
import com.bluecc.hubs.stub.ReturnItemTypeData;

public final class OrderSeedDataList {
    public static final List<OrderItemAssocTypeData> orderItemAssocTypeList=ImmutableList.of(        
            OrderItemAssocType_PURCHASE_ORDER,        
            OrderItemAssocType_DROP_SHIPMENT,        
            OrderItemAssocType_REPLACEMENT,        
            OrderItemAssocType_NEW_VERSION,        
            OrderItemAssocType_EXCHANGE);

    public static final List<EnumerationData> enumerationList=ImmutableList.of(        
            Enumeration_WEB_SALES_CHANNEL,        
            Enumeration_FAX_SALES_CHANNEL,        
            Enumeration_PHONE_SALES_CHANNEL,        
            Enumeration_EMAIL_SALES_CHANNEL,        
            Enumeration_SNAIL_SALES_CHANNEL,        
            Enumeration_AFFIL_SALES_CHANNEL,        
            Enumeration_EBAY_SALES_CHANNEL,        
            Enumeration_UNKNWN_SALES_CHANNEL,        
            Enumeration_ODR_ITM_UPDATE,        
            Enumeration_ODR_ITM_CANCEL,        
            Enumeration_ODR_ITM_APPEND,        
            Enumeration_OICR_MISORDER_ITEM,        
            Enumeration_OICR_CHANGE_MIND,        
            Enumeration_AUTO,        
            Enumeration_MANUAL);

    public static final List<OrderItemTypeData> orderItemTypeList=ImmutableList.of(        
            OrderItemType_PURCHASE_SPECIFIC,        
            OrderItemType_INVENTORY_ORDER_ITEM,        
            OrderItemType_SUPPLIES_ORDER_ITEM,        
            OrderItemType_ASSET_ORDER_ITEM,        
            OrderItemType_PRODUCT_ORDER_ITEM,        
            OrderItemType_WORK_ORDER_ITEM,        
            OrderItemType_RENTAL_ORDER_ITEM,        
            OrderItemType_BULK_ORDER_ITEM);

    public static final List<OrderDenylistTypeData> orderDenylistTypeList=ImmutableList.of(        
            OrderDenylistType_DENYLIST_ADDRESS,        
            OrderDenylistType_DENYLIST_CREDITCARD,        
            OrderDenylistType_DENYLIST_EMAIL,        
            OrderDenylistType_DENYLIST_PHONE);

    public static final List<ReturnAdjustmentTypeData> returnAdjustmentTypeList=ImmutableList.of(        
            ReturnAdjustmentType_RET_PROMOTION_ADJ,        
            ReturnAdjustmentType_RET_REPLACE_ADJ,        
            ReturnAdjustmentType_RET_DISCOUNT_ADJ,        
            ReturnAdjustmentType_RET_FEE_ADJ,        
            ReturnAdjustmentType_RET_MISC_ADJ,        
            ReturnAdjustmentType_RET_SALES_TAX_ADJ,        
            ReturnAdjustmentType_RET_VAT_TAX_ADJ,        
            ReturnAdjustmentType_RET_VAT_PC_ADJ,        
            ReturnAdjustmentType_RET_SHIPPING_ADJ,        
            ReturnAdjustmentType_RET_SURCHARGE_ADJ,        
            ReturnAdjustmentType_RET_ADD_FEATURE_ADJ,        
            ReturnAdjustmentType_RET_WARRANTY_ADJ,        
            ReturnAdjustmentType_RET_MKTG_PKG_ADJ,        
            ReturnAdjustmentType_RET_MAN_ADJ);

    public static final List<EnumerationTypeData> enumerationTypeList=ImmutableList.of(        
            EnumerationType_ORDER_SALES_CHANNEL,        
            EnumerationType_ODR_ITM_CHANGE_TYPE,        
            EnumerationType_ODR_ITM_CH_REASON,        
            EnumerationType_ALLOC_PLAN_METHOD);

    public static final List<CustRequestResolutionData> custRequestResolutionList=ImmutableList.of(        
            CustRequestResolution_FIXED,        
            CustRequestResolution_WORKS,        
            CustRequestResolution_WONTFIX,        
            CustRequestResolution_DUPLICATE,        
            CustRequestResolution_REJECTED,        
            CustRequestResolution_IMPLEMENTED);

    public static final List<ReturnHeaderTypeData> returnHeaderTypeList=ImmutableList.of(        
            ReturnHeaderType_CUSTOMER_RETURN,        
            ReturnHeaderType_VENDOR_RETURN);

    public static final List<ReturnTypeData> returnTypeList=ImmutableList.of(        
            ReturnType_RTN_CREDIT,        
            ReturnType_RTN_REFUND,        
            ReturnType_RTN_REPLACE,        
            ReturnType_RTN_CSREPLACE,        
            ReturnType_RTN_REPAIR_REPLACE,        
            ReturnType_RTN_WAIT_REPLACE_RES,        
            ReturnType_RTN_REPLACE_IMMEDIAT,        
            ReturnType_RTN_REFUND_IMMEDIATE,        
            ReturnType_RTN_RENTAL);

    public static final List<CustRequestTypeData> custRequestTypeList=ImmutableList.of(        
            CustRequestType_RF_BUGFIX,        
            CustRequestType_RF_CATALOG,        
            CustRequestType_RF_FEATURE,        
            CustRequestType_RF_INFO,        
            CustRequestType_RF_PROPOSAL,        
            CustRequestType_RF_QUOTE,        
            CustRequestType_RF_SUPPORT,        
            CustRequestType_RF_PUR_QUOTE);

    public static final List<StatusItemData> statusItemList=ImmutableList.of(        
            StatusItem_ORDER_CREATED,        
            StatusItem_ORDER_PROCESSING,        
            StatusItem_ORDER_APPROVED,        
            StatusItem_ORDER_SENT,        
            StatusItem_ORDER_HOLD,        
            StatusItem_ORDER_COMPLETED,        
            StatusItem_ORDER_REJECTED,        
            StatusItem_ORDER_CANCELLED,        
            StatusItem_ITEM_CREATED,        
            StatusItem_ITEM_APPROVED,        
            StatusItem_ITEM_COMPLETED,        
            StatusItem_ITEM_REJECTED,        
            StatusItem_ITEM_CANCELLED,        
            StatusItem_PAYMENT_NOT_RECEIVED,        
            StatusItem_PAYMENT_RECEIVED,        
            StatusItem_PAYMENT_NOT_AUTH,        
            StatusItem_PAYMENT_AUTHORIZED,        
            StatusItem_PAYMENT_SETTLED,        
            StatusItem_PAYMENT_DECLINED,        
            StatusItem_PAYMENT_REFUNDED,        
            StatusItem_PAYMENT_CANCELLED,        
            StatusItem_ODS_SUBMITTED,        
            StatusItem_ODS_ACCEPTED,        
            StatusItem_ODS_APPROVED,        
            StatusItem_ODS_ARRANGED,        
            StatusItem_ODS_CANCELLED,        
            StatusItem_RETURN_REQUESTED,        
            StatusItem_RETURN_ACCEPTED,        
            StatusItem_RETURN_RECEIVED,        
            StatusItem_RETURN_COMPLETED,        
            StatusItem_RETURN_MAN_REFUND,        
            StatusItem_RETURN_CANCELLED,        
            StatusItem_SUP_RETURN_REQUESTED,        
            StatusItem_SUP_RETURN_ACCEPTED,        
            StatusItem_SUP_RETURN_SHIPPED,        
            StatusItem_SUP_RETURN_COMPLETED,        
            StatusItem_SUP_RETURN_CANCELLED,        
            StatusItem_CRQ_DRAFT,        
            StatusItem_CRQ_SUBMITTED,        
            StatusItem_CRQ_ACCEPTED,        
            StatusItem_CRQ_REVIEWED,        
            StatusItem_CRQ_PENDING,        
            StatusItem_CRQ_COMPLETED,        
            StatusItem_CRQ_REJECTED,        
            StatusItem_CRQ_CANCELLED,        
            StatusItem_REQ_PROPOSED,        
            StatusItem_REQ_CREATED,        
            StatusItem_REQ_APPROVED,        
            StatusItem_REQ_ORDERED,        
            StatusItem_REQ_REJECTED,        
            StatusItem_QUO_CREATED,        
            StatusItem_QUO_APPROVED,        
            StatusItem_QUO_ORDERED,        
            StatusItem_QUO_REJECTED,        
            StatusItem_ALLOC_PLAN_CREATED,        
            StatusItem_ALLOC_PLAN_APPROVED,        
            StatusItem_ALLOC_PLAN_COMPLETED,        
            StatusItem_ALLOC_PLAN_CANCELLED,        
            StatusItem_ALLOC_PLAN_ITEM_CRTD,        
            StatusItem_ALLOC_PLAN_ITEM_APRV,        
            StatusItem_ALLOC_PLAN_ITEM_CMPL,        
            StatusItem_ALLOC_PLAN_ITEM_CNCL);

    public static final List<StatusValidChangeData> statusValidChangeList=ImmutableList.of(        
            StatusValidChange_ORDER_CREATED_ORDER_PROCESSING,        
            StatusValidChange_ORDER_CREATED_ORDER_APPROVED,        
            StatusValidChange_ORDER_CREATED_ORDER_HOLD,        
            StatusValidChange_ORDER_CREATED_ORDER_REJECTED,        
            StatusValidChange_ORDER_CREATED_ORDER_CANCELLED,        
            StatusValidChange_ORDER_PROCESSING_ORDER_HOLD,        
            StatusValidChange_ORDER_PROCESSING_ORDER_APPROVED,        
            StatusValidChange_ORDER_PROCESSING_ORDER_REJECTED,        
            StatusValidChange_ORDER_PROCESSING_ORDER_CANCELLED,        
            StatusValidChange_ORDER_APPROVED_ORDER_SENT,        
            StatusValidChange_ORDER_APPROVED_ORDER_PROCESSING,        
            StatusValidChange_ORDER_APPROVED_ORDER_COMPLETED,        
            StatusValidChange_ORDER_APPROVED_ORDER_CANCELLED,        
            StatusValidChange_ORDER_APPROVED_ORDER_HOLD,        
            StatusValidChange_ORDER_HOLD_ORDER_PROCESSING,        
            StatusValidChange_ORDER_HOLD_ORDER_APPROVED,        
            StatusValidChange_ORDER_HOLD_ORDER_CANCELLED,        
            StatusValidChange_ORDER_SENT_ORDER_COMPLETED,        
            StatusValidChange_ORDER_SENT_ORDER_CANCELLED,        
            StatusValidChange_ORDER_COMPLETED_ORDER_APPROVED,        
            StatusValidChange_ITEM_CREATED_ITEM_APPROVED,        
            StatusValidChange_ITEM_CREATED_ITEM_REJECTED,        
            StatusValidChange_ITEM_CREATED_ITEM_CANCELLED,        
            StatusValidChange_ITEM_APPROVED_ITEM_COMPLETED,        
            StatusValidChange_ITEM_APPROVED_ITEM_CANCELLED,        
            StatusValidChange_ITEM_COMPLETED_ITEM_APPROVED,        
            StatusValidChange_PAYMENT_NOT_RECEIVED_PAYMENT_RECEIVED,        
            StatusValidChange_PAYMENT_NOT_RECEIVED_PAYMENT_CANCELLED,        
            StatusValidChange_PAYMENT_NOT_AUTH_PAYMENT_AUTHORIZED,        
            StatusValidChange_PAYMENT_NOT_AUTH_PAYMENT_CANCELLED,        
            StatusValidChange_PAYMENT_AUTHORIZED_PAYMENT_SETTLED,        
            StatusValidChange_PAYMENT_AUTHORIZED_PAYMENT_CANCELLED,        
            StatusValidChange_PAYMENT_SETTLED_PAYMENT_REFUNDED,        
            StatusValidChange_ODS_SUBMITTED_ODS_ACCEPTED,        
            StatusValidChange_ODS_ACCEPTED_ODS_APPROVED,        
            StatusValidChange_ODS_APPROVED_ODS_ARRANGED,        
            StatusValidChange_ODS_SUBMITTED_ODS_CANCELLED,        
            StatusValidChange_ODS_ACCEPTED_ODS_CANCELLED,        
            StatusValidChange_ODS_APPROVED_ODS_CANCELLED,        
            StatusValidChange_ODS_ARRANGED_ODS_CANCELLED,        
            StatusValidChange_RETURN_REQUESTED_RETURN_ACCEPTED,        
            StatusValidChange_RETURN_REQUESTED_RETURN_CANCELLED,        
            StatusValidChange_RETURN_ACCEPTED_RETURN_RECEIVED,        
            StatusValidChange_RETURN_ACCEPTED_RETURN_CANCELLED,        
            StatusValidChange_RETURN_RECEIVED_RETURN_COMPLETED,        
            StatusValidChange_RETURN_RECEIVED_RETURN_CANCELLED,        
            StatusValidChange_RETURN_RECEIVED_RETURN_MAN_REFUND,        
            StatusValidChange_SUP_RETURN_REQUESTED_SUP_RETURN_ACCEPTED,        
            StatusValidChange_SUP_RETURN_REQUESTED_SUP_RETURN_CANCELLED,        
            StatusValidChange_SUP_RETURN_ACCEPTED_SUP_RETURN_SHIPPED,        
            StatusValidChange_SUP_RETURN_ACCEPTED_SUP_RETURN_CANCELLED,        
            StatusValidChange_SUP_RETURN_SHIPPED_SUP_RETURN_COMPLETED,        
            StatusValidChange_SUP_RETURN_SHIPPED_SUP_RETURN_CANCELLED,        
            StatusValidChange_CRQ_DRAFT_CRQ_ACCEPTED,        
            StatusValidChange_CRQ_DRAFT_CRQ_SUBMITTED,        
            StatusValidChange_CRQ_DRAFT_CRQ_CANCELLED,        
            StatusValidChange_CRQ_SUBMITTED_CRQ_ACCEPTED,        
            StatusValidChange_CRQ_SUBMITTED_CRQ_COMPLETED,        
            StatusValidChange_CRQ_SUBMITTED_CRQ_REJECTED,        
            StatusValidChange_CRQ_SUBMITTED_CRQ_CANCELLED,        
            StatusValidChange_CRQ_SUBMITTED_CRQ_PENDING,        
            StatusValidChange_CRQ_PENDING_CRQ_SUBMITTED,        
            StatusValidChange_CRQ_PENDING_CRQ_ACCEPTED,        
            StatusValidChange_CRQ_PENDING_CRQ_REVIEWED,        
            StatusValidChange_CRQ_PENDING_CRQ_CANCELLED,        
            StatusValidChange_CRQ_ACCEPTED_CRQ_REVIEWED,        
            StatusValidChange_CRQ_ACCEPTED_CRQ_COMPLETED,        
            StatusValidChange_CRQ_ACCEPTED_CRQ_CANCELLED,        
            StatusValidChange_CRQ_ACCEPTED_CRQ_PENDING,        
            StatusValidChange_CRQ_REVIEWED_CRQ_COMPLETED,        
            StatusValidChange_CRQ_REVIEWED_CRQ_CANCELLED,        
            StatusValidChange_CRQ_REVIEWED_CRQ_PENDING,        
            StatusValidChange_CRQ_COMPLETED_CRQ_REVIEWED,        
            StatusValidChange_REQ_PROPOSED_REQ_APPROVED,        
            StatusValidChange_REQ_PROPOSED_REQ_REJECTED,        
            StatusValidChange_REQ_CREATED_REQ_APPROVED,        
            StatusValidChange_REQ_CREATED_REQ_REJECTED,        
            StatusValidChange_REQ_APPROVED_REQ_ORDERED,        
            StatusValidChange_REQ_APPROVED_REQ_REJECTED,        
            StatusValidChange_QUO_CREATED_QUO_APPROVED,        
            StatusValidChange_QUO_CREATED_QUO_REJECTED,        
            StatusValidChange_QUO_APPROVED_QUO_ORDERED,        
            StatusValidChange_QUO_APPROVED_QUO_REJECTED,        
            StatusValidChange_ALLOC_PLAN_CREATED_ALLOC_PLAN_APPROVED,        
            StatusValidChange_ALLOC_PLAN_CREATED_ALLOC_PLAN_CANCELLED,        
            StatusValidChange_ALLOC_PLAN_APPROVED_ALLOC_PLAN_CREATED,        
            StatusValidChange_ALLOC_PLAN_APPROVED_ALLOC_PLAN_COMPLETED,        
            StatusValidChange_ALLOC_PLAN_APPROVED_ALLOC_PLAN_CANCELLED,        
            StatusValidChange_ALLOC_PLAN_ITEM_CRTD_ALLOC_PLAN_ITEM_APRV,        
            StatusValidChange_ALLOC_PLAN_ITEM_CRTD_ALLOC_PLAN_ITEM_CNCL,        
            StatusValidChange_ALLOC_PLAN_ITEM_APRV_ALLOC_PLAN_ITEM_CRTD,        
            StatusValidChange_ALLOC_PLAN_ITEM_APRV_ALLOC_PLAN_ITEM_CMPL,        
            StatusValidChange_ALLOC_PLAN_ITEM_APRV_ALLOC_PLAN_ITEM_CNCL);

    public static final List<WorkReqFulfTypeData> workReqFulfTypeList=ImmutableList.of(        
            WorkReqFulfType_WRF_IMPLEMENTS,        
            WorkReqFulfType_WRF_FIXES,        
            WorkReqFulfType_WRF_DEPLOYS,        
            WorkReqFulfType_WRF_TESTS,        
            WorkReqFulfType_WRF_DELIVERS);

    public static final List<AllocationPlanTypeData> allocationPlanTypeList=ImmutableList.of(        
            AllocationPlanType_SALES_ORD_ALLOCATION);

    public static final List<OrderTypeData> orderTypeList=ImmutableList.of(        
            OrderType_PURCHASE_ORDER,        
            OrderType_SALES_ORDER);

    public static final List<ReturnItemTypeMapData> returnItemTypeMapList=ImmutableList.of(        
            ReturnItemTypeMap_FINISHED_GOOD_CUSTOMER_RETURN,        
            ReturnItemTypeMap_MARKETING_PKG_AUTO_CUSTOMER_RETURN,        
            ReturnItemTypeMap_MARKETING_PKG_PICK_CUSTOMER_RETURN,        
            ReturnItemTypeMap_AGGREGATED_CONF_CUSTOMER_RETURN,        
            ReturnItemTypeMap_DIGITAL_GOOD_CUSTOMER_RETURN,        
            ReturnItemTypeMap_FINDIG_GOOD_CUSTOMER_RETURN,        
            ReturnItemTypeMap_RAW_MATERIAL_CUSTOMER_RETURN,        
            ReturnItemTypeMap_PROMOTION_ADJUSTMENT_CUSTOMER_RETURN,        
            ReturnItemTypeMap_REPLACE_ADJUSTMENT_CUSTOMER_RETURN,        
            ReturnItemTypeMap_DISCOUNT_ADJUSTMENT_CUSTOMER_RETURN,        
            ReturnItemTypeMap_FEE_CUSTOMER_RETURN,        
            ReturnItemTypeMap_MISCELLANEOUS_CHARGE_CUSTOMER_RETURN,        
            ReturnItemTypeMap_SALES_TAX_CUSTOMER_RETURN,        
            ReturnItemTypeMap_VAT_TAX_CUSTOMER_RETURN,        
            ReturnItemTypeMap_VAT_PRICE_CORRECT_CUSTOMER_RETURN,        
            ReturnItemTypeMap_SHIPPING_CHARGES_CUSTOMER_RETURN,        
            ReturnItemTypeMap_SURCHARGE_ADJUSTMENT_CUSTOMER_RETURN,        
            ReturnItemTypeMap_ADDITIONAL_FEATURE_CUSTOMER_RETURN,        
            ReturnItemTypeMap_WARRANTY_ADJUSTMENT_CUSTOMER_RETURN,        
            ReturnItemTypeMap_RENTAL_ORDER_ITEM_CUSTOMER_RETURN,        
            ReturnItemTypeMap_ASSET_USAGE_OUT_IN_CUSTOMER_RETURN,        
            ReturnItemTypeMap_SERVICE_PRODUCT_CUSTOMER_RETURN,        
            ReturnItemTypeMap_SERVICE_CUSTOMER_RETURN,        
            ReturnItemTypeMap_FINISHED_GOOD_VENDOR_RETURN,        
            ReturnItemTypeMap_MARKETING_PKG_AUTO_VENDOR_RETURN,        
            ReturnItemTypeMap_MARKETING_PKG_PICK_VENDOR_RETURN,        
            ReturnItemTypeMap_AGGREGATED_CONF_VENDOR_RETURN,        
            ReturnItemTypeMap_DIGITAL_GOOD_VENDOR_RETURN,        
            ReturnItemTypeMap_FINDIG_GOOD_VENDOR_RETURN,        
            ReturnItemTypeMap_RAW_MATERIAL_VENDOR_RETURN,        
            ReturnItemTypeMap_PROMOTION_ADJUSTMENT_VENDOR_RETURN,        
            ReturnItemTypeMap_REPLACE_ADJUSTMENT_VENDOR_RETURN,        
            ReturnItemTypeMap_DISCOUNT_ADJUSTMENT_VENDOR_RETURN,        
            ReturnItemTypeMap_FEE_VENDOR_RETURN,        
            ReturnItemTypeMap_MISCELLANEOUS_CHARGE_VENDOR_RETURN,        
            ReturnItemTypeMap_SALES_TAX_VENDOR_RETURN,        
            ReturnItemTypeMap_VAT_TAX_VENDOR_RETURN,        
            ReturnItemTypeMap_VAT_PRICE_CORRECT_VENDOR_RETURN,        
            ReturnItemTypeMap_SHIPPING_CHARGES_VENDOR_RETURN,        
            ReturnItemTypeMap_SURCHARGE_ADJUSTMENT_VENDOR_RETURN,        
            ReturnItemTypeMap_ADDITIONAL_FEATURE_VENDOR_RETURN,        
            ReturnItemTypeMap_WARRANTY_ADJUSTMENT_VENDOR_RETURN);

    public static final List<StatusTypeData> statusTypeList=ImmutableList.of(        
            StatusType_ORDER_STATUS,        
            StatusType_ORDER_ITEM_STATUS,        
            StatusType_PAYMENT_PREF_STATUS,        
            StatusType_ORDER_DEL_SCH,        
            StatusType_ORDER_RETURN_STTS,        
            StatusType_PORDER_RETURN_STTS,        
            StatusType_CUSTREQ_STTS,        
            StatusType_REQUIREMENT_STATUS,        
            StatusType_QUOTE_STATUS,        
            StatusType_ALLOC_PLAN_STATUS,        
            StatusType_ALLOC_PLAN_ITEM_STTS);

    public static final List<ShoppingListTypeData> shoppingListTypeList=ImmutableList.of(        
            ShoppingListType_SLT_WISH_LIST,        
            ShoppingListType_SLT_GIFT_REG,        
            ShoppingListType_SLT_AUTO_REODR,        
            ShoppingListType_SLT_FREQ_PURCHASES,        
            ShoppingListType_SLT_SPEC_PURP);

    public static final List<RequirementTypeData> requirementTypeList=ImmutableList.of(        
            RequirementType_CUSTOMER_REQUIREMENT,        
            RequirementType_INTERNAL_REQUIREMENT,        
            RequirementType_PRODUCT_REQUIREMENT,        
            RequirementType_WORK_REQUIREMENT,        
            RequirementType_TRANSFER_REQUIREMENT);

    public static final List<ReturnReasonData> returnReasonList=ImmutableList.of(        
            ReturnReason_RTN_NOT_WANT,        
            ReturnReason_RTN_DEFECTIVE_ITEM,        
            ReturnReason_RTN_MISSHIP_ITEM,        
            ReturnReason_RTN_DIG_FILL_FAIL,        
            ReturnReason_RTN_COD_REJECT,        
            ReturnReason_RTN_SIZE_EXCHANGE,        
            ReturnReason_RTN_NORMAL_RETURN);

    public static final List<OrderAdjustmentTypeData> orderAdjustmentTypeList=ImmutableList.of(        
            OrderAdjustmentType_PROMOTION_ADJUSTMENT,        
            OrderAdjustmentType_REPLACE_ADJUSTMENT,        
            OrderAdjustmentType_DISCOUNT_ADJUSTMENT,        
            OrderAdjustmentType_DONATION_ADJUSTMENT,        
            OrderAdjustmentType_FEE,        
            OrderAdjustmentType_MISCELLANEOUS_CHARGE,        
            OrderAdjustmentType_SALES_TAX,        
            OrderAdjustmentType_VAT_TAX,        
            OrderAdjustmentType_VAT_PRICE_CORRECT,        
            OrderAdjustmentType_SHIPPING_CHARGES,        
            OrderAdjustmentType_SURCHARGE_ADJUSTMENT,        
            OrderAdjustmentType_ADDITIONAL_FEATURE,        
            OrderAdjustmentType_WARRANTY_ADJUSTMENT,        
            OrderAdjustmentType_MKTG_PKG_AUTO_ADJUST,        
            OrderAdjustmentType_DEPOSIT_ADJUSTMENT);

    public static final List<QuoteTypeData> quoteTypeList=ImmutableList.of(        
            QuoteType_OTHER_QUOTE,        
            QuoteType_PRODUCT_QUOTE,        
            QuoteType_PROPOSAL,        
            QuoteType_PURCHASE_QUOTE);

    public static final List<ReturnItemTypeData> returnItemTypeList=ImmutableList.of(        
            ReturnItemType_RET_NPROD_ITEM,        
            ReturnItemType_RET_PROD_ITEM,        
            ReturnItemType_RET_FPROD_ITEM,        
            ReturnItemType_RET_DPROD_ITEM,        
            ReturnItemType_RET_FDPROD_ITEM,        
            ReturnItemType_RET_RPROD_ITEM,        
            ReturnItemType_RET_PROD_FEATR_ITEM,        
            ReturnItemType_RET_SPROD_ITEM,        
            ReturnItemType_RET_WE_ITEM,        
            ReturnItemType_RET_TE_ITEM,        
            ReturnItemType_RET_MPROD_ITEM);

}

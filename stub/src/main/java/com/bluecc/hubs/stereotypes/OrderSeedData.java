package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.OrderItemAssocTypeData;
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

public final class OrderSeedData {
    public final static OrderItemAssocTypeData OrderItemAssocType_PURCHASE_ORDER = OrderItemAssocTypeData.newBuilder()
        .setDescription("Purchase Order")
        .setHasTable(castIndicator("N"))
        .setOrderItemAssocTypeId("PURCHASE_ORDER")
        .build();


    public final static OrderItemAssocTypeData OrderItemAssocType_DROP_SHIPMENT = OrderItemAssocTypeData.newBuilder()
        .setDescription("Drop Shipment")
        .setHasTable(castIndicator("N"))
        .setOrderItemAssocTypeId("DROP_SHIPMENT")
        .build();


    public final static OrderItemAssocTypeData OrderItemAssocType_REPLACEMENT = OrderItemAssocTypeData.newBuilder()
        .setDescription("Return Replacement")
        .setHasTable(castIndicator("N"))
        .setOrderItemAssocTypeId("REPLACEMENT")
        .build();


    public final static OrderItemAssocTypeData OrderItemAssocType_NEW_VERSION = OrderItemAssocTypeData.newBuilder()
        .setDescription("New Version")
        .setHasTable(castIndicator("N"))
        .setOrderItemAssocTypeId("NEW_VERSION")
        .build();


    public final static OrderItemAssocTypeData OrderItemAssocType_EXCHANGE = OrderItemAssocTypeData.newBuilder()
        .setDescription("Exchange Order")
        .setHasTable(castIndicator("N"))
        .setOrderItemAssocTypeId("EXCHANGE")
        .build();


    public final static EnumerationData Enumeration_WEB_SALES_CHANNEL = EnumerationData.newBuilder()
        .setDescription("Web Channel")
        .setEnumCode("WEB_CHANNEL")
        .setEnumId("WEB_SALES_CHANNEL")
        .setEnumTypeId("ORDER_SALES_CHANNEL")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_FAX_SALES_CHANNEL = EnumerationData.newBuilder()
        .setDescription("Fax Channel")
        .setEnumCode("FAX_CHANNEL")
        .setEnumId("FAX_SALES_CHANNEL")
        .setEnumTypeId("ORDER_SALES_CHANNEL")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_PHONE_SALES_CHANNEL = EnumerationData.newBuilder()
        .setDescription("Phone Channel")
        .setEnumCode("PHONE_CHANNEL")
        .setEnumId("PHONE_SALES_CHANNEL")
        .setEnumTypeId("ORDER_SALES_CHANNEL")
        .setSequenceId("04")
        .build();


    public final static EnumerationData Enumeration_EMAIL_SALES_CHANNEL = EnumerationData.newBuilder()
        .setDescription("E-Mail Channel")
        .setEnumCode("EMAIL_CHANNEL")
        .setEnumId("EMAIL_SALES_CHANNEL")
        .setEnumTypeId("ORDER_SALES_CHANNEL")
        .setSequenceId("05")
        .build();


    public final static EnumerationData Enumeration_SNAIL_SALES_CHANNEL = EnumerationData.newBuilder()
        .setDescription("Snail Mail Channel")
        .setEnumCode("SNAIL_CHANNEL")
        .setEnumId("SNAIL_SALES_CHANNEL")
        .setEnumTypeId("ORDER_SALES_CHANNEL")
        .setSequenceId("06")
        .build();


    public final static EnumerationData Enumeration_AFFIL_SALES_CHANNEL = EnumerationData.newBuilder()
        .setDescription("Affiliate Channel")
        .setEnumCode("AFFIL_CHANNEL")
        .setEnumId("AFFIL_SALES_CHANNEL")
        .setEnumTypeId("ORDER_SALES_CHANNEL")
        .setSequenceId("07")
        .build();


    public final static EnumerationData Enumeration_EBAY_SALES_CHANNEL = EnumerationData.newBuilder()
        .setDescription("eBay Channel")
        .setEnumCode("EBAY_CHANNEL")
        .setEnumId("EBAY_SALES_CHANNEL")
        .setEnumTypeId("ORDER_SALES_CHANNEL")
        .setSequenceId("08")
        .build();


    public final static EnumerationData Enumeration_UNKNWN_SALES_CHANNEL = EnumerationData.newBuilder()
        .setDescription("Unknown Channel")
        .setEnumCode("UNKOWN_CHANNEL")
        .setEnumId("UNKNWN_SALES_CHANNEL")
        .setEnumTypeId("ORDER_SALES_CHANNEL")
        .setSequenceId("99")
        .build();


    public final static EnumerationData Enumeration_ODR_ITM_UPDATE = EnumerationData.newBuilder()
        .setDescription("Order Item Update")
        .setEnumCode("ITM_UPDATE")
        .setEnumId("ODR_ITM_UPDATE")
        .setEnumTypeId("ODR_ITM_CHANGE_TYPE")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_ODR_ITM_CANCEL = EnumerationData.newBuilder()
        .setDescription("Order Item Cancel")
        .setEnumCode("ITM_CANCEL")
        .setEnumId("ODR_ITM_CANCEL")
        .setEnumTypeId("ODR_ITM_CHANGE_TYPE")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_ODR_ITM_APPEND = EnumerationData.newBuilder()
        .setDescription("Order Item Append")
        .setEnumCode("ITM_APPEND")
        .setEnumId("ODR_ITM_APPEND")
        .setEnumTypeId("ODR_ITM_CHANGE_TYPE")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_OICR_MISORDER_ITEM = EnumerationData.newBuilder()
        .setDescription("Mis-Ordered Item")
        .setEnumCode("MISORDER")
        .setEnumId("OICR_MISORDER_ITEM")
        .setEnumTypeId("ODR_ITM_CH_REASON")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_OICR_CHANGE_MIND = EnumerationData.newBuilder()
        .setDescription("Changed Mind")
        .setEnumCode("CHANGE_MIND")
        .setEnumId("OICR_CHANGE_MIND")
        .setEnumTypeId("ODR_ITM_CH_REASON")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_AUTO = EnumerationData.newBuilder()
        .setDescription("Auto")
        .setEnumCode("AUTO")
        .setEnumId("AUTO")
        .setEnumTypeId("ALLOC_PLAN_METHOD")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_MANUAL = EnumerationData.newBuilder()
        .setDescription("Manual")
        .setEnumCode("MANUAL")
        .setEnumId("MANUAL")
        .setEnumTypeId("ALLOC_PLAN_METHOD")
        .setSequenceId("02")
        .build();


    public final static OrderItemTypeData OrderItemType_PURCHASE_SPECIFIC = OrderItemTypeData.newBuilder()
        .setDescription("Purchase Order Specific")
        .setHasTable(castIndicator("N"))
        .setOrderItemTypeId("PURCHASE_SPECIFIC")
        .build();


    public final static OrderItemTypeData OrderItemType_INVENTORY_ORDER_ITEM = OrderItemTypeData.newBuilder()
        .setDescription("PO: Inventory")
        .setHasTable(castIndicator("N"))
        .setOrderItemTypeId("INVENTORY_ORDER_ITEM")
        .setParentTypeId("PURCHASE_SPECIFIC")
        .build();


    public final static OrderItemTypeData OrderItemType_SUPPLIES_ORDER_ITEM = OrderItemTypeData.newBuilder()
        .setDescription("PO: Supplies (to Expense)")
        .setHasTable(castIndicator("N"))
        .setOrderItemTypeId("SUPPLIES_ORDER_ITEM")
        .setParentTypeId("PURCHASE_SPECIFIC")
        .build();


    public final static OrderItemTypeData OrderItemType_ASSET_ORDER_ITEM = OrderItemTypeData.newBuilder()
        .setDescription("PO: Fixed Asset")
        .setHasTable(castIndicator("N"))
        .setOrderItemTypeId("ASSET_ORDER_ITEM")
        .setParentTypeId("PURCHASE_SPECIFIC")
        .build();


    public final static OrderItemTypeData OrderItemType_PRODUCT_ORDER_ITEM = OrderItemTypeData.newBuilder()
        .setDescription("Product Item")
        .setHasTable(castIndicator("N"))
        .setOrderItemTypeId("PRODUCT_ORDER_ITEM")
        .build();


    public final static OrderItemTypeData OrderItemType_WORK_ORDER_ITEM = OrderItemTypeData.newBuilder()
        .setDescription("Work Item")
        .setHasTable(castIndicator("N"))
        .setOrderItemTypeId("WORK_ORDER_ITEM")
        .build();


    public final static OrderItemTypeData OrderItemType_RENTAL_ORDER_ITEM = OrderItemTypeData.newBuilder()
        .setDescription("Rental Item")
        .setHasTable(castIndicator("N"))
        .setOrderItemTypeId("RENTAL_ORDER_ITEM")
        .build();


    public final static OrderItemTypeData OrderItemType_BULK_ORDER_ITEM = OrderItemTypeData.newBuilder()
        .setDescription("Bulk Item")
        .setHasTable(castIndicator("N"))
        .setOrderItemTypeId("BULK_ORDER_ITEM")
        .build();


    public final static OrderDenylistTypeData OrderDenylistType_DENYLIST_ADDRESS = OrderDenylistTypeData.newBuilder()
        .setDescription("Addresss")
        .setOrderDenylistTypeId("DENYLIST_ADDRESS")
        .build();


    public final static OrderDenylistTypeData OrderDenylistType_DENYLIST_CREDITCARD = OrderDenylistTypeData.newBuilder()
        .setDescription("Credit Card")
        .setOrderDenylistTypeId("DENYLIST_CREDITCARD")
        .build();


    public final static OrderDenylistTypeData OrderDenylistType_DENYLIST_EMAIL = OrderDenylistTypeData.newBuilder()
        .setDescription("E-Mail")
        .setOrderDenylistTypeId("DENYLIST_EMAIL")
        .build();


    public final static OrderDenylistTypeData OrderDenylistType_DENYLIST_PHONE = OrderDenylistTypeData.newBuilder()
        .setDescription("Phone Number")
        .setOrderDenylistTypeId("DENYLIST_PHONE")
        .build();


    public final static ReturnAdjustmentTypeData ReturnAdjustmentType_RET_PROMOTION_ADJ = ReturnAdjustmentTypeData.newBuilder()
        .setDescription("Return Promotion")
        .setHasTable(castIndicator("N"))
        .setReturnAdjustmentTypeId("RET_PROMOTION_ADJ")
        .build();


    public final static ReturnAdjustmentTypeData ReturnAdjustmentType_RET_REPLACE_ADJ = ReturnAdjustmentTypeData.newBuilder()
        .setDescription("Return Replacement")
        .setHasTable(castIndicator("N"))
        .setReturnAdjustmentTypeId("RET_REPLACE_ADJ")
        .build();


    public final static ReturnAdjustmentTypeData ReturnAdjustmentType_RET_DISCOUNT_ADJ = ReturnAdjustmentTypeData.newBuilder()
        .setDescription("Return Discount")
        .setHasTable(castIndicator("N"))
        .setReturnAdjustmentTypeId("RET_DISCOUNT_ADJ")
        .build();


    public final static ReturnAdjustmentTypeData ReturnAdjustmentType_RET_FEE_ADJ = ReturnAdjustmentTypeData.newBuilder()
        .setDescription("Return Fee")
        .setHasTable(castIndicator("N"))
        .setReturnAdjustmentTypeId("RET_FEE_ADJ")
        .build();


    public final static ReturnAdjustmentTypeData ReturnAdjustmentType_RET_MISC_ADJ = ReturnAdjustmentTypeData.newBuilder()
        .setDescription("Return Miscellaneous Charges")
        .setHasTable(castIndicator("N"))
        .setReturnAdjustmentTypeId("RET_MISC_ADJ")
        .build();


    public final static ReturnAdjustmentTypeData ReturnAdjustmentType_RET_SALES_TAX_ADJ = ReturnAdjustmentTypeData.newBuilder()
        .setDescription("Return Sales Tax")
        .setHasTable(castIndicator("N"))
        .setReturnAdjustmentTypeId("RET_SALES_TAX_ADJ")
        .build();


    public final static ReturnAdjustmentTypeData ReturnAdjustmentType_RET_VAT_TAX_ADJ = ReturnAdjustmentTypeData.newBuilder()
        .setDescription("Return VAT Tax")
        .setHasTable(castIndicator("N"))
        .setReturnAdjustmentTypeId("RET_VAT_TAX_ADJ")
        .build();


    public final static ReturnAdjustmentTypeData ReturnAdjustmentType_RET_VAT_PC_ADJ = ReturnAdjustmentTypeData.newBuilder()
        .setDescription("Return VAT Price Correction")
        .setHasTable(castIndicator("N"))
        .setReturnAdjustmentTypeId("RET_VAT_PC_ADJ")
        .build();


    public final static ReturnAdjustmentTypeData ReturnAdjustmentType_RET_SHIPPING_ADJ = ReturnAdjustmentTypeData.newBuilder()
        .setDescription("Return Shipping and Handling")
        .setHasTable(castIndicator("N"))
        .setReturnAdjustmentTypeId("RET_SHIPPING_ADJ")
        .build();


    public final static ReturnAdjustmentTypeData ReturnAdjustmentType_RET_SURCHARGE_ADJ = ReturnAdjustmentTypeData.newBuilder()
        .setDescription("Return Surcharge")
        .setHasTable(castIndicator("N"))
        .setReturnAdjustmentTypeId("RET_SURCHARGE_ADJ")
        .build();


    public final static ReturnAdjustmentTypeData ReturnAdjustmentType_RET_ADD_FEATURE_ADJ = ReturnAdjustmentTypeData.newBuilder()
        .setDescription("Return Additional Feature")
        .setHasTable(castIndicator("N"))
        .setReturnAdjustmentTypeId("RET_ADD_FEATURE_ADJ")
        .build();


    public final static ReturnAdjustmentTypeData ReturnAdjustmentType_RET_WARRANTY_ADJ = ReturnAdjustmentTypeData.newBuilder()
        .setDescription("Return Warranty")
        .setHasTable(castIndicator("N"))
        .setReturnAdjustmentTypeId("RET_WARRANTY_ADJ")
        .build();


    public final static ReturnAdjustmentTypeData ReturnAdjustmentType_RET_MKTG_PKG_ADJ = ReturnAdjustmentTypeData.newBuilder()
        .setDescription("Return Marketing Package Adjustment")
        .setHasTable(castIndicator("N"))
        .setReturnAdjustmentTypeId("RET_MKTG_PKG_ADJ")
        .build();


    public final static ReturnAdjustmentTypeData ReturnAdjustmentType_RET_MAN_ADJ = ReturnAdjustmentTypeData.newBuilder()
        .setDescription("Return Manual Adjustment")
        .setHasTable(castIndicator("N"))
        .setReturnAdjustmentTypeId("RET_MAN_ADJ")
        .build();


    public final static EnumerationTypeData EnumerationType_ORDER_SALES_CHANNEL = EnumerationTypeData.newBuilder()
        .setDescription("Order Sales Channel")
        .setEnumTypeId("ORDER_SALES_CHANNEL")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_ODR_ITM_CHANGE_TYPE = EnumerationTypeData.newBuilder()
        .setDescription("Order Item Change Type")
        .setEnumTypeId("ODR_ITM_CHANGE_TYPE")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_ODR_ITM_CH_REASON = EnumerationTypeData.newBuilder()
        .setDescription("Order Item Change Reason")
        .setEnumTypeId("ODR_ITM_CH_REASON")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_ALLOC_PLAN_METHOD = EnumerationTypeData.newBuilder()
        .setDescription("Allocation Plan Method")
        .setEnumTypeId("ALLOC_PLAN_METHOD")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustRequestResolutionData CustRequestResolution_FIXED = CustRequestResolutionData.newBuilder()
        .setCustRequestResolutionId("FIXED")
        .setCustRequestTypeId("RF_BUGFIX")
        .setDescription("Fixed")
        .build();


    public final static CustRequestResolutionData CustRequestResolution_WORKS = CustRequestResolutionData.newBuilder()
        .setCustRequestResolutionId("WORKS")
        .setCustRequestTypeId("RF_BUGFIX")
        .setDescription("Works For Me")
        .build();


    public final static CustRequestResolutionData CustRequestResolution_WONTFIX = CustRequestResolutionData.newBuilder()
        .setCustRequestResolutionId("WONTFIX")
        .setCustRequestTypeId("RF_BUGFIX")
        .setDescription("Won't Fix")
        .build();


    public final static CustRequestResolutionData CustRequestResolution_DUPLICATE = CustRequestResolutionData.newBuilder()
        .setCustRequestResolutionId("DUPLICATE")
        .setCustRequestTypeId("RF_FEATURE")
        .setDescription("Duplicate")
        .build();


    public final static CustRequestResolutionData CustRequestResolution_REJECTED = CustRequestResolutionData.newBuilder()
        .setCustRequestResolutionId("REJECTED")
        .setCustRequestTypeId("RF_FEATURE")
        .setDescription("Rejected")
        .build();


    public final static CustRequestResolutionData CustRequestResolution_IMPLEMENTED = CustRequestResolutionData.newBuilder()
        .setCustRequestResolutionId("IMPLEMENTED")
        .setCustRequestTypeId("RF_FEATURE")
        .setDescription("Implemented")
        .build();


    public final static ReturnHeaderTypeData ReturnHeaderType_CUSTOMER_RETURN = ReturnHeaderTypeData.newBuilder()
        .setDescription("Return from Customer")
        .setReturnHeaderTypeId("CUSTOMER_RETURN")
        .build();


    public final static ReturnHeaderTypeData ReturnHeaderType_VENDOR_RETURN = ReturnHeaderTypeData.newBuilder()
        .setDescription("Return to Vendor")
        .setReturnHeaderTypeId("VENDOR_RETURN")
        .build();


    public final static ReturnTypeData ReturnType_RTN_CREDIT = ReturnTypeData.newBuilder()
        .setDescription("Store Credit")
        .setHasTable(castIndicator("N"))
        .setReturnTypeId("RTN_CREDIT")
        .setSequenceId("01")
        .build();


    public final static ReturnTypeData ReturnType_RTN_REFUND = ReturnTypeData.newBuilder()
        .setDescription("Refund")
        .setHasTable(castIndicator("N"))
        .setReturnTypeId("RTN_REFUND")
        .setSequenceId("02")
        .build();


    public final static ReturnTypeData ReturnType_RTN_REPLACE = ReturnTypeData.newBuilder()
        .setDescription("Wait Replacement")
        .setHasTable(castIndicator("N"))
        .setReturnTypeId("RTN_REPLACE")
        .setSequenceId("03")
        .build();


    public final static ReturnTypeData ReturnType_RTN_CSREPLACE = ReturnTypeData.newBuilder()
        .setDescription("Cross-Ship Replacement")
        .setHasTable(castIndicator("N"))
        .setReturnTypeId("RTN_CSREPLACE")
        .setSequenceId("04")
        .build();


    public final static ReturnTypeData ReturnType_RTN_REPAIR_REPLACE = ReturnTypeData.newBuilder()
        .setDescription("Repair Replacement")
        .setHasTable(castIndicator("N"))
        .setReturnTypeId("RTN_REPAIR_REPLACE")
        .setSequenceId("05")
        .build();


    public final static ReturnTypeData ReturnType_RTN_WAIT_REPLACE_RES = ReturnTypeData.newBuilder()
        .setDescription("Wait Replacement Reserved")
        .setHasTable(castIndicator("N"))
        .setReturnTypeId("RTN_WAIT_REPLACE_RES")
        .setSequenceId("06")
        .build();


    public final static ReturnTypeData ReturnType_RTN_REPLACE_IMMEDIAT = ReturnTypeData.newBuilder()
        .setDescription("Replace Immediately")
        .setHasTable(castIndicator("N"))
        .setReturnTypeId("RTN_REPLACE_IMMEDIAT")
        .setSequenceId("07")
        .build();


    public final static ReturnTypeData ReturnType_RTN_REFUND_IMMEDIATE = ReturnTypeData.newBuilder()
        .setDescription("Refund immediately")
        .setHasTable(castIndicator("N"))
        .setReturnTypeId("RTN_REFUND_IMMEDIATE")
        .setSequenceId("08")
        .build();


    public final static ReturnTypeData ReturnType_RTN_RENTAL = ReturnTypeData.newBuilder()
        .setDescription("Rental")
        .setHasTable(castIndicator("N"))
        .setReturnTypeId("RTN_RENTAL")
        .setSequenceId("09")
        .build();


    public final static CustRequestTypeData CustRequestType_RF_BUGFIX = CustRequestTypeData.newBuilder()
        .setCustRequestTypeId("RF_BUGFIX")
        .setDescription("Request For Bug Fix")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustRequestTypeData CustRequestType_RF_CATALOG = CustRequestTypeData.newBuilder()
        .setCustRequestTypeId("RF_CATALOG")
        .setDescription("Request For Catalog")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustRequestTypeData CustRequestType_RF_FEATURE = CustRequestTypeData.newBuilder()
        .setCustRequestTypeId("RF_FEATURE")
        .setDescription("Request For Feature")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustRequestTypeData CustRequestType_RF_INFO = CustRequestTypeData.newBuilder()
        .setCustRequestTypeId("RF_INFO")
        .setDescription("Request For Information")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustRequestTypeData CustRequestType_RF_PROPOSAL = CustRequestTypeData.newBuilder()
        .setCustRequestTypeId("RF_PROPOSAL")
        .setDescription("Request For Proposal")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustRequestTypeData CustRequestType_RF_QUOTE = CustRequestTypeData.newBuilder()
        .setCustRequestTypeId("RF_QUOTE")
        .setDescription("Request For Quote")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustRequestTypeData CustRequestType_RF_SUPPORT = CustRequestTypeData.newBuilder()
        .setCustRequestTypeId("RF_SUPPORT")
        .setDescription("Request For Support")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustRequestTypeData CustRequestType_RF_PUR_QUOTE = CustRequestTypeData.newBuilder()
        .setCustRequestTypeId("RF_PUR_QUOTE")
        .setDescription("Request For Purchase Quote")
        .setHasTable(castIndicator("N"))
        .build();


    public final static StatusItemData StatusItem_ORDER_CREATED = StatusItemData.newBuilder()
        .setDescription("Created")
        .setSequenceId("01")
        .setStatusCode("CREATED")
        .setStatusId("ORDER_CREATED")
        .setStatusTypeId("ORDER_STATUS")
        .build();


    public final static StatusItemData StatusItem_ORDER_PROCESSING = StatusItemData.newBuilder()
        .setDescription("Processing")
        .setSequenceId("04")
        .setStatusCode("PROCESSING")
        .setStatusId("ORDER_PROCESSING")
        .setStatusTypeId("ORDER_STATUS")
        .build();


    public final static StatusItemData StatusItem_ORDER_APPROVED = StatusItemData.newBuilder()
        .setDescription("Approved")
        .setSequenceId("05")
        .setStatusCode("APPROVED")
        .setStatusId("ORDER_APPROVED")
        .setStatusTypeId("ORDER_STATUS")
        .build();


    public final static StatusItemData StatusItem_ORDER_SENT = StatusItemData.newBuilder()
        .setDescription("Sent")
        .setSequenceId("03")
        .setStatusCode("SENT")
        .setStatusId("ORDER_SENT")
        .setStatusTypeId("ORDER_STATUS")
        .build();


    public final static StatusItemData StatusItem_ORDER_HOLD = StatusItemData.newBuilder()
        .setDescription("Held")
        .setSequenceId("06")
        .setStatusCode("HELD")
        .setStatusId("ORDER_HOLD")
        .setStatusTypeId("ORDER_STATUS")
        .build();


    public final static StatusItemData StatusItem_ORDER_COMPLETED = StatusItemData.newBuilder()
        .setDescription("Completed")
        .setSequenceId("10")
        .setStatusCode("COMPLETED")
        .setStatusId("ORDER_COMPLETED")
        .setStatusTypeId("ORDER_STATUS")
        .build();


    public final static StatusItemData StatusItem_ORDER_REJECTED = StatusItemData.newBuilder()
        .setDescription("Rejected")
        .setSequenceId("98")
        .setStatusCode("REJECTED")
        .setStatusId("ORDER_REJECTED")
        .setStatusTypeId("ORDER_STATUS")
        .build();


    public final static StatusItemData StatusItem_ORDER_CANCELLED = StatusItemData.newBuilder()
        .setDescription("Cancelled")
        .setSequenceId("99")
        .setStatusCode("CANCELLED")
        .setStatusId("ORDER_CANCELLED")
        .setStatusTypeId("ORDER_STATUS")
        .build();


    public final static StatusItemData StatusItem_ITEM_CREATED = StatusItemData.newBuilder()
        .setDescription("Created")
        .setSequenceId("01")
        .setStatusCode("CREATED")
        .setStatusId("ITEM_CREATED")
        .setStatusTypeId("ORDER_ITEM_STATUS")
        .build();


    public final static StatusItemData StatusItem_ITEM_APPROVED = StatusItemData.newBuilder()
        .setDescription("Approved")
        .setSequenceId("05")
        .setStatusCode("APPROVED")
        .setStatusId("ITEM_APPROVED")
        .setStatusTypeId("ORDER_ITEM_STATUS")
        .build();


    public final static StatusItemData StatusItem_ITEM_COMPLETED = StatusItemData.newBuilder()
        .setDescription("Completed")
        .setSequenceId("10")
        .setStatusCode("COMPLETED")
        .setStatusId("ITEM_COMPLETED")
        .setStatusTypeId("ORDER_ITEM_STATUS")
        .build();


    public final static StatusItemData StatusItem_ITEM_REJECTED = StatusItemData.newBuilder()
        .setDescription("Rejected")
        .setSequenceId("98")
        .setStatusCode("REJECTED")
        .setStatusId("ITEM_REJECTED")
        .setStatusTypeId("ORDER_ITEM_STATUS")
        .build();


    public final static StatusItemData StatusItem_ITEM_CANCELLED = StatusItemData.newBuilder()
        .setDescription("Cancelled")
        .setSequenceId("99")
        .setStatusCode("CANCELLED")
        .setStatusId("ITEM_CANCELLED")
        .setStatusTypeId("ORDER_ITEM_STATUS")
        .build();


    public final static StatusItemData StatusItem_PAYMENT_NOT_RECEIVED = StatusItemData.newBuilder()
        .setDescription("Not-Received")
        .setSequenceId("01")
        .setStatusCode("NOT_RECEIVED")
        .setStatusId("PAYMENT_NOT_RECEIVED")
        .setStatusTypeId("PAYMENT_PREF_STATUS")
        .build();


    public final static StatusItemData StatusItem_PAYMENT_RECEIVED = StatusItemData.newBuilder()
        .setDescription("Received")
        .setSequenceId("02")
        .setStatusCode("RECEIVED")
        .setStatusId("PAYMENT_RECEIVED")
        .setStatusTypeId("PAYMENT_PREF_STATUS")
        .build();


    public final static StatusItemData StatusItem_PAYMENT_NOT_AUTH = StatusItemData.newBuilder()
        .setDescription("Not-Authorized")
        .setSequenceId("01")
        .setStatusCode("NOT_AUTHORIZED")
        .setStatusId("PAYMENT_NOT_AUTH")
        .setStatusTypeId("PAYMENT_PREF_STATUS")
        .build();


    public final static StatusItemData StatusItem_PAYMENT_AUTHORIZED = StatusItemData.newBuilder()
        .setDescription("Authorized")
        .setSequenceId("02")
        .setStatusCode("AUTHORIZED")
        .setStatusId("PAYMENT_AUTHORIZED")
        .setStatusTypeId("PAYMENT_PREF_STATUS")
        .build();


    public final static StatusItemData StatusItem_PAYMENT_SETTLED = StatusItemData.newBuilder()
        .setDescription("Settled")
        .setSequenceId("03")
        .setStatusCode("SETTLED")
        .setStatusId("PAYMENT_SETTLED")
        .setStatusTypeId("PAYMENT_PREF_STATUS")
        .build();


    public final static StatusItemData StatusItem_PAYMENT_DECLINED = StatusItemData.newBuilder()
        .setDescription("Declined")
        .setSequenceId("04")
        .setStatusCode("DECLINED")
        .setStatusId("PAYMENT_DECLINED")
        .setStatusTypeId("PAYMENT_PREF_STATUS")
        .build();


    public final static StatusItemData StatusItem_PAYMENT_REFUNDED = StatusItemData.newBuilder()
        .setDescription("Refunded")
        .setSequenceId("05")
        .setStatusCode("REFUNDED")
        .setStatusId("PAYMENT_REFUNDED")
        .setStatusTypeId("PAYMENT_PREF_STATUS")
        .build();


    public final static StatusItemData StatusItem_PAYMENT_CANCELLED = StatusItemData.newBuilder()
        .setDescription("Cancelled")
        .setSequenceId("99")
        .setStatusCode("CANCELLED")
        .setStatusId("PAYMENT_CANCELLED")
        .setStatusTypeId("PAYMENT_PREF_STATUS")
        .build();


    public final static StatusItemData StatusItem_ODS_SUBMITTED = StatusItemData.newBuilder()
        .setDescription("Supplier Submitted")
        .setSequenceId("01")
        .setStatusCode("SUBMITTED")
        .setStatusId("ODS_SUBMITTED")
        .setStatusTypeId("ORDER_DEL_SCH")
        .build();


    public final static StatusItemData StatusItem_ODS_ACCEPTED = StatusItemData.newBuilder()
        .setDescription("Accepted")
        .setSequenceId("02")
        .setStatusCode("ACCEPTED")
        .setStatusId("ODS_ACCEPTED")
        .setStatusTypeId("ORDER_DEL_SCH")
        .build();


    public final static StatusItemData StatusItem_ODS_APPROVED = StatusItemData.newBuilder()
        .setDescription("Schedule Approved")
        .setSequenceId("03")
        .setStatusCode("APPROVED")
        .setStatusId("ODS_APPROVED")
        .setStatusTypeId("ORDER_DEL_SCH")
        .build();


    public final static StatusItemData StatusItem_ODS_ARRANGED = StatusItemData.newBuilder()
        .setDescription("Delivery Arranged")
        .setSequenceId("04")
        .setStatusCode("ARRANGED")
        .setStatusId("ODS_ARRANGED")
        .setStatusTypeId("ORDER_DEL_SCH")
        .build();


    public final static StatusItemData StatusItem_ODS_CANCELLED = StatusItemData.newBuilder()
        .setDescription("Delivery Cancelled")
        .setSequenceId("99")
        .setStatusCode("CANCELLED")
        .setStatusId("ODS_CANCELLED")
        .setStatusTypeId("ORDER_DEL_SCH")
        .build();


    public final static StatusItemData StatusItem_RETURN_REQUESTED = StatusItemData.newBuilder()
        .setDescription("Requested")
        .setSequenceId("01")
        .setStatusCode("REQUESTED")
        .setStatusId("RETURN_REQUESTED")
        .setStatusTypeId("ORDER_RETURN_STTS")
        .build();


    public final static StatusItemData StatusItem_RETURN_ACCEPTED = StatusItemData.newBuilder()
        .setDescription("Accepted")
        .setSequenceId("02")
        .setStatusCode("ACCEPTED")
        .setStatusId("RETURN_ACCEPTED")
        .setStatusTypeId("ORDER_RETURN_STTS")
        .build();


    public final static StatusItemData StatusItem_RETURN_RECEIVED = StatusItemData.newBuilder()
        .setDescription("Received")
        .setSequenceId("03")
        .setStatusCode("RECEIVED")
        .setStatusId("RETURN_RECEIVED")
        .setStatusTypeId("ORDER_RETURN_STTS")
        .build();


    public final static StatusItemData StatusItem_RETURN_COMPLETED = StatusItemData.newBuilder()
        .setDescription("Completed")
        .setSequenceId("10")
        .setStatusCode("COMPLETED")
        .setStatusId("RETURN_COMPLETED")
        .setStatusTypeId("ORDER_RETURN_STTS")
        .build();


    public final static StatusItemData StatusItem_RETURN_MAN_REFUND = StatusItemData.newBuilder()
        .setDescription("Manual Refund Required")
        .setSequenceId("11")
        .setStatusCode("MANUAL_REFUND")
        .setStatusId("RETURN_MAN_REFUND")
        .setStatusTypeId("ORDER_RETURN_STTS")
        .build();


    public final static StatusItemData StatusItem_RETURN_CANCELLED = StatusItemData.newBuilder()
        .setDescription("Cancelled")
        .setSequenceId("99")
        .setStatusCode("CANCELLED")
        .setStatusId("RETURN_CANCELLED")
        .setStatusTypeId("ORDER_RETURN_STTS")
        .build();


    public final static StatusItemData StatusItem_SUP_RETURN_REQUESTED = StatusItemData.newBuilder()
        .setDescription("Requested")
        .setSequenceId("01")
        .setStatusCode("REQUESTED")
        .setStatusId("SUP_RETURN_REQUESTED")
        .setStatusTypeId("PORDER_RETURN_STTS")
        .build();


    public final static StatusItemData StatusItem_SUP_RETURN_ACCEPTED = StatusItemData.newBuilder()
        .setDescription("Accepted")
        .setSequenceId("02")
        .setStatusCode("ACCEPTED")
        .setStatusId("SUP_RETURN_ACCEPTED")
        .setStatusTypeId("PORDER_RETURN_STTS")
        .build();


    public final static StatusItemData StatusItem_SUP_RETURN_SHIPPED = StatusItemData.newBuilder()
        .setDescription("Shipped")
        .setSequenceId("03")
        .setStatusCode("SHIPPED")
        .setStatusId("SUP_RETURN_SHIPPED")
        .setStatusTypeId("PORDER_RETURN_STTS")
        .build();


    public final static StatusItemData StatusItem_SUP_RETURN_COMPLETED = StatusItemData.newBuilder()
        .setDescription("Completed")
        .setSequenceId("10")
        .setStatusCode("COMPLETED")
        .setStatusId("SUP_RETURN_COMPLETED")
        .setStatusTypeId("PORDER_RETURN_STTS")
        .build();


    public final static StatusItemData StatusItem_SUP_RETURN_CANCELLED = StatusItemData.newBuilder()
        .setDescription("Cancelled")
        .setSequenceId("99")
        .setStatusCode("CANCELLED")
        .setStatusId("SUP_RETURN_CANCELLED")
        .setStatusTypeId("PORDER_RETURN_STTS")
        .build();


    public final static StatusItemData StatusItem_CRQ_DRAFT = StatusItemData.newBuilder()
        .setDescription("Draft")
        .setSequenceId("00")
        .setStatusCode("DRAFT")
        .setStatusId("CRQ_DRAFT")
        .setStatusTypeId("CUSTREQ_STTS")
        .build();


    public final static StatusItemData StatusItem_CRQ_SUBMITTED = StatusItemData.newBuilder()
        .setDescription("Submitted")
        .setSequenceId("01")
        .setStatusCode("SUBMITTED")
        .setStatusId("CRQ_SUBMITTED")
        .setStatusTypeId("CUSTREQ_STTS")
        .build();


    public final static StatusItemData StatusItem_CRQ_ACCEPTED = StatusItemData.newBuilder()
        .setDescription("Accepted")
        .setSequenceId("02")
        .setStatusCode("ACCEPTED")
        .setStatusId("CRQ_ACCEPTED")
        .setStatusTypeId("CUSTREQ_STTS")
        .build();


    public final static StatusItemData StatusItem_CRQ_REVIEWED = StatusItemData.newBuilder()
        .setDescription("Reviewed")
        .setSequenceId("03")
        .setStatusCode("REVIEWED")
        .setStatusId("CRQ_REVIEWED")
        .setStatusTypeId("CUSTREQ_STTS")
        .build();


    public final static StatusItemData StatusItem_CRQ_PENDING = StatusItemData.newBuilder()
        .setDescription("Pending Cust.")
        .setSequenceId("09")
        .setStatusCode("PENDING")
        .setStatusId("CRQ_PENDING")
        .setStatusTypeId("CUSTREQ_STTS")
        .build();


    public final static StatusItemData StatusItem_CRQ_COMPLETED = StatusItemData.newBuilder()
        .setDescription("Completed")
        .setSequenceId("04")
        .setStatusCode("COMPLETED")
        .setStatusId("CRQ_COMPLETED")
        .setStatusTypeId("CUSTREQ_STTS")
        .build();


    public final static StatusItemData StatusItem_CRQ_REJECTED = StatusItemData.newBuilder()
        .setDescription("Rejected")
        .setSequenceId("98")
        .setStatusCode("REJECTED")
        .setStatusId("CRQ_REJECTED")
        .setStatusTypeId("CUSTREQ_STTS")
        .build();


    public final static StatusItemData StatusItem_CRQ_CANCELLED = StatusItemData.newBuilder()
        .setDescription("Cancelled")
        .setSequenceId("99")
        .setStatusCode("CANCELLED")
        .setStatusId("CRQ_CANCELLED")
        .setStatusTypeId("CUSTREQ_STTS")
        .build();


    public final static StatusItemData StatusItem_REQ_PROPOSED = StatusItemData.newBuilder()
        .setDescription("Proposed")
        .setSequenceId("01")
        .setStatusCode("PROPOSED")
        .setStatusId("REQ_PROPOSED")
        .setStatusTypeId("REQUIREMENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_REQ_CREATED = StatusItemData.newBuilder()
        .setDescription("Created")
        .setSequenceId("01")
        .setStatusCode("CREATED")
        .setStatusId("REQ_CREATED")
        .setStatusTypeId("REQUIREMENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_REQ_APPROVED = StatusItemData.newBuilder()
        .setDescription("Approved")
        .setSequenceId("02")
        .setStatusCode("APPROVED")
        .setStatusId("REQ_APPROVED")
        .setStatusTypeId("REQUIREMENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_REQ_ORDERED = StatusItemData.newBuilder()
        .setDescription("Ordered")
        .setSequenceId("03")
        .setStatusCode("ORDERED")
        .setStatusId("REQ_ORDERED")
        .setStatusTypeId("REQUIREMENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_REQ_REJECTED = StatusItemData.newBuilder()
        .setDescription("Rejected")
        .setSequenceId("98")
        .setStatusCode("REJECTED")
        .setStatusId("REQ_REJECTED")
        .setStatusTypeId("REQUIREMENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_QUO_CREATED = StatusItemData.newBuilder()
        .setDescription("Created")
        .setSequenceId("01")
        .setStatusCode("CREATED")
        .setStatusId("QUO_CREATED")
        .setStatusTypeId("QUOTE_STATUS")
        .build();


    public final static StatusItemData StatusItem_QUO_APPROVED = StatusItemData.newBuilder()
        .setDescription("Approved")
        .setSequenceId("02")
        .setStatusCode("APPROVED")
        .setStatusId("QUO_APPROVED")
        .setStatusTypeId("QUOTE_STATUS")
        .build();


    public final static StatusItemData StatusItem_QUO_ORDERED = StatusItemData.newBuilder()
        .setDescription("Ordered")
        .setSequenceId("03")
        .setStatusCode("ORDERED")
        .setStatusId("QUO_ORDERED")
        .setStatusTypeId("QUOTE_STATUS")
        .build();


    public final static StatusItemData StatusItem_QUO_REJECTED = StatusItemData.newBuilder()
        .setDescription("Rejected")
        .setSequenceId("98")
        .setStatusCode("REJECTED")
        .setStatusId("QUO_REJECTED")
        .setStatusTypeId("QUOTE_STATUS")
        .build();


    public final static StatusItemData StatusItem_ALLOC_PLAN_CREATED = StatusItemData.newBuilder()
        .setDescription("Created")
        .setSequenceId("01")
        .setStatusCode("CREATED")
        .setStatusId("ALLOC_PLAN_CREATED")
        .setStatusTypeId("ALLOC_PLAN_STATUS")
        .build();


    public final static StatusItemData StatusItem_ALLOC_PLAN_APPROVED = StatusItemData.newBuilder()
        .setDescription("Approved")
        .setSequenceId("02")
        .setStatusCode("APPROVED")
        .setStatusId("ALLOC_PLAN_APPROVED")
        .setStatusTypeId("ALLOC_PLAN_STATUS")
        .build();


    public final static StatusItemData StatusItem_ALLOC_PLAN_COMPLETED = StatusItemData.newBuilder()
        .setDescription("Completed")
        .setSequenceId("03")
        .setStatusCode("COMPLETED")
        .setStatusId("ALLOC_PLAN_COMPLETED")
        .setStatusTypeId("ALLOC_PLAN_STATUS")
        .build();


    public final static StatusItemData StatusItem_ALLOC_PLAN_CANCELLED = StatusItemData.newBuilder()
        .setDescription("Cancelled")
        .setSequenceId("04")
        .setStatusCode("CANCELLED")
        .setStatusId("ALLOC_PLAN_CANCELLED")
        .setStatusTypeId("ALLOC_PLAN_STATUS")
        .build();


    public final static StatusItemData StatusItem_ALLOC_PLAN_ITEM_CRTD = StatusItemData.newBuilder()
        .setDescription("Created")
        .setSequenceId("01")
        .setStatusCode("CREATED")
        .setStatusId("ALLOC_PLAN_ITEM_CRTD")
        .setStatusTypeId("ALLOC_PLAN_ITEM_STTS")
        .build();


    public final static StatusItemData StatusItem_ALLOC_PLAN_ITEM_APRV = StatusItemData.newBuilder()
        .setDescription("Approved")
        .setSequenceId("02")
        .setStatusCode("APPROVED")
        .setStatusId("ALLOC_PLAN_ITEM_APRV")
        .setStatusTypeId("ALLOC_PLAN_ITEM_STTS")
        .build();


    public final static StatusItemData StatusItem_ALLOC_PLAN_ITEM_CMPL = StatusItemData.newBuilder()
        .setDescription("Completed")
        .setSequenceId("03")
        .setStatusCode("COMPLETED")
        .setStatusId("ALLOC_PLAN_ITEM_CMPL")
        .setStatusTypeId("ALLOC_PLAN_ITEM_STTS")
        .build();


    public final static StatusItemData StatusItem_ALLOC_PLAN_ITEM_CNCL = StatusItemData.newBuilder()
        .setDescription("Cancelled")
        .setSequenceId("04")
        .setStatusCode("CANCELLED")
        .setStatusId("ALLOC_PLAN_ITEM_CNCL")
        .setStatusTypeId("ALLOC_PLAN_ITEM_STTS")
        .build();


    public final static StatusValidChangeData StatusValidChange_ORDER_CREATED_ORDER_PROCESSING = StatusValidChangeData.newBuilder()
        .setStatusId("ORDER_CREATED")
        .setStatusIdTo("ORDER_PROCESSING")
        .setTransitionName("Process Order")
        .build();


    public final static StatusValidChangeData StatusValidChange_ORDER_CREATED_ORDER_APPROVED = StatusValidChangeData.newBuilder()
        .setStatusId("ORDER_CREATED")
        .setStatusIdTo("ORDER_APPROVED")
        .setTransitionName("Approve Order")
        .build();


    public final static StatusValidChangeData StatusValidChange_ORDER_CREATED_ORDER_HOLD = StatusValidChangeData.newBuilder()
        .setStatusId("ORDER_CREATED")
        .setStatusIdTo("ORDER_HOLD")
        .setTransitionName("Hold Order")
        .build();


    public final static StatusValidChangeData StatusValidChange_ORDER_CREATED_ORDER_REJECTED = StatusValidChangeData.newBuilder()
        .setStatusId("ORDER_CREATED")
        .setStatusIdTo("ORDER_REJECTED")
        .setTransitionName("Reject Order")
        .build();


    public final static StatusValidChangeData StatusValidChange_ORDER_CREATED_ORDER_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("ORDER_CREATED")
        .setStatusIdTo("ORDER_CANCELLED")
        .setTransitionName("Cancel Order")
        .build();


    public final static StatusValidChangeData StatusValidChange_ORDER_PROCESSING_ORDER_HOLD = StatusValidChangeData.newBuilder()
        .setStatusId("ORDER_PROCESSING")
        .setStatusIdTo("ORDER_HOLD")
        .setTransitionName("Hold Order")
        .build();


    public final static StatusValidChangeData StatusValidChange_ORDER_PROCESSING_ORDER_APPROVED = StatusValidChangeData.newBuilder()
        .setStatusId("ORDER_PROCESSING")
        .setStatusIdTo("ORDER_APPROVED")
        .setTransitionName("Approve Order")
        .build();


    public final static StatusValidChangeData StatusValidChange_ORDER_PROCESSING_ORDER_REJECTED = StatusValidChangeData.newBuilder()
        .setStatusId("ORDER_PROCESSING")
        .setStatusIdTo("ORDER_REJECTED")
        .setTransitionName("Reject Order")
        .build();


    public final static StatusValidChangeData StatusValidChange_ORDER_PROCESSING_ORDER_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("ORDER_PROCESSING")
        .setStatusIdTo("ORDER_CANCELLED")
        .setTransitionName("Cancel Order")
        .build();


    public final static StatusValidChangeData StatusValidChange_ORDER_APPROVED_ORDER_SENT = StatusValidChangeData.newBuilder()
        .setStatusId("ORDER_APPROVED")
        .setStatusIdTo("ORDER_SENT")
        .setTransitionName("Send Order")
        .build();


    public final static StatusValidChangeData StatusValidChange_ORDER_APPROVED_ORDER_PROCESSING = StatusValidChangeData.newBuilder()
        .setStatusId("ORDER_APPROVED")
        .setStatusIdTo("ORDER_PROCESSING")
        .setTransitionName("Process Order")
        .build();


    public final static StatusValidChangeData StatusValidChange_ORDER_APPROVED_ORDER_COMPLETED = StatusValidChangeData.newBuilder()
        .setStatusId("ORDER_APPROVED")
        .setStatusIdTo("ORDER_COMPLETED")
        .setTransitionName("Complete Order")
        .build();


    public final static StatusValidChangeData StatusValidChange_ORDER_APPROVED_ORDER_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("ORDER_APPROVED")
        .setStatusIdTo("ORDER_CANCELLED")
        .setTransitionName("Cancel Order")
        .build();


    public final static StatusValidChangeData StatusValidChange_ORDER_APPROVED_ORDER_HOLD = StatusValidChangeData.newBuilder()
        .setStatusId("ORDER_APPROVED")
        .setStatusIdTo("ORDER_HOLD")
        .setTransitionName("Hold Order")
        .build();


    public final static StatusValidChangeData StatusValidChange_ORDER_HOLD_ORDER_PROCESSING = StatusValidChangeData.newBuilder()
        .setStatusId("ORDER_HOLD")
        .setStatusIdTo("ORDER_PROCESSING")
        .setTransitionName("Process Order")
        .build();


    public final static StatusValidChangeData StatusValidChange_ORDER_HOLD_ORDER_APPROVED = StatusValidChangeData.newBuilder()
        .setStatusId("ORDER_HOLD")
        .setStatusIdTo("ORDER_APPROVED")
        .setTransitionName("Approve Order")
        .build();


    public final static StatusValidChangeData StatusValidChange_ORDER_HOLD_ORDER_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("ORDER_HOLD")
        .setStatusIdTo("ORDER_CANCELLED")
        .setTransitionName("Cancel Order")
        .build();


    public final static StatusValidChangeData StatusValidChange_ORDER_SENT_ORDER_COMPLETED = StatusValidChangeData.newBuilder()
        .setStatusId("ORDER_SENT")
        .setStatusIdTo("ORDER_COMPLETED")
        .setTransitionName("Order Completed")
        .build();


    public final static StatusValidChangeData StatusValidChange_ORDER_SENT_ORDER_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("ORDER_SENT")
        .setStatusIdTo("ORDER_CANCELLED")
        .setTransitionName("Order Cancelled")
        .build();


    public final static StatusValidChangeData StatusValidChange_ORDER_COMPLETED_ORDER_APPROVED = StatusValidChangeData.newBuilder()
        .setStatusId("ORDER_COMPLETED")
        .setStatusIdTo("ORDER_APPROVED")
        .setTransitionName("Approve Order")
        .build();


    public final static StatusValidChangeData StatusValidChange_ITEM_CREATED_ITEM_APPROVED = StatusValidChangeData.newBuilder()
        .setStatusId("ITEM_CREATED")
        .setStatusIdTo("ITEM_APPROVED")
        .setTransitionName("Approve Item")
        .build();


    public final static StatusValidChangeData StatusValidChange_ITEM_CREATED_ITEM_REJECTED = StatusValidChangeData.newBuilder()
        .setStatusId("ITEM_CREATED")
        .setStatusIdTo("ITEM_REJECTED")
        .setTransitionName("Reject Item")
        .build();


    public final static StatusValidChangeData StatusValidChange_ITEM_CREATED_ITEM_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("ITEM_CREATED")
        .setStatusIdTo("ITEM_CANCELLED")
        .setTransitionName("Cancel Item")
        .build();


    public final static StatusValidChangeData StatusValidChange_ITEM_APPROVED_ITEM_COMPLETED = StatusValidChangeData.newBuilder()
        .setStatusId("ITEM_APPROVED")
        .setStatusIdTo("ITEM_COMPLETED")
        .setTransitionName("Complete Item")
        .build();


    public final static StatusValidChangeData StatusValidChange_ITEM_APPROVED_ITEM_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("ITEM_APPROVED")
        .setStatusIdTo("ITEM_CANCELLED")
        .setTransitionName("Cancel Item")
        .build();


    public final static StatusValidChangeData StatusValidChange_ITEM_COMPLETED_ITEM_APPROVED = StatusValidChangeData.newBuilder()
        .setStatusId("ITEM_COMPLETED")
        .setStatusIdTo("ITEM_APPROVED")
        .setTransitionName("Approve Item")
        .build();


    public final static StatusValidChangeData StatusValidChange_PAYMENT_NOT_RECEIVED_PAYMENT_RECEIVED = StatusValidChangeData.newBuilder()
        .setStatusId("PAYMENT_NOT_RECEIVED")
        .setStatusIdTo("PAYMENT_RECEIVED")
        .setTransitionName("Payment Received")
        .build();


    public final static StatusValidChangeData StatusValidChange_PAYMENT_NOT_RECEIVED_PAYMENT_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("PAYMENT_NOT_RECEIVED")
        .setStatusIdTo("PAYMENT_CANCELLED")
        .setTransitionName("Payment Cancelled")
        .build();


    public final static StatusValidChangeData StatusValidChange_PAYMENT_NOT_AUTH_PAYMENT_AUTHORIZED = StatusValidChangeData.newBuilder()
        .setStatusId("PAYMENT_NOT_AUTH")
        .setStatusIdTo("PAYMENT_AUTHORIZED")
        .setTransitionName("Payment Authorized")
        .build();


    public final static StatusValidChangeData StatusValidChange_PAYMENT_NOT_AUTH_PAYMENT_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("PAYMENT_NOT_AUTH")
        .setStatusIdTo("PAYMENT_CANCELLED")
        .setTransitionName("Payment Cancelled")
        .build();


    public final static StatusValidChangeData StatusValidChange_PAYMENT_AUTHORIZED_PAYMENT_SETTLED = StatusValidChangeData.newBuilder()
        .setStatusId("PAYMENT_AUTHORIZED")
        .setStatusIdTo("PAYMENT_SETTLED")
        .setTransitionName("Payment Settled")
        .build();


    public final static StatusValidChangeData StatusValidChange_PAYMENT_AUTHORIZED_PAYMENT_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("PAYMENT_AUTHORIZED")
        .setStatusIdTo("PAYMENT_CANCELLED")
        .setTransitionName("Payment Cancelled")
        .build();


    public final static StatusValidChangeData StatusValidChange_PAYMENT_SETTLED_PAYMENT_REFUNDED = StatusValidChangeData.newBuilder()
        .setStatusId("PAYMENT_SETTLED")
        .setStatusIdTo("PAYMENT_REFUNDED")
        .setTransitionName("Payment Refunded")
        .build();


    public final static StatusValidChangeData StatusValidChange_ODS_SUBMITTED_ODS_ACCEPTED = StatusValidChangeData.newBuilder()
        .setStatusId("ODS_SUBMITTED")
        .setStatusIdTo("ODS_ACCEPTED")
        .setTransitionName("Accept Delivery Information")
        .build();


    public final static StatusValidChangeData StatusValidChange_ODS_ACCEPTED_ODS_APPROVED = StatusValidChangeData.newBuilder()
        .setStatusId("ODS_ACCEPTED")
        .setStatusIdTo("ODS_APPROVED")
        .setTransitionName("Approve Delivery Schedule")
        .build();


    public final static StatusValidChangeData StatusValidChange_ODS_APPROVED_ODS_ARRANGED = StatusValidChangeData.newBuilder()
        .setStatusId("ODS_APPROVED")
        .setStatusIdTo("ODS_ARRANGED")
        .setTransitionName("Arrange Delivery")
        .build();


    public final static StatusValidChangeData StatusValidChange_ODS_SUBMITTED_ODS_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("ODS_SUBMITTED")
        .setStatusIdTo("ODS_CANCELLED")
        .setTransitionName("Cancel Delivery")
        .build();


    public final static StatusValidChangeData StatusValidChange_ODS_ACCEPTED_ODS_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("ODS_ACCEPTED")
        .setStatusIdTo("ODS_CANCELLED")
        .setTransitionName("Cancel Delivery")
        .build();


    public final static StatusValidChangeData StatusValidChange_ODS_APPROVED_ODS_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("ODS_APPROVED")
        .setStatusIdTo("ODS_CANCELLED")
        .setTransitionName("Cancel Delivery")
        .build();


    public final static StatusValidChangeData StatusValidChange_ODS_ARRANGED_ODS_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("ODS_ARRANGED")
        .setStatusIdTo("ODS_CANCELLED")
        .setTransitionName("Cancel Delivery")
        .build();


    public final static StatusValidChangeData StatusValidChange_RETURN_REQUESTED_RETURN_ACCEPTED = StatusValidChangeData.newBuilder()
        .setStatusId("RETURN_REQUESTED")
        .setStatusIdTo("RETURN_ACCEPTED")
        .setTransitionName("Requested Return Accepted")
        .build();


    public final static StatusValidChangeData StatusValidChange_RETURN_REQUESTED_RETURN_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("RETURN_REQUESTED")
        .setStatusIdTo("RETURN_CANCELLED")
        .setTransitionName("Requested Return Cancelled")
        .build();


    public final static StatusValidChangeData StatusValidChange_RETURN_ACCEPTED_RETURN_RECEIVED = StatusValidChangeData.newBuilder()
        .setStatusId("RETURN_ACCEPTED")
        .setStatusIdTo("RETURN_RECEIVED")
        .setTransitionName("Accepted Return Received")
        .build();


    public final static StatusValidChangeData StatusValidChange_RETURN_ACCEPTED_RETURN_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("RETURN_ACCEPTED")
        .setStatusIdTo("RETURN_CANCELLED")
        .setTransitionName("Accepted Return Cancelled")
        .build();


    public final static StatusValidChangeData StatusValidChange_RETURN_RECEIVED_RETURN_COMPLETED = StatusValidChangeData.newBuilder()
        .setStatusId("RETURN_RECEIVED")
        .setStatusIdTo("RETURN_COMPLETED")
        .setTransitionName("Received Return Completed")
        .build();


    public final static StatusValidChangeData StatusValidChange_RETURN_RECEIVED_RETURN_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("RETURN_RECEIVED")
        .setStatusIdTo("RETURN_CANCELLED")
        .setTransitionName("Received Return Cancelled")
        .build();


    public final static StatusValidChangeData StatusValidChange_RETURN_RECEIVED_RETURN_MAN_REFUND = StatusValidChangeData.newBuilder()
        .setStatusId("RETURN_RECEIVED")
        .setStatusIdTo("RETURN_MAN_REFUND")
        .setTransitionName("Received Return Requires Manual Refund")
        .build();


    public final static StatusValidChangeData StatusValidChange_SUP_RETURN_REQUESTED_SUP_RETURN_ACCEPTED = StatusValidChangeData.newBuilder()
        .setStatusId("SUP_RETURN_REQUESTED")
        .setStatusIdTo("SUP_RETURN_ACCEPTED")
        .setTransitionName("Requested Return Accepted")
        .build();


    public final static StatusValidChangeData StatusValidChange_SUP_RETURN_REQUESTED_SUP_RETURN_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("SUP_RETURN_REQUESTED")
        .setStatusIdTo("SUP_RETURN_CANCELLED")
        .setTransitionName("Requested Return Cancelled")
        .build();


    public final static StatusValidChangeData StatusValidChange_SUP_RETURN_ACCEPTED_SUP_RETURN_SHIPPED = StatusValidChangeData.newBuilder()
        .setStatusId("SUP_RETURN_ACCEPTED")
        .setStatusIdTo("SUP_RETURN_SHIPPED")
        .setTransitionName("Accepted Return Shipped")
        .build();


    public final static StatusValidChangeData StatusValidChange_SUP_RETURN_ACCEPTED_SUP_RETURN_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("SUP_RETURN_ACCEPTED")
        .setStatusIdTo("SUP_RETURN_CANCELLED")
        .setTransitionName("Accepted Return Cancelled")
        .build();


    public final static StatusValidChangeData StatusValidChange_SUP_RETURN_SHIPPED_SUP_RETURN_COMPLETED = StatusValidChangeData.newBuilder()
        .setStatusId("SUP_RETURN_SHIPPED")
        .setStatusIdTo("SUP_RETURN_COMPLETED")
        .setTransitionName("Shipped Return Completed")
        .build();


    public final static StatusValidChangeData StatusValidChange_SUP_RETURN_SHIPPED_SUP_RETURN_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("SUP_RETURN_SHIPPED")
        .setStatusIdTo("SUP_RETURN_CANCELLED")
        .setTransitionName("Shipped Return Cancelled")
        .build();


    public final static StatusValidChangeData StatusValidChange_CRQ_DRAFT_CRQ_ACCEPTED = StatusValidChangeData.newBuilder()
        .setStatusId("CRQ_DRAFT")
        .setStatusIdTo("CRQ_ACCEPTED")
        .setTransitionName("Accept Request")
        .build();


    public final static StatusValidChangeData StatusValidChange_CRQ_DRAFT_CRQ_SUBMITTED = StatusValidChangeData.newBuilder()
        .setStatusId("CRQ_DRAFT")
        .setStatusIdTo("CRQ_SUBMITTED")
        .setTransitionName("Submit Request")
        .build();


    public final static StatusValidChangeData StatusValidChange_CRQ_DRAFT_CRQ_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("CRQ_DRAFT")
        .setStatusIdTo("CRQ_CANCELLED")
        .setTransitionName("Cancel Request")
        .build();


    public final static StatusValidChangeData StatusValidChange_CRQ_SUBMITTED_CRQ_ACCEPTED = StatusValidChangeData.newBuilder()
        .setStatusId("CRQ_SUBMITTED")
        .setStatusIdTo("CRQ_ACCEPTED")
        .setTransitionName("Accept Request")
        .build();


    public final static StatusValidChangeData StatusValidChange_CRQ_SUBMITTED_CRQ_COMPLETED = StatusValidChangeData.newBuilder()
        .setStatusId("CRQ_SUBMITTED")
        .setStatusIdTo("CRQ_COMPLETED")
        .setTransitionName("Complete Request")
        .build();


    public final static StatusValidChangeData StatusValidChange_CRQ_SUBMITTED_CRQ_REJECTED = StatusValidChangeData.newBuilder()
        .setStatusId("CRQ_SUBMITTED")
        .setStatusIdTo("CRQ_REJECTED")
        .setTransitionName("Reject Request")
        .build();


    public final static StatusValidChangeData StatusValidChange_CRQ_SUBMITTED_CRQ_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("CRQ_SUBMITTED")
        .setStatusIdTo("CRQ_CANCELLED")
        .setTransitionName("Cancel Request")
        .build();


    public final static StatusValidChangeData StatusValidChange_CRQ_SUBMITTED_CRQ_PENDING = StatusValidChangeData.newBuilder()
        .setStatusId("CRQ_SUBMITTED")
        .setStatusIdTo("CRQ_PENDING")
        .setTransitionName("Pending customer")
        .build();


    public final static StatusValidChangeData StatusValidChange_CRQ_PENDING_CRQ_SUBMITTED = StatusValidChangeData.newBuilder()
        .setStatusId("CRQ_PENDING")
        .setStatusIdTo("CRQ_SUBMITTED")
        .setTransitionName("Submit Request")
        .build();


    public final static StatusValidChangeData StatusValidChange_CRQ_PENDING_CRQ_ACCEPTED = StatusValidChangeData.newBuilder()
        .setStatusId("CRQ_PENDING")
        .setStatusIdTo("CRQ_ACCEPTED")
        .setTransitionName("Accept Request")
        .build();


    public final static StatusValidChangeData StatusValidChange_CRQ_PENDING_CRQ_REVIEWED = StatusValidChangeData.newBuilder()
        .setStatusId("CRQ_PENDING")
        .setStatusIdTo("CRQ_REVIEWED")
        .setTransitionName("Review Request")
        .build();


    public final static StatusValidChangeData StatusValidChange_CRQ_PENDING_CRQ_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("CRQ_PENDING")
        .setStatusIdTo("CRQ_CANCELLED")
        .setTransitionName("Cancel Request")
        .build();


    public final static StatusValidChangeData StatusValidChange_CRQ_ACCEPTED_CRQ_REVIEWED = StatusValidChangeData.newBuilder()
        .setStatusId("CRQ_ACCEPTED")
        .setStatusIdTo("CRQ_REVIEWED")
        .setTransitionName("Review Request")
        .build();


    public final static StatusValidChangeData StatusValidChange_CRQ_ACCEPTED_CRQ_COMPLETED = StatusValidChangeData.newBuilder()
        .setStatusId("CRQ_ACCEPTED")
        .setStatusIdTo("CRQ_COMPLETED")
        .setTransitionName("Complete Request")
        .build();


    public final static StatusValidChangeData StatusValidChange_CRQ_ACCEPTED_CRQ_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("CRQ_ACCEPTED")
        .setStatusIdTo("CRQ_CANCELLED")
        .setTransitionName("Cancel Request")
        .build();


    public final static StatusValidChangeData StatusValidChange_CRQ_ACCEPTED_CRQ_PENDING = StatusValidChangeData.newBuilder()
        .setStatusId("CRQ_ACCEPTED")
        .setStatusIdTo("CRQ_PENDING")
        .setTransitionName("Pending Customer")
        .build();


    public final static StatusValidChangeData StatusValidChange_CRQ_REVIEWED_CRQ_COMPLETED = StatusValidChangeData.newBuilder()
        .setStatusId("CRQ_REVIEWED")
        .setStatusIdTo("CRQ_COMPLETED")
        .setTransitionName("Complete Request")
        .build();


    public final static StatusValidChangeData StatusValidChange_CRQ_REVIEWED_CRQ_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("CRQ_REVIEWED")
        .setStatusIdTo("CRQ_CANCELLED")
        .setTransitionName("Cancel Request")
        .build();


    public final static StatusValidChangeData StatusValidChange_CRQ_REVIEWED_CRQ_PENDING = StatusValidChangeData.newBuilder()
        .setStatusId("CRQ_REVIEWED")
        .setStatusIdTo("CRQ_PENDING")
        .setTransitionName("Pending Customer")
        .build();


    public final static StatusValidChangeData StatusValidChange_CRQ_COMPLETED_CRQ_REVIEWED = StatusValidChangeData.newBuilder()
        .setStatusId("CRQ_COMPLETED")
        .setStatusIdTo("CRQ_REVIEWED")
        .setTransitionName("Re-open Request")
        .build();


    public final static StatusValidChangeData StatusValidChange_REQ_PROPOSED_REQ_APPROVED = StatusValidChangeData.newBuilder()
        .setStatusId("REQ_PROPOSED")
        .setStatusIdTo("REQ_APPROVED")
        .setTransitionName("Accept Requirement")
        .build();


    public final static StatusValidChangeData StatusValidChange_REQ_PROPOSED_REQ_REJECTED = StatusValidChangeData.newBuilder()
        .setStatusId("REQ_PROPOSED")
        .setStatusIdTo("REQ_REJECTED")
        .setTransitionName("Reject Requirement")
        .build();


    public final static StatusValidChangeData StatusValidChange_REQ_CREATED_REQ_APPROVED = StatusValidChangeData.newBuilder()
        .setStatusId("REQ_CREATED")
        .setStatusIdTo("REQ_APPROVED")
        .setTransitionName("Accept Requirement")
        .build();


    public final static StatusValidChangeData StatusValidChange_REQ_CREATED_REQ_REJECTED = StatusValidChangeData.newBuilder()
        .setStatusId("REQ_CREATED")
        .setStatusIdTo("REQ_REJECTED")
        .setTransitionName("Reject Requirement")
        .build();


    public final static StatusValidChangeData StatusValidChange_REQ_APPROVED_REQ_ORDERED = StatusValidChangeData.newBuilder()
        .setStatusId("REQ_APPROVED")
        .setStatusIdTo("REQ_ORDERED")
        .setTransitionName("Order Requirement")
        .build();


    public final static StatusValidChangeData StatusValidChange_REQ_APPROVED_REQ_REJECTED = StatusValidChangeData.newBuilder()
        .setStatusId("REQ_APPROVED")
        .setStatusIdTo("REQ_REJECTED")
        .setTransitionName("Reject Requirement")
        .build();


    public final static StatusValidChangeData StatusValidChange_QUO_CREATED_QUO_APPROVED = StatusValidChangeData.newBuilder()
        .setStatusId("QUO_CREATED")
        .setStatusIdTo("QUO_APPROVED")
        .setTransitionName("Accept Quote")
        .build();


    public final static StatusValidChangeData StatusValidChange_QUO_CREATED_QUO_REJECTED = StatusValidChangeData.newBuilder()
        .setStatusId("QUO_CREATED")
        .setStatusIdTo("QUO_REJECTED")
        .setTransitionName("Reject Quote")
        .build();


    public final static StatusValidChangeData StatusValidChange_QUO_APPROVED_QUO_ORDERED = StatusValidChangeData.newBuilder()
        .setStatusId("QUO_APPROVED")
        .setStatusIdTo("QUO_ORDERED")
        .setTransitionName("Order Quote")
        .build();


    public final static StatusValidChangeData StatusValidChange_QUO_APPROVED_QUO_REJECTED = StatusValidChangeData.newBuilder()
        .setStatusId("QUO_APPROVED")
        .setStatusIdTo("QUO_REJECTED")
        .setTransitionName("Reject Quote")
        .build();


    public final static StatusValidChangeData StatusValidChange_ALLOC_PLAN_CREATED_ALLOC_PLAN_APPROVED = StatusValidChangeData.newBuilder()
        .setStatusId("ALLOC_PLAN_CREATED")
        .setStatusIdTo("ALLOC_PLAN_APPROVED")
        .setTransitionName("Approve")
        .build();


    public final static StatusValidChangeData StatusValidChange_ALLOC_PLAN_CREATED_ALLOC_PLAN_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("ALLOC_PLAN_CREATED")
        .setStatusIdTo("ALLOC_PLAN_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_ALLOC_PLAN_APPROVED_ALLOC_PLAN_CREATED = StatusValidChangeData.newBuilder()
        .setStatusId("ALLOC_PLAN_APPROVED")
        .setStatusIdTo("ALLOC_PLAN_CREATED")
        .setTransitionName("Create")
        .build();


    public final static StatusValidChangeData StatusValidChange_ALLOC_PLAN_APPROVED_ALLOC_PLAN_COMPLETED = StatusValidChangeData.newBuilder()
        .setStatusId("ALLOC_PLAN_APPROVED")
        .setStatusIdTo("ALLOC_PLAN_COMPLETED")
        .setTransitionName("Complete")
        .build();


    public final static StatusValidChangeData StatusValidChange_ALLOC_PLAN_APPROVED_ALLOC_PLAN_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("ALLOC_PLAN_APPROVED")
        .setStatusIdTo("ALLOC_PLAN_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_ALLOC_PLAN_ITEM_CRTD_ALLOC_PLAN_ITEM_APRV = StatusValidChangeData.newBuilder()
        .setStatusId("ALLOC_PLAN_ITEM_CRTD")
        .setStatusIdTo("ALLOC_PLAN_ITEM_APRV")
        .setTransitionName("Approve")
        .build();


    public final static StatusValidChangeData StatusValidChange_ALLOC_PLAN_ITEM_CRTD_ALLOC_PLAN_ITEM_CNCL = StatusValidChangeData.newBuilder()
        .setStatusId("ALLOC_PLAN_ITEM_CRTD")
        .setStatusIdTo("ALLOC_PLAN_ITEM_CNCL")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_ALLOC_PLAN_ITEM_APRV_ALLOC_PLAN_ITEM_CRTD = StatusValidChangeData.newBuilder()
        .setStatusId("ALLOC_PLAN_ITEM_APRV")
        .setStatusIdTo("ALLOC_PLAN_ITEM_CRTD")
        .setTransitionName("Create")
        .build();


    public final static StatusValidChangeData StatusValidChange_ALLOC_PLAN_ITEM_APRV_ALLOC_PLAN_ITEM_CMPL = StatusValidChangeData.newBuilder()
        .setStatusId("ALLOC_PLAN_ITEM_APRV")
        .setStatusIdTo("ALLOC_PLAN_ITEM_CMPL")
        .setTransitionName("Complete")
        .build();


    public final static StatusValidChangeData StatusValidChange_ALLOC_PLAN_ITEM_APRV_ALLOC_PLAN_ITEM_CNCL = StatusValidChangeData.newBuilder()
        .setStatusId("ALLOC_PLAN_ITEM_APRV")
        .setStatusIdTo("ALLOC_PLAN_ITEM_CNCL")
        .setTransitionName("Cancel")
        .build();


    public final static WorkReqFulfTypeData WorkReqFulfType_WRF_IMPLEMENTS = WorkReqFulfTypeData.newBuilder()
        .setDescription("Implements")
        .setWorkReqFulfTypeId("WRF_IMPLEMENTS")
        .build();


    public final static WorkReqFulfTypeData WorkReqFulfType_WRF_FIXES = WorkReqFulfTypeData.newBuilder()
        .setDescription("Fixes")
        .setWorkReqFulfTypeId("WRF_FIXES")
        .build();


    public final static WorkReqFulfTypeData WorkReqFulfType_WRF_DEPLOYS = WorkReqFulfTypeData.newBuilder()
        .setDescription("Deploys")
        .setWorkReqFulfTypeId("WRF_DEPLOYS")
        .build();


    public final static WorkReqFulfTypeData WorkReqFulfType_WRF_TESTS = WorkReqFulfTypeData.newBuilder()
        .setDescription("Tests")
        .setWorkReqFulfTypeId("WRF_TESTS")
        .build();


    public final static WorkReqFulfTypeData WorkReqFulfType_WRF_DELIVERS = WorkReqFulfTypeData.newBuilder()
        .setDescription("Delivers")
        .setWorkReqFulfTypeId("WRF_DELIVERS")
        .build();


    public final static AllocationPlanTypeData AllocationPlanType_SALES_ORD_ALLOCATION = AllocationPlanTypeData.newBuilder()
        .setDescription("Sales Order Allocation Plan")
        .setHasTable(castIndicator("N"))
        .setPlanTypeId("SALES_ORD_ALLOCATION")
        .build();


    public final static OrderTypeData OrderType_PURCHASE_ORDER = OrderTypeData.newBuilder()
        .setDescription("Purchase")
        .setHasTable(castIndicator("N"))
        .setOrderTypeId("PURCHASE_ORDER")
        .build();


    public final static OrderTypeData OrderType_SALES_ORDER = OrderTypeData.newBuilder()
        .setDescription("Sales")
        .setHasTable(castIndicator("N"))
        .setOrderTypeId("SALES_ORDER")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_FINISHED_GOOD_CUSTOMER_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("CUSTOMER_RETURN")
        .setReturnItemMapKey("FINISHED_GOOD")
        .setReturnItemTypeId("RET_FPROD_ITEM")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_MARKETING_PKG_AUTO_CUSTOMER_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("CUSTOMER_RETURN")
        .setReturnItemMapKey("MARKETING_PKG_AUTO")
        .setReturnItemTypeId("RET_FPROD_ITEM")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_MARKETING_PKG_PICK_CUSTOMER_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("CUSTOMER_RETURN")
        .setReturnItemMapKey("MARKETING_PKG_PICK")
        .setReturnItemTypeId("RET_FPROD_ITEM")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_AGGREGATED_CONF_CUSTOMER_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("CUSTOMER_RETURN")
        .setReturnItemMapKey("AGGREGATED_CONF")
        .setReturnItemTypeId("RET_FPROD_ITEM")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_DIGITAL_GOOD_CUSTOMER_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("CUSTOMER_RETURN")
        .setReturnItemMapKey("DIGITAL_GOOD")
        .setReturnItemTypeId("RET_DPROD_ITEM")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_FINDIG_GOOD_CUSTOMER_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("CUSTOMER_RETURN")
        .setReturnItemMapKey("FINDIG_GOOD")
        .setReturnItemTypeId("RET_FDPROD_ITEM")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_RAW_MATERIAL_CUSTOMER_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("CUSTOMER_RETURN")
        .setReturnItemMapKey("RAW_MATERIAL")
        .setReturnItemTypeId("RET_RPROD_ITEM")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_PROMOTION_ADJUSTMENT_CUSTOMER_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("CUSTOMER_RETURN")
        .setReturnItemMapKey("PROMOTION_ADJUSTMENT")
        .setReturnItemTypeId("RET_PROMOTION_ADJ")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_REPLACE_ADJUSTMENT_CUSTOMER_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("CUSTOMER_RETURN")
        .setReturnItemMapKey("REPLACE_ADJUSTMENT")
        .setReturnItemTypeId("RET_REPLACE_ADJ")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_DISCOUNT_ADJUSTMENT_CUSTOMER_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("CUSTOMER_RETURN")
        .setReturnItemMapKey("DISCOUNT_ADJUSTMENT")
        .setReturnItemTypeId("RET_DISCOUNT_ADJ")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_FEE_CUSTOMER_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("CUSTOMER_RETURN")
        .setReturnItemMapKey("FEE")
        .setReturnItemTypeId("RET_FEE_ADJ")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_MISCELLANEOUS_CHARGE_CUSTOMER_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("CUSTOMER_RETURN")
        .setReturnItemMapKey("MISCELLANEOUS_CHARGE")
        .setReturnItemTypeId("RET_MISC_ADJ")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_SALES_TAX_CUSTOMER_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("CUSTOMER_RETURN")
        .setReturnItemMapKey("SALES_TAX")
        .setReturnItemTypeId("RET_SALES_TAX_ADJ")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_VAT_TAX_CUSTOMER_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("CUSTOMER_RETURN")
        .setReturnItemMapKey("VAT_TAX")
        .setReturnItemTypeId("RET_VAT_TAX_ADJ")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_VAT_PRICE_CORRECT_CUSTOMER_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("CUSTOMER_RETURN")
        .setReturnItemMapKey("VAT_PRICE_CORRECT")
        .setReturnItemTypeId("RET_VAT_PC_ADJ")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_SHIPPING_CHARGES_CUSTOMER_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("CUSTOMER_RETURN")
        .setReturnItemMapKey("SHIPPING_CHARGES")
        .setReturnItemTypeId("RET_SHIPPING_ADJ")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_SURCHARGE_ADJUSTMENT_CUSTOMER_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("CUSTOMER_RETURN")
        .setReturnItemMapKey("SURCHARGE_ADJUSTMENT")
        .setReturnItemTypeId("RET_SURCHARGE_ADJ")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_ADDITIONAL_FEATURE_CUSTOMER_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("CUSTOMER_RETURN")
        .setReturnItemMapKey("ADDITIONAL_FEATURE")
        .setReturnItemTypeId("RET_ADD_FEATURE_ADJ")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_WARRANTY_ADJUSTMENT_CUSTOMER_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("CUSTOMER_RETURN")
        .setReturnItemMapKey("WARRANTY_ADJUSTMENT")
        .setReturnItemTypeId("RET_WARRANTY_ADJ")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_RENTAL_ORDER_ITEM_CUSTOMER_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("CUSTOMER_RETURN")
        .setReturnItemMapKey("RENTAL_ORDER_ITEM")
        .setReturnItemTypeId("RET_FPROD_ITEM")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_ASSET_USAGE_OUT_IN_CUSTOMER_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("CUSTOMER_RETURN")
        .setReturnItemMapKey("ASSET_USAGE_OUT_IN")
        .setReturnItemTypeId("RET_FPROD_ITEM")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_SERVICE_PRODUCT_CUSTOMER_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("CUSTOMER_RETURN")
        .setReturnItemMapKey("SERVICE_PRODUCT")
        .setReturnItemTypeId("RET_SPROD_ITEM")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_SERVICE_CUSTOMER_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("CUSTOMER_RETURN")
        .setReturnItemMapKey("SERVICE")
        .setReturnItemTypeId("RET_SPROD_ITEM")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_FINISHED_GOOD_VENDOR_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("VENDOR_RETURN")
        .setReturnItemMapKey("FINISHED_GOOD")
        .setReturnItemTypeId("RET_FPROD_ITEM")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_MARKETING_PKG_AUTO_VENDOR_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("VENDOR_RETURN")
        .setReturnItemMapKey("MARKETING_PKG_AUTO")
        .setReturnItemTypeId("RET_FPROD_ITEM")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_MARKETING_PKG_PICK_VENDOR_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("VENDOR_RETURN")
        .setReturnItemMapKey("MARKETING_PKG_PICK")
        .setReturnItemTypeId("RET_FPROD_ITEM")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_AGGREGATED_CONF_VENDOR_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("VENDOR_RETURN")
        .setReturnItemMapKey("AGGREGATED_CONF")
        .setReturnItemTypeId("RET_FPROD_ITEM")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_DIGITAL_GOOD_VENDOR_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("VENDOR_RETURN")
        .setReturnItemMapKey("DIGITAL_GOOD")
        .setReturnItemTypeId("RET_DPROD_ITEM")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_FINDIG_GOOD_VENDOR_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("VENDOR_RETURN")
        .setReturnItemMapKey("FINDIG_GOOD")
        .setReturnItemTypeId("RET_FDPROD_ITEM")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_RAW_MATERIAL_VENDOR_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("VENDOR_RETURN")
        .setReturnItemMapKey("RAW_MATERIAL")
        .setReturnItemTypeId("RET_RPROD_ITEM")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_PROMOTION_ADJUSTMENT_VENDOR_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("VENDOR_RETURN")
        .setReturnItemMapKey("PROMOTION_ADJUSTMENT")
        .setReturnItemTypeId("RET_PROMOTION_ADJ")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_REPLACE_ADJUSTMENT_VENDOR_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("VENDOR_RETURN")
        .setReturnItemMapKey("REPLACE_ADJUSTMENT")
        .setReturnItemTypeId("RET_REPLACE_ADJ")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_DISCOUNT_ADJUSTMENT_VENDOR_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("VENDOR_RETURN")
        .setReturnItemMapKey("DISCOUNT_ADJUSTMENT")
        .setReturnItemTypeId("RET_DISCOUNT_ADJ")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_FEE_VENDOR_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("VENDOR_RETURN")
        .setReturnItemMapKey("FEE")
        .setReturnItemTypeId("RET_FEE_ADJ")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_MISCELLANEOUS_CHARGE_VENDOR_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("VENDOR_RETURN")
        .setReturnItemMapKey("MISCELLANEOUS_CHARGE")
        .setReturnItemTypeId("RET_MISC_ADJ")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_SALES_TAX_VENDOR_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("VENDOR_RETURN")
        .setReturnItemMapKey("SALES_TAX")
        .setReturnItemTypeId("RET_SALES_TAX_ADJ")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_VAT_TAX_VENDOR_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("VENDOR_RETURN")
        .setReturnItemMapKey("VAT_TAX")
        .setReturnItemTypeId("RET_VAT_TAX_ADJ")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_VAT_PRICE_CORRECT_VENDOR_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("VENDOR_RETURN")
        .setReturnItemMapKey("VAT_PRICE_CORRECT")
        .setReturnItemTypeId("RET_VAT_PC_ADJ")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_SHIPPING_CHARGES_VENDOR_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("VENDOR_RETURN")
        .setReturnItemMapKey("SHIPPING_CHARGES")
        .setReturnItemTypeId("RET_SHIPPING_ADJ")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_SURCHARGE_ADJUSTMENT_VENDOR_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("VENDOR_RETURN")
        .setReturnItemMapKey("SURCHARGE_ADJUSTMENT")
        .setReturnItemTypeId("RET_SURCHARGE_ADJ")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_ADDITIONAL_FEATURE_VENDOR_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("VENDOR_RETURN")
        .setReturnItemMapKey("ADDITIONAL_FEATURE")
        .setReturnItemTypeId("RET_ADD_FEATURE_ADJ")
        .build();


    public final static ReturnItemTypeMapData ReturnItemTypeMap_WARRANTY_ADJUSTMENT_VENDOR_RETURN = ReturnItemTypeMapData.newBuilder()
        .setReturnHeaderTypeId("VENDOR_RETURN")
        .setReturnItemMapKey("WARRANTY_ADJUSTMENT")
        .setReturnItemTypeId("RET_WARRANTY_ADJ")
        .build();


    public final static StatusTypeData StatusType_ORDER_STATUS = StatusTypeData.newBuilder()
        .setDescription("Order")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("ORDER_STATUS")
        .build();


    public final static StatusTypeData StatusType_ORDER_ITEM_STATUS = StatusTypeData.newBuilder()
        .setDescription("Order Item")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ORDER_STATUS")
        .setStatusTypeId("ORDER_ITEM_STATUS")
        .build();


    public final static StatusTypeData StatusType_PAYMENT_PREF_STATUS = StatusTypeData.newBuilder()
        .setDescription("Payment Preference")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("PAYMENT_PREF_STATUS")
        .build();


    public final static StatusTypeData StatusType_ORDER_DEL_SCH = StatusTypeData.newBuilder()
        .setDescription("Order Delivery Schedule")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("ORDER_DEL_SCH")
        .build();


    public final static StatusTypeData StatusType_ORDER_RETURN_STTS = StatusTypeData.newBuilder()
        .setDescription("Order Return Status For Customer Returns")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("ORDER_RETURN_STTS")
        .build();


    public final static StatusTypeData StatusType_PORDER_RETURN_STTS = StatusTypeData.newBuilder()
        .setDescription("Order Return Status For Supplier Returns")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("PORDER_RETURN_STTS")
        .build();


    public final static StatusTypeData StatusType_CUSTREQ_STTS = StatusTypeData.newBuilder()
        .setDescription("Custom Request Status")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("CUSTREQ_STTS")
        .build();


    public final static StatusTypeData StatusType_REQUIREMENT_STATUS = StatusTypeData.newBuilder()
        .setDescription("Requirement Status")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("REQUIREMENT_STATUS")
        .build();


    public final static StatusTypeData StatusType_QUOTE_STATUS = StatusTypeData.newBuilder()
        .setDescription("Quote Status")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("QUOTE_STATUS")
        .build();


    public final static StatusTypeData StatusType_ALLOC_PLAN_STATUS = StatusTypeData.newBuilder()
        .setDescription("Allocation Plan Status")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("ALLOC_PLAN_STATUS")
        .build();


    public final static StatusTypeData StatusType_ALLOC_PLAN_ITEM_STTS = StatusTypeData.newBuilder()
        .setDescription("Allocation Plan Item Status")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ALLOC_PLAN_STATUS")
        .setStatusTypeId("ALLOC_PLAN_ITEM_STTS")
        .build();


    public final static ShoppingListTypeData ShoppingListType_SLT_WISH_LIST = ShoppingListTypeData.newBuilder()
        .setDescription("Wish List")
        .setShoppingListTypeId("SLT_WISH_LIST")
        .build();


    public final static ShoppingListTypeData ShoppingListType_SLT_GIFT_REG = ShoppingListTypeData.newBuilder()
        .setDescription("Gift Registry")
        .setShoppingListTypeId("SLT_GIFT_REG")
        .build();


    public final static ShoppingListTypeData ShoppingListType_SLT_AUTO_REODR = ShoppingListTypeData.newBuilder()
        .setDescription("Automatic Re-Orders")
        .setShoppingListTypeId("SLT_AUTO_REODR")
        .build();


    public final static ShoppingListTypeData ShoppingListType_SLT_FREQ_PURCHASES = ShoppingListTypeData.newBuilder()
        .setDescription("Frequent Purchases")
        .setShoppingListTypeId("SLT_FREQ_PURCHASES")
        .build();


    public final static ShoppingListTypeData ShoppingListType_SLT_SPEC_PURP = ShoppingListTypeData.newBuilder()
        .setDescription("Special Purpose")
        .setShoppingListTypeId("SLT_SPEC_PURP")
        .build();


    public final static RequirementTypeData RequirementType_CUSTOMER_REQUIREMENT = RequirementTypeData.newBuilder()
        .setDescription("Customer Requirement")
        .setHasTable(castIndicator("N"))
        .setRequirementTypeId("CUSTOMER_REQUIREMENT")
        .build();


    public final static RequirementTypeData RequirementType_INTERNAL_REQUIREMENT = RequirementTypeData.newBuilder()
        .setDescription("Internal Requirement")
        .setHasTable(castIndicator("N"))
        .setRequirementTypeId("INTERNAL_REQUIREMENT")
        .build();


    public final static RequirementTypeData RequirementType_PRODUCT_REQUIREMENT = RequirementTypeData.newBuilder()
        .setDescription("Product Requirement")
        .setHasTable(castIndicator("N"))
        .setRequirementTypeId("PRODUCT_REQUIREMENT")
        .build();


    public final static RequirementTypeData RequirementType_WORK_REQUIREMENT = RequirementTypeData.newBuilder()
        .setDescription("Work Requirement")
        .setHasTable(castIndicator("N"))
        .setRequirementTypeId("WORK_REQUIREMENT")
        .build();


    public final static RequirementTypeData RequirementType_TRANSFER_REQUIREMENT = RequirementTypeData.newBuilder()
        .setDescription("Inter Facility Transfer Requirement")
        .setRequirementTypeId("TRANSFER_REQUIREMENT")
        .build();


    public final static ReturnReasonData ReturnReason_RTN_NOT_WANT = ReturnReasonData.newBuilder()
        .setDescription("Did Not Want Item")
        .setReturnReasonId("RTN_NOT_WANT")
        .setSequenceId("01")
        .build();


    public final static ReturnReasonData ReturnReason_RTN_DEFECTIVE_ITEM = ReturnReasonData.newBuilder()
        .setDescription("Defective Item")
        .setReturnReasonId("RTN_DEFECTIVE_ITEM")
        .setSequenceId("02")
        .build();


    public final static ReturnReasonData ReturnReason_RTN_MISSHIP_ITEM = ReturnReasonData.newBuilder()
        .setDescription("Mis-Shipped Item")
        .setReturnReasonId("RTN_MISSHIP_ITEM")
        .setSequenceId("03")
        .build();


    public final static ReturnReasonData ReturnReason_RTN_DIG_FILL_FAIL = ReturnReasonData.newBuilder()
        .setDescription("Digital Fulfillment Failed")
        .setReturnReasonId("RTN_DIG_FILL_FAIL")
        .setSequenceId("04")
        .build();


    public final static ReturnReasonData ReturnReason_RTN_COD_REJECT = ReturnReasonData.newBuilder()
        .setDescription("COD Payment Rejected")
        .setReturnReasonId("RTN_COD_REJECT")
        .setSequenceId("05")
        .build();


    public final static ReturnReasonData ReturnReason_RTN_SIZE_EXCHANGE = ReturnReasonData.newBuilder()
        .setDescription("Size Exchange")
        .setReturnReasonId("RTN_SIZE_EXCHANGE")
        .setSequenceId("06")
        .build();


    public final static ReturnReasonData ReturnReason_RTN_NORMAL_RETURN = ReturnReasonData.newBuilder()
        .setDescription("Normal Return")
        .setReturnReasonId("RTN_NORMAL_RETURN")
        .setSequenceId("07")
        .build();


    public final static OrderAdjustmentTypeData OrderAdjustmentType_PROMOTION_ADJUSTMENT = OrderAdjustmentTypeData.newBuilder()
        .setDescription("Promotion")
        .setHasTable(castIndicator("N"))
        .setOrderAdjustmentTypeId("PROMOTION_ADJUSTMENT")
        .build();


    public final static OrderAdjustmentTypeData OrderAdjustmentType_REPLACE_ADJUSTMENT = OrderAdjustmentTypeData.newBuilder()
        .setDescription("Replacement")
        .setHasTable(castIndicator("N"))
        .setOrderAdjustmentTypeId("REPLACE_ADJUSTMENT")
        .build();


    public final static OrderAdjustmentTypeData OrderAdjustmentType_DISCOUNT_ADJUSTMENT = OrderAdjustmentTypeData.newBuilder()
        .setDescription("Discount")
        .setHasTable(castIndicator("N"))
        .setOrderAdjustmentTypeId("DISCOUNT_ADJUSTMENT")
        .build();


    public final static OrderAdjustmentTypeData OrderAdjustmentType_DONATION_ADJUSTMENT = OrderAdjustmentTypeData.newBuilder()
        .setDescription("Donation")
        .setHasTable(castIndicator("N"))
        .setOrderAdjustmentTypeId("DONATION_ADJUSTMENT")
        .build();


    public final static OrderAdjustmentTypeData OrderAdjustmentType_FEE = OrderAdjustmentTypeData.newBuilder()
        .setDescription("Fee")
        .setHasTable(castIndicator("N"))
        .setOrderAdjustmentTypeId("FEE")
        .build();


    public final static OrderAdjustmentTypeData OrderAdjustmentType_MISCELLANEOUS_CHARGE = OrderAdjustmentTypeData.newBuilder()
        .setDescription("Miscellaneous Charges")
        .setHasTable(castIndicator("N"))
        .setOrderAdjustmentTypeId("MISCELLANEOUS_CHARGE")
        .build();


    public final static OrderAdjustmentTypeData OrderAdjustmentType_SALES_TAX = OrderAdjustmentTypeData.newBuilder()
        .setDescription("Sales Tax")
        .setHasTable(castIndicator("N"))
        .setOrderAdjustmentTypeId("SALES_TAX")
        .build();


    public final static OrderAdjustmentTypeData OrderAdjustmentType_VAT_TAX = OrderAdjustmentTypeData.newBuilder()
        .setDescription("VAT Tax (not added to totals)")
        .setHasTable(castIndicator("N"))
        .setOrderAdjustmentTypeId("VAT_TAX")
        .build();


    public final static OrderAdjustmentTypeData OrderAdjustmentType_VAT_PRICE_CORRECT = OrderAdjustmentTypeData.newBuilder()
        .setDescription("VAT Price Correction")
        .setHasTable(castIndicator("N"))
        .setOrderAdjustmentTypeId("VAT_PRICE_CORRECT")
        .build();


    public final static OrderAdjustmentTypeData OrderAdjustmentType_SHIPPING_CHARGES = OrderAdjustmentTypeData.newBuilder()
        .setDescription("Shipping and Handling")
        .setHasTable(castIndicator("N"))
        .setOrderAdjustmentTypeId("SHIPPING_CHARGES")
        .build();


    public final static OrderAdjustmentTypeData OrderAdjustmentType_SURCHARGE_ADJUSTMENT = OrderAdjustmentTypeData.newBuilder()
        .setDescription("Surcharge")
        .setHasTable(castIndicator("N"))
        .setOrderAdjustmentTypeId("SURCHARGE_ADJUSTMENT")
        .build();


    public final static OrderAdjustmentTypeData OrderAdjustmentType_ADDITIONAL_FEATURE = OrderAdjustmentTypeData.newBuilder()
        .setDescription("Additional Feature")
        .setHasTable(castIndicator("N"))
        .setOrderAdjustmentTypeId("ADDITIONAL_FEATURE")
        .build();


    public final static OrderAdjustmentTypeData OrderAdjustmentType_WARRANTY_ADJUSTMENT = OrderAdjustmentTypeData.newBuilder()
        .setDescription("Warranty")
        .setHasTable(castIndicator("N"))
        .setOrderAdjustmentTypeId("WARRANTY_ADJUSTMENT")
        .build();


    public final static OrderAdjustmentTypeData OrderAdjustmentType_MKTG_PKG_AUTO_ADJUST = OrderAdjustmentTypeData.newBuilder()
        .setDescription("Marketing Package Adjustment")
        .setHasTable(castIndicator("N"))
        .setOrderAdjustmentTypeId("MKTG_PKG_AUTO_ADJUST")
        .build();


    public final static OrderAdjustmentTypeData OrderAdjustmentType_DEPOSIT_ADJUSTMENT = OrderAdjustmentTypeData.newBuilder()
        .setDescription("Deposit")
        .setHasTable(castIndicator("N"))
        .setOrderAdjustmentTypeId("DEPOSIT_ADJUSTMENT")
        .build();


    public final static QuoteTypeData QuoteType_OTHER_QUOTE = QuoteTypeData.newBuilder()
        .setDescription("Other")
        .setHasTable(castIndicator("N"))
        .setQuoteTypeId("OTHER_QUOTE")
        .build();


    public final static QuoteTypeData QuoteType_PRODUCT_QUOTE = QuoteTypeData.newBuilder()
        .setDescription("Product")
        .setHasTable(castIndicator("N"))
        .setQuoteTypeId("PRODUCT_QUOTE")
        .build();


    public final static QuoteTypeData QuoteType_PROPOSAL = QuoteTypeData.newBuilder()
        .setDescription("Proposal")
        .setHasTable(castIndicator("N"))
        .setQuoteTypeId("PROPOSAL")
        .build();


    public final static QuoteTypeData QuoteType_PURCHASE_QUOTE = QuoteTypeData.newBuilder()
        .setDescription("Product Purchase")
        .setHasTable(castIndicator("N"))
        .setQuoteTypeId("PURCHASE_QUOTE")
        .build();


    public final static ReturnItemTypeData ReturnItemType_RET_NPROD_ITEM = ReturnItemTypeData.newBuilder()
        .setDescription("Return Non-Product Item")
        .setReturnItemTypeId("RET_NPROD_ITEM")
        .build();


    public final static ReturnItemTypeData ReturnItemType_RET_PROD_ITEM = ReturnItemTypeData.newBuilder()
        .setDescription("Return Product Item")
        .setReturnItemTypeId("RET_PROD_ITEM")
        .build();


    public final static ReturnItemTypeData ReturnItemType_RET_FPROD_ITEM = ReturnItemTypeData.newBuilder()
        .setDescription("Return Finished Good Item")
        .setParentTypeId("RET_PROD_ITEM")
        .setReturnItemTypeId("RET_FPROD_ITEM")
        .build();


    public final static ReturnItemTypeData ReturnItemType_RET_DPROD_ITEM = ReturnItemTypeData.newBuilder()
        .setDescription("Return Digital Good Item")
        .setParentTypeId("RET_PROD_ITEM")
        .setReturnItemTypeId("RET_DPROD_ITEM")
        .build();


    public final static ReturnItemTypeData ReturnItemType_RET_FDPROD_ITEM = ReturnItemTypeData.newBuilder()
        .setDescription("Return Finished/Digital Good Item")
        .setParentTypeId("RET_PROD_ITEM")
        .setReturnItemTypeId("RET_FDPROD_ITEM")
        .build();


    public final static ReturnItemTypeData ReturnItemType_RET_RPROD_ITEM = ReturnItemTypeData.newBuilder()
        .setDescription("Return Raw Material Good Item")
        .setParentTypeId("RET_PROD_ITEM")
        .setReturnItemTypeId("RET_RPROD_ITEM")
        .build();


    public final static ReturnItemTypeData ReturnItemType_RET_PROD_FEATR_ITEM = ReturnItemTypeData.newBuilder()
        .setDescription("Return Product-Feature Item")
        .setParentTypeId("RET_PROD_ITEM")
        .setReturnItemTypeId("RET_PROD_FEATR_ITEM")
        .build();


    public final static ReturnItemTypeData ReturnItemType_RET_SPROD_ITEM = ReturnItemTypeData.newBuilder()
        .setDescription("Return Service Product Item")
        .setParentTypeId("RET_PROD_ITEM")
        .setReturnItemTypeId("RET_SPROD_ITEM")
        .build();


    public final static ReturnItemTypeData ReturnItemType_RET_WE_ITEM = ReturnItemTypeData.newBuilder()
        .setDescription("Return Work-Effort Item")
        .setParentTypeId("RET_NPROD_ITEM")
        .setReturnItemTypeId("RET_WE_ITEM")
        .build();


    public final static ReturnItemTypeData ReturnItemType_RET_TE_ITEM = ReturnItemTypeData.newBuilder()
        .setDescription("Return Time-Entry Item")
        .setParentTypeId("RET_NPROD_ITEM")
        .setReturnItemTypeId("RET_TE_ITEM")
        .build();


    public final static ReturnItemTypeData ReturnItemType_RET_MPROD_ITEM = ReturnItemTypeData.newBuilder()
        .setDescription("Return Raw Material Item")
        .setParentTypeId("RET_PROD_ITEM")
        .setReturnItemTypeId("RET_MPROD_ITEM")
        .build();

}

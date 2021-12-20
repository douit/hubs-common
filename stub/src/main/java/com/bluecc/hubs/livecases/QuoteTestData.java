package com.bluecc.hubs.livecases;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.ProductStorePromoApplData;
import com.bluecc.hubs.stub.QuoteTermData;
import com.bluecc.hubs.stub.CustRequestData;
import com.bluecc.hubs.stub.ShoppingListFlatData;
import com.bluecc.hubs.stub.QuoteItemData;
import com.bluecc.hubs.stub.ShoppingListItemData;
import com.bluecc.hubs.stub.ProductPromoProductData;
import com.bluecc.hubs.stub.ProductPromoActionData;
import com.bluecc.hubs.stub.QuoteFlatData;
import com.bluecc.hubs.stub.ProductPromoData;
import com.bluecc.hubs.stub.ProductPromoRuleData;
import com.bluecc.hubs.stub.PartyAcctgPreferenceData;
import com.bluecc.hubs.stub.WorkEffortFlatData;
import com.bluecc.hubs.stub.QuoteAdjustmentData;
import com.bluecc.hubs.stub.CustRequestItemData;

public final class QuoteTestData {
    public static ProductStorePromoApplData ProductStorePromoAppl_9000_9010_() {
        return ProductStorePromoApplData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setProductPromoId("9010")
            .setProductStoreId("9000")
            .setSequenceNum(5)
            .build();
    }


    public static QuoteTermData QuoteTerm_FIN_PAYMENT_DISC_9000_00002() {
        return QuoteTermData.newBuilder()
            .setDescription("Update test term")
            .setQuoteId("9000")
            .setQuoteItemSeqId("00002")
            .setTermDays(5)
            .setTermTypeId("FIN_PAYMENT_DISC")
            .setTermValue(10)
            .setUomId("CNY")
            .build();
    }


    public static QuoteTermData QuoteTerm_FIN_PAYMENT_DISC_9000_00003() {
        return QuoteTermData.newBuilder()
            .setDescription("Delete test term")
            .setQuoteId("9000")
            .setQuoteItemSeqId("00003")
            .setTermDays(7)
            .setTermTypeId("FIN_PAYMENT_DISC")
            .setTermValue(5)
            .setUomId("CNY")
            .build();
    }


    public static CustRequestData CustRequest_9000() {
        return CustRequestData.newBuilder()
            .setCustRequestDate(getTimestamp("2008-07-28 09:45:31.928"))
            .setCustRequestId("9000")
            .setCustRequestName("Customer Request Usage")
            .setCustRequestTypeId("RF_QUOTE")
            .setDescription("Demo CustRequest")
            .setFromPartyId("DemoCustomer")
            .setPriority(9)
            .setProductStoreId("9000")
            .setStatusId("CRQ_ACCEPTED")
            .build();
    }


    public static ShoppingListFlatData ShoppingList_9000() {
        return ShoppingListFlatData.newBuilder()
            .setCurrencyUom("USD")
            .setIsActive(castIndicator("Y"))
            .setIsPublic(castIndicator("N"))
            .setListName("Test Shopping List")
            .setPartyId("DemoCustomer")
            .setProductStoreId("9000")
            .setShoppingListId("9000")
            .setShoppingListTypeId("SLT_WISH_LIST")
            .build();
    }


    public static QuoteItemData QuoteItem_9000_00001() {
        return QuoteItemData.newBuilder()
            .setProductId("GZ-1001")
            .setQuantity(getFixedPoint("1"))
            .setQuoteId("9000")
            .setQuoteItemSeqId("00001")
            .build();
    }


    public static QuoteItemData QuoteItem_9000_00002() {
        return QuoteItemData.newBuilder()
            .setProductId("GZ-2644")
            .setQuantity(getFixedPoint("1"))
            .setQuoteId("9000")
            .setQuoteItemSeqId("00002")
            .build();
    }


    public static QuoteItemData QuoteItem_9000_00003() {
        return QuoteItemData.newBuilder()
            .setProductId("GZ-1001")
            .setQuantity(getFixedPoint("1"))
            .setQuoteId("9000")
            .setQuoteItemSeqId("00003")
            .build();
    }


    public static QuoteItemData QuoteItem_9001_00001() {
        return QuoteItemData.newBuilder()
            .setProductId("GZ-1005")
            .setQuantity(getFixedPoint("1"))
            .setQuoteId("9001")
            .setQuoteItemSeqId("00001")
            .build();
    }


    public static ShoppingListItemData ShoppingListItem_9000_00001() {
        return ShoppingListItemData.newBuilder()
            .setProductId("SV-1001")
            .setQuantity(getFixedPoint("1.000000"))
            .setShoppingListId("9000")
            .setShoppingListItemSeqId("00001")
            .build();
    }


    public static ProductPromoProductData ProductPromoProduct_9010_01_01__NA__GZ_1005() {
        return ProductPromoProductData.newBuilder()
            .setProductId("GZ-1005")
            .setProductPromoActionSeqId("01")
            .setProductPromoApplEnumId("PPPA_INCLUDE")
            .setProductPromoCondSeqId("_NA_")
            .setProductPromoId("9010")
            .setProductPromoRuleId("01")
            .build();
    }


    public static ProductPromoProductData ProductPromoProduct_9010__NA___NA___NA__GZ_1006() {
        return ProductPromoProductData.newBuilder()
            .setProductId("GZ-1006")
            .setProductPromoActionSeqId("_NA_")
            .setProductPromoApplEnumId("PPPA_INCLUDE")
            .setProductPromoCondSeqId("_NA_")
            .setProductPromoId("9010")
            .setProductPromoRuleId("_NA_")
            .build();
    }


    public static ProductPromoActionData ProductPromoAction_9010_01_01() {
        return ProductPromoActionData.newBuilder()
            .setAmount(getFixedPoint("20.0"))
            .setOrderAdjustmentTypeId("PROMOTION_ADJUSTMENT")
            .setProductPromoActionEnumId("PROMO_PROD_DISC")
            .setProductPromoActionSeqId("01")
            .setProductPromoId("9010")
            .setProductPromoRuleId("01")
            .setQuantity(getFixedPoint("1.0"))
            .build();
    }


    public static QuoteFlatData Quote_9000() {
        return QuoteFlatData.newBuilder()
            .setCurrencyUomId("USD")
            .setIssueDate(getTimestamp("2009-12-11 12:00:00.000"))
            .setPartyId("DemoCustomer")
            .setProductStoreId("9000")
            .setQuoteId("9000")
            .setQuoteName("Most competitive quote ever")
            .setQuoteTypeId("PRODUCT_QUOTE")
            .setSalesChannelEnumId("EMAIL_SALES_CHANNEL")
            .setStatusId("QUO_CREATED")
            .setValidFromDate(getTimestamp("2009-12-11 12:00:00.000"))
            .build();
    }


    public static QuoteFlatData Quote_9001() {
        return QuoteFlatData.newBuilder()
            .setCurrencyUomId("USD")
            .setIssueDate(getTimestamp("2009-12-11 12:00:00.000"))
            .setPartyId("DemoCustomer")
            .setProductStoreId("9000")
            .setQuoteId("9001")
            .setQuoteName("Most competitive quote ever")
            .setQuoteTypeId("PRODUCT_QUOTE")
            .setSalesChannelEnumId("EMAIL_SALES_CHANNEL")
            .setStatusId("QUO_CREATED")
            .setValidFromDate(getTimestamp("2009-12-11 12:00:00.000"))
            .build();
    }


    public static ProductPromoData ProductPromo_9010() {
        return ProductPromoData.newBuilder()
            .setCreatedByUserLogin("admin")
            .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setLastModifiedByUserLogin("admin")
            .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setProductPromoId("9010")
            .setPromoName("Test Percent off product set ")
            .setPromoText("20% off any one item, either GZ-1005 (.NIT Gizmo) or GZ-1006 (Open Gizmo) with a limit of 1 per order")
            .setRequireCode(castIndicator("N"))
            .setShowToCustomer(castIndicator("Y"))
            .setUseLimitPerOrder(1)
            .setUserEntered(castIndicator("Y"))
            .build();
    }


    public static ProductPromoRuleData ProductPromoRule_9010_01() {
        return ProductPromoRuleData.newBuilder()
            .setProductPromoId("9010")
            .setProductPromoRuleId("01")
            .setRuleName("Test Percent off rule")
            .build();
    }


    public static PartyAcctgPreferenceData PartyAcctgPreference_DemoCustomer() {
        return PartyAcctgPreferenceData.newBuilder()
            .setPartyId("DemoCustomer")
            .setQuoteSeqCustMethId("QUOTE_HOOK_ENF_SEQ")
            .build();
    }


    public static WorkEffortFlatData WorkEffort_9007() {
        return WorkEffortFlatData.newBuilder()
            .setWorkEffortId("9007")
            .setWorkEffortName("Quote WorkEffort")
            .setWorkEffortTypeId("TASK")
            .build();
    }


    public static QuoteAdjustmentData QuoteAdjustment_9001() {
        return QuoteAdjustmentData.newBuilder()
            .setAmount(getCurrency("2"))
            .setQuoteAdjustmentId("9001")
            .setQuoteAdjustmentTypeId("SALES_TAX")
            .setQuoteId("9001")
            .setQuoteItemSeqId("00001")
            .build();
    }


    public static CustRequestItemData CustRequestItem_9000_00001() {
        return CustRequestItemData.newBuilder()
            .setCustRequestId("9000")
            .setCustRequestItemSeqId("00001")
            .setProductId("GZ-1001")
            .setStatusId("CRQ_ACCEPTED")
            .setStory("This can be the longer story of an item on the customer request.")
            .build();
    }

}

package com.bluecc.hubs.livecases;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.livecases.QuoteTestData.*;

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

public final class QuoteTestDataList {
    public static List<ProductStorePromoApplData> productStorePromoApplList() {
        return ImmutableList.of(        
            ProductStorePromoAppl_9000_9010_());
    }

    public static List<QuoteTermData> quoteTermList() {
        return ImmutableList.of(        
            QuoteTerm_FIN_PAYMENT_DISC_9000_00002(),        
            QuoteTerm_FIN_PAYMENT_DISC_9000_00003());
    }

    public static List<CustRequestData> custRequestList() {
        return ImmutableList.of(        
            CustRequest_9000());
    }

    public static List<ShoppingListFlatData> shoppingListList() {
        return ImmutableList.of(        
            ShoppingList_9000());
    }

    public static List<QuoteItemData> quoteItemList() {
        return ImmutableList.of(        
            QuoteItem_9000_00001(),        
            QuoteItem_9000_00002(),        
            QuoteItem_9000_00003(),        
            QuoteItem_9001_00001());
    }

    public static List<ShoppingListItemData> shoppingListItemList() {
        return ImmutableList.of(        
            ShoppingListItem_9000_00001());
    }

    public static List<ProductPromoProductData> productPromoProductList() {
        return ImmutableList.of(        
            ProductPromoProduct_9010_01_01__NA__GZ_1005(),        
            ProductPromoProduct_9010__NA___NA___NA__GZ_1006());
    }

    public static List<ProductPromoActionData> productPromoActionList() {
        return ImmutableList.of(        
            ProductPromoAction_9010_01_01());
    }

    public static List<QuoteFlatData> quoteList() {
        return ImmutableList.of(        
            Quote_9000(),        
            Quote_9001());
    }

    public static List<ProductPromoData> productPromoList() {
        return ImmutableList.of(        
            ProductPromo_9010());
    }

    public static List<ProductPromoRuleData> productPromoRuleList() {
        return ImmutableList.of(        
            ProductPromoRule_9010_01());
    }

    public static List<PartyAcctgPreferenceData> partyAcctgPreferenceList() {
        return ImmutableList.of(        
            PartyAcctgPreference_DemoCustomer());
    }

    public static List<WorkEffortFlatData> workEffortList() {
        return ImmutableList.of(        
            WorkEffort_9007());
    }

    public static List<QuoteAdjustmentData> quoteAdjustmentList() {
        return ImmutableList.of(        
            QuoteAdjustment_9001());
    }

    public static List<CustRequestItemData> custRequestItemList() {
        return ImmutableList.of(        
            CustRequestItem_9000_00001());
    }

}

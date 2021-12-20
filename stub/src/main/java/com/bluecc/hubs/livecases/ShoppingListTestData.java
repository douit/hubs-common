package com.bluecc.hubs.livecases;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.ShoppingListFlatData;
import com.bluecc.hubs.stub.ShoppingListItemData;

public final class ShoppingListTestData {
    public static ShoppingListFlatData ShoppingList_DemoWishList() {
        return ShoppingListFlatData.newBuilder()
            .setCurrencyUom("USD")
            .setIsActive(castIndicator("Y"))
            .setIsPublic(castIndicator("N"))
            .setListName("Demo Wish List")
            .setPartyId("DemoCustomer")
            .setProductStoreId("9000")
            .setShoppingListId("DemoWishList")
            .setShoppingListTypeId("SLT_WISH_LIST")
            .build();
    }


    public static ShoppingListItemData ShoppingListItem_DemoWishList_00001() {
        return ShoppingListItemData.newBuilder()
            .setProductId("GZ-2644")
            .setQuantity(getFixedPoint("5"))
            .setShoppingListId("DemoWishList")
            .setShoppingListItemSeqId("00001")
            .build();
    }


    public static ShoppingListItemData ShoppingListItem_DemoWishList_00002() {
        return ShoppingListItemData.newBuilder()
            .setProductId("WG-1111")
            .setQuantity(getFixedPoint("2"))
            .setShoppingListId("DemoWishList")
            .setShoppingListItemSeqId("00002")
            .build();
    }


    public static ShoppingListItemData ShoppingListItem_DemoWishList_00003() {
        return ShoppingListItemData.newBuilder()
            .setProductId("WG-5569")
            .setQuantity(getFixedPoint("10"))
            .setShoppingListId("DemoWishList")
            .setShoppingListItemSeqId("00003")
            .build();
    }

}

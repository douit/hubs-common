package com.bluecc.hubs.livecases;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.livecases.ShoppingListTestData.*;

import com.bluecc.hubs.stub.ShoppingListFlatData;
import com.bluecc.hubs.stub.ShoppingListItemData;

public final class ShoppingListTestDataList {
    public static List<ShoppingListFlatData> shoppingListList() {
        return ImmutableList.of(        
            ShoppingList_DemoWishList());
    }

    public static List<ShoppingListItemData> shoppingListItemList() {
        return ImmutableList.of(        
            ShoppingListItem_DemoWishList_00001(),        
            ShoppingListItem_DemoWishList_00002(),        
            ShoppingListItem_DemoWishList_00003());
    }

}

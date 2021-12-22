package com.bluecc.income.dao;

import com.bluecc.hubs.ProtoJsonUtils;
import com.bluecc.hubs.feed.LiveObjects;
import com.bluecc.hubs.stub.ShoppingListFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.model.ShoppingList;
import com.bluecc.income.model.ShoppingListItem;
import com.bluecc.income.types.AppKey;
import com.bluecc.income.types.LiveCodecObjects;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import org.redisson.api.RListMultimap;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.Locale;

import static com.bluecc.hubs.fund.Util.prettyFull;
import static com.bluecc.hubs.livecases.ShoppingListTestData.ShoppingListItem_DemoWishList_00001;
import static com.bluecc.hubs.livecases.ShoppingListTestData.ShoppingList_DemoWishList;
import static org.junit.Assert.assertEquals;

public class ShoppingListDelegatorTest extends AbstractStoreProcTest {
    @Inject
    ShoppingListDelegator shoppingLists;

    @Before
    public void setUp() throws Exception {
        setupEntities("ShoppingList");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId = sequence.nextStringId();
            ShoppingListFlatData flatData = ShoppingListFlatData.newBuilder()
                    .setShoppingListId(newId)
                    .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, shoppingLists.create(ctx, flatData));
            assertEquals(1, shoppingLists.update(ctx, flatData));
            assertEquals(1, shoppingLists.find(ctx, flatData).size());
            assertEquals(1, shoppingLists.findById(ctx, flatData).size());
            assertEquals(1, shoppingLists.delete(ctx, flatData));
            assertEquals(0, shoppingLists.find(ctx, flatData).size());
        });
    }

    // @Inject
    // LiveCodecObjects liveObjects;
    @Inject
    LiveObjects liveObjects;

    @Test
    public void createFromProto() {

        // add a shopping-list
        ShoppingList shoppingList = getShoppingList();
        String id = shoppingList.getShoppingListId();
        System.out.println(id + " ==> " + shoppingList);

        // add a item
        ShoppingListItem itemData = newShoppingListItem(id);
        System.out.println("will save ==>");
        prettyFull(itemData);

        ShoppingListItem item = liveObjects.persist(itemData);
        String itemId = item.getId();
        System.out.println("added item: " + itemId);

        ShoppingList o = liveObjects.get(ShoppingList.class, id);
        o.getRelShoppingListItem().add(item);

        // re-query it
        // o = liveObjects.getDetach(ShoppingList.class, id); // 为了正确反序列化
        o = liveObjects.get(ShoppingList.class, id);
        System.out.println("get shopping-list from live-object ==> " + o.getShoppingListId());
        prettyFull(o);

        item = liveObjects.get(ShoppingListItem.class, itemId);
        System.out.println("get shopping-list-item from live-object ==> " + item.getId());
        prettyFull(item);

        item = liveObjects.getService().detach(item);
        System.out.println("detach item ==> ");
        prettyFull(item);

        // o = liveObjects.getService().detach(o);  // ?? java.lang.NoSuchFieldException: No such field: Id
        // System.out.println(o);
        // toData操作会使用getter方法获取字段代理的值, toJson则是做具体的序列化
        System.out.println("== proto-json ==> "+ProtoJsonUtils.toJson(o.toData()));
        // == proto-json ==> {
        //   "shopping_list_id": "1472997935955390465",
        //   "shopping_list_type_id": "SLT_WISH_LIST",
        //   "product_store_id": "9000",
        //   "party_id": "DemoCustomer",
        //   "list_name": "Demo Wish List",
        //   "is_active": "YES",
        //   "currency_uom": "USD",
        //   "last_ordered_date": "1970-01-01T00:00:00Z",
        //   "last_admin_modified": "1970-01-01T00:00:00Z",
        //   "last_updated_tx_stamp": "2021-12-21T02:30:49.569Z",
        //   "created_tx_stamp": "1970-01-01T00:00:00Z"
        // }
    }

    private ShoppingListItem newShoppingListItem(String id) {
        ShoppingListItem itemData = ShoppingListItem
                .fromPrototype(ShoppingListItem_DemoWishList_00001())
                .id(sequence.nextStringId())
                .shoppingListId(id)
                .shoppingListItemSeqId("1")
                .build();
        return itemData;
    }

    private ShoppingList getShoppingList() {
        ShoppingListFlatData flatData = ShoppingList_DemoWishList();
        ShoppingList shoppingList = liveObjects.persist(ShoppingList.fromPrototype(flatData)
                .shoppingListId(sequence.nextStringId())
                .lastUpdatedStamp(LocalDateTime.now())
                        .lastUpdatedTxStamp(LocalDateTime.now())
                .build());
        return shoppingList;
    }

    static AppKey adminKey() {
        return new AppKey("default", "store", "admin");
    }

    @Test
    public void perssitWithAppKey() {
        RListMultimap<AppKey, ShoppingList> shoppingLists = liveObjects.redisson()
                .getListMultimap("shopping-list");
        shoppingLists.put(adminKey(), getShoppingList());

        shoppingLists.getAll(adminKey()).forEach(e -> {
            // prettyFull(e);
            // System.out.println("proto-json: "+ProtoJsonUtils.toJson(e.toData()));
            System.out.println("==> " + e.toData());
            System.out.println(".. " + e.getShoppingListTypeId()+", "+e.getLastUpdatedStamp());
        });
    }
}

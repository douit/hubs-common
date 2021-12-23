package com.bluecc.income.procs;

import com.bluecc.hubs.ProtoJsonUtils;
import com.bluecc.hubs.feed.LiveObjects;
import com.bluecc.hubs.fund.JsonString;
import com.bluecc.hubs.fund.Sequence;
import com.bluecc.hubs.stub.ShoppingListFlatData;
import com.bluecc.income.dao.ShoppingListDelegator;
import com.bluecc.income.exchange.GsonConverters;
import com.bluecc.income.exchange.IService;
import com.bluecc.income.model.ShoppingList;
import com.bluecc.income.model.ShoppingListItem;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.linecorp.armeria.server.annotation.*;
import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RAtomicLong;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

import static com.bluecc.hubs.livecases.ShoppingListTestData.ShoppingListItem_DemoWishList_00001;
import static com.bluecc.hubs.livecases.ShoppingListTestData.ShoppingList_DemoWishList;

@Slf4j
@Singleton
public class ShoppingCarts implements IService {
    @Data
    @AllArgsConstructor
    public static class ShoppingCart {
        String ownerId;
        ShoppingList shoppingList;
    }

    @Inject
    ShoppingListDelegator shoppingLists;
    @Inject
    LiveObjects liveObjects;
    @Inject
    protected Sequence sequence;
    @Inject
    Security security;

    Map<String, ShoppingCart> carts = Maps.newConcurrentMap();

    @Get("/carts/list/:shoppingListId")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public JsonString getShoppingListAsJson(@Param String shoppingListId) {
        log.info("get shopping-list '{}'", shoppingListId);
        ShoppingList o = liveObjects.get(ShoppingList.class, shoppingListId);
        log.info("shopping-list {} has {} items", shoppingListId, o.getRelShoppingListItem().size());
        Preconditions.checkNotNull(o, "Cannot get list %s from live-objects", shoppingListId);
        // return ProtoJsonUtils.toJsonString(o.toData());
        return ProtoJsonUtils.toJsonString(o.toHeadBuilder()
                .addAllShoppingListItem(
                        o.getRelShoppingListItem().stream().map(item -> item.toDataBuilder().build())
                                .collect(Collectors.toList()))
                .build());
    }

    @Data
    public static class ShopItem {
        String productId;
        String quantity;
    }

    @Post("/carts/items/new/:shoppingListId")
    @ProducesJson
    @RequestConverter(GsonConverters.GsonRequestConverter.class)
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public String newShoppingListItem(@Param String shoppingListId,
                                      ShopItem shopItem) {
        long seqId = liveObjects.getSeqId("shoppingCart");
        ShoppingListItem itemData = ShoppingListItem
                .fromPrototype(ShoppingListItem_DemoWishList_00001())
                .id(sequence.nextStringId())
                .productId(shopItem.productId)
                .quantity(new BigDecimal(shopItem.quantity))
                .shoppingListId(shoppingListId)
                .shoppingListItemSeqId(Long.toString(seqId))
                .build();
        ShoppingListItem item = liveObjects.persist(itemData);
        ShoppingList o = liveObjects.get(ShoppingList.class, shoppingListId);
        o.getRelShoppingListItem().add(item);
        return item.getId();
    }

    // headers: x-hubs-token
    @Post("/carts/list/new")
    @ProducesJson
    @RequestConverter(GsonConverters.GsonRequestConverter.class)
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public Try<String> newShoppingList(@Header String xHubsToken) {
        return Try.of(() -> {
            Preconditions.checkNotNull(xHubsToken, "Require token");
            String ownerId = getOwnerByToken(xHubsToken);
            Preconditions.checkNotNull(ownerId, "Invalid token: %s", xHubsToken);

            ShoppingListFlatData flatData = ShoppingList_DemoWishList();
            ShoppingList shoppingList = liveObjects.persist(ShoppingList.fromPrototype(flatData)
                    .partyId(ownerId)
                    .shoppingListId(sequence.nextStringId())
                    .lastUpdatedStamp(LocalDateTime.now())
                    .lastUpdatedTxStamp(LocalDateTime.now())
                    .build());

            carts.put(shoppingList.getShoppingListId(),
                    new ShoppingCart(ownerId, shoppingList));
            return shoppingList.getShoppingListId();
        });
    }

    private String getOwnerByToken(String xHubsToken) {
        Security.UserToken token = security.verifyToken(xHubsToken);
        return token.getOwnerId();
    }
}

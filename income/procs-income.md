## shell
```bash
> person=meta.getEntityMeta('Person')
> person.pk
```

## setup data
```bash
$ just i procs.SeedFiles  # store seed files: "order", "ecommerce"
$ just i procs.TypeEntityProcs  # 发布seed全部数据到redis

$ just i cli.DataDumper  # 转储proto-json数据
```

## annotations
```java
interface Services {
    @Get("/types/:name")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public GsonConverters.JsonString queryTypes(@Param String name) {
    }

    @Data
    public static class ShopItem{
        String productId;
        String quantity;
    }

    @Post("/carts/:shoppingListId/items")
    @ProducesJson
    @RequestConverter(GsonConverters.GsonRequestConverter.class)
    public String newShoppingListItem(@Param String shoppingListId, ShopItem shopItem) {
        
    }
}
```


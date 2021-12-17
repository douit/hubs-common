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

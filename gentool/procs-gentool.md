## start
```bash
$ just gen MetaTool OrderHeader OrderItem
$ just gen MetaTool -o Party
$ just gen MetaTool Shipment

# 生成protobuf messages和services
$ just gen ProtoTool -w
$ mvn compile -f stub/pom.xml
# or
$ just proto
$ just stub

$ just addon dataset/order/PartyGeoPointData.xml 
```
```bash
# gen all
$ just gen GeneratorMain  # sql(and types), protobuf(and types)
#$ just gen GenHeadEntities  # model-bean, dao
$ just gen ExternalTool  # sql, or: just sql
```

## deploy flows
1. (gentool) GeneratorMain
2. (apiset) just stub
3. (common) just sql
4. (income) SeedFiles



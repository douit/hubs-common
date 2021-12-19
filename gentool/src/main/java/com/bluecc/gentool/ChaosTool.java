package com.bluecc.gentool;

import com.bluecc.hubs.fund.*;
import com.bluecc.hubs.fund.descriptor.EntitySummaries;
import com.google.common.collect.*;
import com.google.gson.JsonObject;
import com.hubspot.jinjava.Jinjava;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

import static com.bluecc.gentool.Stereotypes.convertToStereotype;
import static com.bluecc.hubs.fund.SeedReader.collectEntityData;
import static com.bluecc.hubs.fund.descriptor.EntitySummaries.SUMMARY_CFG;

public class ChaosTool {

    Map<String, Set<String>> commonUses = Maps.newHashMap();

    void putCommonUse(String entity, String... fields) {
        for (String fld : fields) {
            Set<String> flds = commonUses.computeIfAbsent(entity, e -> new HashSet<>());
            flds.add(fld);
        }
    }

    public static void main(String[] args) throws IOException {
        // String dataFile="dataset/accounting/PaymentApplicationTestsData.xml";
        ChaosTool chaosTool = new ChaosTool();
        // System.out.println(chaosTool.gen(dataFile));

        String dataFile = "dataset/order/OrderDemoData.xml";
        // String dataFile="dataset/accounting/PaymentApplicationTestsData.xml";
        // String dataFile = "dataset/livecases/SalesOrder_DEMO10090.xml";
        // String dataFile="dataset/livecases/SalesOrderAccounting_DEMO1002.xml";
        chaosTool.deduceStereotypes(dataFile);

        // asset/facts/common_use.yml
        System.out.println("common-use for Product: " + chaosTool.commonUses.get("Product"));
        System.out.println("common-use for ProductPrice: " + chaosTool.commonUses.get("ProductPrice"));
        String cnt=Util.toYaml(
                new EntitySummaries.EntitySummary(
                        chaosTool.commonUses.entrySet()
                                .stream()
                                .map(e -> new EntitySummaries.CommonUse(e.getKey(), new ArrayList<>(e.getValue())))
                                .collect(Collectors.toList())
                )
        );
        Util.writeFile(cnt, SUMMARY_CFG);
    }

    AllMetas.EntityList entityList;

    ChaosTool() {
        entityList = AllMetas.EntityList.load();
    }

    public void deduceStereotypes(String dataFile) {
        Multimap<String, Stereotypes.Stereotype> dataMaps =
                getStereotypes(dataFile);
        // assertNotNull(dataMaps);
        System.out.println(dataMaps.keySet());

        List<String> result = Lists.newArrayList();
        for (String ent : dataMaps.keySet()) {
            String r = deduce(dataMaps, ent);
            if (r != null) {
                result.add(r);
            }
        }
        System.out.println("----------------- leaves");
        result.forEach(e -> System.out.println(e));
    }

    private String deduce(Multimap<String, Stereotypes.Stereotype> dataMaps, String ent) {
        System.out.println(ent + " --- ");
        Stereotypes.Stereotype ste = dataMaps
                .get(ent).stream().findFirst().get();
        // assertNotNull(ste);

        Set<String> fields = Sets.newHashSet(ste.fields.keySet()); // copy
        putCommonUse(ent, fields.toArray(new String[0]));
        // one
        ste.getFieldList().stream()
                .map(f -> Tuple2.of(f.meta.getName(),
                        ste.meta.findRelationsByField(f.meta.getName(),
                                        EntityMeta.REL_ONE).stream()
                                .map(r -> r.getName())
                                .collect(Collectors.toList())))
                .peek(t -> {
                    if (!t.f1.isEmpty()) {
                        fields.remove(t.f0);
                    }
                })
                .filter(t -> !t.f1.isEmpty())
                .forEach(e -> System.out.println("\t" + e));

        // nofk: 包含了那些已经确定了one关联的字段
        List<Tuple2<String, List<String>>> nofkRels = ste.getFieldList().stream()
                .map(f -> Tuple2.of(f.meta.getName(),
                        ste.meta.findRelationsByField(f.meta.getName(),
                                        EntityMeta.REL_ONE_NOFK).stream()
                                .map(r -> r.getName())
                                .collect(Collectors.toList())))
                .filter(t -> !t.f1.isEmpty())
                .peek(t -> System.out.format("\tnofk: %s -> %s\n", t.f0, t.f1))
                .collect(Collectors.toList());
        fields.removeAll(nofkRels.stream().map(t -> t.f0)
                .collect(Collectors.toSet()));

        // many: 这个相当于是array字段
        List<Tuple2<String, List<String>>> multiRels =
                fields.stream().map(f -> ste.meta.getField(f).get())
                        .map(f -> Tuple2.of(f.getName(),
                                ste.meta.findRelationsByField(f.getName(),
                                                EntityMeta.REL_ONE_NOFK).stream()
                                        .map(r -> r.getName())
                                        .collect(Collectors.toList())))
                        .filter(t -> !t.f1.isEmpty())
                        .peek(t -> System.out.format("\tmulti: %s -> %s\n", t.f0, t.f1))
                        .collect(Collectors.toList());
        fields.removeAll(multiRels.stream().map(t -> t.f0)
                .collect(Collectors.toSet()));


        // pk and slave-keys
        System.out.format("\tpk: %s\n", ste.meta.getPk());
        fields.remove(ste.meta.getPk());

        if (ste.meta.isCombine()) {
            Set<String> slaveKeys = fields.stream().filter(f -> ste.meta.getPks().contains(f))
                    .collect(Collectors.toSet());
            if (!slaveKeys.isEmpty()) {
                System.out.format("\tslave-keys: %s\n", slaveKeys);
                fields.removeAll(slaveKeys);
            }
        }

        // manual fields by name-filter and type-filter
        // System.out.println(fields);
        Set<String> manualFields = Sets.newHashSet("description",
                "packagingTypeCode");
        Set<String> containManualFields = fields.stream()
                .filter(f -> manualFields.contains(f)
                        || manualFields.stream()
                        .anyMatch(c -> f.toLowerCase().endsWith(c)))
                .collect(Collectors.toSet());
        if (fields.removeAll(containManualFields)) {
            System.out.println("\tmanual: " + containManualFields);
        }

        Set<String> manualTypeFields = fields.stream()
                .map(f -> ste.meta.getField(f).get())
                .filter(f -> f.isManualField())
                .map(f -> f.getName())
                .collect(Collectors.toSet());
        if (fields.removeAll(manualTypeFields)) {
            System.out.println("\tmanual-types: " + manualTypeFields);
        }

        // seq-id
        // Set<String> seqSuffix=Sets.newHashSet("SeqId");
        fields.removeAll(fields.stream()
                .filter(f -> f.endsWith("SeqId"))
                .peek(f -> System.out.println("\tseq field " + f))
                .collect(Collectors.toSet()));

        // measures
        Set<String> measureFlds = fields.stream().map(f -> ste.meta.getField(f).get())
                .filter(f -> f.isDateTimeField()
                        || f.isNumericField()
                        || f.isDecimalField()
                        || f.isIndicator())
                .map(f -> f.getName())
                .collect(Collectors.toSet());
        if (!measureFlds.isEmpty()) {
            System.out.println("\tmeasure: " + measureFlds);
            fields.removeAll(measureFlds);
        }

        // blobs
        Set<String> blobFlds = fields.stream().map(f -> ste.meta.getField(f).get())
                .filter(f -> f.isBlobField())
                .map(f -> f.getName())
                .collect(Collectors.toSet());
        if (!blobFlds.isEmpty()) {
            System.out.println("\tblob: " + blobFlds);
            fields.removeAll(blobFlds);
        }

        // raw text
        Set<String> rawTextFlds = fields.stream().map(f -> ste.meta.getField(f).get())
                .filter(f -> f.isRawTextField())
                .map(f -> f.getName())
                .collect(Collectors.toSet());
        if (!rawTextFlds.isEmpty()) {
            System.out.println("\traw-text: " + blobFlds);
            fields.removeAll(rawTextFlds);
        }

        // spec-auto-fields
        Map<String, String> autoUniques = ImmutableMap.of(
                "supplierProductId", "SupplierProduct",
                "partyTaxId", "PartyTaxAuthInfo"
        );
        for (String fldName : new ArrayList<>(fields)) {
            // if (fldName.equals("supplierProductId") && ent.equals("SupplierProduct")) {
            //     System.out.println("\tauto-unique: "+fldName);
            //     fields.remove("supplierProductId");
            // }
            if (autoUniques.containsKey(fldName)) {
                String ownerEnt = autoUniques.get(fldName);
                if (ent.equals(ownerEnt)) {
                    System.out.println("\tauto-unique: " + fldName);
                } else {
                    FieldComplementSpec relSpec = FieldComplementSpec.builder()
                            .type("one")
                            .relEntity(ownerEnt)
                            .name(fldName)
                            .relFieldName(fldName)
                            .build();
                    System.out.println("\trel-spec: " + relSpec);
                }
                fields.remove(fldName);
            }
        }

        // complement
        List<FieldComplementSpec> specs = fields.stream()
                .map(f -> ste.meta.getField(f).get())
                .map(f -> complementSpec(ent, f))
                .filter(f -> f != null)
                .peek(s -> System.out.format("\tcomplement %s: %s\n", s.name, s))
                .collect(Collectors.toList());

        fields.removeAll(specs.stream().map(s -> s.name).collect(Collectors.toSet()));

        // enums
        Map<String, Set<String>> enumTypes = ImmutableMap.of(
                "configItemTypeId", Sets.newHashSet("MULTIPLE", "SINGLE"),
                "configTypeId", Sets.newHashSet("QUESTION")
        );
        fields.removeAll(fields.stream().filter(f -> enumTypes.containsKey(f))
                .peek(f -> System.out.format("custom-enum %s: %s\n", f, enumTypes.get(f)))
                .collect(Collectors.toSet()));

        // deform fields
        Map<String, Set<String>> deformFields = ImmutableMap.of(
                "FacilityLocation",
                Sets.newHashSet("areaId", "positionId",
                        "levelId", "sectionId", "aisleId")
        );
        if (deformFields.containsKey(ent)) {
            Set<String> flds = deformFields.get(ent);
            fields.removeAll(fields.stream().filter(f ->
                            Objects.requireNonNull(flds).contains(f))
                    .peek(f -> System.out.format("deform-field %s\n", f))
                    .collect(Collectors.toSet()));
        }

        // ...
        if (fields.isEmpty()) {
            return null;
        }

        return ent + " leaves: " + fields.stream()
                .map(f -> String.format("%s: %s", f, ste.meta.getField(f).get().getType()))
                .collect(Collectors.toList());
    }

    @Data
    @Builder
    public static class FieldComplementSpec {
        String type;
        String name;
        String title;
        String relEntity;
        String relFieldName;
    }

    FieldComplementSpec complementSpec(String ent, EntityMeta.FieldMeta fld) {

        switch (fld.getName()) {
            // <relation type="one" fk-name="PROD_STR_RORDENUM" title="ReserveOrder" rel-entity-name="Enumeration">
            //         <key-map field-name="reserveOrderEnumId" rel-field-name="enumId"/>
            //       </relation>
            case "reserveOrderEnumId":
                return FieldComplementSpec.builder()
                        .type("one")
                        .name(fld.getName())
                        .title("ReserveOrder")
                        .relEntity("Enumeration")
                        .relFieldName("enumId")
                        .build();
            // <relation type="one" fk-name="SERVER_HIT_VISIT" rel-entity-name="Visit">
            //         <key-map field-name="visitId"/>
            //       </relation>
            case "visitId":
                return FieldComplementSpec.builder()
                        .type("one")
                        .relEntity("Visit")
                        .name(fld.getName())
                        .relFieldName(fld.getName())
                        .build();
            // <relation type="one" fk-name="PROD_CC_CATALOG" rel-entity-name="ProdCatalog">
            //         <key-map field-name="prodCatalogId"/>
            //       </relation>
            case "prodCatalogId":
                return FieldComplementSpec.builder()
                        .type("one")
                        .relEntity("ProdCatalog")
                        .name(fld.getName())
                        .relFieldName(fld.getName())
                        .build();
        }

        AllMetas.EntityInfo info = entityList.getInfoByKey(fld.getName());
        if (info != null) {
            return FieldComplementSpec.builder()
                    .type("one")
                    .relEntity(info.getName())
                    .name(fld.getName())
                    .relFieldName(fld.getName())
                    .build();
        }

        String fldName = fld.getName();
        if (fldName.endsWith("UserLogin")) {
            return FieldComplementSpec.builder()
                    .type("one")
                    .relEntity("UserLogin")
                    .name(fld.getName())
                    .relFieldName("userLoginId")
                    .build();
        } else if (fldName.endsWith("UomId")) {
            return FieldComplementSpec.builder()
                    .type("one")
                    .relEntity("Uom")
                    .name(fld.getName())
                    .relFieldName("uomId")
                    .build();
        }

        // if(ent.equals("SupplierProduct"))
        // supplierProductId可以作为SupplierProduct实体的唯一主键, 并能在OrderItem中引用
        if (fldName.equals("supplierProductId") && !ent.equals("SupplierProduct")) {
            return FieldComplementSpec.builder()
                    .type("one")
                    .relEntity("SupplierProduct")
                    .name(fldName)
                    .relFieldName(fldName)
                    .build();
        }

        return null;
    }

    ProtoMeta protoMeta = new ProtoMeta();
    Jinjava jinjava = TemplateUtil.getJinjava();

    String gen(String dataFile) throws IOException {

        Multimap<String, Stereotypes.Stereotype> typeMaps = getStereotypes(dataFile);

        System.out.format("total keys: %d, objects: %d\n",
                typeMaps.keySet().size(),
                typeMaps.values().size());

        String tplSource = IOUtils.toString(Objects.requireNonNull(
                        StereotypeTool.class.getResourceAsStream(
                                "/templates/stereotype_deduce.j2")),
                StandardCharsets.UTF_8);
        String result = jinjava.render(tplSource,
                ImmutableMap.of("objs", typeMaps.values()));

        return result;
    }

    public Multimap<String, Stereotypes.Stereotype> getStereotypes(String dataFile) {
        Multimap<String, JsonObject> dataList = ArrayListMultimap.create();
        collectEntityData(dataList, dataFile, true);

        //
        Set<String> idSet = Sets.newHashSet();

        Multimap<String, Stereotypes.Stereotype> typeMaps = ArrayListMultimap.create();
        for (String ent : dataList.keySet()) {
            EntityMeta meta = protoMeta.getEntityMeta(ent);
            for (JsonObject jo : dataList.get(ent)) {
                Stereotypes.Stereotype obj = convertToStereotype(jo, meta, idSet);
                if (obj != null) {
                    typeMaps.put(ent, obj);

                    // System.out.println(result);
                    // writer.write(result);
                    // elementDefs.add(result);
                }
            }
        }
        return typeMaps;
    }
}

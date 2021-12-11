package com.bluecc.gentool;

import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.Tuple2;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ChaosToolTest {
    ChaosTool chaosTool = new ChaosTool();
    String dataFile = "dataset/accounting/PaymentApplicationTestsData.xml";

    @Test
    public void getStereotypes() {
        Multimap<String, Stereotypes.Stereotype> dataMaps = chaosTool.getStereotypes(dataFile);
        assertNotNull(dataMaps);
        // System.out.println(dataMaps.keySet());

        String ent = "Invoice";

        // System.out.println(ent + " --- ");
        Stereotypes.Stereotype ste = dataMaps
                .get(ent).stream().findFirst().get();
        assertNotNull(ste);
        assertThat(ste.getFields()).containsKey("partyIdFrom");

        assertThat(ste.meta.findRelationsByField("partyIdFrom", EntityMeta.REL_ONE,
                        EntityMeta.REL_ONE_NOFK)
                .stream()
                .map(e -> e.getName())
                .collect(Collectors.toSet()))
                .contains("FromParty");
    }

    @Test
    public void deduceStereotypes() {
        Multimap<String, Stereotypes.Stereotype> dataMaps =
                chaosTool.getStereotypes(dataFile);
        assertNotNull(dataMaps);
        System.out.println(dataMaps.keySet());

        List<String> result= Lists.newArrayList();
        for (String ent : dataMaps.keySet()) {
            result.add(deduce(dataMaps, ent));
        }
        System.out.println("-----------------");
        result.forEach(e -> System.out.println(e));
    }

    private String deduce(Multimap<String, Stereotypes.Stereotype> dataMaps, String ent) {
        System.out.println(ent +" --- ");
        Stereotypes.Stereotype ste = dataMaps
                .get(ent).stream().findFirst().get();
        assertNotNull(ste);

        Set<String> fields= Sets.newHashSet(ste.fields.keySet()); // copy

        ste.getFieldList().stream()
                .map(f -> Tuple2.of(f.meta.getName(),
                        ste.meta.findRelationsByField(f.meta.getName(),
                                        EntityMeta.REL_ONE).stream()
                                .map(r -> r.getName())
                                .collect(Collectors.toList())))
                .peek(t -> {
                    if(!t.f1.isEmpty()) {
                        fields.remove(t.f0);
                    }
                })
                .forEach(e -> System.out.println("\t"+e));


        System.out.format("\tpk: %s\n", ste.meta.getPk());
        fields.remove(ste.meta.getPk());

        // System.out.println(fields);
        Set<String> manualFields=Sets.newHashSet("description");
        if(fields.removeAll(manualFields)) {
            System.out.println("\tmanual: " + manualFields);
        }

        // Set<String> seqSuffix=Sets.newHashSet("SeqId");
        fields.removeAll(fields.stream()
                .filter(f -> f.endsWith("SeqId"))
                        .peek(f -> System.out.println("\tseq field "+f))
                .collect(Collectors.toSet()));

        Set<String> measureFlds=fields.stream().map(f -> ste.meta.getField(f).get())
                .filter(f -> f.isDateTimeField()
                        ||f.isNumericField()
                        ||f.isDecimalField()
                        ||f.isIndicator())
                .map(f -> f.getName())
                .collect(Collectors.toSet());
        System.out.println("\tmeasure: "+measureFlds);
        fields.removeAll(measureFlds);

        Set<String> blobFlds=fields.stream().map(f -> ste.meta.getField(f).get())
                .filter(f -> f.isBlobField())
                .map(f -> f.getName())
                .collect(Collectors.toSet());
        System.out.println("\tblob: "+blobFlds);
        fields.removeAll(blobFlds);

        return ent +" leaves: "+fields.stream()
                .map(f -> String.format("%s: %s", f, ste.meta.getField(f).get().getType()))
                .collect(Collectors.toList());
    }

    @Test
    public void testOneNoFk(){
        // OrderAdjustment leaves: [productPromoRuleId: id]
        EntityMeta meta=chaosTool.protoMeta.getEntityMeta("OrderAdjustment");
        meta.findRelationsByField("productPromoRuleId", EntityMeta.REL_ONE)
                .forEach(r -> System.out.println(r.getName()));
        meta.findRelationsByField("productPromoRuleId", EntityMeta.REL_ONE_NOFK)
                .forEach(r -> System.out.println("nofk: "+r.getName()));
        meta.findRelationsByField("productPromoRuleId", EntityMeta.REL_MANY)
                .forEach(r -> System.out.println("many: "+r.getName()));
    }

    @Test
    public void testComplementSpec(){
        // <relation type="one" fk-name="PROD_STR_RORDENUM" title="ReserveOrder" rel-entity-name="Enumeration">
        //         <key-map field-name="reserveOrderEnumId" rel-field-name="enumId"/>
        //       </relation>

        // SupplierProduct leaves: [supplierProductId: id-long]
        EntityMeta meta=chaosTool.protoMeta.getEntityMeta("SupplierProduct");
        // Set<String> slaveKeys=fields.stream().filter(f -> meta.getPks().contains(f))
        //         .collect(Collectors.toSet());
        System.out.println(meta.getPks());
    }
}
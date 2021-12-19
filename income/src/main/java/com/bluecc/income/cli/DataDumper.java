package com.bluecc.income.cli;

import com.bluecc.hubs.fund.HeadEntityResources;
import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.hubs.fund.SystemDefs;
import com.bluecc.hubs.fund.Util;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.dao.ProductDelegator;
import com.bluecc.income.exchange.IDelegator;
import com.bluecc.income.procs.Buckets;
import com.bluecc.income.procs.Catalogs;
import com.bluecc.income.procs.SelectorBindings;

import javax.inject.Inject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.bluecc.hubs.fund.SystemDefs.prependHubsHomeFile;
import static com.bluecc.hubs.fund.Util.prettyFull;
import static com.bluecc.income.dummy.store.StoreModule.startup;
import static java.lang.String.format;

public class DataDumper {

    public static void main(String[] args) {
        DataDumper dataDumper=startup(DataDumper.class);
        dataDumper.dumpAll();
    }

    private final Map<String, IDelegator> delegators;
    // @Inject
    // Buckets buckets;
    @Inject
    DataDumper(Map<String, IDelegator> delegators){
        this.delegators=delegators;
    }

    public void dumpAll(){
        HeadEntityResources.allHeads().forEach(ent ->{
            // dump(ent+".json", buckets.serializeToString());
            System.out.println(".. dump "+ent);
            try {
                delegators.get(ent).serialize(QueryList.getDefaultInstance(),
                        new FileWriter(prependHubsHomeFile(format("dumps/%s.json", ent))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void dump(String fileName, String cnt){
        try {
            Util.writeFile(cnt, prependHubsHomeFile("dumps/"+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dumpJson(String fileName, Object obj){
        if(!fileName.endsWith(".json")){
            fileName=fileName+".json";
        }
        dump(fileName, Util.GSON_NO_EXCLUDE.toJson(obj));
    }


    public static class CatalogDumper {
        @Inject
        ProductDelegator productDelegator;
        @Inject
        Catalogs catalogs;
        @Inject
        ProtoMeta protoMeta;

        // catalog name, as "HotelFac", target file, as "productsInCatalog"
        public void dumpProductsInCatalog(String catalog, String targetFile) {
            productDelegator.process(c -> {
                DataDumper.dumpJson(targetFile,
                        productDelegator.chainQuery(c, "where pr.product_id in (<ids>)",
                                        SelectorBindings.stringList("ids",
                                                catalogs.getProductsInCatalog(c, catalog)),
                                        protoMeta.getInspectMeta("Product").getValidRelationNames())
                                .entrySet().stream().peek(entry -> {
                                    System.out.println(entry.getKey() + " ==> ");
                                    prettyFull(entry.getValue());
                                    // System.out.println(value.getRelProductPrice());
                                })
                                .map(entry -> entry.getValue())
                                .collect(Collectors.toList())
                );
            });
        }
    }
}

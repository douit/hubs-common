package com.bluecc.income.cli;

import com.bluecc.hubs.fund.HeadEntityResources;
import com.bluecc.hubs.fund.SystemDefs;
import com.bluecc.hubs.fund.Util;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.exchange.IDelegator;
import com.bluecc.income.procs.Buckets;

import javax.inject.Inject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import static com.bluecc.hubs.fund.SystemDefs.prependHubsHomeFile;
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
}

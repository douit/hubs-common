package com.bluecc.income.procs;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.fund.DataSetUtil;

import javax.inject.Inject;

import static com.bluecc.income.dummy.store.StoreModule.startup;

public class SeedFiles extends AbstractProcs{
    public static void main(String[] args) {
        SeedFiles seedFiles=startup(SeedFiles.class);
        seedFiles.setupSeedFiles();
    }

    @Inject
    protected GenericProcs genericProcs;
    void setupSeedFiles(){
        process(ctx ->{
            DataSetUtil.seedFiles().forEach(f -> {
                genericProcs.storeDataFile(ctx, f.getAbsolutePath());
            });
        });
    }
}

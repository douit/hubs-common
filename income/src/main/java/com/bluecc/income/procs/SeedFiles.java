package com.bluecc.income.procs;

import com.bluecc.hubs.fund.DataSetUtil;

import javax.inject.Inject;

import static com.bluecc.income.dummy.store.StoreModule.startup;

/**
 * $ just i procs.SeedFiles
 */
public class SeedFiles extends AbstractProcs{
    public static void main(String[] args) {
        SeedFiles seedFiles=startup(SeedFiles.class);
        long cost=seedFiles.setupSeedFiles();
        System.out.format("all ok, took %d ms.\n", cost);
        System.exit(0);
    }

    @Inject
    protected GenericProcs genericProcs;
    long setupSeedFiles(){
        long start=System.currentTimeMillis();
        process(ctx ->{
            DataSetUtil.seedFiles().forEach(f -> {
                genericProcs.storeDataFile(ctx, f.getAbsolutePath());
            });
        });
        return System.currentTimeMillis()-start;
    }
}

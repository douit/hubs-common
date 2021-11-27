package com.bluecc.income;

import com.bluecc.income.dummy.store.HubsStore;
import com.bluecc.income.exchange.IProc;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(GuiceTestRunner.class)
public class AbstractStoreProc {
    @Inject
    protected HubsStore hubsStore;

    protected void process(IProc proc){
        hubsStore.getJdbi().withHandle(handle -> {
            proc.proc(new IProc.ProcContext(handle));
           return null;
        });
    }

    protected void truncate(IProc.ProcContext ctx, String... tableNames) {
        for (String tableName : tableNames) {
            ctx.getHandle().execute("truncate " + tableName);
        }
    }

}


package com.bluecc.income;

import com.bluecc.income.dummy.store.HubsStore;
import com.bluecc.income.dummy.store.MemTestStore;
import com.bluecc.income.exchange.IProc;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(GuiceTestRunner.class)
public class AbstractMemStoreProc {
    @Inject
    protected MemTestStore store;

    protected void process(IProc proc){
        store.getJdbi().withHandle(handle -> {
            proc.proc(new IProc.ProcContext(handle));
           return null;
        });
    }
}


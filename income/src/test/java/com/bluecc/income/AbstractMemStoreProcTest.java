package com.bluecc.income;

import com.bluecc.hubs.fund.Sequence;
import com.bluecc.hubs.fund.model.IModel;
import com.bluecc.income.dummy.store.HubsStore;
import com.bluecc.income.dummy.store.MemTestStore;
import com.bluecc.income.exchange.IProc;
import com.bluecc.income.exchange.ResultSubscriber;
import org.junit.runner.RunWith;
import reactor.core.publisher.Flux;

import javax.inject.Inject;

@RunWith(GuiceTestRunner.class)
public class AbstractMemStoreProcTest {
    @Inject
    protected MemTestStore store;
    @Inject
    protected Sequence sequence;
    // protected void process(IProc proc){
    //     store.getJdbi().withHandle(handle -> {
    //         proc.proc(new IProc.ProcContext(handle));
    //        return null;
    //     });
    // }
    protected Flux<IModel> process(IProc proc){
        return store.getJdbi().withHandle(handle -> {
            ResultSubscriber<IModel> resultSubscriber=new ResultSubscriber<>();
            proc.proc(new IProc.ProcContext(handle, resultSubscriber));
            return Flux.fromIterable(resultSubscriber.getResult());
        });
    }
}


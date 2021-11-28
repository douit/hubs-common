package com.bluecc.income.procs;

import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.hubs.fund.Sequence;
import com.bluecc.hubs.fund.descriptor.INameSymbol;
import com.bluecc.income.dummy.store.HubsStore;
import com.bluecc.income.exchange.IProc;
import com.google.common.base.Preconditions;

import javax.inject.Inject;

public class AbstractProcs {
    @Inject
    protected HubsStore hubsStore;
    @Inject
    protected Sequence sequence;
    @Inject
    protected ProtoMeta protoMeta;

    protected void process(IProc proc) {
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

    public static String getPk(INameSymbol symbol) {
        return symbol.getTableKeys().size() > 1 ? "id" : symbol.getTableKeys().get(0);
    }

    protected static void assertEquals(Object o1, Object o2) {
        Preconditions.checkArgument(o1.equals(o2),
                "Expect %s, but %s", o1, o2);
    }

    protected static void assertNotNull(Object o){
        Preconditions.checkNotNull(o, "Object is null");
    }
}


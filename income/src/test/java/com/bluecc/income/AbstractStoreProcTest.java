package com.bluecc.income;

import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.hubs.fund.Sequence;
import com.bluecc.hubs.fund.SystemDefs;
import com.bluecc.hubs.fund.Util;
import com.bluecc.income.dummy.store.HubsStore;
import com.bluecc.income.exchange.IProc;
import com.bluecc.income.procs.GenericProcs;
import com.bluecc.income.template.TemplateGlobalContext;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.SqlLogger;
import org.jdbi.v3.core.statement.StatementContext;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(GuiceTestRunner.class)
public class AbstractStoreProcTest {
    @Inject
    protected HubsStore hubsStore;
    @Inject
    protected Sequence sequence;
    @Inject
    protected ProtoMeta protoMeta;
    @Inject
    protected GenericProcs genericProcs;

    public static final String sourceSalesOrder= SystemDefs
            .prependHubsHome( "dataset/sample/sales_order.xml");

    protected void process(IProc proc){
        hubsStore.getJdbi().withHandle(handle -> {
            proc.proc(new IProc.ProcContext(handle));
           return null;
        });
    }

    protected void truncate(IProc.ProcContext ctx, List<String> tableNames) {
        for (String tableName : tableNames) {
            ctx.getHandle().execute("truncate " + tableName);
        }
    }

    protected void truncate(IProc.ProcContext ctx, String... tableNames) {
        truncate(ctx, Arrays.asList(tableNames));
    }

    protected void setupEntities(String...entities){
        final Jdbi db = hubsStore.getJdbi();
        db.setSqlLogger(new SqlLogger() {
            @Override
            public void logBeforeExecution(StatementContext ctx) {
                System.out.println("sql -> " + ctx.getRawSql());
                System.out.println("\t" + ctx.getParsedSql().getSql());
                System.out.println("\t"+ctx.getBinding().toString());
            }
        });

        TemplateGlobalContext.getContext().preload(entities);
        process(c -> {
            truncate(c, Arrays.stream(entities).map(e ->
                    Util.toSnakecase(e)).collect(Collectors.toList()));
        });
    }

}


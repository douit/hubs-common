package com.bluecc.income.exchange;

import com.bluecc.hubs.proto.ProtoModule;
import com.bluecc.income.dummy.store.HubsStore;
import com.google.inject.Guice;
import com.google.inject.Injector;

import javax.inject.Inject;

public class StoreProcMain {
    private static final Injector injector = Guice
            .createInjector(new ProtoModule());
    public static void main(String[] args) {
        StoreProcMain main=injector.getInstance(StoreProcMain.class);
        main.personProcs();
    }

    @Inject
    protected HubsStore hubsStore;

    protected void process(IProc proc){
        hubsStore.getJdbi().withHandle(handle -> {
            proc.proc(new IProc.ProcContext(handle));
            return null;
        });
    }

    public void personProcs() {
        process(ctx -> {
            // truncate(ctx, "person");
            // Dao dao = c.getHandle().attach(// Dao.class);
            int r = ctx.getHandle().createUpdate("insert into <table> (<columns>) values (<placers>)")
                    .define("table", "person")
                    .defineList("columns", "party_id", "last_name")
                    .defineList("placers", ":party_id", ":last_name")
                    .bind("party_id", System.currentTimeMillis())
                    .bind("last_name", "tom")
                    .execute();
            System.out.println(r);

            ctx.getHandle().createQuery("select <columns> from <table>")
                    .define("table", "person")
                    .defineList("columns", "party_id", "last_name")
                    .mapToMap()
                    .list()
                    .forEach(e -> System.out.println(e));

        });
    }
}

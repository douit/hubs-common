package com.bluecc.income.exchange;

import com.bluecc.hubs.feed.ProtoModule;
import com.bluecc.hubs.fund.model.IModel;
import com.bluecc.hubs.fund.pubs.Action;
import com.bluecc.hubs.fund.pubs.Services;
import com.bluecc.income.dummy.store.HubsStore;
import com.bluecc.income.model.Person;
import com.google.inject.Guice;
import com.google.inject.Injector;
import reactor.core.publisher.Flux;

import javax.inject.Inject;
import java.util.List;
import java.util.function.Function;

import static com.bluecc.hubs.fund.Util.pretty;

@Services
public class StoreProcMain {
    private static final Injector injector = Guice
            .createInjector(new ProtoModule());

    public static void main(String[] args) {
        StoreProcMain main=injector.getInstance(StoreProcMain.class);
        main.personProcs().apply("test").subscribe(e -> pretty(e));
    }

    @Inject
    protected HubsStore hubsStore;

    protected Flux<IModel> process(IProc proc){
        return hubsStore.getJdbi().withHandle(handle -> {
            ResultSubscriber<IModel> resultSubscriber=new ResultSubscriber<>();
            proc.proc(new IProc.ProcContext(handle, resultSubscriber));
            return Flux.fromIterable(resultSubscriber.getResult());
        });
    }

    @Action
    public Function<String, Flux<IModel>> personProcs() {
        return input -> process(ctx -> {
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
                    .mapTo(Person.class)
                    .list()
                    .forEach(e -> ctx.getSubscriber().onNext(e));
            ctx.getSubscriber().onComplete();
        });
    }
}

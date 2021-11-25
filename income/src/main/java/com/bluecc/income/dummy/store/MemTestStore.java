package com.bluecc.income.dummy.store;

import com.bluecc.income.exchange.IStore;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.guava.GuavaPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MemTestStore extends AbstractStore {
    Jdbi jdbi;

    MemTestStore(){
        this.jdbi = Jdbi.create("jdbc:h2:mem:test"); // (H2 in-memory database)
        installPlugins();
        JdbiProcs.init(jdbi);
    }

    public Jdbi getJdbi() {
        return jdbi;
    }

    public void createTestTables(Handle handle) {
        handle.execute("create table something (" +
                "id identity primary key, name varchar(50), " +
                "integerValue integer, " +
                "intValue integer)");
    }

}

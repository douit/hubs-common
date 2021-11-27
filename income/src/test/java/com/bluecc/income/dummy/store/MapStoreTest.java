package com.bluecc.income.dummy.store;

import com.bluecc.income.AbstractMemStoreProc;
import com.bluecc.income.AbstractStoreProc;
import com.bluecc.income.exchange.IProc;
import lombok.Data;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.mapper.reflect.BeanMapper;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindMap;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;
import org.junit.Test;
import org.testcontainers.shaded.com.google.common.collect.ImmutableMap;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MapStoreTest extends AbstractMemStoreProc {
    @RegisterBeanMapper(value=Something.class)
    public interface Dao {
        @SqlUpdate("update something set name=:name where id=:id")
        void update(@Bind("id") int id, @BindMap Map<Object, Object> map);
        @SqlUpdate("insert into something (id, name) values (:id, :name)")
        void insert(@Bind("id") int id, @BindMap Map<Object, Object> map);
        @SqlQuery("select * from something where id=:id")
        Something get(@Bind("id") long id);
        @SqlQuery("select * from something where id=:id")
        @RegisterBeanMapper(value=SomethingBean.class)
        SomethingBean getWithBean(@Bind("id") long id);
    }

    @Data
    public static class SomethingBean {
        private int id;
        private String name;
        private Integer integerValue;
        private int intValue;
    }

    @Test
    public void testInsert() {
        process(c -> {
            store.createTestTables(c.getHandle());
            Dao dao = c.getHandle().attach(Dao.class);
            dao.insert(1, ImmutableMap.of("name", "samlet"));

            Map<String, Object> rec = findById(c.getHandle(), "something");
            System.out.println(rec);

            // System.out.println(dao.get(1));
            assertEquals(rec.get("name"), dao.get(1).getName());

            System.out.println(dao.getWithBean(1));
            assertEquals(rec.get("name"), dao.getWithBean(1).getName());
        });
    }

    private Map<String, Object> findById(Handle handle, String table) {
        Map<String, Object> rec = handle
                .createQuery("select * from <table> where id=:id")
                .define("table", table)
                .bind("id", 1)
                .mapToMap().one();
        return rec;
    }
}


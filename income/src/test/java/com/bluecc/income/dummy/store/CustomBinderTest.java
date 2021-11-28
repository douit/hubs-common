package com.bluecc.income.dummy.store;

import com.bluecc.income.AbstractMemStoreProcTest;
import com.bluecc.income.values.ColumnValues.DatabaseLongValue;
import com.bluecc.income.values.ColumnValues.DatabaseValue;
import com.bluecc.income.values.NumberArguments.BigIntNumberArgumentFactory;
import org.jdbi.v3.sqlobject.config.RegisterArgumentFactory;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindMethods;
import org.jdbi.v3.sqlobject.customizer.BindMethodsList;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomBinderTest extends AbstractMemStoreProcTest {

    @Test
    public void testPairRowDao() {
        process(c -> {
            c.getHandle().execute("CREATE TABLE bind_methods (id IDENTITY PRIMARY KEY, value BIGINT)");

            PairRowDAO dao = c.getHandle().attach(PairRowDAO.class);
            final long testValue = 707L;
            final int testId = 7;

            final DatabaseValue<?> dbVal = new DatabaseLongValue(testValue);
            final PairRow row = new PairRow(testId, dbVal);

            assertThat(dao.insert(row)).isEqualTo(1);
            assertThat(dao.getById(testId)).isEqualTo(testValue);
        });
    }

    public interface PairRowDAO {
        @SqlUpdate("INSERT INTO bind_methods (id, value) VALUES(:row.getKey, :row.getValue.getColumnValue)")
        @RegisterArgumentFactory(BigIntNumberArgumentFactory.class)
        int insert(@BindMethods("row") PairRow pairRow);

        @SqlQuery("SELECT value FROM bind_methods WHERE id = :id")
        Long getById(@Bind("id") int dbid);
    }

    public static final class PairRow {

        private final int id;
        private final DatabaseValue<?> value;

        PairRow(final int id, final DatabaseValue<?> value) {
            super();
            this.id = id;
            this.value = value;
        }

        public int getKey() {
            return this.id;
        }

        public DatabaseValue<?> getValue() {
            return this.value;
        }
    }

    @Test
    public void testThingDao() {
        process(c -> {
            c.getHandle().execute("create table thing (id identity primary key, foo varchar(50), bar varchar(50), baz varchar(50))");
            ThingDAO dao = c.getHandle().attach(ThingDAO.class);
            // final ThingDAO dao = this.h2Extension.getJdbi().onDemand(ThingDAO.class);

            // 按需实例具有开放式生命周期，因为它们为每个方法调用获取和释放连接。
            // 它们是线程安全的，可以在应用程序中重复使用。
            // ThingDAO dao = store.getJdbi().onDemand(ThingDAO.class);

            Thing thing1 = new Thing(1, "foo1", "bar1", "baz1");
            Thing thing2 = new Thing(2, "foo2", "bar2", "baz2");

            List<Thing> things = Arrays.asList(thing1, thing2);

            assertThat(dao.insert(things)).isEqualTo(things.size());
            assertThat(dao.getBazById(2)).isEqualTo("baz2");
        });
    }

    public interface ThingDAO {
        @SqlUpdate("insert into thing (id, foo, bar, baz) VALUES <items>")
        int insert(@BindMethodsList(value = "items", methodNames = {"getId", "getFoo", "getBar", "getBaz"}) Collection<Thing> thing);

        @SqlQuery("select baz from thing where id = :id")
        String getBazById(@Bind("id") int id);
    }

    public static class Thing {
        private int id;
        private String fooTest;
        private String barTest;
        private String bazTest;

        public Thing(int id, String fooTest, String barTest, String bazTest) {
            this.id = id;
            this.fooTest = fooTest;
            this.barTest = barTest;
            this.bazTest = bazTest;
        }

        public int getId() {
            return id;
        }

        public String getFoo() {
            return fooTest;
        }

        public String getBar() {
            return barTest;
        }

        public String getBaz() {
            return bazTest;
        }
    }
}

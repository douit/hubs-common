package com.bluecc.income.dummy.store;

import com.bluecc.income.AbstractMemStoreProcTest;
import com.bluecc.income.template.UseHubsTemplateEngine;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.SqlLogger;
import org.jdbi.v3.core.statement.StatementContext;
import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.customizer.TimestampedConfig;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.stringtemplate4.UseStringTemplateEngine;
import org.jdbi.v3.stringtemplate4.UseStringTemplateSqlLocator;
import org.junit.Before;
import org.junit.Test;

import java.time.ZoneOffset;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TemplateProcTest extends AbstractMemStoreProcTest {
    public interface Dao {
        @SqlQuery
        @UseStringTemplateSqlLocator
        List<Integer> findLocated(@Define("sort") boolean sort, @Define("sortBy") String sortBy);

        @SqlQuery("select id from something order by <if(sort)> <sortBy>, <endif> id")
        @UseStringTemplateEngine
        List<Integer> findInline(@Define("sort") boolean sort, @Define("sortBy") String sortBy);

        @SqlQuery("select id from something order by {% if sort %} {{sortBy}}, {% endif %} id")
        @UseHubsTemplateEngine
        List<Integer> findHubs(@Define("sort") boolean sort, @Define("sortBy") String sortBy);
    }

    private static final ZoneOffset GMT_PLUS_2 = ZoneOffset.ofHours(2);
    @Before
    public void setUp() throws Exception {
        final Jdbi db = store.getJdbi();
        db.getConfig(TimestampedConfig.class).setTimezone(GMT_PLUS_2);
        db.setSqlLogger(new SqlLogger() {
            @Override
            public void logBeforeExecution(StatementContext ctx) {
                System.out.println("sql -> "+ctx.getRawSql());
                System.out.println("\t"+ctx.getParsedSql().getSql());
            }
        });
    }

    @Test
    public void testDaoTemplate() {

        process(c -> {
            store.createTestTables(c.getHandle());
            c.getHandle().execute("insert into something (id, name) values (1, 'Martin')");
            c.getHandle().execute("insert into something (id, name) values (3, 'David')");
            c.getHandle().execute("insert into something (id, name) values (2, 'Joe')");

            Dao dao = c.getHandle().attach(Dao.class);
            List<Integer> ids = dao.findInline(true, "name");
            assertThat(ids).containsExactly(3, 2, 1);

            ids = dao.findHubs(true, "name");
            assertThat(ids).containsExactly(3, 2, 1);
        });
    }
}

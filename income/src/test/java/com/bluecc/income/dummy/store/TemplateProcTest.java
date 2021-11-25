package com.bluecc.income.dummy.store;

import com.bluecc.income.AbstractMemStoreProc;
import com.bluecc.income.AbstractStoreProc;
import com.bluecc.income.template.UseHubsTemplateEngine;
import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.stringtemplate4.UseStringTemplateEngine;
import org.jdbi.v3.stringtemplate4.UseStringTemplateSqlLocator;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TemplateProcTest extends AbstractMemStoreProc {
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

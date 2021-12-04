package com.bluecc.income.dummy.store;

import com.bluecc.hubs.fund.Util;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.stub.*;
import com.bluecc.income.AbstractOnceProcTest;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.exchange.IProc;
import com.github.javafaker.Faker;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.mapper.reflect.BeanMapper;
import org.jdbi.v3.core.statement.PreparedBatch;
import org.jdbi.v3.core.statement.StatementContext;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlBatch;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.bluecc.income.exchange.DataStoreHelper.queryMap;
import static java.lang.String.format;
import static org.junit.Assert.assertEquals;

public class StoreProcTest extends AbstractOnceProcTest {
    @RegisterRowMapper(PersonMapper.class)
    public interface PartyDao {
        @SqlQuery("select * from party where party_id=:id")
        @UseRowMapper(PartyMapper.class)
        PartyFlatData getFlat(@Bind("id") long id);

        @SqlQuery("select * from person")
        List<PersonFlatData> listPersons();

        @SqlBatch("INSERT INTO party (party_type_id) VALUES(?)")
        @GetGeneratedKeys
        List<Long> createParties(String... types);

        @SqlBatch("INSERT INTO person (party_id, last_name) VALUES(?, ?)")
            // @GetGeneratedKeys
            // @UseRowMapper(PersonMapper.class)
        void createPersons(List<Long> ids, String... names);

        @SqlBatch("INSERT INTO party_group (party_id, group_name) VALUES(?, ?)")
            // @GetGeneratedKeys
        void createPartyGroups(List<Long> ids, String... names);

        @SqlBatch("INSERT INTO contact_mech (contact_mech_type_id) VALUES(?)")
        @GetGeneratedKeys
        List<Long> createContactMechs(String... types);

        @SqlBatch("insert into postal_address (contact_mech_id, to_name, address1, address2) " +
                "values (:id, :addr.toName, :addr.address1, :addr.address2)")
        void bulkInsertPostalAddress(@Bind("id") List<Long> ids,
                                     @BindBean("addr") List<PostalAddressData> addressData);

    }

    public static class PartyMapper implements RowMapper<PartyFlatData> {
        @Override
        public PartyFlatData map(ResultSet r, StatementContext ctx) throws SQLException {
            return PartyFlatData.newBuilder()
                    .setPartyId(r.getString("party_id"))
                    .setPartyTypeId(r.getString("party_type_id"))
                    .build();
        }
    }

    public static class PersonMapper implements RowMapper<PersonFlatData> {
        @Override
        public PersonFlatData map(ResultSet r, StatementContext ctx) throws SQLException {
            return PersonFlatData.newBuilder()
                    .setPartyId(r.getString("party_id"))
                    .setLastName(r.getString("last_name"))
                    .build();
        }
    }

    static TypeSymbol getTypeSymbol(String typestr) {
        return TypeSymbol.newBuilder().setValueId(typestr).build();
    }

    @Test
    public void testPartyDao() {
        process(ctx -> {
            // ctx.getHandle().execute("insert into party (party_type_id) values ('PERSON')");
            int result = ctx.getHandle().createUpdate(
                    "insert into party (party_id, party_type_id) " +
                            "values (:id, :type)")
                    .bind("id", System.currentTimeMillis())
                    .bind("type", "PERSON")
                    .execute();
            System.out.println("result: " + result);
        });
    }

    @Test
    public void testList() {
        process(c -> {
            PartyDao dao = c.getHandle().attach(PartyDao.class);
            dao.listPersons().forEach(e -> System.out.println(e));
        });
    }
    @Test
    public void testCreatePartyDao() {
        process(c -> {
            truncate(c, "party", "person");

            PartyDao dao = c.getHandle().attach(PartyDao.class);
            // List<PersonFlatData> persons=dao.createPersons("Alice", "Bob", "Charlie");
            List<Long> ids = dao.createParties(times("PERSON", 3));
            dao.createPersons(ids, "Alice", "Bob", "Charlie");
            System.out.println(ids);
            assertEquals(3, ids.size());
            // insertParties(c, personIds, "PERSON");
        });
    }

    private String[] times(String s, int total) {
        String[] result = new String[total];
        for (int j = 0; j < total; j++) {
            result[j] = s;
        }
        return result;
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    String[] fakeGroups(int total) {
        String[] result = new String[total];
        for (int i = 0; i < total; i++) {
            result[i] = faker.company().name();
        }
        return result;
    }

    @Test
    public void testCreatePartyGroupDao() {
        process(c -> {
            truncate(c, "party", "party_group");

            int total = 5;
            PartyDao dao = c.getHandle().attach(PartyDao.class);

            List<Long> ids = dao.createParties(times("PARTY_GROUP", total));
            dao.createPartyGroups(ids, fakeGroups(total));
            System.out.println(ids);
            assertEquals(total, ids.size());
            // insertParties(c, ids, "PARTY_GROUP");

            PartyFlatData partyFlatData = dao.getFlat(ids.get(0));
            assertEquals("PARTY_GROUP", partyFlatData.getPartyTypeId());
        });
    }

    int[] insertParties(IProc.ProcContext ctx, List<Long> ids, String typeName) {
        PreparedBatch batch = ctx.getHandle().prepareBatch(
                "INSERT INTO party(party_id, party_type_id) VALUES(:id, :type)");
        ids.forEach(id -> batch.bind("id", id).bind("type", typeName).add());
        int[] counts = batch.execute();
        return counts;
    }

    @Test
    public void testContactMech() {
        process(c -> {
            PartyDao dao = c.getHandle().attach(PartyDao.class);
            List<Long> ids = dao.createContactMechs(times("POSTAL_ADDRESS", 2));
            String oneName = faker.name().name();
            dao.bulkInsertPostalAddress(ids, Lists.newArrayList(
                    PostalAddressData.newBuilder()
                            .setToName(oneName)
                            .setAddress1(faker.address().city())
                            .setAddress2(faker.address().fullAddress())
                            .build(),
                    PostalAddressData.newBuilder()
                            .setToName(faker.name().name())
                            .setAddress1(faker.address().city())
                            .setAddress2(faker.address().fullAddress())
                            .build()
            ));

            Map<String, Object> rec = queryAddressMap(c, ids);
            assertEquals(oneName, rec.get("to_name"));
            System.out.println(rec);

            rec = queryMap(c, EntityNames.ContactMech, ids.get(0));
            assertEquals("POSTAL_ADDRESS", getByFieldName(rec, "contactMechTypeId"));
            System.out.println(rec);
        });
    }

    Object getByFieldName(Map<String, Object> rec, String fieldName) {
        return rec.get(Util.toSnakecase(fieldName));
    }

    private Map<String, Object> queryAddressMap(IProc.ProcContext c, List<Long> ids) {
        Map<String, Object> rec = c.getHandle()
                .createQuery("select * from postal_address where contact_mech_id=:id")
                .bind("id", ids.get(0))
                .mapToMap().one();
        return rec;
    }

    @Test
    public void testQueryWithTemplate() {
        process(ctx -> {
            truncate(ctx, "person");
            // Dao dao = c.getHandle().attach(// Dao.class);
            int r = ctx.getHandle().createUpdate("insert into <table> (<columns>) values (<placers>)")
                    .define("table", "person")
                    .defineList("columns", "party_id", "last_name")
                    .defineList("placers", ":party_id", ":last_name")
                    .bind("party_id", 100)
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

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class User{
        String id;
        String name;
    }
    @Test
    public void testResultSetToMessage() {
        hubsStore.getJdbi().registerRowMapper(User.class,
                (rs, ctx) -> new User(rs.getString("party_id"),
                        rs.getString("last_name")));
        hubsStore.getJdbi().registerRowMapper(BeanMapper.factory(PersonData.Builder.class));

        process(c -> {
            // Dao dao = c.getHandle().attach(Dao.class);
            List<User> users = c.getHandle().createQuery(
                    "SELECT party_id, last_name FROM person ORDER BY party_id ASC")
                    .mapTo(User.class)
                    .list();
            System.out.println(users);

            List<PersonData.Builder> persons = c.getHandle().createQuery(
                            "SELECT party_id, last_name FROM person ORDER BY party_id ASC")
                    .mapTo(PersonData.Builder.class)
                    .list();
            System.out.println(persons);
        });
    }

    void mapToMessage(Map<String, Object> result){
    }

    public void testBuilder(){
        PersonData.Builder person=PersonData.newBuilder();
    }
}


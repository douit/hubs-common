package com.bluecc.income.dummy.store;

import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.hubs.stub.PersonFlatData;
import com.bluecc.income.AbstractStoreProc;
import com.bluecc.income.template.TemplateGlobalContext;
import com.bluecc.income.template.UseHubsTemplateEngine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.SqlLogger;
import org.jdbi.v3.core.statement.StatementContext;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.*;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.bluecc.hubs.ProtoTypes.*;
import static com.bluecc.hubs.fund.Util.pretty;
import static com.bluecc.income.exchange.MessageMapCollector.collect;
import static org.junit.Assert.assertEquals;

public class PartiesTest extends AbstractStoreProc {
    @RegisterBeanMapper(value=Person.class)
    public interface PartyDao {
        @SqlQuery("select * from person")
        List<Person> listPersons();
        @SqlQuery("select * from person where party_id=:id")
        Person getPerson(@Bind("id") String id);

        // @SqlUpdate("insert into {{Person.underscore}} {{Person.insertClause}}")
        // @UseHubsTemplateEngine
        // @Timestamped
        // void insertPerson(@BindBean PersonFlatData data);

        @SqlUpdate("insert into {{Person.underscore}} {{Person.insertClause}}")
        @UseHubsTemplateEngine
        @Timestamped
        void insertPerson(@BindBean Person data);

        @SqlUpdate("update {{Person.underscore}} set {{Person.updateClause}} where {{Person.pkCol}}=:id")
        @Timestamped
        @UseHubsTemplateEngine
        void updatePerson(@Bind("id") String id, @BindBean Person data);

        @SqlUpdate("delete from person where last_name = :it")
        void deleteByLastName(@Bind("it") String name);

        @UseHubsTemplateEngine
        @SqlUpdate("delete from person where  {{Person.pkCol}} = :it")
        void deletePersonById(@Bind("it") String id);

        @SqlQuery("select count(*) from person")
        int countPerson();
    }

    private static final ZoneOffset GMT_PLUS_2 = ZoneOffset.ofHours(2);
    @Before
    public void setUp() throws Exception {
        final Jdbi db = hubsStore.getJdbi();
        db.getConfig(TimestampedConfig.class).setTimezone(GMT_PLUS_2);
        db.setSqlLogger(new SqlLogger() {
            @Override
            public void logBeforeExecution(StatementContext ctx) {
                System.out.println("sql -> "+ctx.getRawSql());
                System.out.println("\t"+ctx.getParsedSql().getSql());
            }
        });

        TemplateGlobalContext.getContext().preload("Person");
    }

    @Test
    public void testInsertWithTemplate() {
        process(c -> {
            truncate(c, "person");

            PartyDao dao = c.getHandle().attach(PartyDao.class);
            // PersonFlatData flatData= PersonFlatData.newBuilder()
            //         .setPartyId(Long.toString(System.currentTimeMillis()))
            //         .setLastName("samlet")
            //         .setFirstName("wu")
            //         .build();
            // dao.insertPerson(flatData);

            // String id=Long.toString(System.currentTimeMillis());
            String id=sequence.nextStringId();
            LocalDate date = LocalDate.of(2001, 2, 1);
            // java.time.LocalTime
            Person flatData= Person.builder()
                    .partyId(id)
                    .lastName("samlet")
                    .firstName("wu")
                    .birthDate(date)
                    .passportExpireDate(LocalDateTime.now())
                    .gender('Y')
                    .build();
            dao.insertPerson(flatData);

            for (Person person : dao.listPersons()) {
                pretty(person);
            }
            assertEquals(id, dao.listPersons().get(0).getPartyId());

            // update
            flatData.setLastName("Lion");
            dao.updatePerson(id, flatData);

            assertEquals("Lion", dao.listPersons().get(0).getLastName());
            pretty(dao.listPersons().get(0));

            dao.deleteByLastName("Lion");
            assertEquals(0, dao.countPerson());

            dao.insertPerson(flatData);
            dao.deletePersonById(flatData.getPartyId());
            assertEquals(0, dao.countPerson());
        });
    }

    @Test
    public void testQueryWithTemplate() {
        process(ctx -> {
            truncate(ctx, "person");
            PartyDao dao = ctx.getHandle().attach(PartyDao.class);

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


            System.out.println("-----------");
            String newId=sequence.nextStringId();
            PersonFlatData flatData= PersonFlatData.newBuilder()
                    .setPartyId(newId)
                    .setLastName("samlet")
                    .setFirstName("wu")
                    .build();

            collect((c, e) -> {
                System.out.println("Ⓜ️ "+c.getSymbol()+" -> "+e);
                List<String> names= new ArrayList<>(e.keySet());
                List<String> placers = names.stream().map(name -> ":"+name)
                        .collect(Collectors.toList());
                int total = ctx.getHandle().createUpdate("insert into <table> (<columns>) values (<placers>)")
                        .define("table", c.getSymbol().getTable())
                        .defineList("columns", names)
                        .defineList("placers", placers)
                        .bindMap(e)
                        .execute();
                assertEquals(1, total);
                assertEquals("samlet", dao.getPerson(newId).getLastName());
            }).fillMap(flatData);
        });
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Person implements Serializable {
        private static final long serialVersionUID = 1L;

        String partyId;
        String salutation;
        String firstName;
        String middleName;
        String lastName;
        String personalTitle;
        String suffix;
        String nickname;
        String firstNameLocal;
        String middleNameLocal;
        String lastNameLocal;
        String otherLocal;
        String memberId;
        Character gender;
        java.time.LocalDate birthDate;
        java.sql.Date deceasedDate;
        Double height;
        Double weight;
        String mothersMaidenName;
        String oldMaritalStatus;
        String maritalStatusEnumId;
        String socialSecurityNumber;
        String passportNumber;
        java.time.LocalDateTime passportExpireDate;
        Double totalYearsWorkExperience;
        String comments;
        String employmentStatusEnumId;
        String residenceStatusEnumId;
        String occupation;
        Long yearsWithEmployer;
        Long monthsWithEmployer;
        String existingCustomer;
        String cardId;
        // java.sql.Timestamp lastUpdatedStamp;
        // java.sql.Timestamp lastUpdatedTxStamp;
        // java.sql.Timestamp createdStamp;
        // java.sql.Timestamp createdTxStamp;
        private java.time.LocalDateTime lastUpdatedStamp;
        private java.time.LocalDateTime createdStamp;

        public PersonFlatData toFlatData(){
            return PersonFlatData.newBuilder()
                    .setPartyId(partyId)
                    .setLastName(lastName)
                    .setFirstName(firstName)
                    .build();
        }

        public static Person fromFlatData(PersonFlatData data){
            return Person.builder()
                    .partyId(data.getPartyId())
                    .lastName(data.getLastName())
                    .firstName(data.getFirstName())
                    .birthDate(getLocalDate(data.getBirthDate()))
                    .passportExpireDate(getLocalDateTime(data.getPassportExpireDate()))
                    .gender(getIndicatorChar(data.getGender()))
                    .build();
        }
    }

}

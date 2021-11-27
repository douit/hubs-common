package com.bluecc.income.dummy.store;

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
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.BindMap;
import org.jdbi.v3.sqlobject.customizer.Timestamped;
import org.jdbi.v3.sqlobject.customizer.TimestampedConfig;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Map;

import static com.bluecc.hubs.fund.Util.pretty;
import static org.junit.Assert.assertEquals;

public class PartiesTest extends AbstractStoreProc {
    @RegisterBeanMapper(value=Person.class)
    public interface PartyDao {
        @SqlQuery("select * from person")
        List<Person> listPersons();

        @SqlUpdate("insert into {{Person.underscore}} {{Person.insertClause}}")
        @UseHubsTemplateEngine
        @Timestamped
        void insertPerson(@BindBean PersonFlatData data);

        @SqlUpdate("insert into {{Person.underscore}} {{Person.insertClause}}")
        @UseHubsTemplateEngine
        @Timestamped
        void insertPerson(@BindBean Person data);
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

            String id=Long.toString(System.currentTimeMillis());
            Person flatData= Person.builder()
                    .partyId(id)
                    .lastName("samlet")
                    .firstName("wu")
                    .build();
            dao.insertPerson(flatData);

            for (Person person : dao.listPersons()) {
                pretty(person);
            }
            assertEquals(id, dao.listPersons().get(0).getPartyId());
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
        String gender;
        java.sql.Date birthDate;
        java.sql.Date deceasedDate;
        Double height;
        Double weight;
        String mothersMaidenName;
        String oldMaritalStatus;
        String maritalStatusEnumId;
        String socialSecurityNumber;
        String passportNumber;
        java.sql.Date passportExpireDate;
        Double totalYearsWorkExperience;
        String comments;
        String employmentStatusEnumId;
        String residenceStatusEnumId;
        String occupation;
        Long yearsWithEmployer;
        Long monthsWithEmployer;
        String existingCustomer;
        String cardId;
        java.sql.Timestamp lastUpdatedStamp;
        java.sql.Timestamp lastUpdatedTxStamp;
        java.sql.Timestamp createdStamp;
        java.sql.Timestamp createdTxStamp;

    }

}

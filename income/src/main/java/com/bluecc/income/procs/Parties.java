package com.bluecc.income.procs;

import com.bluecc.hubs.stub.PersonFlatData;
import com.bluecc.income.exchange.IProc;
import com.bluecc.income.template.UseHubsTemplateEngine;
import com.google.common.base.Preconditions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.Timestamped;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.bluecc.hubs.ProtoTypes.*;
import static com.bluecc.hubs.fund.Util.pretty;
import static com.bluecc.income.dummy.store.StoreModule.startup;
import static com.bluecc.income.exchange.MessageMapCollector.collect;

public class Parties extends AbstractProcs {
    public static void main(String[] args) {
        Parties parties = startup(Parties.class);
        parties.crudSample();
    }

    void crudSample() {
        process(ctx -> {
            truncate(ctx, "person");
            PartyDao dao = ctx.getHandle().attach(PartyDao.class);

            System.out.println("-----------");
            String newId = sequence.nextStringId();
            PersonFlatData flatData = PersonFlatData.newBuilder()
                    .setPartyId(newId)
                    .setLastName("samlet")
                    .setFirstName("wu")
                    .build();
            storePerson(ctx, flatData);

            Person person=dao.getPerson(newId);
            Preconditions.checkNotNull(person);
            pretty(person);
        });
    }

    public void storePerson(IProc.ProcContext ctx, PersonFlatData flatData) {
        collect((c, e) -> {
            System.out.println("Ⓜ️ " + c.getSymbol() + " -> " + e);
            List<String> names = new ArrayList<>(e.keySet());
            List<String> placers = names.stream().map(name -> ":" + name)
                    .collect(Collectors.toList());
            int total = ctx.getHandle().createUpdate("insert into <table> (<columns>) values (<placers>)")
                    .define("table", c.getSymbol().getTable())
                    .defineList("columns", names)
                    .defineList("placers", placers)
                    .bindMap(e)
                    .execute();
            assertEquals(1, total);
        }).fillMap(flatData);
    }

    @RegisterBeanMapper(value = Person.class)
    public interface PartyDao {
        @SqlQuery("select * from person")
        List<Person> listPersons();

        @SqlQuery("select * from person where party_id=:id")
        Person getPerson(@Bind("id") String id);

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

        public PersonFlatData toFlatData() {
            return PersonFlatData.newBuilder()
                    .setPartyId(partyId)
                    .setLastName(lastName)
                    .setFirstName(firstName)
                    .build();
        }

        public static Person fromFlatData(PersonFlatData data) {
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



package com.bluecc.income.dao;

import com.bluecc.income.procs.AbstractProcs;
import com.bluecc.income.model.Person;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

public class PersonDelegator extends AbstractProcs{

    @RegisterBeanMapper(value = Person.class)
    public interface PersonDao {
        @SqlQuery("select * from person")
        List<Person> listPerson();
        @SqlQuery("select * from person where party_id=:id")
        Person getPerson(@Bind("id") String id);

        @SqlQuery("select count(*) from person")
        int countPerson();
    }

}

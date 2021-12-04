package com.bluecc.income.dao;

import com.bluecc.income.procs.AbstractProcs;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;
import java.util.Set;
import com.bluecc.income.model.*;
import com.bluecc.income.helper.ModelWrapper;

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

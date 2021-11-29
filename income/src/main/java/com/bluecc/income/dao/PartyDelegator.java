package com.bluecc.income.dao;

import com.bluecc.income.procs.AbstractProcs;
import com.bluecc.income.model.Party;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

public class PartyDelegator extends AbstractProcs{

    @RegisterBeanMapper(value = Party.class)
    public interface PartyDao {
        @SqlQuery("select * from party")
        List<Party> listParty();
        @SqlQuery("select * from party where party_id=:id")
        Party getParty(@Bind("id") String id);

        @SqlQuery("select count(*) from party")
        int countParty();
    }

}

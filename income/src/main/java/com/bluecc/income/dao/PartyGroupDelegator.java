package com.bluecc.income.dao;

import com.bluecc.income.procs.AbstractProcs;
import com.bluecc.income.model.PartyGroup;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

public class PartyGroupDelegator extends AbstractProcs{

    @RegisterBeanMapper(value = PartyGroup.class)
    public interface PartyGroupDao {
        @SqlQuery("select * from party_group")
        List<PartyGroup> listPartyGroup();
        @SqlQuery("select * from party_group where party_id=:id")
        PartyGroup getPartyGroup(@Bind("id") String id);

        @SqlQuery("select count(*) from party_group")
        int countPartyGroup();
    }

}

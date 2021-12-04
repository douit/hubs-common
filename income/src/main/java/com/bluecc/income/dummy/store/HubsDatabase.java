package com.bluecc.income.dummy.store;

import com.bluecc.hubs.ProtoJsonUtils;
import com.bluecc.hubs.stub.PersonFlatData;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.bluecc.hubs.ProtoJsonUtils.toJson;

public class HubsDatabase {
    public static void main(String[] args) {
        MysqlTestFac fac=new MysqlTestFac();
        Jdbi jdbi = Jdbi.create(fac.getDataSource());

        List<PersonFlatData> rs=queryPerson(jdbi);
        rs.forEach(e -> System.out.println(toJson(e)));
    }

    public static class PersonFlatMapper implements RowMapper<PersonFlatData> {
        @Override
        public PersonFlatData map(ResultSet rs, StatementContext ctx) throws SQLException {
            return PersonFlatData.newBuilder().setPartyId(
                    String.valueOf(rs.getLong("party_id")))
                    .setLastName(rs.getString("last_name"))
                    .setFirstName(rs.getString("first_name"))
                    .build();
        }
    }

    static List<PersonFlatData> queryPerson(Jdbi jdbi){
        return jdbi.withHandle(handle -> {
            List<PersonFlatData> ds = handle.createQuery(
                    "select * from person")
                    .map(new PersonFlatMapper())
                    .list();
            return ds;
        });
    }
}

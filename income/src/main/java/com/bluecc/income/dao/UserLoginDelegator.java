package com.bluecc.income.dao;

import com.bluecc.income.procs.AbstractProcs;
import com.bluecc.income.model.UserLogin;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

public class UserLoginDelegator extends AbstractProcs{

    @RegisterBeanMapper(value = UserLogin.class)
    public interface UserLoginDao {
        @SqlQuery("select * from user_login")
        List<UserLogin> listUserLogin();
        @SqlQuery("select * from user_login where user_login_id=:id")
        UserLogin getUserLogin(@Bind("id") String id);

        @SqlQuery("select count(*) from user_login")
        int countUserLogin();
    }

}

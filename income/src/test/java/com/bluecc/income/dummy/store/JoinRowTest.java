package com.bluecc.income.dummy.store;

import com.bluecc.income.AbstractMemStoreProc;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import org.assertj.core.api.Assertions;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.mapper.JoinRow;
import org.jdbi.v3.core.mapper.JoinRowMapper;
import org.jdbi.v3.core.mapper.reflect.BeanMapper;
import org.jdbi.v3.core.mapper.reflect.ColumnName;
import org.jdbi.v3.sqlobject.GenerateSqlObject;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.BindFields;
import org.jdbi.v3.sqlobject.statement.SqlBatch;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.tuple;
import static org.assertj.guava.api.Assertions.assertThat;


public class JoinRowTest extends AbstractMemStoreProc {
    @Test
    public void testJoinRowProc() {
        process(c -> {
            Handle handle = c.getHandle();
            handle.execute("create table contacts (id int, name text)");
            handle.execute("create table phones (id int, contact_id int, name text, number text)");

            handle.execute("insert into contacts (id, name) values (?, ?)", 1, "Alice");
            handle.execute("insert into phones (id, contact_id, name, number) values (?, ?, ?, ?)",
                    100, 1, "Home", "555-1212");
            handle.execute("insert into phones (id, contact_id, name, number) values (?, ?, ?, ?)",
                    101, 1, "Work", "555-9999");

            // tag::beanMapperPrefix[]
            handle.registerRowMapper(BeanMapper.factory(ContactBean.class, "c"));
            handle.registerRowMapper(BeanMapper.factory(PhoneBean.class, "p"));
            handle.registerRowMapper(JoinRowMapper.forTypes(ContactBean.class, PhoneBean.class));
            List<JoinRow> contactPhones = handle.select("select "
                            + "c.id cid, c.name cname, "
                            + "p.id pid, p.name pname, p.number pnumber "
                            + "from contacts c left join phones p on c.id = p.contact_id")
                    .mapTo(JoinRow.class)
                    .list();
            // end::beanMapperPrefix[]

            Assertions.assertThat(contactPhones)
                    .extracting(cp -> cp.get(ContactBean.class), cp -> cp.get(PhoneBean.class))
                    .containsExactly(
                            tuple(new ContactBean(1, "Alice"), new PhoneBean(100, "Home", "555-1212")),
                            tuple(new ContactBean(1, "Alice"), new PhoneBean(101, "Work", "555-9999")));

            ContactBean contactBean=contactPhones.get(0).get(ContactBean.class);
            System.out.println(contactBean);

        });
    }

    @Test
    public void testBaz() {
        process(c -> {
            c.getHandle().execute("create table baz (baz array)");
            BazDao dao = c.getHandle().attach(BazDao.class);

            final Baz baz1 = new Baz(1, 2, 3);
            dao.insert(baz1);
            final Baz baz2 = new Baz(2, 3, 4);
            dao.insert(baz2);

            Assertions.assertThat(dao.list())
                    .containsExactlyInAnyOrder(baz1, baz2);
        });
    }

    /*
    Jdbi 包括一个实验性的 SqlObject 代码生成器。如果您将jdbi3-generator工件包含
    为注释处理器并使用 注释您的 SqlObject 定义@GenerateSqlObject，
    则生成器将生成一个实现类并避免使用Proxy实例。这可能对graal-native 编译有用。
     */
    // @GenerateSqlObject
    @RegisterConstructorMapper(Baz.class)
    interface BazDao {
        @SqlUpdate("insert into baz (baz) values (:baz)")
        void insert(@BindFields Baz value);

        @SqlQuery("select baz from baz")
        List<Baz> list();
    }

    public static class Baz {
        public Baz(@ColumnName("baz") final int... baz) {
            this.baz = IntStream.of(baz)
                    .boxed()
                    .collect(Collectors.toList());
        }

        public final List<Integer> baz;

        @Override
        public int hashCode() {
            return baz.hashCode();
        }

        @Override
        public boolean equals(final Object obj) {
            return obj instanceof Baz && Objects.equals(((Baz) obj).baz, baz);
        }
    }

    @Test
    public void multimapJoin() {
        process(c -> {
            JoinRowDao dao = c.getHandle().attach(JoinRowDao.class);
            dao.createUserTable();
            dao.createPhoneTable();

            dao.insertUsers(
                    new User(1, "alice"),
                    new User(2, "bob"),
                    new User(3, "cathy"));
            dao.insertPhone(1, new Phone(10, "555-0001"), new Phone(11, "555-0021"));
            dao.insertPhone(2, new Phone(20, "555-0002"), new Phone(21, "555-0022"));
            dao.insertPhone(3, new Phone(30, "555-0003"), new Phone(31, "555-0023"));

            // FAIL:
            // Verify that the Java compiler is configured to emit parameter names,
            // that your result set has the columns expected, annotate the parameter
            // names explicitly with @ColumnName, or annotate nullable parameters as @Nullable
            // 解决方案: 手工在构造函数上加入@ColumnName

            assertThat(dao.getMultimap()).hasSameEntriesAs(
                    ImmutableMultimap.<User, Phone>builder()
                            .putAll(new User(1, "alice"),
                                    new Phone(10, "555-0001"),
                                    new Phone(11, "555-0021"))
                            .putAll(new User(2, "bob"),
                                    new Phone(20, "555-0002"),
                                    new Phone(21, "555-0022"))
                            .putAll(new User(3, "cathy"),
                                    new Phone(30, "555-0003"),
                                    new Phone(31, "555-0023"))
                            .build());

            // 因为是一对多, 所以无法用map
            // Map<User, Phone> ds=dao.getMap();
            // System.out.println(ds);

        });
    }

    public interface JoinRowDao {
        @SqlUpdate("create table user (id int, name varchar)")
        void createUserTable();

        @SqlUpdate("create table phone (id int, user_id int, phone varchar)")
        void createPhoneTable();

        @SqlBatch("insert into user (id, name) values (:id, :name)")
        void insertUsers(@BindBean User... users);

        // @SqlBatch("insert into phone (id, user_id, phone) values (:id, :userId, :phone)")
        // void insertPhone(int userId, @BindBean Phone... phones);
        @SqlBatch("insert into phone (id, user_id, phone) values (:id, :userId, :phone)")
        void insertPhone(@Bind("userId") int userId, @BindBean Phone... phones);

        // tag::joinRow[]
        @SqlQuery("select u.id u_id, u.name u_name, p.id p_id, p.phone p_phone "
                + "from user u left join phone p on u.id = p.user_id")
        @RegisterConstructorMapper(value = User.class, prefix = "u")
        @RegisterConstructorMapper(value = Phone.class, prefix = "p")
        Map<User, Phone> getMap();
        // end::joinRow[]

        // tag::joinRowMultimap[]
        @SqlQuery("select u.id u_id, u.name u_name, p.id p_id, p.phone p_phone "
                + "from user u left join phone p on u.id = p.user_id")
        @RegisterConstructorMapper(value = User.class, prefix = "u")
        @RegisterConstructorMapper(value = Phone.class, prefix = "p")
        Multimap<User, Phone> getMultimap();
        // end::joinRowMultimap[]

    }

    public static class User {
        private final int id;
        private final String name;

        public User(@ColumnName("id")int id,
                    @ColumnName("name")String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public String toString() {
            return "User{"
                    + "id=" + id
                    + ", name='" + name + '\''
                    + '}';
        }
    }

    public static class Phone {
        private final int id;
        private final String phone;

        public Phone(@ColumnName("id")int id, @ColumnName("phone")String phone) {
            this.id = id;
            this.phone = phone;
        }

        public int getId() {
            return id;
        }

        public String getPhone() {
            return phone;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Phone phone1 = (Phone) o;
            return id == phone1.id
                    && Objects.equals(phone, phone1.phone);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, phone);
        }

        @Override
        public String toString() {
            return "Phone{"
                    + "id=" + id
                    + ", phone='" + phone + '\''
                    + '}';
        }
    }
}

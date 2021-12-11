package com.bluecc.income.dummy.liveobjects;

import com.bluecc.income.AbstractRemoteTest;
import org.junit.Test;
import org.redisson.api.RLiveObjectService;
import org.redisson.api.RMap;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.annotation.REntity;
import org.redisson.api.annotation.RId;
import org.redisson.api.annotation.RIndex;
import org.redisson.api.condition.Condition;
import org.redisson.api.condition.Conditions;
import org.redisson.liveobject.resolver.UUIDGenerator;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.bluecc.hubs.fund.Util.pretty;
import static org.assertj.core.api.Assertions.assertThat;

public class LiveObjectTest extends AbstractRemoteTest{

    @REntity
    public static class TestEnum implements Serializable {

        public enum MyEnum {A, B}

        @RId
        private String id;
        private MyEnum myEnum1;
        private MyEnum myEnum2;

        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }

        public MyEnum getMyEnum1() {
            return myEnum1;
        }
        public void setMyEnum1(MyEnum myEnum1) {
            this.myEnum1 = myEnum1;
        }

        public MyEnum getMyEnum2() {
            return myEnum2;
        }
        public void setMyEnum2(MyEnum myEnum2) {
            this.myEnum2 = myEnum2;
        }

    }

    @REntity
    public static class TestREntity implements Comparable<TestREntity>, Serializable {

        @RId
        private String name;
        private String value;

        protected TestREntity() {
        }

        public TestREntity(String name) {
            this.name = name;
        }

        public TestREntity(String name, String value) {
            super();
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public int compareTo(TestREntity o) {
            int res = name.compareTo(o.name);
            if (res == 0) {
                return value.compareTo(o.value);
            }
            return res;
        }
    }

    @REntity
    public static class TestREntityWithRMap implements Comparable<TestREntityWithRMap>, Serializable {

        @RId
        private String name;
        private RMap value;

        protected TestREntityWithRMap() {
        }

        public TestREntityWithRMap(String name) {
            this.name = name;
        }

        public TestREntityWithRMap(String name, RMap value) {
            super();
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public RMap getValue() {
            return value;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setValue(RMap value) {
            this.value = value;
        }

        @Override
        public int compareTo(TestREntityWithRMap o) {
            int res = name.compareTo(o.name);
            if (res == 0 || value != null || o.value != null) {
                if (value.getName() == null) {
                    return -1;
                }
                return value.getName().compareTo(o.value.getName());
            }
            return res;
        }
    }

    @REntity
    public static class TestREntityWithMap implements Comparable<TestREntityWithMap>, Serializable {

        @RId(generator = UUIDGenerator.class)
        private String name;
        private Map value;

        public TestREntityWithMap() {
        }

        public TestREntityWithMap(String name) {
            this.name = name;
        }

        public TestREntityWithMap(String name, Map value) {
            super();
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public Map getValue() {
            return value;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setValue(Map value) {
            this.value = value;
        }

        @Override
        public int compareTo(TestREntityWithMap o) {
            return name.compareTo(o.name);
        }
    }

    @REntity
    public static class TestREntityIdNested implements Comparable<TestREntityIdNested>, Serializable {

        @RId
        private TestREntity name;
        private String value;

        public TestREntityIdNested(TestREntity name) {
            this.name = name;
        }

        public TestREntityIdNested(TestREntity name, String value) {
            super();
            this.name = name;
            this.value = value;
        }

        public TestREntity getName() {
            return name;
        }

        public String getValue() {
            return value;
        }

        public void setName(TestREntity name) {
            this.name = name;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public int compareTo(TestREntityIdNested o) {
            int res = name.compareTo(o.name);
            if (res == 0 || value != null || o.value != null) {
                return value.compareTo(o.value);
            }
            return res;
        }
    }

    @REntity
    public static class TestREntityValueNested implements Comparable<TestREntityValueNested>, Serializable {

        @RId
        private String name;
        private TestREntityWithRMap value;

        protected TestREntityValueNested() {
        }

        public TestREntityValueNested(String name) {
            this.name = name;
        }

        public TestREntityValueNested(String name, TestREntityWithRMap value) {
            super();
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public TestREntityWithRMap getValue() {
            return value;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setValue(TestREntityWithRMap value) {
            this.value = value;
        }

        @Override
        public int compareTo(TestREntityValueNested o) {
            int res = name.compareTo(o.name);
            if (res == 0 || value != null || o.value != null) {
                return value.compareTo(o.value);
            }
            return res;
        }
    }

    @REntity
    public static class TestIndexed implements Serializable {

        @RId
        private String id;
        @RIndex
        private String name1;
        @RIndex
        private String name2;
        @RIndex
        private Integer num1;
        @RIndex
        private Boolean bool1;
        @RIndex
        private TestIndexed obj;
        @RIndex
        private int num2;

        protected TestIndexed() {
        }

        public TestIndexed(String id) {
            super();
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public Boolean getBool1() {
            return bool1;
        }
        public void setBool1(Boolean bool1) {
            this.bool1 = bool1;
        }

        public String getName1() {
            return name1;
        }
        public void setName1(String name1) {
            this.name1 = name1;
        }

        public Integer getNum1() {
            return num1;
        }
        public void setNum1(Integer num1) {
            this.num1 = num1;
        }

        public TestIndexed getObj() {
            return obj;
        }
        public void setObj(TestIndexed obj) {
            this.obj = obj;
        }

        public String getName2() {
            return name2;
        }

        public void setName2(String name2) {
            this.name2 = name2;
        }

        public int getNum2() {
            return num2;
        }

        public void setNum2(int num2) {
            this.num2 = num2;
        }
    }

    @Test
    public void testIndexedPersist() {
        RLiveObjectService liveObjectService = redisson.getLiveObjectService();
        TestIndexed item1 = new TestIndexed("1");
        item1.setName1("testnma");
        item1.setName2("gfgfgf");
        item1.setNum1(123);

        TestIndexed item2 = new TestIndexed("2");

        List<TestIndexed> s = liveObjectService.persist(item1, item2);
        assertThat(s.get(0).getId()).isEqualTo(item1.getId());
        assertThat(s.get(1).getId()).isEqualTo(item2.getId());

        redisson.shutdown();
    }

    @Test
    public void testFindIn() {
        RLiveObjectService s = redisson.getLiveObjectService();
        TestIndexed t1 = new TestIndexed("1");
        t1.setNum1(1);
        t1.setName1("common");
        t1.setName2("value1");
        t1 = s.persist(t1);

        TestIndexed t2 = new TestIndexed("2");
        t2.setNum1(1);
        t2.setName1("common");
        t2.setName2("value2");
        t2 = s.persist(t2);

        TestIndexed t3 = new TestIndexed("3");
        t3.setNum1(1);
        t3.setName1("common");
        t3.setName2("value3");
        t3 = s.persist(t3);

        RScoredSortedSet<Object> t = redisson.getScoredSortedSet("redisson_live_object_index:{org.redisson.RedissonLiveObjectServiceTest$TestIndexed}:num2");
        assertThat(t).hasSize(3);

        Collection<TestIndexed> objects2 = s.find(TestIndexed.class, Conditions.and(
                Conditions.in("num1", 1, 2),
                Conditions.in("name2", "value1", "value2")));
        assertThat(objects2).hasSize(2);
        for (TestIndexed testIndexed : objects2) {
            assertThat(testIndexed.getId()).isIn("1", "2");
        }
    }

    @Test
    public void testFindEq2() {
        RLiveObjectService s = redisson.getLiveObjectService();
        TestIndexed t1 = new TestIndexed("1");
        t1.setNum1(1);
        t1.setName1("common");
        t1.setName2(";asdlkfj");
        t1 = s.persist(t1);

        TestIndexed t2 = new TestIndexed("2");
        t2.setNum1(1);
        t2.setName1("common");
        t2.setName2("893123");
        t2 = s.persist(t2);

        TestIndexed t3 = new TestIndexed("3");
        t3.setNum1(1);
        t3.setName1("common");
        t3.setName2("hkf;glhsdfg");
        t3 = s.persist(t3);

        Collection<TestIndexed> objects2 = s.find(TestIndexed.class, Conditions.and(
                Conditions.eq("num1", 1),
                Conditions.eq("name1", "jkflasdf"),
                Conditions.eq("name2", "fdfdf")));
        assertThat(objects2).isEmpty();

        Collection<TestIndexed> objects1 = s.find(TestIndexed.class, Conditions.and(
                Conditions.eq("num1", 1),
                Conditions.eq("name1", "common"),
                Conditions.eq("name2", "hkf;glhsdfg")));
        assertThat(objects1).hasSize(1);
    }

    @Test
    public void testConditionSerialize(){
        Condition c=Conditions.eq("num1", 1);
        pretty(c);
    }

    @Test
    public void testFindLe() {
        RLiveObjectService s = redisson.getLiveObjectService();
        TestIndexed t1 = new TestIndexed("1");
        t1.setNum1(12);
        t1 = s.persist(t1);

        TestIndexed t2 = new TestIndexed("2");
        t2.setNum1(10);
        t2 = s.persist(t2);

        Collection<TestIndexed> objects2 = s.find(TestIndexed.class, Conditions.le("num1", 9));
        assertThat(objects2).isEmpty();

        Collection<TestIndexed> objects0 = s.find(TestIndexed.class, Conditions.le("num1", 12));
        assertThat(objects0).hasSize(2);
        Iterator<TestIndexed> iter = objects0.iterator();
        TestIndexed obj1 = iter.next();
        assertThat(obj1.getId()).isEqualTo(t1.getId());
        TestIndexed obj2 = iter.next();
        assertThat(obj2.getId()).isEqualTo(t2.getId());

        s.delete(t1);
        s.delete(t2);

        Collection<TestIndexed> objects3 = s.find(TestIndexed.class, Conditions.le("num1", 12));
        assertThat(objects3).isEmpty();

        TestIndexed t3 = new TestIndexed("3");
        t3.setName1("test31");
        t3.setNum1(32);
        t3.setBool1(false);
        t3 = s.persist(t3);

        TestIndexed t4 = new TestIndexed("4");
        t4 = s.persist(t4);
        t4.setName1("test41");
        t4.setNum1(42);
        t4.setBool1(true);

        Collection<TestIndexed> objects4 = s.find(TestIndexed.class, Conditions.or(Conditions.le("num1", 30), Conditions.le("num1", 32)));
        assertThat(objects4).hasSize(1);

        Collection<TestIndexed> objects41 = s.find(TestIndexed.class, Conditions.or(Conditions.le("num1", 31), Conditions.lt("num1", -1)));
        assertThat(objects41).hasSize(0);

        Collection<TestIndexed> objects5 = s.find(TestIndexed.class, Conditions.or(Conditions.and(Conditions.eq("name1", "test31"), Conditions.le("num1", 32)),
                Conditions.and(Conditions.eq("name1", "test41"), Conditions.le("num1", 42))));
        assertThat(objects5).hasSize(2);

        Collection<TestIndexed> objects6 = s.find(TestIndexed.class, Conditions.or(Conditions.eq("name1", "test34"),
                Conditions.and(Conditions.eq("name1", "test41"), Conditions.le("num1", 42))));
        assertThat(objects6.iterator().next().getId()).isEqualTo("4");
    }

    @Test
    public void testFindLt() {
        RLiveObjectService s = redisson.getLiveObjectService();
        TestIndexed t1 = new TestIndexed("1");
        t1.setNum1(12);
        t1 = s.persist(t1);

        TestIndexed t2 = new TestIndexed("2");
        t2.setNum1(10);
        t2 = s.persist(t2);

        Collection<TestIndexed> objects2 = s.find(TestIndexed.class, Conditions.lt("num1", 9));
        assertThat(objects2).isEmpty();

        Collection<TestIndexed> objects0 = s.find(TestIndexed.class, Conditions.lt("num1", 13));
        assertThat(objects0).hasSize(2);
        Iterator<TestIndexed> iter = objects0.iterator();
        TestIndexed obj1 = iter.next();
        assertThat(obj1.getId()).isEqualTo(t1.getId());
        TestIndexed obj2 = iter.next();
        assertThat(obj2.getId()).isEqualTo(t2.getId());

        s.delete(t1);
        s.delete(t2);

        Collection<TestIndexed> objects3 = s.find(TestIndexed.class, Conditions.lt("num1", 13));
        assertThat(objects3).isEmpty();

        TestIndexed t3 = new TestIndexed("3");
        t3.setName1("test31");
        t3.setNum1(32);
        t3.setBool1(false);
        t3 = s.persist(t3);

        TestIndexed t4 = new TestIndexed("4");
        t4 = s.persist(t4);
        t4.setName1("test41");
        t4.setNum1(42);
        t4.setBool1(true);

        Collection<TestIndexed> objects4 = s.find(TestIndexed.class, Conditions.or(Conditions.lt("num1", 30), Conditions.lt("num1", 33)));
        assertThat(objects4).hasSize(1);

        Collection<TestIndexed> objects41 = s.find(TestIndexed.class, Conditions.or(Conditions.lt("num1", 32), Conditions.lt("num1", -1)));
        assertThat(objects41).hasSize(0);

        Collection<TestIndexed> objects5 = s.find(TestIndexed.class, Conditions.or(Conditions.and(Conditions.eq("name1", "test31"), Conditions.lt("num1", 33)),
                Conditions.and(Conditions.eq("name1", "test41"), Conditions.lt("num1", 43))));
        assertThat(objects5).hasSize(2);

        Collection<TestIndexed> objects6 = s.find(TestIndexed.class, Conditions.or(Conditions.eq("name1", "test34"),
                Conditions.and(Conditions.eq("name1", "test41"), Conditions.lt("num1", 43))));
        assertThat(objects6.iterator().next().getId()).isEqualTo("4");
    }

    @Test
    public void testFindGe() {
        RLiveObjectService s = redisson.getLiveObjectService();
        TestIndexed t1 = new TestIndexed("1");
        t1.setNum1(12);
        t1 = s.persist(t1);

        TestIndexed t2 = new TestIndexed("2");
        t2.setNum1(10);
        t2 = s.persist(t2);

        Collection<TestIndexed> objects0 = s.find(TestIndexed.class, Conditions.ge("num1", 10));
        assertThat(objects0).hasSize(2);
        Iterator<TestIndexed> iter = objects0.iterator();
        TestIndexed obj1 = iter.next();
        assertThat(obj1.getId()).isEqualTo(t1.getId());
        TestIndexed obj2 = iter.next();
        assertThat(obj2.getId()).isEqualTo(t2.getId());

        s.delete(t1);
        s.delete(t2);

        Collection<TestIndexed> objects3 = s.find(TestIndexed.class, Conditions.ge("num1", 10));
        assertThat(objects3).isEmpty();

        TestIndexed t3 = new TestIndexed("3");
        t3.setName1("test31");
        t3.setNum1(32);
        t3.setBool1(false);
        t3 = s.persist(t3);

        TestIndexed t4 = new TestIndexed("4");
        t4 = s.persist(t4);
        t4.setName1("test41");
        t4.setNum1(42);
        t4.setBool1(true);

        Collection<TestIndexed> objects4 = s.find(TestIndexed.class, Conditions.or(Conditions.ge("num1", 42), Conditions.ge("num1", 43)));
        assertThat(objects4).hasSize(1);

        Collection<TestIndexed> objects41 = s.find(TestIndexed.class, Conditions.or(Conditions.ge("num1", 43), Conditions.ge("num1", 45)));
        assertThat(objects41).hasSize(0);

        Collection<TestIndexed> objects5 = s.find(TestIndexed.class, Conditions.or(Conditions.and(Conditions.eq("name1", "test31"), Conditions.ge("num1", 32)),
                Conditions.and(Conditions.eq("name1", "test41"), Conditions.ge("num1", 42))));
        assertThat(objects5).hasSize(2);

        Collection<TestIndexed> objects6 = s.find(TestIndexed.class, Conditions.or(Conditions.eq("name1", "test34"),
                Conditions.and(Conditions.eq("name1", "test41"), Conditions.ge("num1", 42))));
        assertThat(objects6.iterator().next().getId()).isEqualTo("4");
    }

    @Test
    public void testFindGt() {
        RLiveObjectService s = redisson.getLiveObjectService();
        TestIndexed t1 = new TestIndexed("1");
        t1.setNum1(12);
        t1 = s.persist(t1);

        TestIndexed t2 = new TestIndexed("2");
        t2.setNum1(10);
        t2 = s.persist(t2);

        Collection<TestIndexed> objects0 = s.find(TestIndexed.class, Conditions.gt("num1", 9));
        assertThat(objects0).hasSize(2);
        Iterator<TestIndexed> iter = objects0.iterator();
        TestIndexed obj1 = iter.next();
        assertThat(obj1.getId()).isEqualTo(t1.getId());
        TestIndexed obj2 = iter.next();
        assertThat(obj2.getId()).isEqualTo(t2.getId());

        s.delete(t1);
        s.delete(t2);

        Collection<TestIndexed> objects3 = s.find(TestIndexed.class, Conditions.gt("num1", 9));
        assertThat(objects3).isEmpty();

        TestIndexed t3 = new TestIndexed("3");
        t3.setName1("test31");
        t3.setNum1(32);
        t3.setBool1(false);
        t3 = s.persist(t3);

        TestIndexed t4 = new TestIndexed("4");
        t4 = s.persist(t4);
        t4.setName1("test41");
        t4.setNum1(42);
        t4.setBool1(true);

        Collection<TestIndexed> objects4 = s.find(TestIndexed.class, Conditions.or(Conditions.gt("num1", 40), Conditions.gt("num1", 42)));
        assertThat(objects4).hasSize(1);

        Collection<TestIndexed> objects41 = s.find(TestIndexed.class, Conditions.or(Conditions.gt("num1", 42), Conditions.gt("num1", 45)));
        assertThat(objects41).hasSize(0);

        Collection<TestIndexed> objects5 = s.find(TestIndexed.class, Conditions.or(Conditions.and(Conditions.eq("name1", "test31"), Conditions.gt("num1", 30)),
                Conditions.and(Conditions.eq("name1", "test41"), Conditions.gt("num1", 40))));
        assertThat(objects5).hasSize(2);

        Collection<TestIndexed> objects6 = s.find(TestIndexed.class, Conditions.or(Conditions.eq("name1", "test34"),
                Conditions.and(Conditions.eq("name1", "test41"), Conditions.gt("num1", 41))));
        assertThat(objects6.iterator().next().getId()).isEqualTo("4");
    }
}

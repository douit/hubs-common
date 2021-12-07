package com.bluecc.income.dummy.liveobjects;

import com.bluecc.hubs.feed.FactBag;
import org.redisson.api.RCascadeType;
import org.redisson.api.RLiveObjectService;
import org.redisson.api.RedissonClient;
import org.redisson.api.annotation.RCascade;
import org.redisson.api.annotation.REntity;
import org.redisson.api.annotation.RId;
import org.redisson.api.annotation.RIndex;
import org.redisson.api.condition.Conditions;
import org.redisson.liveobject.resolver.LongGenerator;

import javax.inject.Inject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.bluecc.income.dummy.store.StoreModule.startup;
import static java.lang.Thread.sleep;

public class DummyObject {
    public static void main(String[] args) throws InterruptedException {
        DummyObject dummyObject=startup(DummyObject.class);
        dummyObject.start();

        sleep(1);
        System.exit(0);
    }

    @Inject
    FactBag factBag;


    void start(){
        RedissonClient redisson= getRedisson();
        RLiveObjectService s = redisson.getLiveObjectService();
        TestIndexed t1 = new TestIndexed("1");
        t1.setNum1(12);
        // t1 = s.persist(t1);
        t1 = s.merge(t1);

        TestIndexed t2 = new TestIndexed("2");
        t2.setNum1(10);
        t2 = s.merge(t2);

        Collection<TestIndexed> objects2 = s.find(TestIndexed.class,
                Conditions.lt("num1", 9));
        System.out.println(objects2.size());

        Collection<TestIndexed> objects0 = s.find(TestIndexed.class,
                Conditions.lt("num1", 13));
        System.out.println(objects0.size());

        // remove
        s.delete(t1);
        s.delete(t2);
    }

    public RedissonClient getRedisson() {
        return factBag.getSharedData().getClient();
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


    @REntity
    public static class Customer {

        @RId
        private String id;

        @RCascade(RCascadeType.ALL)
        private List<Order> orders = new ArrayList<>();

        public Customer() {
        }

        public Customer(String id) {
            super();
            this.id = id;
        }

        public void addOrder(Order order) {
            getOrders().add(order);
        }

        public void setOrders(List<Order> orders) {
            this.orders = orders;
        }

        public List<Order> getOrders() {
            return orders;
        }

        public String getId() {
            return id;
        }

    }

    @REntity
    public static class Order {

        @RId(generator = LongGenerator.class)
        private Long id;

        @RCascade({RCascadeType.PERSIST, RCascadeType.DETACH})
        private Customer customer;

        public Order() {
        }

        public Order(Customer customer) {
            super();
            this.customer = customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }

        public Customer getCustomer() {
            return customer;
        }

        public Long getId() {
            return id;
        }

    }
}

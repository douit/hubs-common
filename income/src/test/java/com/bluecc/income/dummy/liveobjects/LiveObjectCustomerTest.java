package com.bluecc.income.dummy.liveobjects;

import com.bluecc.income.AbstractRemoteTest;
import org.junit.Test;
import org.redisson.api.RCascadeType;
import org.redisson.api.annotation.RCascade;
import org.redisson.api.annotation.REntity;
import org.redisson.api.annotation.RId;
import org.redisson.liveobject.resolver.LongGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LiveObjectCustomerTest extends AbstractRemoteTest {

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

    @REntity
    public static class SetterEncapsulation {

        @RId(generator = LongGenerator.class)
        private Long id;

        private Map<String, Integer> map;

        public SetterEncapsulation() {
        }

        public Long getId() {
            return id;
        }

        public Integer getItem(String name) {
            return getMap().get(name);
        }

        public void addItem(String name, Integer amount) {
            getMap().put(name, amount);
        }

        protected Map<String, Integer> getMap() {
            return map;
        }

    }


    @Test
    public void testCollectionRewrite() {
        Customer c = new Customer("123");
        c = redisson.getLiveObjectService().merge(c);

        Order o1 = new Order(c);
        o1 = redisson.getLiveObjectService().merge(o1);
        // assertThat(o1.getId()).isEqualTo(1);
        c.getOrders().add(o1);

        Order o2 = new Order(c);
        o2 = redisson.getLiveObjectService().merge(o2);
        // assertThat(o2.getId()).isEqualTo(2);
        c.getOrders().add(o2);

        assertThat(c.getOrders().size()).isEqualTo(2);

        // assertThat(redisson.getKeys().count()).isEqualTo(7);

        List<Order> list = new ArrayList<>();
        Order o3 = new Order(c);
        o3 = redisson.getLiveObjectService().merge(o3);
        // assertThat(o3.getId()).isEqualTo(3);
        list.add(o3);
        c.setOrders(list);

        assertThat(c.getOrders().size()).isEqualTo(1);
    }

}

package com.bluecc.income.dummy.liveobjects;

import com.bluecc.income.GuiceTestRunner;
import com.bluecc.income.dummy.liveobjects.DummyObject.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RedissonClient;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(GuiceTestRunner.class)
public class DummyObjectTest {
    @Inject
    DummyObject dummyObject;

    @Test
    public void start() {
        RedissonClient redisson=dummyObject.getRedisson();

        Customer customer = new Customer("12");
        Order order = new Order(customer);
        customer.getOrders().add(order);
        Order order2 = new Order(customer);
        customer.getOrders().add(order2);

        redisson.getLiveObjectService().merge(customer);
        Customer mergedCustomer = redisson.getLiveObjectService().get(Customer.class, "12");
        assertThat(mergedCustomer.getOrders().size()).isEqualTo(2);
        for (Order orderElement : mergedCustomer.getOrders()) {
            assertThat(orderElement.getId()).isNotNull();
            assertThat(orderElement.getCustomer().getId()).isEqualTo("12");
        }

        try {
            redisson.getLiveObjectService().persist(customer);
            fail("Should not be here");
        } catch (Exception e) {
            assertEquals("This REntity already exists.", e.getMessage());
        }
    }


    @Test
    public void testPersistList() {
        RedissonClient redisson=dummyObject.getRedisson();

        Customer customer = new Customer("12");
        Order order = new Order(customer);
        customer.getOrders().add(order);
        Order order2 = new Order(customer);
        customer.getOrders().add(order2);

        // redisson.getLiveObjectService().persist(customer);
        redisson.getLiveObjectService().merge(customer);

        customer = redisson.getLiveObjectService().get(Customer.class, "12");
        assertThat(customer.getOrders().size()).isEqualTo(2);
        for (Order orderElement : customer.getOrders()) {
            assertThat(orderElement.getId()).isNotNull();
            assertThat(orderElement.getCustomer().getId()).isEqualTo("12");
        }
    }
}
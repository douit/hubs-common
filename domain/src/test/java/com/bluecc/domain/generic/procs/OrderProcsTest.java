package com.bluecc.domain.generic.procs;

import com.bluecc.domain.generic.dao.OrderHeaderRepository;
import com.bluecc.domain.generic.procs.OrderProcs.OrderAndItems;
import com.bluecc.domain.sql.model.OrderHeader;
import com.bluecc.domain.sql.model.OrderItem;
import com.bluecc.domain.util.JdbcHelper;
import com.github.javafaker.Faker;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Locale;

import static com.bluecc.domain.util.JsonUtil.pretty;

public class OrderProcsTest  extends AbstractProcsTest {
    @Inject
    JdbcHelper jdbcHelper;
    @Inject
    OrderProcs orderProcs;
    @Inject
    OrderHeaderRepository orderHeaderRepository;
    Faker faker = new Faker(new Locale("zh-CN"));
    @Before
    public void setUp() throws Exception {
        jdbcHelper.truncate("order_header", "order_item");
    }

    @Test
    public void testSaveOrderHeader(){
        OrderHeader header=new OrderHeader();
        Long id=orderHeaderRepository.save(header);
        System.out.println(id);
    }

    @Test
    public void saveOrder() {
        OrderHeader header=new OrderHeader();

        List<OrderItem> items= Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            OrderItem item=new OrderItem();
            item.setOrderItemSeqId((long) i);
            item.setQuantity(randDecimal(1,10));
            item.setUnitPrice(randDecimal(1, 10000));
            item.setItemDescription(faker.commerce().productName());
            items.add(item);
        }

        OrderAndItems orderAndItems= OrderAndItems.builder()
                .header(header)
                .items(items)
                .build();
        Long id=orderProcs.saveOrder(orderAndItems);
        System.out.println(id);

        // List<OrderAndItems> result=orderProcs.findWithItems(id);
        OrderAndItems result=orderProcs.findWithItems(id);
        System.out.println(result);
        result.items.forEach(e -> pretty(e));

        System.out.println("total orders: "+orderProcs.count());
    }
}
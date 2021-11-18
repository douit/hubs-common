package com.bluecc.domain.generic.procs;

import com.bluecc.domain.generic.dao.OrderHeaderRepository;
import com.bluecc.domain.generic.procs.OrderProcs.OrderAndItems;
import com.bluecc.domain.sql.model.OrderHeader;
import com.bluecc.domain.sql.model.OrderItem;
import com.bluecc.domain.sql.model.OrderItemPriceInfo;
import com.bluecc.domain.util.JdbcHelper;
import com.bluecc.domain.util.RandomDate;
import com.github.javafaker.Faker;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Locale;

import static com.bluecc.domain.util.JsonUtil.pretty;
import static org.junit.Assert.assertEquals;

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
        // OrderItemPriceInfo
        jdbcHelper.truncate("order_header", "order_item", "order_item_price_info");
    }

    @Test
    public void testSaveOrderHeader(){
        OrderHeader header=new OrderHeader();
        Long id=orderHeaderRepository.save(header);
        System.out.println(id);
    }

    @Test
    public void saveOrder() {
        RandomDate randomDate = getRandomDate();

        for (int genN=0;genN<3;++genN) {
            OrderAndItems orderAndItems = getOrderAndItems(randomDate);

            Long id = orderProcs.saveOrder(orderAndItems);
            System.out.println(id);

            // List<OrderAndItems> result=orderProcs.findWithItems(id);
            OrderAndItems result = orderProcs.findWithItems(id);
            System.out.println(result);
            System.out.print("header: ");
            pretty(result.header);
            result.items.forEach(e -> pretty(e));
            System.out.println("price-info: "+result.getItemPriceInfos().size());
            // 如果用innerJoin, 则只会有3条记录
            assertEquals(5, result.items.size());
            assertEquals(5, result.getItemPriceInfos().size());
        }

        System.out.println("total orders: "+orderProcs.count());
        assertEquals(3, orderProcs.count());
    }

    @Test
    public void saveOrderEvent() {
        RandomDate randomDate = getRandomDate();

        for (int genN=0;genN<3;++genN) {
            OrderAndItems input = getOrderAndItems(randomDate);

            OrderAndItems result = orderProcs.saveAndReturnOrder(input);
            assertEquals(5, result.items.size());
            assertEquals(5, result.getItemPriceInfos().size());
        }

        System.out.println("total orders: "+orderProcs.count());
        assertEquals(3, orderProcs.count());
    }

    private OrderAndItems getOrderAndItems(RandomDate randomDate) {
        OrderHeader header = new OrderHeader();
        header.setOrderDate(randomDate.getRandomDate());
        List<OrderItem> items = Lists.newArrayList();
        for (int i = 0; i < 5; ++i) {
            OrderItem item = new OrderItem();
            item.setOrderItemSeqId((long) i);
            item.setQuantity(randDecimal(1, 10));
            item.setUnitPrice(randDecimal(1, 10000));
            item.setItemDescription(faker.commerce().productName());
            items.add(item);
        }

        List<OrderItemPriceInfo> orderItemPriceInfos=Lists.newArrayList();
        for(int i=0;i<3;++i){
            OrderItemPriceInfo orderItemPriceInfo=new OrderItemPriceInfo();
            orderItemPriceInfo.setOrderItemSeqId((long) i);
            orderItemPriceInfo.setModifyAmount(randDecimal(0, 99));
            orderItemPriceInfos.add(orderItemPriceInfo);
        }

        OrderAndItems orderAndItems = OrderAndItems.builder()
                .header(header)
                .items(items)
                .itemPriceInfos(orderItemPriceInfos)
                .build();
        return orderAndItems;
    }

    private RandomDate getRandomDate() {
        DateTime endTime=DateTime.now();
        DateTime startTime=endTime.minusDays(30);
        RandomDate randomDate=new RandomDate(startTime, endTime, 3600);
        return randomDate;
    }
}
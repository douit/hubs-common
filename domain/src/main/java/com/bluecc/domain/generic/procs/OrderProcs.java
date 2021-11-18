package com.bluecc.domain.generic.procs;

import com.bluecc.domain.dummy.guice.Transactional;
import com.bluecc.domain.dummy.repository.UserAndTweets;
import com.bluecc.domain.generic.dao.OrderHeaderRepository;
import com.bluecc.domain.sql.model.*;
import com.querydsl.core.group.GroupBy;
import com.querydsl.core.types.QBean;
import com.querydsl.sql.dml.SQLInsertClause;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.util.List;

import static com.bluecc.domain.sql.model.QOrderHeader.orderHeader;
import static com.bluecc.domain.sql.model.QOrderItem.orderItem;
import static com.bluecc.domain.sql.model.QTweet.tweet;
import static com.bluecc.domain.sql.model.QTweetUser.tweetUser;
import static com.bluecc.domain.sql.model.QUser.user;
import static com.querydsl.core.types.Projections.bean;

public class OrderProcs extends OrderHeaderRepository {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderAndItems {
        Long orderId;
        DateTime createdStamp;

        OrderHeader header;
        List<OrderItem> items;
    }

    @Transactional
    public Long saveOrder(OrderAndItems orderAndItems) {
        orderAndItems.header.setCreatedStamp(DateTime.now());
        Long orderId = save(orderAndItems.header);

        if (!orderAndItems.getItems().isEmpty()) {
            SQLInsertClause insert = insert(orderItem);
            orderAndItems.getItems().forEach(item -> {
                item.setOrderId(orderId);
                insert.populate(item).addBatch();
            });
            insert.execute();
        }

        return orderId;
    }

    // slaves
    final QBean<OrderItem> orderItemBean = bean(OrderItem.class, orderItem.all());
    // master and slaves
    final QBean<OrderAndItems> orderAndItemsBean = bean(OrderAndItems.class,
            orderHeader.orderId, orderHeader.createdStamp,  // digest attrs
            bean(OrderHeader.class, orderHeader.all()).as("header"), // master
            GroupBy.list(orderItemBean).as("items")  // slave: order items
    );

    @Transactional
    public OrderAndItems findWithItems(Long orderId) {
        List<OrderAndItems> rs = selectFrom(orderHeader)
                .innerJoin(orderItem).on(orderHeader.orderId.eq(orderItem.orderId))
                .where(orderHeader.orderId.eq(orderId))
                // .limit(1) // 如果限制为1, 则只会查找1条orderItems
                .transform(GroupBy.groupBy(orderHeader.orderId).list(orderAndItemsBean));
        return rs.isEmpty() ? null : rs.get(0);
    }

    @Transactional
    public List<OrderAndItems> findAllWithItems() {
        return selectFrom(orderHeader)
                .innerJoin(orderItem).on(orderHeader.orderId.eq(orderItem.orderId))
                // .where(orderHeader.orderId.eq(orderId))
                .transform(GroupBy.groupBy(orderHeader.orderId).list(orderAndItemsBean));
    }

    @Transactional
    public long count() {
        return selectFrom(orderHeader).fetchCount();
    }
}

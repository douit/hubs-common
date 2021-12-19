package com.bluecc.income.service;

import com.bluecc.hubs.stub.ProductData;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.helper.Observers;
import com.google.common.collect.Lists;
import io.grpc.stub.StreamObserver;
import org.junit.Test;

import javax.inject.Inject;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

import static com.bluecc.income.helper.Observers.ObserverWrapper.observe;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
public class ProductRpcTest extends AbstractStoreProcTest {

    @Inject
    ProductRpc productRpc;

    @Test
    public void findList() {
        // productRpc.findList(QueryList.getDefaultInstance(), observe(p ->
        //         System.out.println(p)));
        List<ProductData> productDataList= Lists.newArrayList();
        productRpc.findList(QueryList.getDefaultInstance(), observe(productDataList::add));
        System.out.println(productDataList.size());
        assertThat(productDataList).hasSizeGreaterThan(1);
    }

    @Test
    public void findAndPrintList() {
        productRpc.findList(QueryList.getDefaultInstance(), observe(p ->
                System.out.println(p)));
    }
}
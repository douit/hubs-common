package com.bluecc.income.exchange;

import com.google.common.collect.Lists;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.util.List;

@Slf4j
public  class ResultSubscriber<T> extends BaseSubscriber<T> {
    private final List<T> result= Lists.newArrayList();

    public List<T> getResult() {
        return result;
    }

    @Override
    public void hookOnSubscribe(@NonNull Subscription subscription) {
        log.debug("subscribed");
        request(1);
    }

    @Override
    public void hookOnNext(@NonNull T value) {
        log.debug("on-next: " + value);
        result.add(value);
        request(1);
    }
}


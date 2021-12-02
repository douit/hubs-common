package com.bluecc.income.dummy.util;

import com.linecorp.armeria.internal.shaded.guava.collect.Lists;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class ReactorTest {
    @Test
    public void testFlux() {
        {
            AtomicInteger sum = new AtomicInteger(0);
            Flux
                    .just(1, 2, 3, 4)
                    .reduce(Integer::sum)
                    .subscribe(sum::set);
            log.info("Sum is: {}", sum.get());
        }
        {
            // 将会输出0，因为在这里使用了subscribeOn方法，将使得订阅者在异步线程执行。
            AtomicInteger sum = new AtomicInteger(0);
            Flux
                    .just(1, 2, 3, 4)
                    .subscribeOn(Schedulers.elastic())
                    .reduce(Integer::sum)
                    .subscribe(sum::set);
            log.info("Sum is: {}", sum.get());
        }
    }

    @Test
    public void useGenerate() {
        Flux<String> flux = Flux.generate(
                () -> 0,
                (state, sink) -> {
                    sink.next("3 x " + state + " = " + 3 * state);
                    if (state == 10) sink.complete();
                    return state + 1;
                });

        flux.subscribe(System.out::println);
    }


    public static class CustSubscriber<T> extends BaseSubscriber<T> {
        // 调用request(n)来决定这次subscribe获取元素的最大数目
        @Override
        public void hookOnSubscribe(@NonNull Subscription subscription) {
            System.out.println("subscribed");
            request(1);
        }

        @Override
        public void hookOnNext(@NonNull T value) {
            System.out.println("on-next: " + value);
            request(1);
        }
    }

    @Test
    public void testSubscriber() {
        Flux<String> flux = Flux.generate(
                () -> 0,
                (state, sink) -> {
                    sink.next("3 x " + state + " = " + 3 * state);
                    if (state == 10) sink.complete();
                    return state + 1;
                });

        flux.subscribe(new CustSubscriber<>());
    }

    public static class StateSubscriber<T> extends BaseSubscriber<T> {
        List<T> result= Lists.newArrayList();
        @Override
        public void hookOnSubscribe(@NonNull Subscription subscription) {
            System.out.println("subscribed");
            request(1);
        }

        @Override
        public void hookOnNext(@NonNull T value) {
            System.out.println("on-next: " + value);
            result.add(value);
            request(1);
        }
    }
    @Test
    public void testStatedSubscriber() throws InterruptedException {
        // Subscriber<String> subs=new StateSubscriber<>();
        StateSubscriber<String> subs=new StateSubscriber<>();
        subs.onNext("first");
        subs.onNext("second");
        subs.onComplete();

        System.out.println(subs.result);

        Flux<String> flux = Flux.generate(
                () -> 0,
                (state, sink) -> {
                    sink.next("3 x " + state + " = " + 3 * state);
                    if (state == 10) sink.complete();
                    return state + 1;
                });

        subs=new StateSubscriber<>();
        flux.subscribe(subs);
        System.out.println(subs.result);

        //
        flux = Flux.just("Khanh", "Quan", "Thanh");
        flux.subscribe(new StateSubscriber<>());
        TimeUnit.SECONDS.sleep(1);
    }


    @Test
    public void testRequest(){
        Flux<Integer> ints3 = Flux.range(1, 4);
        ints3.subscribe(System.out::println,
                error -> System.err.println("Error " + error),
                () -> System.out.println("Done"),
                sub -> sub.request(2));
    }

    @Test
    public void testShare(){
        Flux<Integer> numbers = Flux
                .just(1, 2, 3, 4)
                .log()
                .share();
        numbers
                .reduce(Integer::sum)
                .subscribe(sum -> log.info("Sum is: {}", sum));
        numbers
                .reduce((a, b) -> a * b)
                .subscribe(product -> log.info("Product is: {}", product));
    }

    @Test
    public void useSubscribeOn() throws InterruptedException {
        Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);
        final Flux<String> flux = Flux
                .range(1, 2)
                .map(i -> 10 + i + ":" + Thread.currentThread())
                .subscribeOn(s)
                .map(i -> "value " + i + ":"+ Thread.currentThread());

        new Thread(() -> flux.subscribe(System.out::println), "ThreadA").start();
        Thread.sleep(5000);
    }
}

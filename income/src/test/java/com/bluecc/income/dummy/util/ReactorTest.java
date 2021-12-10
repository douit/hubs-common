package com.bluecc.income.dummy.util;

import com.linecorp.armeria.internal.shaded.guava.collect.Lists;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    public void testToFuture() throws ExecutionException, InterruptedException {
        Flux<String> flux = Flux.generate(
                () -> 0,
                (state, sink) -> {
                    sink.next("3 x " + state + " = " + 3 * state);
                    if (state == 10) sink.complete();
                    return state + 1;
                });

        // flux.subscribe(new CustSubscriber<>());
        CompletableFuture<List<String>> result = flux.collectList().toFuture();
        System.out.println(result.get());
    }

    @Test
    public void testResultToFuture() throws Exception {
        Result r=Flux.just("red", "white", "blue")
                .log("source")
                .flatMap(value -> Mono.fromCallable(() -> {
                    Thread.sleep(1000);
                    return value;
                }).subscribeOn(Schedulers.elastic()))
                .log("merged")
                .collect(Result::new, Result::add)
                .doOnNext(Result::stop)
                .log("accumulated")
                .toFuture()
                .get();

        System.out.println(r);
    }

    // @Test
    // public void delayElementShouldNotCancelTwice() throws Exception {
    //     DirectProcessor<Long> p = DirectProcessor.create();
    //     AtomicInteger cancellations = new AtomicInteger();
    //     Flux<Long> publishedFlux = p
    //             .publish()
    //             .refCount(2)
    //             .doOnCancel(() -> cancellations.incrementAndGet());
    //     publishedFlux.any(x -> x > 5)
    //             .delayElement(Duration.ofMillis(2))
    //             .subscribe();
    //     CompletableFuture<List<Long>> result = publishedFlux.collectList().toFuture();
    //     for (long i = 0; i < 10; i++) {
    //         p.onNext(i);
    //         Thread.sleep(1);
    //     }
    //     p.onComplete();
    //     assertThat(result.get(10, TimeUnit.MILLISECONDS).size()).isEqualTo(10);
    //     assertThat(cancellations.get()).isEqualTo(2);
    // }

    public static class StateSubscriber<T> extends BaseSubscriber<T> {
        List<T> result = Lists.newArrayList();

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
        StateSubscriber<String> subs = new StateSubscriber<>();
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

        subs = new StateSubscriber<>();
        flux.subscribe(subs);
        System.out.println(subs.result);

        //
        flux = Flux.just("Khanh", "Quan", "Thanh");
        flux.subscribe(new StateSubscriber<>());
        TimeUnit.SECONDS.sleep(1);
    }


    @Test
    public void testRequest() {
        Flux<Integer> ints3 = Flux.range(1, 4);
        ints3.subscribe(System.out::println,
                error -> System.err.println("Error " + error),
                () -> System.out.println("Done"),
                sub -> sub.request(2));
    }

    @Test
    public void testShare() {
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
                .map(i -> "value " + i + ":" + Thread.currentThread());

        new Thread(() -> flux.subscribe(System.out::println), "ThreadA").start();
        sleep(5000);
    }

    @Test
    public void testMono() throws ExecutionException, InterruptedException {
        Mono.just(1)
                .map(integer -> "foo" + integer)
                // .or(Mono.delay(Duration.ofMillis(100)))
                .subscribe(System.out::println);

        System.out.println(Mono.just(1)
                .map(integer -> "foo" + integer)
                .toFuture().get());
    }

    @Test
    public void testFluxResult() throws Exception {

        Flux.just("red", "white", "blue")
                .log("source")
                .flatMap(value -> Mono.fromCallable(() -> {
                            System.out.println("wait .. "+value);
                            sleep(1000);
                            return value;
                        })
                        // .subscribeOn(Schedulers.boundedElastic())
                        .subscribeOn(Schedulers.elastic())
                )
                .log("merged")
                .collect(Result::new, Result::add)
                .doOnNext(Result::stop)
                .log("accumulated")
                .toFuture()
                .get();
        sleep(2000);
    }

    static final class Result {

        private ConcurrentMap<String, AtomicLong> counts = new ConcurrentHashMap<>();

        private long timestamp = System.currentTimeMillis();

        private long duration;

        public long add(String colour) {
            AtomicLong value = counts.getOrDefault(colour, new AtomicLong());
            counts.putIfAbsent(colour, value);
            return value.incrementAndGet();
        }

        public void stop() {
            this.duration = System.currentTimeMillis() - timestamp;
        }

        public long getDuration() {
            return duration;
        }

        public Map<String, AtomicLong> getCounts() {
            return counts;
        }

        @Override
        public String toString() {
            return "Result [duration=" + duration + ", counts=" + counts + "]";
        }

    }

    @Test
    public void testSleep() throws InterruptedException {

        //flux emits one element per second
        Flux<Character> flux = Flux.just('a', 'b', 'c', 'd')
                .delayElements(Duration.ofSeconds(1));
        //Observer 1 - takes 500ms to process
        flux
                .map(Character::toUpperCase)
                .subscribe(i -> {
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Observer-1 : " + i);
                });
        //Observer 2 - process immediately
        flux.subscribe(i -> System.out.println("Observer-2 : " + i));

        System.out.println("Ends");
        sleep(5000);
    }

    @Test
    public void testError(){
        Flux.just(1,2,3)
                .map(i -> i / (i-2))
                .subscribe(
                        i -> System.out.println("Received :: " + i),
                        err -> System.out.println("Error :: " + err),
                        () -> System.out.println("Successfully completed"));

            //Output
//         Received :: -1
//         Error :: java.lang.ArithmeticException: / by zero
    }
}

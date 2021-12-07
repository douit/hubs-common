package com.bluecc.income.dummy.liveobjects;

import com.bluecc.income.AbstractRemoteTest;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.api.annotation.RRemoteAsync;
import org.redisson.api.annotation.RRemoteReactive;
import org.redisson.api.annotation.RRemoteRx;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public class RemoteServiceTest extends AbstractRemoteTest {
    public static class Pojo {

        private String stringField;

        public Pojo() {
        }

        public Pojo(String stringField) {
            this.stringField = stringField;
        }

        public String getStringField() {
            return stringField;
        }

        public void setStringField(String stringField) {
            this.stringField = stringField;
        }
    }

    public static class SerializablePojo implements Serializable {

        private String stringField;

        public SerializablePojo() {
        }

        public SerializablePojo(String stringField) {
            this.stringField = stringField;
        }

        public String getStringField() {
            return stringField;
        }

        public void setStringField(String stringField) {
            this.stringField = stringField;
        }
    }

    @RRemoteAsync(RemoteInterface.class)
    public interface RemoteInterfaceAsync {

        RFuture<Void> cancelMethod();

        RFuture<Void> voidMethod(String name, Long param);

        RFuture<Long> resultMethod(Long value);

        RFuture<Void> errorMethod();

        RFuture<Void> errorMethodWithCause();

        RFuture<Void> timeoutMethod();

    }

    @RRemoteReactive(RemoteInterface.class)
    public interface RemoteInterfaceReactive {

        Mono<Void> cancelMethod();

        Mono<Void> voidMethod(String name, Long param);

        Mono<Long> resultMethod(Long value);

        Mono<Void> errorMethod();

        Mono<Void> errorMethodWithCause();

        Mono<Void> timeoutMethod();

    }

    @RRemoteRx(RemoteInterface.class)
    public interface RemoteInterfaceRx {

        Completable cancelMethod();

        Completable voidMethod(String name, Long param);

        Single<Long> resultMethod(Long value);

        Completable errorMethod();

        Completable errorMethodWithCause();

        Completable timeoutMethod();

    }

    @RRemoteAsync(RemoteInterface.class)
    public interface RemoteInterfaceWrongMethodAsync {

        RFuture<Void> voidMethod1(String name, Long param);

        RFuture<Long> resultMethod(Long value);

    }

    @RRemoteAsync(RemoteInterface.class)
    public interface RemoteInterfaceWrongParamsAsync {

        RFuture<Void> voidMethod(Long param, String name);

        RFuture<Long> resultMethod(Long value);

    }


    public interface RemoteInterface {

        Optional<Integer> optionalResult(Integer value);

        void cancelMethod() throws InterruptedException;

        void voidMethod(String name, Long param);

        Long resultMethod(Long value);

        void errorMethod() throws IOException;

        void errorMethodWithCause();

        void timeoutMethod() throws InterruptedException;

        Pojo doSomethingWithPojo(Pojo pojo);

        SerializablePojo doSomethingWithSerializablePojo(SerializablePojo pojo);

        String methodOverload();

        String methodOverload(String str);

        String methodOverload(Long lng);

        String methodOverload(String str, Long lng);

    }

    public static class RemoteImpl implements RemoteInterface {

        private AtomicInteger iterations;

        public RemoteImpl() {
        }

        public RemoteImpl(AtomicInteger iterations) {
            super();
            this.iterations = iterations;
        }

        @Override
        public Optional<Integer> optionalResult(Integer value) {
            if (value == null) {
                return Optional.empty();
            }
            return Optional.of(value);
        }

        @Override
        public void cancelMethod() throws InterruptedException {
            while (true) {
                int i = iterations.incrementAndGet();
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("interrupted! " + i);
                    return;
                }
            }
        }

        @Override
        public void voidMethod(String name, Long param) {
            System.out.println(name + " " + param);
        }

        @Override
        public Long resultMethod(Long value) {
            return value*2;
        }

        @Override
        public void errorMethod() throws IOException {
            throw new IOException("Checking error throw");
        }

        @Override
        public void errorMethodWithCause() {
            try {
                int s = 2 / 0;
            } catch (Exception e) {
                throw new RuntimeException("Checking error throw", e);
            }
        }

        @Override
        public void timeoutMethod() throws InterruptedException {
            Thread.sleep(2000);
        }

        @Override
        public Pojo doSomethingWithPojo(Pojo pojo) {
            return pojo;
        }

        @Override
        public SerializablePojo doSomethingWithSerializablePojo(SerializablePojo pojo) {
            return pojo;
        }

        @Override
        public String methodOverload() {
            return "methodOverload()";
        }

        @Override
        public String methodOverload(Long lng) {
            return "methodOverload(Long lng)";
        }

        @Override
        public String methodOverload(String str) {
            return "methodOverload(String str)";
        }

        @Override
        public String methodOverload(String str, Long lng) {
            return "methodOverload(String str, Long lng)";
        }

    }

    @Test
    public void testOptional() {
        RRemoteService remoteService = redisson.getRemoteService();
        remoteService.register(RemoteInterface.class, new RemoteImpl());
        RemoteInterface service = redisson.getRemoteService().get(RemoteInterface.class);

        Optional<Integer> r1 = service.optionalResult(null);
        assertThat(r1.isPresent()).isFalse();
        Optional<Integer> r2 = service.optionalResult(2);
        assertThat(r2.get()).isEqualTo(2);
        remoteService.deregister(RemoteInterface.class);
    }

    @Test
    public void testConcurrentInvocations() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        RRemoteService remoteService = redisson.getRemoteService();
        remoteService.register(RemoteInterface.class, new RemoteImpl());
        RemoteInterface service = redisson.getRemoteService().get(RemoteInterface.class);

        List<Future<?>> futures = new ArrayList<>();

        int iterations = 1000;
        AtomicBoolean bool = new AtomicBoolean();
        for (int i = 0; i < iterations; i++) {
            futures.add(executorService.submit(() -> {
                try {
                    if (ThreadLocalRandom.current().nextBoolean()) {
                        service.resultMethod(1L);
                    } else {
                        service.methodOverload();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    bool.set(true);
                }
            }));
        }

        while (!futures.stream().allMatch(Future::isDone)) {}

        assertThat(bool.get()).isFalse();
        remoteService.deregister(RemoteInterface.class);
    }

    @Test
    public void testPendingInvocations() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        RRemoteService rs = redisson.getRemoteService();
        rs.register(RemoteInterface.class, new RemoteImpl(), 1, executor);

        assertThat(rs.getPendingInvocations(RemoteInterface.class)).isEqualTo(0);

        RemoteInterfaceAsync ri = redisson.getRemoteService().get(RemoteInterfaceAsync.class);

        for (int i = 0; i < 5; i++) {
            ri.timeoutMethod();
        }
        Thread.sleep(1000);
        assertThat(rs.getPendingInvocations(RemoteInterface.class)).isEqualTo(4);
        Thread.sleep(9000);
        assertThat(rs.getPendingInvocations(RemoteInterface.class)).isEqualTo(0);

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        rs.deregister(RemoteInterface.class);
    }

    @Test
    public void testFreeWorkers() throws InterruptedException, ExecutionException {
        RedissonClient r1 = createInstance();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        RRemoteService rs = r1.getRemoteService();
        rs.register(RemoteInterface.class, new RemoteImpl(), 1, executor);
        assertThat(rs.getFreeWorkers(RemoteInterface.class)).isEqualTo(1);

        RedissonClient r2 = createInstance();
        RemoteInterfaceAsync ri = r2.getRemoteService().get(RemoteInterfaceAsync.class);

        RFuture<Void> f = ri.timeoutMethod();
        Thread.sleep(100);
        assertThat(rs.getFreeWorkers(RemoteInterface.class)).isEqualTo(0);
        f.get();
        assertThat(rs.getFreeWorkers(RemoteInterface.class)).isEqualTo(1);

        r1.shutdown();
        r2.shutdown();

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }

    @Test
    public void testCancelAsync() throws InterruptedException {
        RedissonClient r1 = createInstance();
        AtomicInteger iterations = new AtomicInteger();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        r1.getKeys().flushall();
        r1.getRemoteService().register(RemoteInterface.class, new RemoteImpl(iterations), 1, executor);

        RedissonClient r2 = createInstance();
        RemoteInterfaceAsync ri = r2.getRemoteService().get(RemoteInterfaceAsync.class);

        RFuture<Void> f = ri.cancelMethod();
        Thread.sleep(500);
        assertThat(f.cancel(true)).isTrue();

        executor.shutdown();
        r1.shutdown();
        r2.shutdown();

        assertThat(iterations.get()).isLessThan(Integer.MAX_VALUE / 2);

        assertThat(executor.awaitTermination(2, TimeUnit.SECONDS)).isTrue();
    }

    @Test
    public void testCancelReactive() throws InterruptedException {
        RedissonReactiveClient r1 = Redisson.create(createConfig()).reactive();
        AtomicInteger iterations = new AtomicInteger();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        r1.getKeys().flushall();
        r1.getRemoteService().register(RemoteInterface.class, new RemoteImpl(iterations), 1, executor);

        RedissonReactiveClient r2 = Redisson.create(createConfig()).reactive();
        RemoteInterfaceReactive ri = r2.getRemoteService().get(RemoteInterfaceReactive.class);

        Mono<Void> f = ri.cancelMethod();
        Disposable t = f.doOnSubscribe(s -> s.request(1)).subscribe();
        Thread.sleep(500);
        t.dispose();

        executor.shutdown();
        r1.shutdown();
        r2.shutdown();

        assertThat(iterations.get()).isLessThan(Integer.MAX_VALUE / 2);

        assertThat(executor.awaitTermination(2, TimeUnit.SECONDS)).isTrue();
    }

    @Test
    public void testWrongMethodAsync() {
        assertThrows(IllegalArgumentException.class, () -> {
            redisson.getRemoteService().get(RemoteInterfaceWrongMethodAsync.class);
        });
    }

    @Test
    public void testWrongParamsAsync() {
        assertThrows(IllegalArgumentException.class, () -> {
            redisson.getRemoteService().get(RemoteInterfaceWrongParamsAsync.class);
        });
    }

    @Test
    public void testAsync() throws InterruptedException {
        RedissonClient r1 = createInstance();
        r1.getRemoteService().register(RemoteInterface.class, new RemoteImpl());

        RedissonClient r2 = createInstance();
        RemoteInterfaceAsync ri = r2.getRemoteService().get(RemoteInterfaceAsync.class);

        RFuture<Void> f = ri.voidMethod("someName", 100L);
        f.sync();
        RFuture<Long> resFuture = ri.resultMethod(100L);
        resFuture.sync();
        assertThat(resFuture.getNow()).isEqualTo(200);

        r1.shutdown();
        r2.shutdown();
    }

    @Test
    public void testReactive() throws InterruptedException {
        RedissonReactiveClient r1 = Redisson.create(createConfig()).reactive();
        r1.getRemoteService().register(RemoteInterface.class, new RemoteImpl());

        RedissonReactiveClient r2 = Redisson.create(createConfig()).reactive();
        RemoteInterfaceReactive ri = r2.getRemoteService().get(RemoteInterfaceReactive.class);

        Mono<Void> f = ri.voidMethod("someName", 100L);
        f.block();
        Mono<Long> resFuture = ri.resultMethod(100L);
        assertThat(resFuture.block()).isEqualTo(200);

        r1.shutdown();
        r2.shutdown();
    }

    @Test
    public void testRx() {
        RedissonRxClient r1 = Redisson.create(createConfig()).rxJava();
        r1.getRemoteService().register(RemoteInterface.class, new RemoteImpl());

        RedissonRxClient r2 = Redisson.create(createConfig()).rxJava();
        RemoteInterfaceRx ri = r2.getRemoteService().get(RemoteInterfaceRx.class);

        Completable f = ri.voidMethod("someName", 100L);
        f.blockingAwait();
        Single<Long> resFuture = ri.resultMethod(100L);
        assertThat(resFuture.blockingGet()).isEqualTo(200);

        r1.shutdown();
        r2.shutdown();
    }

    @Test
    public void testExecutorAsync() throws InterruptedException {
        RedissonClient r1 = createInstance();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        r1.getRemoteService().register(RemoteInterface.class, new RemoteImpl(), 1, executor);

        RedissonClient r2 = createInstance();
        RemoteInterfaceAsync ri = r2.getRemoteService().get(RemoteInterfaceAsync.class);

        RFuture<Void> f = ri.voidMethod("someName", 100L);
        f.sync();
        RFuture<Long> resFuture = ri.resultMethod(100L);
        resFuture.sync();
        assertThat(resFuture.getNow()).isEqualTo(200);

        r1.shutdown();
        r2.shutdown();

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}

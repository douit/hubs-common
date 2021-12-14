package com.bluecc.hubs.fund;

import one.util.streamex.EntryStream;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StreamTest {
    public List<String> getEvenIndexedStringsVersionTwo(List<String> names) {
        return EntryStream.of(names)
                .filterKeyValue((index, name) -> index % 2 == 0)
                .values()
                .toList();
    }

    @Test
    public void whenCalled_thenReturnListOfEvenIndexedStringsVersionTwo() {
        String[] names
                = {"Afrim", "Bashkim", "Besim", "Lulzim", "Durim", "Shpetim"};
        List<String> expectedResult
                = Arrays.asList("Afrim", "Besim", "Durim");
        List<String> actualResult
                = getEvenIndexedStringsVersionTwo(Arrays.asList(names));

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testShortcuts(){
        // List<String> userNames = StreamEx.of(users).map(User::getName).toList();
        // Map<Role, List<User>> role2users = StreamEx.of(users).groupingBy(User::getRole);
        // StreamEx.of(1,2,3).joining("; "); // "1; 2; 3"
    }
    //
    // public static <T, TT extends T, R> void checkShortCircuitCollector(String message, R expected,
    //                                                                    int expectedConsumedElements, Supplier<Stream<TT>> base, Collector<T, ?, R> collector, boolean skipIdentity) {
    //     assertNotNull(message, finished(collector));
    //     Collector<T, ?, R> withIdentity = Collectors.collectingAndThen(collector, Function.identity());
    //     for (StreamExSupplier<TT> supplier : streamEx(base)) {
    //         AtomicInteger counter = new AtomicInteger();
    //         assertEquals(message + ": " + supplier, expected, supplier.get().peek(t -> counter.incrementAndGet())
    //                 .collect(collector));
    //         if (!supplier.get().isParallel())
    //             assertEquals(message + ": " + supplier + ": consumed: ", expectedConsumedElements, counter.get());
    //         if (!skipIdentity)
    //             assertEquals(message + ": " + supplier, expected, supplier.get().collect(withIdentity));
    //     }
    // }
    // public static class StreamExSupplier<T> extends StreamSupplier<T> {
    //
    //     public StreamExSupplier(Supplier<Stream<T>> base, Mode mode) {
    //         super(base, mode);
    //     }
    //
    //     @Override
    //     public StreamEx<T> get() {
    //         if (mode == Mode.SPLITERATOR)
    //             return StreamEx.of(base.get().spliterator());
    //         return StreamEx.of(super.get());
    //     }
    // }
    //
    // static class StreamSupplier<T> {
    //     final Mode mode;
    //     final Supplier<Stream<T>> base;
    //
    //     public StreamSupplier(Supplier<Stream<T>> base, Mode mode) {
    //         this.base = base;
    //         this.mode = mode;
    //     }
    //
    //     enum Mode {
    //         NORMAL, SPLITERATOR, PARALLEL, APPEND, PREPEND, RANDOM
    //     }
    //
    //     public Stream<T> get() {
    //         Stream<T> res = base.get();
    //         switch (mode) {
    //             case NORMAL:
    //             case SPLITERATOR:
    //                 return res.sequential();
    //             case PARALLEL:
    //                 return res.parallel();
    //             case APPEND:
    //                 // using Stream.empty() or Arrays.asList() here is optimized out
    //                 // in append/prepend which is undesired
    //                 return StreamEx.of(res.parallel()).append(new ConcurrentLinkedQueue<>());
    //             case PREPEND:
    //                 return StreamEx.of(res.parallel()).prepend(new ConcurrentLinkedQueue<>());
    //             case RANDOM:
    //                 return StreamEx.of(new EmptyingSpliterator<>(res.parallel().spliterator())).parallel();
    //             default:
    //                 throw new InternalError("Unsupported mode: " + mode);
    //         }
    //     }
    //
    //     @Override
    //     public String toString() {
    //         return mode.toString();
    //     }
    // }

}

package com.bluecc.income.helper;

import io.grpc.stub.StreamObserver;

import java.util.function.Consumer;

public class Observers {
    public static class ObserverWrapper<T> implements StreamObserver<T> {
        public static <T> ObserverWrapper<T> observe(Consumer<T> consumer){
            return new ObserverWrapper<T>(consumer);
        }

        Consumer<T> consumer;
        ObserverWrapper(Consumer<T> consumer){
            this.consumer=consumer;
        }
        @Override
        public void onNext(T value) {
            consumer.accept(value);
        }

        @Override
        public void onError(Throwable t) {
        }

        @Override
        public void onCompleted() {
        }
    }
}

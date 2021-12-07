package com.bluecc.saga.dummy.fsm;

import akka.actor.typed.ActorRef;

import java.util.LinkedList;
import java.util.List;

public class BuncherEvents {
    // ----------------------- events
    public interface Event {}

    public static final class SetTarget implements Event {
        public final ActorRef<Batch> ref;

        public SetTarget(ActorRef<Batch> ref) {
            this.ref = ref;
        }
    }

    public enum Timeout implements Event {
        INSTANCE
    }

    public enum Flush implements Event {
        INSTANCE
    }

    public static final class Queue implements Event {
        public final Object obj;

        public Queue(Object obj) {
            this.obj = obj;
        }
    }

    // -------------------------- data
    // #storing-state
    interface Data {}

    public static final class Todo implements Data {
        public final ActorRef<Batch> target;
        public final List<Object> queue;

        public Todo(ActorRef<Batch> target, List<Object> queue) {
            this.target = target;
            this.queue = queue;
        }

        // #storing-state

        @Override
        public String toString() {
            return "Todo{" + "target=" + target + ", queue=" + queue + '}';
        }

        public Todo addElement(Object element) {
            List<Object> nQueue = new LinkedList<>(queue);
            nQueue.add(element);
            return new Todo(this.target, nQueue);
        }

        public Todo copy(List<Object> queue) {
            return new Todo(this.target, queue);
        }

        public Todo copy(ActorRef<Batch> target) {
            return new Todo(target, this.queue);
        }
        // #storing-state
    }

    public static final class Batch {
        public final List<Object> list;

        public Batch(List<Object> list) {
            this.list = list;
        }

        // #storing-state

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Batch batch = (Batch) o;

            return list.equals(batch.list);
        }

        @Override
        public int hashCode() {
            return list.hashCode();
        }

        @Override
        public String toString() {
            final StringBuilder builder = new StringBuilder();
            builder.append("Batch{list=");
            list.stream()
                    .forEachOrdered(
                            e -> {
                                builder.append(e);
                                builder.append(",");
                            });
            int len = builder.length();
            builder.replace(len, len, "}");
            return builder.toString();
        }
        // #storing-state
    }
    // #storing-state
}

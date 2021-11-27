package com.bluecc.income.values;

public class ColumnValues {

    public interface DatabaseValue<T> {
        T getColumnValue();
    }

    public static final class DatabaseLongValue extends DatabaseNumberValue<Long> {
        public DatabaseLongValue(final long value) {
            super(Long.valueOf(value));
        }
    }

    public static class DatabaseNumberValue<T extends Number> implements DatabaseValue<T> {

        private final T value;

        public DatabaseNumberValue(final T value) {
            super();
            this.value = value;
        }

        @Override
        public T getColumnValue() {
            return this.value;
        }
    }

}

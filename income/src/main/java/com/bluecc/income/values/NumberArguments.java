package com.bluecc.income.values;

import org.jdbi.v3.core.argument.AbstractArgumentFactory;
import org.jdbi.v3.core.argument.Argument;
import org.jdbi.v3.core.config.ConfigRegistry;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Objects;

public class NumberArguments {

    public static final class BigIntNumberArgumentFactory extends AbstractArgumentFactory<Number> {

        public BigIntNumberArgumentFactory() {
            super(Types.BIGINT);
        }

        @Override
        protected Argument build(final Number value, final ConfigRegistry config) {
            return new BigIntNumberArgument(value);
        }
    }

    public static final class BigIntNumberArgument implements Argument {

        private final Number value;

        public BigIntNumberArgument(final Number value) {
            this.value = value;
        }

        @Override
        public void apply(final int position, final PreparedStatement statement, final StatementContext ctx) throws SQLException {
            statement.setLong(position, this.value.longValue());
        }

        @Override
        public String toString() {
            return Objects.toString(this.value);
        }
    }
}

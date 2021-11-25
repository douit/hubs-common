package com.bluecc.income.exchange;

import org.jdbi.v3.core.Jdbi;

public interface IStore {
    Jdbi getJdbi();
}

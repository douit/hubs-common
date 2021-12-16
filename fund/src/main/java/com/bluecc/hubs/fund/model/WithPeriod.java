package com.bluecc.hubs.fund.model;

import java.time.LocalDateTime;

public interface WithPeriod {

    LocalDateTime getFromDate();

    void setFromDate(LocalDateTime fromDate);

    LocalDateTime getThruDate();

    void setThruDate(LocalDateTime thruDate);
}

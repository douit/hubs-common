package com.bluecc.hubs.fund.model;

public interface IModel {
    java.time.LocalDateTime getLastUpdatedStamp();
    java.time.LocalDateTime getLastUpdatedTxStamp();
    java.time.LocalDateTime getCreatedStamp();
    java.time.LocalDateTime getCreatedTxStamp();
}

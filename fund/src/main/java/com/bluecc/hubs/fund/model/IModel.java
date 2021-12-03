package com.bluecc.hubs.fund.model;

import com.google.protobuf.Message;

public interface IModel {
    java.time.LocalDateTime getLastUpdatedStamp();
    java.time.LocalDateTime getLastUpdatedTxStamp();
    java.time.LocalDateTime getCreatedStamp();
    java.time.LocalDateTime getCreatedTxStamp();

    Message toData();
    <T extends Message.Builder> T toDataBuilder();
}

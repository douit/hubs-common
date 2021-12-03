package com.bluecc.hubs.fund.model;

import com.google.protobuf.Message;

public interface IEventModel<T extends Message.Builder> extends IModel<T>{
    java.time.LocalDateTime getLastUpdatedStamp();
    java.time.LocalDateTime getLastUpdatedTxStamp();
    java.time.LocalDateTime getCreatedStamp();
    java.time.LocalDateTime getCreatedTxStamp();
}

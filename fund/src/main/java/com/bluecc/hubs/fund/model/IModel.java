package com.bluecc.hubs.fund.model;

import com.google.protobuf.Message;

public interface IModel<T extends Message.Builder> {
    Message toData();
    T toDataBuilder();
}

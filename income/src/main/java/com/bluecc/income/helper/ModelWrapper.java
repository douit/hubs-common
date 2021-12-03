package com.bluecc.income.helper;

import com.bluecc.hubs.fund.model.IModel;
import com.google.protobuf.Message;

public class ModelWrapper<T extends Message.Builder> implements IModel<T> {
    T builder;
    public ModelWrapper(T builder){
        this.builder=builder;
    }
    @Override
    public Message toData() {
        return toDataBuilder().build();
    }

    @Override
    public T toDataBuilder() {
        return builder;
    }
}

package com.bluecc.saga.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Type;
import java.util.function.Consumer;

@Data
@AllArgsConstructor
public class StateAction<T extends IMessageEvent> {
    Type[] accepter;
    Consumer<T> action;
}

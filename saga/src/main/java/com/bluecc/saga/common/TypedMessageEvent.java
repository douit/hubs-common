package com.bluecc.saga.common;

import akka.actor.typed.ActorRef;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public  class TypedMessageEvent<T> implements IMessageEvent{
    protected T data;
    protected EventType eventType;
    public ActorRef<IMessageEvent> replyTo;
}

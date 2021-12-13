package com.bluecc.saga.common;

public interface IMessageEvent{
    public enum EventType{
        Create(0), Retrieve(1), Update(2), Delete(3),
        Trade(4), Talk(5), Start(6), Stop(7), Timer(8),
        ;

        private final int value;
        EventType(int value){
            this.value=value;
        }

        public int getValue() {
            return value;
        }
    }


}
package com.bluecc.domain.guice;

public interface IEventProvider {
    void onSuccess(EventData eventData, Object eventObject);
    void onFail(EventData eventData, Exception e);
    void onEnd(EventData eventData);
}

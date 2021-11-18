package com.bluecc.domain.event;

import com.bluecc.domain.guice.EventData;
import com.bluecc.domain.guice.IEventProvider;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsoleTracker implements IEventProvider {
    @Override
    public void onSuccess(EventData eventData, Object eventObject) {
        log.info("✔ {}: {}", eventData.toString(), eventObject.toString());
    }

    @Override
    public void onFail(EventData eventData, Exception e) {
        log.info("✖ {}: {}", eventData.toString(), e.getMessage());
    }

    @Override
    public void onEnd(EventData eventData) {
    }
}

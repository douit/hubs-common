package com.bluecc.domain.guice;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EventData {
    String eventName;
    LocalDateTime timestamp;
}

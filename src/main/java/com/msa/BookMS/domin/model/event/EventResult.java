package com.msa.BookMS.domin.model.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class EventResult {
    private EventType eventType;
    private boolean isSuccessed;
    private IDName idName;
    private Item item;
    private long point;
}

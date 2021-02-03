package ru.alexey.event;

import org.springframework.context.ApplicationEvent;

public class TestStartEvent extends ApplicationEvent {

    public TestStartEvent(Object source) {
        super(source);
    }
}

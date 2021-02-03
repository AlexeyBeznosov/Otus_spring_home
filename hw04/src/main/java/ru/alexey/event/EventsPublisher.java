package ru.alexey.event;

import org.springframework.context.ApplicationEvent;

public interface EventsPublisher {
    void publish(ApplicationEvent applicationEvent);
}

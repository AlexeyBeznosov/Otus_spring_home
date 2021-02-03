package ru.alexey.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class EventsPublisherImpl implements EventsPublisher {

    private final ApplicationEventPublisher publisher;

    public EventsPublisherImpl(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(ApplicationEvent applicationEvent) {
        publisher.publishEvent(applicationEvent);
    }
}

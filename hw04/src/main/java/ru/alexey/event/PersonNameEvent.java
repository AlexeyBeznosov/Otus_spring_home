package ru.alexey.event;

import org.springframework.context.ApplicationEvent;
import ru.alexey.domain.Person;

public class PersonNameEvent extends ApplicationEvent {

    private final Person person;

    public PersonNameEvent(Object source, Person person) {
        super(source);
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}

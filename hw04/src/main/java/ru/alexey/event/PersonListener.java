package ru.alexey.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.alexey.service.PersonService;

@Component
public class PersonListener {

    private final PersonService personService;

    public PersonListener(PersonService personService) {
        this.personService = personService;
    }

    @EventListener
    public void setPerson(PersonNameEvent personNameEvent) {
        personService.setPerson(personNameEvent.getPerson());
    }
}

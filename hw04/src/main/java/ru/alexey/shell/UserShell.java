package ru.alexey.shell;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import ru.alexey.domain.Person;
import ru.alexey.event.EventsPublisher;
import ru.alexey.event.PersonNameEvent;
import ru.alexey.event.TestStartEvent;

@ShellComponent
public class UserShell {

    private final Person person = new Person();
    private final EventsPublisher eventsPublisher;
    private boolean isPersonPublished = false;

    public UserShell(EventsPublisher eventsPublisher) {
        this.eventsPublisher = eventsPublisher;
    }

    @ShellMethod(key = "login-name", value = "Enter your name")
    public String loginName(String name) {
        person.setName(name);
        return name;
    }

    @ShellMethod(key = "login-secondname", value = "Enter your second name")
    public String loginSecondName(String secondname) {
        person.setSecondname(secondname);
        return secondname;
    }

    @ShellMethod(value = "Publish event command", key = {"p", "pub", "publish"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public String publishEvent() {
        eventsPublisher.publish(new PersonNameEvent(this, person));
        isPersonPublished = true;
        return "Event published";
    }

    @ShellMethod(key = "start-test", value = "start test")
    @ShellMethodAvailability(value = "isPersonPublishedCommandAvailable")
    public void startTest() {
        eventsPublisher.publish(new TestStartEvent(this));
    }

    private Availability isPersonPublishedCommandAvailable() {
        return isPersonPublished ? Availability.available() : Availability.unavailable("you are not published");
    }

    private Availability isPublishEventCommandAvailable() {
        if (person.getName() != null && person.getSecondname() != null) {
            return Availability.available();
        } else {
            return Availability.unavailable("you are not logined");
        }
    }
}

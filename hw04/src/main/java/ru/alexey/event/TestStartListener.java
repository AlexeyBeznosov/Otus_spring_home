package ru.alexey.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.alexey.application.Testable;

@Component
public class TestStartListener {

    private final Testable myTester;

    public TestStartListener(Testable myTester) {
        this.myTester = myTester;
    }

    @EventListener
    public void startTest(TestStartEvent testStartEvent) {
        myTester.doTest();
    }
}

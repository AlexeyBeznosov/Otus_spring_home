package ru.alexey;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.alexey.Application.MyTesterImpl;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        MyTesterImpl myTesterImpl = context.getBean(MyTesterImpl.class);
        myTesterImpl.doTest();
    }
}

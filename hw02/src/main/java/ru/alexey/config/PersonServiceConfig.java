package ru.alexey.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.alexey.View.QuestionAnswerView;
import ru.alexey.service.PersonService;
import ru.alexey.service.PersonServiceImpl;

@Configuration
public class PersonServiceConfig {

    @Bean
    public PersonService personService(QuestionAnswerView questionAnswerView) {
        return new PersonServiceImpl(questionAnswerView);
    }
}

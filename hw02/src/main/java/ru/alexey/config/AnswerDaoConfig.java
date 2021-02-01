package ru.alexey.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.alexey.dao.AnswerDao;
import ru.alexey.dao.AnswerDaoImpl;

@Configuration
public class AnswerDaoConfig {

    @Bean
    public AnswerDao answerDao() {
        return new AnswerDaoImpl("/Questions.csv");
    }
}

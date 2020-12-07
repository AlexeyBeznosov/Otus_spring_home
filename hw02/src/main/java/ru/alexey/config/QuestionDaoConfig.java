package ru.alexey.config;

import ru.alexey.dao.QuestionDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.alexey.dao.QuestionDaoImpl;

@Configuration
public class QuestionDaoConfig {

    @Bean
    public QuestionDao questionDao() {
        return new QuestionDaoImpl("/Questions.csv");
    }

}

package ru.alexey.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.alexey.dao.AnswerDao;
import ru.alexey.dao.QuestionDao;
import ru.alexey.service.QuestionAnswerService;
import ru.alexey.service.QuestionAnswerServiceImpl;

@Configuration
public class QuestionAnswerServiceConfig {

    @Bean
    public QuestionAnswerService serviceImpl(QuestionDao questionDao, AnswerDao answerDao) {
        return new QuestionAnswerServiceImpl(questionDao, answerDao);
    }
}

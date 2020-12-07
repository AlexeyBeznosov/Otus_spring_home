package ru.alexey.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.alexey.dao.QuestionDao;
import ru.alexey.service.Service;
import ru.alexey.service.ServiceImpl;

@Configuration
public class ServicesConfig {

    @Bean
    public Service serviceImpl(QuestionDao questionDao) {
        return new ServiceImpl(questionDao);
    }
}

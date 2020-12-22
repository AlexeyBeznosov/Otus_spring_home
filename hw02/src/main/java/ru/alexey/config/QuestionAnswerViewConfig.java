package ru.alexey.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.alexey.View.QuestionAnswerView;
import ru.alexey.View.QuestionAnswerViewImpl;

@Configuration
public class QuestionAnswerViewConfig {

    @Bean
    public QuestionAnswerView questionAnswerView() {
        return new QuestionAnswerViewImpl();
    }

}

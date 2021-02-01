package ru.alexey.dao;

import org.springframework.stereotype.Component;
import ru.alexey.config.ApplicationConfig;
import ru.alexey.domain.Question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionDaoImpl implements QuestionDao {

    private final ApplicationConfig applicationConfig;

    public QuestionDaoImpl(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    @Override
    public List<Question> getAllQuestions() {
        String fileName = applicationConfig.getFileNameCsv();
        BufferedReader questionBufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName)));
        return questionBufferedReader.lines().map(p -> new Question(p.split(";")[0])).collect(Collectors.toList());
    }
}

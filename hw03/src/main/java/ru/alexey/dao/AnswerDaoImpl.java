package ru.alexey.dao;

import org.springframework.stereotype.Component;
import ru.alexey.config.ApplicationConfig;
import ru.alexey.domain.Answer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnswerDaoImpl implements AnswerDao {

    private final String fileName;

    public AnswerDaoImpl(ApplicationConfig applicationConfig) {
     this.fileName = applicationConfig.getFileNameCsv();
    }

    @Override
    public List<Answer> getAllAnswers() {
        BufferedReader answerBufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName)));
        return answerBufferedReader.lines().map(p -> new Answer(p.split(";")[1])).collect(Collectors.toList());
    }
}

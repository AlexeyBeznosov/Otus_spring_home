package ru.alexey.dao;

import ru.alexey.domain.Question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionDaoImpl implements QuestionDao {

    private final String fileName;

    public QuestionDaoImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Question> getAllQuestions() {
        BufferedReader questionBufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName)));
        return questionBufferedReader.lines().map(p -> new Question(p.split(";")[0])).collect(Collectors.toList());
    }
}

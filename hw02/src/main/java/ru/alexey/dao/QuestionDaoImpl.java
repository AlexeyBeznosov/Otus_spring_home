package ru.alexey.dao;

import ru.alexey.domain.Answer;
import ru.alexey.domain.Question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionDaoImpl implements QuestionDao {

    private List<Question> questions;
    private List<Answer> answers;

    public QuestionDaoImpl(String fileName) {
        BufferedReader questionBufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName)));
        questions = questionBufferedReader.lines().map(p -> new Question(p.split(";")[0])).collect(Collectors.toList());
        BufferedReader answerBufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName)));
        answers = answerBufferedReader.lines().map(p -> new Answer(p.split(";")[1])).collect(Collectors.toList());
    }

    @Override
    public List<Question> getAllQuestions() {
        return questions;
    }

    @Override
    public List<Answer> getAllAnswers() {
        return answers;
    }
}

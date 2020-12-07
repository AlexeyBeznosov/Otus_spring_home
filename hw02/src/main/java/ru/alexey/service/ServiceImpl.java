package ru.alexey.service;

import ru.alexey.dao.QuestionDao;
import ru.alexey.domain.Answer;
import ru.alexey.domain.Question;

import java.util.List;

public class ServiceImpl implements Service {

    private final QuestionDao dao;

    public ServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Question> getAllQuestions() {
        return dao.getAllQuestions();
    }

    @Override
    public List<Answer> getAllAnswers() {
        return dao.getAllAnswers();
    }
}

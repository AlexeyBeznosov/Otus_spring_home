package ru.alexey.service;

import ru.alexey.dao.AnswerDao;
import ru.alexey.dao.QuestionDao;
import ru.alexey.domain.Answer;
import ru.alexey.domain.Question;

import java.util.List;

public class QuestionAnswerServiceImpl implements QuestionAnswerService {

    private final QuestionDao questionDao;
    private final AnswerDao answerDao;

    public QuestionAnswerServiceImpl(QuestionDao questionDao, AnswerDao answerDao) {
        this.questionDao = questionDao;
        this.answerDao = answerDao;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionDao.getAllQuestions();
    }

    @Override
    public List<Answer> getAllAnswers() {
        return answerDao.getAllAnswers();
    }
}

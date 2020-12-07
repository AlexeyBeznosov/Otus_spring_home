package ru.alexey.dao;

import ru.alexey.domain.Answer;
import ru.alexey.domain.Question;

import java.util.List;

public interface QuestionDao {

    List<Question> getAllQuestions();

    List<Answer> getAllAnswers();
}
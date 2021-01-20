package ru.alexey.service;

import ru.alexey.domain.Answer;
import ru.alexey.domain.Question;

import java.util.List;

public interface QuestionAnswerService {

    List<Question> getAllQuestions();

    List<Answer> getAllAnswers();
}

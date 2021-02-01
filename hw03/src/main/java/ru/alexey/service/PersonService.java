package ru.alexey.service;

import ru.alexey.domain.Answer;
import ru.alexey.domain.Question;

import java.util.List;

public interface PersonService {

    void requestPersonName();

    List<Answer> getPersonAnswers(List<Question> questions);
}

package ru.alexey.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.alexey.domain.Answer;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerDaoImplTest {

    private AnswerDaoImpl answerDao = new AnswerDaoImpl("/testQuestions.csv");

    @Test
    @DisplayName("should get answers from scv")
    void getAllAnswers() {
        List<Answer> listActual = answerDao.getAllAnswers();
        assertThat(listActual.size()).isEqualTo(5);
    }
}

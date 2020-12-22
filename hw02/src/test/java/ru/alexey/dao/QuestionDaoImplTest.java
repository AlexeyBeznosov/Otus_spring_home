package ru.alexey.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.alexey.domain.Question;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class QuestionDaoImplTest {

    private QuestionDaoImpl questionDao = new QuestionDaoImpl("/testQuestions.csv");

    @Test
    @DisplayName("should get questions from scv")
    void getAllQuestions() {
        List<Question> listActual = questionDao.getAllQuestions();
        assertThat(listActual.size()).isEqualTo(5);
    }
}

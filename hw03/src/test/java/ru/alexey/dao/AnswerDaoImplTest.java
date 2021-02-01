package ru.alexey.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.alexey.config.ApplicationConfig;
import ru.alexey.domain.Answer;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AnswerDaoImplTest {

    @Test
    @DisplayName("should get answers from scv")
    void getAllAnswers() {
        ApplicationConfig applicationConfig = mock(ApplicationConfig.class);
        when(applicationConfig.getFileNameCsv()).thenReturn("/testQuestions.csv");
        AnswerDaoImpl answerDao = new AnswerDaoImpl(applicationConfig);
        List<Answer> listActual = answerDao.getAllAnswers();
        assertThat(listActual.size()).isEqualTo(5);
    }
}

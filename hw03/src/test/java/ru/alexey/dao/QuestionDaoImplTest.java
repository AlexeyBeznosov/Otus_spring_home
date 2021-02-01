package ru.alexey.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.alexey.config.ApplicationConfig;
import ru.alexey.domain.Question;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class QuestionDaoImplTest {

    @Test
    @DisplayName("should get questions from scv")
    void getAllQuestions() {
        ApplicationConfig applicationConfig = mock(ApplicationConfig.class);
        when(applicationConfig.getFileNameCsv()).thenReturn("/testQuestions.csv");
        QuestionDaoImpl questionDao = new QuestionDaoImpl(applicationConfig);
        List<Question> listActual = questionDao.getAllQuestions();
        assertThat(listActual.size()).isEqualTo(5);
    }
}

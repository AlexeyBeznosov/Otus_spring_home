package ru.alexey.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import ru.alexey.config.ApplicationConfig;
import ru.alexey.domain.Question;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class CSVLinesDaoImplTest {

    @Test
    @DisplayName("should get questions from csv")
    void getAllQuestions() {
        ApplicationConfig applicationConfig = mock(ApplicationConfig.class);
        when(applicationConfig.getFileNameCsv()).thenReturn("/testQuestions.csv");
        CSVLinesDaoImpl questionDao = new CSVLinesDaoImpl(applicationConfig);
        List<String> listActual = questionDao.getAllCSVLines();
        assertThat(listActual.size()).isEqualTo(5);
    }
}

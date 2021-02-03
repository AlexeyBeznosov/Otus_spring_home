package ru.alexey.service;

import org.assertj.core.api.ListAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import ru.alexey.dao.CSVLinesDao;
import ru.alexey.dao.CSVLinesDaoImpl;
import ru.alexey.domain.Answer;
import ru.alexey.domain.Question;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class QuestionAnswerServiceImplTest {
    private CSVLinesDao csvLinesDao = mock(CSVLinesDaoImpl.class);

    @BeforeEach
    private void setUp() {
        when(csvLinesDao.getAllCSVLines()).thenReturn(List.of("question1;answer1", "question2;answer2", "question3;answer3"));
    }

    @Test
    @DisplayName("should get list questions")
    void testGetAllQuestions() {
        List<Question> listExpected = List.of(new Question("question1"), new Question("question2"), new Question("question3"));
        ListAssert<Question> listAssert = assertThat(new QuestionAnswerServiceImpl(csvLinesDao).getAllQuestions());
        listAssert.isEqualTo(listExpected);
    }

    @Test
    @DisplayName("should get list answers")
    void testGetAllAnswers() {
        List<Answer> listExpected = List.of(new Answer("answer1"), new Answer("answer2"), new Answer("answer3"));
        ListAssert<Answer> listAssert = assertThat(new QuestionAnswerServiceImpl(csvLinesDao).getAllAnswers());
        listAssert.isEqualTo(listExpected);
    }
}

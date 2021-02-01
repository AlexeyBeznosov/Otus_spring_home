package ru.alexey.service;

import org.assertj.core.api.ListAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.alexey.dao.AnswerDaoImpl;
import ru.alexey.dao.QuestionDaoImpl;
import ru.alexey.domain.Answer;
import ru.alexey.domain.Question;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class QuestionAnswerServiceImplTest {
    private QuestionDaoImpl questionDao = mock(QuestionDaoImpl.class);
    private AnswerDaoImpl answerDao = mock(AnswerDaoImpl.class);

    @Test
    @DisplayName("should get list questions")
    void testGetAllQuestions() {
        List<Question> listExpected = List.of(new Question("question1"), new Question("question2"));
        when(questionDao.getAllQuestions()).thenReturn(List.of(new Question("question1"), new Question("question2")));
        ListAssert<Question> listAssert = assertThat(new QuestionAnswerServiceImpl(questionDao, answerDao).getAllQuestions());
        listAssert.isEqualTo(listExpected);
    }

    @Test
    @DisplayName("should get list answers")
    void testGetAllAnswers() {
        List<Answer> listExpected = List.of(new Answer("answer1"), new Answer("answer2"));
        when(answerDao.getAllAnswers()).thenReturn(List.of(new Answer("answer1"), new Answer("answer2")));
        ListAssert<Answer> listAssert = assertThat(new QuestionAnswerServiceImpl(questionDao, answerDao).getAllAnswers());
        listAssert.isEqualTo(listExpected);
    }
}

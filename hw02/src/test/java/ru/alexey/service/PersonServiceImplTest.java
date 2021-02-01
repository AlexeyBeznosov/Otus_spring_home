package ru.alexey.service;

import org.assertj.core.api.ListAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.alexey.View.QuestionAnswerViewImpl;
import ru.alexey.domain.Answer;
import ru.alexey.domain.Question;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


class PersonServiceImplTest {

    private QuestionAnswerViewImpl questionAnswerView;
    private PersonServiceImpl personService;

    @BeforeEach
    private void setUp() {
        questionAnswerView = mock(QuestionAnswerViewImpl.class);
        personService = new PersonServiceImpl(questionAnswerView);
    }

    @Test
    @DisplayName("should enter name")
    void requestPersonName() {
        personService.requestPersonName();
        verify(questionAnswerView, times(1)).showQuestion(eq("Enter name: "));
        verify(questionAnswerView, times(2)).getAnswer();
        verify(questionAnswerView, times(1)).showQuestion(eq("Enter Second name: "));
    }

    @Test
    @DisplayName("should get answers")
    void getPersonAnswers() {
        when(questionAnswerView.getAnswer()).thenReturn("answer1", "answer2", "Answer3");
        List<Question> listQuestion = List.of(new Question("question1"), new Question("question2"), new Question(""));
        ListAssert<Answer> listAssert = assertThat(personService.getPersonAnswers(listQuestion));
        listAssert.isEqualTo(List.of(new Answer("answer1"), new Answer("answer2"), new Answer("Answer3")));
    }
}

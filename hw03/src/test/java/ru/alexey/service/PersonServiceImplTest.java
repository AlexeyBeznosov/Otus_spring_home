package ru.alexey.service;

import org.assertj.core.api.ListAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.alexey.config.ApplicationConfig;
import ru.alexey.domain.Answer;
import ru.alexey.domain.Question;
import ru.alexey.view.QuestionAnswerViewImpl;

import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


class PersonServiceImplTest {

    private QuestionAnswerViewImpl questionAnswerView;
    private PersonServiceImpl personService;

    @BeforeEach
    private void setUp() {
        questionAnswerView = mock(QuestionAnswerViewImpl.class);
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/bundle");
        ApplicationConfig applicationConfig = mock(ApplicationConfig.class);
        when(applicationConfig.getLocale()).thenReturn(Locale.ENGLISH);
        personService = new PersonServiceImpl(questionAnswerView, messageSource, applicationConfig);
    }

    @Test
    @DisplayName("should enter name")
    void requestPersonName() {
        personService.requestPersonName();
        verify(questionAnswerView, times(1)).showQuestion(eq("Enter your name: "));
        verify(questionAnswerView, times(2)).getAnswer();
        verify(questionAnswerView, times(1)).showQuestion(eq("Enter your secondname: "));
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

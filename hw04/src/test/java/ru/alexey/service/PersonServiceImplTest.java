package ru.alexey.service;

import org.assertj.core.api.ListAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.alexey.config.ApplicationConfig;
import ru.alexey.domain.Person;
import ru.alexey.shell.UserShell;
import ru.alexey.domain.Answer;
import ru.alexey.domain.Question;
import ru.alexey.view.QuestionAnswerView;
import ru.alexey.view.QuestionAnswerViewImpl;

import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
class PersonServiceImplTest {

    private QuestionAnswerViewImpl questionAnswerView;
    private PersonServiceImpl personService;

    @BeforeEach
    private void setUp() {
        questionAnswerView = mock(QuestionAnswerViewImpl.class);
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/bundle");
        messageSource.setDefaultLocale(Locale.ENGLISH);
        LocaleMessageApplicationService localeMessageApplicationService = mock(LocaleMessageApplicationServiceImpl.class);
        ApplicationConfig applicationConfig = mock(ApplicationConfig.class);
        when(applicationConfig.getLocale()).thenReturn(Locale.ENGLISH);
        personService = new PersonServiceImpl(questionAnswerView, localeMessageApplicationService);
    }

    @Test
    @DisplayName("should set Person")
    void requestPersonName() {
        Person person = new Person();
        personService.setPerson(person);
        assertThat(personService.getPerson()).isEqualTo(person);
    }

    @Test
    @DisplayName("should get answers")
    void getPersonAnswers() {
        when(questionAnswerView.getAnswer()).thenReturn("answer1", "answer2", "Answer3");
        List<Question> listQuestion = List.of(new Question("question1"), new Question("question2"), new Question("question3"));
        ListAssert<Answer> listAssert = assertThat(personService.getPersonAnswers(listQuestion));
        listAssert.isEqualTo(List.of(new Answer("answer1"), new Answer("answer2"), new Answer("Answer3")));
    }
}

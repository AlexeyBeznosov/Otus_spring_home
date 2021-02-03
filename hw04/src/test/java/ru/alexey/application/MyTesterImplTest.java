package ru.alexey.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.alexey.config.ApplicationConfig;
import ru.alexey.domain.Person;
import ru.alexey.domain.Question;
import ru.alexey.service.*;

import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
class MyTesterImplTest {

    @Test
    @DisplayName("should do test")
    void doTest() {
        QuestionAnswerService questionAnswerService = mock(QuestionAnswerServiceImpl.class);
        PersonService personService = mock(PersonServiceImpl.class);
        when(questionAnswerService.getAllQuestions()).thenReturn(List.of(new Question("question1"), new Question("question2")));
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/bundle");
        messageSource.setDefaultEncoding("UTF-8");
        LocaleMessageApplicationService localeMessageApplicationService = mock(LocaleMessageApplicationServiceImpl.class);
        MyTesterImpl myTester = new MyTesterImpl(questionAnswerService, new ApplicationConfig(), personService, localeMessageApplicationService);

        myTester.doTest();
        verify(questionAnswerService, times(1)).getAllQuestions();
        List<Question> questions = questionAnswerService.getAllQuestions();
        verify(personService, times(1)).getPersonAnswers(questions);
        verify(questionAnswerService, times(1)).getAllAnswers();
    }
}

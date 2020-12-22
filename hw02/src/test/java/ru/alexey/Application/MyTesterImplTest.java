package ru.alexey.Application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.alexey.domain.Question;
import ru.alexey.service.PersonService;
import ru.alexey.service.PersonServiceImpl;
import ru.alexey.service.QuestionAnswerService;
import ru.alexey.service.QuestionAnswerServiceImpl;

import java.util.List;

import static org.mockito.Mockito.*;

class MyTesterImplTest {

    @Test
    @DisplayName("should do test")
    void doTest() {
        QuestionAnswerService questionAnswerService = mock(QuestionAnswerServiceImpl.class);
        PersonService personService = mock(PersonServiceImpl.class);
        when(questionAnswerService.getAllQuestions()).thenReturn(List.of(new Question("question1"), new Question("question2")));
        MyTesterImpl myTester = new MyTesterImpl(questionAnswerService, "3", personService);

        myTester.doTest();
        verify(personService, times(1)).requestPersonName();
        verify(questionAnswerService, times(1)).getAllQuestions();
        List<Question> questions = questionAnswerService.getAllQuestions();
        verify(personService, times(1)).getPersonAnswers(questions);
        verify(questionAnswerService, times(1)).getAllAnswers();
    }
}

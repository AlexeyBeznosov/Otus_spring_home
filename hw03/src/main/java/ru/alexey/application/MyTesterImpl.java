package ru.alexey.application;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import ru.alexey.config.ApplicationConfig;
import ru.alexey.domain.Answer;
import ru.alexey.domain.Question;
import ru.alexey.service.PersonService;
import ru.alexey.service.QuestionAnswerService;

import java.util.List;
import java.util.Locale;

@Component
public class MyTesterImpl implements Testable {

    private ApplicationConfig applicationConfig;
    private QuestionAnswerService questionAnswerService;
    private PersonService personService;
    private MessageSource messageSource;

    public MyTesterImpl(QuestionAnswerService questionAnswerService, ApplicationConfig applicationConfig, PersonService personService, MessageSource messageSource) {
        this.questionAnswerService = questionAnswerService;
        this.applicationConfig = applicationConfig;
        this.personService = personService;
        this.messageSource = messageSource;
    }

    @Override
    public void doTest() {
        int countRightAnswer = 0;
        personService.requestPersonName();
        List<Question> questions = questionAnswerService.getAllQuestions();
        List<Answer> personAnswers = personService.getPersonAnswers(questions);
        List<Answer> answers = questionAnswerService.getAllAnswers();

        for (int i = 0; i < personAnswers.size(); i++) {
            String answer = personAnswers.get(i).getAnswer();
            if (compareAnswer(answers.get(i).getAnswer(), answer)) {
                countRightAnswer++;
            }
        }
        String message = messageSource.getMessage("Score", new String[]{}, applicationConfig.getLocale());
        System.out.print(message + ": " + countRightAnswer);
        if (countRightAnswer >= applicationConfig.getValueRightAnswerPass()) {
            message = messageSource.getMessage("Test passed", new String[]{}, applicationConfig.getLocale());
        } else {
            message = messageSource.getMessage("Test not passed", new String[]{}, applicationConfig.getLocale());
        }
        System.out.println(" " + message);
    }

    private boolean compareAnswer(String rightAnswer, String answer) {
        return rightAnswer.toLowerCase().equals(answer.toLowerCase());
    }
}

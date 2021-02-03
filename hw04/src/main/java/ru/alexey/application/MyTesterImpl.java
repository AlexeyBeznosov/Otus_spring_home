package ru.alexey.application;

import org.springframework.stereotype.Component;
import ru.alexey.config.ApplicationConfig;
import ru.alexey.domain.Answer;
import ru.alexey.domain.Question;
import ru.alexey.service.LocaleMessageApplicationService;
import ru.alexey.service.PersonService;
import ru.alexey.service.QuestionAnswerService;

import java.util.List;

@Component
public class MyTesterImpl implements Testable {

    private ApplicationConfig applicationConfig;
    private QuestionAnswerService questionAnswerService;
    private PersonService personService;
    private LocaleMessageApplicationService localeMessageApplicationService;

    public MyTesterImpl(QuestionAnswerService questionAnswerService, ApplicationConfig applicationConfig,
                        PersonService personService, LocaleMessageApplicationService localeMessageApplicationService) {
        this.questionAnswerService = questionAnswerService;
        this.applicationConfig = applicationConfig;
        this.personService = personService;
        this.localeMessageApplicationService = localeMessageApplicationService;
    }

    @Override
    public void doTest() {
        int countRightAnswer = 0;
        List<Question> questions = questionAnswerService.getAllQuestions();
        List<Answer> personAnswers = personService.getPersonAnswers(questions);
        List<Answer> answers = questionAnswerService.getAllAnswers();

        for (int i = 0; i < personAnswers.size(); i++) {
            String answer = personAnswers.get(i).getAnswer();
            if (compareAnswer(answers.get(i).getAnswer(), answer)) {
                countRightAnswer++;
            }
        }
        String message = localeMessageApplicationService.localeMessage("Score");
        System.out.print(message + ": " + countRightAnswer);
        if (countRightAnswer >= applicationConfig.getValueRightAnswerPass()) {
            message = localeMessageApplicationService.localeMessage("Test passed");
        } else {
            message = localeMessageApplicationService.localeMessage("Test not passed");
        }
        System.out.println(" " + message);
    }

    private boolean compareAnswer(String rightAnswer, String answer) {
        return rightAnswer.toLowerCase().equals(answer.toLowerCase());
    }
}

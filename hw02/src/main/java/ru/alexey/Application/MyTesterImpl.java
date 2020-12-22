package ru.alexey.Application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.alexey.domain.Answer;
import ru.alexey.domain.Question;
import ru.alexey.service.PersonService;
import ru.alexey.service.QuestionAnswerService;

import java.util.List;

@Component
@PropertySource("classpath:Test.property")
public class MyTesterImpl implements Testable {

    private List<Answer> answers;
    private List<Question> questions;
    private QuestionAnswerService questionAnswerService;
    private PersonService personService;
    private int valueRightAnswerPass;

    public MyTesterImpl(QuestionAnswerService questionAnswerService, @Value("${valueRightAnswerPass}") String valueRightAnswerPass, PersonService personService) {
        this.questionAnswerService = questionAnswerService;
        this.valueRightAnswerPass = Integer.parseInt(valueRightAnswerPass);
        this.personService = personService;
    }

    @Override
    public void doTest() {
        int countRightAnswer = 0;
        personService.requestPersonName();
        questions = questionAnswerService.getAllQuestions();
        List<Answer> personAnswers = personService.getPersonAnswers(questions);
        answers = questionAnswerService.getAllAnswers();

        for (int i = 0; i < personAnswers.size(); i++) {
            String answer = personAnswers.get(i).getAnswer();
            if (compareAnswer(answers.get(i).getAnswer(), answer)) {
                countRightAnswer++;
            }
        }
        if (countRightAnswer >= valueRightAnswerPass) {
            System.out.println("Score: " + countRightAnswer + " - Test passed");
        } else {
            System.out.println("Score: " + countRightAnswer + " - Test not passed");
        }

    }

    private boolean compareAnswer(String rightAnswer, String answer) {
        return rightAnswer.toLowerCase().equals(answer.toLowerCase());
    }
}

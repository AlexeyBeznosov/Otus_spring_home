package ru.alexey.Application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.alexey.domain.Answer;
import ru.alexey.domain.Question;
import ru.alexey.service.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Component
@PropertySource("classpath:Test.property")
public class MyTester {

    private String name;
    private String secondname;
    private List<Answer> answers;
    private List<Question> questions;
    private Service service;
    private int valueRightAnswerPass;

    public MyTester(Service service, @Value("${valueRightAnswerPass}") String valueRightAnswerPass) {
        this.service = service;
        this.valueRightAnswerPass = Integer.parseInt(valueRightAnswerPass);
    }

    public void doTest() {
        int countRightAnswer = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            requestName(reader);
            questions = service.getAllQuestions();
            answers = service.getAllAnswers();
            for (int i = 0; i < questions.size(); i++) {
                String answer = requestAnswer(reader, questions.get(i));
                if (compareAnswer(answers.get(i).getAnswer(), answer)) {
                    countRightAnswer++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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

    private String requestAnswer(BufferedReader reader, Question question) throws IOException {
        System.out.println("Answer the question: " + question.getQuestion());
        return reader.readLine();
    }

    private void requestName(BufferedReader reader) throws IOException {
        System.out.println("Enter name: ");
        name = reader.readLine();
        System.out.println("Enter Second name: ");
        secondname = reader.readLine();
    }
}

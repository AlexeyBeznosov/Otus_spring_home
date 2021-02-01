package ru.alexey.service;

import ru.alexey.View.QuestionAnswerView;
import ru.alexey.domain.Answer;
import ru.alexey.domain.Question;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceImpl implements PersonService {

    private final QuestionAnswerView questionAnswerView;

    public PersonServiceImpl(QuestionAnswerView questionAnswerView) {
        this.questionAnswerView = questionAnswerView;
    }

    @Override
    public void requestPersonName() {
        questionAnswerView.showQuestion("Enter name: ");
        String name = questionAnswerView.getAnswer();
        questionAnswerView.showQuestion("Enter Second name: ");
        String secondname = questionAnswerView.getAnswer();
    }

    @Override
    public List<Answer> getPersonAnswers(List<Question> questions) {
        List<Answer> answers = new ArrayList<>();
        for (Question question : questions) {
            questionAnswerView.showQuestion("Answer the question: " + question.getQuestion());
            answers.add(new Answer(questionAnswerView.getAnswer()));
        }
        return answers;
    }
}

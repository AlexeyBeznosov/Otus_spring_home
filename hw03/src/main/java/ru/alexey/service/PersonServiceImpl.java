package ru.alexey.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.alexey.config.ApplicationConfig;
import ru.alexey.view.QuestionAnswerView;
import ru.alexey.domain.Answer;
import ru.alexey.domain.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class PersonServiceImpl implements PersonService {

    private final QuestionAnswerView questionAnswerView;
    private final MessageSource messageSource;
    private final Locale locale;

    public PersonServiceImpl(QuestionAnswerView questionAnswerView, MessageSource messageSource, ApplicationConfig applicationConfig) {
        this.questionAnswerView = questionAnswerView;
        this.locale = applicationConfig.getLocale();
        this.messageSource = messageSource;
    }

    @Override
    public void requestPersonName() {
        String message = messageSource.getMessage("Enter name", new String[]{}, locale);
        questionAnswerView.showQuestion(message + ": ");
        String name = questionAnswerView.getAnswer();
        message = messageSource.getMessage("Enter secondname", new String[]{}, locale);
        questionAnswerView.showQuestion(message + ": ");
        String secondname = questionAnswerView.getAnswer();
    }

    @Override
    public List<Answer> getPersonAnswers(List<Question> questions) {
        List<Answer> answers = new ArrayList<>();
        String message = messageSource.getMessage("Answer the question", new String[]{}, locale);
        for (Question question : questions) {
            questionAnswerView.showQuestion(message + ": " + question.getQuestion());
            answers.add(new Answer(questionAnswerView.getAnswer()));
        }
        return answers;
    }
}

package ru.alexey.service;

import org.springframework.stereotype.Service;
import ru.alexey.domain.Answer;
import ru.alexey.domain.Person;
import ru.alexey.domain.Question;
import ru.alexey.shell.UserShell;
import ru.alexey.view.QuestionAnswerView;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final QuestionAnswerView questionAnswerView;
    private final LocaleMessageApplicationService localeMessageApplicationService;
    private Person person;

    public PersonServiceImpl(QuestionAnswerView questionAnswerView,
                             LocaleMessageApplicationService localeMessageApplicationService) {
        this.questionAnswerView = questionAnswerView;
        this.localeMessageApplicationService = localeMessageApplicationService;
    }

    @Override
    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public Person getPerson() {
        return person;
    }

    @Override
    public List<Answer> getPersonAnswers(List<Question> questions) {
        List<Answer> answers = new ArrayList<>();
        String message = localeMessageApplicationService.localeMessage("Answer the question");
        for (Question question : questions) {
            questionAnswerView.showQuestion(message + ": " + question.getQuestion());
            answers.add(new Answer(questionAnswerView.getAnswer()));
        }
        return answers;
    }
}

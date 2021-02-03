package ru.alexey.service;

import org.springframework.stereotype.Service;
import ru.alexey.dao.CSVLinesDao;
import ru.alexey.domain.Answer;
import ru.alexey.domain.Question;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionAnswerServiceImpl implements QuestionAnswerService {

    private final CSVLinesDao csvLinesDao;

    public QuestionAnswerServiceImpl(CSVLinesDao csvLinesDao) {
        this.csvLinesDao = csvLinesDao;
    }

    @Override
    public List<Question> getAllQuestions() {
        return csvLinesDao.getAllCSVLines().stream().map(p -> new Question(p.split(";")[0])).collect(Collectors.toList());
    }

    @Override
    public List<Answer> getAllAnswers() {
        return csvLinesDao.getAllCSVLines().stream().map(p -> new Answer(p.split(";")[1])).collect(Collectors.toList());
    }
}

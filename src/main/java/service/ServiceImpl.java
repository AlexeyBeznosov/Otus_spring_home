package service;

import Domain.Question;
import dao.DaoImpl;

import java.util.List;

public class ServiceImpl {

    private final DaoImpl dao;

    public ServiceImpl(DaoImpl dao) {
        this.dao = dao;
    }

    public List<Question> getAllQuestions() {
        return dao.getAllQuestions();
    }
}

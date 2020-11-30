package dao;

import Domain.Question;
import storage.StorageImpl;

import java.util.List;

public class DaoImpl {

    private final StorageImpl storage;

    public DaoImpl(StorageImpl storage) {
        this.storage = storage;
    }

    public List<Question> getAllQuestions() {
        return storage.getAllQuestions();
    }
}

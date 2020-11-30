package storage;

import Domain.Question;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StorageImpl {
    private List<Question> questions = new ArrayList<>();

    public StorageImpl(File file) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            questions = fileReader.lines().map(p -> new Question(p.split(";")[0])).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Question> getAllQuestions() {
        return questions;
    }


}

package ru.alexey.view;

import org.springframework.stereotype.Component;
import ru.alexey.exception.MyIOException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class QuestionAnswerViewImpl implements QuestionAnswerView {

    private final BufferedReader reader;

    public QuestionAnswerViewImpl() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public QuestionAnswerViewImpl(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public void showQuestion(String message) {
        System.out.println(message);
    }

    @Override
    public String getAnswer() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new MyIOException("IOException", e);
        }
    }
}

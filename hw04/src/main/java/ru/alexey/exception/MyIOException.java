package ru.alexey.exception;

import java.io.IOException;

public class MyIOException extends RuntimeException {

    public MyIOException(String message, IOException e) {
        super(message, e);
    }
}

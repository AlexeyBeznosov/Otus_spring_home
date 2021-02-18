package ru.alexey.event;

import org.springframework.context.ApplicationEvent;
import ru.alexey.domain.Book;

public class BookReadEvent extends ApplicationEvent {

    private final Book book;

    public BookReadEvent(Object source, Book book) {
        super(source);
        this.book = book;
    }

    public Book getBook() {
        return book;
    }
}

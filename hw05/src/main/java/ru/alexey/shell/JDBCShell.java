package ru.alexey.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.alexey.domain.Author;
import ru.alexey.domain.Book;
import ru.alexey.domain.Genre;
import ru.alexey.event.*;

@ShellComponent
public class JDBCShell {

    private final EventsPublisher eventsPublisher;

    public JDBCShell(EventsPublisher eventsPublisher) {
        this.eventsPublisher = eventsPublisher;
    }

    @ShellMethod(key = "insert-book", value = "Enter booktitle author genre")
    public void insertBook(String title, String authorName, String genreName) {
        Book book = new Book(title);
        book.setAuthor(new Author(authorName));
        book.setGenre(new Genre(genreName));
        eventsPublisher.publish(new BookInsertEvent(this, book));
    }

    @ShellMethod(key = "read-book", value = "Enter book title")
    public void readBook(String title) {
        Book book = new Book(title);
        eventsPublisher.publish(new BookReadEvent(this, book));
    }

    @ShellMethod(key = "update-book", value = "Enter new book title author genre")
    public void updateBook(Long id, String title, String authorName, String genreName) {
        Book book = new Book(title);
        book.setId(id);
        book.setAuthor(new Author(authorName));
        book.setGenre(new Genre(genreName));
        eventsPublisher.publish(new BookUpdateEvent(this, book));
    }

    @ShellMethod(key = "delete-book", value = "Enter delete book title author genre")
    public void deleteBook(Long id) {
        Book book = new Book("deletebook");
        book.setId(id);
        eventsPublisher.publish(new BookDeleteEvent(this, book));
    }
}

package ru.alexey.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.alexey.domain.Book;
import ru.alexey.service.BookService;

@Component
public class BookListener {

    private final BookService bookService;

    public BookListener(BookService bookService) {
        this.bookService = bookService;
    }

    @EventListener
    public void insertBook(BookInsertEvent bookInsertEvent) {
        bookService.insert(bookInsertEvent.getBook());
    }

    @EventListener
    public void readBook(BookReadEvent bookReadEvent) {
        Book book = bookService.getByName(bookReadEvent.getBook().getTitle());
        System.out.println(book);
    }

    @EventListener
    public void updateBook(BookUpdateEvent bookUpdateEvent) {
        bookService.update(bookUpdateEvent.getBook());
    }

    @EventListener
    public void deleteBook(BookDeleteEvent bookDeleteEvent) {
        bookService.delete(bookDeleteEvent.getBook());
    }
}

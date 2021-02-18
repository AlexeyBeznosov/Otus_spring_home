package ru.alexey.service;

import ru.alexey.domain.Book;

public interface BookService {

    void insert(Book book);

    Book getByName(String title);

    void update(Book book);

    void delete(Book book);
}

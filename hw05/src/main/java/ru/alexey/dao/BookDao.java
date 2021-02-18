package ru.alexey.dao;

import ru.alexey.domain.Book;

public interface BookDao {

    void insert(Book book);

    Book getByName(String title);

    Book getById(Long id);

    void delete(Long id);

    void update(Book book);

    int count();
}

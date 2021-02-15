package ru.alexey.dao;

import ru.alexey.domain.Author;

public interface AuthorDao {

    void insert(Author author);

    Author getById(Long id);

    Author getByName(String name);
}

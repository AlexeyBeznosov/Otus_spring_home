package ru.alexey.service;

import ru.alexey.domain.Author;

public interface AuthorService {

    void init(Author author);

    Author getByName(String name);

    void insert(Author author);
}

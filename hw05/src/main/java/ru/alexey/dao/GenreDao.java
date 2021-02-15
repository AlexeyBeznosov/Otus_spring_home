package ru.alexey.dao;

import ru.alexey.domain.Genre;

public interface GenreDao {

    void insert(Genre genre);

    Genre getById(Long id);

    Genre getByName(String name);
}

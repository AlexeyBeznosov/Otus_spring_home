package ru.alexey.service;

import ru.alexey.domain.Genre;

public interface GenreService {

    void init(Genre genre);

    Genre getByName(String name);

    void insert(Genre genre);
}

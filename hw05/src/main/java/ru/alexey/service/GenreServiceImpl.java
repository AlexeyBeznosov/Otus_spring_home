package ru.alexey.service;

import org.springframework.stereotype.Service;
import ru.alexey.dao.GenreDao;
import ru.alexey.domain.Author;
import ru.alexey.domain.Genre;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreDao genreDao;
    private Long id = 1L;

    public GenreServiceImpl(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public void init(Genre genre) {
        Genre findGenre = getByName(genre.getName());
        if (findGenre != null) {
            genre.setId(findGenre.getId());
        } else {
            genre.setId(++id);
            genreDao.insert(genre);
        }
    }

    @Override
    public Genre getByName(String name) {
        return genreDao.getByName(name);
    }

    @Override
    public void insert(Genre genre) {
        genreDao.insert(genre);
    }
}

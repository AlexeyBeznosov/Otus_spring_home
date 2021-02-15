package ru.alexey.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.alexey.domain.Author;
import ru.alexey.domain.Genre;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@JdbcTest
@Import({GenreDaoJDBC.class, GenreRowMapper.class})
@Transactional(propagation = Propagation.NOT_SUPPORTED)
class GenreDaoJDBCTest {

    @Autowired
    private GenreDao genreDao;

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @Test
    @DisplayName("should insert genre")
    void insert() {
        Genre genre = new Genre(20L, "Genre1");
        genreDao.insert(genre);
        assertThat(genreDao.getById(genre.getId())).isEqualTo(genre);
    }

    @Test
    @DisplayName("should read genre by id")
    void getById() {
        Genre genre = new Genre(21L, "Genre2");
        genreDao.insert(genre);
        assertThat(genreDao.getById(genre.getId())).isEqualTo(genre);
    }

    @Test
    @DisplayName("should read genre by name")
    void getByName() {
        Genre genre = new Genre(22L, "Genre3");
        genreDao.insert(genre);
        assertThat(genreDao.getByName(genre.getName())).isEqualTo(genre);
    }
}

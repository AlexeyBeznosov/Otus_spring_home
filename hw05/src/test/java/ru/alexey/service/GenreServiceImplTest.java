package ru.alexey.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.alexey.dao.GenreDao;
import ru.alexey.dao.GenreDaoJDBC;
import ru.alexey.domain.Genre;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class GenreServiceImplTest {

    private static final GenreDao GENRE_DAO = mock(GenreDaoJDBC.class);
    private static final GenreService GENRE_SERVICE = new GenreServiceImpl(GENRE_DAO);
    private static final Genre GENRE = new Genre("Genre");
    private static final Genre GENRE1 = new Genre(1L,"Genre1");

    @BeforeEach
    void setUp() {
        when(GENRE_DAO.getByName("Genre1")).thenReturn(new Genre(1L, "Genre1"));
    }

    @Test
    @DisplayName("should init Genre")
    void init() {
        GENRE_SERVICE.init(GENRE);
        assertThat(GENRE.getId()).isNotNull();
    }

    @Test
    @DisplayName("should get Genre by name")
    void getByName() {
        assertThat(GENRE_SERVICE.getByName("Genre1")).isEqualTo(GENRE1);
    }

    @Test
    @DisplayName("should insert Genre")
    void insert() {
        GENRE_SERVICE.insert(GENRE1);
        verify(GENRE_DAO, times(1)).insert(GENRE1);
    }
}

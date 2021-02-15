package ru.alexey.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.alexey.dao.AuthorDao;
import ru.alexey.dao.AuthorDaoJDBC;
import ru.alexey.domain.Author;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class AuthorServiceImplTest {

    private static final AuthorDao AUTHOR_DAO = mock(AuthorDaoJDBC.class);
    private static final AuthorService AUTHOR_SERVICE = new AuthorServiceImpl(AUTHOR_DAO);
    private static final Author AUTHOR = new Author("Author");
    private static final Author AUTHOR1 = new Author(1L,"Author1");

    @BeforeEach
    void setUp() {
        when(AUTHOR_DAO.getByName("Author1")).thenReturn(new Author(1L, "Author1"));
    }

    @Test
    @DisplayName("should init Author")
    void init() {
        AUTHOR_SERVICE.init(AUTHOR);
        assertThat(AUTHOR.getId()).isNotNull();
    }

    @Test
    @DisplayName("should get Author by name")
    void getByName() {
        assertThat(AUTHOR_SERVICE.getByName("Author1")).isEqualTo(AUTHOR1);
    }

    @Test
    @DisplayName("should insert Author")
    void insert() {
        AUTHOR_SERVICE.insert(AUTHOR1);
        verify(AUTHOR_DAO, times(1)).insert(AUTHOR1);
    }
}

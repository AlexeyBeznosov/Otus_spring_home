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

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Import({AuthorDaoJDBC.class, AuthorRowMapper.class})
@Transactional(propagation = Propagation.NOT_SUPPORTED)
class AuthorDaoJDBCTest {

    @Autowired
    private AuthorDao authorDao;

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @Test
    @DisplayName("should insert author")
    void insert() {
        Author author = new Author(20L, "Author1");
        authorDao.insert(author);
        assertThat(authorDao.getById(author.getId())).isEqualTo(author);
    }

    @Test
    @DisplayName("should read author by id")
    void getById() {
        Author author = new Author(21L, "Author2");
        authorDao.insert(author);
        assertThat(authorDao.getById(author.getId())).isEqualTo(author);
    }

    @Test
    @DisplayName("should read author by name")
    void getByName() {
        Author author = new Author(22L, "Author3");
        authorDao.insert(author);
        assertThat(authorDao.getByName(author.getName())).isEqualTo(author);
    }
}

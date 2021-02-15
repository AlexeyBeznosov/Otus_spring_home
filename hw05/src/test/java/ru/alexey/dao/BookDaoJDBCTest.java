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
import ru.alexey.domain.Book;
import ru.alexey.domain.Genre;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Import({BookDaoJDBC.class, BookRowMapper.class, AuthorDaoJDBC.class, GenreDaoJDBC.class, AuthorRowMapper.class, GenreRowMapper.class})
@Transactional(propagation = Propagation.NOT_SUPPORTED)
class BookDaoJDBCTest {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private GenreDao genreDao;

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @Test
    @DisplayName("should insert book")
    void insert() {
        Author author = new Author(20L, "Author1");
        Genre genre = new Genre(20L, "Genre1");
        Book book = new Book(20L, "insert_book", author, genre);
        insert(book);
        assertThat(bookDao.getByName("insert_book")).isEqualTo(book);
    }

    @Test
    @DisplayName("should read book by name")
    void getByName() {
        Author author = new Author(21L, "Author2");
        Genre genre = new Genre(21L, "Genre2");
        Book book = new Book(21L, "get_book_name", author, genre);
        insert(book);
        assertThat(bookDao.getByName("get_book_name")).isEqualTo(book);
    }

    @Test
    @DisplayName("should read book by id")
    void getById() {
        Author author = new Author(24L, "Author2");
        Genre genre = new Genre(24L, "Genre2");
        Book book = new Book(24L, "get_book_id", author, genre);
        insert(book);
        assertThat(bookDao.getById(book.getId())).isEqualTo(book);
    }

    @Test
    @DisplayName("should update book")
    void update() {
        Author author = new Author(22L, "Author3");
        Genre genre = new Genre(22L, "Genre3");
        Book book = new Book(22L, "update_book", author, genre);
        insert(book);
        book.setTitle("new_book");
        bookDao.update(book);
        assertThat(bookDao.getByName("new_book")).isEqualTo(book);
    }

    @Test
    @DisplayName("should delete book by name")
    void delete() {
        Author author = new Author(23L, "Author4");
        Genre genre = new Genre(23L, "Genre4");
        Book book = new Book(23L, "delete_book", author, genre);
        insert(book);
        bookDao.delete(book.getId());
        assertThat(bookDao.getByName(book.getTitle())).isNull();
    }

    private void insert(Book book) {
        authorDao.insert(book.getAuthor());
        genreDao.insert(book.getGenre());
        bookDao.insert(book);
    }
}

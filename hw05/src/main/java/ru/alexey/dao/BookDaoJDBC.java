package ru.alexey.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.alexey.domain.Author;
import ru.alexey.domain.Book;
import ru.alexey.domain.Genre;

import java.util.Map;

@Repository
public class BookDaoJDBC implements BookDao {

    private final NamedParameterJdbcOperations jdbc;
    private final BookRowMapper bookRowMapper;

    public BookDaoJDBC(NamedParameterJdbcOperations jdbc, BookRowMapper bookRowMapper) {
        this.jdbc = jdbc;
        this.bookRowMapper = bookRowMapper;
    }

    @Override
    public void insert(Book book) {
        Author author = book.getAuthor();
        Genre genre = book.getGenre();
        jdbc.update("insert into book (id, title, id_author, id_genre) values (:id, :title, :id_author, :id_genre)",
                Map.of("id", book.getId(), "title", book.getTitle(), "id_author",
                        author.getId(), "id_genre", genre.getId()));
    }

    @Override
    public Book getByName(String title) {
        try {
            return jdbc.queryForObject("select id, title, id_author, id_genre from book where title = :title",
                    Map.of("title", title), bookRowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Book getById(Long id) {
        try {
            return jdbc.queryForObject("select id, title, id_author, id_genre from book where id = :id",
                    Map.of("id", id), bookRowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void update(Book book) {
        jdbc.update("update book set title = :title, id_author = :id_author, id_genre = :id_genre where id = :id",
                Map.of("title", book.getTitle(), "id", book.getId(), "id_author",
                        book.getAuthor().getId(), "id_genre", book.getGenre().getId()));
    }

    @Override
    public void delete(Long id) {
        jdbc.update("delete from book where id = :id",
                Map.of("id", id));
    }

    @Override
    public int count() {
        return jdbc.getJdbcOperations().queryForObject("select count(*) from book", Integer.class);
    }
}

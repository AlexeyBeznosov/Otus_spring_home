package ru.alexey.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.alexey.domain.Author;
import ru.alexey.domain.Book;
import ru.alexey.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BookRowMapper implements RowMapper<Book> {

    private final AuthorDao authorJDBC;
    private final GenreDao genreJDBC;

    public BookRowMapper(AuthorDao authorJDBC, GenreDao genreJDBC) {
        this.authorJDBC = authorJDBC;
        this.genreJDBC = genreJDBC;
    }

    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Long id = resultSet.getLong("id");
        String title = resultSet.getString("title");
        Long id_author = resultSet.getLong("id_author");
        Long id_genre = resultSet.getLong("id_genre");
        Author author = authorJDBC.getById(id_author);
        Genre genre = genreJDBC.getById(id_genre);
        return new Book(id, title, author, genre);
    }
}

package ru.alexey.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.alexey.domain.Author;
import ru.alexey.domain.Book;
import ru.alexey.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Long id = resultSet.getLong("id");
        String title = resultSet.getString("title");
        Long id_author = resultSet.getLong("id_author");
        String name_author = resultSet.getString("name_author");
        Long id_genre = resultSet.getLong("id_genre");
        String name_genre = resultSet.getString("name_genre");
        return new Book(id, title, new Author(id_author, name_author), new Genre(id_genre, name_genre));
    }
}

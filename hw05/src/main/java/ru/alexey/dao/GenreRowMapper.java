package ru.alexey.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.alexey.domain.Author;
import ru.alexey.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreRowMapper implements RowMapper<Genre> {

    @Override
    public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        return new Genre(id, name);
    }
}
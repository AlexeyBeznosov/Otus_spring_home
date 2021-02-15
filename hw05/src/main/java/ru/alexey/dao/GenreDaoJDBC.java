package ru.alexey.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.alexey.domain.Genre;

import java.util.Map;

@Repository
public class GenreDaoJDBC implements GenreDao {

    private final NamedParameterJdbcOperations jdbc;

    public GenreDaoJDBC(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void insert(Genre genre) {
        jdbc.update("insert into genre (id, name) values (:id, :name)",
                Map.of("id", genre.getId(), "name", genre.getName()));
    }

    @Override
    public Genre getById(Long id) {
        return jdbc.queryForObject("select id, name from genre where id = :id", Map.of("id", id), new GenreRowMapper());
    }

    @Override
    public Genre getByName(String name) {
        try {
            return jdbc.queryForObject("select id, name from genre where name = :name", Map.of("name", name), new GenreRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}

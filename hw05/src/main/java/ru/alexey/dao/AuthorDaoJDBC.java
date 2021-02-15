package ru.alexey.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.alexey.domain.Author;

import java.util.Map;

@Repository
public class AuthorDaoJDBC implements AuthorDao {

    private final NamedParameterJdbcOperations jdbc;

    public AuthorDaoJDBC(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void insert(Author author) {
        jdbc.update("insert into author (id, name) values (:id, :name)",
                Map.of("id", author.getId(), "name", author.getName()));
    }

    @Override
    public Author getById(Long id) {
        return jdbc.queryForObject("select id, name from author where id = :id", Map.of("id", id), new AuthorRowMapper());
    }

    @Override
    public Author getByName(String name) {
        try {
            return jdbc.queryForObject("select id, name from author where name = :name", Map.of("name", name), new AuthorRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}

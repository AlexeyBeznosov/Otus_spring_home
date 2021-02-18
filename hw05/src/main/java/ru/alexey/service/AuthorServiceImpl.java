package ru.alexey.service;

import org.springframework.stereotype.Service;
import ru.alexey.dao.AuthorDao;
import ru.alexey.domain.Author;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorDao authorDao;
    private Long id = 1L;

    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public void init(Author author) {
        Author findAuthor = getByName(author.getName());
        if (findAuthor != null) {
            author.setId(findAuthor.getId());
        } else {
            author.setId(++id);
            insert(author);
        }
    }

    @Override
    public Author getByName(String name) {
        return authorDao.getByName(name);
    }

    @Override
    public void insert(Author author) {
        authorDao.insert(author);
    }
}

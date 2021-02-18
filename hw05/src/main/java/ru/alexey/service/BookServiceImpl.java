package ru.alexey.service;

import org.springframework.stereotype.Service;
import ru.alexey.dao.BookDao;
import ru.alexey.domain.Book;

@Service
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;
    private final AuthorService authorService;
    private final GenreService genreService;
    private Long id = 1L;

    public BookServiceImpl(BookDao bookDao, AuthorService authorService, GenreService genreService) {
        this.bookDao = bookDao;
        this.authorService = authorService;
        this.genreService = genreService;
    }

    @Override
    public void insert(Book book) {
        book.setId(++id);
        init(book);
        bookDao.insert(book);
    }

    @Override
    public Book getByName(String title) {
        return bookDao.getByName(title);
    }

    @Override
    public void update(Book book) {
        init(book);
        bookDao.update(book);
    }

    @Override
    public void delete(Book book) {
        bookDao.delete(book.getId());
    }

    private void init(Book book) {
        authorService.init(book.getAuthor());
        genreService.init(book.getGenre());
    }
}

package ru.alexey.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.alexey.dao.BookDao;
import ru.alexey.dao.BookDaoJDBC;
import ru.alexey.domain.Author;
import ru.alexey.domain.Book;
import ru.alexey.domain.Genre;

import static org.mockito.Mockito.*;

class BookServiceImplTest {

    private static final Long ID = 2L;
    private static final Author AUTHOR = new Author(ID, "Author");
    private static final Genre GENRE = new Genre(ID, "Genre");
    private static final Book EXPECTED_BOOK = new Book(ID, "book", AUTHOR, GENRE);
    private static final BookDao BOOK_DAO = mock(BookDaoJDBC.class);
    private static final AuthorService AUTHOR_SERVICE = mock(AuthorServiceImpl.class);
    private static final GenreService GENRE_SERVICE = mock(GenreServiceImpl.class);
    private static final BookService BOOK_SERVICE = new BookServiceImpl(BOOK_DAO, AUTHOR_SERVICE, GENRE_SERVICE);
    private static final Book book = new Book("book");

    @BeforeEach
    void setUp() {
        when(BOOK_DAO.getByName("book")).thenReturn(EXPECTED_BOOK);
    }

    @Test
    @DisplayName("should verify insert book")
    void insert() {
        book.setAuthor(AUTHOR);
        book.setGenre(GENRE);
        BOOK_SERVICE.insert(book);
        verify(AUTHOR_SERVICE, times(1)).init(AUTHOR);
        verify(GENRE_SERVICE, times(1)).init(GENRE);
        verify(BOOK_DAO, times(1)).insert(book);
    }

    @Test
    @DisplayName("should verify get book by name")
    void getByName() {
        BOOK_SERVICE.getByName(book.getTitle());
        verify(BOOK_DAO, times(1)).getByName("book");
    }

    @Test
    @DisplayName("should verify update book")
    void update() {
        BOOK_SERVICE.update(book);
        verify(BOOK_DAO, times(1)).update(book);
    }

    @Test
    @DisplayName("should verify delete book")
    void delete() {
        BOOK_SERVICE.delete(book);
        verify(BOOK_DAO, times(1)).delete(book.getId());
    }
}

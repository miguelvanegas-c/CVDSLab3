package edu.eci.cvds.tdd.library;

import edu.eci.cvds.tdd.library.book.Book;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;

    @BeforeEach
    public void setUp(){
        library = new Library();
    }
    @Test
    public void testAddBookRegisterNewBook(){
        Book book = new Book("nicolicas", "nianduro", "miguelicas");
        assertTrue(library.addBook(book));
    }
    @Te
}

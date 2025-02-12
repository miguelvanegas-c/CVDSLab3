package edu.eci.cvds.tdd.library;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.user.User;
import edu.eci.cvds.tdd.library.loan.Loan;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;

    @BeforeEach
    public void setUp(){
        library = new Library();
    }
    @Test
    public void testAddBookRegisterNewBookWithoutProblem(){
        Book book = new Book("nicolicas", "nianduro", "miguelicas");
        assertTrue(library.addBook(book));
    }
    @Test
    public void testAddBookNotRegisterBookBecauseBookIsNull(){
        assertFalse(library.addBook(null));
    }
    @Test
    public void testLoanABookCreateNewLoanWithoutProblem(){
        Book book = new Book("nicolicas", "nianduro", "miguelicas");
        library.addBook(book);
        User user = new User();
        user.setId("nicolicas");
        Loan loan = library.loanABook("nicolicas", "nianduro");
        assertNotNull(loan);
    }

    @Test
    public void testLoanABookNotCreateNewLoanBecauseBookNotAvaible(){
        User user = new User();
        user.setId("nicolicas");
        Loan loan = library.loanABook("nicolicas", "nianduro");
        assertNull(loan);
    }

    @Test
    public void testLoanABookNotCreateNewLoanBecauseBookIsNull(){
        Loan loan = library.loanABook("nicolicas", null);
        assertNull(loan);
    }

    @Test
    public void testLoanABookNotCreateNewLoanBecauseUserIsNull(){
        Loan loan = library.loanABook(null, "miguelicas");
        assertNull(loan);
    }

    @Test
    public void testLoanABookNotCreateNewLoanBecauseUserNotExist(){
        Book book = new Book("nicolicas", "nianduro", "miguelicas");
        library.addBook(book);
        Loan loan = library.loanABook("nicolicas", "nianduro");
        assertNull(loan);
    }

    @Test
    public void testLoanABookNotCreateNewLoanBecauseUserHaveLoanWithBook(){
        Book book = new Book("nicolicas", "nianduro", "miguelicas");
        library.addBook(book);
        User user = new User();
        user.setId("nicolicas");
        Loan loan = library.loanABook("nicolicas", "nianduro");
        Loan loan2 = library.loanABook("nicolicas", "nianduro");
        assertNull(loan2);
    }
}
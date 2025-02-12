package edu.eci.cvds.tdd.library;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

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
    public void testReturnLoanReturnLoanWithoutProblem(){
        Book book = new Book("nicolicas", "nianduro", "nianduro");
        library.addBook(book);
        Loan loan = library.loanABook("nicolicas", "nianduro");
        assertEquals(loan,library.returnLoan(loan));
    }

    @Test
    public void testReturnLoanNotReturnLoanBecauseLoanIsNull(){
        assertNull(library.returnLoan(null));
    }

    @Test
    public void testReturnLoanNotReturnLoanBecauseLoanNotExist(){
        Loan loan = new Loan();
        assertNull(library.returnLoan(loan));
    }

    @Test
    public void testReturnLoanReturnDateIsGood(){
        Book book = new Book("nicolicas", "nianduro", "nianduro");
        library.addBook(book);
        Loan loan = library.loanABook("nicolicas", "nianduro");
        assertEquals(library.returnLoan(loan).getReturnDate(), LocalDateTime.now());
    }
}

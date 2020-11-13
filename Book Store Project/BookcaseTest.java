import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * The test class BookcaseTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BookcaseTest
{
    /**
     * Default constructor for test class BookcaseTest
     */
    public BookcaseTest () {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp () {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown () {
    }

    /**
     * Tests Constructor
     */
    @Test
    public void TestConstructor () throws FileNotFoundException {
        File bookInventory = new File("Test_Classics.txt");
        Bookcase classics = new Bookcase(bookInventory);

        assertEquals(3,         classics.bookCount());
        assertEquals(0,         classics.findBook("9780486284736"));
        assertEquals(1,         classics.findBook("9789176370698"));
        assertEquals(2,         classics.findBook("9780141441146")); 

        classics.sort();
        assertEquals(0,         classics.findBook("9780141441146"));
        assertEquals(1,         classics.findBook("9780486284736"));
        assertEquals(2,         classics.findBook("9789176370698"));
        System.out.println("Test one, Jane, P&P, Frank: \n" + classics);

        classics.remove("9780141441146");
        assertEquals(0,         classics.findBook("9780486284736"));
        assertEquals(1,         classics.findBook("9789176370698"));

        Book dracula = new Book ("9780486454016", "Bram Stoker", 
                "Dracula", "Dover Publications", 336, 04, 18, 2000);
        classics.addBook (dracula); 
        assertEquals(2,         classics.findBook("9780486454016"));
        classics.sort();
        System.out.println("Test two, P&P, Drac, Frank: \n" + classics);

        classics.clear();
        assertEquals(0,         classics.bookCount());

    }
}

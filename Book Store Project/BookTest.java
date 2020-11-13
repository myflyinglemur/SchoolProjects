import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BookTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BookTest
{
    /**
     * Default constructor for test class BookTest
     */
    public BookTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }

    /**
     * Test Constructor
     */
    @Test
    public void TestConstructor () {
        Book pandp = new Book ("9780486284736", "Jane Austen", "Pride and Prejudice", "Dover Publications", 
                272, 04, 12, 1995);

        assertEquals("9780486284736",      pandp.getISBN());
        assertEquals("Jane Austen",         pandp.getAuthor());
        assertEquals("Pride and Prejudice", pandp.getTitle());
        assertEquals("Dover Publications",  pandp.getPublisher());
        assertEquals(272,                   pandp.getPageCount());
        assertEquals(04,                    pandp.getPubMonth());
        assertEquals(12,                    pandp.getPubDay());
        assertEquals(1995,                  pandp.getPubYear());

        Book frankenstein = new Book("9789176370698", "Mary Shelley", "Frankenstein", "Wisehouse Classics",
                150, 11, 17, 2015);
        assertEquals("9789176370698",      frankenstein.getISBN());
        assertEquals("Mary Shelley",        frankenstein.getAuthor());
        assertEquals("Frankenstein",        frankenstein.getTitle());
        assertEquals("Wisehouse Classics",  frankenstein.getPublisher());
        assertEquals(150,                   frankenstein.getPageCount());
        assertEquals(11,                    frankenstein.getPubMonth());
        assertEquals(17,                    frankenstein.getPubDay());
        assertEquals(2015,                  frankenstein.getPubYear());
    }
}

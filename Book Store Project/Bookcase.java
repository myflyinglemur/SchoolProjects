import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/**
 * Creates an arraylist 'bookcase' that stores book information from a file and
 * allows user to manipulate list and file information
 * 
 * @author Rachel Lowy
 * @version 17 August 2016
 */
public class Bookcase {
    private ArrayList<Book> bookcase = new ArrayList<Book>();
    private File bookFile;

    //-----------------------------------
    //     CONSTRUCTOR
    //-----------------------------------
    /**
     * Constructs a bookcase with books described in a file in it
     * 
     * @param   file    a file containing book information
     * 
     * @throws FileNotFoundException
     */
    public Bookcase (File bookFile) throws FileNotFoundException {
        this.bookFile = bookFile;
        
        //Read files; fills bookcase arrayList with books from file
        readFileFillCase(); 
    }

    //-----------------------------------
    //     ACCESSORS
    //-----------------------------------
    public int bookCount () {
        return bookcase.size();
    }

    /**
     * Reads book information from a file
     * 
     * @throws FileNotFoundException
     */
    public void readFileFillCase () throws FileNotFoundException {
        Scanner input = new Scanner(bookFile);

        while (input.hasNext()) {
            //read file info
            String isbn = input.nextLine();
            String author = input.nextLine();
            String title = input.nextLine();
            String publisher = input.nextLine();
            int pageCount = input.nextInt();
            int month = input.nextInt();
            int day = input.nextInt();
            int year = input.nextInt();

            Book book = new Book (isbn, author, title, publisher, pageCount, month, day, year);

            //Skips blank line in file if there is more input
            if (input.hasNext()) {
                input.nextLine();
                input.nextLine();
            }
            
            addBook(book);
        }
    }

    /**
     * Finds index location of desired book on shelf
     * 
     * @param   isbn    book's ISBN numberf
     */
    public int findBook (String isbn) {
        for (int index = 0; index < bookcase.size(); index ++) {
            Book book = bookcase.get(index);
            if (book.getISBN().equals(isbn)) {
                return bookcase.indexOf(book);
            }
        }
        return -1;
    }

    //-----------------------------------
    //     MUTATORS
    //-----------------------------------
    /**
     * Adds a book to the bookcase array
     * 
     * @param   book  Book object
     */
    public void addBook (Book book) {

        bookcase.add(book);
    }

    /**
     * Removes book of requested ISBN from bookcase
     * 
     * @param   isbn    book's ISBN number
     */
    public void remove (String isbn) {
        bookcase.remove(findBook(isbn));
    }

    /**
     * Sort books by ISBN number
     */
    public void sort () {
        Collections.sort(bookcase); 
    }

    /**
     * Removes all books from bookcase
     */
    public void clear () {
        bookcase.clear();
    }

    //-----------------------------------
    //     OTHER METHODS
    //-----------------------------------
    /**
     * Writes book information to the inventory file and adds it to bookcase array
     * 
     * @param   book    Book object
     * 
     * @throws FileNotFoundException
     */
    public void addToFile (Book book) throws FileNotFoundException {

        PrintStream output = new PrintStream (bookFile);
        output.println(book.getISBN());
        output.println(book.getAuthor());
        output.println(book.getTitle());
        output.println(book.getPublisher());
        output.println(book.getPageCount());
        output.println(book.getPubMonth() + " " + book.getPubDay() + " " + book.getPubYear() + "\n");	

    }

    /**
     * Creates a string output of items in bookcase
     */
    public String toString () {
        String descrip = "";
        for (Book book: bookcase) {
            descrip += book;
        }
        return descrip;
    }
}

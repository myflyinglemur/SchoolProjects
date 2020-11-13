import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * A program to allow the user to examine the contents of a bookshelf array and
 * the book inventory file.
 * 
 * @author Rachel Lowy
 * @version 17 August 2016
 */
public class BookcaseUI {
    public static final int MENU_START = 1;
    public static final int MENU_END = 7;

    /**
     * Gets a file from the user and creates a bookcase from it. 
     * Offers the user a menu of bookcase interactions.
     * 
     * @throws FileNotFoundException
     */
    public static void main (String[] args) throws FileNotFoundException {
        //Welcomes user
        System.out.println("Welcome to the book inventory management system.");
        System.out.println("This program reads and writes from a book file");
        System.out.println("and can maintain and update a list of current bookcase inventory.");
        System.out.println("Please use ISBN-13 values. ISBN-10 is not supported and");
        System.out.println("may cause unexpected errors.\n");

        Scanner console = new Scanner(System.in);

        //Gets file with book information for shelf
        System.out.println("Please enter a file containing book inventory: ");
        File bookFile = new File(console.next());
        while (!bookFile.canRead()) {
            System.out.println("File not found. Please enter a valid file name: ");
            bookFile = new File(console.next());
        }

        //Bookcase holds current inventory
        Bookcase bookcase = new Bookcase(bookFile);

        //initialize control variable
        int menuChoice = 0;;
        while (menuChoice < MENU_END){
            if (menuChoice == 1) {
                bookcase.readFileFillCase();
                System.out.println("File has been read and book information added to bookcase");
            } else if (menuChoice == 2) {
                bookcase.addToFile(getBookInfo(console));
                System.out.println("Book information has been added to file");
            } else if (menuChoice == 3) {
                bookcase.sort();
                System.out.println("Bookcase has been sorted");
            } else if (menuChoice == 4) {
                System.out.println(bookcase);
            } else if (menuChoice == 5) {
                bookcase.addBook(getBookInfo(console)); 
                System.out.println("Book information has been added to bookcase");
            } else if (menuChoice == 6) {
                String isbn = getBookISBN(console);
                if (bookcase.findBook(isbn) == -1) {
                    System.out.println("Book not found. Examine bookcase contents and try again.");
                } else {
                    bookcase.remove(isbn);
                    System.out.println("Book information has been removed from bookcase");
                }
            }

            displayMenu();
            menuChoice = getValidInt(console, MENU_START, MENU_END);
        }
        System.out.println("Goodbye");
    }

    public static void displayMenu () {
        System.out.println ("\nPlease select the following options\n");
        System.out.println ("1. Read book information from file to bookcase");
        System.out.println ("2. Write book information to file");
        System.out.println ("3. Sort books by ISBN");
        System.out.println ("4. Display books on bookcase");
        System.out.println ("5. Add a book to bookcase");
        System.out.println ("6. Delete a book from current inventory by ISBN");
        System.out.println ("7. Exit program\n");

    }

    /**
     * Gets an integer inside of a user-selected range
     * 
     * @param   start   integer starting value of range, inclusive
     * @param   end     integer ending valude of range, inclusive
     *
     * @return  choice   integer value between start and end values
     */
    public static int getValidInt(Scanner s, int start, int end) {
        while (! s.hasNextInt()) {
            System.out.printf("\nSelection must be a whole number %d to %d", start, end);
            s.next();
        }

        int choice = s.nextInt();
        while (!inRange(choice, start, end)) {
            System.out.printf("\nSelection must be a whole number %d to %d \n", start, end);
            choice = s.nextInt();
        } 

        return choice;
    }

    /**
     * Reports whether a value is in a user-selected range
     * 
     * @param   number  double to check range of
     * @param   start   double starting value of range, inclusive
     * @param   end     double ending valude of range, inclusive
     *
     * @return  value   boolean reports true if 'number' is between start and end 
     */
    public static boolean inRange (double number, double start, double end){
        boolean value = false;
        if (number >= start && number <= end) {
            value = true;
        }
        return value; 
    }

    /**
     * Gets book ISBN from user
     */
    public static String getBookISBN (Scanner console) {
        String isbn;

        console.nextLine(); //consumes carriage stop from last user input

        System.out.println("Book ISBN 13, numbers only: ");
        isbn = console.nextLine();
        while (isbn.length() != 13){
            System.out.println("ISBN must be 13 characters long. Omit dashes in entry.");
            isbn = console.nextLine();
        }

        return isbn;
    }

    /**
     * Gets user input to create a book
     * 
     * @param   console     Scanner object to read user input
     */
    public static Book getBookInfo (Scanner console) {
        String isbn, author, title, publisher;
        int pageCount, pubMonth, pubDay, pubYear;

        isbn = getBookISBN(console);

        System.out.println("Author: ");
        author = console.nextLine();

        System.out.println("Title: ");
        title = console.nextLine();

        System.out.println("Publisher: ");
        publisher = console.nextLine();

        System.out.println("Page Count: ");
        pageCount = console.nextInt();

        //gets publication month
        System.out.println("Month of publication - 2 digit number (e.g. 07): ");
        pubMonth = console.nextInt();
        while (!inRange(pubMonth, 1, 12)) {
            System.out.println("Month must be between 1 and 12. Please re-enter:");
            pubMonth = console.nextInt();
        }

        //gets publication day
        System.out.println("Day of publication - 2 digit number (e.g., 31): ");
        pubDay = console.nextInt();
        while (!inRange(pubDay, 1, 31)) {
            System.out.println("Day must be between 01 and 31. Please re-enter:");
            pubDay = console.nextInt();
        }

        //gets publication year
        System.out.println("Year of publication - 4 digit number (e.g., 1994): ");
        pubYear = console.nextInt();
        while (!inRange(pubYear, 1000, 2500)) {
            System.out.println("Year must be 4 digits from modern era. Please re-enter:");
            pubYear = console.nextInt();
        }

        Book book = new Book(isbn, author, title, publisher, pageCount, 
                pubMonth, pubDay, pubYear);

        return book;
    }

}

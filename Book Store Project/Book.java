import java.lang.String;

/**
 * Creates a book object with helfpul reference information
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Book implements Quotable, Comparable<Book> {
    //-----------------------------------
    //     PRIVATE VARIABLES
    //-----------------------------------
    private String isbn;
    private String author;
    private String title;
    private String publisher;
    private int pageCount; 
    private int pubMonth;
    private int pubDay;
    private int pubYear;

    //-----------------------------------
    //     CONSTRUCTOR
    //-----------------------------------

    /**
     * Constructs a book object
     * 
     * @param   isbn        book's ISBN number
     * @param   author      book's author
     * @param   title       book's title
     * @param   publisher   book's publisher
     * @param   pageCount   total pages in book
     * @param   pubMonth    book's publication month
     * @param   pubDay      book's publication day 
     * @param   pubYear     book's publication year
     * 
     */

    public Book (String isbn, String author, String title, String publisher,
    int pageCount, int pubMonth, int pubDay, int pubYear) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.pageCount = pageCount;
        this.pubMonth = pubMonth;
        this.pubDay = pubDay;
        this.pubYear = pubYear;
    }

    //-----------------------------------
    //     ACCESSORS
    //-----------------------------------

    /**
     * Gets a book's ISBN
     * 
     * @return  book ISBN
     */
    @Override
    public String getISBN(){
        return isbn;
    }

    /**
     * Gets a book's Author
     * 
     * @return  book's Author
     */
    @Override
    public String getAuthor(){
        return author;
    }

    /**
     * Gets a book's Title
     * 
     * @return  book's Title
     */
    @Override
    public String getTitle(){
        return title;
    }

    /**
     * Gets a book's Publisher
     * 
     * @return  book's Publisher
     */
    @Override
    public String getPublisher(){
        return publisher;
    }

    /**
     * Gets a book's publication year
     * 
     * @return  book's publication year
     */
    @Override
    public int getPubYear(){
        return pubYear;
    }

    /**
     * Gets a book's publication month
     * 
     * @return  book's publication month
     */
    @Override
    public int getPubMonth(){
        return pubMonth;
    }

    /**
     * Gets a book's publication day
     * 
     * @return  book's publication day
     */
    @Override
    public int getPubDay(){
        return pubDay;
    }

    /**
     * Gets a book's page count
     * 
     * @return  book's page count
     */
    @Override
    public int getPageCount(){
        return pageCount;
    }

    //-----------------------------------
    //     Other Methods
    //-----------------------------------
    /**
     * Returns book with larger ISBN number
     * 
     * @param   other       another book
     * @return  result      0 for equal ISBN
     *                      1 if this book is larger
     *                      -1 if other book is larger
     */
    @Override
    public int compareTo (Book other) {
        return this.getISBN().compareTo(other.getISBN());
    }

    /**
     * Creates a string output summarizing book information
     */
    public String toString () {
        String descrip = "";
        
        descrip += ("ISBN: " + this.getISBN()) + "\n";
        descrip += ("Author: " + this.getAuthor() + "\n");
        descrip += ("Title: " + this.getTitle() + "\n");
        descrip += ("Publisher: " + this.getPublisher() + "\n");
        descrip += ("Page Count: " + this.getPageCount() + "\n");
        descrip += ("Publication Date: " + this.getPubMonth() + " "
                    + this.getPubDay() + " " + this.getPubYear() + "\n\n");
        return descrip;
    }

}


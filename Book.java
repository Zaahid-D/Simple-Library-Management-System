// Defines a class named Book to represent a book in the library
public class Book {

    // Private fields for book attributes
    private String title;           				// Stores the title of the book
    private String author;          				// Stores the author's name
    private String ISBN;            				// Stores the ISBN number of the book
    private boolean isAvailable;    				// Indicates whether the book is available for borrowing

    // Constructor to initialize the Book object with its attributes
    public Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;               			// Assigns the provided title to the book
        this.author = author;             			// Assigns the provided author name to the book
        this.ISBN = isbn;                 			// Assigns the provided ISBN to the book
        this.isAvailable = isAvailable;   			// Assigns the availability status of the book
    }

    // Getter method to retrieve the book title
    public String getTitle() {
        return this.title;  
    }

    // Setter method to modify the book title
    public void setTitle(String title) {
        this.title = title; 
    }

    // Getter method to retrieve the book author
    public String getAuthor() {
        return this.author; 
    }

    // Setter method to modify the book author
    public void setAuthor(String author) {
        this.author = author;  
    }

    // Getter method to retrieve the book ISBN
    public String getIsbn() {
        return this.ISBN;  
    }

    // Setter method to modify the book ISBN
    public void setIsbn(String Isbn) {
        this.ISBN = Isbn;  
    }

    // Getter method to check if the book is available
    public boolean isAvailable() {
        return this.isAvailable; 
    }

    // Setter method to modify the availability status of the book
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;  
    }

    // toString method to provide a string representation of the Book object
    @Override
    public String toString() {
        // Returns a formatted string displaying the book's attributes
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
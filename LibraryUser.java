// LibraryUser class to represent users of the library
import java.util.ArrayList;

public class LibraryUser {
    private String name;                      		// Stores the name of the user
    private String userID;                    		// Stores the unique ID of the user
    private ArrayList<Book> borrowedBooks;   		// Stores the list of books borrowed by the user

    // Constructor to initialize LibraryUser with name and userID
    public LibraryUser(String name, String userID) {
        this.name = name;                     		// Assigns the user's name
        this.userID = userID;                 		// Assigns the user's ID
        this.borrowedBooks = new ArrayList<>(); 	// Initializes the list of borrowed books
    }

    // Getter method to retrieve the user's name
    public String getName() { 
        return this.name; 
    }
    
    // Setter method to modify the user's name
    public void setName(String name) { 
        this.name = name; 
    }
    
    // Getter method to retrieve the user's ID
    public String getUserID() { 
        return this.userID; 
    }
    
    // Setter method to modify the user's ID
    public void setUserID(String userID) { 
        this.userID = userID; 
    }
    
    // Getter method to retrieve the list of borrowed books
    public ArrayList<Book> getBorrowedBooks() { 
        return this.borrowedBooks; 
    }

    // Method for the user to borrow a book
    public void borrowBook(Book book) {
        if (book.isAvailable()) {   														// Check if the book is available
            this.borrowedBooks.add(book);   												// Add the book to the user's borrowed books
            book.setAvailable(false);   													// Update the book's availability status to false
            System.out.println(this.name + " successfully borrowed: " + book.getTitle()); 	// Confirmation message
        } else {
            System.out.println(book.getTitle() + " is currently unavailable."); 			// Message if the book is unavailable
        }
    }

    // Method for the user to return a borrowed book
    public void returnBook(Book book) {
        if (this.borrowedBooks.contains(book)) {   											// Check if the user has borrowed this book
            this.borrowedBooks.remove(book);   												// Remove the book from the borrowed list
            book.setAvailable(true);   														// Update the book's availability status to true
            System.out.println(this.name + " successfully returned: " + book.getTitle()); 	// Confirmation message
        } else {
            System.out.println(this.name + " has not borrowed: " + book.getTitle()); 		// Message if the user hasn't borrowed the book
        }
    }

    // toString method for LibraryUser to provide a string representation of the user's attributes
    @Override
    public String toString() {
        return "LibraryUser{" +
                "name='" + name + '\'' +              										// Shows the user's name
                ", userID='" + userID + '\'' +        										// Shows the user's ID
                ", borrowedBooks=" + borrowedBooks +   										// Shows the list of borrowed books
                '}';
    }
}
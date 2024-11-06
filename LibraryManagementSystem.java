import java.util.ArrayList; 

public class LibraryManagementSystem {
    private ArrayList<LibraryUser> users; 									// List to hold library users
    private ArrayList<Book> books; 											// List to hold books in the library

    // Constructor to initialize the library system
    public LibraryManagementSystem() {
        this.users = new ArrayList<>(); 									// Initialize the users list
        this.books = new ArrayList<>(); 									// Initialize the books list
    }

    // Method to add a new user to the library
    public void addUser(LibraryUser user) {
        this.users.add(user); 												// Add the user to the list
        System.out.println("User added: " + user.getName()); 				// Confirm user addition
    }

    // Method to remove a user from the library
    public void removeUser(LibraryUser user) {
        // Attempt to remove the user and print the result
        if (this.users.remove(user)) {
            System.out.println("User removed: " + user.getName());
        } else {
            System.out.println("User not found: " + user.getName());
        }
    }
        
    // Method to add a new book to the library
    public void addBook(Book book) {
        this.books.add(book); 												 // Add the book to the list
        System.out.println("Book added: " + book.getTitle()); 				 // Confirm book addition
    }

    // Method to display all users' names and IDs
    public void displayUserDetails() {
        // Check if there are no users
        if (this.users.isEmpty()) {
            System.out.println("No users in the library system.");
        } else {
            System.out.println("\n--- Library Users ---");
            // Loop through each user and display their ID and name
            for (LibraryUser user : this.users) {
                System.out.println("User ID: " + user.getUserID() + ", Name: " + user.getName());
            }
        }
    }
    
    // Method to display user details along with borrowed books
    public void displayUserDetailsandBorrowedBooks() {
        if (this.users.isEmpty()) {
            System.out.println("No users in the library system.");
        } else {
            System.out.println("\n--- Library Users and Borrowed Books ---");
            for (LibraryUser user : this.users) {
                System.out.println(user.toString());  							// Print full details using LibraryUser's toString
            }
        }
    }

    // Method to display details of all books in the library
    public void displayBookDetails() {
        if (this.books.isEmpty()) {
            System.out.println("No books in the library system.");
        } else {
            System.out.println("\n--- Library Books ---");
            for (Book book : this.books) {
                System.out.println(book.toString());  							// Print full details using Book's toString
            }
        }
    }

    // Custom exception for user not found
    class UserNotFoundException extends Exception {
        public UserNotFoundException(String message) {
            super(message); 													// Pass the message to the Exception class
        }
    }

    // Custom exception for book not found
    class BookNotFoundException extends Exception {
        public BookNotFoundException(String message) {
            super(message); 													// Pass the message to the Exception class
        }
    }
    
    // Method to search for a user by their ID
    public LibraryUser searchUserByID(String userID) throws UserNotFoundException {
        // Loop through users to find a match by ID
        for (LibraryUser user : users) {
            if (user.getUserID().equals(userID)) { 								// Use .equals() to compare strings
                return user; // Return the found user
            }
        }
        // Throw exception if user not found
        throw new UserNotFoundException("User with ID " + userID + " not found.");
    }

    // Method to search for a user by their name
    public LibraryUser searchUserByName(String name) throws UserNotFoundException {
        // Loop through users to find a match by name
        for (LibraryUser user : users) {
            if (user.getName().equalsIgnoreCase(name)) { 						// Use equalsIgnoreCase for case-insensitive comparison
                return user; 													// Return the found user
            }
        }
        // Throw exception if user not found
        throw new UserNotFoundException("User with name " + name + " not found.");
    }

    // Method to search for a book by its ISBN
    public Book searchBookByISBN(String isbn) throws BookNotFoundException {
        // Loop through books to find a match by ISBN
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) { 						// Use equalsIgnoreCase for case-insensitive comparison
                return book; 													// Return the found book
            }
        }
        // Throw exception if book not found
        throw new BookNotFoundException("Book with ISBN " + isbn + " not found.");
    }

    // Method to search for a book by its title
    public Book searchBookByTitle(String title) throws BookNotFoundException {
        // Loop through books to find a match by title
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) { 						// Use equalsIgnoreCase for case-insensitive comparison
                return book; 													// Return the found book
            }
        }
        // Throw exception if book not found
        throw new BookNotFoundException("Book with title \"" + title + "\" not found.");
    }
}

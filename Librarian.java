// Librarian class that extends LibraryUser to represent librarians
public class Librarian extends LibraryUser {
    private LibraryManagementSystem librarySystem; 								// Reference to the library management system

    // Constructor to initialize the Librarian with name, userID, and library system reference
    public Librarian(String name, String userID, LibraryManagementSystem librarySystem) {
        super(name, userID);               										// Call the parent constructor to set name and userID
        this.librarySystem = librarySystem; 									// Assigns the library system reference
    }

    // Method to manage book details, such as updating book information
    public void manageBooks(String action, Book book, String newTitle, String newAuthor, String newISBN) {
        if (action.equalsIgnoreCase("update")) {								// Check if the action is to update
            book.setTitle(newTitle);											// Update the book's title
            book.setAuthor(newAuthor);											// Update the book's author
            book.setIsbn(newISBN);												// Update the book's ISBN
            System.out.println("Updated book details: " + book.toString());  	// Use Book's toString for updated details
        } else {
            System.out.println("Invalid action for managing books.");
        }
    }


    // Method to manage library users, such as registering or deregistering 
    public void manageUsers(String action, LibraryUser user) {
        if (action.equalsIgnoreCase("register")) {
            librarySystem.addUser(user);										// Add user to the library system
            System.out.println("User registered: " + user.toString());  		// Use LibraryUser's toString
        } else if (action.equalsIgnoreCase("deregister")) {
            librarySystem.removeUser(user);										// Remove user from the library system
            System.out.println("User deregistered: " + user.toString());  		// Use LibraryUser's toString
        } else {
            System.out.println("Invalid action for managing users.");			// Message for invalid action
        }
    }


    // toString method for Librarian to provide a string representation of the librarian's attributes
    @Override
    public String toString() {
        return "Librarian{" +
                "name='" + getName() + '\'' +             						// Shows the librarian's name
                ", userID='" + getUserID() + '\'' +       						// Shows the librarian's ID
                ", librarySystem=" + librarySystem +       						// Shows the reference to the library system
                '}';
    }
}
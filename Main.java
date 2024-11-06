public class Main {
    public static void main(String[] args) {
        LibraryManagementSystem librarySystem = new LibraryManagementSystem();
        System.out.println("📚✨ Welcome to the Ubunifu Library Management System ✨📚");
        System.out.println("🔹 Where Knowledge and Inspiration Meet the Boundless World of Books 🔹\n");
        
        // 📚 Adding books to the system
        System.out.println("\n--- 📘 Adding Books ---");
        Book book1 = new Book("The Joys of Womanhood", "Buchi Emecheta", "9780143038960", true);
        Book book2 = new Book("Disgrace", "J. M. Coetzee", "9780142001695", true);
        Book book3 = new Book("A Grain of Wheat", "Ngugi wa Thiong'o", "9780435901584", true);
        Book book4 = new Book("Harvest of Skulls", "Abdourahman A. Waberi", "9781846590458", true);
        librarySystem.addBook(book1);
        librarySystem.addBook(book2);
        librarySystem.addBook(book3);
        librarySystem.addBook(book4);

        // 👤 Adding users to the system
        System.out.println("\n--- 👥 Adding Users ---");
        LibraryUser user1 = new LibraryUser("Zaahid", "LIB001");
        LibraryUser user2 = new LibraryUser("Lily", "LIB002");
        LibraryUser user3 = new LibraryUser("Zainab", "LIB003");
        LibraryUser user4 = new LibraryUser("Daniel", "LIB015");
        librarySystem.addUser(user1);
        librarySystem.addUser(user2);
        librarySystem.addUser(user3);
        librarySystem.addUser(user4);

        // 👩‍🏫 Librarian managing books and users
        Librarian librarian = new Librarian("Rose", "3", librarySystem);
        System.out.println("\n--- 👩‍🏫 Librarian Managing Books and Users ---");
        System.out.println("Librarian Name: " + librarian.getName());

        // ✍️ Testing book updates
        System.out.println("\n--- ✍️ Librarian Managing Books ---");
        librarian.manageBooks("update", book1, "The Joys of Womanhood - Part 1", "Buchi Emecheta", "9780143038960");
        librarian.manageBooks("update", book2, "Disgrace ", "Z. M. Coetzee", "9780142055555");

        // 📝 Testing user registration and deregistration
        System.out.println("\n--- 📝 Librarian Managing Users ---");
        LibraryUser newUser = new LibraryUser("Zack", "LIB004");
        librarian.manageUsers("register", newUser);
        librarian.manageUsers("deregister", user3);

        // 👥 Display users
        System.out.println("\n👥 Updated Library User List After Changes Made by Librarian:");
        librarySystem.displayUserDetails();
        
        // 📚 Display all books
        System.out.println("\n📚 Updated Library Books List After Changes Made by Librarian:");
        librarySystem.displayBookDetails();

        // 📖 Borrowing books
        System.out.println("\n--- 📖 Borrowing Books ---");
        user1.borrowBook(book1);  
        user2.borrowBook(book3); 
        user4.borrowBook(book3);

        // 👤 Display users and books after borrowing
        librarySystem.displayUserDetailsandBorrowedBooks();
        librarySystem.displayBookDetails();

        // 📕 Returning books
        System.out.println("\n--- 📕 Returning Books ---");
        user1.returnBook(book1);  
        user2.returnBook(book3);  

        // 👤 Display users and books after returning
        librarySystem.displayUserDetailsandBorrowedBooks();
        librarySystem.displayBookDetails();

        // 🔍 Test searching for a user by ID
        System.out.println("\n--- 🔍 Search Functionality ---");

        // 🔎 Searching for a user by userID
        System.out.println("\n--- 🔎 Search for a User by ID ---");
        try {
            LibraryUser searchedUser = librarySystem.searchUserByID("LIB001");
            System.out.println("Found User by ID: " + searchedUser.getName());
        } catch (LibraryManagementSystem.UserNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // 🔎 Searching for a non-existent user by ID
        try {
            LibraryUser notFoundUser = librarySystem.searchUserByID("LIB007");
            System.out.println("Found User by ID: " + notFoundUser.getName());
        } catch (LibraryManagementSystem.UserNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // 🔎 Searching for a user by name
        System.out.println("\n--- 🔎 Search for a User by Name ---");
        try {
            LibraryUser foundUserByName = librarySystem.searchUserByName("Zaahid");
            System.out.println("Found User by Name: " + foundUserByName.getName());
        } catch (LibraryManagementSystem.UserNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // 🔎 Searching for a non-existent user by name
        try {
            LibraryUser notFoundUserByName = librarySystem.searchUserByName("John");
            System.out.println("Found User by Name: " + notFoundUserByName.getName());
        } catch (LibraryManagementSystem.UserNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // 📖 Searching for a book by ISBN
        System.out.println("\n--- 📖 Search for a Book by ISBN ---");
        try {
            Book searchedBook = librarySystem.searchBookByISBN("9781846590458");
            System.out.println("Found Book by ISBN: " + searchedBook.getTitle());
        } catch (LibraryManagementSystem.BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // 📖 Searching for a non-existent book by ISBN
        try {
            Book notFoundBook = librarySystem.searchBookByISBN("9780747532123");
            System.out.println("Found Book by ISBN: " + notFoundBook.getTitle());
        } catch (LibraryManagementSystem.BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // 📖 Searching for a book by title
        System.out.println("\n--- 📖 Search for a Book by Title ---");
        try {
            Book foundBookByTitle = librarySystem.searchBookByTitle("Harvest of Skulls");
            System.out.println("Found Book by Title: " + foundBookByTitle.getTitle());
        } catch (LibraryManagementSystem.BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // 📖 Searching for a non-existent book by title
        try {
            Book notFoundBookByTitle = librarySystem.searchBookByTitle("Bodyguard");
            System.out.println("Found Book by Title: " + notFoundBookByTitle.getTitle());
        } catch (LibraryManagementSystem.BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        
        // ❌ Testing exception handling 
        System.out.println("\n--- ❌ Testing exception handling  ---");
        
        // 🔍 Testing exception handling for user not found
        System.out.println("\n--- Testing UserNotFoundException ---");
        try {
            librarySystem.searchUserByID("LIB010");  // This ID does not exist
        } catch (LibraryManagementSystem.UserNotFoundException e) {
            System.out.println("❌ Caught UserNotFoundException: " + e.getMessage());
        }

        try {
            librarySystem.searchUserByName("Bob");  // This name does not exist
        } catch (LibraryManagementSystem.UserNotFoundException e) {
            System.out.println("❌ Caught UserNotFoundException: " + e.getMessage());
        }

        // 📚 Testing exception handling for book not found
        System.out.println("\n--- Testing BookNotFoundException ---");
        try {
            librarySystem.searchBookByISBN("111111111524547");  // This ISBN does not exist
        } catch (LibraryManagementSystem.BookNotFoundException e) {
            System.out.println("❌ Caught BookNotFoundException: " + e.getMessage());
        }

        try {
            librarySystem.searchBookByTitle("The Old Man and the Medal");  // This title does not exist
        } catch (LibraryManagementSystem.BookNotFoundException e) {
            System.out.println("❌ Caught BookNotFoundException: " + e.getMessage());
        }
    }
}
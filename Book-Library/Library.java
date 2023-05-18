public class Library {
    private Book[] books;

    public Library(String libraryAddress) {
        books = new Book[50];
    }

    public void addBook(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                return;
            }
        }
        System.out.println("This library already has 50 books, it is full.");
    }

    public void borrowBook(String bookTitle) {
        try {
            for (int i = 0; i < books.length; i++) {
                Book currentBook = books[i];
                if (currentBook.getTitle().equals(bookTitle)){
                    if (currentBook.isBorrowed()) {
                        System.out.println("Sorry, this book is already borrowed.");
                        return;
                    } else {
                        currentBook.borrowed();
                        System.out.println("You successfully borrowed " + currentBook.getTitle());
                        return;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Sorry, this book is not in our catalog.");
        }
    }
    
    public void printAvailableBooks() {
        boolean noBooksAvailable = true;
        for (int i = 0; i < books.length; i++) {
            Book currentBook = books[i];
            if (currentBook != null && !currentBook.isBorrowed()) {
                System.out.println(currentBook.getTitle());
                noBooksAvailable = false;
            }
        }
        if (noBooksAvailable) {
            System.out.println("No book in catalog");
        }
    }

    public void returnBook(String bookTitle) {
            for (int i = 0; i < books.length; i++) {
                if (books[i] != null && books[i].getTitle().equals(bookTitle)) {
                    books[i].returned();
                    System.out.println("You successfully returned " + books[i].getTitle());
                    return;
                }
            }
            System.out.println("This book does not belong to this library.");
    }

    public static void main(String[] args) {
        Library firstLibrary = new Library("First Library");
        Library secondLibrary = new Library("Second Library");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Pragmatic Programmer"));
        firstLibrary.addBook(new Book("Code - The Hidden Language"));
        firstLibrary.addBook(new Book("Programming Pearls"));
        firstLibrary.addBook(new Book("Domain Driven Design in Life"));

        // Try to borrow The Pragmatic Programmer from both libraries
        System.out.println("Borrowing The Pragmatic Programmer:");
        firstLibrary.borrowBook("The Pragmatic Programmer");
        firstLibrary.borrowBook("The Pragmatic Programmer");
        secondLibrary.borrowBook("The Pragmatic Programmer");
        System.out.println();
        
        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return TThe Pragmatic Programmer to the first library
        System.out.println("Returning The Pragmatic Programmer:");
        firstLibrary.returnBook("The Pragmatic Programmer");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        
    }
}

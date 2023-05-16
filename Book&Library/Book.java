public class Book {
    public String title;
    public boolean rented;

    public Book(String bookTitle) {
        title = bookTitle;
        rented = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isRented() {
        return rented;
    }

    public void borrowBook() {
        rented = true;
    }

    public void returnBook() {
        rented = false;
    }

    public static void main(String[] args) {
        Book testBook = new Book("The Pragmatic Programmer");
        System.out.println("Title : " + testBook.getTitle());
        System.out.println("Rented? : " + testBook.isRented());
        testBook.borrowBook();
        System.out.println("Rented? : " + testBook.isRented());
        testBook.returnBook();
        System.out.println("Rented? : " + testBook.isRented());
    }
}

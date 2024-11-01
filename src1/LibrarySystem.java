import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Book {
    String title;
    String author;
    int quantity;

    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public boolean borrowBooks(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
            return true;
        }
        return false;
    }

    public void returnBooks(int quantity) {
        this.quantity += quantity;
    }
}

public class LibrarySystem {
    private static final Map<String, Book> library = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nLibrary System:");
            System.out.println("1. Add Books");
            System.out.println("2. Borrow Books");
            System.out.println("3. Return Books");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addBooks();
                    break;
                case 2:
                    borrowBooks();
                    break;
                case 3:
                    returnBooks();
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addBooks() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Book book = library.get(title);
        if (book != null) {
            book.addQuantity(quantity);
            System.out.println("Updated the quantity of " + title + " by " + author + " to " + book.quantity);
        } else {
            library.put(title, new Book(title, author, quantity));
            System.out.println("Added new book: " + title + " by " + author + " with quantity " + quantity);
        }
    }

    private static void borrowBooks() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter number of books to borrow: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Book book = library.get(title);
        if (book != null && book.borrowBooks(quantity)) {
            System.out.println("Successfully borrowed " + quantity + " copies of " + title);
        } else {
            System.out.println("Error: Not enough copies available or book not found.");
        }
    }

    private static void returnBooks() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter number of books to return: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Book book = library.get(title);
        if (book != null) {
            book.returnBooks(quantity);
            System.out.println("Successfully returned " + quantity + " copies of " + title);
        } else {
            System.out.println("Error: Book not found in the library system.");
        }
    }
}

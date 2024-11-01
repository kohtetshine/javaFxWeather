
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GenericCatalog<LibraryItem<String>> catalog = new GenericCatalog<>();

        boolean running = true;
        while (running) {
            System.out.println("\nLibrary Catalog Menu:");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. View Catalog");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter item ID: ");
                    String itemID = scanner.nextLine();
                    catalog.addItem(new LibraryItem<>(title, author, itemID));
                    break;
                case 2:
                    System.out.print("Enter item ID to remove: ");
                    String idToRemove = scanner.nextLine();
                    catalog.removeItem(new LibraryItem<>(null, null, idToRemove));
                    break;
                case 3:
                    catalog.displayCatalog();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}

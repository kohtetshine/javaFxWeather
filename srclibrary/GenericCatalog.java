
import java.util.ArrayList;
import java.util.List;

public class GenericCatalog<T> {
    private List<T> catalog;

    public GenericCatalog() {
        catalog = new ArrayList<>();
    }

    public void addItem(T item) {
        catalog.add(item);
        System.out.println("Item added: " + item.toString());
    }

    public void removeItem(T item) {
        if (catalog.contains(item)) {
            catalog.remove(item);
            System.out.println("Item removed: " + item.toString());
        } else {
            System.out.println("Item not found in the catalog.");
        }
    }

    public void displayCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("The catalog is empty.");
        } else {
            for (T item : catalog) {
                System.out.println(item.toString());
            }
        }
    }
}

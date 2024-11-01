import com.ecommerce.Product;
import com.ecommerce.Customer;
import com.ecommerce.orders.Order;

public class Main {
    public static void main(String[] args) {
        // Create products
        Product product1 = new Product(1, "Laptop", 1200.99);
        Product product2 = new Product(2, "Headphones", 150.50);
        Product product3 = new Product(3, "Mouse", 25.75);

        // Create a customer
        Customer customer = new Customer(101, "Amna Ahmad");

        // Browse and add products to the shopping cart
        customer.addToCart(product1);
        customer.addToCart(product2);
        customer.addToCart(product3);

        // Display total cost
        System.out.println("Total Cart Cost: $" + customer.calculateTotalCost());

        // Place order
        Order order = new Order(1001, customer);
        order.displayOrderSummary();
    }
}

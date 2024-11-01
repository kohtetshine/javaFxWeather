package com.ecommerce.orders;

import com.ecommerce.Customer;
import com.ecommerce.Product;
import java.util.ArrayList;

public class Order {
    private int orderID;
    private Customer customer;
    private ArrayList<Product> products;
    private double total;

    public Order(int orderID, Customer customer) {
        this.orderID = orderID;
        this.customer = customer;
        this.products = customer.getShoppingCart();
        this.total = customer.calculateTotalCost();
    }

    // Generate order summary
    public void displayOrderSummary() {
        System.out.println("Order ID: " + orderID);
        customer.displayCustomerInfo();
        System.out.println("Products Ordered:");
        for (Product product : products) {
            product.displayProductInfo();
        }
        System.out.println("Total: $" + total);
    }
}

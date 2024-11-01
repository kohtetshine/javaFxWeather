package com.ecommerce;

import java.util.ArrayList;

public class Customer {
    private int customerID;
    private String name;
    private ArrayList<Product> shoppingCart;

    public Customer(int customerID, String name) {
        this.customerID = customerID;
        this.name = name;
        this.shoppingCart = new ArrayList<>();
    }

    // Getters and Setters
    public int getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    // Add a product to the shopping cart
    public void addToCart(Product product) {
        shoppingCart.add(product);
        System.out.println(product.getName() + " added to the cart.");
    }

    // Remove a product from the shopping cart
    public void removeFromCart(Product product) {
        shoppingCart.remove(product);
        System.out.println(product.getName() + " removed from the cart.");
    }

    // Calculate the total cost of the shopping cart
    public double calculateTotalCost() {
        double total = 0;
        for (Product product : shoppingCart) {
            total += product.getPrice();
        }
        return total;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    // Display customer info
    public void displayCustomerInfo() {
        System.out.println("Customer ID: " + customerID + ", Name: " + name);
    }
}

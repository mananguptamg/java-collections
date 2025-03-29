package com.bridgelabz.extraproblems;

import java.util.*;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int qty) {
        this.quantity += qty;
    }

    public void removeQuantity(int qty) {
        this.quantity = Math.max(0, this.quantity - qty);
    }

    @Override
    public String toString() {
        return String.format("%s -> %.2f x %d", name, price, quantity);
    }
}

class CartManager {

    private Map<String, Product> cart = new HashMap<>();                     // Product name -> Product
    private LinkedHashMap<String, Product> orderedCart = new LinkedHashMap<>();  // Insertion order
    private TreeMap<Double, List<Product>> priceSortedCart = new TreeMap<>();    // Sorted by price

    // Add product to the cart
    public void addProduct(String name, double price, int quantity) {
        if (cart.containsKey(name)) {
            Product existingProduct = cart.get(name);
            existingProduct.addQuantity(quantity);
        } else {
            Product product = new Product(name, price, quantity);
            cart.put(name, product);
            orderedCart.put(name, product);

            // Add to price-sorted map
            priceSortedCart
                    .computeIfAbsent(price, k -> new ArrayList<>())
                    .add(product);
        }
    }

    // Remove a product from the cart
    public void removeProduct(String name, int quantity) {
        if (!cart.containsKey(name)) {
            System.out.println("Product not found.");
            return;
        }

        Product product = cart.get(name);

        if (quantity >= product.getQuantity()) {
            cart.remove(name);
            orderedCart.remove(name);

            // Remove from TreeMap
            List<Product> products = priceSortedCart.get(product.getPrice());
            products.remove(product);
            if (products.isEmpty()) {
                priceSortedCart.remove(product.getPrice());
            }
        } else {
            product.removeQuantity(quantity);
        }
    }

    // Display cart in insertion order
    public void displayCartInOrder() {
        System.out.println("\n--- Cart in Insertion Order ---");
        for (Product product : orderedCart.values()) {
            System.out.println(product);
        }
    }

    // Display cart sorted by price
    public void displayCartByPrice() {
        System.out.println("\n--- Cart Sorted by Price ---");
        for (Map.Entry<Double, List<Product>> entry : priceSortedCart.entrySet()) {
            for (Product product : entry.getValue()) {
                System.out.println(product);
            }
        }
    }

    // Calculate the total price of items in the cart
    public double getTotalPrice() {
        double total = 0.0;
        for (Product product : cart.values()) {
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }
}

public class ShoppingCart {
    public static void main(String[] args) {

        CartManager cart = new CartManager();

        // Adding products
        cart.addProduct("Apple", 150, 4);
        cart.addProduct("Banana", 80, 10);
        cart.addProduct("Orange", 40, 3);
        cart.addProduct("Milk", 60, 1);
        cart.addProduct("Apple", 150, 2);    // Adding more apples

        // Display the cart
        cart.displayCartInOrder();
        cart.displayCartByPrice();

        // Removing items
        System.out.println("\n--- Removing 3 Bananas ---");
        cart.removeProduct("Banana", 3);
        cart.displayCartInOrder();

        System.out.println("\n--- Total Price: " + cart.getTotalPrice());
    }
}

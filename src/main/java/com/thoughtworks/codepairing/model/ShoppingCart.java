package com.thoughtworks.codepairing.model;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {
    private List<Product> products;
    private Customer customer;

    public ShoppingCart(Customer customer, List<Product> products) {
        this.customer = customer;
        this.products = products;
    }

    public Order checkout() {
        double totalPrice = 0;
        int loyaltyPointsEarned = 0;

        for (Product product : products) {
            loyaltyPointsEarned += product.getDiscount() == 0
                            ? (product.getPrice() / 5)
                            : (product.getPrice() / product.getDiscount());
            totalPrice += product.getPrice() - product.getDiscount();
        }

        return new Order(totalPrice, loyaltyPointsEarned);
    }

    @Override
    public String toString() {
        return "Customer: " + customer.getName() + "\n" + "Bought:  \n" + products.stream().map(p -> "- " + p.getName()+ ", "+p.getPrice()).collect(Collectors.joining("\n"));
    }
}

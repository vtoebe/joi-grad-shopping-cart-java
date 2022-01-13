package com.thoughtworks.codepairing;

import com.thoughtworks.codepairing.model.Customer;
import com.thoughtworks.codepairing.model.Product;
import com.thoughtworks.codepairing.model.ShoppingCart;
import com.thoughtworks.codepairing.model.Order;

import java.util.List;

import static java.util.Arrays.asList;

public class SampleApp {
    public static void main(String[] args) {

        List<Product> products = asList(
                new Product(10.0, "DIS_10_PRODUCT1", "product 1"),
                new Product(20.0, "DIS_10_PRODUCT2",  "product 2"),
                new Product(30.0, "DIS_10_PRODUCT3", "product 3")
        );

        Customer customer = new Customer("A Customer");

        ShoppingCart shoppingCart = new ShoppingCart(customer, products);
        System.out.println(shoppingCart);

        Order order = shoppingCart.checkout();
        System.out.println(order);
    }
}

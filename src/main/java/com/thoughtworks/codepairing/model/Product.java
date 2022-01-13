package com.thoughtworks.codepairing.model;

import java.util.*;

public class Product{
    private final double price;
    private final String productCode;
    private final String name;
    private final int discount;
    static final HashMap<String, Integer> discountPairs = new HashMap<>();


    public Product(double price, String productCode, String name) {
        setDiscountPairs();
        this.price = price;
        this.productCode = productCode;
        this.name = name;
        this.discount = setDiscount();
    }

    public double getPrice() { return price; }
    public String getName() { return name; }
    public int getDiscount() { return discount; }

    private void setDiscountPairs(){
        discountPairs.put("DIS_10", 10);
        discountPairs.put("DIS_15", 15);
        discountPairs.put("DIS_20", 20);
        discountPairs.put("DIS_30", 30);
    }

    public int setDiscount(){
        for (Map.Entry<String, Integer> pair : discountPairs.entrySet()){
            if (productCode.startsWith(pair.getKey())){
                return pair.getValue();
            }
        }
        return 0;
    }
}

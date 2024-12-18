package org.example;

import org.example.model.Product;
import org.example.model.Store;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        store.print();
        Product product = store.getProduct("Product-1");
        store.addProduct("Product-5000", 2500);
        System.out.println(product);
    }
}
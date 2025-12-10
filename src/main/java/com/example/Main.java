package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public void main(String[] args) {
        DataRetriever dr = new DataRetriever();

        System.out.println("Toutes les satégories");
        System.out.println(dr.getAllCategories());
        System.out.println("produit page 1");
        System.out.println(dr.getProductList(1,3));
        System.out.println(dr.getProductsByName("phone"));
    }
}
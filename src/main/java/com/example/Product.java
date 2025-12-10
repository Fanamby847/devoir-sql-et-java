package main.java.com.example;

import java.time.Instant;
public class Product {
    private int id;
    private String name;
    private double price ;
    private Instant CreationDatetime;

    public Product(int id, String name , double price , Instant CreationDatetime){
        this.id = id ;
        this.name = name;
        this.price = price ;
        this.CreationDatetime = CreationDatetime;
    }

    public String toString() {
        return "Product {id =" +id + ",name = '" + name 
        + "', price = "+ price + ", created = " + CreationDatetime + "}";
    }
}

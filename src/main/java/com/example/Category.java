package main.java.com.example;

public class Category {
    private int id;
    private String name;

    public Category(int id , String name) {
        this.id = id;
        this.name = name;
    }

    public String toString(){
        return "Category {id = " + id + ", name = '" + name +"'}";
    }
}

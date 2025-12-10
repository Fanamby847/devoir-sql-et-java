package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private String url= "jdbc:postgresql://localhost:5432/product_management_db";
    private String user= "product_management_user";
    private String passWord = "123456";

    public Connection getDBConnection(){
        try{
            return DriverManager.getConnection(url, user, passWord);
        } catch (Exception e) {
            throw new RuntimeException("Erreur de connexion à la base", e);
        }
    }
}

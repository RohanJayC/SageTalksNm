package com.example.blog.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseConnection {
    public static void main(String[] args){
       String url= System.getenv("DB_URL");
       String user= System.getenv("DB_USER");
       String password= System.getenv("DB_PASSWORD");
        try(Scanner scanner=new Scanner(System.in)){
            DriverManager.getConnection(url,user,password);
            System.out.println("Connected");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}


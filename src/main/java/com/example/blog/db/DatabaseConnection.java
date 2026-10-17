package com.example.blog.db;
import java.sql.*;

public class DatabaseConnection {
    public static void main(String[] args){
       String url= System.getenv("DB_URL");
       String user= System.getenv("DB_USER");
       String password= System.getenv("DB_PASSWORD");
        try(Connection conn= DriverManager.getConnection(url,user,password);//Opens live connection to db and hands back as Connection object
            Statement statement= conn.createStatement();//Sends SQL commands from java to the db and processes the result
            ResultSet resultSet= statement.executeQuery("SELECT id,created_date,category,title,content FROM blog ORDER BY id")){
            System.out.println("Connected");
            while(resultSet.next()) {
                System.out.printf("%-5d",resultSet.getInt(1));
                System.out.printf("%-12s",resultSet.getString(2));
                System.out.printf("%-20s",resultSet.getString(3));
                System.out.printf("%-50s",resultSet.getString(4));
                System.out.printf("%-50s",resultSet.getString(5));
                System.out.println();
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}


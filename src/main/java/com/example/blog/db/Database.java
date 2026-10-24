package com.example.blog.db;
import java.sql.*;
import java.sql.Connection;
public class Database {
    public static Connection getConnection() throws SQLException {
        String url = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        return DriverManager.getConnection(url, user, password);
    }
}
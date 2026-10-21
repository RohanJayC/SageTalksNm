package com.example.blog.db;
import com.example.blog.model.Post;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    public static void main(String[] args){
       String url= System.getenv("DB_URL");
       String user= System.getenv("DB_USER");
       String password= System.getenv("DB_PASSWORD");
        try(Connection conn= DriverManager.getConnection(url,user,password);//Opens live connection to db and hands back as Connection object
            Statement statement= conn.createStatement();//Sends SQL commands from java to the db and processes the result
            ResultSet resultSet= statement.executeQuery("SELECT id,created_date,category,title,content FROM blog ORDER BY id")){
            System.out.println("Connected");
            List<Post> posts =new ArrayList<>();
            while(resultSet.next()) {
                Long id=resultSet.getLong("id");
                LocalDate createdDate=resultSet.getDate("created_Date").toLocalDate();
                String category=resultSet.getString("category");
                String title=resultSet.getString("title");
                String content=resultSet.getString("content");

                Post post=new Post(id,createdDate,category,title,content);
                posts.add(post);
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}


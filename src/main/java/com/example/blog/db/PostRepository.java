package com.example.blog.db;
import com.example.blog.model.Post;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    public List<Post> displayAll() throws SQLException {
        List<Post> posts = new ArrayList<>();
        try (Connection conn = Database.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id,created_date,category,title,content FROM blog ORDER BY id")) {
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                LocalDate createdDate = resultSet.getDate("created_date").toLocalDate();
                String category = resultSet.getString("category");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");

                posts.add(new Post(id, createdDate, category, title, content));
            }
        }
        return posts;
    }
}




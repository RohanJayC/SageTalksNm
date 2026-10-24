package com.example.blog.db;
import com.example.blog.model.Post;
import java.sql.SQLException;
import java.util.List;
public class DisplayAllDemo {
    public static void main(String[] args) {
        PostRepository repository = new PostRepository();
        try {
            List<Post> posts = repository.displayAll();
            System.out.println("Loaded " + posts.size() + " posts");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
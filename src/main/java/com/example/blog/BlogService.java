package com.example.blog;
import com.example.blog.model.Post;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

class BlogService {
    ArrayList<Post> posts = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int nextId = 1; // Counter for post IDs, prevents duplicates

    void createPost() {
        Long id = (long) nextId++;
        System.out.println("Enter your title:");
        String title = sc.nextLine();
        System.out.println("Enter the category of your post:");
        String category = sc.nextLine();
        System.out.println("Enter the contents of your post here:");
        String content = sc.nextLine();
        Post p = new Post(id, LocalDate.now(), category, title, content);
        posts.add(p);
        System.out.println("Your post has been created successfully!");
    }

    void editPost() {
        System.out.println("Enter the post ID of the post you wish to edit:");
        int editID = sc.nextInt();
        sc.nextLine();
        for (Post p : posts) {
            if (p.getId() == editID) {
                System.out.println("------------------------------");
                System.out.println("Edited Content:");
                p.setContent(sc.nextLine());
                return;
            }
        }
        System.out.println("Please re-check the post ID, a post with the entered ID does not exist");
    }

    void deletePost() {
        System.out.println("Enter the post ID of the post you wish to delete:");
        int delID = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getId() == delID) {
                posts.remove(i);
                System.out.println("Post deleted successfully");
                return;
            }
        }
        System.out.println("Please re-check the post ID, a post with the entered ID does not exist");
    }

    void viewPost() {
        System.out.println("Enter the post ID of the post you wish to view:");
        int viewID = sc.nextInt();
        sc.nextLine();
        for (Post p : posts) {
            if (p.getId() == viewID) {
                printPost(p);
                return;
            }
        }
        System.out.println("Please re-check the post ID, a post with the entered ID does not exist");
    }

    void viewAllPosts() {
        for (Post p : posts) {
            printPost(p);
        }
    }

    private void printPost(Post p) {
        System.out.println("------------------------------");
        System.out.println("ID: " + p.getId());
        System.out.println("Date: " + p.getCreatedDate());
        System.out.println("Category: " + p.getCategory());
        System.out.println("Title: " + p.getTitle());
        System.out.println("Content: " + p.getContent());
    }
}
package com.example.blog.model;
import java.time.LocalDate;

public class Post {
        private Long id;
        private LocalDate createdDate;
        private String category;
        private String title;
        private String content;
        public Post(String category, String title, String content){// id and creation date assigned only upon posting so a constructor for unsaved post
            this.category=category;
            this.title=title;
            this.content=content;
        }
        public Post(Long id, LocalDate createdDate, String category, String title, String content){//constructor for uploaded post
            this.id=id;
            this.createdDate=createdDate;
            this.category=category;
            this.title=title;
            this.content=content;
        }

    public Long getId() {
        return id;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
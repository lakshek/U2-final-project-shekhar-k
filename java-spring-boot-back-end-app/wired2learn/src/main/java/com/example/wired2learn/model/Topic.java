package com.example.wired2learn.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many topics are in one category
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false, foreignKey = @ForeignKey(name = "fk_topic_category_id"))
    private Category category;

    @Column(name = "topic_title", nullable = false)
    private String title;

    @Column(name = "topic_content", columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "topic_image_url", length = 500)
    private String imageUrl;

    @Column(name = "topic_locked", nullable = false)
    private boolean locked;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    // Constructors
    public Topic() {
    }

    public Topic(Category category, String title, String content, String imageUrl, boolean locked) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.locked = locked;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean getLocked() {
        return locked;
    }
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }
}

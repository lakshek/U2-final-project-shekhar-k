package com.example.wired2learn.dto;

import java.time.LocalDateTime;

public class TopicResponseDTO {

    private Long id;
    private Long categoryId;
    private String title;
    private String content;
    private String imageUrl;
    private boolean locked;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    // Constructors
    public TopicResponseDTO() {
    }

    public TopicResponseDTO(Long id, Long categoryId, String title, String content, String imageUrl, boolean locked, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.categoryId = categoryId;
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.locked = locked;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public Long getCategoryId() {
        return categoryId;
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

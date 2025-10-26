package com.example.wired2learn.dto;

import com.example.wired2learn.model.Category;

public class TopicRequestDTO {

    private Long categoryId;
    private String title;
    private String content;
    private String imageUrl;
    private boolean locked;

    // Constructors
    public TopicRequestDTO() {
    }

    public TopicRequestDTO(Long categoryId, String title, String content, String imageUrl, boolean locked) {
        this.categoryId = categoryId;
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.locked = locked;
    }

    // Getters and Setters

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
}

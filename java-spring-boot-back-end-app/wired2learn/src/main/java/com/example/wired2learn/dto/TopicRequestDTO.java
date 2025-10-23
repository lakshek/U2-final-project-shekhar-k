package com.example.wired2learn.dto;

public class TopicRequestDTO {

    private Long categoryId;
    private String title;
    private String content;
    private String imageUrl;
    private boolean isProtected;

    // Constructors
    public TopicRequestDTO() {
    }

    public TopicRequestDTO(Long categoryId, String title, String content, String imageUrl, boolean isProtected) {
        this. categoryId = categoryId;
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.isProtected = isProtected;
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

    public boolean isProtected() {
        return isProtected;
    }
    public void setProtected(boolean aProtected) {
        isProtected = aProtected;
    }
}

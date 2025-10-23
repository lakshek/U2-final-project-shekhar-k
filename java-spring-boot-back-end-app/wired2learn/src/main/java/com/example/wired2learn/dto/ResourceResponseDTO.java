package com.example.wired2learn.dto;

import java.time.LocalDateTime;

public class ResourceResponseDTO {

    private Long id;
    private String title;
    private String url;
    private String description;
    private boolean isProtected;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    // Constructors
    public ResourceResponseDTO() {
    }

    public ResourceResponseDTO(Long id, String title, String url, String description, boolean isProtected, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.description = description;
        this.isProtected = isProtected;
        this. createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    // Getter and Setters

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isProtected() {
        return isProtected;
    }
    public void setProtected(boolean aProtected) {
        isProtected = aProtected;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }
}

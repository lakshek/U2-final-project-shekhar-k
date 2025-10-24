package com.example.wired2learn.dto;

import java.time.LocalDateTime;

public class FavoriteResponseDTO {

    private Long id;
    private Long userId;
    private Long resourceId;
    private LocalDateTime createdAt;

    // Constructors
    public FavoriteResponseDTO() {
    }

    public FavoriteResponseDTO(Long id, Long userId, Long resourceId, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.resourceId = resourceId;
        this.createdAt = createdAt;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

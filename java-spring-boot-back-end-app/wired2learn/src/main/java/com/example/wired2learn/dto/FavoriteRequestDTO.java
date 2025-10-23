package com.example.wired2learn.dto;

public class FavoriteRequestDTO {

    private Long userId;
    private Long resourceId;

    // Constructors
    public FavoriteRequestDTO() {
    }

    public FavoriteRequestDTO(Long userId, Long resourceId) {
        this.userId = userId;
        this.resourceId = resourceId;
    }

    // Getters and Setters

    public Long getUserId() {
        return userId;
    }

    public Long getResourceId() {
        return resourceId;
    }
}

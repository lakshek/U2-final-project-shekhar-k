package com.example.wired2learn.dto;

public class ResourceRequestDTO {

    private String title;
    private String url;
    private String description;
    private boolean locked;

    // Constructors
    public ResourceRequestDTO() {
    }

    public ResourceRequestDTO(String title, String url, String description, boolean locked) {
        this.title = title;
        this.url = url;
        this.description = description;
        this.locked = locked;
    }

    //Getters and Setters

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

    public boolean getLocked() {
        return locked;
    }
    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}

package com.example.wired2learn.model;

import jakarta.persistence.*;
import org.springframework.web.servlet.tags.form.TextareaTag;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "resources")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "resource_title", nullable = false)
    private String title;

    @Column(name = "resource_url", length = 500, nullable = false)
    private String url;

    @Column(name = "resource_description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "resource_is_protected", nullable = false)
    private boolean isProtected;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @OneToMany(mappedBy = "resource", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Favorite> favorites;

    // Constructors
    public Resource () {
    }

    public Resource(String title, String url, String description, boolean isProtected) {
        this.title = title;
        this.url = url;
        this.description = description;
        this.isProtected = isProtected;
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
    }

    // Getters and Setters

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

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public List<Favorite> getFavorites() {
        return favorites;
    }
}

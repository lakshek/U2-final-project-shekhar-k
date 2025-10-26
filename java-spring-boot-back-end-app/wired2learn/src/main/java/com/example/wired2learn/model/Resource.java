package com.example.wired2learn.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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

    @Column(name = "resource_locked", nullable = false)
    private boolean locked;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @OneToMany(mappedBy = "resource")
    private List<Favorite> favorites;

    // Constructors
    public Resource () {
    }

    public Resource(String title, String url, String description, boolean locked) {
        this.title = title;
        this.url = url;
        this.description = description;
        this.locked = locked;
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

    public List<Favorite> getFavorites() {
        return favorites;
    }
}

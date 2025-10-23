package com.example.wired2learn.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class JournalResponseDTO {

    private Long id;
    private Long userId;
    private String title;
    private LocalDate date;
    private String entry;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    // Constructors
    public JournalResponseDTO() {
    }

    public JournalResponseDTO(Long id, Long userId, String title, LocalDate date, String entry, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.date = date;
        this.entry = entry;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEntry() {
        return entry;
    }
    public void setEntry(String entry) {
        this.entry = entry;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }
}

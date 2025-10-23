package com.example.wired2learn.dto;

import java.time.LocalDate;

public class JournalRequestDTO {

    private Long userId;
    private String title;
    private LocalDate date;
    private String entry;

    // Constructors
    public JournalRequestDTO() {
    }

    public JournalRequestDTO (Long userId, String title, LocalDate date, String entry) {
        this.userId = userId;
        this.title = title;
        this.date = date;
        this.entry = entry;
    }

    // Getters and Setters

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
}

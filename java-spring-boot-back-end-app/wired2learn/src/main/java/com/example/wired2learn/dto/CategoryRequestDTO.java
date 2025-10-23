package com.example.wired2learn.dto;

public class CategoryRequestDTO {

    private String name;

    // Constructors
    public CategoryRequestDTO() {
    }

    public CategoryRequestDTO(String name) {
        this.name = name;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

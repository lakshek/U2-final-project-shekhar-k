package com.example.wired2learn.service;

import com.example.wired2learn.dto.CategoryRequestDTO;
import com.example.wired2learn.dto.CategoryResponseDTO;
import com.example.wired2learn.model.Category;
import com.example.wired2learn.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // CREATE
    public CategoryResponseDTO createCategory(CategoryRequestDTO dto) {

        // Create a new category object from the DTO
        Category category = new Category(dto.getName());

        // Save category to the database
        Category savedCategory = categoryRepository.save(category);

        // Convert the saved category to CategoryResponseDTO and return it
        return mapToResponse(savedCategory);
    }

    // READ ALL
    public List<CategoryResponseDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();

        // Create a new Array List to hold CategoryResponseDTOs
        List<CategoryResponseDTO> responseList = new ArrayList<>();

        // Convert each category object to CategoryResponseDTO and add it to the responseList
        for (Category category : categories) {
            responseList.add(mapToResponse(category));
        }

        // return responseList
        return responseList;
    }

    // READ BY ID
    public CategoryResponseDTO getCategoryById(Long id) {

        // Check if Category exists. If category not found, throw exception
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        return mapToResponse(category);
    }

    // UPDATE
    public CategoryResponseDTO updateCategory(long id, CategoryRequestDTO dto) {

        // Check if Category exists. If Category not found, throw exception
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        // Update Category fields
        category.setName(dto.getName());

        // Save the updated Category to the database
        Category savedCategory = categoryRepository.save(category);

        // Convert the saved Category to CategoryResponseDTO and return it
        return mapToResponse(savedCategory);
    }

    // DELETE
    public void deleteCategory(Long id) {

        // Check if Category exists. If Category not found, throw exception
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        categoryRepository.delete(category);
    }

    // Helper method to map Category object to CategoryResponseDTO
    public CategoryResponseDTO mapToResponse(Category category) {
        return new CategoryResponseDTO(
                category.getId(),
                category.getName(),
                category.getCreatedAt(),
                category.getModifiedAt()
        );
    }
}

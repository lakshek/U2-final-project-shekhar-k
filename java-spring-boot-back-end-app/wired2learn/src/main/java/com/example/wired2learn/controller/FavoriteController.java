package com.example.wired2learn.controller;

import com.example.wired2learn.dto.FavoriteRequestDTO;
import com.example.wired2learn.dto.FavoriteResponseDTO;
import com.example.wired2learn.repository.FavoriteRepository;
import com.example.wired2learn.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    // Create a favorite
    @PostMapping
    public ResponseEntity<FavoriteResponseDTO> createFavorite(@RequestBody FavoriteRequestDTO favoriteRequestDTO) {
        return ResponseEntity.ok(favoriteService.createFavorite(favoriteRequestDTO));
    }

    // Get all favorites
    @GetMapping
    public ResponseEntity<List<FavoriteResponseDTO>> getAllFavorites() {
        return ResponseEntity.ok(favoriteService.getAllFavorites());
    }

    // Get a favorite by id
    public ResponseEntity<FavoriteResponseDTO> getFavoriteById(@PathVariable Long id) {
        return ResponseEntity.ok(favoriteService.getFavoriteById(id));
    }

    // Delete a favorite
    public ResponseEntity<String> deleteFavorite(@PathVariable Long id) {
        favoriteService.deleteFavorite(id);
        return ResponseEntity.ok("Favorite deleted successfully.");
    }
}

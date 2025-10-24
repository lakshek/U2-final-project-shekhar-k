package com.example.wired2learn.service;

import com.example.wired2learn.dto.FavoriteRequestDTO;
import com.example.wired2learn.dto.FavoriteResponseDTO;
import com.example.wired2learn.model.Favorite;
import com.example.wired2learn.model.Resource;
import com.example.wired2learn.model.User;
import com.example.wired2learn.repository.FavoriteRepository;
import com.example.wired2learn.repository.ResourceRepository;
import com.example.wired2learn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    // CREATE
    public FavoriteResponseDTO createFavorite(FavoriteRequestDTO dto) {

        // Check if User exists. If User not found, throw exception
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("User not found with id: " + dto.getUserId()));

        // Check if Resource exists. If Resource not found, throw exception
        Resource resource = resourceRepository.findById(dto.getResourceId()).orElseThrow(() -> new RuntimeException("Resource not found with id: " + dto.getResourceId()));

        // If User and Journal are found, create a Favorite object from the dto
        Favorite favorite = new Favorite(user, resource);

        Favorite savedFavorite = favoriteRepository.save(favorite);

        return mapToResponse(savedFavorite);
    }

    // READ ALL
    public List<FavoriteResponseDTO> getAllFavorites() {
        List<Favorite> favorites = favoriteRepository.findAll();

        // Create a new Array List to hold the FavoriteResponseDTOs
        List<FavoriteResponseDTO> responseList = new ArrayList<>();

        // Convert each favorite object to FavoriteResponseDTO and add it to the list
        for (Favorite favorite : favorites) {
            responseList.add(mapToResponse(favorite));
        }

        // return the list of FavoriteResponseDTOs
        return responseList;
    }

    // READ BY ID
    public FavoriteResponseDTO getFavoriteById(Long id) {

        // Check if favorite exists. If favorite not found, throw exception
        Favorite favorite = favoriteRepository.findById(id).orElseThrow(() -> new RuntimeException("Favorite not found with id: " + id));

        return mapToResponse(favorite);
    }

    // DELETE
    public void deleteFavorite(Long id) {

        // Check if favorite exists. If favorite not found, throw exception
        Favorite favorite = favoriteRepository.findById(id).orElseThrow(() -> new RuntimeException("Favorite not found with id: " + id));
        favoriteRepository.delete(favorite);
    }


    // Helper method to map favorite object to FavoriteResponseDTO
    public FavoriteResponseDTO mapToResponse(Favorite favorite) {
        return new FavoriteResponseDTO(
                favorite.getId(),
                favorite.getUser().getId(),
                favorite.getResource().getId(),
                favorite.getCreatedAt()
        );
    }
}

package com.example.wired2learn.service;

import com.example.wired2learn.dto.ResourceRequestDTO;
import com.example.wired2learn.dto.ResourceResponseDTO;
import com.example.wired2learn.model.Resource;
import com.example.wired2learn.repository.FavoriteRepository;
import com.example.wired2learn.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

//    @Autowired
//    private FavoriteRepository favoriteRepository;

    // CREATE
    public ResourceResponseDTO createResource(ResourceRequestDTO dto) {

        // Create resource from DTO
        Resource resource = new Resource(dto.getTitle(), dto.getUrl(), dto.getDescription(), dto.getLocked());

        // Save the object to the database
        Resource savedResource = resourceRepository.save(resource);

        // Convert the saved object to ResourceResponseDTO and return it
        return mapToResponse(savedResource);
    }

    // READ ALL
    public List<ResourceResponseDTO> getAllResources() {
        List<Resource> resources = resourceRepository.findAll();

        // Create a new Array List to hold the Response List
        List<ResourceResponseDTO> responseList = new ArrayList<>();

        // Convert each object to ResourceResponseDTO and add it to the list
        for (Resource resource : resources) {
            responseList.add(mapToResponse(resource));
        }

        // Return the list
        return responseList;
    }

    // READ BY ID
    public ResourceResponseDTO getResourceById(Long id) {

        // Check if resource exists. If resource not found, throw exception
        Resource resource = resourceRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource not found with id: " + id));

        return mapToResponse(resource);
    }

    // UPDATE
    public ResourceResponseDTO updateResource(Long id, ResourceRequestDTO dto) {

        // Check if resource exists. If resource not found, throw exception
        Resource resource = resourceRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource not found with id: " + id));

        // Update resource fields from DTO
        resource.setTitle(dto.getTitle());
        resource.setUrl(dto.getUrl());
        resource.setDescription(dto.getDescription());
        resource.setLocked(dto.getLocked());

        // Save the object to the database
        Resource savedResource = resourceRepository.save(resource);

        // Convert saved resource to ResourceResponseDTO and return it
        return mapToResponse(savedResource);
    }

    // DELETE
    public void deleteResource(Long id) {

        // Check if resource exists. If resource not found, throw exception
        Resource resource = resourceRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource not found with id: " + id));

        // Check if favorite exists for the user. If favorite found, throw exception
//        if (favoriteRepository.existsByResource(resource)) {
//            throw new RuntimeException("Cannot delete resource. Favorites exist for this user. Delete favorites first.");
//        }

        resourceRepository.delete(resource);
    }


    // Helper method to convert resource object to ResourceResponseDTO
    public ResourceResponseDTO mapToResponse(Resource resource) {
        return new ResourceResponseDTO(
            resource.getId(),
            resource.getTitle(),
            resource.getUrl(),
            resource.getDescription(),
            resource.getLocked(),
            resource.getCreatedAt(),
            resource.getModifiedAt()
        );
    }
}

package com.example.wired2learn.controller;

import com.example.wired2learn.dto.ResourceRequestDTO;
import com.example.wired2learn.dto.ResourceResponseDTO;
import com.example.wired2learn.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    // Create a resource
    @PostMapping
    public ResponseEntity<ResourceResponseDTO> createResource(@RequestBody ResourceRequestDTO resourceRequestDTO) {
        return ResponseEntity.ok(resourceService.createResource(resourceRequestDTO));
    }

    // Read all resources
    @GetMapping
    public ResponseEntity<List<ResourceResponseDTO>> getAllResources() {
        return ResponseEntity.ok(resourceService.getAllResources());
    }

    // Read a resource by id
    @GetMapping("/{id}")
    public ResponseEntity<ResourceResponseDTO> getResourceById(@PathVariable Long id) {
        return ResponseEntity.ok(resourceService.getResourceById(id));
    }

    // Update a resource
    @PutMapping("/{id}")
    public ResponseEntity<ResourceResponseDTO> updateResource(@PathVariable Long id, @RequestBody ResourceRequestDTO resourceRequestDTO) {
        return ResponseEntity.ok(resourceService.updateResource(id, resourceRequestDTO));
    }

    // Delete resource
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteResource(@PathVariable Long id) {
        resourceService.deleteResource(id);
        return ResponseEntity.ok("Resource deleted successfully.");
    }
}

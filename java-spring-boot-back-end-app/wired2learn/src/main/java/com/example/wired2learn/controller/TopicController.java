package com.example.wired2learn.controller;

import com.example.wired2learn.dto.TopicRequestDTO;
import com.example.wired2learn.dto.TopicResponseDTO;
import com.example.wired2learn.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    // Create a topic
    @PostMapping
    public ResponseEntity<TopicResponseDTO> createTopic(@RequestBody TopicRequestDTO topicRequestDTO) {
        return ResponseEntity.ok(topicService.createTopic(topicRequestDTO));
    }

    // Read all topics
    @GetMapping
    public ResponseEntity<List<TopicResponseDTO>> getAllTopics() {
        return ResponseEntity.ok(topicService.getAllTopics());
    }

    // Read a topic by id
    @GetMapping("/{id}")
    public ResponseEntity<TopicResponseDTO> getTopicById(@PathVariable Long id) {
        return ResponseEntity.ok(topicService.getTopicById(id));
    }

    // Update a topic
    @PutMapping("/{id}")
    public ResponseEntity<TopicResponseDTO> updateTopic(@PathVariable Long id, @RequestBody TopicRequestDTO topicRequestDTO) {
        return ResponseEntity.ok(topicService.updateTopic(id, topicRequestDTO));
    }

    // Delete a topic
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return ResponseEntity.ok("Topic deleted successfully.");
    }
}

package com.example.wired2learn.service;

import com.example.wired2learn.dto.TopicRequestDTO;
import com.example.wired2learn.dto.TopicResponseDTO;
import com.example.wired2learn.model.Category;
import com.example.wired2learn.model.Topic;
import com.example.wired2learn.repository.CategoryRepository;
import com.example.wired2learn.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // CREATE
    public TopicResponseDTO createTopic(TopicRequestDTO dto) {

        // Check if Category exists. If Category not found, throw exception
        Category category = categoryRepository.findById(dto.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found with id: " + dto.getCategoryId()));

        // Create topic object from the DTO
        Topic topic = new Topic(category, dto.getTitle(), dto.getContent(), dto.getImageUrl(), dto.getLocked());

        // Save Topic to the database
        Topic savedTopic = topicRepository.save(topic);

        // Convert saved topic to TopicResponseDTO and return it

        return mapToResponse(savedTopic);
    }

    // READ ALL
    public List<TopicResponseDTO> getAllTopics() {
        List<Topic> topics = topicRepository.findAll();

        // Create a new Array List to hold the TopicResponseDTOs
        List<TopicResponseDTO> responseList = new ArrayList<>();

        // Convert each Topic object to TopicResponseDTO and add it to the List
        for (Topic topic : topics) {
            responseList.add(mapToResponse(topic));
        }

        // Return the list of TopicResponseDTOs
        return responseList;
    }

    // READ BY ID
    public TopicResponseDTO getTopicById(Long id) {

        // Check if topic exists. If topic not found, throw exception
        Topic topic = topicRepository.findById(id).orElseThrow(() -> new RuntimeException("Topic not found with id: " + id));

        return mapToResponse(topic);
    }

    // UPDATE
    public TopicResponseDTO updateTopic(Long id, TopicRequestDTO dto) {

        // Check if topic exists. If topic not found, throw exception
        Topic topic = topicRepository.findById(id).orElseThrow(() -> new RuntimeException("Topic not found with id: " + id));

        // Check if category exists. If category not found, throw exception
        Category category = categoryRepository.findById(dto.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found with id: " + dto.getCategoryId()));

        // Update the topic fields
        topic.setCategory(category);
        topic.setTitle(dto.getTitle());
        topic.setContent(dto.getContent());
        topic.setImageUrl(dto.getImageUrl());
        topic.setLocked(dto.getLocked());

        // Save topic to the database
        Topic savedTopic = topicRepository.save(topic);

        // Convert the saved topic to TopicResponseDTO and return it
        return mapToResponse(savedTopic);
    }

    // DELETE
    public void deleteTopic(Long id) {

        // Check if topic exists. If topic not found, throw exception
        Topic topic = topicRepository.findById(id).orElseThrow(() -> new RuntimeException("Topic not found with id: " + id));

        topicRepository.delete(topic);
    }


    // Helper method to map topic object to TopicResponseDTO
    public TopicResponseDTO mapToResponse(Topic topic) {
        return new TopicResponseDTO(
                topic.getId(),
                topic.getCategory().getId(),
                topic.getTitle(),
                topic.getContent(),
                topic.getImageUrl(),
                topic.getLocked(),
                topic.getCreatedAt(),
                topic.getModifiedAt()
        );
    }
}

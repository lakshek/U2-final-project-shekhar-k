package com.example.wired2learn.repository;

import com.example.wired2learn.model.Category;
import com.example.wired2learn.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    boolean existsByCategory(Category category);
}

package com.example.wired2learn.repository;

import com.example.wired2learn.model.Journal;
import com.example.wired2learn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {
    boolean existsByUser(User user);
    List<Journal> findByUser(User user);
}

package com.example.wired2learn.repository;

import com.example.wired2learn.model.Favorite;
import com.example.wired2learn.model.Resource;
import com.example.wired2learn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    boolean existsByUser(User user);
    boolean existsByResource(Resource resource);
}

package com.example.wired2learn.service;

import com.example.wired2learn.dto.LoginRequestDTO;
import com.example.wired2learn.dto.UserRequestDTO;
import com.example.wired2learn.dto.UserResponseDTO;
import com.example.wired2learn.model.User;
import com.example.wired2learn.repository.JournalRepository;
import com.example.wired2learn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JournalRepository journalRepository;

//    @Autowired
//    private FavoriteRepository favoriteRepository;

    // CREATE
    public UserResponseDTO createUser(UserRequestDTO dto) {

        // Check if email exists
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already registered.");
        }

        // Hash the password before saving
        String hashedPassword = passwordEncoder.encode(dto.getPassword());

        // Create a new User object from the DTO
        User user = new User(dto.getName(), dto.getEmail(), hashedPassword, dto.getRole());

        // Save the user to the database
        User savedUser = userRepository.save(user);

        // Convert the saved User object to a UserResponseDTO and return it
        return mapToResponse(savedUser);
    }

    // AUTHENTICATE USER (LOGIN)
    public UserResponseDTO authenticateUser(LoginRequestDTO loginDto) {
        // Check if email exists
        User user = userRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password."));

        // If email exists, check if password exists
        boolean matches = passwordEncoder.matches(loginDto.getPassword(), user.getPassword());

        // If password doesn't match, throw an error
        if (!matches) {
            throw new RuntimeException("Invalid email or password.");
        }

        return mapToResponse(user);
    }

    // READ ALL
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();

        // Create a new ArrayList to hold UserResponseDTOs
        List<UserResponseDTO> responseList = new ArrayList<>();

        // Convert each User object to UserResponseDTO and add it to the response list
        for (User user : users) {
            responseList.add(mapToResponse(user));
        }

        // Return the list of UserResponseDTOs
        return responseList;
    }

    // READ BY ID
    public UserResponseDTO getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        // If user is not found, throw exception
        if(!optionalUser.isPresent()) {
            throw new RuntimeException("User not found with id: " + id);
        }

        // Is user is found, map to UserResponseDTO
        User user = optionalUser.get();
        return mapToResponse(user);
    }

    // UPDATE
    public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {

        // Check if user exists. If user not found, throw exception
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        // Update user fields
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        // Hash the password before updating
        String hashedPassword = passwordEncoder.encode(dto.getPassword());
        user.setPassword(hashedPassword);

        user.setRole(dto.getRole());

        // Save the updated user to the database
        User updatedUser = userRepository.save(user);

        // Convert the updated User object to a UserResponseDTO and return it
        return mapToResponse(updatedUser);
    }

    // DELETE
    public void deleteUser(Long id) {

        // Check if user exists. If user not found, throw exception
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        // Check if journal exists for the user. If journal found, throw exception
        if (journalRepository.existsByUser(user)) {
            throw new RuntimeException("Cannot delete user: journals exist for this user. Delete journals first.");
        }

        // Check if favorite exists for the user. If favorite found, throw exception
//        if (favoriteRepository.existsByUser(user)) {
//            throw new RuntimeException("Cannot delete user. Favorites exist for this user. Delete favorites first.");
//        }

        userRepository.delete(user);
    }

    
    // Helper method to map User object to UserResponseDTO
    private UserResponseDTO mapToResponse(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getCreatedAt()
        );
    }
}

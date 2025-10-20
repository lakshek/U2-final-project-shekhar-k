package com.example.wired2learn.service;

import com.example.wired2learn.dto.UserRequestDTO;
import com.example.wired2learn.dto.UserResponseDTO;
import com.example.wired2learn.model.User;
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

    // CREATE
    public UserResponseDTO createUser(UserRequestDTO dto) {

        // Hash the password before saving
        String hashedPassword = passwordEncoder.encode(dto.getPassword());

        // Create a new User entity from the DTO
        User user = new User(dto.getName(), dto.getEmail(), hashedPassword, dto.getRole());

        // Save the user to the database
        User savedUser = userRepository.save(user);

        // Convert the saved User entity to a UserResponseDTO and return it
        return mapToResponse(savedUser);
    }

    // READ ALL
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();

        // Create a new ArrayList to hold UserResponseDTOs
        List<UserResponseDTO> responseList = new ArrayList<>();

        // Convert each User entity to UserResponseDTO and add to the response list
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
        Optional<User> optionalUser = userRepository.findById(id);

        // If user is not found, throw exception
        if(!optionalUser.isPresent()) {
            throw new RuntimeException("User not found with id: " + id);
        }

        // If use is found, Create a new User entity from the DTO
        User user = optionalUser.get();

        // Update user fields
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        // Hash the password before updating
        String hashedPassword = passwordEncoder.encode(dto.getPassword());
        user.setPassword(hashedPassword);

        user.setRole(dto.getRole());

        // Save the updated user to the database
        User updatedUser = userRepository.save(user);

        // Convert the updated User entity to a UserResponseDTO and return it
        return mapToResponse(updatedUser);
    }

    // DELETE
    public void deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        // If user is not found, throw exception
        if(!optionalUser.isPresent()) {
            throw new RuntimeException("User not found with id: " + id);
        }

        User user = optionalUser.get();
        userRepository.delete(user);
    }

    
    // Helper method to map User entity to UserResponseDTO
    private UserResponseDTO mapToResponse(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }
}

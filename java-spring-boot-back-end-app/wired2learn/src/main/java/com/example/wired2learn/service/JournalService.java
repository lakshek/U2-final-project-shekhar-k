package com.example.wired2learn.service;

import com.example.wired2learn.dto.JournalRequestDTO;
import com.example.wired2learn.dto.JournalResponseDTO;
import com.example.wired2learn.model.Journal;
import com.example.wired2learn.model.User;
import com.example.wired2learn.repository.JournalRepository;
import com.example.wired2learn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;

    @Autowired
    private UserRepository userRepository;

    // CREATE
    public JournalResponseDTO createJournal(JournalRequestDTO dto) {

        // Check if User exists. If User not found, throw an exception
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("User not found with id: " + dto.getUserId()));

        // If User is found, create a journal object from the DTO
        Journal journal = new Journal(user, dto.getTitle(), dto.getDate(), dto.getEntry());

        Journal savedJournal = journalRepository.save(journal);

        return mapToResponse(savedJournal);
    }

    // READ ALL
    public List<JournalResponseDTO> getAllJournals() {
        List<Journal> journals = journalRepository.findAll();

        // Create a new ArrayList to hold the JournalResponseDTOs
        List<JournalResponseDTO> responseList = new ArrayList<>();

        // Convert each journal object to JournalResponseDTO and add it to the response list
        for (Journal journal: journals) {
            responseList.add(mapToResponse(journal));
        }

        // return the list of JournalResponseDTOs
        return responseList;
    }

    // READ BY ID
    public JournalResponseDTO getJournalById(Long id) {

        // Check if journal exists. If journal not found, throw exception
        Journal journal = journalRepository.findById(id).orElseThrow(() -> new RuntimeException("Journal not found with id: " + id));

        return mapToResponse(journal);
    }

    // UPDATE
    public JournalResponseDTO updateJournal(Long id, JournalRequestDTO dto) {

        // Check if journal exists. If journal not found, throw exception
        Journal journal = journalRepository.findById(id).orElseThrow(() -> new RuntimeException("Journal not found with id: " + id));

        // Check if user exists. If user not found, throw exception
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("User not found with id:" + dto.getUserId()));

        // Update journal fields
        journal.setUser(user);
        journal.setTitle(dto.getTitle());
        journal.setDate(dto.getDate());
        journal.setEntry(dto.getEntry());

        // Save the updated journal to the database
        Journal updatedJournal = journalRepository.save(journal);

        // Convert the updated journal object to JournalResponseDTO and return it
        return mapToResponse(updatedJournal);
    }

    // DELETE
    public void deleteJournal(Long id) {

        // Check if journal exists. If journal not found, throw exception
        Journal journal = journalRepository.findById(id).orElseThrow(() -> new RuntimeException("Journal not found with the id: " + id));

        journalRepository.delete(journal);
    }

    // Helper method to map Journal object to JournalResponseDTO
    public JournalResponseDTO mapToResponse(Journal journal) {
        return new JournalResponseDTO(
                journal.getId(),
                journal.getUser().getId(),
                journal.getTitle(),
                journal.getDate(),
                journal.getEntry(),
                journal.getCreatedAt(),
                journal.getModifiedAt()
        );
    }
}

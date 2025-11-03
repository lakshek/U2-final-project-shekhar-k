package com.example.wired2learn.controller;

import com.example.wired2learn.dto.JournalRequestDTO;
import com.example.wired2learn.dto.JournalResponseDTO;
import com.example.wired2learn.dto.ResourceResponseDTO;
import com.example.wired2learn.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/journals")
public class JournalController {

    @Autowired
    private JournalService journalService;

    // Create a Journal
    @PostMapping
    public ResponseEntity<JournalResponseDTO> createJournal(@RequestBody JournalRequestDTO journalRequestDTO) {
        return ResponseEntity.ok(journalService.createJournal(journalRequestDTO));
    }

    // Get all Journals
    @GetMapping
    public ResponseEntity<List<JournalResponseDTO>> getAllJournals() {
        return ResponseEntity.ok(journalService.getAllJournals());
    }

    // Get all journals for a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<JournalResponseDTO>> getJournalByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(journalService.getJournalsByUser(userId));
    }

    // Get a Journal by id
    @GetMapping("/{id}")
    public ResponseEntity<JournalResponseDTO> getJournalById(@PathVariable Long id) {
        return ResponseEntity.ok(journalService.getJournalById(id));
    }

    // Update a Journal
    @PutMapping("/{id}")
    public ResponseEntity<JournalResponseDTO> updateJournal(@PathVariable Long id, @RequestBody JournalRequestDTO journalRequestDTO) {
        return ResponseEntity.ok(journalService.updateJournal(id, journalRequestDTO));
    }

    // Delete a Journal
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJournal(@PathVariable Long id) {
        journalService.deleteJournal(id);
        return ResponseEntity.ok("Journal deleted successfully.");
    }
}

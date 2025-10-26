package com.example.wired2learn.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// Mark this class as a configuration class so Spring knows to look here for beans
@Configuration
public class SecurityConfig {

    // Define a PasswordEncoder bean so passwords can be hashed
    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCryptPasswordEncoder is a secure way to convert any password to hashed string
        return new BCryptPasswordEncoder();
    }
}

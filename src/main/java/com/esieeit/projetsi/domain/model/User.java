package com.esieeit.projetsi.domain.model; // Ton package exact

import com.esieeit.projetsi.domain.enums.UserRole; // Import de TON enum
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    private String email;
    private String password;

    // ... tes autres champs (email, password)

    // C'est ici que la magie opère
    @Enumerated(EnumType.STRING) // Indispensable pour stocker "USER" ou "ADMIN" en texte
    @Column(name = "role", nullable = false)
    private UserRole role = UserRole.USER; // On utilise le nom exact de ton enum

    // Constructeur par défaut (obligatoire pour JPA)
    public User() {}

    // --- GETTERS ET SETTERS ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public UserRole getRole() { 
        return role; 
    }
    
    public void setRole(UserRole role) { 
        this.role = role; 
    }
}
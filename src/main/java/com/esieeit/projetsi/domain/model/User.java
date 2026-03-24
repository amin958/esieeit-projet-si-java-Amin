package com.esieeit.projetsi.domain.model; // Ton package exact

import com.esieeit.projetsi.domain.enums.UserRole; // Import de TON enum
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    // ... tes autres champs (email, password)

    // C'est ici que la magie opère
    @Enumerated(EnumType.STRING) // Indispensable pour stocker "USER" ou "ADMIN" en texte
    @Column(name = "role", nullable = false)
    private UserRole role = UserRole.USER; // On utilise le nom exact de ton enum

    // Constructeur par défaut (obligatoire pour JPA)
    public User() {}

    // Getters et Setters
    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
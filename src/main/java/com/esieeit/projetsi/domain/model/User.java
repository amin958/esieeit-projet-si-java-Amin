package com.esieeit.projetsi.domain.model;

import com.esieeit.projetsi.domain.enums.UserRole;
import com.esieeit.projetsi.domain.validation.Validators;
import java.util.HashSet;
import java.util.Set;

public class User {
    private Long id;
    private String email;
    private String username;
    private Set<UserRole> roles;

    public User(String email, String username) {
        this.email = Validators.requireEmail(email, "email");
        this.username = Validators.requireNonBlank(username, "username", 3, 30);
        this.roles = new HashSet<>();
        this.roles.add(UserRole.USER); // Rôle par défaut
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEmail() { return email; }
    public String getUsername() { return username; }
    public Set<UserRole> getRoles() { return roles; }

    @Override
    public String toString() {
        return "User{username='" + username + "', email='" + email + "'}";
    }
}
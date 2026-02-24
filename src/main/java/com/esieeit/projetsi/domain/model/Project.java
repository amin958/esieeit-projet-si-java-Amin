package com.esieeit.projetsi.domain.model;

import com.esieeit.projetsi.domain.validation.Validators;

public class Project {
    private Long id;
    private String name;
    private String description;
    private User owner;

    public Project(String name, String description, User owner) {
        this.name = Validators.requireNonBlank(name, "nom du projet", 1, 80);
        this.description = description; // Peut être null
        Validators.requireNonNull(owner, "propriétaire du projet");
        this.owner = owner;
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public User getOwner() { return owner; }

    public void setId(Long id) { this.id = id; }

    @Override
    public String toString() {
        return "Project{name='" + name + "', owner=" + owner.getUsername() + "}";
    }
}
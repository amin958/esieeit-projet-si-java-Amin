package com.esieeit.projetsi.domain.model;

import com.esieeit.projetsi.domain.enums.ProjectStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "projects")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProjectStatus status = ProjectStatus.DRAFT;

    // C'est ici qu'on fait le lien avec la table 'users' !
    // Plusieurs projets peuvent appartenir à UN seul propriétaire.
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    // Constructeur vide obligatoire pour JPA
    public Project() {}

    public Project(String name, String description, User owner) {
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.status = ProjectStatus.DRAFT;
    }

    // --- Getters & Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public ProjectStatus getStatus() { return status; }
    public void setStatus(ProjectStatus status) { this.status = status; }
    
    @JsonIgnore
    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
}
package com.esieeit.projetsi.domain.model;

import com.esieeit.projetsi.domain.enums.TaskStatus;
import com.esieeit.projetsi.domain.exception.DomainException;
import com.esieeit.projetsi.domain.validation.Validators;

public class Task {
    private Long id;
    private String title;
    private TaskStatus status;
    private Project project;

    public Task(String title, Project project) {
        this.title = Validators.requireNonBlank(title, "titre de la tâche", 1, 120);
        Validators.requireNonNull(project, "projet associé");
        this.project = project;
        this.status = TaskStatus.TODO;
    }

    // --- Méthodes Métier (Workflow) ---
    
    public void start() {
        if (this.status != TaskStatus.TODO) {
            throw new DomainException("Impossible de démarrer une tâche qui n'est pas en TODO");
        }
        this.status = TaskStatus.IN_PROGRESS;
    }

    public void complete() {
        if (this.status != TaskStatus.IN_PROGRESS) {
            throw new DomainException("On ne peut terminer qu'une tâche en cours (IN_PROGRESS)");
        }
        this.status = TaskStatus.DONE;
    }

    public void archive() {
        if (this.status != TaskStatus.DONE) {
            throw new DomainException("Seule une tâche terminée (DONE) peut être archivée");
        }
        this.status = TaskStatus.ARCHIVED;
    }

    // --- Getters (Indispensables pour enlever le jaune et lire les données) ---

    public Long getId() { 
        return id; 
    }

    public String getTitle() { 
        return title; 
    }

    public TaskStatus getStatus() { 
        return status; 
    }

    public Project getProject() {
        return project;
    }

    // --- Setters ---

    public void setId(Long id) { 
        this.id = id; 
    }

    @Override
    public String toString() {
        return "Task{title='" + title + "', status=" + status + "}";
    }
}

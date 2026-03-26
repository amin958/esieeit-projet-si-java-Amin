package com.esieeit.projetsi.controller;

import com.esieeit.projetsi.domain.model.Project;
import com.esieeit.projetsi.service.ProjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // 1. On dit à Spring : "C'est une API Web !"
@RequestMapping("/api/projects") // 2. Voici l'adresse URL pour accéder à ce guichet
public class ProjectController {

    private final ProjectService projectService;

    // 3. On connecte le Controller au Service
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping // 4. Quand on fait une requête GET (lecture) sur cette adresse...
    public List<Project> getAllProjects() {
        // ... on demande au service de nous donner les vrais projets de MySQL !
        return projectService.getAllProjects(); 
    }
}
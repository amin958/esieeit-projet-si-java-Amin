package com.esieeit.projetsi.service; // Adapte le package si besoin

import com.esieeit.projetsi.domain.model.Project;
import com.esieeit.projetsi.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Cette annotation dit à Spring : "Ceci est le cerveau métier"
public class ProjectService {

    private final ProjectRepository projectRepository;

    // Injection du Repository
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    // La méthode qui va chercher les vrais projets en base
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}
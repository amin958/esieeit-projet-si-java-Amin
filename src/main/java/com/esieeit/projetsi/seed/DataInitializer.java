package com.esieeit.projetsi.seed;

import com.esieeit.projetsi.domain.model.Project;
import com.esieeit.projetsi.domain.model.Task;
import com.esieeit.projetsi.domain.model.User;
import com.esieeit.projetsi.domain.enums.UserRole;
// Ajoute ici tes autres imports d'enums si besoin (ex: TaskStatus)

import com.esieeit.projetsi.repository.ProjectRepository;
import com.esieeit.projetsi.repository.TaskRepository;
import com.esieeit.projetsi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    // Injection des dépendances (tes 3 Repositories)
    public DataInitializer(UserRepository userRepository, ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    @Bean
    CommandLineRunner initData() {
        return args -> {
            // 1. On vérifie si la base est déjà remplie pour ne pas créer de doublons
            if (userRepository.count() > 0) {
                System.out.println("Base de données déjà initialisée !");
                return;
            }

            System.out.println("Création des données de test en cours...");

            // 2. Création des Utilisateurs
            User admin = new User();
            admin.setUsername("admin");
            admin.setEmail("admin@esiee.fr");
            admin.setPassword("motdepasse123"); 
            admin.setRole(UserRole.ADMIN);

            User dev = new User();
            dev.setUsername("amin");
            dev.setEmail("amine@esiee.fr");
            dev.setPassword("motdepasse123");
            dev.setRole(UserRole.USER);

            userRepository.saveAll(List.of(admin, dev));

            // 3. Création d'un Projet
            Project projetSI = new Project();
            projetSI.setName("IJ Start App"); // Petit clin d'oeil à ton alternance !
            projetSI.setDescription("Application pour le Centre Information Jeunesse");
            projetSI.setOwner(admin); 
            
            projectRepository.save(projetSI);

            // 4. Création des Tâches liées au projet
            Task task1 = new Task();
            task1.setTitle("Faire le design Figma");
            task1.setDescription("Maquettes de l'application mobile");
            task1.setProject(projetSI); 

            Task task2 = new Task();
            task2.setTitle("Créer l'API Spring Boot");
            task2.setDescription("TP 4.1 et 4.2");
            task2.setProject(projetSI); 
            
            taskRepository.saveAll(List.of(task1, task2));

            System.out.println("Données de test injectées avec succès !");
        };
    }
}
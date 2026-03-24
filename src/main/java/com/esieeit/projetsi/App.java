package com.esieeit.projetsi; // Attention : vérifie que ce nom correspond au dossier où se trouve le fichier

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        // Cette ligne lance officiellement l'application
        SpringApplication.run(App.class, args);
        System.out.println("L'application SI est lancée avec succès !");
    }

}
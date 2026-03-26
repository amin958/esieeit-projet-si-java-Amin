# IJ Start - Système de Gestion de Projets SI

## 📌 Présentation du Projet
**IJ Start** est une application de gestion de projets et de tâches collaboratives développée dans le cadre du module "Projet SI" à l'ESIEE-IT. L'objectif est de fournir une plateforme robuste pour suivre l'avancement des développements au sein d'une organisation, en respectant les standards professionnels du développement Java.

## 🛠️ Stack Technique
- **Langage :** Java 17+
- **Framework :** Spring Boot (Web, Data JPA, Validation)
- **Base de données :** MySQL (via Docker Compose)
- **Architecture :** Clean Architecture / 3-Layers
- **Outils :** Gradle/Maven, Postman, Git

## 🏗️ Architecture du Projet
Le projet suit une structure en couches pour assurer la séparation des responsabilités :
- **API (Web) :** Controllers REST et DTOs pour l'exposition des données.
- **Application (Service) :** Logique métier, validations et règles de gestion.
- **Domain (Entity) :** Modèles métier (Project, User, Task) et Enums de statut.
- **Infrastructure (Repository) :** Persistance des données via Spring Data JPA.

## 🚀 Installation et Lancement
1. **Cloner le dépôt :** `git clone <url-du-repo>`
2. **Lancer la base de données :** `docker-compose up -d`
3. **Lancer l'application :** `./gradlew bootRun` ou via l'IDE
4. **Accéder à l'API :** `http://localhost:8080/api/projects`

## 📋 Fonctionnalités (MVP)
- [x] CRUD complet sur les Projets.
- [x] Gestion des tâches liées aux projets (One-to-Many).
- [x] Validation des données en entrée (Annotations `@Valid`).
- [x] Mapping Entité <-> DTO pour la sécurité des données.

---
**Auteur :** Amin AGHANI - Bachelor 2ème année
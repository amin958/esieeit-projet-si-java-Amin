# Backlog Produit - Projet SI Java (ESIEE-IT)

## 1. Définition du Produit
**Pitch :** Notre application permet aux utilisateurs de centraliser la gestion de leurs projets et de leurs tâches. Elle offre une structure claire pour organiser le travail quotidien, avec une gestion sécurisée des accès.

## 2. Acteurs (Personas)
| Acteur | Objectifs | Permissions |
| :--- | :--- | :--- |
| **Visiteur** | Découvrir l'application | Voir la page d'accueil, s'inscrire |
| **Utilisateur** | Gérer ses projets et tâches | CRUD projets et tâches personnels |
| **Admin** | Superviser la plateforme | Voir tous les comptes, bloquer/supprimer |

## 3. Modules / Features
- **Module A :** Authentification & Profil
- **Module B :** Gestion des projets
- **Module C :** Gestion des tâches
- **Module D :** Recherche / Filtre
- **Module E :** Administration (bonus)

## 4. User Stories (MoSCoW + Estimation)

| ID | Module | User Story | Priorité | Estim |
| :--- | :--- | :--- | :--- | :--- |
| **US-01** | Auth | En tant que Visiteur, je veux créer un compte afin de pouvoir accéder à l’application. | **Must** | M |
| **US-02** | Auth | En tant que Utilisateur, je veux me connecter afin de retrouver mes projets. | **Must** | M |
| **US-03** | Auth | En tant que Utilisateur, je veux me déconnecter afin de sécuriser ma session. | **Should** | S |
| **US-04** | Auth | En tant que Utilisateur, je veux modifier mon profil afin de mettre à jour mes informations. | **Should** | S |
| **US-05** | Projets | En tant que Utilisateur, je veux créer un projet afin de structurer mon travail. | **Must** | M |
| **US-06** | Projets | En tant que Utilisateur, je veux lister mes projets afin de voir tout ce que je gère. | **Must** | S |
| **US-07** | Projets | En tant que Utilisateur, je veux modifier un projet afin de corriger ses infos. | **Must** | S |
| **US-08** | Projets | En tant que Utilisateur, je veux supprimer un projet afin de nettoyer ma liste. | **Should** | S |
| **US-09** | Tâches | En tant que Utilisateur, je veux ajouter une tâche dans un projet afin de planifier les actions à faire. | **Must** | M |
| **US-10** | Tâches | En tant que Utilisateur, je veux changer le statut d’une tâche afin de suivre l’avancement. | **Must** | S |
| **US-11** | Tâches | En tant que Utilisateur, je veux modifier une tâche afin d'ajuster son contenu. | **Should** | S |
| **US-12** | Tâches | En tant que Utilisateur, je veux supprimer une tâche afin d'enlever les tâches inutiles. | **Should** | S |
| **US-13** | Filtres | En tant que Utilisateur, je veux filtrer les tâches par statut afin de me concentrer sur les urgences. | **Nice** | S |
| **US-14** | Filtres | En tant que Utilisateur, je veux rechercher une tâche par mot-clé afin de retrouver rapidement une information. | **Nice** | M |
| **US-15** | Admin | En tant qu'Admin, je veux lister tous les utilisateurs afin de surveiller la plateforme. | **Nice** | L |

## 5. Critères d'Acceptation (Exemples)

### US-01 - Inscription
- **Given** Je suis sur la page d'inscription.
- **When** Je saisis un email valide et un mot de passe conforme (8 caractères min).
- **Then** Mon compte est créé et je suis redirigé vers la page de connexion.
- **Given** Un compte existe déjà avec cet email.
- **When** Je tente de m'inscrire.
- **Then** Je reçois un message d'erreur et la création est refusée.

### US-05 - Créer projet
- **Given** Je suis connecté.
- **When** Je remplis le formulaire de création avec un nom valide.
- **Then** Le projet est enregistré dans la base de données.
- **And** Il apparaît immédiatement dans ma liste de projets.

### US-10 - Changer statut
- **Given** Je suis connecté et sur la vue d'une tâche.
- **When** Je sélectionne le statut "Terminé".
- **Then** La tâche est mise à jour visuellement.
- **And** Elle est déplacée dans la section correspondante.
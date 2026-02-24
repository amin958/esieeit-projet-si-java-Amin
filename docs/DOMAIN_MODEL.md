# Domain Model - Projet SI Java

## 1. Périmètre Métier (Acteurs & Cas d'usage)

### Acteurs
* **User :** Utilisateur authentifié de la plateforme. Il gère ses propres projets et tâches.
* **Admin :** Administrateur système. Il supervise l'ensemble des utilisateurs et peut intervenir en cas de problème.

### Cas d'usage principaux (MVP)
* **UC-01 :** En tant que Visiteur, je veux créer un compte pour accéder à l'application.
* **UC-02 :** En tant que User, je veux me connecter à mon espace.
* **UC-03 :** En tant que User, je veux créer un nouveau projet.
* **UC-04 :** En tant que User, je veux lister mes projets existants.
* **UC-05 :** En tant que User, je veux ajouter une tâche à un de mes projets.
* **UC-06 :** En tant que User, je veux changer le statut d'une tâche (ex: de TODO à IN_PROGRESS).
* **UC-07 :** En tant que User, je veux ajouter un commentaire sur une tâche pour donner du contexte.

---

## 2. Entités Métier et Attributs

### `User`
* `id` : Long (PK)
* `email` : String
* `username` : String
* `passwordHash` : String
* `role` : UserRole (Enum)
* `createdAt` : Instant

### `Project`
* `id` : Long (PK)
* `name` : String
* `description` : String
* `ownerId` : Long (FK vers User)
* `createdAt` : Instant
* `updatedAt` : Instant

### `Task`
* `id` : Long (PK)
* `title` : String
* `description` : String
* `status` : TaskStatus (Enum)
* `projectId` : Long (FK vers Project)
* `createdAt` : Instant
* `updatedAt` : Instant

### `Comment`
* `id` : Long (PK)
* `content` : String
* `taskId` : Long (FK vers Task)
* `authorId` : Long (FK vers User)
* `createdAt` : Instant

### Enums
* **`UserRole`** : USER, ADMIN
* **`TaskStatus`** : TODO, IN_PROGRESS, DONE, ARCHIVED

---

## 3. Relations et Cardinalités

* **User (1) -- (0..N) Project** : Un utilisateur possède zéro ou plusieurs projets. Un projet n'a qu'un seul propriétaire.
* **Project (1) -- (0..N) Task** : Un projet contient zéro ou plusieurs tâches. Une tâche appartient à un seul projet.
* **Task (1) -- (0..N) Comment** : Une tâche peut avoir zéro ou plusieurs commentaires. Un commentaire est lié à une seule tâche.
* **User (1) -- (0..N) Comment** : Un utilisateur peut écrire zéro ou plusieurs commentaires.

---

## 4. Règles Métier et Invariants

### Invariants de validation
* **User :** L'email doit être unique et avoir un format valide. Le username est obligatoire.
* **Project :** Le nom (`name`) est obligatoire (max 80 caractères). Un projet doit obligatoirement être lié à un `ownerId`.
* **Task :** Le titre (`title`) est obligatoire (max 120 caractères). Une tâche a par défaut le statut `TODO` à sa création.
* **Comment :** Le contenu (`content`) ne peut pas être vide.

### Workflow des statuts (TaskStatus)
* ✅ **Transitions autorisées :** TODO ➡️ IN_PROGRESS ➡️ DONE ➡️ ARCHIVED. TODO ➡️ ARCHIVED (Annulation directe).
* ❌ **Transitions interdites :** DONE ➡️ TODO (Une tâche terminée ne peut pas repartir à zéro, il faut en créer une nouvelle).

---

## 5. Diagramme de Classes

```mermaid
classDiagram
    class User {
        +Long id
        +String email
        +String username
        +String passwordHash
        +UserRole role
        +Instant createdAt
    }
    class Project {
        +Long id
        +String name
        +String description
        +Long ownerId
        +Instant createdAt
        +Instant updatedAt
    }
    class Task {
        +Long id
        +String title
        +String description
        +TaskStatus status
        +Long projectId
        +Instant createdAt
        +Instant updatedAt
    }
    class Comment {
        +Long id
        +String content
        +Long taskId
        +Long authorId
        +Instant createdAt
    }
    class TaskStatus {
        <<enumeration>>
        TODO
        IN_PROGRESS
        DONE
        ARCHIVED
    }
    class UserRole {
        <<enumeration>>
        USER
        ADMIN
    }

    User "1" -- "0..*" Project : owns
    Project "1" -- "0..*" Task : contains
    Task "1" -- "0..*" Comment : has
    User "1" -- "0..*" Comment : writes
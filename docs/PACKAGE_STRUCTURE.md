# Structure des Packages - Projet SI Java

## 1. Philosophie d'Architecture
Pour ce projet, nous adoptons une **Clean Architecture simplifiée**. L'objectif est d'isoler la logique métier (le cœur de l'application) des détails techniques (la base de données, l'API web). Cette séparation permet d'avoir un code plus maintenable et testable.

## 2. Arborescence Proposée

```text
com.esieeit.projetsi
├── domain/             # LE COEUR DU MÉTIER (Ne dépend d'aucun autre package)
│   ├── model/          # Les entités pures (User, Project, Task, Comment)
│   ├── enums/          # Les énumérations (TaskStatus, UserRole)
│   └── exception/      # Les erreurs spécifiques au métier (ex: TaskStatusException)
├── application/        # LES CAS D'USAGE
│   └── service/        # Orchestration (ex: ProjectService, TaskService)
├── api/                # LA COUCHE WEB
│   ├── controller/     # Les points d'entrée REST (ex: ProjectController)
│   └── dto/            # Les objets de transfert de données (Request/Response)
└── infrastructure/     # LA COUCHE TECHNIQUE
    ├── persistence/    # Base de données (Entités JPA, Repositories Spring Data)
    └── config/         # Configuration globale (Sécurité, Swagger, etc.)
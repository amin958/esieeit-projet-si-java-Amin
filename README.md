# Projet SI Java - Amin
Projet réalisé dans le cadre du cours de L2 à l'ESIEE-IT.

## Installation
`./gradlew test` pour lancer les tests.
# Projet SI - Gestion de Projets
## TP 4.1 - Base de données & JPA

### Configuration
- **Base de données** : MySQL 8.4 (Docker)
- **Port** : 3308
- **ORM** : Hibernate / JPA

### Lancement
1. Démarrer la base : `docker compose up -d`
2. Lancer l'API : `./gradlew bootRun`

### Choix techniques
- Utilisation de `ddl-auto: update` pour la génération automatique du schéma.
- Port décalé sur 3308 pour éviter les conflits locaux.
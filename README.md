# Gestion Scolaire — Application JavaFX

Application de gestion scolaire complète développée en Java avec JavaFX et Hibernate/JPA. Ce projet offre un système complet d'authentification, de gestion académique, de notes, de finances, de bibliothèque, de santé, de transport, de discipline et bien d'autres fonctionnalités pour les établissements scolaires.

L'application utilise une architecture multi-couches :
- **Interface graphique** : JavaFX (FXML)
- **Base de données** : MySQL/MariaDB (UTF8MB4)
- **ORM** : Hibernate JPA
- **Build** : Maven Java 17


Architecture du projet
-------------------------------------

## Structure des dossiers

```
src/main/
├── java/com/
│   ├── App.java                          # Point d'entrée JavaFX principal
│   ├── config/
│   │   ├── DbInitializer.java           # Initialisation de la base de données
│   │   ├── EnvLoader.java               # Chargement des variables d'environnement
│   │   └── JPAUtil.java                 # Utilitaire de configuration JPA
│   ├── controllers/
│   │   ├── DashController.java          # Tableau de bord administrateur
│   │   └── LoginController.java         # Écran de connexion
│   ├── dao/
│   │   └── GenericDAO.java              # DAO générique pour toutes les entités
│   ├── models/                          # Entités JPA (50+ classes)
│   │   └── [User.java, Etudiant.java, Enseignant.java, ...]
│   └── services/
│       ├── AppSession.java              # Gestion de la session utilisateur
│       ├── AuthService.java             # Service d'authentification
│       ├── BaseService.java             # Service de base
│       └── [CourseService, GradeService, ...]
└── resources/
    ├── com/
    │   ├── login.fxml                  # Écran de connexion
    │   ├── dash.fxml                   # Tableau de bord principal
    │   ├── dashEleve.fxml              # Tableau de bord étudiant
    │   ├── dashProf.fxml               # Tableau de bord professeur
    │   └── profil.fxml                 # Écran de profil
    └── META-INF/
        └── persistence.xml             # Configuration JPA
```
## Entités du modèle de données

Les entités principales de l'application :

**Authentification & Utilisateurs**
- `roles` : Rôles applicatifs (ADMIN, ENSEIGNANT, ETUDIANT, STAFF)
- `users` : Comptes d'authentification centralisés
- `user_profiles` : Informations personnelles détaillées
- `admins`, `enseignants`, `etudiants`, `staff_non_teaching` : Profils spécifiques par rôle

**Structures académiques**
- `academic_years` : Années académiques
- `terms` : Semestres/périodes
- `faculties`, `departments` : Organisation institutionnelle
- `programs` : Cursus/programmes d'études
- `classes` : Groupes/cohortes d'étudiants
- `courses`, `course_offerings` : Catalogue et offres de cours
- `enrollments` : Inscriptions aux cours

**Évaluation & Résultats**
- `assessment_types`, `assessments` : Types et évaluations planifiées
- `grades`, `grade_scales` : Notes et échelles de notation
- `transcripts` : Bulletins officiels

**Autres fonctionnalités**
- `attendance` : Présence aux cours
- `timetables` : Emplois du temps
- `fees`, `invoices`, `payments`, `scholarships` : Gestion financière
- `library_books`, `library_loans` : Bibliothèque
- `transport_buses`, `transport_routes` : Transport
- `health_records`, `medical_visits` : Santé
- `disciplinary_actions` : Discipline
- `events`, `notifications`, `messages` : Communication
- `files` : Gestion des fichiers
- `audit_logs` : Journalisation des actions
- `system_settings` : Configuration du système

Technologies & Dépendances
-------------------------------------

### Framework & Langues
- **Java 17** : Langage de programmation
- **Maven** : Gestion de projet et build
- **JavaFX 17.0.2** : Interface utilisateur graphique (GUI)

### Persistance & ORM
- **Hibernate ORM 6.x** : Implémentation JPA
- **Jakarta Persistence 3.1.0** : Spécification JPA
- **MySQL Connector/J** : Driver MySQL

### Utilitaires
- **Lombok 1.18.28** : Génération automatique de getters/setters
- **.env support** : Gestion des variables d'environnement

### Base de données
- **MySQL/MariaDB** avec charset UTF8MB4
- Configuration via variables d'environnement
Bonnes pratiques & Configuration
----------------------------

### Sécurité
- Les mots de passe sont hashés avec bcrypt/argon2 (voir `PasswordUtils.java`)
- Les transactions sont utilisées pour les opérations multi-tables
- L'authentification est centralisée dans `AuthService.java`

### Performance & Optimisation
- Indexer les colonnes fréquemment recherchées (email, role_id, student_number, course codes)
- Utiliser le `GenericDAO` pour éviter la duplication de code
- Les sessions utilisateur sont gérées via `AppSession.java`

### Déploiement & Sauvegarde
- Préparer un fichier `.env` à la racine du projet avec :
  ```
  DB_URL=jdbc:mysql://localhost:3306/gestion_scolaire?serverTimezone=UTC&useSSL=false
  DB_USER=root
  DB_PASSWORD=yourpassword
  ```
- Sauvegardes régulières de la base de données
- Valider les contraintes étrangères après import des données

Installation & Démarrage
-----------

### Prérequis
- Java 17 ou plus récent
- Maven 3.6+
- MySQL/MariaDB en fonctionnement

### Configuration

1. **Cloner le projet** :
   ```bash
   git clone <repository-url>
   cd Java-Project
   ```

2. **Créer un fichier `.env`** à la racine :
   ```
   DB_URL=jdbc:mysql://localhost:3306/gestion_scolaire?serverTimezone=UTC&useSSL=false
   DB_USER=root
   DB_PASSWORD=yourpassword
   ```

3. **Initialiser la base de données** :
   - Exécutez `data/database.sql` pour créer le schéma
   - Exécutez `data/sample_data.sql` pour charger les données d'exemple

### Build & Exécution

**Compiler le projet** :
```powershell
mvn -DskipTests clean package
```

**Exécuter l'application** :
- Sur Windows : Double-cliquez sur `run-app.bat`
- Ou via Maven : `mvn javafx:run`
- Ou manuellement :
  ```powershell
  mvn compile
  mvn exec:java -Dexec.mainClass="com.App"
  ```

### Fichiers compilés
Les fichiers compilés et ressources se trouvent dans `target/classes`. Ne modifiez pas directement ce dossier.

Fonctionnalités principales
-------------------------------------

### Authentification & Rôles
- Système de connexion sécurisé avec hachage de mot de passe
- Support de 4 rôles : ADMIN, ENSEIGNANT, ETUDIANT, STAFF
- Gestion des sessions utilisateur
- Profils d'utilisateurs détaillés

### Gestion Académique
- Gestion des années académiques et périodes
- Organisation par facultés et départements
- Gestion des programmes et cursus
- Création et gestion des classes
- Catalogue complet des cours
- Inscriptions des étudiants

### Évaluation & Notes
- Types d'évaluation multiples (contrôle continu, examen, projet, etc.)
- Enregistrement des notes par évaluation
- Calculs automatiques avec échelles de notation
- Génération de bulletins et transcripts

### Présence & Emploi du temps
- Enregistrement de la présence par cours
- Gestion des emplois du temps

### Gestion Financière
- Gestion des frais et libellés
- Système de facturation
- Enregistrement des paiements
- Gestion des bourses et aides

### Services Additionnels
- Bibliothèque : Catalogue et gestion des prêts
- Transport : Gestion des bus et itinéraires
- Santé : Dossiers médicaux et visites
- Discipline : Enregistrement des incidents
- Événements : Communication avec les utilisateurs
- Messagerie interne
- Audit : Journalisation des actions critiques

Contribution & Développement
---------

### Convention de codage
- Utiliser Java 17+ avec conventions de nommage camelCase
- Ajouter des annotations Lombok (@Getter, @Setter, @Data) sur les entités
- Documenter les services avec JavaDoc

### Ajouter une nouvelle fonctionnalité
1. Créer l'entité JPA dans `models/`
2. Implémenter un DAO spécialisé dans `dao/` ou utiliser `GenericDAO`
3. Créer un service dans `services/`
4. Créer le contrôleur JavaFX dans `controllers/`
5. Ajouter le fichier FXML dans `resources/com/`

### Support & Problèmes
Pour des problèmes de base de données, vérifiez :
- La configuration `.env`
- La connexion MySQL
- Les logs dans la console de l'application
- Merci de ne pas committer vos identifiants dans `.env`. Le fichier `.env` est ignoré par Git.

# Gestion Scolaire — Schéma de base de données

Ce dépôt contient un schéma SQL complet pour une solution de gestion scolaire (authentification, profils, académique, notes, finance, bibliothèque, santé, transport, discipline, logs, etc.). Le schéma est conçu pour MySQL/MariaDB (UTF8MB4) et suit une approche normalisée : la table `users` centralise l'authentification et les tables spécifiques (étudiants, enseignants, admins, staff) étendent les profils via PK = users.id.


Tables principales — description brève
-------------------------------------
- roles : liste des rôles applicatifs (ADMIN, ENSEIGNANT, ETUDIANT, ...).
- genders : méta pour genres (M/F/O).
- nationalities : nationalités de référence.
- users : comptes d'authentification (username, email, password, role_id, état).
- user_profiles : informations personnelles détaillées (nom, téléphone, adresse, urgence).
- admins : données spécifiques aux administrateurs (PK = users.id).
- enseignants : métadonnées des enseignants (employé, spécialité) (PK = users.id).
- etudiants : métadonnées des étudiants (numéro étudiant, admission, statut) (PK = users.id).
- staff_non_teaching : personnel non-enseignant (PK = users.id).

Structures académiques
- academic_years : années académiques (ex. 2024-2025).
- terms : semestres/périodes rattachées à une année.
- faculties : facultés / grandes divisions.
- departments : départements rattachés aux facultés.
- programs : cursus/programmes (Bachelor, Master, etc.).
- classes : cohortes ou groupes d'un programme pour une année.

Salles & infrastructure
- buildings : bâtiments du campus.
- rooms : salles, laboratoires, capacités.

Cours & enseignement
- courses : catalogue des cours (code, titre, crédits).
- course_offerings : offre d'un cours pour un terme (instructeur, salle, planning).
- enrollments : inscription d'un étudiant à une offre de cours.

Évaluation & résultats
- assessment_types : types d'évaluation (TD, examen, projet).
- assessments : évaluations planifiées (poids, date).
- grades : notes individuelles par évaluation.
- grade_scales : échelles de notation (lettres, points).
- transcripts : bulletins / relevés de notes officiels.

Présence & emploi du temps
- attendance : enregistrements de présence par date/cours.
- timetables : snapshots d'emplois du temps (JSON par propriétaire).

Finance
- fee_items : libellés de frais.
- invoices : factures émises aux étudiants.
- payments : paiements reçus.
- scholarships : informations sur bourses et aides.

Bibliothèque
- library_books : catalogue de livres.
- library_loans : prêts de livres par utilisateur.

Transport
- transport_buses : flotte d'autobus.
- transport_routes : itinéraires et arrêts (JSON).

Santé
- health_records : dossier médical minimal par utilisateur.
- medical_visits : visites médicales enregistrées.

Discipline & incidents
- disciplinary_actions : incidents disciplinaires et mesures.

Événements & communication
- events : événements du campus avec audience ciblée.
- notifications : notifications individuelles.
- messages : messagerie interne entre utilisateurs.

Fichiers & audit
- files : fichiers et pièces jointes stockés (références).
- audit_logs : journal d'audit des actions critiques.
- system_settings : paires clé/valeur de configuration.

Bonnes pratiques & remarques
----------------------------
- Les tables spécifiques aux rôles ont pour PK la même valeur que `users.id` afin d'éviter la duplication d'identité.
- Utiliser des transactions lors d'opérations multi-tables (inscriptions, paiements).
- Protéger les mots de passe : stocker uniquement des hashes sécurisés (bcrypt/argon2).
- Prévoir des sauvegardes régulières et valider les contraintes étrangères après import.
- Indexer les colonnes fréquemment recherchées (email, role_id, student_number, course codes).

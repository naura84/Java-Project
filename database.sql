-- Création de la base de données
CREATE DATABASE IF NOT EXISTS gestion_scolaire;
USE gestion_scolaire;

-- Table des utilisateurs (connexion)
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('ADMIN', 'ENSEIGNANT', 'ETUDIANT') NOT NULL,
    actif BOOLEAN DEFAULT TRUE,
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_login TIMESTAMP NULL,
    INDEX idx_role (role)
);

-- Table des classes
CREATE TABLE classes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(50) NOT NULL UNIQUE,
    niveau VARCHAR(20) NOT NULL,
    annee_scolaire VARCHAR(10) NOT NULL,
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table des admins (clé primaire = clé étrangère)
CREATE TABLE admins (
    id INT PRIMARY KEY,
    fonction VARCHAR(100),
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE
);

-- Table des étudiants (clé primaire = clé étrangère)
CREATE TABLE etudiants (
    id INT PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    date_naissance DATE NOT NULL,
    numero_etudiant VARCHAR(20) UNIQUE NOT NULL,
    classe_id INT NOT NULL,
    adresse VARCHAR(255),
    telephone VARCHAR(20),
    email_professionnel VARCHAR(100),
    email_personnel VARCHAR(100),
    statut ENUM('ACTIF', 'SUSPENDU', 'DIPLOME') DEFAULT 'ACTIF',
    date_inscription TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (classe_id) REFERENCES classes(id) ON DELETE RESTRICT,
    INDEX idx_classe (classe_id),
    INDEX idx_numero (numero_etudiant)
);

-- Table des enseignants (clé primaire = clé étrangère)
CREATE TABLE enseignants (
    id INT PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    specialite VARCHAR(100) NOT NULL,
    email_professionnel VARCHAR(100),
    email_personnel VARCHAR(100),
    date_embauche DATE NOT NULL,
    telephone VARCHAR(20),
    statut ENUM('ACTIF', 'CONGE', 'INACTIF') DEFAULT 'ACTIF',
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE
);

-- Table des cours
CREATE TABLE cours (
    id INT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(20) UNIQUE NOT NULL,
    nom VARCHAR(100) NOT NULL,
    description TEXT,
    enseignant_id INT NOT NULL,
    classe_id INT NOT NULL,
    coefficient INT DEFAULT 1,
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (enseignant_id) REFERENCES enseignants(id) ON DELETE RESTRICT,
    FOREIGN KEY (classe_id) REFERENCES classes(id) ON DELETE CASCADE,
    INDEX idx_enseignant (enseignant_id),
    INDEX idx_classe (classe_id)
);

-- Table des notes
CREATE TABLE notes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    etudiant_id INT NOT NULL,
    cours_id INT NOT NULL,
    note_devoir DECIMAL(5,2),
    note_controle DECIMAL(5,2),
    note_examen DECIMAL(5,2),
    note_finale DECIMAL(5,2),
    appreciation VARCHAR(50),
    date_notation TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (etudiant_id) REFERENCES etudiants(id) ON DELETE CASCADE,
    FOREIGN KEY (cours_id) REFERENCES cours(id) ON DELETE CASCADE,
    UNIQUE KEY unique_etudiant_cours (etudiant_id, cours_id),
    INDEX idx_etudiant (etudiant_id),
    INDEX idx_cours (cours_id)
);

-- Table des résultats/bulletins
CREATE TABLE bulletins (
    id INT PRIMARY KEY AUTO_INCREMENT,
    etudiant_id INT NOT NULL,
    periode VARCHAR(20) NOT NULL,
    moyenne_generale DECIMAL(5,2),
    rang INT,
    mention VARCHAR(50),
    date_generation TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (etudiant_id) REFERENCES etudiants(id) ON DELETE CASCADE,
    UNIQUE KEY unique_etudiant_periode (etudiant_id, periode),
    INDEX idx_etudiant (etudiant_id)
);

-- Insertion de données de test
INSERT INTO users (id, username, email, password, role) VALUES
(1, 'admin1', 'admin@school.com', 'hashed_password_123', 'ADMIN'),
(2, 'prof_dupont', 'dupont@school.com', 'hashed_password_456', 'ENSEIGNANT'),
(3, 'prof_martin', 'martin@school.com', 'hashed_password_789', 'ENSEIGNANT'),
(4, 'jean_etudiant', 'jean@student.com', 'hashed_password_101', 'ETUDIANT'),
(5, 'marie_etudiant', 'marie@student.com', 'hashed_password_102', 'ETUDIANT');

INSERT INTO classes (nom, niveau, annee_scolaire) VALUES
('1A', '1ère année', '2024-2025'),
('1B', '1ère année', '2024-2025'),
('2A', '2ème année', '2024-2025');

INSERT INTO admins (id, fonction) VALUES
(1, 'Directeur');

INSERT INTO enseignants (id, specialite, date_embauche) VALUES
(2, 'Mathématiques', '2020-09-01'),
(3, 'Français', '2021-09-01');

INSERT INTO etudiants (id, date_naissance, numero_etudiant, classe_id) VALUES
(4, '2005-03-15', 'ETU001', 1),
(5, '2005-07-22', 'ETU002', 1);

INSERT INTO cours (code, nom, enseignant_id, classe_id) VALUES
('MATH101', 'Algèbre', 2, 1),
('FRAN101', 'Littérature', 3, 1),
('MATH102', 'Géométrie', 2, 1);

-- Création de la base de données et schéma complet pour gestion scolaire "tête au pied"

CREATE DATABASE IF NOT EXISTS gestion_scolaire DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE gestion_scolaire;

-- Tables de référence
CREATE TABLE roles (
    id INT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(50) NOT NULL UNIQUE,
    label VARCHAR(100) NOT NULL,
    description TEXT
) ENGINE=InnoDB;

CREATE TABLE genders (
    id TINYINT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(10) UNIQUE,
    label VARCHAR(20)
) ENGINE=InnoDB;

CREATE TABLE nationalities (
    id SMALLINT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(10) UNIQUE,
    name VARCHAR(100)
) ENGINE=InnoDB;

-- Authentification des utilisateurs
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role_id INT NOT NULL,
    active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_login TIMESTAMP NULL,
    password_reset_token VARCHAR(255),
    password_reset_expires DATETIME,
    INDEX idx_role (role_id),
    FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE RESTRICT
) ENGINE=InnoDB;

-- Profils des utilisateurs
CREATE TABLE user_profiles (
    user_id INT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    middle_name VARCHAR(100),
    preferred_name VARCHAR(100),
    gender_id TINYINT,
    nationality_id SMALLINT,
    birth_date DATE,
    place_of_birth VARCHAR(255),
    photo_path VARCHAR(255),
    address_full VARCHAR(512),
    city VARCHAR(100),
    postal_code VARCHAR(20),
    country VARCHAR(100),
    phone_mobile VARCHAR(30),
    phone_home VARCHAR(30),
    emergency_contact_name VARCHAR(150),
    emergency_contact_relation VARCHAR(50),
    emergency_contact_phone VARCHAR(30),
    timezone VARCHAR(50),
    language_pref VARCHAR(10),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (gender_id) REFERENCES genders(id),
    FOREIGN KEY (nationality_id) REFERENCES nationalities(id)
) ENGINE=InnoDB;

-- Tables spécifiques aux rôles
CREATE TABLE admins (
    id INT PRIMARY KEY,
    title VARCHAR(100),
    office_location VARCHAR(100),
    permissions JSON NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE enseignants (
    id INT PRIMARY KEY,
    employee_number VARCHAR(50) UNIQUE,
    department_id INT,
    hire_date DATE,
    job_title VARCHAR(100),
    specialization VARCHAR(200),
    work_email VARCHAR(150),
    work_phone VARCHAR(30),
    status ENUM('ACTIF','CONGE','INACTIF') DEFAULT 'ACTIF',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE etudiants (
    id INT PRIMARY KEY,
    student_number VARCHAR(50) UNIQUE NOT NULL,
    admission_date DATE,
    program_id INT,
    current_level VARCHAR(50),
    year_admitted YEAR,
    status ENUM('ACTIF','SUSPENDU','DIPLOME','RETIRE') DEFAULT 'ACTIF',
    scholarship_id INT NULL,
    accommodation_details TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE staff_non_teaching (
    id INT PRIMARY KEY,
    employee_number VARCHAR(50) UNIQUE,
    department_id INT,
    hire_date DATE,
    role_title VARCHAR(100),
    work_email VARCHAR(150),
    work_phone VARCHAR(30),
    status ENUM('ACTIF','CONGE','INACTIF') DEFAULT 'ACTIF',
    FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- Structures académiques
CREATE TABLE academic_years (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) UNIQUE NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    active BOOLEAN DEFAULT FALSE
) ENGINE=InnoDB;

CREATE TABLE terms (
    id INT PRIMARY KEY AUTO_INCREMENT,
    academic_year_id INT NOT NULL,
    name VARCHAR(50),
    start_date DATE,
    end_date DATE,
    FOREIGN KEY (academic_year_id) REFERENCES academic_years(id) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE faculties (
    id INT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(20) UNIQUE,
    name VARCHAR(150),
    description TEXT
) ENGINE=InnoDB;

CREATE TABLE departments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    faculty_id INT,
    code VARCHAR(20) UNIQUE,
    name VARCHAR(150),
    head_id INT NULL, -- references enseignants.id
    FOREIGN KEY (faculty_id) REFERENCES faculties(id),
    FOREIGN KEY (head_id) REFERENCES enseignants(id) ON DELETE SET NULL
) ENGINE=InnoDB;

CREATE TABLE programs (
    id INT PRIMARY KEY AUTO_INCREMENT,
    department_id INT,
    code VARCHAR(50) UNIQUE,
    name VARCHAR(200),
    level ENUM('Bachelor','Master','PhD','Diploma','Certificate','Other'),
    duration_semesters INT,
    description TEXT,
    FOREIGN KEY (department_id) REFERENCES departments(id) ON DELETE SET NULL
) ENGINE=InnoDB;

CREATE TABLE classes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    program_id INT,
    academic_year_id INT,
    name VARCHAR(100),
    section VARCHAR(50),
    capacity INT DEFAULT 0,
    homeroom_teacher_id INT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (program_id) REFERENCES programs(id) ON DELETE SET NULL,
    FOREIGN KEY (academic_year_id) REFERENCES academic_years(id) ON DELETE SET NULL,
    FOREIGN KEY (homeroom_teacher_id) REFERENCES enseignants(id) ON DELETE SET NULL
) ENGINE=InnoDB;

-- Lieux et emplois du temps
CREATE TABLE buildings (
    id INT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(50) UNIQUE,
    name VARCHAR(150),
    address VARCHAR(255),
    description TEXT
) ENGINE=InnoDB;

CREATE TABLE rooms (
    id INT PRIMARY KEY AUTO_INCREMENT,
    building_id INT,
    code VARCHAR(50),
    name VARCHAR(100),
    capacity INT,
    type ENUM('CLASSROOM','LAB','AUDITORIUM','OFFICE','LIBRARY','OTHER') DEFAULT 'CLASSROOM',
    FOREIGN KEY (building_id) REFERENCES buildings(id) ON DELETE SET NULL
) ENGINE=InnoDB;

-- Cours et offres de cours
CREATE TABLE courses (
    id INT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(50) UNIQUE NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    credits DECIMAL(4,2) DEFAULT 3.00,
    coefficient INT DEFAULT 1,
    department_id INT,
    level VARCHAR(50),
    elective BOOLEAN DEFAULT FALSE,
    prerequisites TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (department_id) REFERENCES departments(id) ON DELETE SET NULL
) ENGINE=InnoDB;

CREATE TABLE course_offerings (
    id INT PRIMARY KEY AUTO_INCREMENT,
    course_id INT NOT NULL,
    term_id INT NOT NULL,
    instructor_id INT,
    class_id INT, -- which class/cohort attends
    room_id INT,
    schedule JSON, -- e.g. [{"day":"Mon","start":"08:00","end":"09:30"}]
    max_capacity INT,
    enrolled_count INT DEFAULT 0,
    status ENUM('SCHEDULED','ONGOING','COMPLETED','CANCELLED') DEFAULT 'SCHEDULED',
    FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE,
    FOREIGN KEY (term_id) REFERENCES terms(id) ON DELETE CASCADE,
    FOREIGN KEY (instructor_id) REFERENCES enseignants(id) ON DELETE SET NULL,
    FOREIGN KEY (class_id) REFERENCES classes(id) ON DELETE SET NULL,
    FOREIGN KEY (room_id) REFERENCES rooms(id) ON DELETE SET NULL
) ENGINE=InnoDB;

-- Inscription et dossiers académiques
CREATE TABLE enrollments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    course_offering_id INT NOT NULL,
    enrolled_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('ENROLLED','WITHDRAWN','COMPLETED','FAILED','AUDIT') DEFAULT 'ENROLLED',
    final_grade DECIMAL(5,2) NULL,
    grade_point DECIMAL(4,2) NULL,
    UNIQUE KEY uq_student_offering (student_id, course_offering_id),
    FOREIGN KEY (student_id) REFERENCES etudiants(id) ON DELETE CASCADE,
    FOREIGN KEY (course_offering_id) REFERENCES course_offerings(id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- Évaluations et notes
CREATE TABLE assessment_types (
    id INT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(50) UNIQUE,
    label VARCHAR(100),
    description TEXT
) ENGINE=InnoDB;

CREATE TABLE assessments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    course_offering_id INT NOT NULL,
    type_id INT NULL,            -- rendu NULLABLE pour permettre ON DELETE SET NULL
    title VARCHAR(200),
    description TEXT,
    weight DECIMAL(5,2) DEFAULT 0, -- percentage of final grade
    date TIMESTAMP NULL,
    max_score DECIMAL(8,2) DEFAULT 100,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (course_offering_id) REFERENCES course_offerings(id) ON DELETE CASCADE,
    FOREIGN KEY (type_id) REFERENCES assessment_types(id) ON DELETE SET NULL
) ENGINE=InnoDB;

CREATE TABLE grades (
    id INT PRIMARY KEY AUTO_INCREMENT,
    assessment_id INT NOT NULL,
    student_id INT NOT NULL,
    score DECIMAL(8,2),
    remarks TEXT,
    graded_by INT, -- users.id
    graded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE KEY uq_assessment_student (assessment_id, student_id),
    FOREIGN KEY (assessment_id) REFERENCES assessments(id) ON DELETE CASCADE,
    FOREIGN KEY (student_id) REFERENCES etudiants(id) ON DELETE CASCADE,
    FOREIGN KEY (graded_by) REFERENCES users(id) ON DELETE SET NULL
) ENGINE=InnoDB;

CREATE TABLE grade_scales (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    min_score DECIMAL(5,2),
    max_score DECIMAL(5,2),
    grade_label VARCHAR(10),
    grade_point DECIMAL(3,2)
) ENGINE=InnoDB;

CREATE TABLE transcripts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    academic_year_id INT NOT NULL,
    term_id INT NULL,
    gpa DECIMAL(4,2),
    remarks TEXT,
    generated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES etudiants(id) ON DELETE CASCADE,
    FOREIGN KEY (academic_year_id) REFERENCES academic_years(id) ON DELETE CASCADE,
    FOREIGN KEY (term_id) REFERENCES terms(id) ON DELETE SET NULL
) ENGINE=InnoDB;

-- Présences
CREATE TABLE attendance (
    id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    course_offering_id INT NOT NULL,
    date DATE NOT NULL,
    status ENUM('PRESENT','ABSENT','LATE','EXCUSED') DEFAULT 'PRESENT',
    recorded_by INT,
    recorded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    notes TEXT,
    FOREIGN KEY (student_id) REFERENCES etudiants(id) ON DELETE CASCADE,
    FOREIGN KEY (course_offering_id) REFERENCES course_offerings(id) ON DELETE CASCADE,
    FOREIGN KEY (recorded_by) REFERENCES users(id) ON DELETE SET NULL,
    UNIQUE KEY uq_attendance (student_id, course_offering_id, date)
) ENGINE=InnoDB;

-- Emplois du temps (pour UI/export)
CREATE TABLE timetables (
    id INT PRIMARY KEY AUTO_INCREMENT,
    owner_type ENUM('CLASS','TEACHER','ROOM','STUDENT') NOT NULL,
    owner_id INT NOT NULL,
    term_id INT NOT NULL,
    schedule JSON,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (term_id) REFERENCES terms(id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- Finance : frais, factures, paiements, bourses
CREATE TABLE fee_items (
    id INT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(50) UNIQUE,
    description VARCHAR(255),
    amount DECIMAL(10,2),
    recurring BOOLEAN DEFAULT FALSE
) ENGINE=InnoDB;

CREATE TABLE invoices (
    id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    invoice_number VARCHAR(100) UNIQUE,
    issue_date DATE,
    due_date DATE,
    total_amount DECIMAL(10,2),
    status ENUM('UNPAID','PARTIAL','PAID','CANCELLED') DEFAULT 'UNPAID',
    details JSON,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES etudiants(id) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE payments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    invoice_id INT,
    student_id INT,
    amount DECIMAL(10,2),
    method ENUM('CASH','CARD','BANK_TRANSFER','CHEQUE','OTHER'),
    paid_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    reference VARCHAR(255),
    processed_by INT,
    FOREIGN KEY (invoice_id) REFERENCES invoices(id) ON DELETE SET NULL,
    FOREIGN KEY (student_id) REFERENCES etudiants(id) ON DELETE SET NULL,
    FOREIGN KEY (processed_by) REFERENCES users(id) ON DELETE SET NULL
) ENGINE=InnoDB;

CREATE TABLE scholarships (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200),
    description TEXT,
    amount DECIMAL(10,2),
    criteria JSON
) ENGINE=InnoDB;

-- Bibliothèque
CREATE TABLE library_books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    isbn VARCHAR(50),
    title VARCHAR(255),
    authors VARCHAR(255),
    publisher VARCHAR(255),
    year_publication YEAR,
    copies_total INT DEFAULT 1,
    copies_available INT DEFAULT 1,
    location VARCHAR(255),
    subjects TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

CREATE TABLE library_loans (
    id INT PRIMARY KEY AUTO_INCREMENT,
    book_id INT NOT NULL,
    user_id INT NOT NULL,
    loaned_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    due_date DATE,
    returned_at TIMESTAMP NULL,
    fine_amount DECIMAL(8,2) DEFAULT 0,
    status ENUM('LOANED','RETURNED','OVERDUE','LOST') DEFAULT 'LOANED',
    FOREIGN KEY (book_id) REFERENCES library_books(id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- Transport
CREATE TABLE transport_buses (
    id INT PRIMARY KEY AUTO_INCREMENT,
    plate_number VARCHAR(50) UNIQUE,
    driver_name VARCHAR(150),
    capacity INT,
    route_description TEXT
) ENGINE=InnoDB;

CREATE TABLE transport_routes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(150),
    stops JSON, -- array of stops with coords
    active BOOLEAN DEFAULT TRUE
) ENGINE=InnoDB;

-- Santé et dossiers médicaux
CREATE TABLE health_records (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    blood_type VARCHAR(5),
    allergies TEXT,
    chronic_conditions TEXT,
    medications TEXT,
    emergency_instructions TEXT,
    last_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE medical_visits (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    visit_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    reason TEXT,
    diagnosis TEXT,
    treatment TEXT,
    referred BOOLEAN DEFAULT FALSE,
    notes TEXT,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- Discipline et incidents
CREATE TABLE disciplinary_actions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    reported_by INT,
    incident_date DATE,
    category VARCHAR(100),
    description TEXT,
    action_taken TEXT,
    status ENUM('OPEN','RESOLVED','APPEALED') DEFAULT 'OPEN',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES etudiants(id) ON DELETE CASCADE,
    FOREIGN KEY (reported_by) REFERENCES users(id) ON DELETE SET NULL
) ENGINE=InnoDB;

-- Événements, notifications et messagerie
CREATE TABLE events (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    description TEXT,
    start_datetime DATETIME,
    end_datetime DATETIME,
    location VARCHAR(255),
    audience JSON, -- e.g. {"roles":["ETUDIANT","ENSEIGNANT"], "classes":[1,2]}
    created_by INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (created_by) REFERENCES users(id) ON DELETE SET NULL
) ENGINE=InnoDB;

CREATE TABLE notifications (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    title VARCHAR(255),
    message TEXT,
    link VARCHAR(500),
    read BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE messages (
    id INT PRIMARY KEY AUTO_INCREMENT,
    sender_id INT,
    receiver_id INT,
    subject VARCHAR(255),
    body TEXT,
    sent_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    read_at TIMESTAMP NULL,
    attachments JSON,
    FOREIGN KEY (sender_id) REFERENCES users(id) ON DELETE SET NULL,
    FOREIGN KEY (receiver_id) REFERENCES users(id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- Fichiers et pièces jointes
CREATE TABLE files (
    id INT PRIMARY KEY AUTO_INCREMENT,
    owner_type VARCHAR(50),
    owner_id INT,
    filename VARCHAR(255),
    filepath VARCHAR(500),
    mime_type VARCHAR(100),
    size_bytes BIGINT,
    uploaded_by INT,
    uploaded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (uploaded_by) REFERENCES users(id) ON DELETE SET NULL
) ENGINE=InnoDB;

-- Audit et journaux
CREATE TABLE audit_logs (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NULL,
    action VARCHAR(100),
    entity VARCHAR(100),
    entity_id VARCHAR(100),
    description TEXT,
    ip_address VARCHAR(50),
    user_agent VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE SET NULL
) ENGINE=InnoDB;

-- Paramètres du système
CREATE TABLE system_settings (
    `key` VARCHAR(150) PRIMARY KEY,
    `value` TEXT,
    description TEXT,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- Index et contraintes supplémentaires
ALTER TABLE users ADD INDEX idx_users_email (email);

-- Données d'exemple minimales
INSERT IGNORE INTO roles (id, code, label) VALUES
(1,'ADMIN','Administrateur'),
(2,'ENSEIGNANT','Enseignant'),
(3,'ETUDIANT','Etudiant'),
(4,'STAFF','Personnel');

INSERT IGNORE INTO genders (id, code, label) VALUES
(1,'M','Masculin'),
(2,'F','Feminin'),
(3,'O','Autre');

INSERT IGNORE INTO nationalities (name) VALUES ('Française'),('Marocaine'),('Sénégalaise'),('Autre');

INSERT IGNORE INTO users (id, username, email, password, role_id, active) VALUES
(1,'admin1','admin@school.com','hashed_pwd_admin',1,TRUE),
(2,'dupont.p','dupont@school.com','hashed_pwd_dupont',2,TRUE),
(3,'martin.s','martin@school.com','hashed_pwd_martin',2,TRUE),
(4,'jean.d','jean@student.com','hashed_pwd_jean',3,TRUE),
(5,'marie.l','marie@student.com','hashed_pwd_marie',3,TRUE);

INSERT IGNORE INTO user_profiles (user_id, first_name, last_name, gender_id, birth_date, phone_mobile) VALUES
(1,'Admin','One',1,'1980-01-01','+33123456789'),
(2,'Pierre','Dupont',1,'1985-05-12','+33123450001'),
(3,'Sophie','Martin',2,'1990-07-22','+33123450002'),
(4,'Jean','Dupuis',1,'2005-03-15','+33600123456'),
(5,'Marie','Leclerc',2,'2005-07-22','+33600123457');

INSERT IGNORE INTO admins (id, title) VALUES (1,'Directeur');

INSERT IGNORE INTO enseignants (id, employee_number, department_id, hire_date, job_title, specialization) VALUES
(2,'EMP2020-001',NULL,'2020-09-01','Professeur','Mathématiques'),
(3,'EMP2021-002',NULL,'2021-09-01','Professeur','Français');

INSERT IGNORE INTO etudiants (id, student_number, admission_date, program_id, year_admitted) VALUES
(4,'ETU001','2021-09-01',NULL,2021),
(5,'ETU002','2021-09-01',NULL,2021);

INSERT IGNORE INTO academic_years (id, name, start_date, end_date, active) VALUES
(1,'2024-2025','2024-09-01','2025-06-30',TRUE);

INSERT IGNORE INTO terms (academic_year_id, name, start_date, end_date) VALUES
(1,'Semestre 1','2024-09-01','2025-01-15'),
(1,'Semestre 2','2025-01-16','2025-06-30');

INSERT IGNORE INTO departments (id, name) VALUES (1,'Département de Mathématiques');
INSERT IGNORE INTO courses (id, code, title, credits, department_id) VALUES (1,'MATH101','Algèbre',3.0,1);
INSERT IGNORE INTO course_offerings (id, course_id, term_id, instructor_id, class_id, max_capacity, status) VALUES (1,1,1,2, NULL, 100, 'SCHEDULED');

-- Fin du script

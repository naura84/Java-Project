USE gestion_scolaire;

-- Sample data for quick import (sensible random values)

-- Roles
INSERT INTO roles (id, code, label, description) VALUES
(1, 'ADMIN', 'Administrator', 'Full access'),
(2, 'PROF', 'Professor', 'Academic staff'),
(3, 'STUDENT', 'Student', 'Enrolled students');

-- Genders
INSERT INTO genders (id, code, label) VALUES
(1, 'M', 'Male'),
(2, 'F', 'Female');

-- Nationalities (now free text)
INSERT INTO nationalities (id, name) VALUES
(1, 'France'),
(2, 'United States'),
(3, 'Germany'),
(4, 'Spain'),
(5, 'Italy'),
(6, 'Belgium'),
(7, 'Netherlands'),
(8, 'China'),
(9, 'India'),
(10, 'Morocco');

-- Academic years and terms
INSERT INTO academic_years (id, name, start_date, end_date, active) VALUES
(1, '2025/2026', '2025-09-01', '2026-06-30', TRUE);

INSERT INTO terms (id, academic_year_id, name, start_date, end_date) VALUES
(1, 1, 'Term 1', '2025-09-01', '2025-12-20'),
(2, 1, 'Term 2', '2026-01-10', '2026-04-30');

-- Buildings and rooms
INSERT INTO buildings (id, code, name, address, description) VALUES
(1, 'BLD1', 'Eiffel Building', '20 Rue de la Paix, Paris', 'Main academic building');

INSERT INTO rooms (id, building_id, code, name, capacity, type) VALUES
(1, 1, 'EM102', 'Eiffel 1 - EM102', 60, 'CLASSROOM'),
(2, 1, 'EM212', 'Eiffel 2 - EM212', 80, 'CLASSROOM');

-- Programs and classes
INSERT INTO programs (id, department_id, code, name, level, duration_semesters, description) VALUES
(1, NULL, 'CS-BACH', 'Computer Science', 'Bachelor', 6, 'BSc in Computer Science');

INSERT INTO classes (id, program_id, academic_year_id, name, section, capacity, homeroom_teacher_id, created_at) VALUES
(1, 1, 1, 'B2 Group 4', 'A', 30, NULL, NOW()),
(2, 1, 1, 'M1 Groupe Cybersecurity', 'A', 25, NULL, NOW());

-- Users and profiles (IDs chosen to match professeur/etudiant ids)
INSERT INTO users (id, username, email, password, role_id, active, created_at) VALUES
(1, 'admin', 'admin@example.com', 'f3aTPZ2i2BvUAe7kyagIgA==:355b220d470d159dd3ee7c3eb22ac22c6c65579bbd1382501ab124bffbb3248d', 1, TRUE, NOW()),
(2, 'tatiana.dubois', 'tatiana.dubois@example.com', '+pMLYGaxApaHYDUeVcmHig==:0c18c912e744b9691ab360822f53ecab5177b4ea30241d2e24ab4fff8dfe6fdc', 2, TRUE, NOW()),
(3, 'linda.adora', 'linda.adora@student.example.com', 'vvXkwxURl6m9RPWgRo8n8g==:390aa35d4157504a11a26efe49b02fb4d63f53c56e3ad42db7fe95451b44490c', 3, TRUE, NOW());

INSERT INTO user_profiles (user_id, first_name, last_name, preferred_name, gender_id, nationality_id, birth_date, city, phone_mobile) VALUES
(1, 'Admin', 'Root', 'Admin', 2, 1, '1985-01-01', 'Paris', '+33100000001'),
(2, 'Tatiana', 'Dubois', 'Tatiana', 2, 1, '1980-03-12', 'Paris', '+33100000002'),
(3, 'Linda', 'Adora', 'Linda', 2, 2, '2002-07-17', 'Lyon', '+33100000003');

-- Teachers and students (use same id as users)
INSERT INTO enseignants (id, employee_number, department_id, hire_date, job_title, specialization, work_email, work_phone, status, created_at) VALUES
(2, 'EMP-1002', NULL, '2010-09-01', 'Senior Lecturer', 'Object Oriented Programming', 'tatiana.dubois@example.com', '+33100000002', 'ACTIF', NOW());

INSERT INTO etudiants (id, student_number, admission_date, program_id, current_level, year_admitted, status, created_at) VALUES
(3, 'STU-3003', '2023-09-01', 1, 'B2', 2023, 'ACTIF', NOW());

-- Courses
INSERT INTO courses (id, code, title, description, credits, coefficient, department_id, level, elective, created_at) VALUES
(1, 'CS101', 'POO Java', 'Programmation orientée objet en Java', 3.00, 1, NULL, 'B2', FALSE, NOW()),
(2, 'CS201', 'Mathématiques avancées', 'Algèbre et analyse', 4.00, 1, NULL, 'B2', FALSE, NOW()),
(3, 'CS301', 'Security Basics', 'Introduction to cybersecurity', 3.00, 1, NULL, 'M1', FALSE, NOW());

-- Course offerings (schedule stored as JSON string for simplicity)
INSERT INTO course_offerings (id, course_id, term_id, instructor_id, class_id, room_id, schedule, max_capacity, enrolled_count, status) VALUES
(1, 1, 1, 2, 1, 1, '[{"day":"Tue","start":"13:00","end":"15:30"}]', 60, 25, 'SCHEDULED'),
(2, 2, 1, 2, 2, 2, '[{"day":"Mon","start":"08:30","end":"10:30"}]', 50, 20, 'SCHEDULED'),
(3, 3, 2, 2, 2, 2, '[{"day":"Thu","start":"13:00","end":"15:00"}]', 40, 10, 'SCHEDULED');

-- Enrollments
INSERT INTO enrollments (id, student_id, course_offering_id, enrolled_on, status) VALUES
(1, 3, 1, NOW(), 'ENROLLED'),
(2, 3, 2, NOW(), 'ENROLLED');

-- Events
INSERT INTO events (id, title, description, start_datetime, end_datetime, location, audience, created_by, created_at) VALUES
(1, 'Visite du campus', 'Nous vous invitons à la visite du campus de Paris. L\'Amphithéâtre vous attend pour prolonger les échanges.', '2025-12-15 10:00:00', '2025-12-15 12:00:00', 'Amphithéâtre', '{"roles":["STUDENT","PROF"]}', 1, NOW()),
(2, 'Séminaire Sécurité', 'Séminaire sur les bonnes pratiques en cybersécurité.', '2026-01-20 14:00:00', '2026-01-20 16:00:00', 'Salle EM212', '{"roles":["PROF","STUDENT"]}', 2, NOW());

-- Notifications
INSERT INTO notifications (id, user_id, title, message, link, is_read, created_at) VALUES
(1, 3, 'Rappel: Projet', 'N\'oubliez pas de rendre votre projet avant le 20/12.', NULL, 0, NOW()),
(2, 2, 'Réunion departement', 'Réunion départementale le 18/12 à 09:00 en salle EM212.', NULL, 0, NOW());

-- Simple messages table sample
INSERT INTO messages (id, sender_id, receiver_id, subject, body, sent_at) VALUES
(1, 2, 3, 'Bienvenue', 'Bienvenue dans le cours POO Java. Le premier cours aura lieu mardi.', NOW());

-- Timetable example (for student and teacher)
INSERT INTO timetables (id, owner_type, owner_id, term_id, schedule, updated_at) VALUES
(1, 'STUDENT', 3, 1, '[{"day":"Tue","start":"13:00","end":"15:30","course_offering_id":1}]', NOW()),
(2, 'TEACHER', 2, 1, '[{"day":"Tue","start":"13:00","end":"15:30","course_offering_id":1},{"day":"Mon","start":"08:30","end":"10:30","course_offering_id":2}]', NOW());


-- More users (teachers and students)
INSERT INTO users (id, username, email, password, role_id, active, created_at) VALUES
(4, 'christina.leroy', 'christina.leroy@example.com', 'K0AlY5EO8FVLURhnpuFdeg==:f013ad83616fdf429d25d5b430f362aa217968e80ea5319211d96c17ac422c38', 2, TRUE, NOW()),
(5, 'paul.martin', 'paul.martin@example.com', 'HEcMrxP5fwuA5aVT0XFNnQ==:982b3b53920e3d50e1d8815a066083986f154326430b41075627c5955d6879a5', 2, TRUE, NOW()),
(6, 'sara.nguyen', 'sara.nguyen@student.example.com', 'Ckp6IViRo7/kE8S236Io8A==:faff9c8cdf52f1388466202206dc7b7e1f432ce22f6180e231cef65f0363bee3', 3, TRUE, NOW()),
(7, 'youssef.ben', 'youssef.ben@student.example.com', 'iPLCLuoKxcGcLXXUGkm+gw==:bfc2040d927c7b8e56986c1e22156a5e49e56f7ccd4704f58e60ee7207d7a932', 3, TRUE, NOW()),
(8, 'michael.ross', 'michael.ross@example.com', 'AMshJDUtF6b+R9gDvLHlQA==:baa990e9141e0e1764eaecdbddd65a8805699f71f155e5a41d130d4b521b7b75', 2, TRUE, NOW()),
(9, 'amelie.rousseau', 'amelie.rousseau@student.example.com', 'joCA9J5fjJzyQV/ZgyAtiA==:cbb46b6bbd4c2c06fdf412aea691e77f9dc7409f637f63cd24b3687ce4c7e4a2', 3, TRUE, NOW()),
(10, 'jon.doe', 'jon.doe@student.example.com', '6Bl4nTLjPiUEiBqXjrb7RQ==:fdefc6eb107a74a91c60ee9543ad5b3d3097faf268e98f5d3834e7e881838b11', 3, TRUE, NOW());

INSERT INTO user_profiles (user_id, first_name, last_name, preferred_name, gender_id, nationality_id, birth_date, city, phone_mobile) VALUES
(4, 'Christina', 'Leroy', 'Christina', 2, 1, '1978-11-05', 'Paris', '+33100000004'),
(5, 'Paul', 'Martin', 'Paul', 1, 1, '1975-06-18', 'Lille', '+33100000005'),
(6, 'Sara', 'Nguyen', 'Sara', 2, 2, '2003-04-22', 'Marseille', '+33100000006'),
(7, 'Youssef', 'Ben', 'Youssef', 1, 1, '2001-12-01', 'Toulouse', '+33100000007'),
(8, 'Michael', 'Ross', 'Michael', 1, 2, '1982-02-09', 'Nice', '+33100000008'),
(9, 'Amelie', 'Rousseau', 'Amelie', 2, 1, '2004-05-03', 'Bordeaux', '+33100000009'),
(10, 'Jon', 'Doe', 'Jon', 1, 2, '2002-08-11', 'Lyon', '+33100000010');

-- Teachers entries
INSERT INTO enseignants (id, employee_number, department_id, hire_date, job_title, specialization, work_email, work_phone, status, created_at) VALUES
(4, 'EMP-1004', NULL, '2008-02-01', 'Associate Professor', 'Advanced Mathematics', 'christina.leroy@example.com', '+33100000004', 'ACTIF', NOW()),
(5, 'EMP-1005', NULL, '2005-07-15', 'Professor', 'Databases', 'paul.martin@example.com', '+33100000005', 'ACTIF', NOW()),
(8, 'EMP-1008', NULL, '2012-09-01', 'Lecturer', 'Networks', 'michael.ross@example.com', '+33100000008', 'ACTIF', NOW());

-- Students entries
INSERT INTO etudiants (id, student_number, admission_date, program_id, current_level, year_admitted, status, created_at) VALUES
(6, 'STU-3006', '2023-09-01', 1, 'B2', 2023, 'ACTIF', NOW()),
(7, 'STU-3007', '2022-09-01', 1, 'B3', 2022, 'ACTIF', NOW()),
(9, 'STU-3009', '2024-09-01', 1, 'B1', 2024, 'ACTIF', NOW()),
(10, 'STU-3010', '2023-09-01', 1, 'B2', 2023, 'ACTIF', NOW());

-- More courses
INSERT INTO courses (id, code, title, description, credits, coefficient, department_id, level, elective, created_at) VALUES
(4, 'CS102', 'Data Structures', 'Structures de données et algorithmes', 3.00, 1, NULL, 'B2', FALSE, NOW()),
(5, 'CS202', 'Databases', 'Systèmes de gestion de base de données', 3.00, 1, NULL, 'B2', FALSE, NOW()),
(6, 'CS303', 'Computer Networks', 'Introduction to computer networks', 3.00, 1, NULL, 'M1', FALSE, NOW());

-- Additional course offerings with schedules
INSERT INTO course_offerings (id, course_id, term_id, instructor_id, class_id, room_id, schedule, max_capacity, enrolled_count, status) VALUES
(4, 4, 1, 4, 1, 1, '[{"day":"Wed","start":"09:00","end":"11:00"}]', 60, 28, 'SCHEDULED'),
(5, 5, 1, 5, 1, 2, '[{"day":"Fri","start":"10:00","end":"12:00"}]', 50, 22, 'SCHEDULED'),
(6, 6, 2, 8, 2, 2, '[{"day":"Thu","start":"09:00","end":"11:00"}]', 40, 18, 'SCHEDULED');

-- More enrollments
INSERT INTO enrollments (id, student_id, course_offering_id, enrolled_on, status) VALUES
(3, 6, 4, NOW(), 'ENROLLED'),
(4, 7, 5, NOW(), 'ENROLLED'),
(5, 9, 5, NOW(), 'ENROLLED'),
(6, 10, 6, NOW(), 'ENROLLED');

-- Additional events
INSERT INTO events (id, title, description, start_datetime, end_datetime, location, audience, created_by, created_at) VALUES
(3, 'Atelier Algèbre', 'Atelier pratique pour Mathématiques avancées.', '2025-12-18 09:00:00', '2025-12-18 11:00:00', 'Salle EM102', '{"roles":["PROF","STUDENT"]}', 4, NOW()),
(4, 'Hackathon étudiant', 'Hackathon 48h pour les étudiants de CS.', '2026-02-05 10:00:00', '2026-02-07 10:00:00', 'Campus Hall', '{"roles":["STUDENT"]}', 1, NOW());

-- Additional notifications
INSERT INTO notifications (id, user_id, title, message, link, is_read, created_at) VALUES
(3, 6, 'Nouveau cours', 'Vous avez été inscrit au cours Data Structures.', NULL, 0, NOW()),
(4, 7, 'Rappel', 'Participez au séminaire Sécurité le 20/01.', NULL, 0, NOW());

-- Additional messages
INSERT INTO messages (id, sender_id, receiver_id, subject, body, sent_at) VALUES
(2, 4, 6, 'Organisation TD', 'Le TD aura lieu mercredi à 9h en EM102.', NOW()),
(3, 5, 7, 'Base de données', 'Merci d\'apporter votre portable pour le TP.', NOW());

-- Timetables for new users
INSERT INTO timetables (id, owner_type, owner_id, term_id, schedule, updated_at) VALUES
(3, 'TEACHER', 4, 1, '[{"day":"Wed","start":"09:00","end":"11:00","course_offering_id":4}]', NOW()),
(4, 'STUDENT', 6, 1, '[{"day":"Wed","start":"09:00","end":"11:00","course_offering_id":4}]', NOW());

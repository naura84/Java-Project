# 🎓 School Management System — JavaFX Application

> Complete academic management application with multi-role authentication, 
> 50+ JPA entities, and a clean multi-layer architecture (MVC + DAO + Services).

![Java](https://img.shields.io/badge/Java-17-007396?logo=openjdk)
![JavaFX](https://img.shields.io/badge/JavaFX-17.0.2-1E90FF)
![Hibernate](https://img.shields.io/badge/Hibernate-6.x-59666C?logo=hibernate)
![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?logo=mysql)
![Maven](https://img.shields.io/badge/Maven-3.6+-C71A36?logo=apachemaven)

Complete school management application developed in Java with JavaFX and Hibernate/JPA. This project offers a comprehensive authentication system, academic management, grades, finances, library, health, transport, discipline and many other features for educational institutions.


## ✨ Key Features

- 🔐 Multi-role authentication (Admin, Teacher, Student, Staff) with bcrypt/argon2
- 🎓 Full academic management: faculties, programs, classes, courses, enrollments
- 📊 Grades, evaluations & transcripts
- 💰 Financial management: fees, invoices, payments, scholarships
- 📚 Library, transport, health & disciplinary modules
- 🗄️ 50+ JPA entities with optimized relationships

---

## 1. Architecture & Project Structure

The application uses a multi-layer architecture:
- **GUI** : JavaFX (FXML)
- **Database** : MySQL/MariaDB (UTF8MB4)
- **ORM** : Hibernate JPA
- **Build Tool** : Maven Java 17

### 1.1 Folder Structure

```
src/main/
├── java/com/
│   ├── App.java                          # Main JavaFX entry point
│   ├── config/
│   │   ├── DbInitializer.java           # Database initialization
│   │   ├── EnvLoader.java               # Environment variables loader
│   │   └── JPAUtil.java                 # JPA configuration utility
│   ├── controllers/
│   │   ├── DashController.java          # Admin dashboard controller
│   │   └── LoginController.java         # Login screen controller
│   ├── dao/
│   │   └── GenericDAO.java              # Generic DAO for all entities
│   ├── models/                          # JPA entities (50+ classes)
│   │   └── [User.java, Student.java, Teacher.java, ...]
│   └── services/
│       ├── AppSession.java              # User session management
│       ├── AuthService.java             # Authentication service
│       ├── BaseService.java             # Base service
│       └── [CourseService, GradeService, ...]
└── resources/
    ├── com/
    │   ├── login.fxml                  # Login screen
    │   ├── dash.fxml                   # Main dashboard
    │   ├── dashEleve.fxml              # Student dashboard
    │   ├── dashProf.fxml               # Teacher dashboard
    │   └── profil.fxml                 # Profile screen
    └── META-INF/
        └── persistence.xml             # JPA configuration
```
## Entités du modèle de données

### 1.2 Data Model Entities

**Authentication & Users**
- `roles` : Application roles (ADMIN, TEACHER, STUDENT, STAFF)
- `users` : Centralized authentication accounts
- `user_profiles` : Detailed personal information
- `admins`, `teachers`, `students`, `staff_non_teaching` : Role-specific profiles

**Academic Structures**
- `academic_years` : Academic years
- `terms` : Semesters/periods
- `faculties`, `departments` : Institutional organization
- `programs` : Study programs/curricula
- `classes` : Student groups/cohorts
- `courses`, `course_offerings` : Course catalog and offerings
- `enrollments` : Course registrations

**Assessment & Results**
- `assessment_types`, `assessments` : Assessment types and planned evaluations
- `grades`, `grade_scales` : Grades and grading scales
- `transcripts` : Official transcripts

**Additional Features**
- `attendance` : Course attendance
- `timetables` : Schedules
- `fees`, `invoices`, `payments`, `scholarships` : Financial management
- `library_books`, `library_loans` : Library
- `transport_buses`, `transport_routes` : Transportation
- `health_records`, `medical_visits` : Health
- `disciplinary_actions` : Discipline
- `events`, `notifications`, `messages` : Communication
- `files` : File management
- `audit_logs` : Action logging
- `system_settings` : System configuration

## 2. Technologies & Dependencies

### 2.1 Framework & Languages
- **Java 17** : Programming language
- **Maven** : Project management and build tool
- **JavaFX 17.0.2** : GUI framework

### 2.2 Persistence & ORM
- **Hibernate ORM 6.x** : JPA implementation
- **Jakarta Persistence 3.1.0** : JPA specification
- **MySQL Connector/J** : MySQL driver

### 2.3 Utilities
- **Lombok 1.18.28** : Auto-generation of getters/setters
- **.env support** : Environment variables management

### 2.4 Database
- **MySQL/MariaDB** with UTF8MB4 charset
- Configuration via environment variables

## 3. Best Practices & Configuration

### 3.1 Security
- Passwords are hashed with bcrypt/argon2 (see `PasswordUtils.java`)
- Transactions are used for multi-table operations
- Authentication is centralized in `AuthService.java`

### 3.2 Performance & Optimization
- Index frequently searched columns (email, role_id, student_number, course codes)
- Use `GenericDAO` to avoid code duplication
- User sessions are managed via `AppSession.java`

### 3.3 Deployment & Backup
- Prepare a `.env` file at the project root with:
  ```
  DB_URL=jdbc:mysql://localhost:3306/school_management?serverTimezone=UTC&useSSL=false
  DB_USER=root
  DB_PASSWORD=yourpassword
  ```
- Regular database backups
- Validate foreign key constraints after data import

## 4. Installation & Getting Started

### 4.1 Prerequisites
- Java 17 or newer
- Maven 3.6+
- MySQL/MariaDB running

### 4.2 Configuration

1. **Clone the repository** :
   ```bash
   git clone "https://github.com/naura84/Java-Project.git"
   cd Java-Project
   ```

2. **Create a `.env` file** at the project root:
   ```
   DB_URL=jdbc:mysql://localhost:3306/school_management?serverTimezone=UTC&useSSL=false
   DB_USER=root
   DB_PASSWORD=yourpassword
   ```

3. **Initialize the database** :
   - Execute `data/database.sql` to create the schema
   - Execute `data/sample_data.sql` to load sample data

### 4.3 Build & Execution

**Compile the project** :
```powershell
mvn -DskipTests clean package
```

**Run the application** :
- On Windows: Double-click `run-app.bat`
- Or via Maven: `mvn javafx:run`
- Or manually:
  ```powershell
  mvn compile
  mvn exec:java -Dexec.mainClass="com.App"
  ```

### 4.4 Compiled Files
Compiled files and resources are located in `target/classes`. Do not modify this folder directly.

## 5. Main Features & Functionalities

### 5.1 Authentication & Roles
- Secure login system with password hashing
- Support for 4 roles: ADMIN, TEACHER, STUDENT, STAFF
- User session management
- Detailed user profiles

### 5.2 Academic Management
- Academic year and period management
- Organization by faculties and departments
- Program and curriculum management
- Class creation and management
- Complete course catalog
- Student enrollments

### 5.3 Grading & Evaluation
- Multiple assessment types (continuous assessment, exams, projects, etc.)
- Grade recording by evaluation
- Automatic calculations with grading scales
- Report card and transcript generation

### 5.4 Attendance & Scheduling
- Course attendance recording
- Timetable management

### 5.5 Financial Management
- Fee and billing management
- Invoicing system
- Payment recording
- Scholarship and financial aid management

### 5.6 Additional Services
- **Library**: Catalog and loan management
- **Transport**: Bus and route management
- **Health**: Medical records and visits
- **Discipline**: Incident recording
- **Events**: User communication
- Internal messaging
- **Audit**: Critical action logging

## 6. Contributing & Development

### 6.1 Coding Conventions
- Use Java 17+ with camelCase naming conventions
- Add Lombok annotations (@Getter, @Setter, @Data) to entities
- Document services with JavaDoc

### 6.2 Adding a New Feature
1. Create the JPA entity in `models/`
2. Implement a specialized DAO in `dao/` or use `GenericDAO`
3. Create a service in `services/`
4. Create the JavaFX controller in `controllers/`
5. Add the FXML file in `resources/com/`

### 6.3 Support & Troubleshooting
For database issues, check:
- The `.env` configuration
- MySQL connection
- Logs in the application console
- Please do not commit your credentials in `.env`. The `.env` file is ignored by Git.

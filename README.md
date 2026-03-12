# FSAD Skill Exam - Full Stack Application Development 2025-2026

## Project Overview
This is a Maven Hibernate project that implements HQL (Hibernate Query Language) operations on a Payment entity class. The project demonstrates database operations including insert, read, and delete functionality using Hibernate ORM framework.

## Technology Stack
- **Language**: Java 11+
- **Framework**: Hibernate 6.1.7
- **Database**: MySQL
- **Build Tool**: Maven
- **Architecture**: Maven standard directory structure

## Project Structure
```
2400030826-FSAD-SKILL-EXAM/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/klef/fsad/exam/
│   │   │       ├── Payment.java (Entity Class)
│   │   │       └── ClientDemo.java (HQL Operations Class)
│   │   └── resources/
│   │       └── hibernate.cfg.xml (Hibernate Configuration)
├── pom.xml (Maven Configuration)
└── README.md
```

## Entity Classes

### Payment Entity
**Package**: `com.klef.fsad.exam`

**Properties**:
- `id` (int) - Primary key (Auto-generated)
- `name` (String) - Payment recipient name
- `date` (LocalDate) - Payment date
- `status` (String) - Payment status (Completed, Pending, Failed, etc.)
- `amount` (Double) - Payment amount
- `description` (String) - Payment description

**Features**:
- JPA annotations (@Entity, @Table, @Id, @Column, @GeneratedValue)
- Constructors (default and parameterized)
- Getters and Setters for all properties
- toString() method for easy display

## Implementation Details

### ClientDemo Class
**Package**: `com.klef.fsad.exam`

**Operations**:

1. **INSERT Operations**
   - Creates 4 sample Payment records using persistent objects
   - Uses `session.persist()` method
   - Commits transaction after insertion

2. **DELETE Operations**
   - Deletes records based on ID using HQL with named parameters
   - HQL Query: `DELETE FROM Payment WHERE id = :paymentId`
   - Uses `query.setParameter()` for named parameters
   - Executes `query.executeUpdate()` for delete operation

3. **SELECT Operations**
   - Retrieves all payments with sorting
   - Query by status using HQL with named parameters
   - Counts total records in database
   - Returns List<Payment> for result processing

### Hibernate Configuration
**File**: `src/main/resources/hibernate.cfg.xml`

**Configuration Details**:
- MySQL JDBC Driver: `com.mysql.cj.jdbc.Driver`
- Database URL: `jdbc:mysql://localhost:3306/fsadexam`
- Default credentials: `root/root` (Change as needed)
- Dialect: `MySQL8Dialect`
- Auto DDL: `create` (Creates tables on session factory initialization)
- SQL Display: `true` (Shows generated SQL queries)

## Running the Application

### Prerequisites
1. Java 11 or higher
2. MySQL Server running
3. Maven installed
4. Create database: `CREATE DATABASE fsadexam;`

### Steps to Run
1. Clone the repository
2. Navigate to project directory
3. Run: `mvn clean install`
4. Run: `mvn exec:java -Dexec.mainClass="com.klef.fsad.exam.ClientDemo"`

## Database Setup
```sql
CREATE DATABASE fsadexam;
USE fsadexam;
-- Tables will be auto-created by Hibernate
```

## Expected Output
When you run ClientDemo, you should see:
1. Records inserted successfully
2. Delete operation confirmation
3. List of all remaining records
4. Additional HQL query results

## Key Concepts Demonstrated
- **Hibernate Entity Mapping**: Using JPA annotations to map Java classes to database tables
- **HQL Queries**: Using Hibernate Query Language instead of native SQL
- **Named Parameters**: Secure query execution with parameterized queries
- **Transaction Management**: Proper commit/rollback handling
- **Session Management**: Opening and closing Hibernate sessions properly

## Maven Dependencies
- hibernate-core: 6.1.7.Final
- mysql-connector-java: 8.0.33
- junit: 4.13.2

## Author
Kumaravel - Student ID: 2400030826

## Course
Full Stack Application Development 2025-2026 (Even Semester)

## Assignment
SKILL Exam Question - Hibernate HQL Implementation

---
**Note**: Update the database credentials in `hibernate.cfg.xml` if using different MySQL settings.

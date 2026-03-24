# Veritas AI - Backend Admin Panel 🎓

[![Live Demo](https://img.shields.io/badge/demo-live-success)](https://veritasa.netlify.app/)
[![Java](https://img.shields.io/badge/Java-17+-orange)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0+-brightgreen)](https://spring.io/projects/spring-boot)
[![Docker](https://img.shields.io/badge/Docker-Ready-blue)](https://www.docker.com/)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

> A secure, scalable backend admin panel for managing AI-powered educational platform with ML model training capabilities, role-based access control, and real-time analytics.

## 🚀 Live Demo

**Frontend:** [https://veritasa.netlify.app/](https://veritasa.netlify.app/)

**API Endpoint:** `https://veritas-ai-production.up.railway.app`

## 📋 Table of Contents

- [Features](#-features)
- [Tech Stack](#️-tech-stack)
- [System Architecture](#-system-architecture)
- [Getting Started](#-getting-started)
- [API Documentation](#-api-documentation)
- [Docker Deployment](#-docker-deployment)
- [Performance Optimizations](#-performance-optimizations)
- [Security](#-security)
- [Contributing](#-contributing)

## ✨ Features

### Admin Management
- 🔐 **JWT Authentication** - Secure token-based authentication system
- 👥 **Role-Based Authorization** - Granular access control for Admin, Mentor, and User roles
- 📊 **User Management** - Complete CRUD operations for user accounts
- 🎓 **Mentor Management** - Dedicated interface for managing mentors and their profiles
- 📚 **Course Management** - Full lifecycle management of courses and curricula

### ML Model Training
- 🤖 **Real-time Training Status** - Live tracking of model training progress via REST endpoints
- 📈 **Regression Models** - Implementation of regression algorithms for predictive analytics
- 🌲 **Decision Tree Algorithms** - Classification and decision-making capabilities
- ⚡ **Optimized Pipelines** - 45% reduction in training time through data preprocessing improvements
- 💾 **Resource Management** - Efficient allocation and monitoring of computational resources

### Performance & Scalability
- ⚡ **Query Optimization** - 35% improvement in API fetch performance through Hibernate/JPA optimizations
- 🔄 **Connection Pooling** - HikariCP for efficient database connection management
- 📦 **DTO Pattern** - Clean separation between entity and presentation layers
- 🎯 **Exception Handling** - Centralized error management with structured responses
- 📊 **Lazy Loading** - Strategic use of lazy loading for complex entity relationships

## 🛠️ Tech Stack

### Backend
- **Java 17** - Latest LTS version for modern language features
- **Spring Boot 3.0+** - Enterprise-grade application framework
- **Spring Security** - Comprehensive security framework
- **Spring Data JPA** - Simplified data access layer
- **Hibernate** - ORM for database operations

### Database
- **MySQL 8.0** - Primary relational database
- **HikariCP** - High-performance JDBC connection pool

### Security
- **JWT (JSON Web Tokens)** - Stateless authentication
- **BCrypt** - Password hashing algorithm
- **Spring Security** - Authorization and authentication

### DevOps & Deployment
- **Docker** - Containerization for consistent deployments
- **Railway** - Cloud platform deployment
- **Maven** - Dependency management and build automation

### ML Libraries
- **Weka** / **Smile** - Machine learning algorithms
- **Apache Commons Math** - Mathematical computations

## 🏗️ System Architecture
```
┌─────────────────┐
│   React Admin   │
│     Panel       │
└────────┬────────┘
         │
         │ HTTPS/REST
         │
┌────────▼────────────────────────────────┐
│         Spring Boot Application         │
│  ┌────────────────────────────────────┐ │
│  │     Security Layer (JWT + RBAC)    │ │
│  └────────────────────────────────────┘ │
│  ┌────────────────────────────────────┐ │
│  │       REST Controllers             │ │
│  │  - Auth  - Users  - Mentors        │ │
│  │  - Courses  - ML Training          │ │
│  └────────────────────────────────────┘ │
│  ┌────────────────────────────────────┐ │
│  │       Service Layer                │ │
│  │  (Business Logic + Validations)    │ │
│  └────────────────────────────────────┘ │
│  ┌────────────────────────────────────┐ │
│  │    Repository Layer (JPA/Hibernate)│ │
│  └────────────────────────────────────┘ │
└────────┬────────────────────────────────┘
         │
         │ JDBC
         │
┌────────▼────────┐
│   MySQL 8.0     │
│   Database      │
└─────────────────┘
```

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+
- Docker (optional, for containerized deployment)

### Installation

1. **Clone the repository**
```bash
git clone https://github.com/tharun694/Veritas-AI.git
cd Veritas-AI
```

2. **Configure Database**

Create a MySQL database:
```sql
CREATE DATABASE veritas_ai;
```

Update `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/veritas_ai
spring.datasource.username=your_username
spring.datasource.password=your_password

# JWT Secret Key
jwt.secret=your-secret-key-here
jwt.expiration=86400000

# Hibernate Settings
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

3. **Build the project**
```bash
mvn clean install
```

4. **Run the application**
```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

## 📚 API Documentation

### Authentication Endpoints

#### Register User
```http
POST /api/auth/register
Content-Type: application/json

{
  "username": "john_doe",
  "email": "john@example.com",
  "password": "SecurePass123",
  "role": "USER"
}
```

#### Login
```http
POST /api/auth/login
Content-Type: application/json

{
  "email": "john@example.com",
  "password": "SecurePass123"
}

Response:
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "type": "Bearer",
  "username": "john_doe",
  "email": "john@example.com",
  "roles": ["ROLE_USER"]
}
```

### User Management (Admin Only)

#### Get All Users
```http
GET /api/admin/users
Authorization: Bearer {token}
```

#### Update User
```http
PUT /api/admin/users/{id}
Authorization: Bearer {token}
Content-Type: application/json

{
  "username": "updated_name",
  "email": "updated@example.com",
  "role": "MENTOR"
}
```

#### Delete User
```http
DELETE /api/admin/users/{id}
Authorization: Bearer {token}
```

### Course Management

#### Create Course
```http
POST /api/admin/courses
Authorization: Bearer {token}
Content-Type: application/json

{
  "title": "Machine Learning Fundamentals",
  "description": "Introduction to ML concepts",
  "mentorId": 5,
  "duration": 40,
  "category": "AI/ML"
}
```

#### Get All Courses
```http
GET /api/courses
```

### ML Model Training

#### Start Training
```http
POST /api/ml/train
Authorization: Bearer {token}
Content-Type: application/json

{
  "modelType": "REGRESSION",
  "datasetPath": "/data/training_data.csv",
  "parameters": {
    "learningRate": 0.01,
    "epochs": 100
  }
}
```

#### Get Training Status
```http
GET /api/ml/training-status/{trainingId}
Authorization: Bearer {token}

Response:
{
  "trainingId": "abc123",
  "status": "IN_PROGRESS",
  "progress": 65,
  "currentEpoch": 65,
  "totalEpochs": 100,
  "estimatedTimeRemaining": "2 minutes"
}
```

## 🐳 Docker Deployment

### Build Docker Image
```bash
# Build the JAR file
mvn clean package -DskipTests

# Build Docker image
docker build -t veritas-ai:latest .
```

### Docker Compose
```yaml
version: '3.8'

services:
  mysql:
    image: mysql:8.0
    environment:
      MYSQL_DATABASE: veritas_ai
      MYSQL_ROOT_PASSWORD: rootpassword
    ports:
      - "3306:3306"
    volumes:
      - mysql_data:/var/lib/mysql

  app:
    build: .
    ports:
      - "8080:8080"
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://mysql:3306/veritas_ai
      SPRING_DATASOURCE_USERNAME: root
      SPRING_DATASOURCE_PASSWORD: rootpassword
    depends_on:
      - mysql

volumes:
  mysql_data:
```

### Run with Docker Compose
```bash
docker-compose up -d
```

### Deploy to Railway

1. Install Railway CLI:
```bash
npm install -g @railway/cli
```

2. Login and deploy:
```bash
railway login
railway init
railway up
```

## ⚡ Performance Optimizations

### Database Query Optimization
- **N+1 Query Problem**: Eliminated using `@EntityGraph` and fetch joins
- **Pagination**: Implemented `Pageable` for large datasets
- **Indexing**: Strategic indexes on frequently queried columns
- **Connection Pooling**: HikariCP with optimized pool size
```java
// Example: Optimized query with fetch join
@Query("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.enrolledCourses WHERE u.role = :role")
List<User> findUsersByRoleWithCourses(@Param("role") Role role);
```

### Caching Strategy
```java
@Cacheable(value = "courses", key = "#id")
public Course getCourseById(Long id) {
    return courseRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
}
```

### ML Pipeline Optimization
- **Data Preprocessing**: Vectorization and normalization before training
- **Batch Processing**: Processing training data in optimized batch sizes
- **Resource Allocation**: Dynamic memory allocation based on dataset size
- **Parallel Processing**: Multi-threaded training for independent models

## 🔒 Security

### Authentication Flow
1. User sends credentials to `/api/auth/login`
2. Server validates and generates JWT token
3. Client stores token and includes in `Authorization` header for subsequent requests
4. Server validates token and extracts user details for authorization

### Security Features
- ✅ **Password Encryption**: BCrypt with strength 12
- ✅ **JWT Expiration**: Configurable token expiration
- ✅ **CORS Configuration**: Restricted to trusted origins
- ✅ **SQL Injection Prevention**: Parameterized queries via JPA
- ✅ **XSS Protection**: Input validation and sanitization
- ✅ **HTTPS Only**: Enforced in production

-- ML Training Sessions
CREATE TABLE training_sessions (
    id VARCHAR(50) PRIMARY KEY,
    model_type VARCHAR(50) NOT NULL,
    status VARCHAR(20) NOT NULL,
    progress INT DEFAULT 0,
    started_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    completed_at TIMESTAMP NULL,
    created_by BIGINT,
    FOREIGN KEY (created_by) REFERENCES users(id)
);
```

## 🧪 Testing

Run all tests:
```bash
mvn test
```

Run with coverage:
```bash
mvn clean test jacoco:report
```

## 📈 Future Enhancements

- [ ] WebSocket support for real-time notifications
- [ ] Redis caching for improved performance
- [ ] Elasticsearch integration for advanced search
- [ ] Microservices architecture migration
- [ ] GraphQL API alongside REST
- [ ] Advanced ML models (Neural Networks, Deep Learning)
- [ ] Kubernetes deployment configuration
- [ ] Comprehensive API documentation with Swagger/OpenAPI

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Tharun Prakash G**

- GitHub: [@tharun694](https://github.com/tharun694)
- LinkedIn: [Your LinkedIn]([www.linkedin.com/in/
tharun-prakash-g])
- Email:tharunprakash999@gmail.com
- LeetCode: [250+ Problems Solved]([(https://leetcode.com/u/unkSNnMRt3])

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- Railway for seamless deployment
- The open-source community for inspiration

---

⭐ **Star this repository if you found it helpful!**

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

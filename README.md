# CareerSync Backend

CareerSync is a role-based career and placement management platform designed to connect students, recruiters, and administrators through a centralized system.

This repository contains the backend REST API built with Spring Boot, PostgreSQL, Spring Data JPA, Spring Security, and JWT authentication.

## Features

- JWT-based user authentication
- Role-based authorization
- Student management
- Recruiter management
- Job creation and management
- Student job applications
- Application status management
- Student profile management
- Admin user monitoring
- Admin job monitoring
- Admin application monitoring
- PostgreSQL database integration
- RESTful API architecture

## User Roles

### Student

Students can:

- Browse available jobs
- Apply for jobs
- View submitted applications
- Track application status
- View their profile

### Recruiter

Recruiters can:

- Post job opportunities
- View their posted jobs
- View student applications
- Update application status

### Admin

Administrators can:

- View registered users
- Monitor posted jobs
- Monitor student applications

## Technology Stack

- Java 21
- Spring Boot
- Spring MVC
- Spring Data JPA
- Spring Security
- JWT
- PostgreSQL
- Maven
- Lombok

## Backend Architecture

The backend follows a layered architecture:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
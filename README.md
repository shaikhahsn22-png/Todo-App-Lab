# Todo App

## Project Description
A Spring Boot REST API for managing todo categories and, later, todo items.

## Technologies
- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Postman

## Current Progress
### Step 1
- Created Spring Boot application
- Added `/hello` endpoint
- Tested using Postman

### Step 2
- Created development Spring profile
- Connected the application to PostgreSQL

### Step 3
- Created Category model
- Created CategoryRepository
- Created CategoryService
- Created CategoryController
- Implemented:
  - GET `/api/categories`
  - POST `/api/categories`
  - GET `/api/categories/{id}`

## Design Decisions
- Used PostgreSQL 
- Used Controller, Service, and Repository layers to separate responsibilities.
- Category currently contains `id`, `name`, and `description`.

## Challenges
I have not faced any issues yet.

## What Went Well
All went well.

## Favourite Part
Organizing the structure of the project.

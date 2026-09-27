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

### Step 3A
- Created Category model
- Created CategoryRepository
- Created CategoryService
- Created CategoryController
- Implemented Category CRUD endpoints:
  - GET `/api/categories`
  - POST `/api/categories`
  - GET `/api/categories/{id}`
  - PUT `/api/categories/{categoryId}`
  - DELETE `/api/categories/{categoryId}`
    
### Step 3B
- Created `Item` model
- Created `ItemRepository`
- Created `ItemService`
- Created `ItemController`
- Mapped `Category` and `Item` with a one-to-many / many-to-one relationship
- Added `name`, `description`, and `dueDate` fields to `Item`
- Implemented Item CRUD endpoints:
  - GET `/api/categories/{categoryId}/items`
  - POST `/api/categories/{categoryId}/items`
  - GET `/api/categories/{categoryId}/items/{itemId}`
  - PUT `/api/categories/{categoryId}/items/{itemId}`
  - DELETE `/api/categories/{categoryId}/items/{itemId}`
- Added validation for missing categories and items
- Tested all endpoints using Postman

### Step 3C
- Created `User` model
- Added `userName`, `emailAddress`, and `password` fields
- Created `UserProfile` model
- Added `firstName`, `lastName`, and `profileDescription` fields
- Mapped `User` and `UserProfile` using a one-to-one relationship
- Created user registration endpoint:
  - POST `/auth/users/register`
- Configured Spring Security to allow registration while protecting the other application endpoints
- Tested user registration using Postman

### Step 4
- Added Spring Security authentication
- Implemented JWT-based authentication
- Created login request and response models
- Added custom `UserDetails` and `UserDetailsService`
- Added password encryption using BCrypt
- Created login endpoint:
  - POST `/auth/users/login`
- Configured login to return a JWT after successful authentication
- Added JWT utility methods for token generation and validation
- Added JWT request filtering
- Configured protected endpoints to require a valid JWT
- Tested login and authenticated requests using Postman

## Design Decisions
- Used PostgreSQL 
- Used Controller, Service, and Repository layers to separate responsibilities.
- Used Spring Data JPA to manage database operations.
- Designed a one-to-many relationship between `Category` and `Item`.
- Designed a one-to-one relationship between `User` and `UserProfile`.
- Used custom exceptions to handle missing or duplicate data.
- Used BCrypt to securely encode user passwords.
- Used JWT for authentication.
- Allowed public access to registration and login endpoints while protecting the other API endpoints.
- Used Postman to test CRUD, registration, login, and authenticated requests.

## Challenges
I have not faced any issues yet.

## What Went Well
All went well.

## Favourite Part
Organizing the structure of the project.

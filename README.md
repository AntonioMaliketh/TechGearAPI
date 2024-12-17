# TechGear API

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white) ![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

This project is an API built using Java, Java Spring, Flyway Migrations, MySQL as the database, Spring Security and JWT for authentication control.

## Description

The Techgear API is a project built for educational purposes to demonstrate the creation and management of hardware products through a REST API. The API allows users to manage hardware data with various HTTP methods for creating, updating, retrieving, inactivating, reactivating, and deleting hardware items. This API serves as a backend solution for managing hardware inventory and provides the necessary endpoints for interaction.

## Features

- Manage hardware products through various endpoints
- [JWT](https://jwt.io/) authentication for user login
- Ability to deactivate hardware instead of deleting it (soft delete)
- Reactivate deactivated hardware
- Simple inventory management with categories, brands, and quantities

## API Endpoints

The Techgear API exposes the following endpoints for managing hardware products:

- **POST /hardware** - Create a new hardware entry
  - Example JSON body:
    ```json
    {
      "category": "MOUSE",
      "product": "Logitech G403",
      "brand": "LOGITECH",
      "quantity": "1"
    }
    ```

- **GET /hardware** - Retrieve a list of all hardware
- **PUT /hardware/{id}** - Update an existing hardware entry
- **DELETE /hardware/{id}** - Delete a hardware entry
- **DELETE /hardware/deactivate/{id}** - Deactivate a hardware entry (soft delete)
- **PUT /hardware/reactivate/{id}** - Reactivate a deactivated hardware entry
- **GET /hardware/{id}** - Retrieve a specific hardware entry by ID
- **POST /auth/login** - Login and obtain a JWT token for authentication

## Authentication

The API uses **[Spring Security](https://spring.io/projects/spring-security)** and **[JWT](https://jwt.io/)** for authentication. Users must log in with their credentials to obtain a bearer token. The token should then be included in the `Authorization` header for accessing protected endpoints.

Roles:
- **USER** - Standard role for accessing hardware data
- **ADMIN** - Admin role for managing hardware entries (creating, updating, and deleting)

## Database

The API uses **[MySQL](https://www.mysql.com/downloads/)** as the relational database. The necessary database migrations are managed using Flyway.

## Installation

### Prerequisites

- [Java](https://openjdk.org/) 17 or higher
- [MySQL](https://www.mysql.com/downloads/) database running locally or remotely
- [Maven](https://maven.apache.org/download.cgi) for building and managing dependencies

### Steps to Install

1. Clone the repository:
    ```bash
    git clone https://github.com/AntonioMaliketh/TechGearAPI.git
    cd techgear-api
    ```

2. Set up MySQL database:
    - Create a database in MySQL for the project, e.g., `techgear_db`.
    - Configure the `application.properties` or `application.yml` file to point to your database.

3. Install dependencies with Maven:
    ```bash
    mvn clean install
    ```

4. Run the application:
    ```bash
    mvn spring-boot:run
    ```
    The API will be available at `http://localhost:8080`.

    ## Usage

- After running the application, you can interact with the API via HTTP requests.
- Use tools like **[Postman](https://www.postman.com/downloads/)** or **[Insomnia](https://insomnia.rest/download)** to test the API endpoints.
- When making requests to protected endpoints, remember to include the JWT token in the Authorization header as a **Bearer token**.

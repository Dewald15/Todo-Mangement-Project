# Todo Management Application

This is a Spring Boot application for managing todo tasks. The application provides RESTful APIs for creating, retrieving, updating, and deleting todos. It also includes Spring Security for authentication and authorization.

## Table of Contents

- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Database](#database)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Security](#security)
- [Built With](#built-with)
- [Authors](#authors)

## Getting Started

These instructions will help you set up and run the project on your local machine.

### Prerequisites

- Java 22
- Maven
- MySQL

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/Dewald15/Todo-Mangement-Project.git
    cd todo-management
    ```

2. Build the project using Maven:
    ```bash
    mvn clean install
    ```

### Configuration

Configure your database settings in the `application.properties` file located in `src/main/resources`:

```properties
spring.application.name=todo-management

spring.datasource.url=jdbc:mysql://localhost:3306/todo_management
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
```

## Database

Make sure you have a MySQL database running and create a database named `todo_management`. Add users and roles to the database for authentication purposes.

## Running the Application

Run the application using the following command:
```bash
mvn spring-boot:run
```

## API Endpoints

The following endpoints are available in the application:

### Todos

- **Create a new todo**
    - `POST /api/todos`
    - **Request Body:**
      ```json
      {
          "title": "Sample Todo",
          "description": "This is a sample todo",
          "completed": false
      }
      ```

- **Retrieve a todo by ID**
    - `GET /api/todos/{id}`

- **Retrieve all todos**
    - `GET /api/todos`

- **Update a todo**
    - `PUT /api/todos/{id}`
    - **Request Body:**
      ```json
      {
          "title": "Updated Title",
          "description": "Updated Description",
          "completed": true
      }
      ```

- **Delete a todo**
    - `DELETE /api/todos/{id}`

- **Mark a todo as completed**
    - `PATCH /api/todos/{id}/complete`

- **Mark a todo as incomplete**
    - `PATCH /api/todos/{id}/in-complete`

## Security

The application uses Spring Security for authentication and authorization. The security configuration can be found in `SpringSecurityConfig.java`.

### Roles and Permissions

- **ADMIN role:** Can perform all CRUD operations on todos.
- **USER role:** Can view todos and mark them as complete or incomplete.

Make sure to add users and roles to the database. An example user with an encrypted password and assigned roles might look like this:

```sql
INSERT INTO roles (name) VALUES ('ROLE_USER'), ('ROLE_ADMIN');

INSERT INTO users (name, username, email, password) VALUES 
('Admin User', 'admin', 'admin@example.com', '$2a$10$DowJonesPasswordEncoderHere');

INSERT INTO users_roles (user_id, role_id) VALUES 
(1, 1), (1, 2);
```

## Built With

- Spring Boot: The web framework used
- Maven: Dependency Management
- MySQL: Database
- Spring Security: Security framework

## Authors

Dewald van den Berg - [GitHub](https://github.com/Dewald15)



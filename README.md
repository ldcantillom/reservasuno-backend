# ✈️ ReservasUno API

A REST API for managing an airline reservation system, developed with **Spring Boot**. This project was built as a learning experience to strengthen my knowledge of backend development, RESTful services, database integration, and Spring Boot architecture.

Although it started as an educational project, it has been updated to be fully runnable as part of my software development portfolio.

---

## 🚀 Features

* User authentication with Spring Security.
* Flight management.
* Airport management.
* Airline management.
* Reservation management.
* Passenger management.
* RESTful API architecture.
* PostgreSQL database integration.
* Entity mapping with MapStruct.
* Clean layered architecture (Controller → Service → Repository).

---

## 🛠️ Technologies

* Java
* Spring Boot
* Spring Security
* Spring Data JPA (Hibernate)
* PostgreSQL
* Maven
* MapStruct
* Lombok
* Docker & Docker Compose

---

# ⚙️ Getting Started

## 1. Start PostgreSQL with Docker

A `docker-compose.yaml` file is included to quickly create the PostgreSQL database.

Run:

```bash
docker compose up -d
```

This will start the database required by the application.

---

## 2. Load the sample data

Hibernate automatically creates the database schema when the application starts.

After the database has been created, execute the included `seed.sql` file to populate it with sample data.

Example:

```bash
psql -U postgres -d reservasuno -f seed.sql
```

Or import the file using your preferred PostgreSQL client (pgAdmin, DBeaver, DataGrip, etc.).

---

## 3. Run the application

Execute the project with Maven:

```bash
./mvnw spring-boot:run
```

or

```bash
mvn spring-boot:run
```

---

# 🔐 Demo Credentials

> ## ⚠️ IMPORTANT
>
> **Every user in the database uses the same password:**
>
> # **`pass123`**
>
> This was intentionally configured to make testing the application easier.

Example users:

| Username  | Password      |
| --------- | ------------- |
| `juan123` | `pass123`     |
| `mariag`  | `pass123`     |
| `carlosr` | `pass123`     |
| `anam`    | `pass123`     |
| ...       | **`pass123`** |

---

## 📚 Learning Goals

This project helped me gain practical experience with:

* Building REST APIs using Spring Boot.
* Layered application architecture.
* Dependency Injection.
* Spring Data JPA and Hibernate.
* Authentication with Spring Security.
* Database modeling and persistence.
* DTO mapping using MapStruct.
* Dockerizing development environments.

---

## 🚧 Project Status

This project is considered complete as a portfolio project.

Future improvements may include:

* Comprehensive input validation.
* Unit and integration tests.
* API documentation with Swagger / OpenAPI.
* Pagination and filtering.
* Global exception handling improvements.
* CI/CD pipeline.

---

## 📄 License

This project was created for educational and portfolio purposes.

# 🚗 Ride-Sharing Backend - Dual Database (Spring Boot + PostgreSQL + MongoDB)

This project is a Spring Boot application that demonstrates a real-world use case of integrating **PostgreSQL** for relational data and **MongoDB** for document-based storage.

## 📦 Tech Stack

- Java 17+
- Spring Boot 3
- Spring Data JPA (PostgreSQL)
- Spring Data MongoDB
- Docker & Docker Compose
- Maven

## 🧱 Modules

| Entity     | Database     | Type        |
|------------|--------------|-------------|
| Captain    | PostgreSQL   | Relational  |
| Customer   | PostgreSQL   | Relational  |
| Trip       | PostgreSQL   | Relational  |
| Payment    | PostgreSQL   | Relational  |
| Rating     | MongoDB      | Document    |

## 🚀 Getting Started

### 1. Clone the repo

```bash
git clone https://github.com/your-username/mini2-dual-db.git
cd mini2-dual-db
```

### 2. Start databases using Docker Compose

```bash
docker-compose up -d
```

### 3. Run the application

```bash
./mvnw spring-boot:run
```

The backend will start on: `http://localhost:8080`

## 🔧 Configuration

### `application.yml` (Excerpt)

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/mini2
    username: postgres
    password: postgres

  data:
    mongodb:
      uri: mongodb://localhost:27017/mini2

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

## 📬 Example Endpoints

- `POST /api/customers` — Create a customer
- `GET /api/captains/{id}` — Get captain by ID
- `POST /api/ratings` — Add a rating (MongoDB)
- `GET /api/ratings/byEntity?type=trip&id=TRIP_ID` — Query ratings

## 🐳 Docker Services

```yaml
services:
  postgres:
    image: postgres
    environment:
      POSTGRES_DB: mini2
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres

  mongo:
    image: mongo
```

## ✅ Features

- Dual DB Integration (JPA + Mongo)
- Modular architecture
- Dockerized DB setup
- RESTful API design
- Easily extensible for microservices

## 👨‍💻 Author

Moamen Elzyat  
Spring Boot Mini Project 2 — Scalable Software Architecture  
German University in Cairo (GUC)

## 📜 License

This project is for educational purposes.

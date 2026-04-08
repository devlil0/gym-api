# 🏋️ Gym API
## 🌎 Languages
- 🇺🇸 English (default)
- 🇧🇷 [Português](./README-pt-br.md)

REST API developed with Spring Boot for gym management.

The project allows managing students, workouts, and physical assessments, applying real backend development concepts such as layered architecture, database persistence, and best practices with Java.

This project is focused on learning and practical backend development.

---

## 🚀 Technologies

- Java 17  
- Spring Boot  
- Spring Data JPA  
- PostgreSQL  
- Maven  
- Lombok  
- Jakarta Validation  

---

## 📌 Features

- Student CRUD  
- Workout management  
- Physical assessment records  
- Entity relationships  
- Data validation  
- Layered architecture  

---

## 🧱 Architecture

The application follows a layered architecture:

- Controller → handles HTTP requests  
- Service → contains business logic  
- Repository → database access  
- Entity → database representation  
- DTO → data transfer between layers  

---

## ⚙️ Prerequisites

- Java 17  
- Maven  
- PostgreSQL  

---

## ⚙️ How to run

### 1. Clone the repository

git clone https://github.com/devlil0/gym-api  
cd gym-api  

### 2. Configure environment variables

DB_URL=jdbc:postgresql://localhost:5432/gym  
DB_USERNAME=postgres  
DB_PASSWORD=postgres  

---

### 3. Run the application

./mvnw spring-boot:run  

The API will be available at:

http://localhost:8080  

---

## 🔗 Endpoints

### Base URL

http://localhost:8080/v1  

---

### 👤 Student

GET /v1/student  
POST /v1/student  
POST /v1/student/update/{id}  
DELETE /v1/student/{id}  

---

### 🏋️ Workout

GET /v1/workout  
POST /v1/workout  

---

### 💪 Exercises

GET /v1/exercises  
POST /v1/exercises  

---

### 📊 Physical Assessment

GET /v1/physical  
POST /v1/physical  

---

## 🧪 Example Request

POST /v1/student  
Content-Type: application/json  

{
  "name": "John",
  "email": "john@email.com",
  "age": 25
}

---

## 📂 Project Structure

src/  
 └── main/  
     └── java/  
         └── br/com/gym/api/  
             ├── controller/  
             ├── service/  
             ├── database/  
             ├── dto/  
             ├── exception/  
             └── handler/  

---

## ⚠️ Notes

- This project is under development  
- Some endpoints may change  
- REST standard improvements can be applied in future versions  

---

## 👨‍💻 Author

https://github.com/devlil0  

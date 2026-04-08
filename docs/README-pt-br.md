# 🏋️ Gym API

🌎 Escolha seu idioma:
- 🇺🇸 [English](./README.md)
- 🇧🇷 Português (padrão)

API REST desenvolvida com Spring Boot para gerenciamento de academias.

O projeto permite controle de alunos, treinos e avaliações físicas, aplicando conceitos reais de desenvolvimento backend como arquitetura em camadas, persistência com banco de dados e boas práticas com Java.

Projeto com foco em estudo e prática de desenvolvimento backend.

---

## 🚀 Tecnologias

- Java 17  
- Spring Boot  
- Spring Data JPA  
- PostgreSQL  
- Maven  
- Lombok  
- Jakarta Validation  

---

## 📌 Funcionalidades

- CRUD de alunos  
- Gerenciamento de treinos  
- Registro de avaliações físicas  
- Relacionamento entre entidades  
- Validação de dados  
- Arquitetura em camadas  

---

## 🧱 Arquitetura

A aplicação segue padrão em camadas:

- Controller → recebe requisições HTTP  
- Service → contém regras de negócio  
- Repository → acesso ao banco de dados  
- Entity → representação das tabelas  
- DTO → transferência de dados entre camadas  

---

## ⚙️ Pré-requisitos

- Java 17  
- Maven  
- PostgreSQL  

---

## ⚙️ Como rodar

### 1. Clonar repositório

git clone https://github.com/devlil0/gym-api  
cd gym-api  

### 2. Configurar variáveis de ambiente

DB_URL=jdbc:postgresql://localhost:5432/gym  
DB_USERNAME=postgres  
DB_PASSWORD=postgres  

---

### 3. Rodar aplicação

./mvnw spring-boot:run  

A API estará disponível em:

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

## 🧪 Exemplo de requisição

POST /v1/student  
Content-Type: application/json  

{
  "name": "João",
  "email": "joao@email.com",
  "age": 25
}

---

## 📂 Estrutura do projeto

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

## ⚠️ Observações

- Projeto em desenvolvimento  
- Alguns endpoints podem mudar  
- Melhorias REST podem ser aplicadas futuramente  

---

## 👨‍💻 Autor

https://github.com/devlil0  

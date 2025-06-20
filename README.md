# 🧩 Spring Boot Multi-Schema (MySQL)

This project demonstrates how to connect a **Spring Boot** application to **multiple MySQL schemas** using **custom configurations and multiple data sources**.

- ✅ `schema1` handles **User** data  
- ✅ `schema2` handles **Product** data  

Ideal for microservices, modular architecture, or legacy systems that require working with more than one database.

---

## 🛠️ Tech Stack

- ☕ Java 23  
- 🚀 Spring Boot 3.5.3  
- 🧬 Spring Data JPA  
- 🐬 MySQL 8+  
- 📦 Maven  
- ✨ Lombok  

---

## 📁 Project Structure

Spring-Boot-Multi-Schema/
├── config/
│ ├── Schema1Config.java # Configuration for User DB (schema1)
│ └── Schema2Config.java # Configuration for Product DB (schema2)
│
---
├── model/
│ ├── user/
│ │ └── User.java # User entity
│ └── product/
│ └── Product.java # Product entity
│
---
├── repository/
│ ├── userrepo/
│ │ └── UserRepository.java # JPA repository for User
│ └── productrepo/
│ └── ProductRepository.java # JPA repository for Product
│
---
├── resources/
│ └── application.properties # DataSource and JPA config
│
---
└── MultischemaApplication.java # Main Spring Boot application class 


---

## 📌 Key Features

- 🔄 Uses `@EnableJpaRepositories` to separate repository logic by schema.
- 🧩 Separate `EntityManagerFactory` and `TransactionManager` for each database.
- 🔐 Fully isolated database configurations.
- 🔍 Enables `show-sql` and `ddl-auto` for runtime SQL visibility.

---

## 📣 Want more?

I can help you add:

- 🐳 Docker support (`docker-compose.yml`)
- 🧪 Sample REST controllers
- 🔄 Data initialisation scripts
- 🧼 `.gitignore` and production-ready `pom.xml`

Just let me know!

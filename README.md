# -Spring-Boot-Multi-schema
# 🧩 Spring Boot Multi-Schema Example (MySQL)

This project demonstrates how to connect a **Spring Boot** application to **multiple MySQL schemas (databases)** using custom configurations.

✅ `schema1` is used for managing **User** data  
✅ `schema2` is used for managing **Product** data  

---

## 🛠️ Tech Stack

- Java 23  
- Spring Boot 3.5.3  
- Spring Data JPA  
- MySQL 8+  
- Maven  
- Lombok  

---

## 📂 Project Structure

Spring-Boot-Multi-Schema/
├── config/
│ ├── Schema1Config.java <-- Config for User DB (schema1)
│ └── Schema2Config.java <-- Config for Product DB (schema2)
│
├── model/
│ ├── user/User.java <-- User entity
│ └── product/Product.java <-- Product entity
│
├── repository/
│ ├── userrepo/UserRepository.java
│ └── productrepo/ProductRepository.java
│
├── application.properties
└── MultischemaApplication.java <-- Main class

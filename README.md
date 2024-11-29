# User Authentication and Authorization API with Spring Boot and JWT
A Spring Boot application that implements user authentication and authorization using Spring Security and JWT (JSON Web Tokens). 
It provides secure APIs for user registration, login, and role-based access control, along with support for H2 database access.

**Features:**
1. User Registration API (Accessible without authentication)
2. JWT-based Authentication and Authorization
3. Role-based access control with USER and ADMIN roles
4. Secure endpoints for application APIs
5. H2 Database for testing and development
6. Lightweight and extendable architecture


**Technologies Used:**
1. Java 17
2. Spring Boot 3.x
3. Spring Security
4. JWT (JSON Web Token)
5. H2 Database
6. Lombok
7. Maven

**Endpoints**

| Method  | Endpoint      | Description   | Authentication
| ------- | ------------- | ------------- | ------------- |
| POST   | /api/auth/register | Register a new user | Not Required |
| POST  | /api/auth/login	   | Login and receive a JWT token |
|GET	| /h2-console/** |	Access the H2 database console	|
|GET	| /api/users	| Get user details	| 


# Setup Instructions

**Prerequisites**
1. Java 17 installed
2. Maven installed
3. Any IDE (e.g., IntelliJ IDEA, Eclipse)
4. Postman or any API testing tool (optional)

**Clone the Repository**
```
git clone https://github.com/Hiral-Sanghani/RBAC_VRV.git
cd RBAC_VRV

```

**Configure the Application**

**Application Properties:**
1. Update application.yml or application.properties as needed for your environment.
2. Default settings for H2 database:
```spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

# Build the project
  ```
   mvn clean install
   ```

# Run the application
  ```
   mvn spring-boot:run
   ```

# Access the Application
H2 Database Console:

URL: http://localhost:8081/h2-console

* Default credentials:
```Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password: password
```
**APIs:**

* Base URL: http://localhost:8081/api/auth/

* **Testing the API**
 
  * Register a New User:
    * **Endpoint:** POST /api/auth/register

    * **Sample Request Body:**
      ```
        {
         "username": "john123",
         "email": "john.doe@example.com",
         "password": "password123"
       }
      ```

  * Login:

    * **Endpoint:** POST /api/auth/login

    * **Sample Request Body:**
     ```
       {
          "username": "john123",
          "password": "password123"
        }
     ```
     
    * **Response:** A JWT token.
      
    *  Access Protected Endpoints:
        - Pass the JWT token as a Bearer token in the Authorization header.


# Employee Management System

A small Spring Boot REST API project written with straightforward class and variable names.

## Requirements

- Java 17 (or newer compatible JDK)
- Maven 3.9+ (IntelliJ can import the Maven project)
- MySQL 8+

## Run in IntelliJ

1. Extract the ZIP and open this folder in IntelliJ using **File > Open**.
2. Allow IntelliJ to load the Maven `pom.xml` dependencies.
3. Start MySQL and create a user with database creation permission, or use local root.
4. Edit `src/main/resources/application.properties`, or set environment variables `DB_USER`, `DB_PASSWORD`, `DB_URL`.
5. Run the green arrow next to `Application.main()`.
6. The server runs at `http://localhost:8082`.

## Endpoints

- `GET /api/employees`, `GET /api/employees/1`, `POST /api/employees`, `PUT /api/employees/1`, `DELETE /api/employees/1`

POST and PUT accept JSON fields matching the entity Java fields. For related records,
use `{"project":{"id":1},"assignedTo":{"id":1}}` after those records exist.

## Example JSON

```json
{
  "firstName": "Neha",
  "lastName": "Kumari",
  "email": "neha@example.com",
  "department": "IT",
  "salary": 50000
}
```

## GitHub

Run `git init`, `git add .`, `git commit -m "Initial project"`, then create an empty repository on GitHub and follow its
push instructions.

## Notes

- This is a learning-oriented backend starter, not a production-ready app.
- MySQL tables are created by Hibernate when the application starts.
- Never commit real passwords or JWT secrets. Use environment variables outside local development.
- You can add pagination, DTOs and automated API tests as next improvements.


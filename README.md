# Test Containers Demo Project

This repository contains a demo project showcasing the use of **Testcontainers** for integration testing in a Spring Boot application. It provides examples of containerized databases and demonstrates how to test repository and service layers effectively.

## What is this repository for?

- **Purpose**: To demonstrate the use of **Testcontainers** with Spring Boot for integration testing.
- **Features**:
    - Spring Boot application setup.
    - Database containerization for testing.
    - Integration tests for repository and service layers.

### Prerequisites

Make sure you have the following installed on your machine:
- JDK 21 or later
- Maven 3.8 or later
- Docker

### Run the application

1. Position yourself in the project root directory.
2. Run the following command:
```sh
docker-compose up -d
```
3. Start the Spring Boot application

### Run tests

```sh
mvn test
```

# Microservice Supermarket

A microservice architecture for a supermarket system showcasing robust service separation, dynamic service discovery, and efficient API gateway patterns. This implementation leverages a diverse technology stack—including Java with Spring Boot, Node.js with Express, and Python with Flask—to create a scalable, modular ecosystem of independent services that communicate seamlessly through a centralized gateway and service registry.

## Project Overview

This project demonstrates a microservice architecture for a supermarket system with the following components:

- **Eureka Service**: Service discovery server
- **API Gateway**: Central entry point for all client requests
- **Product Service**: Manages product information (Spring Boot)
- **Order Service**: Handles order processing (Spring Boot)
- **Inventory Service**: Tracks inventory levels (Node.js/Express)
- **Customer Service**: Manages customer data (Python/Flask)

## Architecture

                    ┌───────────────┐
                    │ Eureka Server │
                    │   Port:8761   │
                    └───────┬───────┘
                            │
                            │ (service registration/discovery)
                            │
                   ┌────────▼─────────┐
                   │    API Gateway   │
                   └────────┬─────────┘
                            │
             ┌──────────────┼──────────────┬───────────────┐
             │              │              │               │
    ┌────────▼─────┐ ┌──────▼───────┐ ┌────▼─────────┐ ┌───▼──────────┐
    │Product Service│ │ Order Service│ │Inventory Svc │ │Customer Svc  │
    │  Port:8081    │ │  Port:8082   │ │  Port:3000   │ │  Port:5000   │
    │ (Spring Boot) │ │ (Spring Boot)│ │  (Node.js)   │ │  (Python)    │
    └───────────────┘ └──────────────┘ └──────────────┘ └──────────────┘



## Services

### Eureka Service (Port: 8761)

A service discovery server that allows services to find and communicate with each other without hard-coding hostname and port.

- Spring Cloud Netflix Eureka Server
- Java 17

### API Gateway (Spring Cloud Gateway)

Central entry point for all client requests. Routes requests to the appropriate microservice.

Routes configured:
- `/product-service/**` → Product Service (Port: 8081)
- `/order-service/**` → Order Service (Port: 8082)
- `/inventory-service/**` → Inventory Service (Port: 3000)
- `/customer-service/**` → Customer Service (Port: 5000)

### Product Service (Port: 8081)

Manages product information. Built with Spring Boot.

Endpoints:
- `GET /product-service/api/v1/products/all` - Returns all products

### Order Service (Port: 8082)

Handles order processing. Built with Spring Boot.

Endpoints:
- `GET /order-service/api/v1/orders/all` - Returns all orders

### Inventory Service (Port: 3000)

Tracks inventory levels. Built with Node.js and Express.

Endpoints:
- `GET /inventory-service/inventory` - Returns inventory information

### Customer Service (Port: 5000)

Manages customer data. Built with Python and Flask.

Endpoints:
- `GET /customer-service/customers` - Returns customer information

## Technologies Used

- **Java 17** - Core language for Spring Boot services
- **Spring Boot 3.4.2** - Framework for Java services
- **Spring Cloud** - For microservices patterns (Eureka, API Gateway)
- **Node.js/Express** - For Inventory Service
- **Python/Flask** - For Customer Service
- **Gradle** - Build tool for Order Service
- **Maven** - Build tool for other Java services
- **py_eureka_client** - Eureka client for Python service
- **eureka-js-client** - Eureka client for Node.js service

## Getting Started

### Prerequisites

- Java 17 or higher
- Node.js and npm
- Python 3.x and pip
- Gradle and Maven

### Running the Services

1. Start the Eureka Service first:
   ```bash
   cd Eureka-Service
   ./mvnw spring-boot:run

2. Start the API Gateway:
   ```bash
   cd API-Gateway
   ./mvnw spring-boot:run

3. Start the Product Service:
   ```bash
   cd Product-Service
   ./mvnw spring-boot:run

4. Start the Order Service:
   ```bash
   cd Order-Service
   ./gradlew bootRun

5. Start the Inventory Service:
   ```bash
   cd Inventory-Service
   npm install
   node app.js

6. Start the Customer Service:
   ```bash
   cd Customer-Service
   pip install flask py_eureka_client
   python customer_service.py

## Project Structure

    Microservice-Supermarket/
    ├── Eureka-Service/          # Service Discovery
    ├── API-Gateway/             # API Gateway
    ├── Product-Service/         # Product Service (Java)
    ├── Order-Service/           # Order Service (Java)
    ├── Inventory-Service/       # Inventory Service (Node.js)
    └── Customer-Service/        # Customer Service (Python)


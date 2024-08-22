# Payment Microservice

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Razorpay](https://img.shields.io/badge/Razorpay-02042B?style=for-the-badge&logo=razorpay&logoColor=white)
![Stripe](https://img.shields.io/badge/Stripe-008CDD?style=for-the-badge&logo=stripe&logoColor=white)

## Project Description

The Payment Microservice is a Spring Boot application designed to handle payment processing, order management, customer management, transaction tracking, and refunds. It integrates with payment gateways such as Razorpay and Stripe and includes comprehensive features for managing financial transactions.

## Project Structure

```plaintext
src
└── main
    └── java
        └── dev
            └── ruchir
                └── payment_service
                    ├── Configs
                    │   └── Razorpay_Client_Config.java
                    ├── Controller
                    │   ├── PaymentController.java
                    │   ├── OrderController.java
                    │   ├── RefundController.java
                    │   ├── CustomerController.java
                    │   └── TransactionController.java
                    ├── DTOs
                    │   ├── GeneratePaymentLinkRequestDTO.java
                    │   ├── PaymentDTO.java
                    │   ├── OrderDTO.java
                    │   ├── CustomerDTO.java
                    │   └── TransactionDTO.java
                    ├── Models
                    │   ├── BaseEntity.java
                    │   ├── Payment.java
                    │   ├── Order.java
                    │   ├── Customer.java
                    │   └── Transaction.java
                    ├── Repositories
                    │   ├── PaymentRepository.java
                    │   ├── OrderRepository.java
                    │   ├── CustomerRepository.java
                    │   └── TransactionRepository.java
                    ├── Services
                    │   ├── PaymentService.java
                    │   ├── StripePaymentGateway.java
                    │   ├── RazorpayPaymentGateway.java
                    │   ├── OrderService.java
                    │   ├── OrderServiceImpl.java
                    │   ├── CustomerService.java
                    │   ├── CustomerServiceImpl.java
                    │   ├── TransactionService.java
                    │   └── TransactionServiceImpl.java
                    ├── ControllerAdvice
                    │   ├── GlobalExceptionHandler.java
                    │   └── PaymentException.java
                    └── PaymentServiceApplication.java
```

## Features

- **Payment Processing**: Handle payments through Razorpay and Stripe.
- **Order Management**: Create and manage orders.
- **Customer Management**: Create and manage customers.
- **Transaction Tracking**: Track transactions and view transaction details.
- **Refund Handling**: Process refunds for payments.
- **Exception Handling**: Global exception handling with custom messages.

## Key Components

- **`Razorpay_Client_Config.java`**: Configures Razorpay client settings.
- **`PaymentController.java`**: Handles payment-related API requests.
- **`OrderController.java`**: Manages order-related API requests.
- **`RefundController.java`**: Manages refund-related API requests.
- **`CustomerController.java`**: Handles customer-related API requests.
- **`TransactionController.java`**: Manages transaction-related API requests.
- **`GlobalExceptionHandler.java`**: Manages global exception handling.
- **`PaymentService.java`**: Interface for payment services.
- **`StripePaymentGateway.java`**: Handles interactions with the Stripe API.
- **`RazorpayPaymentGateway.java`**: Handles interactions with the Razorpay API.

## Sample API Calls

### Payments

- **POST** `/payments`: Process a new payment.
- **GET** `/payments/{id}`: Retrieve payment details by ID.
- **GET** `/payments`: List all payments.

### Orders

- **POST** `/orders`: Create a new order.
- **GET** `/orders/{id}`: Retrieve order details by ID.
- **GET** `/orders`: List all orders.
- **PUT** `/orders/{id}`: Update order details.
- **DELETE** `/orders/{id}`: Delete an order.

### Customers

- **POST** `/customers`: Add a new customer.
- **GET** `/customers/{id}`: Retrieve customer details by ID.
- **GET** `/customers`: List all customers.
- **PUT** `/customers/{id}`: Update customer details.
- **DELETE** `/customers/{id}`: Delete a customer.

### Transactions

- **POST** `/transactions`: Record a new transaction.
- **GET** `/transactions/{id}`: Retrieve transaction details by ID.
- **GET** `/transactions`: List all transactions.

### Refunds

- **POST** `/refunds`: Initiate a refund request.


### Prerequisites

- [Java JDK 11 or higher](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/)
- [MySQL 8.0](https://dev.mysql.com/downloads/mysql/)



### Installation

1. **Clone the repository:**

    ```bash
    git clone https://github.com/your-username/product_service_24.git
    ```

2. **Navigate to the project directory:**

    ```bash
    cd product_service_24
    ```

3. **Install dependencies and build the project:**

    ```bash
    mvn clean install
    ```

4. **Configure MySQL database settings in `application.properties`:**

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/Payment_Service
    spring.datasource.username=Payment_Service_User
    spring.datasource.password=your_password
    ```

5. **Run the application:**

    ```bash
    mvn spring-boot:run
    ```

### Usage

Access the API at `http://localhost:8080/products`.

### Testing

Run tests using Maven:

```bash
mvn test
 ```

   ## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any improvements or bug fixes.


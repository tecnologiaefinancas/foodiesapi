# Restaurant Admin Panel (Backend Only)

<a href="https://www.linkedin.com/in/natalia-feitosa-cga-cfp" target="_blank" style="text-decoration:none">
    <img src="https://img.shields.io/badge/LinkedIn-000000?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn">
</a>

This is a **Java 17** application built with **Spring Boot**, designed to power an **Admin Panel for a Restaurant**. The backend provides robust APIs to manage restaurant operations, and it integrates with the following technologies:

- **Amazon S3**: Utilized as a storage bucket.
- **MongoDB**: Employed as the database to handle and persist data efficiently.

## Features
- Backend APIs tailored for restaurant administrative functions.
- Integration with Amazon S3 for secure file storage and retrieval.
- MongoDB for scalable and flexible database management.

## Prerequisites
To set up this project, ensure you have the following installed:
- Java 17
- Maven
- MongoDB (running locally or configured remotely)
- AWS S3 bucket with appropriate IAM credentials.

## Setup Instructions
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd <repository-folder>
   ```
2. Configure the application:
    - Update the **`application.properties`** file with your MongoDB URI, AWS S3 access key, secret key, and region.
    - Example:
      ```properties
      spring.data.mongodb.uri=mongodb://<username>:<password>@localhost:27017/<database>
      aws.access.key=<AWS_ACCESS_KEY_ID>
      aws.secret.key=<AWS_SECRET_ACCESS_KEY>
      aws.region=us-east-1
      aws.s3.bucketname=<bucket-name>
      ```
3. Build and run the application:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## Technology Stack
- **Java 17**
- **Spring Boot**
    - Spring Data MongoDB
    - Spring Web
- **Amazon S3 (AWS SDK v2)**
- **MongoDB**

## Acknowledgment
Special thanks to **Bushan** for the valuable lessons.


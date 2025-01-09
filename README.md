# JDBC Project

This project demonstrates various JDBC (Java Database Connectivity) operations, including connecting to a MySQL database, creating tables, inserting data, and handling images within the database.

## Prerequisites

- **Java Development Kit (JDK):** Ensure JDK 21 is installed on your system.
- **MySQL Database:** Set up a MySQL database named `book` with appropriate user credentials.
- **MySQL Connector/J:** Add the MySQL JDBC driver (`mysql-connector-java-8.0.32.jar`) to your project's classpath.

## Project Structure

- **`CreateQuery.java`**: Contains methods to create database tables.
- **`InsertQuery.java`**: Demonstrates inserting static data into the database.
- **`DynamicInputInsertQuery.java`**: Handles dynamic user input for database insertion.
- **`InsertImages.java`**: Shows how to insert images into the database.
- **`FristJDBC.java`**: Establishes a connection to the database and verifies it.
- **`config.properties`**: Stores database configuration properties.
- **`stepsInJDBC.txt`**: Provides step-by-step instructions for setting up and executing JDBC operations.

## Setup and Execution

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/ShivamChaudhari19/jdbc.git
   cd jdbc

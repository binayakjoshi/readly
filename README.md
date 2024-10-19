# Readly
## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Installation](#installation)
- [Database Setup](#database-setup)
- [Running the App](#running-the-app)
- [Usage](#usage)
## Overview
**Readly** is a simple bookstore application with minimalistic UI built using Java Servlets, Tomcat server, and MariaDB. Users can browse books, add them to their cart and place order.The app handles user authentication, inventory management.
## Features

- View a list of books available for sale.
- Add books to the cart and proceed to checkout.
- Vendor management: Add, edit, and remove books from the inventory.
- Responsive and user-friendly interface.
## Tech Stack

- **Frontend**: HTML, CSS, JavaScript
- **Backend**: Java Servlets, JSP
- **Database**: MariaDB/MySQL
- **Server**: Apache Tomcat
- **Build Tool**: Maven
  ## Installation

To run the bookstore app locally, follow these steps:

### Prerequisites

- Apache Tomcat server
- MariaDB
- Maven
- Java Development Kit (JDK) 8+

### Steps

1. **Clone the repository**:
    ```bash
    git clone https://github.com/binayakjoshi/readly.git
    ```

2. **Navigate to the project directory**:
    ```bash
    cd readly
    ```

3. **Install dependencies and build the project**:
    ```bash
    mvn clean install
    ```

4. **Deploy the WAR file to Tomcat**:
    Copy the generated WAR file (`target/readly.war`) to the Tomcat `webapps` directory.
    ```bash
    cp target/readly.war /path/to/tomcat/webapps
    ```
    OR just run the bash script `run.sh` that I have written as:
    ```bash
    zsh run.sh /path/to/readly /path/to/tomcat/
    ```

## Database Setup

1. **Create a database in MariaDB**:
    ```sql
    CREATE DATABASE bookstore;
    ```

2. **Import the SQL schema**:
    The schema file for creating the required tables is located in the `db/schema.sql` file. Import it as follows:
    ```bash
    mysql -u root -p bookstore < db/schema.sql
    ```

3. **Update the database connection settings**:
   In the `src/main/resources/db.properties` file, update the database connection details like the username, password, and database name:

    ```properties
    db.url=jdbc:mariadb://localhost:3306/bookstore_db
    db.username=root
    db.password=""
    ```

## Running the App
   if you use `run.sh` script then you don't need to follow this step 1 just acces the app.
1. **Start Tomcat**:
    Navigate to your Tomcat bin directory and start the server:
    ```bash
    cd /path/to/tomcat/bin
    ./startup.sh
    ```
 
2. **Access the App**:
    Open a browser and go to `http://localhost:8080/readly` to view the app.


# Digital Library Management System

## Overview
The Digital Library Management System is a Spring Boot application that allows users to manage a collection of books. The system supports adding, retrieving, updating, deleting, and searching books by title. It also includes exception handling.

## Features
- Add a book with title, author, and ISBN
- Retrieve all books
- Retrieve a book by ID
- Update book details
- Delete a book
- Search books by title
- Handle validation and exceptions
- Graceful shutdown of the application

## Technologies Used
- Java
- Spring Boot
- Spring Web
- Spring Validation
- Jakarta Validation
- REST APIs

## Endpoints
| Method | Endpoint | Description |
|--------|---------|-------------|
| POST | `/books` | Add a new book |
| GET | `/books` | Retrieve all books |
| GET | `/books/{id}` | Retrieve a book by ID |
| PUT | `/books/{id}` | Update a book |
| DELETE | `/books/{id}` | Delete a book |
| GET | `/books/search?title={title}` | Search books by title |
| POST | `/books/exit` | Shutdown application |

## Running the Application
1. Clone the repository.
2. Navigate to the project directory.
3. Run the application


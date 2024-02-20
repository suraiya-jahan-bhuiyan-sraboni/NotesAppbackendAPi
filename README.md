## Introduction
This project is a Kotlin-based RESTful API that provides endpoints for managing users and their associated notes. It is built using Spring Boot framework for creating RESTful controllers and to map HTTP requests to handler methods.

## Endpoints

### 1. Register User
- **URL:** `/api/users/RegisterUser`
- **Method:** `POST`
- **Request Body:** JSON representing user details (`Users` object)
- **Description:** Registers a new user in the system.

### 2. Login User
- **URL:** `/api/users/loginUser`
- **Method:** `POST`
- **Request Body:** JSON representing user login credentials (`UserloginResponse` object)
- **Response:** JSON representing user details (`UserResponse` object)
- **Description:** Authenticates user login.

### 3. Reset Password
- **URL:** `/api/users/resetPassword`
- **Method:** `PUT`
- **Request Parameters:** `userName` (String), `password` (JSON representing new password)
- **Description:** Resets user password.

### 4. Delete User
- **URL:** `/api/users/deleteUser`
- **Method:** `DELETE`
- **Request Parameters:** `id` (Int)
- **Description:** Deletes a user based on provided user ID.

### 5. Create Note for User
- **URL:** `/api/users/createNote`
- **Method:** `POST`
- **Request Body:** JSON representing note details (`Notes` object)
- **Description:** Creates a new note for a user.

### 6. Get User's Notes
- **URL:** `/api/users/NotesList`
- **Method:** `POST`
- **Request Parameters:** `userId` (Int)
- **Response:** JSON array of notes associated with the user
- **Description:** Retrieves all notes associated with a user.

### 7. Delete All User's Notes
- **URL:** `/api/users/DeleteAllNotes`
- **Method:** `POST`
- **Request Parameters:** `userId` (Int)
- **Description:** Deletes all notes associated with a user.

### 8. Delete Single User's Note
- **URL:** `/api/users/DeleteSingleNotes`
- **Method:** `POST`
- **Request Parameters:** `id` (Int), `userId` (Int)
- **Description:** Deletes a single note associated with a user.

### 9. Update Single User's Note
- **URL:** `/api/users/updateSingleNotes`
- **Method:** `PUT`
- **Request Body:** JSON representing updated note details (`Notes` object)
- **Description:** Updates a single note associated with a user.

## Setup
1. Clone this repository.
2. Make sure you have JDK and Kotlin installed.
3. Import the project into your preferred Kotlin IDE.
4. Configure your database settings in `application.properties`.
5. Run the application.

## Dependencies
- Spring Boot
- Kotlin
- Spring Web
- Spring Data JPA


# **Movie Booking Application Backend**

## **Overview**
The Movie Booking Application Backend is a RESTful API designed to manage movie data efficiently. Users can view a list of all available movies, add new movies with unique IDs, and retrieve specific movie details using their IDs. The application ensures data integrity by implementing strong error handling for duplicate movie IDs and non-existent movie requests.

## **Features**
- Retrieve the full list of movies.
- Add a new movie with a unique ID.
- Fetch details of a specific movie using its ID.
- Handle errors for duplicate movie IDs.
- Return appropriate responses for non-existent movie IDs.

## **Technologies Used**
- Java
- Spring Boot
- REST API
- Maven
- H2 Database (for temporary storage)

## **Installation & Setup**
1. **Clone the repository:**
   ```sh
   git clone https://github.com/your-repo/movie-booking-backend.git
   ```
2. **Navigate to the project directory:**
   ```sh
   cd movie-booking-backend
   ```
3. **Build the project:**
   ```sh
   mvn clean install
   ```
4. **Run the application:**
   ```sh
   mvn spring-boot:run
   ```
5. **Access the API:** `http://localhost:8080`

## **API Endpoints**
### **1. Get All Movies**
   **Endpoint:** `GET /movies`
   **Response:** 
   ```json
   [
       { "id": "1", "title": "Inception", "director": "Christopher Nolan", "year": 2010 },
       { "id": "2", "title": "Interstellar", "director": "Christopher Nolan", "year": 2014 }
   ]
   ```

### **2. Add a New Movie**
   **Endpoint:** `POST /movies`
   **Request Body:**
   ```json
   {
       "id": "3",
       "title": "The Matrix",
       "director": "Lana Wachowski, Lilly Wachowski",
       "year": 1999
   }
   ```
   **Response:**
  
   { "message": "Movie added successfully!" }

   **Error Handling:**
   - If the movie ID already exists, return `400 Bad Request` with an error message.

### **3. Get Movie by ID**
   **Endpoint:** `GET /movies/{id}`
   **Response:**
   ```json
   { "id": "1", "title": "Inception", "director": "Christopher Nolan", "year": 2010 }
   ```
   **Error Handling:**
   - If the movie ID does not exist, return `404 Not Found` with an error message.

## **Error Handling**
- **Duplicate ID Error:** If a movie with the same ID is added, the API will return a `400 Bad Request` error.
- **Movie Not Found:** If a user tries to fetch a non-existent movie, the API will return a `404 Not Found` error.
- **Invalid Requests:** Improperly formatted JSON or missing required fields will result in a `400 Bad Request` error.

## **Future Enhancements**
- Implement a proper database for persistent storage.
- Add user authentication and authorization.
- Enable movie booking functionality.
- Include filtering and sorting options for movies.




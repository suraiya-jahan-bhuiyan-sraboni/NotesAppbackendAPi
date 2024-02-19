# Use the official OpenJDK base image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged jar file into the container
COPY build/libs/NotesApi-0.0.1-SNAPSHOT.jar /app/notes-api.jar

# Expose the port that your application runs on
EXPOSE 8080

# Run the jar file
CMD ["java", "-jar", "notes-api.jar"]


# Use OpenJDK base image
FROM eclipse-temurin:21-jdk

# Install Maven
RUN apt-get update && apt-get install -y maven

# Set the working directory
WORKDIR /app

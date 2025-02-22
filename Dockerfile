# Use OpenJDK base image
FROM openjdk:23-jdk-slim

# Install Maven
RUN apt-get update && \
    apt-get install -y maven

# Set the working directory
WORKDIR /app

# Copy the project files into the container
COPY . /app

# Run Maven clean install (if needed)
RUN mvn clean install

EXPOSE 8008

# Command to run the app
CMD ["mvn", "spring-boot:run"]
# Use Maven with Java 18 (or the version you're using) as a builder
FROM maven:3.8.7-openjdk-18-slim AS builder

WORKDIR /app

# Copy only the pom.xml first to leverage Docker layer caching for Maven dependencies
COPY pom.xml .

# Download project dependencies to cache them in a Docker layer
RUN mvn dependency:go-offline -B

# Now, copy the source code and build the project
COPY src ./src
RUN mvn clean package -DskipTests

# Use Java 18 (or the version you're using) for the runtime
FROM openjdk:18-jdk-slim

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Copy the application-docker.yml configuration into the image
COPY --from=builder /app/src/main/resources/application-docker.yml /config/application-docker.yml

EXPOSE 8182

# Adjust the ENTRYPOINT to use the Docker profile and point to the config
ENTRYPOINT ["java", "-jar", "/app.jar", "--spring.profiles.active=docker", "--spring.config.location=file:/config/"]

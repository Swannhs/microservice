FROM maven:3.8.7-openjdk-18-slim AS builder

WORKDIR /app

# Copy only the pom.xml and download dependencies first.
# This will be cached until the pom.xml changes.
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Now copy the rest of the project and build.
COPY src ./src
RUN mvn clean package -DskipTests

# Use Java 18 for the runtime
FROM openjdk:18-jdk-slim

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "/app.jar"]

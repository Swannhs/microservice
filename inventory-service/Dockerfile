# Use Maven with Java 18 as a base image
FROM maven:3.8.7-openjdk-18-slim

WORKDIR /app

# Expose the port
EXPOSE 8183

# Command to run the application using Spring Boot Maven plugin with specific configuration
CMD ["mvn", "spring-boot:run", "-Dspring.config.location=classpath:/,file:/app/src/main/resources/application-docker.yml"]

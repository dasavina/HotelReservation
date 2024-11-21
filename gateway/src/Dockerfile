# Use an official Maven image as the base image for the build stage
FROM maven:3.9.9-amazoncorretto-21 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file to the container
COPY pom.xml .

# Copy the source code to the container
COPY src ./src

# Build the application using Maven, skipping tests
RUN mvn clean package -DskipTests

# Use an official Amazon Corretto image as the base image for the runtime
FROM amazoncorretto:21

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/api-gateway-0.0.1.jar .

# Set the command to run the API Gateway application
CMD ["java", "-jar", "api-gateway-0.0.1.jar"]

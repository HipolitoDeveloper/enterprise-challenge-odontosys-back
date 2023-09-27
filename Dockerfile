# Use the official maven/Java 8 image to create a build-time image
FROM maven:3.6-jdk-11 AS build
WORKDIR /app
# Copy the pom.xml and src code to the container
COPY . .
# Package the application
RUN mvn package -DskipTests

# Use OpenJDK for runtime
FROM openjdk:11-jre-slim
# Set the working directory inside the container
WORKDIR /app
# Copy the jar to the production image from the builder stage.
COPY --from=build /app/target/EstudandoJAVA-0.0.1-SNAPSHOT.jar /app/EstudandoJAVA-0.0.1-SNAPSHOT.jar

# Command to run the application
CMD ["java", "-jar", "/app/EstudandoJAVA-0.0.1-SNAPSHOT.jar"]
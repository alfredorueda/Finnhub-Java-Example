FROM maven:3.9.8-eclipse-temurin-22

# Set the working directory in the container
WORKDIR /opt/build

# Copy the pom.xml and download the dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code into the container
COPY src ./src

# Package the application (skip tests to speed up the build process)
RUN mvn clean package -Dmaven.test.skip=true

# Set the working directory in the container
WORKDIR /opt/build/target

# Command to run the application
ENTRYPOINT ["java", "-jar", "Finnhub_Java_Example-1.0-SNAPSHOT-jar-with-dependencies.jar"]

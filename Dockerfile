# Fetching latest version of Java
FROM openjdk:17-jdk-bullseye

RUN apt update && apt install maven -y

COPY . /app

# Setting up work directory
WORKDIR /app

RUN mvn clean install

# Copy the jar file into our app
#COPY ./target/bookCartz-0.0.1-SNAPSHOT.jar /app

# Exposing port 8001
EXPOSE 8080

# Starting the application
CMD ["java", "-jar", "bookCartz-0.0.1-SNAPSHOT.jar"]
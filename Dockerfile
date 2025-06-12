## Use OpenJDK as base image
#FROM openjdk:17-jdk-alpine
#
## Add a label
#LABEL maintainer="you@example.com"
#
## Create app directory
#WORKDIR /app
#
## Copy the Spring Boot JAR into the image
#COPY target/logcheck-0.0.1-SNAPSHOT.jar app.jar
#
## Expose port (change if your app uses a different port)
#EXPOSE 8080
#
## Run the app
#ENTRYPOINT ["java", "-jar", "app.jar"]

FROM openjdk:17-jdk-alpine
LABEL maintainer="you@example.com"
WORKDIR /app
COPY target/logcheck-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

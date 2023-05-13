FROM openjdk:17-jdk-slim

COPY target/argpro.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]


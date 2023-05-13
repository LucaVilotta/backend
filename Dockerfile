FROM amazoncorretto:17-alpine-jdk

COPY target/argpro.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

